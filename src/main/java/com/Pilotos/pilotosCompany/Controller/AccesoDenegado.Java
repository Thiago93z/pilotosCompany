package com.Pilotos.pilotosCompany.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

    @Controller
    public class AccesoDenegado {


//Controlador que me lleva al template de acceso No autorizado
    @RequestMapping(value="/Denegado")
    public String accesoDenegado(){
        return "accesoDenegado";
    }
     }
