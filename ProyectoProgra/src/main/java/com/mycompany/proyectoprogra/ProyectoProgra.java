/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.proyectoprogra;

//Clase importadas de Java
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
/**
 *
 *
 */
public class ProyectoProgra {

    public static void main(String[] args) {
        
        Medicos arrMedicos[] = new Medicos[5];  //Lista de tipo Medicos que acepta hasta 5 médicos
        
        //Mensaje que imprime el Menú
       String message= """
                    Bienvenido al Registro de Citas 
                    1.Ingresar un nuevo médico
                    2.Agendar una cita
                    3.Cancelar cita
                    4.Mostrar cita
                    5.Salir   
                    """;
        
        JOptionPane.showMessageDialog(null, message);      //Imprime el menú  
        
        int opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una opcion"));   //Solicita una opción inicial.
        
        //Ciclo While que valida que la opcion esté dentro de las opciones del menú y 
        //permite estar en el program sin necesidad de correrlo de nuevo
        while(opcion > 0){
            
         //Switch para seleccionar la opcion del menu
            switch(opcion){
                
                //Ingresar un nuevo médico
                case 1:
                    ingresarMedico(arrMedicos);
                    JOptionPane.showMessageDialog(null, message);      //Imprime el menú  
                    opcion = Integer.parseInt(JOptionPane.showInputDialog("ingrese opcion"));    //Solicita una opción nuevamente
                    break;
                        
                        
                 //Solicitrar una cita       
                case 2:
                    agendarCita(arrMedicos);
                    JOptionPane.showMessageDialog(null, message);      //Imprime el menú
                    opcion = Integer.parseInt(JOptionPane.showInputDialog("ingrese opcion"));//Solicita una opción nuevamente
                    break;
                
                 case 3:
                     eliminarCita(arrMedicos);
                     JOptionPane.showMessageDialog(null, message); // Imprime el menú nuevamente
                        opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una opción:"));
                        break;
                 case 4:
                      mostrarAgenda(arrMedicos);
                      JOptionPane.showMessageDialog(null, message); // Imprime el menú nuevamente
                        opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una opción:"));
                        break;
            }
                    
        } 

    }
    private static int contMedico = 0;  
    
