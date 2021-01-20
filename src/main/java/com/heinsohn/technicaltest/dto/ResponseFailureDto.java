package com.heinsohn.technicaltest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class ResponseFailureDto implements Response{

    @JsonProperty("message")
    private String message;
}
