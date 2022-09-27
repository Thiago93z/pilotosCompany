package com.Pilotos.pilotosCompany.Controller;

import com.Pilotos.pilotosCompany.Model.Empleado;
import com.Pilotos.pilotosCompany.Model.Empresa;
import com.Pilotos.pilotosCompany.Services.EmpleadoService;
import com.Pilotos.pilotosCompany.Services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class EmpleadoController {
    @Autowired
    EmpleadoService empleadoService;

//    @GetMapping("verempresa")
//    private List<Empresa> verEmpresa(){
//        return empresaService.verEmpresa();
//    }

    @GetMapping("/empleado")
    private String verEmpleado(Model model){
        model.addAttribute("empleado", empleadoService.verEmpleado());
        return "empleado";
    }

    @GetMapping("/crear-empleado")
    private String crearEmpleado(Empleado empleado){
        return "crear-empleado";
    }

    @PostMapping("/empleado")
    private String crear(Empleado empleado){
        empleadoService.crearEmpleado(empleado);
        return "redirect:/empleado";
    }

    @GetMapping("empleado/eliminar/{id}")
    private String eliminarEmpleado(@PathVariable("id") Long id){
        empleadoService.eliminarEmpleado(id);
        return "redirect:/empleado";
    }


    @GetMapping("/empleado/editar/{id}")
    private String verEmpleadoPorId(@PathVariable("id") Long id, Model model){
        Empleado empleado = empleadoService.verEmpleadoPorId(id);
        model.addAttribute("empleado", empleado);
        return "actualizar-empleado";
    }

    @PostMapping("/empleado/actualizar/{id}")
    private String editarEmpleado(@PathVariable("id") Long id, Empleado empleado){
        empleadoService.editarEmpleado(empleado);
        return "redirect:/empresa";
    }
}
