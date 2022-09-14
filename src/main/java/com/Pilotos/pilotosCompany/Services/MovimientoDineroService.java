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
            movimientoDineroRepository.findAll().forEach(movimientoDinero -> listaMovimientoDinero.add(movimientoDinero));
            return listaMovimientoDinero;
        }
        
        public MovimientoDinero getMovimientoDinero(Integer id){
                 return movimientoDineroRepository.findById(id).get();
        }

        public boolean actualizarMovimientoDinero(MovimientoDinero movDinero){
            MovimientoDinero movimientoDinero = movimientoDineroRepository.save(movDinero);
            if (movimientoDineroRepository.findById(movimientoDinero.getId())!= null){
                return true;
            }
            return false;
        }
       
            public boolean eliminarMovimientoDinero(Integer id){
            movimientoDineroRepository.deleteById(id);
             if (movimientoDineroRepo.findById(id)!= null){
                return true;
            }
            return false;
        }
     
        public Long obtenerSumaMontos(){
            return movimientoDineroRepo.SumarMonto();
        }

        public Long MontosPorEmpleado(Integer id){
            return movimientoDineroRepo.MontosPorEmpleado(id);
        }
    
        public Long MontosPorEmpresa(Integer id){
            return movimientoDineroRepo.MontosPorEmpresa(id);
        }
    
        public ArrayList<MovimientoDinero> obtenerPorEmpleado(Integer id) {
            return movimientoDineroRepo.findByEmpleado(id);
        }

        public ArrayList<MovimientoDinero> obtenerPorEmpresa(Integer id) { 
            return movimientoDineroRepo.findByEmpresa(id);
        }

}
