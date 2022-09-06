package com.Pilotos.pilotosCompany.Controller;

import com.Pilotos.pilotosCompany.Model.Empresa;
import com.Pilotos.pilotosCompany.services.ServiceEmpresa;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Api (tags = "Empresa", description = "Metodos para el Api Empresa")
@RestController
@RequestMapping (value = "/empresa/api")

public class ControllerEmpresa {


    @Autowired
    ServiceEmpresa serviceEmpresa;






    @GetMapping (path = "/listarEmpresa", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Empresa> listaEmpresa (){
        return serviceEmpresa.listar();
   }

    @GetMapping (path = "/buscarEmpresa/{idEmpresa}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Empresa> buscarEmpresa (@PathVariable Long idEmpresa){
        Empresa currentEmpresa = serviceEmpresa.buscarEmpresa(idEmpresa);
        if ( currentEmpresa != null){
            return new ResponseEntity<Empresa>(currentEmpresa, HttpStatus.OK);
        }else{
            return new ResponseEntity("Error de Ejecución ", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping (path = "/crearEmpresa", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity <Empresa> crearEmpresa (@RequestBody Empresa empresa){

       boolean salida = serviceEmpresa.addEmpresa(empresa);


       if(salida == true){

           return new ResponseEntity<Empresa>(empresa, HttpStatus.OK);

       }else {

           return new ResponseEntity("Error de Ejecuión ", HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }





    @PutMapping ( path = "/actualizarEmpresa", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Empresa> actualizarEmpresa(@RequestParam Long idEmpresa, @RequestParam String nombreModificado){

        Empresa currentEmpresa = serviceEmpresa.buscarEmpresa(idEmpresa);
        currentEmpresa.setNombre(nombreModificado);
        System.out.println("Method PUT");

       return new ResponseEntity<Empresa>(currentEmpresa, HttpStatus.OK);

    }


    @DeleteMapping (path = "/borrarEmpresa/{idEmpresa}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Boolean> eliminarEmpresa (@PathVariable Long idEmpresa){

        Empresa currentEmpresa = serviceEmpresa.buscarEmpresa(idEmpresa);

        Boolean salida = serviceEmpresa.eliminarEmpresa(currentEmpresa);

       return new ResponseEntity<Boolean>(salida, HttpStatus.OK);

    }



}
