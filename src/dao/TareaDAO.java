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
import javax.swing.JOptionPane;

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
    
    public void alternarEstado(int idTarea) throws SQLException {
        String sql = "UPDATE Tarea SET estado = CASE WHEN estado = 0 THEN 1 ELSE 0 END WHERE idTarea = ?";

    try (Connection conn = ConexionBD.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, idTarea);
        stmt.executeUpdate();
    }
    }
    
    public void marcarEliminada(int idTarea) throws SQLException {
    // PostgreSQL/MySQL (BOOLEAN):
    String sql = "UPDATE Tarea SET eliminada = 1 WHERE idTarea = ?";

    // SQL Server/Oracle (0/1):
    // String sql = "UPDATE Tarea SET eliminada = 1 WHERE id = ?";

    try (Connection conn = ConexionBD.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, idTarea);
        stmt.executeUpdate();
    }
}

    // Método 2 listar tareas
   public List<Tarea> listarTareas() throws SQLException {
    String sql = "SELECT idTarea, titulo, prioridad, estado, especial, fecha, creado, modificado " +
                 "FROM Tarea " +
                 "WHERE COALESCE(eliminada, 0) = 0 " + 
                 "ORDER BY idTarea";

    List<Tarea> lista = new ArrayList<>();
    try (Connection conn = ConexionBD.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            Tarea t = new Tarea(
                rs.getInt("idTarea"),
                rs.getString("titulo"),
                rs.getInt("prioridad"),
                rs.getBoolean("estado"),
                rs.getBoolean("especial"),
                rs.getDate("fecha"),
                rs.getDate("creado").toLocalDate(),
                rs.getDate("modificado").toLocalDate()
            );
            lista.add(t);
        }
    }
    return lista;
}
   
   public void restaurarTarea(int idTarea) throws SQLException {
    // PostgreSQL/MySQL (BOOLEAN):
    String sql = "UPDATE Tarea SET eliminada = 0 WHERE idTarea = ?";

    // SQL Server/Oracle (0/1):
    // String sql = "UPDATE Tarea SET eliminada = 0 WHERE idTarea = ?";

    try (Connection conn = ConexionBD.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, idTarea);
        stmt.executeUpdate();
    }
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

