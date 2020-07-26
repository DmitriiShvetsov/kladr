package com.test.kladr.database.controller;

import com.test.kladr.database.model.Kladr;
import com.test.kladr.database.service.KladrServiceDatabase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/database")
public class ControllerDatabase {

    private static final Logger logger = LoggerFactory.getLogger(ControllerDatabase.class);
    private String instanceId;
    private final KladrServiceDatabase kladrServiceDatabase;


    public ControllerDatabase(@Value(
            "${spring.cloud.consul.discovery.instanceId}") String instanceId,
                              KladrServiceDatabase kladrServiceDatabase
    ) {
        this.instanceId = instanceId;
        this.kladrServiceDatabase = kladrServiceDatabase;
    }

    @GetMapping(value = "/{codeKladr}")
    public Kladr read(@PathVariable(name = "codeKladr") long codeKladr) {
        final Kladr kladr = kladrServiceDatabase.getKladrByCodeKladr(codeKladr);
        logger.info(instanceId + " get codeKladr = " + codeKladr + "\t " + kladr);

        return kladr ;
    }

}



