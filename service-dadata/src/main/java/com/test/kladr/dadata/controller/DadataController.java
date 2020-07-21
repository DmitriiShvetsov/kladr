package com.test.kladr.dadata.controller;

import com.test.kladr.dadata.model.Kladr;
import com.test.kladr.dadata.service.KladrServiceDadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController()
public class DadataController {

    private final KladrServiceDadata kladrServiceDadata;

    @Autowired
    public DadataController(KladrServiceDadata kladrServiceDadata) {
        this.kladrServiceDadata = kladrServiceDadata;
    }

    @GetMapping(value = "/{codeKladr}")
    public ResponseEntity<Kladr> read(@PathVariable(name = "codeKladr") long codeKladr) {
        final Kladr kladr = kladrServiceDadata.getKladrByCodeKladr(codeKladr);

        return kladr != null
                ? new ResponseEntity<>(kladr, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
