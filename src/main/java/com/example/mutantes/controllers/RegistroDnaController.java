package com.example.mutantes.controllers;

import com.example.mutantes.entities.RegistroDna;
import com.example.mutantes.services.RegistroDnaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*") //permitir el acceso a la api desde distintos clientes
@RequestMapping(path = "api/tpa") //la uri que necesitamos para acceder a los recursos, personas es el recurso en este caso
public class RegistroDnaController extends BaseControllerImpl<RegistroDna, RegistroDnaServiceImpl>{
    @Autowired
    RegistroDnaServiceImpl registroDnaService;

    @PostMapping("/mutant/")
    public ResponseEntity<?> detect(@RequestBody RegistroDna registroDna){
        try{
            if(registroDnaService.isMutant(registroDna)){
                return ResponseEntity.status(HttpStatus.OK).body("{\"mutant\":\"Mutante encontrado.\"}");
            }else{
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"mutant\":\"Mutante no encontrado.\"}");
            }
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error.Intente mas tarde.\"}"); //msj de error en JSON
        }
    }
}

