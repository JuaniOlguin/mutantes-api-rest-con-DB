package com.example.mutantes.services;

import com.example.mutantes.entities.RegistroDna;
import com.example.mutantes.entities.Stats;
import com.example.mutantes.matriz.HintSearch;
import com.example.mutantes.matriz.MatrixCreator;
import com.example.mutantes.matriz.MutantDetector;
import com.example.mutantes.repositories.BaseRepository;
import com.example.mutantes.repositories.RegistroDnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistroDnaServiceImpl extends BaseServiceImpl<RegistroDna, Long> implements RegistroDnaService {
    @Autowired
    private RegistroDnaRepository registroDnaRepository;

    public RegistroDnaServiceImpl(BaseRepository<RegistroDna, Long> baseRepository){
        super(baseRepository);
    }

    public MatrixCreator matrixCreator = new MatrixCreator();
    public HintSearch mutantSearch = new HintSearch();
    public MutantDetector mutantDetector = new MutantDetector(mutantSearch);

    @Override
    @Transactional
    public boolean isMutant(RegistroDna dna) throws Exception {
        try{
            char [][] dnaMatriz = matrixCreator.hacerMatriz(dna.getDna());
            if(mutantDetector.isMutant(dnaMatriz)){
                registroDnaRepository.save(new RegistroDna(dna.getDna(), true));
                return true;
            } else {
                registroDnaRepository.save(new RegistroDna(dna.getDna(), false));
                return false;
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
