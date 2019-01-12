package vistas;
import modelos.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Set;

public class SocioVista extends javax.swing.JPanel {

    private Usuario socio;

    public SocioVista(Usuario socio) {
        this.socio = socio;
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

        labelUsuario = new javax.swing.JLabel();
        horizontalSeparator = new javax.swing.JSeparator();
        panelApadrinados = new javax.swing.JPanel();
        textFieldFiltraApadrinados = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaApadrinados = new javax.swing.JList<>();
        verticalSeparator = new javax.swing.JSeparator();
        panelApadrinado = new javax.swing.JPanel();
        labelNombreApadrinado = new javax.swing.JLabel();
        labelEdadApadrinado = new javax.swing.JLabel();
        labelCalificacionApadrinado = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaCalificacionesApadrinados = new javax.swing.JTable();

       

        labelUsuario.setText("Usuario: " + socio.getNombre() + " (" + socio.getRole().getNombre() + ")");

        textFieldFiltraApadrinados.setToolTipText("Filtra por nombre");
        DefaultListModel listaApadrinadosModel = new javax.swing.DefaultListModel<String>() {
            String[] strings = socio.getApadrinados().stream().map((nino -> nino.getNombre() + " " + nino.getApellidos())).toArray(String[]::new);
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        };
        listaApadrinados.setModel(listaApadrinadosModel);
        jScrollPane1.setViewportView(listaApadrinados);

        javax.swing.GroupLayout panelApadrinadosLayout = new javax.swing.GroupLayout(panelApadrinados);
        panelApadrinados.setLayout(panelApadrinadosLayout);
        panelApadrinadosLayout.setHorizontalGroup(
            panelApadrinadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelApadrinadosLayout.createSequentialGroup()
                .addGroup(panelApadrinadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(textFieldFiltraApadrinados))
                .addContainerGap())
        );
        panelApadrinadosLayout.setVerticalGroup(
            panelApadrinadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelApadrinadosLayout.createSequentialGroup()
                .addComponent(textFieldFiltraApadrinados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        verticalSeparator.setOrientation(javax.swing.SwingConstants.VERTICAL);

        labelNombreApadrinado.setText("Nombre apadrinado: ");

        labelEdadApadrinado.setText("Edad: ");

        labelCalificacionApadrinado.setText("Calificaciones");

        tablaCalificacionesApadrinados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Curso", "Calificacion"
            }
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        jScrollPane2.setViewportView(tablaCalificacionesApadrinados);

        javax.swing.GroupLayout panelApadrinadoLayout = new javax.swing.GroupLayout(panelApadrinado);
        panelApadrinado.setLayout(panelApadrinadoLayout);
        panelApadrinadoLayout.setHorizontalGroup(
            panelApadrinadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelApadrinadoLayout.createSequentialGroup()
                .addGroup(panelApadrinadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelNombreApadrinado)
                    .addComponent(labelEdadApadrinado)
                    .addComponent(labelCalificacionApadrinado))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
        );
        panelApadrinadoLayout.setVerticalGroup(
            panelApadrinadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelApadrinadoLayout.createSequentialGroup()
                .addComponent(labelNombreApadrinado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelEdadApadrinado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelCalificacionApadrinado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelApadrinados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(horizontalSeparator, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(verticalSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelApadrinado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelApadrinado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(labelUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(horizontalSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelApadrinados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(verticalSeparator, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );

        textFieldFiltraApadrinados.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String[] apadrinados = socio.getApadrinados().stream().map(nino -> nino.getNombre() + " " + nino.getApellidos()).toArray(String[]::new);
                listaApadrinados.setListData(Arrays.stream(apadrinados).filter(nino -> nino.startsWith(textFieldFiltraApadrinados.getText())).toArray(String[]::new));
            }
        });

        listaApadrinados.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    Nino seleccionado = socio.getApadrinados().get(listaApadrinados.getSelectedIndex());
                    labelNombreApadrinado.setText("Nombre: " + seleccionado.getNombre() + " " + seleccionado.getApellidos());
                    labelEdadApadrinado.setText("Edad: " + " " + seleccionado.getfechaNacimiento());
                    DefaultTableModel model = (DefaultTableModel) tablaCalificacionesApadrinados.getModel();
                    model.setRowCount(0);

                    Set<String> cursos = seleccionado.getNotas().keySet();
                    for (String curso : cursos) {
                        Object[] row = {curso, seleccionado.getNotas().get(curso)};
                        model.addRow(row);
                    }
                }
            }
        });
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator horizontalSeparator;
    private javax.swing.JList<String> listaApadrinados;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaCalificacionesApadrinados;
    private javax.swing.JLabel labelCalificacionApadrinado;
    private javax.swing.JLabel labelEdadApadrinado;
    private javax.swing.JLabel labelNombreApadrinado;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JPanel panelApadrinado;
    private javax.swing.JPanel panelApadrinados;
    private javax.swing.JTextField textFieldFiltraApadrinados;
    private javax.swing.JSeparator verticalSeparator;
    // End of variables declaration//GEN-END:variables
}
