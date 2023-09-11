/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import Controlador.*;
import static Controlador.Controlador.ventana2;

/**
 *
 * @author alexb
 */
public class Ventana_2 extends javax.swing.JFrame {

    /**
     * Creates new form Ventana_2
     */
    public Ventana_2() {
        initComponents();
        formato();
        getVentan2_boton_agregar_escala().setEnabled(false);
        getVentana2_Tabla_Escalas().setEnabled(false);
        getVentana2_actualizar_vuelo().setEnabled(false);
    }

    private void formato() {
    
    String []s={"Ciudad","llegada","Salida","Escala"};
     modelito.setColumnIdentifiers(s);
     ventana2_Tabla_Escalas.setModel(modelito);
    
    String []st={"Numero","Descripcion","Salida","Llegada","Duracion"};
    modelito_2.setColumnIdentifiers(st);
     getVentana2_Tabla_Vuelos().setModel(modelito_2);
     
        for (int i = 1; i <= 24; i++) {
            getVentana2_ComboBox_salida().addItem(String.valueOf(i));
            getVentana2_ComboBox_llegada().addItem(String.valueOf(i));
            getVentana2_comboEscala_llegada().addItem(String.valueOf(i));
            getVentana2_comboEscala_salida().addItem(String.valueOf(i));
        }
   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ventana2_Tabla_Escalas = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        ventana2_Tabla_Vuelos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        ventana2_numerode_vuelo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ventana2_ComboBox1_origen = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        ventana2_ComboBox_Destino = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        ventana2_ComboBox_salida = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        ventana2_ComboBox_llegada = new javax.swing.JComboBox<>();
        ventana2_agregar_vuelo = new javax.swing.JButton();
        ventana2_actualizar_vuelo = new javax.swing.JButton();
        ventana_combox_Escala = new javax.swing.JComboBox<>();
        ventana2_comboEscala_llegada = new javax.swing.JComboBox<>();
        ventana2_comboEscala_salida = new javax.swing.JComboBox<>();
        ventan2_boton_agregar_escala = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ventana2_Tabla_Escalas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        ventana2_Tabla_Escalas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ventana2_Tabla_EscalasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ventana2_Tabla_Escalas);

        ventana2_Tabla_Vuelos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        ventana2_Tabla_Vuelos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ventana2_Tabla_VuelosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(ventana2_Tabla_Vuelos);

        jLabel1.setText("Numero");

        jLabel2.setText("Origen");

        jLabel3.setText("Destino");

        jLabel4.setText("Salida");

        jLabel5.setText("Llegada");

