/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import dominio.Tarea;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author jainer Said Garcia Gonzalez
 */

public class TareaDAO {

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
}
