package com.Pilotos.pilotosCompany.Services;

import com.Pilotos.pilotosCompany.Model.Empresa;
import com.Pilotos.pilotosCompany.Repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpresaService {
    @Autowired
    EmpresaRepository empresaRepository;

    public void crearEmpresa(Empresa empresa){

        empresaRepository.save(empresa);
    }

    public void editarEmpresa(Empresa empresa){
        empresaRepository.save(empresa);
    }


    public List<Empresa> verEmpresa(){
        List<Empresa> empresas = new ArrayList<Empresa>();
        empresas.addAll(empresaRepository.findAll());
        return empresas;
    }

    public void eliminarEmpresa(Long id){
        empresaRepository.deleteById(id);
    }
}
