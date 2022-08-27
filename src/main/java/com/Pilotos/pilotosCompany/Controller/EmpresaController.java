package com.Pilotos.pilotosCompany.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpresaController {

    @RequestMapping("/")
    public String Empresa(){
        return "Empresa works!";
    }


}
