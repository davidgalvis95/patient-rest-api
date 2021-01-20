package com.heinsohn.technicaltest.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

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
    @GeneratedValue( generator = "uuid2" )
    @GenericGenerator( name = "uuid2",
            strategy = "uuid2" )
    @Column( name = "id",
            nullable = false,
            updatable = false)
    @Type(type="uuid-char")
    private UUID Id;

    @Column( name = "patient_id")
    private String patientId;

    @Column( name = "first_name")
    private String firstName;

    @Column( name = "last_name")
    private String lastName;

    @Column( name = "email")
    private String email;

    @Column( name = "phone")
    private String phone;
}
