package com.test.kladr.database.controller;

import com.test.kladr.database.model.Kladr;
import com.test.kladr.database.service.KladrServiceDatabase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger logger = LoggerFactory.getLogger(KladrControllerDatabase.class);

    @Autowired
    public KladrControllerDatabase(KladrServiceDatabase kladrServiceDatabase) {
        this.kladrServiceDatabase = kladrServiceDatabase;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Kladr>> getAll() {
        final List<Kladr> kladrs = kladrServiceDatabase.findAll();

        return !kladrs.isEmpty()
                ? new ResponseEntity<>(kladrs, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/{codeKladr}")
    public Kladr read(@PathVariable(name = "codeKladr") long codeKladr) {
        final Kladr kladr = kladrServiceDatabase.getKladrByCodeKladr(codeKladr);
        logger.info("get codeKladr = "+codeKladr);

        return kladr ;
    }

}
