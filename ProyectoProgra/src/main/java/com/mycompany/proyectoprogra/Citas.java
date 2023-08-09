/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoprogra;
import java.time.LocalDate;
import java.time.LocalTime;
/**
 *
 */
public class Citas {

    //Atributos
    private Medicos medico;
    private Pacientes paciente;
    private LocalDate fecha;
    private LocalTime hora;
    private int servicio;
    
    
    //Constructor
    public Citas(Medicos medico, Pacientes paciente, LocalDate fecha, LocalTime hora, int servicio) {
        this.medico = medico;
        this.paciente = paciente;
        this.fecha = fecha;
        this.hora = hora;
        this.servicio = servicio;
    }
     
    //Getters y Setters
     public Medicos getMedico() {
        return medico;
    }

    public void setMedico(Medicos medico) {
        this.medico = medico;
    }

    public Pacientes getPaciente() {
        return paciente;
    }

    public void setPaciente(Pacientes paciente) {
        this.paciente = paciente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
    
    public int getServicio() {
        return servicio;
    }

    public void setServicio(int servicio) {
        this.servicio = servicio;
    }
}
