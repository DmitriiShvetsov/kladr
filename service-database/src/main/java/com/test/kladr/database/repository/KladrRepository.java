package com.test.kladr.database.repository;

import com.test.kladr.database.model.Kladr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KladrRepository extends JpaRepository<Kladr, Long>{

    Kladr findByCodeKladr(Long codeKladr);

}
