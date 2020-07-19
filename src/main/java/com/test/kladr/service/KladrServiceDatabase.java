package com.test.kladr.service;

import com.test.kladr.model.Kladr;

import java.util.List;

public interface KladrServiceDatabase {

    List<Kladr> findAll();

    Kladr getKladrByCodeKladr(Long id);

}
