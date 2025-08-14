/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;
import dao.TareaDAO;
import dominio.Tarea;
import dominio.ExcepcionValidacion;
import java.sql.SQLException;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author jainer Said 
 */



public class TareaServicio {
    private TareaDAO tareaDAO;
    private Stack<Tarea> pilaEliminadas; 

    public TareaServicio() {
        tareaDAO = new TareaDAO();
        pilaEliminadas = new Stack<>();
    }

    public void agregarTarea(Tarea tarea) throws ExcepcionValidacion, SQLException {
        validarTarea(tarea);
        tareaDAO.insertarTarea(tarea);
    }

    public List<Tarea> listarTareas() throws SQLException {
        return tareaDAO.listarTareas();
    }

    public void eliminarTarea(Tarea tarea) throws SQLException {
        tareaDAO.eliminarTarea(tarea.getIdTarea());
        pilaEliminadas.push(tarea);
    }

    public Tarea deshacerEliminacion() throws SQLException {
        if (!pilaEliminadas.isEmpty()) {
            Tarea restaurada = pilaEliminadas.pop();
            tareaDAO.insertarTarea(restaurada);
            return restaurada;
        }
        return null;
    }

    private void validarTarea(Tarea tarea) throws ExcepcionValidacion {
        if (tarea.getTitulo() == null || tarea.getTitulo().trim().isEmpty()) {
            throw new ExcepcionValidacion("El título no puede estar vacío.");
        }
        if (tarea.getPrioridad() < 1 || tarea.getPrioridad() > 3) {
            throw new ExcepcionValidacion("La prioridad debe estar entre 1 y 3.");
        }
    }

    public void alternarEstado(int idTarea) throws SQLException {
        tareaDAO.alternarEstado(idTarea);
    }

    public void marcarEliminada(int idTarea) throws SQLException {
        tareaDAO.marcarEliminada(idTarea);
    }

    public void restaurarTarea(int idTarea) throws SQLException {
        tareaDAO.restaurarTarea(idTarea);
    }
}

