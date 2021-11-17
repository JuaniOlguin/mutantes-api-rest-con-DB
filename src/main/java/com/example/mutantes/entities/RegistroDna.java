package com.example.mutantes.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "registroDna")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RegistroDna extends Base {
    @Column(name = "dna")
    private String[] dna;

    @Column(name = "isMutant")
    private boolean isMutant;
}