        ventana2_agregar_vuelo.setText("Agregar");
        ventana2_agregar_vuelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventana2_agregar_vueloActionPerformed(evt);
            }
        });

        ventana2_actualizar_vuelo.setText("Actualizar");
        ventana2_actualizar_vuelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventana2_actualizar_vueloActionPerformed(evt);
            }
        });

        ventan2_boton_agregar_escala.setText("+");
        ventan2_boton_agregar_escala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventan2_boton_agregar_escalaActionPerformed(evt);
            }
        });

        jLabel6.setText("ESCALAS");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Llegada");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Salida");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Vuelo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ventana2_agregar_vuelo)
                                .addGap(64, 64, 64))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ventana_combox_Escala, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(ventana2_comboEscala_llegada, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ventana2_comboEscala_salida, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ventan2_boton_agregar_escala, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ventana2_actualizar_vuelo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(80, 80, 80))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(43, 43, 43)))
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ventana2_numerode_vuelo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ventana2_ComboBox1_origen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ventana2_ComboBox_Destino, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(64, 64, 64)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ventana2_ComboBox_salida, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(ventana2_ComboBox_llegada, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(118, 118, 118)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(ventana2_numerode_vuelo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ventana2_ComboBox_salida, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(ventana2_ComboBox1_origen, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(ventana2_ComboBox_llegada, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(ventana2_ComboBox_Destino, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ventana2_agregar_vuelo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ventana2_actualizar_vuelo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ventana_combox_Escala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ventana2_comboEscala_llegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ventana2_comboEscala_salida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ventan2_boton_agregar_escala, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(262, 262, 262)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ventana2_agregar_vueloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventana2_agregar_vueloActionPerformed
      Controlador.AGREGAR_Vuelo();
    }//GEN-LAST:event_ventana2_agregar_vueloActionPerformed

    private void ventana2_Tabla_VuelosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ventana2_Tabla_VuelosMouseClicked
      Controlador.tablla_de_vuelo_mouseclic(evt);
    }//GEN-LAST:event_ventana2_Tabla_VuelosMouseClicked

    private void ventana2_actualizar_vueloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventana2_actualizar_vueloActionPerformed
       Controlador.Actualizar_vuelo();
    }//GEN-LAST:event_ventana2_actualizar_vueloActionPerformed

    private void ventan2_boton_agregar_escalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventan2_boton_agregar_escalaActionPerformed
      Controlador.AgregarEscala();
    }//GEN-LAST:event_ventan2_boton_agregar_escalaActionPerformed

    private void ventana2_Tabla_EscalasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ventana2_Tabla_EscalasMouseClicked
         
    }//GEN-LAST:event_ventana2_Tabla_EscalasMouseClicked

    DefaultTableModel modelito = new DefaultTableModel();
    DefaultTableModel modelito_2 = new DefaultTableModel();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton ventan2_boton_agregar_escala;
    private javax.swing.JComboBox<String> ventana2_ComboBox1_origen;
    private javax.swing.JComboBox<String> ventana2_ComboBox_Destino;
    private javax.swing.JComboBox<String> ventana2_ComboBox_llegada;
    private javax.swing.JComboBox<String> ventana2_ComboBox_salida;
    private javax.swing.JTable ventana2_Tabla_Escalas;
    private javax.swing.JTable ventana2_Tabla_Vuelos;
    private javax.swing.JButton ventana2_actualizar_vuelo;
    private javax.swing.JButton ventana2_agregar_vuelo;
    private javax.swing.JComboBox<String> ventana2_comboEscala_llegada;
    private javax.swing.JComboBox<String> ventana2_comboEscala_salida;
    private javax.swing.JTextField ventana2_numerode_vuelo;
    private javax.swing.JComboBox<String> ventana_combox_Escala;
    // End of variables declaration//GEN-END:variables

   
    public JComboBox<String> getVentana2_ComboBox1_origen() {
        return ventana2_ComboBox1_origen;
    }

    public JComboBox<String> getVentana2_ComboBox_Destino() {
        return ventana2_ComboBox_Destino;
    }

    public JComboBox<String> getVentana2_ComboBox_llegada() {
        return ventana2_ComboBox_llegada;
    }

    public JComboBox<String> getVentana2_ComboBox_salida() {
        return ventana2_ComboBox_salida;
    }

    public JTable getVentana2_Tabla_Escalas() {
        return ventana2_Tabla_Escalas;
    }

    public JTable getVentana2_Tabla_Vuelos() {
        return ventana2_Tabla_Vuelos;
    }

    public JTextField getVentana2_numerode_vuelo() {
        return ventana2_numerode_vuelo;
    }

    public DefaultTableModel getModelito() {
        return modelito;
    }

    public DefaultTableModel getModelito_2() {
        return modelito_2;
    }

    public JButton getVentan2_boton_agregar_escala() {
        return ventan2_boton_agregar_escala;
    }

    public JButton getVentana2_actualizar_vuelo() {
        return ventana2_actualizar_vuelo;
    }

    public JButton getVentana2_agregar_vuelo() {
        return ventana2_agregar_vuelo;
    }

    public JComboBox<String> getVentana2_comboEscala_llegada() {
        return ventana2_comboEscala_llegada;
    }

    public JComboBox<String> getVentana2_comboEscala_salida() {
        return ventana2_comboEscala_salida;
    }

    public JComboBox<String> getVentana_combox_Escala() {
        return ventana_combox_Escala;
    }


}
