/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import dominio.Tarea;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jainer Said Garcia Gonzalez
 */




public class TareaDAO {

    // Método  1 insertar tarea
    public void insertarTarea(Tarea tarea) throws SQLException {
        String sql = "INSERT INTO Tarea (titulo, prioridad, estado, especial, fecha) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, tarea.getTitulo());
            stmt.setInt(2, tarea.getPrioridad());
            stmt.setBoolean(3, tarea.isEstado());
            stmt.setBoolean(4, tarea.isEspecial());
            stmt.setObject(5, tarea.getFecha());

            stmt.executeUpdate();
        }
    }

    // Método 2 listar tareas
    public List<Tarea> listarTareas() throws SQLException {
        List<Tarea> tareas = new ArrayList<>();
        String sql = "SELECT * FROM Tarea ORDER BY fecha";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Tarea tarea = new Tarea(
                    rs.getInt("idTarea"),
                    rs.getString("titulo"),
                    rs.getInt("prioridad"),
                    rs.getBoolean("estado"),
                    rs.getBoolean("especial"),
                    rs.getDate("fecha").toLocalDate()
                );
                tareas.add(tarea);
            }
        }

        return tareas;
    }

    // Método 3 eliminar tarea (desasignar, no borrar)
    public void eliminarTarea(int idTarea) throws SQLException {
        String sql = "UPDATE Tarea SET estado = 0 WHERE idTarea = ?";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idTarea);
            stmt.executeUpdate();
        }
    }
}

