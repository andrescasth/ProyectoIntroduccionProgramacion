/*
 * Esta clase representa a los pacientes y almacena su información en el sistema de citas médicas.
 */
package com.mycompany.proyectoprogra;
import java.time.LocalDate;
import java.time.LocalTime;

public class Pacientes {
    private String nombreCliente;   // Nombre del paciente
    private String telefonoCliente; // Número de teléfono del paciente
    private LocalDate fecha;        // Fecha de la cita
    private int servicio;           // Tipo de servicio (especialidad médica)
    private int duracion;           // Duración de la cita
    
    // Constructor de la clase
    public Pacientes(String nombreCliente, String telefonoCliente, LocalDate fecha, int servicio) {
        this.nombreCliente = nombreCliente;
        this.telefonoCliente = telefonoCliente;
        this.fecha = fecha;
        this.servicio = servicio;
    }
    
    // Métodos para obtener y establecer el nombre del paciente
    public String getNombreCliente() {
        return nombreCliente;
    }
    
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    
    // Métodos para obtener y establecer el número de teléfono del paciente
    public String getTelefonoCliente() {
        return telefonoCliente;
    }
    
    public void setTelefonoliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }
    
    // Métodos para obtener y establecer la fecha de la cita
    public LocalDate getFecha() {
        return fecha;
    }
    
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    // Métodos para obtener y establecer el tipo de servicio (especialidad médica)
    public int getServicio() {
        return servicio;
    }
    
    public void setServicio(int servicio) {
        this.servicio = servicio;
    }
    
    // Métodos para obtener la duración de la cita basada en el tipo de servicio
    public int getDuracion() {
        return duracion;
    }
    
    // Establece la duración de la cita según el tipo de servicio
    public void setDuracion(int servicio) {
        if (servicio == 1) {
            duracion = 1;
        }
        if (servicio == 2) {
            duracion = 2;
        }
        if (servicio == 3) {
            duracion = 3;
        }
    }
}
