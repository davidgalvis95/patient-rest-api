package com.heinsohn.technicaltest.mapper;

import com.heinsohn.technicaltest.domain.Patient;
import com.heinsohn.technicaltest.dto.PatientDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-19T23:54:25-0500",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.8 (Amazon.com Inc.)"
)
@Component
public class PatientMapperImpl implements PatientMapper {

    @Override
    public Patient patientDtoToPatient(PatientDto patientDto) {
        if ( patientDto == null ) {
            return null;
        }

        Patient patient = new Patient();

        patient.setId( patientDto.getId() );
        patient.setPatientId( patientDto.getPatientId() );
        patient.setFirstName( patientDto.getFirstName() );
        patient.setLastName( patientDto.getLastName() );
        patient.setEmail( patientDto.getEmail() );
        patient.setPhone( patientDto.getPhone() );

        return patient;
    }

    @Override
    public PatientDto patientToPatientDto(Patient patient) {
        if ( patient == null ) {
            return null;
        }

        PatientDto patientDto = new PatientDto();

        patientDto.setId( patient.getId() );
        patientDto.setPatientId( patient.getPatientId() );
        patientDto.setFirstName( patient.getFirstName() );
        patientDto.setLastName( patient.getLastName() );
        patientDto.setEmail( patient.getEmail() );
        patientDto.setPhone( patient.getPhone() );

        return patientDto;
    }
}
