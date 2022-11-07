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
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ezequ
 */
public class InscripcionData {
    
    private Connection conexionData;
    private AlumnoData aData;
    private MateriaData mData;
    
    public InscripcionData(Connection connection) {
        this.conexionData = connection;
        this.aData = new AlumnoData(connection);
        this.mData = new MateriaData(connection);
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
                
                ps.close();
                
            } catch(SQLException ex) {
                JOptionPane.showMessageDialog(null, "Se produjo un error, en agregar la inscripción");
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
                i1.setAlumno(aData.buscarAlumnoPorID(rs.getInt("id_alumno")));
                i1.setMateria(mData.buscarMateriaPorID(rs.getInt("id_materia")));
                i1.setNota(rs.getDouble("nota"));
                i1.setId_inscripcion(rs.getInt("id_inscripcion"));
            }
            
            ps.close();
            
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
     
     public void actualizarNota(int id_alumno, int id_materia, double nota) {
        String sqlQuery = "UPDATE inscripcion SET nota= ? WHERE id_materia = ? AND id_alumno = ?";
            try {
            PreparedStatement ps = conexionData.prepareStatement(sqlQuery);
            ps.setDouble(1, nota);
            ps.setInt(2, id_materia);
            ps.setInt(3, id_alumno);
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Se pudo actualizar la nota.");
            } else  {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar la nota.");
            }
            
            ps.close();
            
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se produjo un error. en actualizar nota");
        }
        }
     
     public List<Inscripcion> listadoDeInscripciones() {
         
     String sql = "SELECT * FROM inscripcion";
     
     List<Inscripcion> listaInscripcion = new ArrayList<Inscripcion>();
     try {
         
        PreparedStatement ps = conexionData.prepareStatement(sql);
        
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
        
                Inscripcion i = new Inscripcion();
                
                i.setAlumno(aData.buscarAlumnoPorID(rs.getInt("id_alumno")));
                i.setMateria(mData.buscarMateriaPorID(rs.getInt("id_materia")));
                i.setNota(rs.getDouble("nota"));
                i.setId_inscripcion(rs.getInt("id_inscripcion"));
                listaInscripcion.add(i);
                
                
                }
     
        ps.close();
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al listar las inscripciones. " + ex);
        }
     return listaInscripcion;
     }
     
     
     public List<Materia> obtenerMateriasInscriptas(Alumno a) {
        
        String sql = "SELECT * FROM inscripcion, materia WHERE inscripcion.id_materia = materia.id_materia AND id_alumno = ?";
        
        List<Materia> listaMateria = new ArrayList();
        
        try {
            PreparedStatement ps = conexionData.prepareStatement(sql);

            ps.setInt(1, a.getId_alumno());
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
     
     public List<Materia> obtenerMateriasNoInscriptas(Alumno a) {
        
        String sql = "SELECT * FROM materia WHERE id_materia NOT IN(SELECT inscripcion.id_materia FROM inscripcion NATURAL JOIN materia WHERE id_alumno = ?)";
        
        List<Materia> listaMateria = new ArrayList();
        
        try {
            PreparedStatement ps = conexionData.prepareStatement(sql);

            ps.setInt(1, a.getId_alumno());
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
     
     public List<Alumno> ObtenerAlumnosInscriptos(Materia m) {  
        
        String sql = "SELECT * FROM alumno WHERE id_alumno IN(SELECT inscripcion.id_alumno FROM inscripcion NATURAL JOIN alumno WHERE id_materia = ?)";
        
        List<Alumno> listaAlumno = new ArrayList();
        
        try {
            PreparedStatement ps = conexionData.prepareStatement(sql);

            ps.setInt(1, m.getId_materia());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                
                Alumno a = new Alumno();

                a.setId_alumno(rs.getInt("id_alumno"));
                a.setDni(rs.getLong("DNI"));
                a.setApellido(rs.getString("apellido"));
                a.setNombre(rs.getString("nombre"));
                a.setDate(rs.getDate("fecha_nacimiento").toLocalDate());
                a.setEstado(rs.getBoolean("estado"));
             
                listaAlumno.add(a);
                
                }
                
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al obtener a los alumnos.");
        }
        
        return listaAlumno;
    }
     
     //Este se agrega para las vistas ListadoDeAlumnosxMateria
     public List<Inscripcion> listadoDeInscripcionesParaMateria(Materia m) {
         
     String sql = "SELECT * FROM inscripcion WHERE id_materia = ?";
     
     List<Inscripcion> listaInscripcion = new ArrayList<Inscripcion>();
     try {
         
        PreparedStatement ps = conexionData.prepareStatement(sql);
        ps.setInt(1, m.getId_materia());
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
        
                Inscripcion i = new Inscripcion();
                
                i.setAlumno(aData.buscarAlumnoPorID(rs.getInt("id_alumno")));
                i.setMateria(mData.buscarMateriaPorID(rs.getInt("id_materia")));
                i.setNota(rs.getDouble("nota"));
                i.setId_inscripcion(rs.getInt("id_inscripcion"));
                listaInscripcion.add(i);
                
                
                }
     
        ps.close();
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al listar las inscripciones. " + ex);
        }
     return listaInscripcion;
     }
    }
    