package com.heinsohn.technicaltest.services;

import com.heinsohn.technicaltest.domain.Patient;
import com.heinsohn.technicaltest.dto.PatientDto;
import com.heinsohn.technicaltest.dto.Response;
import com.heinsohn.technicaltest.dto.ResponseFailureDto;
import com.heinsohn.technicaltest.dto.ResponseSuccessDto;
import com.heinsohn.technicaltest.mapper.PatientMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.heinsohn.technicaltest.persistence.repositories.PatientRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PatientRegistryService {

    private PatientRepository patientRepository;
    private final PatientMapper mapper;
    private final String SUCCESS_MESSAGE = "The patient was successfully saved!";
    public static final String FAILURE_MESSAGE = "There was an error while processing the request...";

    @Autowired
    public PatientRegistryService(PatientRepository patientRepository, PatientMapper mapper) {
        this.patientRepository = patientRepository;
        this.mapper = mapper;
    }

    @Transactional
    public Response createPatient(PatientDto patientDto) {

        com.heinsohn.technicaltest.persistence.model.Patient savedPatient;

        if (Objects.nonNull(patientDto.getId())) {

            return ResponseFailureDto.builder()
                    .message(FAILURE_MESSAGE)
                    .build();

        }

        try {

            Patient patientDomain = mapper.patientDtoToPatient(patientDto);
            com.heinsohn.technicaltest.persistence.model.Patient patientModel = this.fromPatientDomainToModelTranslator(patientDomain);
            savedPatient = patientRepository.saveAndFlush(patientModel);

        } catch (Exception e) {

            return ResponseFailureDto.builder()
                    .message(FAILURE_MESSAGE)
                    .build();
        }

        patientDto.setId(savedPatient.getId());

        return ResponseSuccessDto.builder()
                .patientDto(patientDto)
                .message(SUCCESS_MESSAGE)
                .build();
    }

    private com.heinsohn.technicaltest.persistence.model.Patient fromPatientDomainToModelTranslator(Patient patientDomain) {

        com.heinsohn.technicaltest.persistence.model.Patient modelPatient = com.heinsohn.technicaltest.persistence.model.Patient.builder()
                .patientId(patientDomain.getPatientId())
                .firstName(patientDomain.getFirstName())
                .lastName(patientDomain.getLastName())
                .email(patientDomain.getEmail())
                .phone(patientDomain.getPhone())
                .build();

        return modelPatient;
    }

    private Patient fromPatientModelToDomainTranslator(com.heinsohn.technicaltest.persistence.model.Patient modelPatient) {

        Patient patient = Patient.builder()
                .id(modelPatient.getId())
                .patientId(modelPatient.getPatientId())
                .firstName(modelPatient.getFirstName())
                .lastName(modelPatient.getLastName())
                .email(modelPatient.getEmail())
                .phone(modelPatient.getPhone())
                .build();

        return patient;
    }

    public List<PatientDto> getPatients() {
        return patientRepository.findAll().stream().map(patient ->
                mapper.patientToPatientDto(fromPatientModelToDomainTranslator(patient))).collect(Collectors.toList());
    }

    @Transactional
    public PatientDto getPatientsById(String id) {
        return patientRepository.findById(UUID.fromString(id))
                .map(patient -> mapper.patientToPatientDto(fromPatientModelToDomainTranslator(patient)))
                .orElse(null);
    }
}
