package com.Pilotos.pilotosCompany.Controller;

import com.Pilotos.pilotosCompany.Model.Empresa;
import com.Pilotos.pilotosCompany.Services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping (value = "/empresa")
public class EmpresaController {
    @Autowired
    EmpresaService empresaService;

    @GetMapping("")
    private List<Empresa> verEmpresa(){
        return empresaService.verEmpresa();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Empresa> verEmpresaById(@PathVariable(value = "id") Long id){

        Empresa currentEmpresa = empresaService.verEmpresaById(id);
        if(currentEmpresa!=null){
            return new ResponseEntity<Empresa>(currentEmpresa, HttpStatus.OK);
        }else {
            return new ResponseEntity("Error en Controller", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    private Optional<Empresa> verEmpresaPorId(@PathVariable(value = "id") Long id){
        Optional<Empresa> currentEmpresa = empresaService.verEmpresaPorId(id);
        return currentEmpresa;
    }



    @PostMapping("")
    private void crearEmpresa (@RequestBody Empresa empresa){
        empresaService.crearEmpresa(empresa);
    }

    @DeleteMapping("/{id}")
    private void eliminarEmpresa(@PathVariable("id") Long id){
        empresaService.eliminarEmpresa(id);
    }

    @PutMapping("/editarempresa")
    private void editarEmpresa(@RequestBody Empresa empresa){
        empresaService.editarEmpresa(empresa);
    }
}
