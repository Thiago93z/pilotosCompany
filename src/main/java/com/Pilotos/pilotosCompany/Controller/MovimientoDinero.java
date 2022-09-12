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

    @GetMapping({"/","/verMovimientoDinero"})
    public  String viewMovimientoDinero(Model model, @ModelAttribute("mensaje") String mensaje){
        List<MovimientoDinero> listaMovimientoDinero = movimientoDineroServ.getAllMovimientoDinero();
        model.addAttribute("movimientoDineroList", listaMovimientoDinero);
        return "verMovimientoDinero";
    }
    
     @GetMapping({"/AgregarMovimientoDinero"})
    public  String AddMovimientoDinero(Model model){
        MovimientoDinero movDin = new MovimientoDinero();
        model.addAttribute("movDin", movDin);
        return "agregarMovimientoDinero"; 
    }
    
       @PostMapping({"/GuardarMovimientoDinero"})//servicio
    public  String SaveMovimientoDinero(MovimientoDinero movimientoDinero, RedirectAttributes redirectAttributes) {
        if(movimientoDineroService.actualizarMovimientoDinero(movimientoDinero)==true){
            redirectAttributes.addFlashAttribute("mensaje","saveOK");
            return "redirect:/VerMovimientoDinero";
            //redireccionamiento se hace a aservicios
        }
        redirectAttributes.addFlashAttribute("mensaje","saveError");
        return "redirect:/AgregarMovimientoDinero";
    }
      @PostMapping("/ActualizarMovimientoDinero")
    public String updateMovimientoDinero(@ModelAttribute("movimientoDinero") MovimientoDinero movimientoDinero, RedirectAttributes redirectAttributes){
        if(movimientoDineroService.actualizarMovimientoDinero(movimientoDinero)){
            redirectAttributes.addFlashAttribute("mensaje","updateOK");
            return "redirect:/VerMovimientoDinero";
        }
        redirectAttributes.addFlashAttribute("mensaje","updateError");
        return "redirect:/EditarMovimientoDinero/"+ movimientoDinero.getId();

    }
    @GetMapping("/EditarMovimientoDinero/{id}")
    public String editarMovimientoDinero(Model model, @PathVariable Integer id, @ModelAttribute("mensaje") String mensaje){
        MovimientoDinero movimientoDinero = movimientoDineroService.getMovimientoDinero(id);
        model.addAttribute("MovimientoDinero", movimientoDinero);
        model.addAttribute("mensaje", mensaje);
        return "editarEmpresa";
    }

    @GetMapping("/EliminarMovimientoDinero/{id}")
    public String eliminarMovimientoDinero(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        if (movimientoDineroService.eliminarMovimientoDinero(id)==true){
            redirectAttributes.addFlashAttribute("mensaje","deleteOK");
            return "redirect:/VerMovimientoDinero";
        }
        redirectAttributes.addFlashAttribute("mensaje", "deleteError");
        return "redirect:/VerMovimientoDinero";
    }
}
