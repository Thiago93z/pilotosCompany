package com.Pilotos.pilotosCompany.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @RequestMapping("/")
    public String Usuario(){
        return "Clase Usuario!";
    }


}
