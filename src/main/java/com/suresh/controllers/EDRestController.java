package com.suresh.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.suresh.bindings.CitizenData;
import com.suresh.bindings.PlanInfo;
import com.suresh.service.EDService;

@RestController
public class EDRestController {

	@Autowired
	private EDService service;

	@PostMapping
	public ResponseEntity<PlanInfo> getPlansData(@RequestBody CitizenData citizendata) {
		PlanInfo planInfo = service.getPlanInfo(citizendata);
		return new ResponseEntity<>(planInfo, HttpStatus.OK);
	}

}
