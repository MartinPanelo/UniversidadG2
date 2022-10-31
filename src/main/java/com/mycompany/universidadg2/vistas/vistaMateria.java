/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mycompany.universidadg2.vistas;

/**
 *
 * @author ezequ
 */
public class vistaMateria extends javax.swing.JInternalFrame {

    /**
     * Creates new form vistaMateria
     */
    public vistaMateria() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPvistaMateria = new javax.swing.JPanel();
        JLid = new javax.swing.JLabel();
        JLnombre = new javax.swing.JLabel();
        JLanio = new javax.swing.JLabel();
        JTFid = new javax.swing.JTextField();
        JTFnombre = new javax.swing.JTextField();
        JLestado = new javax.swing.JLabel();
        JTFanio = new javax.swing.JTextField();
        JCestado = new javax.swing.JCheckBox();
        JBTNbuscar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        JBTNguardar = new javax.swing.JButton();
        JBTNlimpiar = new javax.swing.JButton();
        JBTNborrar = new javax.swing.JButton();
        JBTNactualizar = new javax.swing.JButton();

        setClosable(true);

        JPvistaMateria.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Formulario de materias", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Microsoft Tai Le", 1, 18))); // NOI18N

        JLid.setText("ID");

        JLnombre.setText("Nombre");

        JLanio.setText("Año");

        JLestado.setText("Estado");

        JTFanio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFanioActionPerformed(evt);
            }
        });

        JBTNbuscar.setText("Buscar");

        JBTNguardar.setText("Guardar");

        JBTNlimpiar.setText("Limpiar");

        JBTNborrar.setText("Borrar");

        JBTNactualizar.setText("Actualizar");

        javax.swing.GroupLayout JPvistaMateriaLayout = new javax.swing.GroupLayout(JPvistaMateria);
        JPvistaMateria.setLayout(JPvistaMateriaLayout);
        JPvistaMateriaLayout.setHorizontalGroup(
            JPvistaMateriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPvistaMateriaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPvistaMateriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPvistaMateriaLayout.createSequentialGroup()
                        .addComponent(JLnombre)
                        .addGap(18, 18, 18)
                        .addComponent(JTFnombre))
                    .addGroup(JPvistaMateriaLayout.createSequentialGroup()
                        .addComponent(JLid)
                        .addGap(49, 49, 49)
                        .addComponent(JTFid))
                    .addGroup(JPvistaMateriaLayout.createSequentialGroup()
                        .addGroup(JPvistaMateriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLestado)
                            .addComponent(JLanio))
                        .addGroup(JPvistaMateriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JPvistaMateriaLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(JTFanio))
                            .addGroup(JPvistaMateriaLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JCestado)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JBTNbuscar)
                .addGap(82, 82, 82))
            .addGroup(JPvistaMateriaLayout.createSequentialGroup()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(JPvistaMateriaLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(JBTNguardar)
                .addGap(18, 18, 18)
                .addComponent(JBTNlimpiar)
                .addGap(18, 18, 18)
                .addComponent(JBTNborrar)
                .addGap(18, 18, 18)
                .addComponent(JBTNactualizar)
                .addContainerGap(80, Short.MAX_VALUE))
        );
        JPvistaMateriaLayout.setVerticalGroup(
            JPvistaMateriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPvistaMateriaLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(JPvistaMateriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLid)
                    .addComponent(JTFid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBTNbuscar))
                .addGap(18, 18, 18)
                .addGroup(JPvistaMateriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLnombre)
                    .addComponent(JTFnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(JPvistaMateriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLanio)
                    .addComponent(JTFanio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(JPvistaMateriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLestado)
                    .addComponent(JCestado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPvistaMateriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBTNguardar)
                    .addGroup(JPvistaMateriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JBTNlimpiar)
                        .addComponent(JBTNborrar)
                        .addComponent(JBTNactualizar)))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JPvistaMateria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(JPvistaMateria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTFanioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFanioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFanioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBTNactualizar;
    private javax.swing.JButton JBTNborrar;
    private javax.swing.JButton JBTNbuscar;
    private javax.swing.JButton JBTNguardar;
    private javax.swing.JButton JBTNlimpiar;
    private javax.swing.JCheckBox JCestado;
    private javax.swing.JLabel JLanio;
    private javax.swing.JLabel JLestado;
    private javax.swing.JLabel JLid;
    private javax.swing.JLabel JLnombre;
    private javax.swing.JPanel JPvistaMateria;
    private javax.swing.JTextField JTFanio;
    private javax.swing.JTextField JTFid;
    private javax.swing.JTextField JTFnombre;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
