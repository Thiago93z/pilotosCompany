package com.Pilotos.pilotosCompany.Controller;

import com.Pilotos.pilotosCompany.Entity.Empleado;
import com.Pilotos.pilotosCompany.repository.EntityEmpleado;
import com.Pilotos.pilotosCompany.services.ServiceEmpleado;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Api (tags = "Persona", description = "Metodos para el Api Persona")
@RestController
@RequestMapping (value = "/empleado")

public class ControllerEmpleado {


    @Autowired
    ServiceEmpleado serviceEmpleado;



    @ApiOperation( value = "Endpoint para listar empleado")
   @GetMapping (path = "/api/listar", produces = "application/json")
   public ResponseEntity <String> callServicePrograma(){

       Empleado empleadoNuevo = new Empleado();
       empleadoNuevo.setNombre("Carlos1");
       empleadoNuevo.setApellido("Romero22");
       empleadoNuevo.setEdad(34L);

       String salida = serviceEmpleado.inscribirEmpleado(empleadoNuevo);

       return new ResponseEntity<String>(salida, HttpStatus.NOT_FOUND);

    }


    @GetMapping (path = "/api/listaEmpleados", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<EntityEmpleado> listaEmpleados (){
        return serviceEmpleado.listar();
   }

    @GetMapping (path = "/api/buscarEmpleado/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EntityEmpleado> buscarEmpleado (@PathVariable Long id){
        EntityEmpleado p = serviceEmpleado.buscarEmpleado(id);
        if ( p != null){
            return new ResponseEntity<EntityEmpleado>(p, HttpStatus.OK);
        }else{
            return new ResponseEntity("Error de Ejecución ", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping (path = "/api/crearEmpleado", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity <EntityEmpleado> crearEmpleado (@RequestBody EntityEmpleado empleado){

       boolean salida = serviceEmpleado.addEmpleado(empleado);


       if(salida == true){

           return new ResponseEntity<EntityEmpleado>(empleado, HttpStatus.OK);

       }else {

           return new ResponseEntity("Error de Ejecuión ", HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }





    @PutMapping ( path = "/api/actualizarEmpleado", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <EntityEmpleado> actualizarEmpleado(@RequestParam Long id, @RequestParam String nombreModificado){

        EntityEmpleado p = serviceEmpleado.buscarEmpleado(id);
        p.setNombre(nombreModificado);
        System.out.println("Method PUT");

       return new ResponseEntity<EntityEmpleado>(p, HttpStatus.OK);

    }

    @PatchMapping (path = "/api/actualizarEmpleadoParcial", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <String> actualizarEmpleadoParcial (){

       String retorno = "Actualizacion Parcial de dominio Persona";
       System.out.println("Ok, metodo patch");
       return new ResponseEntity<String >(retorno, HttpStatus.OK);

    }
    @DeleteMapping (path = "/api/borrarEmpleado/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Boolean> borrarPersona (@PathVariable Long id){

        EntityEmpleado p = serviceEmpleado.buscarEmpleado(id);

        Boolean salida = serviceEmpleado.eliminarEmpleado(p);

       return new ResponseEntity<Boolean>(salida, HttpStatus.OK);

    }

    @GetMapping (path = "/api/listarTodosEmpleados", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Object> listarTodos (){

       return  new ResponseEntity<Object>(serviceEmpleado.listarEmpleados(), HttpStatus.OK);

    }

    @PostMapping (path = "/api/insertarEmpleado", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Boolean> insertarEmpleado (@RequestBody EntityEmpleado empleado){

      return new ResponseEntity<Boolean>(serviceEmpleado.insertarEmpleado(empleado), HttpStatus.OK)  ;

    }

    @PutMapping (path = "/api/actualizarEmpleadoTotal", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> actualizarEmpleadoTotal (@RequestBody EntityEmpleado empleado){

        return new ResponseEntity<Boolean> (serviceEmpleado.actualizarEmpleadoTotal(empleado), HttpStatus.OK);

    }

    @PatchMapping (path = "/udea/mintic/actualizarEmpleadoParcial", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void insertarEmpleadoParcial (@RequestBody EntityEmpleado empleado){

        serviceEmpleado.actualizarEmpleadoParcial(empleado);
    }

    @DeleteMapping("/api/borrarEmpleado/{id}")
    public void eliminarEmpleado(@PathVariable("id") Long id) {
        serviceEmpleado.deleteEmpleadoById(id);
    }

    @PostMapping (path = "/udea/mintic/insertarEmpleadoRol", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void insertarEmpleadoRol (@RequestBody EntityEmpleado empleado){

        serviceEmpleado.insertarEmpleadoRol(empleado);

    }



}
