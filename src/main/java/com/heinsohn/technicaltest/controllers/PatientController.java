package com.heinsohn.technicaltest.controllers;


import com.heinsohn.technicaltest.dto.PatientDto;
import com.heinsohn.technicaltest.dto.Response;
import com.heinsohn.technicaltest.dto.ResponseFailureDto;
import com.heinsohn.technicaltest.dto.ResponseSuccessDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.heinsohn.technicaltest.services.PatientRegistryService;

import javax.validation.Valid;
import java.util.*;

@Slf4j
@RestController
@RequestMapping(value = "/api")
public class PatientController {

    private PatientRegistryService patientService;
    private final String NO_PATIENTS_FOUND = "No patients were found with the id :";
    private final String PATIENT_FOUND = "Patient was found!";

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
                log.debug("There was an error creating the patient with patient id: {}", patientDto.getPatientId());
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
            }

            return ResponseEntity.ok(response);
        }catch (Exception e){
            log.debug("There was an error creating the patient with patient id: {}", patientDto.getPatientId());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }

    }

    @GetMapping()
    public ResponseEntity<List<PatientDto>> getAllPatients(){

        List<PatientDto> patients = patientService.getPatients();
        if(patients.isEmpty()){
            log.debug("No patients were found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }
        return ResponseEntity.ok(patientService.getPatients());
    }

    @GetMapping(value = "/patients/{id}", produces= MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<? extends Response> getPatient(@PathVariable String id){
        PatientDto patientDto = patientService.getPatientsById(id);

        if(Objects.isNull(patientDto)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseFailureDto.builder()
                    .message(NO_PATIENTS_FOUND + id)
                    .build());
        }

        return ResponseEntity.ok(ResponseSuccessDto.builder()
                .message(PATIENT_FOUND)
                .patientDto(patientDto)
                .build());
    }


}
