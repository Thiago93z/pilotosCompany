package com.Pilotos.pilotosCompany.Controller;

import com.Pilotos.pilotosCompany.Enums.Enum_Rol;
import com.Pilotos.pilotosCompany.Model.Empleado;
import com.Pilotos.pilotosCompany.Model.Empresa;
import com.Pilotos.pilotosCompany.Model.UserClient;
import com.Pilotos.pilotosCompany.Services.EmpleadoService;
import com.Pilotos.pilotosCompany.Services.EmpresaService;
import com.Pilotos.pilotosCompany.Services.UserClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class EmpleadoController {
    @Autowired
    EmpleadoService empleadoService;

    @Autowired
    EmpresaService empresaService;
    @Autowired
    UserClientService userClientService;
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
    private String crearEmpleado(Empleado empleado,@AuthenticationPrincipal OidcUser principal, Model model){
        UserClient userClient = this.userClientService.getOrCreateUser(principal.getClaims());
        if(userClient.getRol()!= Enum_Rol.valueOf("VISITANTE")) {
            List<Empresa> listaEmpresa = empresaService.verEmpresa();
            model.addAttribute("empresaList", listaEmpresa);
            return "crear-empleado";
        }

        return "redirect:/empleado";
    }

    @PostMapping("/empleado")
    private String crear(Empleado empleado,@AuthenticationPrincipal OidcUser principal){
        UserClient userClient = this.userClientService.getOrCreateUser(principal.getClaims());
        if(userClient.getRol()!= Enum_Rol.valueOf("VISITANTE"))
        empleadoService.crearEmpleado(empleado);
        return "redirect:/empleado";
    }

    @GetMapping("empleado/eliminar/{id}")
    private String eliminarEmpleado(@PathVariable("id") Long id,@AuthenticationPrincipal OidcUser principal){
        UserClient userClient = this.userClientService.getOrCreateUser(principal.getClaims());
        if(userClient.getRol()== Enum_Rol.valueOf("ADMIN"))
        empleadoService.eliminarEmpleado(id);
        return "redirect:/empleado";
    }


    @GetMapping("/empleado/editar/{id}")
    private String verEmpleadoPorId(@PathVariable("id") Long id, Model model, @AuthenticationPrincipal OidcUser principal){
        UserClient userClient = this.userClientService.getOrCreateUser(principal.getClaims());
        if(userClient.getRol()== Enum_Rol.valueOf("ADMIN")) {
            Empleado empleado = empleadoService.verEmpleadoPorId(id);
            model.addAttribute("empleado", empleado);
            return "actualizar-empleado";
        }
        return "redirect:/empleado";
    }

    @PostMapping("/empleado/actualizar/{id}")
    private String editarEmpleado(@PathVariable("id") Long id, Empleado empleado, @AuthenticationPrincipal OidcUser principal){
        UserClient userClient = this.userClientService.getOrCreateUser(principal.getClaims());
        if(userClient.getRol()== Enum_Rol.valueOf("ADMIN"))
        empleadoService.editarEmpleado(empleado);
        return "redirect:/empleado";
    }
}
