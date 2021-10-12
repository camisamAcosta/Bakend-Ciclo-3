package com.example.Desasup.controlador;

import java.util.ArrayList;
import java.util.Optional;

import com.example.Desasup.modelo.UsuarioModelo;
import com.example.Desasup.servicio.UsuarioServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping( path = "/{id}")
    public Optional<UsuarioModelo> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        return this.UsuarioServicio.obtenerUsuarioPorId(id);
    }

    @DeleteMapping( path = "/{id}")
    public ResponseEntity <?> eliminarPorId(@PathVariable("id") Long id) {
       if(!UsuarioServicio.obtenerUsuarioPorId(id).isPresent()){
        return ResponseEntity.notFound().build();

       }
        this.UsuarioServicio.eliminarUsuarioPorId(id);
        return ResponseEntity.ok().build();
        
    
    }

    //actualizar
    @PutMapping( path = "/{id}")
    public ResponseEntity<?> actualizar(@RequestBody UsuarioModelo nuevoUsuario, @PathVariable(value = "id") Long id) {
    Optional<UsuarioModelo> oUsuario = UsuarioServicio.obtenerUsuarioPorId(id);
    if (!oUsuario.isPresent()) {
    return ResponseEntity.notFound().build();
    }
    oUsuario.get().setNombre(nuevoUsuario.getNombre());
    oUsuario.get().setApellido(nuevoUsuario.getApellido());
    oUsuario.get().setTelefono(nuevoUsuario.getTelefono());
    oUsuario.get().setCorreo(nuevoUsuario.getCorreo());
    oUsuario.get().setEdad(nuevoUsuario.getEdad());
    return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioServicio.guardarUsuario(oUsuario.get()));
}
    

}

