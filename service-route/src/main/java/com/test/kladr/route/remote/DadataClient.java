package com.test.kladr.route.remote;

import com.test.kladr.route.model.Kladr;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "dadata-service")
public interface DadataClient {

	@GetMapping("/{codeKladr}")
	Kladr getKladrByCodeKladr(@PathVariable("codeKladr") Long codeKladr);
	
}
