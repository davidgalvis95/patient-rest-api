package com.heinsohn.technicaltest.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue( generator = "UUID" )
    @GenericGenerator( name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator" )
    @Column( name = "id",
            nullable = false )
    UUID Id;

    @Column( name = "patient_id")
    String patientId;

    @Column( name = "first_name")
    String firstName;

    @Column( name = "last_name")
    String lastName;

    @Column( name = "email")
    String email;

    @Column( name = "phone")
    String phone;
}
