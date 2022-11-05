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
import java.util.HashSet;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ezequ
 */
public class vistaNotas extends javax.swing.JInternalFrame {

    Connection conexiondb = Conexion.getConexion();
    MateriaData mData = new MateriaData(conexiondb);
    AlumnoData aData = new AlumnoData(conexiondb);
    InscripcionData iData = new InscripcionData(conexiondb);
    private DefaultTableModel modeloTabla;
    
    private HashSet<Alumno> listaAlumnos = new HashSet();
    private List<Materia> listaMaterias = new ArrayList();
    private List<Inscripcion> listaInscripciones = new ArrayList();
    private Alumno selecionado = new Alumno();
    //List<Inscripcion> listaInscripciones = new ArrayList<Inscripcion>();
    
    /**
     * Creates new form vistaNotas
     */
    public vistaNotas() {
        initComponents();
        modeloTabla = new DefaultTableModel();
        armarTabla();
        obtenerDatos();
        cargarAlumnosComboBox();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JLnombre = new javax.swing.JLabel();
        JCBnombre = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTtabla = new javax.swing.JTable();
        JBTNguardar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Carga de notas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Microsoft Tai Le", 1, 18))); // NOI18N

        JLnombre.setText("Nombre");

        JCBnombre.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JCBnombreItemStateChanged(evt);
            }
        });
        JCBnombre.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                JCBnombreCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                JCBnombreInputMethodTextChanged(evt);
            }
        });
        JCBnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBnombreActionPerformed(evt);
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
                "ID", "Materia", "Nota"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(JTtabla);

        JBTNguardar.setText("Guardar");
        JBTNguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBTNguardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JLnombre)
                        .addGap(18, 18, 18)
                        .addComponent(JCBnombre, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JBTNguardar)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLnombre)
                    .addComponent(JCBnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(152, 152, 152))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JBTNguardar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JCBnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBnombreActionPerformed

        modeloTabla.setNumRows(0);
       // double nota;
        if (JCBnombre.getSelectedIndex() != -1) {
           selecionado = (Alumno) JCBnombre.getSelectedItem();
        }
         
        for (Inscripcion aux : listaInscripciones) {
          System.out.println(aux.getAlumno() + " " + aux.getMateria() + " " + aux.getNota() );
        }
        
        for (Inscripcion aux : listaInscripciones) {
            if (selecionado.getId_alumno() == aux.getAlumno().getId_alumno()) {
                listaMaterias.add(aux.getMateria());
               // nota = aux.getNota();
                modeloTabla.addRow(new Object[]{aux.getMateria().getId_materia(), aux.getMateria().getNombre(), aux.getNota()});
            }
        }
        
    }//GEN-LAST:event_JCBnombreActionPerformed

    private void JCBnombreItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JCBnombreItemStateChanged
       //cargarAlumnosComboBox();
      
    }//GEN-LAST:event_JCBnombreItemStateChanged

    private void JBTNguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBTNguardarActionPerformed

        //  cargarAlumnosComboBox(); 
    }//GEN-LAST:event_JBTNguardarActionPerformed

    private void JCBnombreInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_JCBnombreInputMethodTextChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_JCBnombreInputMethodTextChanged

    private void JCBnombreCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_JCBnombreCaretPositionChanged
        // TODO add your handling code here:
       
          
    }//GEN-LAST:event_JCBnombreCaretPositionChanged

    private void cargarAlumnosComboBox() {
        
       
        
        JCBnombre.removeAllItems();
            for (Alumno aux : listaAlumnos) {
                JCBnombre.addItem(aux);
            }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBTNguardar;
    private javax.swing.JComboBox<Alumno> JCBnombre;
    private javax.swing.JLabel JLnombre;
    private javax.swing.JTable JTtabla;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void armarTabla() {
        ArrayList<Object> columnas = new ArrayList<Object>();
        columnas.add("Legajo");
        columnas.add("Materia");
        columnas.add("Nota");
        
        for (Object aux : columnas) {
            modeloTabla.addColumn(aux);
        }
        
        JTtabla.setModel(modeloTabla);
    }

    private void obtenerDatos() {
        listaInscripciones = iData.listadoDeInscripciones();
         
        for (Inscripcion aux : listaInscripciones) {
            listaAlumnos.add(aux.getAlumno());
        }
        for (Inscripcion aux : listaInscripciones) {
            listaMaterias.add(aux.getMateria());
        }
    }
}
