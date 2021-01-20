package com.heinsohn.technicaltest.mapper;

import com.heinsohn.technicaltest.domain.Patient;
import com.heinsohn.technicaltest.dto.PatientDto;

import org.mapstruct.Mapper;

@Mapper
public interface PatientMapper {

    //TODO investigate why lombok is now working with mapstruct
    Patient patientDtoToPatient(PatientDto patientDto);
    PatientDto patientToPatientDto(Patient patient);

}
