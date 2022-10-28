package com.mycompany.universidadg2.persistencia;

import com.mycompany.universidadg2.entidades.Alumno;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AlumnoData {

    

    private Connection conexionData;

    public AlumnoData(Connection connection) {
        this.conexionData = connection;//Conexion.getConexion();
    }

    public void guardarAlumno(Alumno a) {

        String query = "INSERT INTO alumno(DNI, apellido, nombre, fecha_nacimiento, estado) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexionData.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, a.getDni());
            ps.setString(2, a.getApellido());
            ps.setString(3, a.getNombre());
            ps.setDate(4, Date.valueOf(a.getDate()));
            ps.setBoolean(5, a.isEstado());
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Alumno agregado");
            } else {
                JOptionPane.showMessageDialog(null, "Alumno no agregado");
            }
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                a.setId_alumno(rs.getInt(1));
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo obtener ID");
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se produjo un error. en agregar alumno");
        }

    }

    public Alumno buscarAlumnoPorID(int id) {
        Alumno a = null;
        String sql = "SELECT * FROM alumno WHERE id_alumno = ?";
        try {
            PreparedStatement ps = conexionData.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                a = new Alumno();
                a.setId_alumno(rs.getInt("id_alumno"));
                a.setDni(rs.getLong("DNI"));
                a.setApellido(rs.getString("apellido"));
                a.setNombre(rs.getString("nombre"));
                a.setDate(rs.getDate("fecha_nacimiento").toLocalDate());
                a.setEstado(rs.getBoolean("estado"));
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se produjo un error. en buscar alumno por id.");
        }
        if (a == null) {
            JOptionPane.showMessageDialog(null, "No se pudo buscar por id porque no existe un alumno con ese id.");
        }
        return a;
    }

    public void actualizarAlumno(Alumno a) {
        String sqlQuery = "UPDATE alumno SET DNI= ? ,apellido= ? ,nombre= ? ,fecha_nacimiento= ?, estado= ? WHERE id_alumno = ?";
            if (buscarAlumnoPorID(a.getId_alumno()) != null) {
            try {
            PreparedStatement ps = conexionData.prepareStatement(sqlQuery);
            ps.setLong(1, a.getDni());
            ps.setString(2, a.getApellido());
            ps.setString(3, a.getNombre());
            ps.setDate(4, Date.valueOf(a.getDate()));
            ps.setBoolean(5, a.isEstado());
            ps.setInt(6, a.getId_alumno());
           
            if (ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Se pudo actualizar al alumno.");
            } else  {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar al alumno.");
            }
            
            ps.close();
            
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se produjo un error. en agregar alumno");
        }  
            }
            
        }

    

    public ArrayList<Alumno> listarAlumnos() {

        ArrayList<Alumno> lista = new ArrayList();

        String sql = "SELECT * FROM alumno WHERE estado = 1";

        try {
            PreparedStatement ps = conexionData.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Alumno a = new Alumno();

                a.setId_alumno(rs.getInt("id_alumno"));
                a.setDni(rs.getInt("DNI"));
                a.setApellido(rs.getString("apellido"));
                a.setNombre(rs.getString("nombre"));
                a.setDate(rs.getDate("fecha_nacimiento").toLocalDate());
                a.setEstado(rs.getBoolean("estado"));

                lista.add(a);
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al obtener a los alumnos");
        }
        return lista;
    }
  
    public void borrarAlumno (int id){
        String sql="UPDATE alumno SET estado=0 WHERE id_alumno = ?";
        try {
            PreparedStatement ps=conexionData.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            
            if (ps.executeUpdate() <= 0) {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el alumno");
            } else  {   
                JOptionPane.showMessageDialog(null, "Se elimino el alumno correctamente");
            }
         
            ps.close();
            
    }   catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ALumnoData Sentencia SQL erronea-borrarAlumno");
        }
    }
      
       
    }


