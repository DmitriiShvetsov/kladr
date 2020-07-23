package com.test.kladr.route.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class RouteController {

    private RestTemplate restTemplate;

    private boolean goToDatabase = true;
    private final String urlDadata = "http://service-dadata/";
    private final String urlDatabase = "http://service-database/";

    public RouteController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping(value = "/{codeKladr}")
    public ResponseEntity<String> goDadata(@PathVariable(name = "codeKladr") long codeKladr) {
        String url;
        if (goToDatabase) {
            url = urlDatabase;
        } else {
            url = urlDadata;
        }

        ResponseEntity<String> responseEntity =
                restTemplate.getForEntity(url + codeKladr, String.class);
        String response = responseEntity.getBody();

        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/change_to_database")
    public void changeToDatabase() {
        goToDatabase = true;
    }

    @GetMapping(value = "/change_to_dadata")
    public void changeToDadata() {
        goToDatabase = false;
    }

}
