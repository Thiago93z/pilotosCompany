package com.Pilotos.pilotosCompany.services;

import com.Pilotos.pilotosCompany.repository.EntityEmpleado;
import com.Pilotos.pilotosCompany.repository.EntityPermisos;
import com.Pilotos.pilotosCompany.repository.RepositoryEmpleado;
import com.Pilotos.pilotosCompany.repository.RepositoryPermisos;
import com.Pilotos.pilotosCompany.util.EnumRol;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceEmpleado {

    @Getter
    @Setter
    private String nombrePrograma;

    @Autowired
    RepositoryEmpleado repositoryEmpleado;

    @Autowired
    RepositoryPermisos repositoryPermisos;
    ArrayList <EntityEmpleado> listaEmpleados;

    public ServiceEmpleado(ArrayList<EntityEmpleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }


    public String inscribirEmpleado(EntityEmpleado empleadoNuevo){

        String inscripcion = "El alumno " + empleadoNuevo.getNombre() + " " + empleadoNuevo.getApellido() + " Con " + empleadoNuevo.getEdad() + "  años, Quedo inscrito al programa "  ;

        return inscripcion;
    }

    public boolean addEmpleado(EntityEmpleado empleado){

        EntityEmpleado empleado1 = new EntityEmpleado();
        empleado1.setNombre(empleado.getNombre());
        empleado1.setApellido(empleado.getApellido());
        empleado1.setEdad(empleado.getEdad());
        empleado1.setId(empleado.getId());

        listaEmpleados.add(empleado1);

        return Boolean.TRUE;

    }

    public ArrayList<EntityEmpleado> listar (){

        System.out.println("Metodo listar del service");

        return listaEmpleados;

    }

    public EntityEmpleado buscarEmpleado (Long id){

        EntityEmpleado empleado = null;

        for (EntityEmpleado p :listaEmpleados ) {
            if (p.getId() == id){
                return p;
            }
        }

        return empleado;
    }



    public Boolean eliminarEmpleado (EntityEmpleado empleado){

        listaEmpleados.remove(empleado);

        return Boolean.TRUE;

    }

    public List <EntityEmpleado>  listarEmpleados (){

        List<EntityEmpleado> list = repositoryEmpleado.findAll();

        return  list;

    }

    public Boolean insertarEmpleado (EntityEmpleado empleado){
        try {
            repositoryEmpleado.save(empleado);
        }catch (Exception e){

            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }


    public Boolean actualizarEmpleadoTotal (EntityEmpleado empleado){

        try {
            repositoryEmpleado.save(empleado);
        }catch (Exception e){

            return Boolean.FALSE;
        }
        return Boolean.TRUE;


    }


    public void actualizarEmpleadoParcial (EntityEmpleado empleado){

       EntityEmpleado currentEmpleado =  repositoryEmpleado.findById(empleado.getId()).orElse(null);

       if (empleado.getNombre() != null){
           currentEmpleado.setNombre(empleado.getNombre());
       }else if (empleado.getApellido() != null){
           currentEmpleado.setApellido(empleado.getApellido());
       }else if (empleado.getEdad() != null){
           currentEmpleado.setEdad(empleado.getEdad());
       }else if (empleado.getDoc() != null){
           currentEmpleado.setDoc(empleado.getDoc());
       }else if (empleado.getPassword() != null){
           currentEmpleado.setPassword(empleado.getPassword());
       }

        repositoryEmpleado.save(currentEmpleado);

    }

    public void deleteEmpleadoById (Long id){

        repositoryEmpleado.deleteById(id);
    }

    public void insertarEmpleadoRol(EntityEmpleado empleado){


        if (empleado.getRol().equals(EnumRol.ADMIN)){
            repositoryEmpleado.save(empleado);
            EntityPermisos permisosAdmin = new EntityPermisos( true, true,true, true, empleado );
            repositoryPermisos.save(permisosAdmin);
        } else if (empleado.getRol().equals(EnumRol.USER)){
            repositoryEmpleado.save(empleado);
            EntityPermisos permisosUser = new EntityPermisos( true, false,false, true, empleado );
            repositoryPermisos.save(permisosUser);

        }else if (empleado.getRol().equals(EnumRol.VISITANTE)){
            repositoryEmpleado.save(empleado);
            EntityPermisos permisosVisitante = new EntityPermisos( true, false,false, false, empleado );
            repositoryPermisos.save(permisosVisitante);
        }else {
            System.err.println("No se pudo obtener el Rol");

        }

    }


}
