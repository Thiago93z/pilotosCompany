package com.Pilotos.pilotosCompany.Controller;

import com.Pilotos.pilotosCompany.Model.Empresa;
import com.Pilotos.pilotosCompany.Services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EmpresaController {
    @Autowired
    EmpresaService empresaService;

//    @GetMapping("verempresa")
//    private List<Empresa> verEmpresa(){
//        return empresaService.verEmpresa();
//    }

    @GetMapping("/empresa")
    private String verEmpresa(Model model){
        model.addAttribute("empresas", empresaService.verEmpresa());
        return "empresa";
    }

    @GetMapping("/crear-empresa")
    private String crearEmpresa(Empresa empresa){
        return "crear-empresa";
    }

    @PostMapping("/empresa")
    private String crear(Empresa empresa){
        empresaService.crearEmpresa(empresa);
        return "redirect:/empresa";
    }

    @GetMapping("empresa/eliminar/{id}")
    private String eliminarEmpresa(@PathVariable("id") Long id){
        empresaService.eliminarEmpresa(id);
        return "redirect:/empresa";
    }


    @GetMapping("/empresa/editar/{id}")
    private String verEmpresaPorId(@PathVariable("id") Long id, Model model){
        Empresa empresa = empresaService.verEmpresaPorId(id);
        model.addAttribute("empresa", empresa);
        return "actualizar-empresa";
    }

    @PostMapping("/empresa/actualizar/{id}")
    private String editarEmpresa(@PathVariable("id") Long id, Empresa empresa){
        empresaService.editarEmpresa(empresa);
        return "redirect:/empresa";
    }


//    @GetMapping(path = "/empresa/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    private Optional<Empresa> verEmpresaPorId(@PathVariable(value = "id") Long id){
//        Optional<Empresa> currentEmpresa = empresaService.verEmpresaPorId(id);
//        return currentEmpresa;
//    }
//
//    @PostMapping("/empresa")
//    private void crearEmpresa (@RequestBody Empresa empresa){
//        empresaService.crearEmpresa(empresa);
//    }
//
//    @DeleteMapping("/empresa/{id}")
//    private void eliminarEmpresa(@PathVariable("id") Long id){
//        empresaService.eliminarEmpresa(id);
//    }
//
//    @PutMapping("/empresa/editarempresa")
//    private void editarEmpresa(@RequestBody Empresa empresa){
//        empresaService.editarEmpresa(empresa);
//    }
}
