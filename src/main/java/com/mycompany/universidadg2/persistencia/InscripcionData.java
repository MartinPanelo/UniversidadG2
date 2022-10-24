/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.universidadg2.persistencia;

import com.mycompany.universidadg2.entidades.Alumno;
import com.mycompany.universidadg2.entidades.Inscripcion;
import com.mycompany.universidadg2.entidades.Materia;
import java.sql.Connection;
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
public class InscripcionData {
    
    private Connection conexionData;
    private AlumnoData a1 = new AlumnoData(conexionData);
    private MateriaData m1 = new MateriaData(conexionData);
    
    public InscripcionData(Connection connection) {
        this.conexionData = connection;
    }
    
    public void guardarInscripcion(Inscripcion i) {
    String query = "INSERT INTO inscripcion(id_alumno, id_materia, nota) VALUES (?, ?, ?)";
    try {
    PreparedStatement ps = conexionData.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, i.getAlumno().getId_alumno());
            ps.setInt(2, i.getMateria().getId_materia());
            ps.setDouble(3, i.getNota());
                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "La inscripcion se realizo.");
                } else  {
                    JOptionPane.showMessageDialog(null, "La inscripcion no se realizo.");
                }
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    i.setId_inscripcion(rs.getInt(1));
                } else  {
                    JOptionPane.showMessageDialog(null, "No se pudo obtener id.");
                }
            } catch(SQLException ex) {
                JOptionPane.showMessageDialog(null, "Se produjo un error, en agregar materia");
            }
    }
    
    public Inscripcion obtenerInscripcion(int id_alumno, int id_materia) {
        Inscripcion i1 = null;
        String sql = "SELECT * FROM inscripcion WHERE id_materia = ? AND id_alumno = ?";
        try {
            PreparedStatement ps = conexionData.prepareStatement(sql);
            ps.setInt(1, id_materia);
            ps.setInt(2, id_alumno);
            ResultSet rs = ps.executeQuery();
  
            if (rs.next()) {
                i1 = new Inscripcion();
                i1.setAlumno(a1.buscarAlumnoPorID(rs.getInt("id_alumno")));
                i1.setMateria(m1.buscarMateriaPorID(rs.getInt("id_materia")));
                i1.setNota(rs.getDouble("nota"));
                i1.setId_inscripcion(rs.getInt("id_inscripcion"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se produjo un error. obtener inscripcion.");
        }
//        
        if (i1 == null) {
            JOptionPane.showMessageDialog(null, "No hay una inscripcion con esos parametros.");
        }
        return i1;
//   
    }
    
     public void borrarInscripcion (int id_alumno, int id_materia){
        String sql="DELETE FROM inscripcion WHERE id_alumno = ? AND id_materia = ?";
        try {
            PreparedStatement ps=conexionData.prepareStatement(sql);
            ps.setInt(1, id_alumno);
            ps.setInt(2, id_materia);
            
            if (ps.executeUpdate() <= 0) {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar");
            } else  {   
                JOptionPane.showMessageDialog(null, "Se elimino la inscripcion correctamente");
            }
            
            ps.close();
            
    }   catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "InscripcionData Sentencia SQL erronea-borrarInscripcion");
        }
    }
    
    }
    