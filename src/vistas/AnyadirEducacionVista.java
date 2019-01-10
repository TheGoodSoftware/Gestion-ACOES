package vistas;

import principal.BD;
import modelos.*;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author m1ndbl0w
 */
public class AnyadirEducacionVista extends javax.swing.JFrame {

    /**
     * Creates new form AnyadirEducacion
     */
    private GestionAcademica gestion;

    public AnyadirEducacionVista(GestionAcademica gestion) {
        this.gestion = gestion;
        initComponents();
    }

    public ArrayList<Object> getData() {
        ArrayList<Object> values = new ArrayList<Object>();
        values.add(edadTexto.getText());
        values.add(notaMedia.getText());
        values.add(nombreTexto.getText());
        //values.add(new BD().getAllNinos().get(ninoTexto.getSelectedIndex()).getID());
        values.add(cursoTexto.getText());
        return values;
    }

    public void addControlador(controladores.AnyadirEducacionControlador ctr) {
        cancelarBoton.addActionListener(ctr);
        cancelarBoton.setActionCommand("CANCELAR");
        anyadirBoton.addActionListener(ctr);
        anyadirBoton.setActionCommand("ANYADIR");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        edadLabel = new javax.swing.JLabel();
        notaMediaLabel = new javax.swing.JLabel();
        //ninoLabel = new javax.swing.JLabel();
        apellidosTexto = new javax.swing.JLabel();
        notaMedia = new javax.swing.JTextField();
        anyadirBoton = new javax.swing.JButton();
        cancelarBoton = new javax.swing.JButton();
        nombreTexto = new javax.swing.JTextField();
        edadTexto = new javax.swing.JTextField();
        //ninoTexto = new javax.swing.JComboBox<>();
        cursoLabel = new javax.swing.JLabel();
        cursoTexto = new javax.swing.JTextField();

        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        //ninoTexto.setModel(new javax.swing.DefaultComboBoxModel<Object>(
                //(Object[]) new BD().getAllNinos().stream().map(u -> u.getNombreCompleto()).toArray()
        //));
        edadLabel.setText("Edad");

        notaMediaLabel.setText("Nota Media");

        //ninoLabel.setText("Niño");

        apellidosTexto.setText("Apellidos");

        anyadirBoton.setText("Añadir");

        cancelarBoton.setText("Cancelar");

        cursoLabel.setText("Curso");
        

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(cancelarBoton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(anyadirBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(edadLabel)
                                                                                .addComponent(notaMediaLabel)
                                                                                .addComponent(apellidosTexto)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                .addComponent(cursoLabel)
                                                                .addGap(64, 64, 64)))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(nombreTexto)
                                                        .addComponent(notaMedia, 0, 227, Short.MAX_VALUE)
                                                        .addComponent(edadTexto)
                                                        .addComponent(cursoTexto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                                )))));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addComponent(edadTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(edadLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(notaMedia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(notaMediaLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cursoLabel)
                                        .addComponent(cursoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(apellidosTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nombreTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(anyadirBoton)
                                        .addComponent(cancelarBoton))
                                .addContainerGap())
        );

        pack();
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel edadLabel;
    private javax.swing.JTextField edadTexto;
    private javax.swing.JLabel apellidosTexto;
    private javax.swing.JTextField nombreTexto;
    private javax.swing.JButton anyadirBoton;
    private javax.swing.JButton cancelarBoton;
    private javax.swing.JLabel notaMediaLabel;
    private javax.swing.JLabel cursoLabel;
    private javax.swing.JTextField notaMedia;
    private javax.swing.JTextField cursoTexto;
    //private javax.swing.JLabel ninoLabel;
    //private javax.swing.JComboBox<Object> ninoTexto;
    // End of variables declaration
}