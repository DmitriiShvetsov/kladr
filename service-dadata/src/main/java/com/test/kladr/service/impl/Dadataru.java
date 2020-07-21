package com.test.kladr.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.test.kladr.model.Kladr;
import com.test.kladr.service.KladrServiceDadata;
import lombok.extern.slf4j.Slf4j;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;


@Slf4j
@Service
public class Dadataru extends RemoteDatabaseServiceImpl implements KladrServiceDadata {

    public Kladr getKladrByCodeKladr(Long codeKladr) {

        String response = null;

        var values = new HashMap<String, Long>() {{
            put("query", codeKladr);
        }};

        var objectMapper = new ObjectMapper();

        try {
            String requestBody = objectMapper
                    .writeValueAsString(values);

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(properties.getProperty("dadata.url")))
                    .header("Authorization", "Token " + properties.getProperty("dadata.token"))
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            HttpResponse<String> httpResponse = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            response = httpResponse.body();

        } catch (InterruptedException | IOException e) {
            log.error("Remote service dadata.ru error:", e);
        }

        ObjectMapper objectMapperResponce = new ObjectMapper();
        JsonNode jsonNode = null;

        Kladr kladr = null;
        try {
            jsonNode = objectMapperResponce.readTree(response);

            Long codeRegion = null;
            Long indexPost = null;
            Long codeOkato = null;
            Long codeTax = null;
            String address = null;

            JsonNode suggestionsNode = jsonNode.path("suggestions");

            if (suggestionsNode.isEmpty()) {
                return null;
            }

            JsonNode itemNode = suggestionsNode.get(0);

            address = itemNode.path("unrestricted_value").asText();
            codeRegion = Long.parseLong(itemNode.path("data").path("region_kladr_id").asText().substring(0, 1));
            indexPost = Long.parseLong(itemNode.path("data").path("postal_code").asText());
            codeOkato = Long.parseLong(itemNode.path("data").path("okato").asText());
            codeTax = Long.parseLong(itemNode.path("data").path("tax_office").asText());


            kladr = Kladr.builder()
                    .address(address)
                    .codeKladr(codeKladr)
                    .codeOkato(codeOkato)
                    .codeRegion(codeRegion)
                    .codeTax(codeTax)
                    .indexPost(indexPost)
                    .build();

        } catch (JsonProcessingException | NullPointerException ex) {
            log.error("Remote service dadata.ru parse error:", ex);
            return null;
        }

        return kladr;
    }
}