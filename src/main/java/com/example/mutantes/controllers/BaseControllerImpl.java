package com.example.mutantes.controllers;

import com.example.mutantes.entities.Base;
import com.example.mutantes.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public abstract class BaseControllerImpl<E extends Base, S extends BaseServiceImpl<E, Long>> implements BaseController<E, Long> {
    @Autowired
    protected S servicio;

    //brinda la respuesta en formato JSON para la app web
    @GetMapping("") //esta notacion define el tipo de request, GET en este caso
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findAll()); //contiene el status de la respuesta (codigos 400, etc)
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}"); //msj de error en JSON
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findById(id)); //contiene el status de la respuesta (codigos 400, etc)
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}"); //msj de error en JSON
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody E entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.save(entity)); //contiene el status de la respuesta (codigos 400, etc)
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}"); //msj de error en JSON
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody E entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.update(id, entity)); //contiene el status de la respuesta (codigos 400, etc)
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}"); //msj de error en JSON
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(servicio.delete(id)); //contiene el status de la respuesta (codigos 400, etc)
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}"); //msj de error en JSON
        }
    }
}
