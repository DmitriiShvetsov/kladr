package com.test.kladr.repository;

import com.test.kladr.model.Kladr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KladrRepository extends JpaRepository<Kladr, Long>{

    Kladr findByCodeKladr(Long codeKladr);

}
