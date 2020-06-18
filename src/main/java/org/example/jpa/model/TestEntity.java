package org.example.jpa.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class TestEntity extends AuditedModel {

    @Id
    @GeneratedValue
    private Long id;

    private String value;

}

