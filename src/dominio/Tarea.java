/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author jainer Said Garcia Gonzalez
 */
public class Tarea {
    //Atributos
    private int idTarea;
    private String titulo;
    private int prioridad;
    private boolean estado;
    private boolean especial;
    private Date fecha;
    private LocalDate creado;
    private LocalDate modificado;
    
    //Constructor
    public Tarea(int idTarea, String titulo, int prioridad, boolean estado, boolean especial, Date fecha, LocalDate creado, LocalDate modificado) {
        this.idTarea = idTarea;
        this.titulo = titulo;
        this.prioridad = prioridad;
        this.estado = estado;
        this.especial = especial;
        this.fecha = fecha;
        this.creado = creado;
        this.modificado = modificado;
    }
    
    
    
    
    
    
    
    
    
    
}