    //Metodo para agregar un nuevo Medico
    private  static void ingresarMedico(Medicos[] arrMedicos){
        
        //Cuenta la cantidad de médicos que han sido registrados.
        if(contMedico < arrMedicos.length){ // Valida que no se puedan ingresar más de 5 médicos.
                        
            //Solicita la información del médico
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del medico:");
            String apellido = JOptionPane.showInputDialog("Ingrese el apellido del medico:");
            int especialidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la especialidad medico:\n 1.Medicina General \n 2.Cirugía Ambulatoria \n 3. Cirugía Especializada" ));
            String almuerzo = JOptionPane.showInputDialog("Ingrese la hora de almuerzo del medico(HH:mm):");
                         
            //Crea un nuevo objeto médico
            Medicos nuevoMedico = new Medicos(nombre,apellido,especialidad,almuerzo);
            nuevoMedico.setNombre(nombre);
            nuevoMedico.setApellido(apellido);
            nuevoMedico.setEspecialidad(especialidad);
            nuevoMedico.setAlmuerzo(almuerzo);
            LocalTime horaAlmuerzo = nuevoMedico.procesarAlmuerzo();//Llama al método procesorAlmuerzo para cambiar de String a LocalTime

           
            arrMedicos[contMedico]= nuevoMedico; //Agrega al médico creado a la lista de médicos
            contMedico++;      //Suma la posición del médico en 1
            JOptionPane.showMessageDialog(null, "Médico agregado correctamente.");//Imprime el mensaje



            //Imrpimir info del médico ingresado
            JOptionPane.showMessageDialog(null,"Nombre: " + nuevoMedico.getNombre()+"\n"+
            "Apellido: " + nuevoMedico.getApellido()+"\n"+
            "Especialidad: " + nuevoMedico.getEspecialidad()+"\n"+
            "Almuerzo: " + horaAlmuerzo);
                         

        }else{
            JOptionPane.showMessageDialog(null, "El arreglo está lleno. No se pueden agregar más médicos.");//Si la lista está llena
        }
    }
    
    
    //Metodo para agregar una nueva cita
    private static void agendarCita(Medicos[] arrMedicos) {
        
        String nombreMedico = JOptionPane.showInputDialog("Ingrese el nombre del médico:");//Solicita el nombre del medico

       // BUSCAR MEDICO EN LA LISTA
        Medicos medico = null;//Se le da un valor predeterminado que indica que en este punto la variable no hace referencia a ningún objeto en memoria.
         
        for (Medicos med : arrMedicos) {
            //Valida si el nombre ingresado coincide con algun nombre de la lista
            if (med != null && med.getNombre().equalsIgnoreCase(nombreMedico)) {
                medico = med;
                break;
            }
        }

        //Si el nombre no coincide imprime el mensaje
        if (medico == null) {
            JOptionPane.showMessageDialog(null, "Médico no encontrado. Verifique el nombre ingresado.");
            return;//Termina el metodo si no coincide el nombre
        }

        //Solicita la informacion del cliente
        String nombreCliente = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
        String telefonoCliente = JOptionPane.showInputDialog("Ingrese el teléfono del cliente:");
        int servicioCliente = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la especialidad medico:\n 1.Medicina General \n 2.Cirugía Ambulatoria \n 3. Cirugía Especializada" ));

        //Indica que el medico no da el servicio
        if( medico.getEspecialidad() != servicioCliente){
            JOptionPane.showMessageDialog(null, "Médico no da este servicio");
            return;
        }
        
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");//formate de la fecha
        String fechaString = JOptionPane.showInputDialog("Ingrese la fecha de la cita (formato dd/MM/yyyy):");
        LocalDate fechaCita = LocalDate.parse(fechaString, dateFormatter);//Transforma la fecha a LocalDate

    
        int duracionCita = 0;
        switch (servicioCliente) {
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
          // Calcular el precio de la cita
             DayOfWeek diaSemana = fechaCita.getDayOfWeek();
            double precio =0;
            double iva = 0.13;
            if(diaSemana == DayOfWeek.SATURDAY || diaSemana == DayOfWeek.SUNDAY ){
                precio = 40000;   
            }else{
                precio = 25000;
            }


        double precioIVA = precio+(precio*iva);
        double precioTotal = (precioIVA * duracionCita);

        // Buscar la primera hora disponible para la cita
        LocalTime horaInicioCita = null;

        for (LocalTime hora = LocalTime.of(8, 0); hora.plusHours(duracionCita).isBefore(LocalTime.of(18, 0)); hora = hora.plusHours(servicioCliente)) {
            if (medico.puedeAtenderCita(hora, duracionCita) && !medico.tieneCita(hora, fechaCita)) {
                horaInicioCita = hora;
                break;
            }
        }
        if (horaInicioCita != null) {
            // Crea la cita con la hora asignada
            Citas cita = new Citas(medico, new Pacientes(nombreCliente, telefonoCliente, fechaCita, servicioCliente), fechaCita, horaInicioCita, servicioCliente);
            medico.agregarCita(cita);
            JOptionPane.showMessageDialog(null, "Cita asignada para el médico " + medico.getNombre() + " a las " + horaInicioCita + ".\nTotal a pagar: " + precioTotal + " colones.");
        } else {
            JOptionPane.showMessageDialog(null, "El médico no está disponible para esa fecha y hora.");
        }

       // Si no se encontró una hora disponible, mostrar un mensaje y terminar el método
        if (horaInicioCita == null) {
            JOptionPane.showMessageDialog(null, "No hay horarios disponibles para la cita.");
            return;
        }


        // Verificar si la hora de la cita está dentro del horario de almuerzo
        LocalTime horaAlmuerzoInicio = medico.procesarAlmuerzo();
        LocalTime horaAlmuerzoFin = horaAlmuerzoInicio.plusHours(1); // Suponemos que el almuerzo dura 1 hora
        
        if (horaInicioCita.isAfter(horaAlmuerzoInicio) && horaInicioCita.isBefore(horaAlmuerzoFin)) {
            JOptionPane.showMessageDialog(null, "No se puede agendar una cita durante el horario de almuerzo.");
            return;
        }

        // Verificar si la hora de la cita está dentro del rango de 8 am a 6 pm
        if (horaInicioCita.isBefore(LocalTime.of(8, 0)) || horaInicioCita.plusHours(duracionCita).isAfter(LocalTime.of(18, 0))) {
            JOptionPane.showMessageDialog(null, "El horario de citas es de 8 am a 6 pm.");
            return;
        }
    }
    
    //Método para eliminar la Cita
    private static void eliminarCita(Medicos[] arrMedicos) { //Recibe una lista de doctores
        
        String nombreMedico = JOptionPane.showInputDialog("Ingrese el nombre del doctor:");   //Solicita el nombre del doctor  
        String nombreCliente = JOptionPane.showInputDialog("Ingrese el nombre del paciente:"); //Solicita el nombre del paciente  
        String fechaString = JOptionPane.showInputDialog("Ingrese la fecha de la cita (formato dd/MM/yyyy):"); //Solita la fecha de la cita a cancelar
        LocalDate fechaCita = LocalDate.parse(fechaString, DateTimeFormatter.ofPattern("dd/MM/yyyy")); //Da formato de fecha  a fechaString

        //Ciclo para  validar si la cita existe
         for (Medicos medico : arrMedicos) {
            if (medico != null && medico.getNombre().equalsIgnoreCase(nombreMedico)) { //Valida si el medico existe
                for (int i = 0; i < medico.getCitas().length; i++) {
                    Citas cita = medico.getCitas()[i];
                    if (cita != null && cita.getPaciente().getNombreCliente().equalsIgnoreCase(nombreCliente) && cita.getFecha().equals(fechaCita)) { //Valida si el paciene existe
                        medico.getCitas()[i] = null;//Si se cumple la cita pasa a null
                        JOptionPane.showMessageDialog(null, "Reservación eliminada.");
                        return;
                    }
                }
            }
        }
    //Indica que la cita no se encontro
        JOptionPane.showMessageDialog(null, "Reservación no encontrada.");
    }
    
    
    //Metodo para imprimir la agenda del doctor
    private static void mostrarAgenda(Medicos[] arrMedicos) {
        
        String nombreMedico = JOptionPane.showInputDialog("Ingrese el nombre del médico:"); //Solicita el nombre del doctor 
        String fechaString = JOptionPane.showInputDialog("Ingrese la fecha para ver la agenda (formato dd/MM/yyyy):"); //Solita la fecha a solicitar
        LocalDate fechaAgenda = LocalDate.parse(fechaString, DateTimeFormatter.ofPattern("dd/MM/yyyy")); //Da formato de fecha  a fechaString

        //Ciclo para  validar si la cita existe
        for (Medicos medico : arrMedicos) {
            if (medico != null && medico.getNombre().equalsIgnoreCase(nombreMedico)) {//Valida si el medico existe
                LocalTime horaActual = LocalTime.of(8, 0); //Inicia a las 8am
                String agendaMessage = "Agenda del médico " + medico.getNombre() + " para el día " + fechaAgenda + "\n";

                //Ciclo que valida que la hora sea antes de las 6pm(18:00)
                while (horaActual.isBefore(LocalTime.of(18, 0))) { 

                    if (horaActual.equals(medico.procesarAlmuerzo())) { //valida la hora de almuerzo
                        agendaMessage += horaActual + " - HORA DE ALMUERZO\n";//Imprime la hora de almuerzo
                    } else {

                        boolean citaEncontrada = false;
                        //valida las citas
                        for (Citas cita : medico.getCitas()) {
                            if (cita != null && cita.getFecha().equals(fechaAgenda) && cita.getHora().equals(horaActual)) {
                                agendaMessage += horaActual + " - " + cita.getPaciente().getNombreCliente() + " (" + cita.getPaciente().getTelefonoCliente() + ")\n"; //Si la cita existe imprime el nombre del cliente
                                citaEncontrada = true; //Pasa a ser true
                                break;
                            }
                        }
                        //Si es false imprime vacio
                        if (!citaEncontrada) {
                            agendaMessage += horaActual + " - —VACIO –\n";
                        }
                    }
                    horaActual = horaActual.plusHours(1); //aumenta 1 hora a hora actual
                }

                // Calcular el monto de dinero a recaudar
                double montoTotal = 0;
                double iva = 0.13;
                double montoIVA;

                DayOfWeek diaSemana = fechaAgenda.getDayOfWeek(); //asigna el dia de la semana a la variable

                double precio;
                if (diaSemana == DayOfWeek.SATURDAY || diaSemana == DayOfWeek.SUNDAY){
                    precio = 40000;//Si es sabado o domingo vale 40000
                }else{
                    precio = 25000;//si es otro dia vale 25000
                }
                //Si la cita existe aumenta el monto de montoTotal
                for (Citas cita : medico.getCitas()) {
                    if (cita != null && cita.getFecha().equals(fechaAgenda)) {
                        montoTotal += (precio * cita.getServicio());

                    }
                }
                montoIVA= montoTotal+(montoTotal*iva);
                JOptionPane.showMessageDialog(null, "Monto a recaudar: " + montoIVA + " colones.");
                JOptionPane.showMessageDialog(null, agendaMessage);
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Médico no encontrado.");
    }
}
    
