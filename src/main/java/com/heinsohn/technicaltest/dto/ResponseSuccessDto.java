package com.heinsohn.technicaltest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class ResponseSuccessDto implements Response{

    @JsonProperty("message")
    String message;

    @JsonProperty("patientDto")
    PatientDto patientDto;
}
