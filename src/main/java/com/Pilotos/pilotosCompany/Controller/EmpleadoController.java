package com.Pilotos.pilotosCompany.Controller;

import com.Pilotos.pilotosCompany.Model.Empleado;
import com.Pilotos.pilotosCompany.Services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class EmpleadoController {
    @Autowired
    EmpleadoService empleadoService;

    @GetMapping("/empleado")
    private List<Empleado> verEmpleado(){
        return empleadoService.verEmpleado();
    }

    @PostMapping("/empleado")
    private void crearEmpleado(@RequestBody Empleado empleado){
        empleadoService.crearEmpleado(empleado);
    }

    @DeleteMapping("/empleado/{id}")
    private void eliminarEmpleado(@PathVariable("id") Long id){
        empleadoService.eliminarEmpleado(id);
    }

    @PutMapping("/editarempleado")
    private void editarEmpleado(@RequestBody Empleado empleado){
        empleadoService.editarEmpleado(empleado);
    }
}
