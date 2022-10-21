/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.universidadg2.persistencia;

import com.mycompany.universidadg2.entidades.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ezequ
 */
public class InscripcionData {
    
    private Connection conexionData;
    
    public InscripcionData(Connection connection) {
        this.conexionData = connection;
    }
    
    
}
