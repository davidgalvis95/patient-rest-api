package com.heinsohn.technicaltest.services;

import com.heinsohn.technicaltest.domain.Patient;
import com.heinsohn.technicaltest.dto.PatientDto;
import com.heinsohn.technicaltest.dto.Response;
import com.heinsohn.technicaltest.dto.ResponseFailureDto;
import com.heinsohn.technicaltest.dto.ResponseSuccessDto;
import com.heinsohn.technicaltest.mapper.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.heinsohn.technicaltest.persistence.repositories.PatientRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

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

            return  ResponseFailureDto.builder()
                    .message(FAILURE_MESSAGE)
                    .build();

        }

        try{

            Patient patientDomain = mapper.patientDtoToPatient(patientDto);
            com.heinsohn.technicaltest.persistence.model.Patient patientModel = this.fromPatientDomainToModelTranslator(patientDomain);
            savedPatient = patientRepository.saveAndFlush(patientModel);

        }catch (Exception e){

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
}
