/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.universidadg2.persistencia;

import com.mycompany.universidadg2.entidades.Alumno;
import com.mycompany.universidadg2.entidades.Materia;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ezequ
 */
public class MateriaData {
    
    private Connection conexionData;
    
    public MateriaData(Connection connection) {
        this.conexionData = connection;
    }
    
    public void agregarMateria(Materia m) {
        String query = "INSERT INTO materia(nombre, anio, estado) VALUES (?, ?, ?)";
            try {
            PreparedStatement ps = conexionData.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, m.getNombre());
            ps.setInt(2, m.getAnio());
            ps.setBoolean(3, m.isEstado());
                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "La materia se agrego.");
                } else  {
                    JOptionPane.showMessageDialog(null, "La materia no se agrego.");
                }
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    m.setId_materia(rs.getInt(1));
                } else  {
                    JOptionPane.showMessageDialog(null, "No se pudo obtener id.");
                }
            } catch(SQLException ex) {
                JOptionPane.showMessageDialog(null, "Se produjo un error, en agregar materia");
            }
        
        
    }
    
    public Materia buscarMateriaPorID(int id) {
        Materia m = null;
        String sql = "SELECT * FROM materia WHERE id_materia = ?";
        try {
            PreparedStatement ps = conexionData.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                m = new Materia();
                m.setId_materia(rs.getInt("id_materia"));
                m.setNombre(rs.getString("nombre"));
                m.setAnio(rs.getInt("anio"));
                m.setEstado(rs.getBoolean("estado"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se produjo un error. en buscar materia por id.");
        }
        
        if (m == null) {
            JOptionPane.showMessageDialog(null, "No hay una materia con ese ID");
        }
        return m;
    }
    
    public void actualizarMateria(Materia m) {
        String sqlQuery = "UPDATE materia SET nombre= ? ,anio= ? ,estado= ? WHERE id_materia = ?";
        if (buscarMateriaPorID(m.getId_materia()) != null) {
            try {
            PreparedStatement ps = conexionData.prepareStatement(sqlQuery);
            ps.setString(1, m.getNombre());
            ps.setInt(2, m.getAnio());
            ps.setBoolean(3, m.isEstado());
            ps.setInt(4, m.getId_materia());
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Se pudo actualizar la materia.");
            } else  {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar la materia.");
            }
            
            ps.close();
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se produjo un error. en actualizar materia");
        }
        }
        }
    
    public ArrayList<Materia> listarMaterias() {

        ArrayList<Materia> listaMateria = new ArrayList();

        String sql = "SELECT * FROM materia WHERE estado = 1";

        try {
            PreparedStatement ps = conexionData.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Materia m = new Materia();

                m.setNombre(rs.getString("nombre"));
                m.setAnio(rs.getInt("anio"));
                m.setEstado(rs.getBoolean("estado"));
                m.setId_materia(rs.getInt("id_materia"));
             
                listaMateria.add(m);
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al obtener a las materias.");
        }
        return listaMateria;
    }
    
    public void borrarMateria (int id){
        String sql="UPDATE materia SET estado=0 WHERE id_materia = ?";
        try {
            PreparedStatement ps=conexionData.prepareStatement(sql);
            ps.setInt(1, id);
            
            if (ps.executeUpdate() <= 0) {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar");
            } else  {   
                JOptionPane.showMessageDialog(null, "Se elimino la materia correctamente");
            }
            
            ps.close();
            
    }   catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "MateriaData Sentencia SQL erronea-borrarMateria");
        }
    }
    
}
