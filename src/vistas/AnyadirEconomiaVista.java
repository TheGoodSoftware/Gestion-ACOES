package vistas;

import principal.BD;
import modelos.*;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jaysus
 */
public class AnyadirEconomiaVista extends javax.swing.JFrame {

    /**
     * Creates new form AnyadirEconomia
     */
	private GestionEconomica gestion;
	
    public AnyadirEconomiaVista(GestionEconomica gestion) {
    	this.gestion = gestion;
        try {
			initComponents();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public ArrayList<Object> getData() {
    	ArrayList<Object> values = new ArrayList<Object>();
    	values.add(cantidadTexto.getText());
    	values.add(monedaTipoBox.getSelectedItem());
    	values.add(descripcionTexto.getText());
    	values.add(tipoCombo.getSelectedItem());
    	values.add(procBenefTexto.getText());
    	values.add(fechaTexto.getText());
    	return values;
    }
    
    public void addControlador(controladores.AnyadirEconomiaControlador ctr) {
    	cancelarBoton.addActionListener(ctr);
    	cancelarBoton.setActionCommand("CANCELAR");
    	anyadirBoton.addActionListener(ctr);
    	anyadirBoton.setActionCommand("ANYADIR");
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     * @throws ParseException 
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() throws ParseException {

        cantidadLabel = new javax.swing.JLabel();
        monedaLabel = new javax.swing.JLabel();
        usuarioLabel = new javax.swing.JLabel();
        descripcionLabel = new javax.swing.JLabel();
        monedaTipoBox = new javax.swing.JComboBox<>();
        anyadirBoton = new javax.swing.JButton();
        cancelarBoton = new javax.swing.JButton();
        cantidadTexto = new javax.swing.JTextField();
        tipoCombo = new javax.swing.JComboBox<>();
        descripcionTexto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        procBenefTexto = new javax.swing.JTextField();
        fechaLabel = new javax.swing.JLabel();
        fechaTexto = new javax.swing.JFormattedTextField(new javax.swing.text.MaskFormatter("##/##/####"));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cantidadLabel.setText("Cantidad");

        monedaLabel.setText("Moneda");

        usuarioLabel.setText("Tipo");

        descripcionLabel.setText("Concepto");

        monedaTipoBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lempira", "Euro"}));

        anyadirBoton.setText("Añadir");

        cancelarBoton.setText("Cancelar");

        tipoCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ingreso", "Gasto" }));

        jLabel1.setText("Proc/Benef");

        fechaLabel.setText("Fecha (xx/xx/xxxx)");
        
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fechaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cantidadLabel)
                            .addComponent(monedaLabel)
                            .addComponent(usuarioLabel)
                            .addComponent(descripcionLabel)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tipoCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(descripcionTexto)
                            .addComponent(monedaTipoBox, 0, 222, Short.MAX_VALUE)
                            .addComponent(cantidadTexto)
                            .addComponent(procBenefTexto, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fechaTexto)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(cancelarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(anyadirBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cantidadLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cantidadTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(monedaTipoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monedaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuarioLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descripcionTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descripcionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(procBenefTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fechaTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(anyadirBoton)
                    .addComponent(cancelarBoton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    // Variables declaration - do not modify                     
    private javax.swing.JLabel cantidadLabel;
    private javax.swing.JTextField cantidadTexto;
    private javax.swing.JLabel descripcionLabel;
    private javax.swing.JTextField descripcionTexto;
    private javax.swing.JLabel fechaLabel;
    private javax.swing.JFormattedTextField fechaTexto;
    private javax.swing.JButton anyadirBoton;
    private javax.swing.JButton cancelarBoton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel monedaLabel;
    private javax.swing.JComboBox<String> monedaTipoBox;
    private javax.swing.JTextField procBenefTexto;
    private javax.swing.JComboBox<String> tipoCombo;
    private javax.swing.JLabel usuarioLabel;
    // End of variables declaration          
}
