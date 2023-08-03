/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoprogra;
import java.time.LocalDate;
import java.time.LocalTime;
/**
 *
 * @author andre
 */
public class Pacientes {
    
    //Atributos
    private String nombreCliente;
    private String telefonoCliente;
    private LocalDate fecha;
    private int servicio;
    private int duracion;
    
    //Constructor
    public Pacientes (String nombreCliente, String telefonoCliente, LocalDate fecha, int servicio){
        this.nombreCliente = nombreCliente;
        this.telefonoCliente= telefonoCliente;
        this.fecha= fecha;
        this.servicio = servicio;
        
    }
    
    
    public String getNombreCliente(){
        return nombreCliente;
    }
    
    public void setNombreCliente(String nombreCliente){
        this.nombreCliente = nombreCliente;
    }
    
    
    public String getTelefonoCliente(){
        return telefonoCliente;
    }
    
    public void setTelefonoliente(String telefonoCliente){
        this.telefonoCliente = telefonoCliente;
    }
    
    public LocalDate fecha(){
        return fecha;
    }
    
    public void setFecha(LocalDate fecha){
        this.fecha = fecha;
    }
    
    public int getServicio(){
        return servicio;
    }
    
    public void setServicio(int servicio){
        this.servicio = servicio;
    }
    
    public int getDuracion(){
        return duracion;
    }
    
    public void setDuracion(int servicio){
        if( servicio == 1){
            duracion =1;
        }
        if( servicio == 2){
            duracion = 2;
        
        }
        if( servicio == 3){
            duracion = 3;
        }
    }
}
