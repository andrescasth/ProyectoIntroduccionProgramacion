/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoprogra;

import java.time.LocalTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
/**
 *
 * @author andre
 */
public class Medicos {
//Atributos
    private String nombre;
    private  String apellido;
    private  int especialidad;
    private  String  almuerzo;
    private Citas[] citas;
   
    
    //Constructor
    public Medicos(String nombre,String apellido, int especialidad, String almuerzo ){
        this.nombre = nombre;
        this.apellido= apellido;
        this.especialidad= especialidad;
        this.almuerzo = almuerzo;
        this.citas = new Citas[10];
    }
     
     //Getters y Setters
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
            this.nombre = nombre;
    }
    
     public String getApellido(){
        return apellido;
    }
    
    public void setApellido(String apellido){
            this.apellido = apellido;
    }
    
     public int getEspecialidad(){
        return especialidad;
    }
    
    public void setEspecialidad(int especialidad){
            this.especialidad = especialidad;
    }
    
     public String getAlmuerzo(){
        return almuerzo;
    }
    
    public void setAlmuerzo(String almuerzo){
            this.almuerzo = almuerzo;
    }
    
    public Citas[] getCitas() {
        return citas;
    }
    
   
    //Transforma el String de "almuerzo" a LocalTime
    public LocalTime procesarAlmuerzo(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime localTime = LocalTime.parse(almuerzo, formatter);
        return localTime;
    }
    
    
    // Método para verificar si el médico puede atender una cita con cierta duración
    public boolean puedeAtenderCita(LocalTime horaInicio, int duracion) {
          int intervalo = 1;
    switch (especialidad) {
        case 1:
            intervalo = 1; // Medicina General atiende cada hora
            break;
        case 2:
            intervalo = 2; // Cirugía Ambulatoria atiende cada 2 horas
            break;
        case 3:
            intervalo = 3; // Cirugía Especializada atiende cada 3 horas
            break;
        default:
            return false; // Si la especialidad no es válida, no puede atender citas.
    }

    for (LocalTime hora = horaInicio; hora.isBefore(horaInicio.plusHours(duracion)); hora = hora.plusHours(intervalo)) {
        boolean disponible = true;
        // Verificar si el médico tiene una cita en la hora actual del ciclo
        for (Citas cita : citas) {
            if (cita != null && cita.getHora().equals(hora)) {
                disponible = false;
                break;
            }
        }
        // Verificar si la hora está dentro del horario de almuerzo
        if (hora.isAfter(procesarAlmuerzo()) && hora.isBefore(procesarAlmuerzo().plusHours(1))) {
            disponible = false;
        }
        if (disponible) {
            return true;
        }
    }
    return false;
}
        
    public void agregarCita(Citas cita) {
        int duracionCita = 0;
        switch (cita.getServicio()) {
            case 1:
                duracionCita = 1;
                break;
            case 2:
                duracionCita = 2;
                break;
            case 3:
                duracionCita = 3;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción inválida. La cita no se ha agendado.");
                return;
        }

        if (!puedeAtenderCita(cita.getHora(), duracionCita)) {
            JOptionPane.showMessageDialog(null, "El médico no está disponible para esa hora y duración.");
            return;
        }

        for (int i = 0; i < citas.length; i++) {
            if (citas[i] == null) {
                citas[i] = cita;
                JOptionPane.showMessageDialog(null, "Cita agregada exitosamente.");
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "No hay espacio disponible para agregar la cita.");
    }
     
     //Verifica si el medicvo ya tiene una cita
    public boolean tieneCita(LocalTime hora, LocalDate fecha) {
        for (Citas cita : citas) {
            if (cita != null && cita.getHora().equals(hora) && cita.getFecha().equals(fecha)) {
                return true;
            }
        }
        return false;
    }
}