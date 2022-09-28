package com.Pilotos.pilotosCompany.Repository;

import com.Pilotos.pilotosCompany.Model.UserClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserClientRepository extends JpaRepository<UserClient, Long> {

    UserClient findByEmail(String email);

}

