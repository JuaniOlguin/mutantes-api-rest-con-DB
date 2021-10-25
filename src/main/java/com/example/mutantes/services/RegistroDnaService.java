package com.example.mutantes.services;

import com.example.mutantes.entities.RegistroDna;

public interface RegistroDnaService extends BaseService<RegistroDna, Long>{
    public boolean isMutant(RegistroDna dna) throws Exception;
}
