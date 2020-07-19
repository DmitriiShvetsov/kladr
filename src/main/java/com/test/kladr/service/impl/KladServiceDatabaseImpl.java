package com.test.kladr.service.impl;

import com.test.kladr.model.Kladr;
import com.test.kladr.repository.KladrRepository;
import com.test.kladr.service.KladrServiceDatabase;
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
    public List<Kladr> findAll() {
        return kladrRepository.findAll();
    }

    @Override
    public Kladr getKladrByCodeKladr(Long codeKladr) {
        return kladrRepository.findByCodeKladr(codeKladr);
    }
}
