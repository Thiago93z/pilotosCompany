package com.Pilotos.pilotosCompany.Repository;

import com.Pilotos.pilotosCompany.Model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
}
