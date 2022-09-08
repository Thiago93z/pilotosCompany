package com.Pilotos.pilotosCompany.Controller;

import com.Pilotos.pilotosCompany.Model.Empresa;
import com.Pilotos.pilotosCompany.Services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpresaController {
    @Autowired
    EmpresaService empresaService;

    @GetMapping("/empresa")
    private List<Empresa> verEmpresa(){
        return empresaService.verEmpresa();
    }

    @PostMapping("/empresa")
    private void crearEmpresa(@RequestBody Empresa empresa){
        empresaService.crearEmpresa(empresa);
    }

    @DeleteMapping("/empresa/{id}")
    private void eliminarEmpresa(@PathVariable("id") Long id){
        empresaService.eliminarEmpresa(id);
    }

    @PutMapping("/editarempresa")
    private void editarEmpresa(@RequestBody Empresa empresa){
        empresaService.editarEmpresa(empresa);
    }
}
