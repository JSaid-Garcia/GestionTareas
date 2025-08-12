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

    //constructor
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

    
    
    //Setters y getters
    
    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }
    
    public int getIdTarea() {
        return idTarea;
    }

   public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEspecial(boolean especial) {
        this.especial = especial;
    }

    public boolean isEspecial() {
        return especial;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public Date getFecha() {
        return fecha;
    }

    public void setCreado(LocalDate creado) {
        this.creado = creado;
    }

    public LocalDate getCreado() {
        return creado;
    }

   
    public void setModificado(LocalDate modificado) {
        this.modificado = modificado;
    }

    public LocalDate getModificado() {
        return modificado;
    }

    
   
    
    
    
    
    
    
    
    
    
    
}
