package com.example.mutantes.controllers;

import com.example.mutantes.entities.Stats;
import com.example.mutantes.services.StatsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/tpa/stats")
public class StatsController extends BaseControllerImpl<Stats, StatsServiceImpl>{
    @Autowired
    StatsServiceImpl statsService;

    @GetMapping("/calcular/")
    public ResponseEntity<?> calcularStats(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(statsService.calcularStats());
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error.Intente mas tarde.\"}"); //msj de error en JSON
        }
    }
}
