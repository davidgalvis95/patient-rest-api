package com.heinsohn.technicaltest.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.UUID;


public class PatientDto {

    private UUID id;

    @NotNull(message = "cannot be null")
    @Size(min = 0,max = 20, message = "must be shorter than 20 characters")
    @Pattern(regexp = "\\d+", message = "only numbers are accepted")
    private String patientId;

    @Size(min = 0,max = 255, message = "must be shorter than 255 characters")
    private String firstName;

    @Size(min = 0,max = 255, message = "must be shorter than 255 characters")
    private String lastName;

    @Email(message = "email must be a valid email")
    @Size(min = 0,max = 255, message = "must be shorter than 255 characters")
    private String email;

    @Size(min = 0,max = 20, message = "must be shorter than 20 characters")
    private String phone;

    public PatientDto(UUID id, @NotNull(message = "cannot be null") @Size(min = 0, max = 20, message = "must be shorter than 20 characters") String patientId, @Size(min = 0, max = 255, message = "must be shorter than 255 characters") String firstName, @Size(min = 0, max = 255, message = "must be shorter than 255 characters") String lastName, @Email(message = "email must be a valid email") @Size(min = 0, max = 255, message = "must be shorter than 255 characters") String email, @Size(min = 0, max = 20, message = "must be shorter than 20 characters") String phone) {
        this.id = id;
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public PatientDto(){}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
