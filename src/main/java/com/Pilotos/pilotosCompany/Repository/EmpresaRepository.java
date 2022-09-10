package com.Pilotos.pilotosCompany.Repository;

import com.Pilotos.pilotosCompany.Model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
