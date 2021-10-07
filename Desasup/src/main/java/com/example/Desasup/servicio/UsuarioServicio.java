package com.example.Desasup.servicio;

import java.util.ArrayList;

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

    
}
