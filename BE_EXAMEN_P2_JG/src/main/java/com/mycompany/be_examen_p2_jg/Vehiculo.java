/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.be_examen_p2_jg;

//import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author jordi
 */

@Entity
public class Vehiculo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_vehiculo;
    private String tipo;
    private String marca;
    private int potencia;
    private String fecha_compra;
    public static List<Vehiculo> todosVehiculos = new ArrayList<>();
    
    public Vehiculo(){
    }

    public Vehiculo(Long id_vehiculo, String tipo, String marca, int potencia, String fecha_compra){
            this.id_vehiculo = id_vehiculo;
            this.tipo = tipo;
            this.marca = marca;
            this.potencia = potencia;
            this.fecha_compra = fecha_compra;
            todosVehiculos.add(this);
    }

    //SETTERS I GETTERS

    public Long getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId(Long id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public String getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(String fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public static List<Vehiculo> getTodosVehiculos() {
        return todosVehiculos;
    }

    public static void setTodosVehiculos(List<Vehiculo> todosVehiculos) {
        Vehiculo.todosVehiculos = todosVehiculos;
    }

    
 
}