package com.example.mutantes.services;

import com.example.mutantes.entities.Base;

import java.io.Serializable;
import java.util.List;

public interface BaseService<E extends Base, ID extends Serializable> {
    public List<E> findAll() throws Exception; //trae lista de todas las entidades E de la db
    public E findById(ID id) throws Exception; //obtener persona de acuerdo al id
    public E save(E entity) throws Exception; //crear una entidad con el parametro
    public E update(ID id, E entity) throws Exception; //para actualizar con la entidad que llega por parametro
    public boolean delete(ID id) throws Exception; //borrar de la base de datos
}
