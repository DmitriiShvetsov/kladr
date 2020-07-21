package com.test.kladr.database;//package ru.experio.invoice.web;

import com.test.kladr.database.model.Kladr;
import com.test.kladr.database.repository.KladrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;

    private final KladrRepository kladrRepository;

    @Autowired
    public SetupDataLoader(KladrRepository kladrRepository) {
        this.kladrRepository = kladrRepository;
    }


    @Override
    @Transactional
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        if (alreadySetup) {
            return;
        }

        final Kladr kladr1 = Kladr.builder()
                .indexPost(606400L)
                .codeTax(5248L)
                .codeRegion(52L)
                .codeOkato(22205555002L)
                .codeKladr(5200400005400L)
                .address("address1")
                .build();

        final Kladr kladr2 = Kladr.builder()
                .indexPost(606401L)
                .codeTax(5249L)
                .codeRegion(53L)
                .codeOkato(22205555003L)
                .codeKladr(5200400005401L)
                .address("address2")
                .build();


        createKladrIfNotFound(kladr1);
        createKladrIfNotFound(kladr2);

        alreadySetup = true;
    }

    @Transactional
    void createKladrIfNotFound(Kladr kladr) {
        Kladr repoKladr = kladrRepository.findByCodeKladr(kladr.getCodeKladr());
        if (repoKladr == null) {
            kladrRepository.save(kladr);
        }
    }


}