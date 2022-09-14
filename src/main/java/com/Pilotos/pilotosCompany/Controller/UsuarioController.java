package com.Pilotos.pilotosCompany.Controller;

import com.Pilotos.pilotosCompany.Model.Usuario;
import com.Pilotos.pilotosCompany.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;
    
    @GetMapping("/usuario")
    private List<Usuario> verUsuario() {
        return usuarioService.verUsuario();
    }
    
    @PostMapping("/usuario")
    private void crearUsuario(@RequestBody Usuario usuario){
        usuarioService.crearUsuario(usuario);
    }
    
    @PutMapping("/editarUsuario")
    private void editarUsuario(@RequestBody Usuario usuario){
        usuarioService.editarUsuario(usuario);
    }
    
    @DeleteMapping("/usuario/{id}")
    private void eliminarUsuario(@PathVariable("id") Long id){
        usuarioService.eliminarUsuario(id);
    }
}
