package com.Pilotos.pilotosCompany.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpleadoComtroller {
    @RequestMapping("/")
    public String empleado(){
        return "Clase empleado";
    }

}
