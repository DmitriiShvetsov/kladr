package com.test.kladr.database.service.impl;

import com.test.kladr.database.model.Kladr;
import com.test.kladr.database.repository.KladrRepository;
import com.test.kladr.database.service.KladrServiceDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KladServiceDatabaseImpl implements KladrServiceDatabase {

    private final KladrRepository kladrRepository;

    @Autowired
    public KladServiceDatabaseImpl(KladrRepository kladrRepository) {
        this.kladrRepository = kladrRepository;
    }

    @Override
    public Kladr getKladrByCodeKladr(Long codeKladr) {
        return kladrRepository.findByCodeKladr(codeKladr);
    }
}
