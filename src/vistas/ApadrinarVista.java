package vistas;

import java.awt.Color;
import java.util.List;

import javax.swing.JList;
import javax.swing.ListModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cherra
 */
public class ApadrinarVista extends javax.swing.JFrame {

    /**
     * Creates new form ApadrinarVista
     */
    public ApadrinarVista() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        panelListaSocios = new javax.swing.JScrollPane();
        listaSocios = new javax.swing.JList<>();
        panelListaNinos = new javax.swing.JScrollPane();
        listaNinos = new javax.swing.JList<>();
        textoSocios = new javax.swing.JLabel();
        textoNinos = new javax.swing.JLabel();
        textoGestionApadrinamientos = new javax.swing.JLabel();
        botonApadrinar = new javax.swing.JButton();
        botonDesapadrinar = new javax.swing.JButton();
        textoMensaje = new javax.swing.JLabel();
        campoBusquedaNino = new javax.swing.JTextField();
        campoBusquedaSocio = new javax.swing.JTextField();
        botonAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listaSocios.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        panelListaSocios.setViewportView(listaSocios);

        listaNinos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        panelListaNinos.setViewportView(listaNinos);

        textoSocios.setText("Socios");

        textoNinos.setText("Niños");

        textoGestionApadrinamientos.setText("Gestión de apadrinamientos");

        botonApadrinar.setText("Apadrinar");
        

        botonDesapadrinar.setText("Desapadrinar");


        textoMensaje.setText("");

        campoBusquedaNino.setText("");

        campoBusquedaSocio.setText("");


        botonAtras.setText("Atras");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelListaSocios, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(textoSocios))
                            .addComponent(campoBusquedaSocio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botonApadrinar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonDesapadrinar, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textoGestionApadrinamientos)
                        .addGap(52, 52, 52)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelListaNinos, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(campoBusquedaNino, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(textoNinos)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonAtras)
                        .addGap(25, 25, 25))))
            .addGroup(layout.createSequentialGroup()
                .addGap(291, 291, 291)
                .addComponent(textoMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textoGestionApadrinamientos)
                        .addComponent(botonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoSocios, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textoNinos, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(campoBusquedaNino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoBusquedaSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(panelListaNinos, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                                    .addComponent(panelListaSocios, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(botonApadrinar)
                                .addGap(39, 39, 39)
                                .addComponent(botonDesapadrinar)))
                        .addGap(12, 12, 12)
                        .addComponent(textoMensaje)))
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>                        

    public void controlador(controladores.ApadrinarControlador ctr) {
    	botonApadrinar.addActionListener(ctr);
    	botonApadrinar.setActionCommand("APADRINAR");
    	botonDesapadrinar.addActionListener(ctr);
    	botonDesapadrinar.setActionCommand("DESAPADRINAR");
    	campoBusquedaNino.addActionListener(ctr);
    	campoBusquedaNino.setActionCommand("FILTRARNINO");
    	campoBusquedaSocio.addActionListener(ctr);
    	campoBusquedaSocio.setActionCommand("FILTRARSOCIO");
    	botonAtras.addActionListener(ctr);
    	botonAtras.setActionCommand("ATRAS");
    }
    
    public void actualizarNino(String[] ninos) {
    	listaNinos.setListData(ninos);
    }
    
    public void actualizarSocio(String[] socios) {
    	listaSocios.setListData(socios);
    	
    }
    
    public int getNinoSeleccionado() {
    	String nino = listaNinos.getSelectedValue();
    	String[] partes = nino.split(" ");
    	return Integer.parseInt(partes[0]);
    }
    
    public int getSocioSeleccionado() {
    	String socio = listaSocios.getSelectedValue();
    	String[] partes = socio.split(" ");
    	return Integer.parseInt(partes[0]);
    }
    
    public void setMensajeExito(String msj) {
    	textoMensaje.setText(msj);
    	textoMensaje.setForeground(Color.GREEN);
    }
    
    public void setMensajeError(String msj) {
    	textoMensaje.setText(msj);
    	textoMensaje.setForeground(Color.RED);
    }
    public void actualizarBotonApadrinar(String msj) {
    	botonApadrinar.setText(msj);
    }
    
    public void actualizarBotonDesapadrinar(String msj) {
    	botonDesapadrinar.setText(msj);
    }
    
    public void deshabilitarApadrinar() {
    	botonApadrinar.setEnabled(false);
    }
    
    public void deshabilitarDesapadrinar() {
    	botonDesapadrinar.setEnabled(false);
    }
    
    public void habilitarApadrinar() {
    	botonApadrinar.setEnabled(true);
    }
    
    public void habilitarDesapadrinar() {
    	botonDesapadrinar.setEnabled(true);
    
    }
    
    public void deshabilitarCamposTexto() {
    	campoBusquedaNino.setEnabled(false);
    	campoBusquedaSocio.setEnabled(false);
    	campoBusquedaNino.setEditable(false);
    	campoBusquedaSocio.setEditable(false);
    }
    public void habilitarCamposTexto() {
    	campoBusquedaNino.setEnabled(true);
    	campoBusquedaSocio.setEnabled(true);
    	campoBusquedaNino.setEditable(true);
    	campoBusquedaSocio.setEditable(true);
    }
    
    public String getFiltroSocio() {
    	return campoBusquedaSocio.getText();
    }
    
    public String getFiltroNino() {
    	return campoBusquedaNino.getText();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ApadrinarVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ApadrinarVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ApadrinarVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ApadrinarVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ApadrinarVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton botonApadrinar;
    private javax.swing.JButton botonDesapadrinar;
    private javax.swing.JButton botonAtras;
    private javax.swing.JLabel textoSocios;
    private javax.swing.JLabel textoNinos;
    private javax.swing.JLabel textoGestionApadrinamientos;
    private javax.swing.JLabel textoMensaje;
    private javax.swing.JList<String> listaSocios;
    private javax.swing.JList<String> listaNinos;
    private javax.swing.JScrollPane panelListaSocios;
    private javax.swing.JScrollPane panelListaNinos;
    private javax.swing.JTextField campoBusquedaNino;
    private javax.swing.JTextField campoBusquedaSocio;
    // End of variables declaration          
}
