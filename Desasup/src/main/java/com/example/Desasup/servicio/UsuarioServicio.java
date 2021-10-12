package com.example.Desasup.servicio;

import java.util.ArrayList;
import java.util.Optional;

import com.example.Desasup.modelo.UsuarioModelo;
import com.example.Desasup.repositorios.UsuarioRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio {
    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    public ArrayList<UsuarioModelo> obtenerUsuarios(){
        return (ArrayList<UsuarioModelo>) usuarioRepositorio.findAll();


    }

    public UsuarioModelo guardarUsuario(UsuarioModelo usuario){
        return usuarioRepositorio.save(usuario);
        
    }

    public Optional<UsuarioModelo> obtenerUsuarioPorId(Long id) {
        return usuarioRepositorio.findById(id);
    }

    public boolean eliminarUsuarioPorId (Long id){
        try {
            usuarioRepositorio.deleteById(id); 
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    
}
