package com.mycompany.universidadg2.persistencia;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import java.sql.Connection;

public class miConexion {
    
    private String url;
    private String usuario;
    private String password;
<<<<<<< Updated upstream
    private Connection conexion;

    public miConexion(String url, String usuario, String password) {
        this.url = url;
        this.usuario = usuario;
        this.password = password;
    }
    
    public Connection buscarConexion(){
        if(conexion==null){
            try{
                Class.forName("org.mariadb.jdbc.Driver");
            }catch(ClassNotFoundException ex){
=======
    
    private Connection conexion; // lo que importa
    
    public miConexion(String url, String usr, String pass)  {
    this.url = url;
    usuario= usr;
    password = pass;
    }
    public Connection buscarConexion() {
        if (conexion==null) { // si es la primera vez
            try {
                Class.forName("org.mariadb.jdbc.Driver"); //com.mysql.jdbc.Driver
                    conexion = DriverManager.getConnection(url, usuario, password);
            } catch (SQLException | ClassNotFoundException ex)  {
>>>>>>> Stashed changes
                Logger.getLogger(miConexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conexion;
    }
    
}
