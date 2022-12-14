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
        
         //CONEXION A ALUMNO
        AlumnoData aData = new AlumnoData(conexiondb);
        
        // GUARDAR UN ALUMNO
        Alumno aluGuardado = new Alumno(454545, "Mcwin", "Rayo", LocalDate.of(2000, 05, 17), true);
        aData.guardarAlumno(aluGuardado);

//      // BUSCAR UN ALUMNO
        System.out.println("\nBuscar un alumno:\n");
        System.out.println(aData.buscarAlumnoPorID(2));
//        
//       
//       //LISTAR ALUMNOS
        System.out.println("\nMostrar todos los alumnos registrados:\n");
        System.out.println(aData.listarAlumnos());
//        
//       // ACTUALIZAR UN ALUMNO // el id viene dentro del alumno
        Alumno aluActualizado = aData.buscarAlumnoPorID(2);// Busco un alumno de la base de datos
        aluActualizado.setApellido("Tellieri"); // Actualizamos apellido
        aData.actualizarAlumno(aluActualizado);
//       
//       
//       // BORRAR ALUMNO POR ID
        aData.borrarAlumno(3);

        // CONEXION A MATERIA
        MateriaData mData = new MateriaData(conexiondb);
        
//       //AGREGAR MATERIA
        Materia matAgregar = new Materia("Cs.sociales", 2, true);
        mData.agregarMateria(matAgregar);
//       
        System.out.println("\nBuscar una materia por su id:\n");
//       // BUSCAR UNA MATERIA POR ID
        System.out.println(mData.buscarMateriaPorID(4));
        
        System.out.println("\nListar todas las materias registradas:\n");
        // LISTAR MATERIAS
        System.out.println(mData.listarMaterias());
//        
//       // ACTUALIZAR UNA MATERIA
        Materia mat2Agregar = mData.buscarMateriaPorID(4);
        mat2Agregar.setAnio(2); // Actualizamos a??o de la materia;
        mData.actualizarMateria(mat2Agregar);
//       
//       // BORRAR MATERIAS
        mData.borrarMateria(4);

         //CONEXION A INSCRIPCION
        InscripcionData iData = new InscripcionData(conexiondb);

        // GUARDAR INSCRIPCION
        Materia mateAgregar = mData.buscarMateriaPorID(3);
        Alumno alumGuardado = aData.buscarAlumnoPorID(2);
         
        Inscripcion in = new Inscripcion(alumGuardado, mateAgregar, 8);
        iData.guardarInscripcion(in);

        System.out.println("\nObtener una inscripcion:\n");
        // OBTENER INSCRIPCION
        System.out.println(iData.obtenerInscripcion(2, 2));

         //ELIMINAR INSCRIPCION
        iData.borrarInscripcion(3, 3);

        // ACTUALIZAR NOTA
        iData.actualizarNota(1, 1, 6.5);

        System.out.println("\nObtener lista de materias a la que esta inscripto un alumno:\n");
        // OBTENER LISTA DE MATERIAS INSCRIPTAS POR ALUMNO
        Alumno prueba1 = aData.buscarAlumnoPorID(3);
        System.out.println(iData.obtenerMateriasInscriptas(prueba1));

        System.out.println("\nObtener lista de materias en las que no esta inscripto un alumno:\n");
        // OBTENER LISTA DE MATERIAS NO INSCRIPTAS POR ALUMNO
        Alumno prueba2 = aData.buscarAlumnoPorID(3);
        System.out.println(iData.obtenerMateriasNoInscriptas(prueba2));

        System.out.println("\nObtener lista de alumnos en los que esten inscriptos a una materia:\n");
        // OBTENER LISTA DE MATERIAS INSCRIPTAS POR ALUMNO
        Materia prueba3 = mData.buscarMateriaPorID(2);
        System.out.println(iData.ObtenerAlumnosInscriptos(prueba3));

    }
}
