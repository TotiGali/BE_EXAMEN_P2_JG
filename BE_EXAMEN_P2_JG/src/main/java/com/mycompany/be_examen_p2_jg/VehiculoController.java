/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.be_examen_p2_jg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Jordi
 */

@RestController

@RequestMapping("/api/vehiculos")
public class VehiculoController {
   
    @Autowired
    private VehiculoRepository vehiculoRepository;
    
    
    @GetMapping
    public List<Vehiculo> getAllVehiculos() {
        // Llama al método findAll() del repositorio para obtener los vehiculos
        return vehiculoRepository.findAll();
    }
    

    @PostMapping
    public Vehiculo createVehiculo(@RequestBody Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }
    
    
    @DeleteMapping("/eliminar/{id_vehiculo}")
    public ResponseEntity<Void> deleteVehiculo(@PathVariable long id_vehiculo) {
        if (vehiculoRepository.existsById(id_vehiculo)) {
            vehiculoRepository.deleteById(id_vehiculo);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PutMapping("/actualizar/{id_vehiculo}")
    public ResponseEntity<Vehiculo> updateVehiculo(@PathVariable Long id_vehiculo, @RequestBody Vehiculo updatedVehiculo) {
        Optional<Vehiculo> vehiculoOptional = vehiculoRepository.findById(id_vehiculo);
        if (vehiculoOptional.isPresent()) {
            Vehiculo vehiculo = vehiculoOptional.get();
            vehiculo.setTipo(updatedVehiculo.getTipo());
            vehiculo.setMarca(updatedVehiculo.getMarca());
            vehiculo.setPotencia(updatedVehiculo.getPotencia());
            vehiculo.setFecha_compra(updatedVehiculo.getFecha_compra());
            vehiculoRepository.save(vehiculo);
            return ResponseEntity.ok(vehiculo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/potenciaMedia/{tipo}")
    public ResponseEntity<Double> getAveragePotenciaByTipo(@PathVariable String tipo) {
        Double averagePotencia = vehiculoRepository.findAveragePotenciaByTipo(tipo);
        if (averagePotencia != null) {
            return ResponseEntity.ok(averagePotencia);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

     @GetMapping("/potenciaMaxima/{tipo}")
    public ResponseEntity<Integer> getMaxPotenciaByTipo(@PathVariable String tipo) {
        Integer maxPotencia = vehiculoRepository.findMaxPotenciaByTipo(tipo);
        if (maxPotencia != null) {
            return ResponseEntity.ok(maxPotencia);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
