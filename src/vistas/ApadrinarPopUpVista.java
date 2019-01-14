package vistas;


import controladores.ApadrinarPopUpControlador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cherra
 */
public class ApadrinarPopUpVista extends javax.swing.JFrame {

    /**
     * Creates new form ApadrinarPopUpVista
     */
    public ApadrinarPopUpVista() {
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

        personaTexto = new javax.swing.JLabel();
        usuarioTexto = new javax.swing.JLabel();
        panelLista = new javax.swing.JScrollPane();
        listaPersonas = new javax.swing.JList<>();
        ninoSocioTexto = new javax.swing.JLabel();
        cuotaCampo = new javax.swing.JTextField();
        cuotaTexto = new javax.swing.JLabel();
        confirmarBoton = new javax.swing.JButton();
        cancelarBoton = new javax.swing.JButton();
        apadrinarDesapadrinarTexto = new javax.swing.JLabel();

        personaTexto.setText("Persona:");

        usuarioTexto.setText("persona seleccionada");

        listaPersonas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        panelLista.setViewportView(listaPersonas);

        ninoSocioTexto.setText("texto: socio/niño");

        cuotaTexto.setText("Cuota:");

        confirmarBoton.setText("Aceptar");


        cancelarBoton.setText("Cancelar");


        apadrinarDesapadrinarTexto.setText("Apadrinar/Desapadrinar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(personaTexto)
                            .addComponent(cuotaTexto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(confirmarBoton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cancelarBoton))
                            .addComponent(usuarioTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cuotaCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(apadrinarDesapadrinarTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelLista, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ninoSocioTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(personaTexto)
                            .addComponent(usuarioTexto))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cuotaCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cuotaTexto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(confirmarBoton)
                            .addComponent(cancelarBoton)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(62, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ninoSocioTexto)
                            .addComponent(apadrinarDesapadrinarTexto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelLista, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(74, 74, 74))
        );

        pack();
    }// </editor-fold>   
    
    
    public void setLista(String[] listaPersonas) {
    	this.listaPersonas.setListData(listaPersonas);
    }
    
    public void setApadrinarDesapadrinar(String texto) {
    	apadrinarDesapadrinarTexto.setText(texto);
    }
    
    public void setUsuario(String usuario, String tipo) {
    	usuarioTexto.setText(usuario);
    	personaTexto.setText(tipo);
    }
    
    public int getCuota() {
    	return Integer.parseInt(cuotaCampo.getText());
    }
    
    public int getSeleccionado() {
    	String persona = listaPersonas.getSelectedValue();
    	String[] partes = persona.split(" ");
    	return Integer.parseInt(partes[0]);
    }
    
    public String getEstado() {
    	return apadrinarDesapadrinarTexto.getText();
    }
    
    public String getCargadoDesde() {
    	return personaTexto.getText();
    }
    
    public int getPersonaPrecargada() {
    	String persona = usuarioTexto.getText();
    	String[] partes = persona.split(" ");
    	return Integer.parseInt(partes[0]);
    }

    public void controlador(ApadrinarPopUpControlador ctr) {
    	confirmarBoton.addActionListener(ctr);
    	cancelarBoton.addActionListener(ctr);
    	confirmarBoton.setActionCommand("CONFIRMAR");
    	cancelarBoton.setActionCommand("CANCELAR");
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton confirmarBoton;
    private javax.swing.JButton cancelarBoton;
    private javax.swing.JLabel personaTexto;
    private javax.swing.JLabel usuarioTexto;
    private javax.swing.JLabel ninoSocioTexto;
    private javax.swing.JLabel cuotaTexto;
    private javax.swing.JLabel apadrinarDesapadrinarTexto;
    private javax.swing.JList<String> listaPersonas;
    private javax.swing.JScrollPane panelLista;
    private javax.swing.JTextField cuotaCampo;
    // End of variables declaration                   
}
