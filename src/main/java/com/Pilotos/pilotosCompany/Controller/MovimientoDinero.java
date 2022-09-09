package com.Pilotos.pilotosCompany.Controller;

import com.Pilotos.pilotosCompany.Model.MovimientoDinero;
import com.Pilotos.pilotosCompany.Services.MovimientoDineroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;

@RestController
public class MovimientoDineroController {
    @Autowired
    MovimientoDineroService movimientoDineroService;

    @GetMapping({"/MovimientoDinero","/verMovimientoDinero"})
    public  String viewMovimientoDinero(Model model){
        List<MovimientoDinero> listaMovimientoDinero = movimientoDineroServ.getAllMovimientoDinero();
        model.addAttribute("movimientoDineroList", listaMovimientoDinero);
        return "verMovimientoDinero";
    }
}
