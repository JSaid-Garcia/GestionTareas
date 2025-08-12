/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jainer Said Garcia Gonzalez
 */

public class ConexionBD {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=GestorTareas";
    private static final String USUARIO = "Said";
    private static final String CLAVE = "123456";
    
    
    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CLAVE);
    }
    
     
}
