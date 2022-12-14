package com.Pilotos.pilotosCompany.Services;

import com.Pilotos.pilotosCompany.Model.Empleado;
import com.Pilotos.pilotosCompany.Model.Empresa;
import com.Pilotos.pilotosCompany.Repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpleadoService {
    @Autowired
    EmpleadoRepository empleadoRepository;

    public void crearEmpleado(Empleado empleado){

        empleadoRepository.save(empleado);
    }

    public void editarEmpleado(Empleado empleado){
        empleadoRepository.save(empleado);
    }


    public List<Empleado> verEmpleado(){
        List<Empleado> empleados = new ArrayList<Empleado>();
        empleados.addAll(empleadoRepository.findAll());
        return empleados;
    }
    public Empleado verEmpleadoPorId(Long id){

        return empleadoRepository.findById(id).get();

    }

    public void eliminarEmpleado(Long id){
        empleadoRepository.deleteById(id);
    }
}
