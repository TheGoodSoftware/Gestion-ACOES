package vistas;

import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;

import javax.swing.table.DefaultTableModel;

import controladores.GestionNinosControlador;
import modelos.Nino;
 

public class GestionNinosVista extends javax.swing.JFrame {

    /**
     * Creates new form gestionSociosNinos
     */
    public GestionNinosVista() {
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

        jSplitPane1 = new javax.swing.JSplitPane();
        buscador = new javax.swing.JTextField();
        
        
        tablaNinos = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        insertarBoton = new javax.swing.JButton();
        actualizarBoton = new javax.swing.JButton();
        eliminarBoton = new javax.swing.JButton();
        atrasBoton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        nombreCampo = new javax.swing.JTextField();
        fechaNacCampo = new javax.swing.JTextField();
        sexoCampo = new javax.swing.JTextField();
        colegioCampo = new javax.swing.JTextField();
        identidadCampo = new javax.swing.JTextField();
        nombreTitulo = new javax.swing.JLabel();
        fechaNacimientoTitulo = new javax.swing.JLabel();
        sexoTitulo = new javax.swing.JLabel();
        identidadTitulo = new javax.swing.JLabel();
        colegioTitulo = new javax.swing.JLabel();
        ccjCampo = new javax.swing.JCheckBox();
        becadoCampo = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscadorActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID","Nombre", "Edad", "Sexo ", "Identidad","Colegio", "Becado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.String.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaNinos.setViewportView(jTable1);

        jLabel1.setText("Buscador:");

        insertarBoton.setText("Insertar");

        actualizarBoton.setText("Actualizar");

        eliminarBoton.setText("Eliminar");

        atrasBoton.setText("Atrás");

        jLabel2.setFont(new java.awt.Font("Cantarell", 0, 22)); // NOI18N
        jLabel2.setText("Gestión de niños");

        nombreTitulo.setText("Nombre");

        fechaNacimientoTitulo.setText("Edad");

        sexoTitulo.setText("Sexo (V/M)");

        identidadTitulo.setText("Identidad");

        colegioTitulo.setText("Colegio");

        ccjCampo.setText("CCJ");
        ccjCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ccjCampoActionPerformed(evt);
            }
        });

        becadoCampo.setText("Becado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tablaNinos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 809, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(261, 261, 261)
                                .addComponent(atrasBoton))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(insertarBoton)
                                .addGap(133, 133, 133)
                                .addComponent(actualizarBoton)
                                .addGap(148, 148, 148)
                                .addComponent(eliminarBoton))))
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(sexoTitulo)
                                .addGap(18, 18, 18)
                                .addComponent(sexoCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fechaNacimientoTitulo)
                                .addGap(18, 18, 18)
                                .addComponent(fechaNacCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nombreTitulo)
                                .addGap(18, 18, 18)
                                .addComponent(nombreCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(identidadTitulo)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(ccjCampo)
                                .addComponent(colegioTitulo)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(identidadCampo, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                            .addComponent(colegioCampo)
                            .addComponent(becadoCampo))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(atrasBoton)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(insertarBoton)
                    .addComponent(actualizarBoton)
                    .addComponent(eliminarBoton))
                .addGap(18, 18, 18)
                .addComponent(tablaNinos, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(identidadCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreTitulo)
                    .addComponent(identidadTitulo))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fechaNacCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechaNacimientoTitulo)
                    .addComponent(colegioTitulo)
                    .addComponent(colegioCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sexoCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sexoTitulo)
                    .addComponent(ccjCampo)
                    .addComponent(becadoCampo))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        jLabel2.getAccessibleContext().setAccessibleName("Gestión de niños");

        pack();
    }// </editor-fold>                        

    private void buscadorActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void ccjCampoActionPerformed(java.awt.event.ActionEvent evt) {                                         
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
    private javax.swing.JButton atrasBoton;
    private javax.swing.JCheckBox becadoCampo;
    private javax.swing.JTextField buscador;
    private javax.swing.JCheckBox ccjCampo;
    private javax.swing.JTextField colegioCampo;
    private javax.swing.JLabel colegioTitulo;
    private javax.swing.JButton eliminarBoton;
    private javax.swing.JTextField fechaNacCampo;
    private javax.swing.JLabel fechaNacimientoTitulo;
    private javax.swing.JTextField identidadCampo;
    private javax.swing.JLabel identidadTitulo;
    private javax.swing.JButton insertarBoton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nombreCampo;
    private javax.swing.JLabel nombreTitulo;
    private javax.swing.JTextField sexoCampo;
    private javax.swing.JLabel sexoTitulo;
    private javax.swing.JScrollPane tablaNinos;
    
    // End of variables declaration                   
	public void controlador(ActionListener ctr) {
		this.insertarBoton.addActionListener(ctr);
		this.insertarBoton.setActionCommand("INSERTAR");
		this.actualizarBoton.addActionListener(ctr);
		this.actualizarBoton.setActionCommand("ACTUALIZAR");
		this.eliminarBoton.addActionListener(ctr);
		this.eliminarBoton.setActionCommand("ELIMINAR");
		this.atrasBoton.addActionListener(ctr);
		this.atrasBoton.setActionCommand("ATRAS");
		
	}

	public void cargarTabla(List<Nino> allNinos) {
		Object[][] tableContent = new Object[200][7];
		String[] identidadArtificial = {"256782189A","224782419B", "236782349B", "257122419D", "25678GD19F", "26782419R" };
		String[] respuesta = {"Sí","No"};
		String[] colegios = {"Loreto", "Santa Fe"};
		Random rnd = new Random();
		for(int i = 0; i< allNinos.size();i++) {
			tableContent[i][0] = allNinos.get(i).getID();
			tableContent[i][1] = allNinos.get(i).getNombre()+" "+allNinos.get(i).getApellidos();
			tableContent[i][2] = allNinos.get(i).getEdad();
			tableContent[i][3] = "V"; //CAMBIAR CUANDO SE MODIFIQUE BBDD
			tableContent[i][4] = identidadArtificial[i];
			
			tableContent[i][5] = colegios[rnd.nextInt(2)];
			tableContent[i][6] = respuesta[rnd.nextInt(2)];
		}
		
		jTable1.setModel(new javax.swing.table.DefaultTableModel(
				tableContent,
				new String[] {
						"ID","Nombre", "Edad", "Sexo ", "Identidad","Colegio", "Becado"	
				}
				));
		
	}
	

	public void setNombre(String nombre) {
		this.nombreCampo.setText(nombre); 
	}
	public void setEdad(String edad) {
		this.fechaNacCampo.setText(edad); 
	}
	public void setSexo(String sexo) {
		this.sexoCampo.setText(sexo); 
	}
	public void setIdentidad(String identidad) {
		this.identidadCampo.setText(identidad); 
	}
	public void setCCJ(String ccj) {
		if(ccj.equals("Sí")) {
			this.ccjCampo.setEnabled(true);
		}
		else {
			this.ccjCampo.setEnabled(false);
		}
		 
	}
	public void setColegio(String colegio) {
		this.colegioCampo.setText(colegio); 
	}
	public void setBecado(String becado) {
		if(becado.equals("Sí")) {
			this.becadoCampo.setEnabled(true);
		}
		else {
			this.becadoCampo.setEnabled(false);
		} 
	}

	public String getNombre() {
		
		return this.nombreCampo.getText();
	}
	
	

	public String getEdad() {
		// TODO Auto-generated method stub
		return this.fechaNacCampo.getText();
	}

	public String getSexo() {
		// TODO Auto-generated method stub
		return this.sexoCampo.getText();
	}

	public String getIdentidad() {
		// TODO Auto-generated method stub
		return this.identidadCampo.getText();
	}

	public String getColegio() {
		// TODO Auto-generated method stub
		return this.colegioCampo.getText();
	}

	public Boolean getCCJ() {
		return this.ccjCampo.isSelected();
	}

	public Boolean getBecado() {
		// TODO Auto-generated method stub
		return this.becadoCampo.isSelected();
	}
	
	 public String getNombreSeleccionado() {
	    	int tupla = jTable1.getSelectedRow();
	    	return (String)jTable1.getValueAt(tupla, 1);
	    	
	    }
	 
	 public String getIDSeleccionado() {
		 int tupla = jTable1.getSelectedRow();
		 return jTable1.getValueAt(tupla, 0).toString();
	 }
	 public String getEdadSeleccionada() {
	    	int tupla = jTable1.getSelectedRow();
	    	return jTable1.getValueAt(tupla, 2).toString();
	    	
	    }
	 public String getSexoSeleccionado() {
	    	int tupla = jTable1.getSelectedRow();
	    	return (String)jTable1.getValueAt(tupla, 3);
	    	
	    }
	 public String getIdentidadSeleccionado() {
	    	int tupla = jTable1.getSelectedRow();
	    	return (String)jTable1.getValueAt(tupla, 4);
	    	
	    }
	 /*
	 public String getCCJSeleccionado() {
	    	int tupla = jTable1.getSelectedRow();
	    	return (String)jTable1.getValueAt(tupla, 4);
	    	
	    }
	    */
	 public String getColegioSeleccionado() {
	    	int tupla = jTable1.getSelectedRow();
	    	return (String)jTable1.getValueAt(tupla, 5);
	    	
	    }
	 public String getBecadoSeleccionado() {
	    	int tupla = jTable1.getSelectedRow();
	    	return (String)jTable1.getValueAt(tupla, 6);
	    	
	    }

	public void setConfirmacionActualizar() {
		insertarBoton.setEnabled(false);
		actualizarBoton.setText("CONFIRMAR");
		eliminarBoton.setEnabled(false);
		atrasBoton.setEnabled(false);
		
	}

	public void habilitarBotones() {
		insertarBoton.setEnabled(true);
		actualizarBoton.setText("Actualizar");
		eliminarBoton.setEnabled(true);
		atrasBoton.setEnabled(true);
		
	}
	
	public void eliminarNinoSeleccionado() {
    	DefaultTableModel model =
    			  (DefaultTableModel)jTable1.getModel();
    	int tupla = jTable1.getSelectedRow();
    	
    	if(tupla!=-1) {
    		
    		model.removeRow(tupla);
    	}
    }
}
