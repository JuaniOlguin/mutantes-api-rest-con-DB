package com.example.mutantes.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "registroDna")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RegistroDna extends Base {
    @Column(name = "dna")
    private String[] dna;

    @Column(name = "isMutant")
    private boolean isMutant;
}
