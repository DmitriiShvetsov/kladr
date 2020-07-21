package com.test.kladr.route.controller;


import com.test.kladr.route.model.Kladr;
import com.test.kladr.route.remote.DadataClient;
import com.test.kladr.route.remote.DatabaseClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class RouteController {

	private boolean goToDatabase = true;
	
	@Autowired
	DadataClient dadataClient;
	@Autowired
	DatabaseClient databaseClient;

	@GetMapping(value = "/{codeKladr}")
	public Kladr read(@PathVariable(name = "codeKladr") long codeKladr) {

		if (goToDatabase){
			return databaseClient.getKladrByCodeKladr(codeKladr);
		}else {
			return dadataClient.getKladrByCodeKladr(codeKladr);
		}
	}

	@GetMapping(value = "/change_to_database")
	public void changeToDatabase() {
		goToDatabase = true;
	}

	@GetMapping(value = "/change_to_dadata")
	public void changeToDadata() {
		goToDatabase = false;
	}

}
