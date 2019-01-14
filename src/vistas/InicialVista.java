package vistas;

import java.awt.event.ActionListener;

import modelos.Usuario;
import principal.BD;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jaysus
 */
public class InicialVista extends javax.swing.JPanel {

    /**
     * Creates new form VistaInicialACOES
     */
    public InicialVista(Usuario u) {
        initComponents();
        this.infoUsuarioLabel.setText(u.getNombreCompleto() + " - " + u.getRole().getNombre() + "(" + u.getRole().getPais()+")");
        int socios = new BD().getAllUsuarios().size();
        int ninos = new BD().getAllNinos().size();
        this.infoBDDLabel.setText("Actualmente tenemos un total de " + socios + " socios y damos ayudas a " + ninos + " niños");
        if(!(u.getRole().getNombre().equalsIgnoreCase("ECONOMIA") && u.getRole().getPais().equalsIgnoreCase("HONDURAS")))
        {
        	this.accionesQueRealizarLabel.setVisible(false);
        	this.mostrarAccionesBoton.setVisible(false);
        }
    }

    public void addControlador(ActionListener ctr) {
    	this.mostrarAccionesBoton.addActionListener(ctr);
    	this.mostrarAccionesBoton.setActionCommand("MOSTRAR_ACCIONES");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        mensajeBienvenida = new javax.swing.JLabel();
        infoUsuarioLabel = new javax.swing.JLabel();
        infoBDDLabel = new javax.swing.JLabel();
        seleccionaCategoriaLabel = new javax.swing.JLabel();
        mostrarAccionesBoton = new javax.swing.JButton();
        accionesQueRealizarLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        jCheckBox1.setText("jCheckBox1");

        setPreferredSize(new java.awt.Dimension(1000, 500));

        mensajeBienvenida.setFont(new java.awt.Font("Ubuntu", 0, 48)); // NOI18N
        mensajeBienvenida.setText("Bienvenido a GestionACOES");

        infoUsuarioLabel.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        infoUsuarioLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoUsuarioLabel.setText("Texto de ejemplo");

        infoBDDLabel.setText("Texto de ejemplo");

        seleccionaCategoriaLabel.setText("Seleccione una categoría para continuar");

        mostrarAccionesBoton.setForeground(new java.awt.Color(255, 0, 0));
        mostrarAccionesBoton.setText("Mostrar");

        accionesQueRealizarLabel.setForeground(new java.awt.Color(255, 0, 0));
        accionesQueRealizarLabel.setText("Tienes acciones que realizar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(infoUsuarioLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mensajeBienvenida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(182, 182, 182))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(infoBDDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 836, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(seleccionaCategoriaLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(accionesQueRealizarLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mostrarAccionesBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)))
                        .addGap(347, 347, 347))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(mensajeBienvenida)
                .addGap(18, 18, 18)
                .addComponent(infoUsuarioLabel)
                .addGap(29, 29, 29)
                .addComponent(seleccionaCategoriaLabel)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(accionesQueRealizarLabel)
                            .addComponent(mostrarAccionesBoton)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(infoBDDLabel)
                .addGap(62, 62, 62))
        );
    }// </editor-fold>                        


    // Variables declaration - do not modify                     
    private javax.swing.JLabel accionesQueRealizarLabel;
    private javax.swing.JLabel infoBDDLabel;
    private javax.swing.JLabel infoUsuarioLabel;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel mensajeBienvenida;
    private javax.swing.JButton mostrarAccionesBoton;
    private javax.swing.JLabel seleccionaCategoriaLabel;
    // End of variables declaration              
}
