package com.mycompany.universidadg2.entidades;

import java.time.LocalDate;

public class Alumno {
    private int id_alumno;
    private long dni;
    private String apellido;
    private String nombre;
    private LocalDate date;
    private boolean estado;

    public Alumno() {
    }

    public Alumno(int id_alumno, long dni, String apellido, String nombre, LocalDate date, boolean estado) {
        this.id_alumno = id_alumno;
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.date = date;
        this.estado = estado;
    }

    public Alumno(long dni, String apellido, String nombre, LocalDate date, boolean estado) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.date = date;
        this.estado = estado;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return apellido + " " + nombre + ", DNI: " + dni;
        //return "Alumno{" + "id_alumno=" + id_alumno + ", dni=" + dni + ", apellido=" + apellido + ", nombre=" + nombre + ", date=" + date + ", estado=" + estado + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.id_alumno;
        hash = 67 * hash + (int) (this.dni ^ (this.dni >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alumno other = (Alumno) obj;
        if (this.id_alumno != other.id_alumno) {
            return false;
        }
        return this.dni == other.dni;
    }
    
    
    
    
    
}
