package com.Pilotos.pilotosCompany;

import com.Pilotos.pilotosCompany.Model.Empresa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PilotosCompanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(PilotosCompanyApplication.class, args);
		Empresa pilotos = new Empresa("Pilotos", "Armenia 123", 1234567, "989-998789" );
		System.out.println(pilotos.getNombre());
		pilotos.setNIT("4567890");
		System.out.println(pilotos.getNIT());
		pilotos.setDireccion("Av bolivar 15-58");
		System.out.println(pilotos.getDireccion());
	}

}
