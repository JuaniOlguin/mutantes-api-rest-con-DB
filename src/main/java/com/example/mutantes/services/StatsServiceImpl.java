package com.example.mutantes.services;

import com.example.mutantes.entities.Stats;
import com.example.mutantes.repositories.BaseRepository;
import com.example.mutantes.repositories.StatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class StatsServiceImpl extends BaseServiceImpl<Stats, Long> implements StatsService {
    @Autowired
    private StatsRepository statsRepository;

    public StatsServiceImpl(BaseRepository<Stats, Long> baseRepository){
        super(baseRepository);
    }

    @Override
    @Transactional
    public Stats calcularStats() throws Exception{
        Stats stats = new Stats();
        stats.setMutantCount(statsRepository.searchMutants());
        stats.setNonMutantCount(statsRepository.searchNonMutants());
        if(stats.getNonMutantCount() > 0)stats.setMutantRatio(stats.getMutantCount()/stats.getNonMutantCount());
        stats.setStatsDate(LocalDateTime.now());
        statsRepository.save(stats);
        return stats;
    }
}
