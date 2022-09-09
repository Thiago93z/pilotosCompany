package com.Pilotos.pilotosCompany.Repository;

import com.Pilotos.pilotosCompany.Model.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoDineroRepository extends JpaRepository<MovimientoDinero, Integer> {
}
