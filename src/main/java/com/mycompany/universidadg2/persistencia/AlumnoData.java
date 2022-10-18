
package com.mycompany.universidadg2.persistencia;

import com.mycompany.universidadg2.entidades.Alumno;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class AlumnoData {
    
    private Connection conexionData = null;

    public AlumnoData(miConexion con) {
        this.conexionData = con.buscarConexion();
    }
    
    public void guardarAlumno(Alumno a){
        String query = "INSERT INTO alumno(DNI, apellido, nombre, fecha_nacimiento, estado) VALUES (?,?,?,?,?)";
        try{
            PreparedStatement ps = conexionData.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, a.getDni());
            ps.setString(2,a.getApellido());
            ps.setString(3, a.getNombre());
            ps.setDate(4, Date.valueOf(a.getDate()));
            ps.setBoolean(5,a.isEstado()); //REVISAR TIPOS (TINY INT / BOOLEAN)//
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                a.setId_alumno(rs.getInt(1));
            }
            else{
                System.out.println("No se pudo obtener ID");
                ps.close();
            }
        }catch{
        
    }
    
    
    
    
    
    
}
