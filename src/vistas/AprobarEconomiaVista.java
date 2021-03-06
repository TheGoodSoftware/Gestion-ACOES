package vistas;

import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import modelos.Economia;
import modelos.GestionEconomica;

/**
 *
 * @author jaysus
 */
public class AprobarEconomiaVista extends javax.swing.JPanel {

    /**
     * Creates new form AprobarEconomia
     */
	private GestionEconomica gestion;
	
    public AprobarEconomiaVista(GestionEconomica gestion) {
    	this.gestion = gestion;
        initComponents();
    }

    public void addControlador(ActionListener ctr) {
    	aceptarBoton.addActionListener(ctr);
    	denegarBoton.addActionListener(ctr);
    	aceptarBoton.setActionCommand("ACEPTAR");
    	denegarBoton.setActionCommand("DENEGAR");
    }
    
    public void updateTable() {
    	DefaultTableModel model = (DefaultTableModel)tablaAprobarPagos.getModel();
    	model.setDataVector(gestion.toObjectArray(), new String [] {
    			"Id", "Cantidad", "Moneda", "Tipo", "Concepto", "Procedencia/Beneficiario", "Fecha", "Aceptado"
            });
    }

    public GestionEconomica getGestion() {
    	return this.gestion;
    }
    
    public int getSeleccionado() {
    	return tablaAprobarPagos.getSelectedRow();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAprobarPagos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        aceptarBoton = new javax.swing.JButton();
        denegarBoton = new javax.swing.JButton();

        tablaAprobarPagos.setModel(new javax.swing.table.DefaultTableModel(
                gestion.toObjectArray(),
                new String [] {
                		"Id", "Cantidad", "Moneda", "Tipo", "Concepto", "Procedencia/Beneficiario", "Fecha", "Aceptado"
                }
            ) {
                boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
        jScrollPane1.setViewportView(tablaAprobarPagos);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setText(" Aceptación de gastos e ingresos de ACOES");

        aceptarBoton.setText("Aceptar");

        denegarBoton.setText("Denegar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 976, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(aceptarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(denegarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptarBoton)
                    .addComponent(denegarBoton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>                        


    // Variables declaration - do not modify                     
    private javax.swing.JButton aceptarBoton;
    private javax.swing.JButton denegarBoton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaAprobarPagos;
    // End of variables declaration                   
}

