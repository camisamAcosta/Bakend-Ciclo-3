package com.example.Desasup.controlador;

import java.util.ArrayList;

import com.example.Desasup.modelo.UsuarioModelo;
import com.example.Desasup.servicio.UsuarioServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioControlador {
    @Autowired
    UsuarioServicio UsuarioServicio;

    @GetMapping()
    public ArrayList<UsuarioModelo> obtenerUsuarios(){
        return UsuarioServicio.obtenerUsuarios();

    }

    @PostMapping()
    public UsuarioModelo guardarUsuario(@RequestBody UsuarioModelo usuario){
        return this.UsuarioServicio.guardarUsuario(usuario);
    }

}
