package vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import modelos.Economia;
import modelos.Nino;
import principal.BD;

/**
 *
 * @author xfja
 */
public class GestionNinosVista extends javax.swing.JPanel {

	private TableRowSorter<TableModel> rowSorter;
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form gestionSociosNinos
     */
    public GestionNinosVista() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        buscador = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        insertarBoton = new javax.swing.JButton();
        actualizarBoton = new javax.swing.JButton();
        eliminarBoton = new javax.swing.JButton();
        generarFichaBoton = new javax.swing.JButton();

       // setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscadorActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Apellidos", "Fecha Nacimiento", "NIF", "Dirección", "Población", "Sexo", "Proyecto", "Fecha alta", "Fecha alta ACOES", "Fecha salida ACOES", "Fecha alta proyecto", "Fecha salida proyecto", "Observaciones"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabla.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(2).setPreferredWidth(90);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(150);
            tabla.getColumnModel().getColumn(5).setPreferredWidth(80);
            tabla.getColumnModel().getColumn(6).setPreferredWidth(80);
            tabla.getColumnModel().getColumn(8).setPreferredWidth(80);
            tabla.getColumnModel().getColumn(9).setPreferredWidth(130);
            tabla.getColumnModel().getColumn(10).setPreferredWidth(230);
            tabla.getColumnModel().getColumn(11).setPreferredWidth(230);
            tabla.getColumnModel().getColumn(12).setPreferredWidth(230);
            tabla.getColumnModel().getColumn(13).setPreferredWidth(230);
            tabla.getColumnModel().getColumn(14).setPreferredWidth(1000);
        }

        jLabel1.setText("Buscador:");

        insertarBoton.setText("Insertar");

        actualizarBoton.setText("Actualizar");

        eliminarBoton.setText("Eliminar");

        generarFichaBoton.setText("Generar ficha información");
        
        eliminarBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(tabla.getSelectedRow() != -1) {
					int result = JOptionPane.showConfirmDialog(null, "¿Estás seguro de querer eliminar la fila seleccionada?", "Eliminación de niño", JOptionPane.YES_NO_OPTION);
					if(result == JOptionPane.YES_OPTION) {
						try {
							
							new BD().eliminarNinoBaseDeDatos(Integer.parseInt(getIDSeleccionado()));
							DefaultTableModel model =
					    			  (DefaultTableModel)tabla.getModel();
					    	int tupla = tabla.getSelectedRow();

					    	if(tupla!=-1) {

					    		model.removeRow(tupla);
					    	}
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
        	
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 910, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(insertarBoton)
                        .addGap(49, 49, 49)
                        .addComponent(actualizarBoton)
                        .addGap(42, 42, 42)
                        .addComponent(eliminarBoton)
                        .addGap(39, 39, 39)
                        .addComponent(generarFichaBoton)))
                .addGap(0, 44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insertarBoton)
                    .addComponent(actualizarBoton)
                    .addComponent(eliminarBoton)
                    .addComponent(generarFichaBoton)
                    .addComponent(buscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
      
        
        buscador.getDocument().addDocumentListener(new DocumentListener(){

            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = buscador.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = buscador.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
        
        
    }// </editor-fold>                                       

    private void buscadorActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(GestionNinosVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionNinosVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionNinosVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionNinosVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionNinosVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton actualizarBoton;
    private javax.swing.JTextField buscador;
    private javax.swing.JButton eliminarBoton;
    private javax.swing.JButton generarFichaBoton;
    private javax.swing.JButton insertarBoton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration     
    
	public void controlador(ActionListener ctr) {
		this.insertarBoton.addActionListener(ctr);
		this.insertarBoton.setActionCommand("INSERTAR");
		this.actualizarBoton.addActionListener(ctr);
		this.actualizarBoton.setActionCommand("ACTUALIZAR");
		this.eliminarBoton.addActionListener(ctr);
		this.eliminarBoton.setActionCommand("ELIMINAR");
		this.generarFichaBoton.addActionListener(ctr);
		this.generarFichaBoton.setActionCommand("GENERAR_INFORME");
	}
	
	public void cargarTabla(List<Nino> allNinos, Map<Integer, String> proyectos) {
		Object[][] tableContent = new Object[200][15];
		for(int i = 0; i< allNinos.size();i++) {
			tableContent[i][0] = allNinos.get(i).getID();
			tableContent[i][1] = allNinos.get(i).getNombre();
			tableContent[i][2] = allNinos.get(i).getApellidos();
			tableContent[i][3] = allNinos.get(i).getfechaNacimiento();
			tableContent[i][4] = allNinos.get(i).getNIF();
			tableContent[i][5] = allNinos.get(i).getDireccion();
			tableContent[i][6] = allNinos.get(i).getPueblo();
			tableContent[i][7] = allNinos.get(i).getSexo();
			tableContent[i][8] = proyectos.get(allNinos.get(i).getProyecto());
			tableContent[i][9] = allNinos.get(i).getFechaAlta();
			tableContent[i][10] = allNinos.get(i).getFechaAltaACOES();
			tableContent[i][11] = allNinos.get(i).getFechaSalidaACOES();
			tableContent[i][12] = allNinos.get(i).getFechaAltaProyecto();
			tableContent[i][13] = allNinos.get(i).getFechaSalidaProyecto();
			tableContent[i][14] = allNinos.get(i).getObservaciones();
		}

		
	      tabla.setModel(new javax.swing.table.DefaultTableModel(
	              tableContent,
	              new String [] {
	                  "ID", "Nombre", "Apellidos", "Fecha Nacimiento", "NIF", "Dirección", "Población", "Sexo", "Proyecto", "Fecha alta", "Fecha alta ACOES", "Fecha salida ACOES", "Fecha alta proyecto", "Fecha salida proyecto", "Observaciones"
	              }
	          ));
	      
	      rowSorter = new TableRowSorter<>(tabla.getModel());
	      tabla.setRowSorter(rowSorter);
	}
	
	public String getIDSeleccionado() {
		 int tupla = tabla.getSelectedRow();
		 return tabla.getValueAt(tupla, 0).toString();
	 }
	public String getNombreSeleccionado() {
		 int tupla = tabla.getSelectedRow();
		 return tabla.getValueAt(tupla, 1).toString();
	 }
	public String getApellidosSeleccionado() {
		 int tupla = tabla.getSelectedRow();
		 return tabla.getValueAt(tupla, 2).toString();
	 }
	public String getFechaNacSeleccionado() {
		 int tupla = tabla.getSelectedRow();
		 return tabla.getValueAt(tupla, 3).toString();
	 }
	public String getNIFSeleccionado() {
		 int tupla = tabla.getSelectedRow();
		 return tabla.getValueAt(tupla, 4).toString();
	 }
	public String getDireccionSeleccionado() {
		 int tupla = tabla.getSelectedRow();
		 return tabla.getValueAt(tupla, 5).toString();
	 }
	public String getPoblacionSeleccionado() {
		 int tupla = tabla.getSelectedRow();
		 return tabla.getValueAt(tupla, 6).toString();
	 }
	public String getSexoSeleccionado() {
		 int tupla = tabla.getSelectedRow();
		 return tabla.getValueAt(tupla, 7).toString();
	 }
	public String getProyectoSeleccionado() {
		 int tupla = tabla.getSelectedRow();
		 return tabla.getValueAt(tupla, 8).toString();
	 }
	public String getFechaAltaSeleccionado() {
		 int tupla = tabla.getSelectedRow();
		 return tabla.getValueAt(tupla, 9).toString();
	 }
	
	public String getFechaAltaACOESSeleccionado() {
		 int tupla = tabla.getSelectedRow();
		 return tabla.getValueAt(tupla, 10).toString();
	 }
	
	public String getFechaSalidaACOESSeleccionado() {
		 int tupla = tabla.getSelectedRow();
		 return tabla.getValueAt(tupla, 11).toString();
	 }
	public String getAltaProyectoSeleccionado() {
		 int tupla = tabla.getSelectedRow();
		 return tabla.getValueAt(tupla, 12).toString();
	 }
	
	public String getSalidaProyectoSeleccionado() {
		 int tupla = tabla.getSelectedRow();
		 return tabla.getValueAt(tupla, 13).toString();
	 }
	public String getObservacionSeleccionado() {
		 int tupla = tabla.getSelectedRow();
		 return tabla.getValueAt(tupla, 14).toString();
	 }

		
	
	
	
	
	
}


