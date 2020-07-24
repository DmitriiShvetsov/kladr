package com.test.kladr.dadata.controller;

import com.test.kladr.dadata.model.Kladr;
import com.test.kladr.dadata.service.KladrServiceDadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DadataController {

    private static final Logger logger = LoggerFactory.getLogger(DadataController.class);
    private String instanceId;
    private final KladrServiceDadata kladrServiceDadata;


    public DadataController(
            @Value("${spring.cloud.consul.discovery.instanceId}") String instanceId,
            KladrServiceDadata kladrServiceDadata
    ) {
        this.instanceId = instanceId;
        this.kladrServiceDadata = kladrServiceDadata;
    }

    @GetMapping(value = "/{codeKladr}")
    public ResponseEntity<Kladr>  getEntityByKladr(@PathVariable(name = "codeKladr") long codeKladr) {
        final Kladr kladr = kladrServiceDadata.getKladrByCodeKladr(codeKladr);

        logger.info(instanceId + " get codeKladr = " + codeKladr + "\t " + kladr);

        return ResponseEntity.ok(kladr);
    }

}
