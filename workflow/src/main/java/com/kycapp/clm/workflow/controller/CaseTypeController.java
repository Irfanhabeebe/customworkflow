package com.kycapp.clm.workflow.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.kycapp.clm.workflow.entity.CaseType;
import com.kycapp.clm.workflow.service.ICaseTypeService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@AllArgsConstructor
public class CaseTypeController {

    ICaseTypeService caseTypeService;

    @GetMapping("/get/{id}")
    public ResponseEntity<CaseType> getMethodName(@PathVariable int id) {
        return new ResponseEntity<>(caseTypeService.get(id),HttpStatus.OK);
    }
    
}
