package com.example.mutantes.repositories;

import com.example.mutantes.entities.RegistroDna;
import com.example.mutantes.entities.Stats;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatsRepository extends BaseRepository<Stats, Long>{
    @Query(
        value = "select count(*) from registro_dna where is_mutant = true",
        nativeQuery = true
    )
    Integer searchMutants();
    @Query(
        value = "select count(*) from registro_dna where is_mutant = false",
        nativeQuery = true
    )
    Integer searchNonMutants();
}
