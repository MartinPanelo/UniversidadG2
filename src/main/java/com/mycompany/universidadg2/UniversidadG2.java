/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.universidadg2;

import com.mycompany.universidadg2.entidades.Alumno;
import com.mycompany.universidadg2.persistencia.AlumnoData;
import com.mycompany.universidadg2.persistencia.Conexion;
import com.mycompany.universidadg2.persistencia.miConexion;
import java.sql.Connection;
import java.time.LocalDate;

/**
 *
 * @author martin
 */
public class UniversidadG2 {

    public static void main(String[] args) {
        
        Connection conexiondb = Conexion.getConexion();        
        AlumnoData alu = new AlumnoData(conexiondb);
        
        
        // BUSCAR UN ALUMNO
        System.out.println(alu.buscarAlumnoPorID(2));
        
      
        // GUARDAR UN ALUMNO
       
       Alumno aluGuardado = new Alumno(454545, "Mcwin", "Rayo",LocalDate.now() , true);
       alu.guardarAlumno(aluGuardado);
       
       
       
    }
}
