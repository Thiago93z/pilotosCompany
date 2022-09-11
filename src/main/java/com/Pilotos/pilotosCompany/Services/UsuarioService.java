package com.Pilotos.pilotosCompany.Services;

import com.Pilotos.pilotosCompany.Model.Usuario;
import com.Pilotos.pilotosCompany.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;
  
    public void crearUsuario(Usuario usuario){
        usuariorepository.save(usuario);
    }
  
    public void editarUsuario(Usuario usuario){
      usuarioRepository.save(usuario);
    }

    public List<Usuario> verUsuario(){
        List<Usuario> usuarios= new ArrayList<Usuario>();
        usuarios.addAll(usuarioRepository.findAll());
        return usuarios;
    }
  
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
