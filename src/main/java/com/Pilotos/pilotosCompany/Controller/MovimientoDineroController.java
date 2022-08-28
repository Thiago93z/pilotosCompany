package com.Pilotos.pilotosCompany.Controller;


import com.proyecto.pilotos.primerproyecto.Modelo.MovimientoDinero;
import com.proyecto.pilotos.primerproyecto.Vista.MovimientoDineroView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MovimientoDineroController {
    
  
   @RequestMapping("/")
   public String MovimientoDinero (){
        return "movimientoDinero works!";
   }
  
  @Autowired
   private MovimientoDineroRepository repository;
   
  @PostMapping("/movimientoDinero")
  public movimientoDinero createMovimientoDinero(@RequestBody MovimientoDinero movimientoDinero){
          return repository.save(movimientoDinero);
  }

  @PutMapping ("/movimientoDinero/{id}")
  public movimientoDinero updateMovimientoDinero(@PathVariable int id,@RequestBody MovimientoDinero movimientoDinero){
       return repository.save(movimientoDinero);
  }

 @DeleteMapping("/movimientoDinero/{id}")
 public void deleteMovimientoDinero(@PathVariable ("id") Integer id){
    repository.deleteById(id);
}
}
