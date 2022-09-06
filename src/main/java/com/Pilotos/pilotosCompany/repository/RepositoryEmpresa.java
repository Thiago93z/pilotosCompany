package com.Pilotos.pilotosCompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryEmpresa extends JpaRepository <EntityEmpresa, Long> {




}
