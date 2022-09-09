package com.Pilotos.pilotosCompany.Services;

import com.Pilotos.pilotosCompany.Model.MovimientoDinero;
import com.Pilotos.pilotosCompany.Repository.MovimientoDineroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovimientoDineroService {
    @Autowired
    MovimientoDineroRepository movimientoDineroRepository;

   public List<MovimientoDinero> getAllMovimientoDinero(){
            List<MovimientoDinero> listaMovimientoDinero = new ArrayList<>();
            movimientoDineroRepo.findAll().forEach(movimientoDinero -> listaMovimientoDinero.add(movimientoDinero));
            return listaMovimientoDinero;
        }

        //metodo para buscar por id
        public MovimientoDinero getMovimientoDinero(Integer id){
            //buscar con id
            return movimientoDineroRepo.findById(id).get();
        }

        //guardar o actualizar sobreescribir el objeto
        public boolean actualizarMovimientoDinero(MovimientoDinero movimientoDinero){
            MovimientoDinero emp = movimientoDineroRepo.save(movimientoDinero);
            if (movimientoDineroRepo.findById(emp.getId())!= null){
                return true;
            }
            return false;
        }
        //metodo para eliminar
        public boolean eliminarMovimientoDinero(Integer id){
            movimientoDineroRepo.deleteById(id);
            if (getMovimientoDinero(id)!= null){
                return false;
            }
            return true;
        }
}
