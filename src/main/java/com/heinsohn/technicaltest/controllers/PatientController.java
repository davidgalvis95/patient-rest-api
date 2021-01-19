package com.heinsohn.technicaltest.controllers;


import com.heinsohn.technicaltest.dto.PatientDto;
import com.heinsohn.technicaltest.dto.Response;
import com.heinsohn.technicaltest.dto.ResponseFailureDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.heinsohn.technicaltest.services.PatientRegistryService;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api")
public class PatientController {

    private PatientRegistryService patientService;

    @Autowired
    public PatientController(PatientRegistryService patientService){
        this.patientService=patientService;
    }

    @PostMapping(value = "/create", produces= MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<? extends Response> registerPatient(@Valid @RequestBody PatientDto patientDto) {

        Response response = null;

        try{
            response = patientService.createPatient(patientDto);

            if(response instanceof ResponseFailureDto){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
            }

            return ResponseEntity.ok(response);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }

    }

    @GetMapping(value = "/patients/{id}", produces= MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<? extends Response> getPatient(){
        return null;
    }
}
