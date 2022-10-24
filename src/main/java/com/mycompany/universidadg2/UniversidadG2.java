/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.universidadg2;

import com.mycompany.universidadg2.entidades.Alumno;
import com.mycompany.universidadg2.entidades.Inscripcion;
import com.mycompany.universidadg2.entidades.Materia;
import com.mycompany.universidadg2.persistencia.AlumnoData;
import com.mycompany.universidadg2.persistencia.Conexion;
import com.mycompany.universidadg2.persistencia.InscripcionData;
import com.mycompany.universidadg2.persistencia.MateriaData;
import java.sql.Connection;
import java.time.LocalDate;

/**
 *
 * @author martin
 */
public class UniversidadG2 {

    public static void main(String[] args) {
        
        Connection conexiondb = Conexion.getConexion();        
        
          // CONEXION A ALUMNO
          AlumnoData aData = new AlumnoData(conexiondb);
          
//        // BUSCAR UN ALUMNO
//        System.out.println(alu.buscarAlumnoPorID(2));
//        
//        // GUARDAR UN ALUMNO
//       
//       Alumno aluGuardado = new Alumno(454545, "Mcwin", "Rayo",LocalDate.now() , true);
//       alu.guardarAlumno(aluGuardado);
//       
//       // LISTAR ALUMNOS
//       
//        System.out.println(alu.listarAlumnos());
//        
//       // ACTUALIZAR UN ALUMNO // el id viene dentro del alumno
//       Alumno aluActualizado = new Alumno(99999, "Zapallo", "Coreano",LocalDate.now() , true);
//       alu.actualizarAlumno(aluActualizado);
//       
//       
//       // BORRAR ALUMNO POR ID       
//       alu.borrarAlumno(12);

         // CONEXION A MATERIA
         MateriaData mData = new MateriaData(conexiondb);
//       
//       //AGREGAR MATERIA
//       Materia matAgregar = new Materia("Matematica", 1, true);
//       mData.agregarMateria(matAgregar);
//       
//       // BUSCAR UNA MATERIA POR ID
//        System.out.println(mData.buscarMateriaPorID(4));
//        
//       // ACTUALIZAR UNA MATERIA
//       Materia mat2Agregar = new Materia(4, "Frances", 1, true);
//       mData.actualizarMateria(mat2Agregar);
//       
//       // LISTAR MATERIAS
//       System.out.println(mData.listarMaterias());
//       
//       // BORRAR MATERIAS
//       mData.borrarMateria(4);

         // CONEXION A INSCRIPCION
         InscripcionData iData = new InscripcionData(conexiondb);

         // GUARDAR INSCRIPCION
//         Materia mateAgregar = mData.buscarMateriaPorID(3);
//         Alumno alumGuardado = aData.buscarAlumnoPorID(2);
//         
//         Inscripcion in = new Inscripcion(alumGuardado, mateAgregar, 8);
//         iData.guardarInscripcion(in);

        // OBTENER INSCRIPCION
//         System.out.println(iData.obtenerInscripcion(2, 2));

        // ELIMINAR INSCRIPCION
           iData.borrarInscripcion(3, 3);
           
       
       
//1 InscribirAlumnos - Alumno, Materia, Nota;
//2 ActualizarNota
//3 ObtenerInscripcionPorId
//4 ObtenerTodasLasIncripciones
//5 BorrarInscripcion
//6 Dado Un Alumno Devuelva Las Materias Inscriptas
//7 Dado un alumno devuelva las materias en donde no esta inscripto
       
       
    }
}
