package com.example.Desasup.repositorios;

import com.example.Desasup.modelo.UsuarioModelo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends CrudRepository<UsuarioModelo, Long>{

    
}
