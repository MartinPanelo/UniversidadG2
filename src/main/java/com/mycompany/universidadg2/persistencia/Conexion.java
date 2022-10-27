
package com.mycompany.universidadg2.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion {

    private static String url = "jdbc:mariadb://localhost:3306/escuelaprueba2";
    private static String usuario = "root";
    private static String password = "";
    private static Conexion conexion=null;

    private Conexion() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Clase Conexion: Error al cargar Driver");
        }
    }

    public static Connection getConexion() {
        
        Connection conn=null;
        
        if (conexion == null) {
            conexion=new Conexion();
         }
        
        try {
            conn = DriverManager.getConnection(url,usuario,password);
            System.out.println("Connected database successfully...");
           // conn = DriverManager.getConnection(url + "?useLegacyDatetimeCode=false&serverTimezone=UTC" + "&user=" + usuario + "&password=" + password);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Clase Conexion: Error de Conexion");
        }
      
      return conn;
    }

}