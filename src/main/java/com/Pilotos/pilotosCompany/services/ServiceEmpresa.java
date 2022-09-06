package com.Pilotos.pilotosCompany.services;

import com.Pilotos.pilotosCompany.Model.Empresa;
import com.Pilotos.pilotosCompany.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceEmpresa {


    @Autowired
    RepositoryEmpresa repositoryEmpresa;

    @Autowired
    RepositoryPermisos repositoryPermisos;
    ArrayList <Empresa> listaEmpresas;

    public ServiceEmpresa(ArrayList<Empresa> listaEmpresas) {
        this.listaEmpresas = listaEmpresas;
    }



    public Empresa buscarEmpresa (Long idEmpresa){

        Empresa empresa = null;

        for (Empresa p :listaEmpresas ) {
            if (p.getIdEmpresa() == idEmpresa){
                return p;
            }
        }

        return empresa;
    }



    public Boolean eliminarEmpresa (Empresa empresa){

        listaEmpresas.remove(empresa);

        return Boolean.TRUE;

    }

    public ArrayList<Empresa> listar (){

        System.out.println("Metodo listar del service");

        return listaEmpresas;

    }

    public boolean addEmpresa(Empresa empresa){

        Empresa currentEmpresa = new Empresa();
        currentEmpresa.setNombre(currentEmpresa.getNombre());
        currentEmpresa.setDireccion(currentEmpresa.getDireccion());
        currentEmpresa.setNIT(currentEmpresa.getNIT());
        currentEmpresa.setTelefono(currentEmpresa.getTelefono());

        listaEmpresas.add(currentEmpresa);

        return Boolean.TRUE;

    }

    public List <EntityEmpresa>  listarEmpresas (){

        List<EntityEmpresa> list = repositoryEmpresa.findAll();

        return  list;

    }

    public Boolean crearEmpresa (EntityEmpresa empresa){
        try {
            repositoryEmpresa.save(empresa);
        }catch (Exception e){

            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }



    public void deleteEmpresaById (Long idEmpresa){

        repositoryEmpresa.deleteById(idEmpresa);
    }



}
