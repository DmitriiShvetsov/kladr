package com.test.kladr.route.controller;

import com.test.kladr.route.model.Kladr;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/route")
public class RouteController {

    private RestTemplate restTemplate;

    private boolean goToDatabase = true;
    private final String urlDadata = "http://service-dadata/dadata/";
    private final String urlDatabase = "http://service-database/database/";

    public RouteController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping(value = "/{codeKladr}")
    public ResponseEntity<Kladr> goDadata(@PathVariable(name = "codeKladr") long codeKladr) {
        String url;
        if (goToDatabase) {
            url = urlDatabase;
        } else {
            url = urlDadata;
        }

        ResponseEntity<Kladr> responseEntity =
                restTemplate.getForEntity(url + codeKladr, Kladr.class);
        Kladr response = responseEntity.getBody();

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
