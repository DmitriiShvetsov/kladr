package com.test.kladr.database.service;

import com.test.kladr.database.model.Kladr;

import java.util.List;

public interface KladrServiceDatabase {

    List<Kladr> findAll();

    Kladr getKladrByCodeKladr(Long id);

}
