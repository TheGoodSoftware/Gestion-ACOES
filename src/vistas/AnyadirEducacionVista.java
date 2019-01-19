/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import principal.BD;
import modelos.*;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JTextField;

/**
 *
 * @author m1ndbl0w
 */
public class AnyadirEducacionVista extends javax.swing.JFrame {

    /**
     * Creates new form AnyadirEducacionVista
     */
    public AnyadirEducacionVista(){
        initComponents();
    }

    public AnyadirEducacionVista(Educacion ed){
        initComponents();
        this.fechaTexto.setText(ed.getFechaNacimiento().replaceAll("/", ""));
        this.nombreTexto.setText(ed.getNombre());
        this.apellidosTexto.setText(ed.getApellidos());
        this.cursoTexto.setText(ed.getCurso());
        this.notaTexto.setText(ed.getNotaMedia());
        this.observacionesTexto.setText(ed.getObservaciones());
    }

    public ArrayList<Object> getData() {
        ArrayList<Object> values = new ArrayList<Object>();
        values.add(nombreTexto.getText());
        values.add(apellidosTexto.getText());
        values.add(fechaTexto.getText());
        values.add(cursoTexto.getText());
        values.add(notaTexto.getText());
        values.add(observacionesTexto.getText());
        return values;
    }

    public void addControlador(ActionListener ctr) {
        cancelarBoton.addActionListener(ctr);
        cancelarBoton.setActionCommand("CANCELAR");
        confirmarBoton.addActionListener(ctr);
        confirmarBoton.setActionCommand("CONFIRMAR");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombreLabel = new javax.swing.JLabel();
        apellidosLabel = new javax.swing.JLabel();
        fechaLabel = new javax.swing.JLabel();
        cursoLabel = new javax.swing.JLabel();
        notaLabel = new javax.swing.JLabel();
        observacionesLabel = new javax.swing.JLabel();
        fechaTexto = new javax.swing.JFormattedTextField();
        nombreTexto = new javax.swing.JTextField();
        apellidosTexto = new javax.swing.JTextField();
        cursoTexto = new javax.swing.JTextField();
        notaTexto = new javax.swing.JTextField();
        observacionesTexto = new javax.swing.JTextField();
        confirmarBoton = new javax.swing.JButton();
        cancelarBoton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nombreLabel.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        nombreLabel.setText("Nombre (*)");

        apellidosLabel.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        apellidosLabel.setText("Apellidos (*)");

        fechaLabel.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        fechaLabel.setText("Fecha De Nacimiento (*)");

        cursoLabel.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cursoLabel.setText("Curso (*)");

        notaLabel.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        notaLabel.setText("Nota Media (*)");

        observacionesLabel.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        observacionesLabel.setText("Observaciones");

        cursoTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        confirmarBoton.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        confirmarBoton.setText("Confirmar");

        cancelarBoton.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cancelarBoton.setText("Cancelar");
        cancelarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fechaLabel)
                            .addComponent(apellidosLabel)
                            .addComponent(nombreLabel)
                            .addComponent(cursoLabel)
                            .addComponent(notaLabel)
                            .addComponent(observacionesLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nombreTexto)
                            .addComponent(notaTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(observacionesTexto, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                            .addComponent(apellidosTexto)
                            .addComponent(fechaTexto, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                            .addComponent(cursoTexto)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(confirmarBoton)
                        .addGap(18, 18, 18)
                        .addComponent(cancelarBoton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreLabel)
                    .addComponent(apellidosTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apellidosLabel)
                    .addComponent(nombreTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fechaLabel)
                    .addComponent(fechaTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cursoLabel)
                    .addComponent(cursoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(notaLabel)
                    .addComponent(notaTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(observacionesLabel)
                    .addComponent(observacionesTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmarBoton)
                    .addComponent(cancelarBoton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confirmarBoton;
    private javax.swing.JButton cancelarBoton;
    private javax.swing.JFormattedTextField fechaTexto;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JLabel apellidosLabel;
    private javax.swing.JLabel fechaLabel;
    private javax.swing.JLabel cursoLabel;
    private javax.swing.JLabel notaLabel;
    private javax.swing.JLabel observacionesLabel;
    private javax.swing.JTextField nombreTexto;
    private javax.swing.JTextField apellidosTexto;
    private javax.swing.JTextField cursoTexto;
    private javax.swing.JTextField notaTexto;
    private javax.swing.JTextField observacionesTexto;
    // End of variables declaration//GEN-END:variables
}
