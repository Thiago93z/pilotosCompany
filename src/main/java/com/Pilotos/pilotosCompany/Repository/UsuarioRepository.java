package com.Pilotos.pilotosCompany.Repository;

import com.pilotos.pilotosCompany.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
