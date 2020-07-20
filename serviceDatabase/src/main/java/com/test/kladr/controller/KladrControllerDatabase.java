package com.test.kladr.controller;

import com.test.kladr.model.Kladr;
import com.test.kladr.service.KladrServiceDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController()
public class KladrControllerDatabase {

    private final KladrServiceDatabase kladrServiceDatabase;

    @Autowired
    public KladrControllerDatabase(KladrServiceDatabase kladrServiceDatabase) {
        this.kladrServiceDatabase = kladrServiceDatabase;
    }

    @GetMapping(value = "/database")
    public ResponseEntity<List<Kladr>> getAll() {
        final List<Kladr> kladrs = kladrServiceDatabase.findAll();

        return !kladrs.isEmpty()
                ? new ResponseEntity<>(kladrs, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/database/{codeKladr}")
    public ResponseEntity<Kladr> read(@PathVariable(name = "codeKladr") long codeKladr) {
        final Kladr kladr = kladrServiceDatabase.getKladrByCodeKladr(codeKladr);

        return kladr != null
                ? new ResponseEntity<>(kladr, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
