package com.finalcourseproject.fleetms.security.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Role extends Auditable<String> {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String id;

    private String description;
    private String details;
}


