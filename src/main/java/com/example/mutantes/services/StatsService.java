package com.example.mutantes.services;

import com.example.mutantes.entities.Stats;

public interface StatsService extends BaseService<Stats, Long>{
    public Stats calcularStats() throws Exception;
}
