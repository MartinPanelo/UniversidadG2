/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mycompany.universidadg2.vistas;

import com.mycompany.universidadg2.entidades.Alumno;
import com.mycompany.universidadg2.entidades.Inscripcion;
import com.mycompany.universidadg2.entidades.Materia;
import com.mycompany.universidadg2.persistencia.AlumnoData;
import com.mycompany.universidadg2.persistencia.Conexion;
import com.mycompany.universidadg2.persistencia.InscripcionData;
import com.mycompany.universidadg2.persistencia.MateriaData;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ezequ
 */
public class vistaInscripcion extends javax.swing.JInternalFrame {

    Connection conexiondb = Conexion.getConexion();
    MateriaData mData = new MateriaData(conexiondb);
    AlumnoData aData = new AlumnoData(conexiondb);
    InscripcionData iData = new InscripcionData(conexiondb);
    
    private DefaultTableModel modeloDeTabla;
    /**
     * Creates new form vistaInscripcion
     */
    ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
    List<Materia> listaMaterias = new ArrayList<Materia>();
    
    public vistaInscripcion() {
        initComponents();
        cargarAlumnosComboBox();
        modeloDeTabla = new DefaultTableModel();
        armarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        JPvistaInscripcion = new javax.swing.JPanel();
        JLalumno = new javax.swing.JLabel();
        JCBalumno = new javax.swing.JComboBox<>();
        JLlistadodemateria = new javax.swing.JLabel();
        JRBinscriptas = new javax.swing.JRadioButton();
        JRBno_inscriptas = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTtabla = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        JBTNinscribir = new javax.swing.JButton();
        JBTNanular = new javax.swing.JButton();

        setClosable(true);

        JPvistaInscripcion.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Formulario de inscripciones", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Microsoft Tai Le", 1, 18))); // NOI18N

        JLalumno.setText("Alumno");

        JCBalumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBalumnoActionPerformed(evt);
            }
        });

        JLlistadodemateria.setText("Listado de materias");

        buttonGroup1.add(JRBinscriptas);
        JRBinscriptas.setText("Inscriptas");
        JRBinscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRBinscriptasActionPerformed(evt);
            }
        });

        buttonGroup1.add(JRBno_inscriptas);
        JRBno_inscriptas.setText("No inscriptas");
        JRBno_inscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRBno_inscriptasActionPerformed(evt);
            }
        });

        JTtabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Año"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(JTtabla);

        JBTNinscribir.setText("Inscribir");
        JBTNinscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNinscribirActionPerformed(evt);
            }
        });

        JBTNanular.setText("Anular");
        JBTNanular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNanularActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPvistaInscripcionLayout = new javax.swing.GroupLayout(JPvistaInscripcion);
        JPvistaInscripcion.setLayout(JPvistaInscripcionLayout);
        JPvistaInscripcionLayout.setHorizontalGroup(
            JPvistaInscripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPvistaInscripcionLayout.createSequentialGroup()
                .addGroup(JPvistaInscripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JPvistaInscripcionLayout.createSequentialGroup()
                        .addGroup(JPvistaInscripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(JPvistaInscripcionLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(JPvistaInscripcionLayout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(JBTNinscribir)
                                .addGap(79, 79, 79)
                                .addComponent(JBTNanular))
                            .addGroup(JPvistaInscripcionLayout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addGroup(JPvistaInscripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(JPvistaInscripcionLayout.createSequentialGroup()
                                        .addComponent(JRBinscriptas)
                                        .addGap(30, 30, 30)
                                        .addComponent(JRBno_inscriptas))
                                    .addGroup(JPvistaInscripcionLayout.createSequentialGroup()
                                        .addComponent(JLalumno)
                                        .addGap(18, 18, 18)
                                        .addComponent(JCBalumno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(JPvistaInscripcionLayout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(JLlistadodemateria)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JPvistaInscripcionLayout.setVerticalGroup(
            JPvistaInscripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPvistaInscripcionLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(JPvistaInscripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLalumno)
                    .addComponent(JCBalumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(JLlistadodemateria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPvistaInscripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JRBinscriptas)
                    .addComponent(JRBno_inscriptas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPvistaInscripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNinscribir)
                    .addComponent(JBTNanular))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPvistaInscripcion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JPvistaInscripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JRBinscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRBinscriptasActionPerformed
        JBTNanular.setEnabled(true);
        JBTNinscribir.setEnabled(false);
        cargarMateriasEnLasQueElAlumnoInscriptos();
    }//GEN-LAST:event_JRBinscriptasActionPerformed

    private void JRBno_inscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRBno_inscriptasActionPerformed
        JBTNanular.setEnabled(false);
        JBTNinscribir.setEnabled(true);
        cargarMateriasEnLasQueElAlumnoNoEsteInscripto();
    }//GEN-LAST:event_JRBno_inscriptasActionPerformed

    private void JCBalumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBalumnoActionPerformed
       if(JCBalumno.getSelectedItem() != null){
           if(JRBinscriptas.isSelected()){
               cargarMateriasEnLasQueElAlumnoInscriptos();
           }
           if(JRBno_inscriptas.isSelected()){
               cargarMateriasEnLasQueElAlumnoNoEsteInscripto();
           }
       }
    }//GEN-LAST:event_JCBalumnoActionPerformed

    private void JBTNinscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNinscribirActionPerformed
        int filaSelecionada = JTtabla.getSelectedRow();
        Alumno selecionado = (Alumno) JCBalumno.getSelectedItem();
        Materia materiaSelecionada = new Materia();
        if (filaSelecionada != -1 && selecionado != null) {
            materiaSelecionada.setAnio((Integer) JTtabla.getValueAt(filaSelecionada, 2));
            materiaSelecionada.setNombre((String.valueOf(JTtabla.getValueAt(filaSelecionada, 1))));
            materiaSelecionada.setId_materia((Integer) JTtabla.getValueAt(filaSelecionada, 0));
            Inscripcion i = new Inscripcion(selecionado, materiaSelecionada, -1);
            iData.guardarInscripcion(i);
        }
    }//GEN-LAST:event_JBTNinscribirActionPerformed

    private void JBTNanularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNanularActionPerformed
        int filaSelecionada = JTtabla.getSelectedRow();
        Alumno selecionado = (Alumno) JCBalumno.getSelectedItem();
        Materia materiaSelecionada = new Materia();
        if (filaSelecionada != -1 && selecionado != null) {
            materiaSelecionada.setId_materia((Integer) JTtabla.getValueAt(filaSelecionada, 0));
            Inscripcion i = new Inscripcion(selecionado, materiaSelecionada, -1);
            iData.borrarInscripcion(selecionado.getId_alumno(), materiaSelecionada.getId_materia());
        }
    }//GEN-LAST:event_JBTNanularActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBTNanular;
    private javax.swing.JButton JBTNinscribir;
    private javax.swing.JComboBox<Alumno> JCBalumno;
    private javax.swing.JLabel JLalumno;
    private javax.swing.JLabel JLlistadodemateria;
    private javax.swing.JPanel JPvistaInscripcion;
    private javax.swing.JRadioButton JRBinscriptas;
    private javax.swing.JRadioButton JRBno_inscriptas;
    private javax.swing.JTable JTtabla;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

    public void cargarAlumnosComboBox() {
        listaAlumnos = aData.listarAlumnos();
        for (Alumno aux : listaAlumnos) {
            JCBalumno.addItem(aux);
        }
    }

    private void armarTabla() {
        ArrayList<Object> columnas = new ArrayList();
        columnas.add("Legajo");
        columnas.add("Nombre");
        columnas.add("Año");
        for (Object aux : columnas) {
            modeloDeTabla.addColumn(aux);
        }
        JTtabla.setModel(modeloDeTabla);
    }

    private void cargarMateriasEnLasQueElAlumnoInscriptos() {
        modeloDeTabla.setNumRows(0);
        Alumno elegido = (Alumno) JCBalumno.getSelectedItem();
        listaMaterias = iData.obtenerMateriasInscriptas(elegido);
        for (Materia aux : listaMaterias) {
            modeloDeTabla.addRow(new Object[]{aux.getId_materia(), aux.getNombre(), aux.getAnio()});
        }
    }

    private void cargarMateriasEnLasQueElAlumnoNoEsteInscripto() {
        modeloDeTabla.setNumRows(0);
        Alumno elegido = (Alumno) JCBalumno.getSelectedItem();
        listaMaterias = iData.obtenerMateriasNoInscriptas(elegido);
        for (Materia aux : listaMaterias) {
            modeloDeTabla.addRow(new Object[]{aux.getId_materia(), aux.getNombre(), aux.getAnio()});
        }
    }
}
