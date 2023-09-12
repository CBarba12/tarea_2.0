/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import vista.*;
import Modelo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author alexb
 */
public class Controlador implements ActionListener, MouseListener {

    public static Ventana_1 ventana = new Ventana_1();
    public static Ventana_2 ventana2 = new Ventana_2();
    public static Modelo_Principal modelo = new Modelo_Principal();

    public static void mostrar() {
        ventana.setVisible(true);
    }

    public static void mostrar2() {
        ventana2.setVisible(true);
    }

    public static void ocultar() {
        ventana.setVisible(false);
    }

    public Controlador(Modelo_Principal Model, Ventana_2 ven2, Ventana_1 ven1) {

        modelo = Model;
        ventana2 = ven2;
        ventana = ven1;

        // eventos de la primer ventana----------------------------------------------------
        ventana.setTitle("CIUDAD");
        ventana.getVentana1_boton_agregar().addActionListener(this);
        ventana.getVentana1_boton_actualizar().addActionListener(this);
        ventana.getCaja1_Bonton_buscar().addActionListener(this);
        ventana.getTabla_ciudad().addMouseListener(this);

        // evento segunda ventana-----------------------------------------------------------
        ventana2.getVentana2_agregar_vuelo().addActionListener(this);
        ventana2.getVentana2_actualizar_vuelo().addActionListener(this);
        ventana2.getVentan2_boton_agregar_escala().addActionListener(this);
        ventana2.getVentana2_Tabla_Vuelos().addMouseListener(this);

        formato();

        ventana.setLocationRelativeTo(null);
        ventana.setBounds(500, 500, 500, 500);
        ventana.setDefaultCloseOperation(ventana.EXIT_ON_CLOSE);
        ventana2.setVisible(true);
        ventana.setVisible(true);
    }

    private void formato() {

        String[] s = {"Ciudad", "llegada", "Salida", "Escala"};
        ventana2.getModelito().setColumnIdentifiers(s);
        ventana2.getVentana2_Tabla_Escalas().setModel(ventana2.getModelito());

        String[] st = {"Numero", "Descripcion", "Salida", "Llegada", "Duracion"};
        ventana2.getModelito_2().setColumnIdentifiers(st);
        ventana2.getVentana2_Tabla_Vuelos().setModel(ventana2.getModelito_2());

        for (int i = 1; i <= 24; i++) {
            ventana2.getVentana2_ComboBox_salida().addItem(String.valueOf(i));
            ventana2.getVentana2_ComboBox_llegada().addItem(String.valueOf(i));
            ventana2.getVentana2_comboEscala_llegada().addItem(String.valueOf(i));
            ventana2.getVentana2_comboEscala_salida().addItem(String.valueOf(i));
        }
        ventana2.getVentan2_boton_agregar_escala().setEnabled(false);
        ventana2.getVentana2_Tabla_Escalas().setEnabled(false);
        ventana2.getVentana2_actualizar_vuelo().setEnabled(false);

        //-----------------------------------------ventana 1------------------------------------------------
        String[] str = {"Id", "nombre", "Gmt"};
        ventana.getModelito().setColumnIdentifiers(str);
        ventana.getTabla_ciudad().setModel(ventana.getModelito());

        ventana.getVENTANA1_ComboBox_GMT().addItem("-6");
        ventana.getVENTANA1_ComboBox_GMT().addItem("-5");
        ventana.getVENTANA1_ComboBox_GMT().addItem("-4");
        ventana.getVENTANA1_ComboBox_GMT().addItem("-3");
        ventana.getVENTANA1_ComboBox_GMT().addItem("-2");
        ventana.getVENTANA1_ComboBox_GMT().addItem("-1");
        ventana.getVentana1_boton_actualizar().setEnabled(false);

    }

    public static void AGREGAR_ciudad() {

        String Id = ventana.getVentana1_caja_ID().getText();
        String Nombre = ventana.getVentana1_nombre_CIUDAD().getText();
        String seleccion = (String) ventana.getVENTANA1_ComboBox_GMT().getSelectedItem();

        for (int i = 0; i < modelo.getList_Ciudades().size(); i++) {
            if (modelo.getList_Ciudades().get(i).getId_Ciudad().equals(Id)) {

                JOptionPane.showMessageDialog(ventana, "Esta ciudad ya existe!!  Digite otro ID");
                return;
            }
        }

        Ciudad generica = new Ciudad(Id, Nombre, seleccion);
        modelo.getList_Ciudades().add(generica);

        ventana2.getVentana2_ComboBox1_origen().addItem(Nombre + "(" + seleccion + "gmt)");
        ventana2.getVentana2_ComboBox_Destino().addItem(Nombre + "(" + seleccion + "gmt)");
        ventana2.getVentana_combox_Escala().addItem(Nombre + "(" + seleccion + "gmt)");

        Object[] columna = new Object[ventana.getModelito().getColumnCount()];
        columna[0] = Id;
        columna[1] = Nombre;
        columna[2] = seleccion;

        ventana.getModelito().addRow(columna);
        ventana.getTabla_ciudad().setModel(ventana.getModelito());

    }

    public static void busqueda_ciudad() {

        String cadena;
        boolean bandera;
        bandera = false;

        for (int i = 0; i < ventana.getTabla_ciudad().getRowCount(); i++) {
            cadena = (String) ventana.getTabla_ciudad().getValueAt(i, 0);

            if (cadena.equals(ventana.getVentana1_caja_buscar_nombre().getText())) {
                ventana.getTabla_ciudad().changeSelection(i, 0, true, false);
                ventana.getVentana1_caja_buscar_nombre().setText("");
                bandera = true;
                break;
            }
        }
        if (bandera == false) {
            JOptionPane.showMessageDialog(null, "Este registro no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
            ventana.getVentana1_caja_buscar_nombre().setText("");

        }
    }

    public static void Tabla_ciudadMouseClicked(java.awt.event.MouseEvent evt) {

        if (evt.getClickCount() == 1) { // Detectar un solo clic

            int selectedRow = ventana.getTabla_ciudad().getSelectedRow();
            if (selectedRow >= 0) {

                String id = (String) ventana.getTabla_ciudad().getValueAt(selectedRow, 0);
                String nombre = (String) ventana.getTabla_ciudad().getValueAt(selectedRow, 1);
                String gmt = (String) ventana.getTabla_ciudad().getValueAt(selectedRow, 2);

                ventana.getVentana1_nombre_CIUDAD().setText(nombre);
                ventana.getVentana1_caja_ID().setText(id);

                ventana.getVentana1_caja_ID().setEnabled(false);
                ventana.getVentana1_boton_actualizar().setEnabled(true);
                ventana.getVentana1_boton_agregar().setEnabled(false);

            }

        }

        //comienza la segunda ventana
    }

    public static void actualizar() {

        if (ventana.getTabla_ciudad().getSelectedRow() >= 0) {

            // Seleccionar una fila existente para editar
            int selectedRow = ventana.getTabla_ciudad().getSelectedRow();
            // Modificar los valores de la fila seleccionada

            String seleccion = (String) ventana.getVENTANA1_ComboBox_GMT().getSelectedItem();

            ventana.getTabla_ciudad().setValueAt(ventana.getVentana1_caja_ID().getText(), selectedRow, 0);
            ventana.getTabla_ciudad().setValueAt(ventana.getVentana1_nombre_CIUDAD().getText(), selectedRow, 1);
            ventana.getTabla_ciudad().setValueAt(seleccion, selectedRow, 2);

            for (int i = 0; i < modelo.getList_Ciudades().size(); i++) {
                if (modelo.getList_Ciudades().get(i).getId_Ciudad().equals(ventana.getVentana1_caja_ID().getText())) {

                    modelo.getList_Ciudades().get(i).setNombre_vuelo(ventana.getVentana1_nombre_CIUDAD().getText());
                    modelo.getList_Ciudades().get(i).setId_Ciudad(ventana.getVentana1_caja_ID().getText());
                    modelo.getList_Ciudades().get(i).setGMT(seleccion);

                }

            }

            ventana2.getVentana2_ComboBox1_origen().removeAllItems();
            ventana2.getVentana2_ComboBox_Destino().removeAllItems();
            ventana2.getVentana_combox_Escala().removeAllItems();

            for (int i = 0; i < modelo.getList_Ciudades().size(); i++) {

                ventana2.getVentana2_ComboBox1_origen().addItem(modelo.getList_Ciudades().get(i).getNombre_Ciudad() + "(" + modelo.getList_Ciudades().get(i).getGMT() + "gmt)");
                ventana2.getVentana2_ComboBox_Destino().addItem(modelo.getList_Ciudades().get(i).getNombre_Ciudad() + "(" + modelo.getList_Ciudades().get(i).getGMT() + "gmt)");
                ventana2.getVentana_combox_Escala().addItem(modelo.getList_Ciudades().get(i).getNombre_Ciudad() + "(" + modelo.getList_Ciudades().get(i).getGMT() + "gmt)");

            }

            ventana.getVentana1_caja_ID().setEnabled(true);
            ventana.getVentana1_nombre_CIUDAD().setText("");
            ventana.getVentana1_caja_ID().setText("");
            ventana.getVentana1_boton_agregar().setEnabled(true);

        }
        ventana.getTabla_ciudad().clearSelection();
    }

    //------------------------------------------------------------------------------vuelo---------------------------
    public static void AGREGAR_Vuelo() {

        int numeroidentificador;
        String Ciudad_Orige = null;
        String Ciudad_Destino = null;
        String Descripcion;
        int horaSalida;
        int hora_llegada;// horas local

        int GTMOrigen = 0;
        int GTMDestino = 0;
        int Duracion;

        ventana2.getVentan2_boton_agregar_escala().setEnabled(false);
        ventana2.getVentana2_Tabla_Escalas().setEnabled(false);

        numeroidentificador = Integer.parseInt(ventana2.getVentana2_numerode_vuelo().getText());

        for (int i = 0; i < modelo.getLista_Vuelos().size(); i++) {
            if (modelo.getLista_Vuelos().get(i).getIdentificador() == (numeroidentificador)) {

                JOptionPane.showMessageDialog(ventana, "Este vuelo ya existe!!  Digite otro Numero identificador");
                return;
            }
        }

        int total = ventana2.getVentana2_ComboBox1_origen().getSelectedIndex();
        int total2 = ventana2.getVentana2_ComboBox_Destino().getSelectedIndex();

        if (total >= 0) {
            for (int i = 0; i < modelo.getList_Ciudades().size(); i++) {
                if (total == i) {
                    Ciudad_Orige = modelo.getList_Ciudades().get(i).getNombre_Ciudad();
                    GTMOrigen = Integer.parseInt(modelo.getList_Ciudades().get(i).getGMT());
                }
                if (total2 == i) {
                    Ciudad_Destino = modelo.getList_Ciudades().get(i).getNombre_Ciudad();
                    GTMDestino = Integer.parseInt(modelo.getList_Ciudades().get(i).getGMT());
                }
            }
        }

        Descripcion = Ciudad_Orige + "-" + Ciudad_Destino;

        horaSalida = Integer.parseInt((String) ventana2.getVentana2_ComboBox_salida().getSelectedItem());
        hora_llegada = Integer.parseInt((String) ventana2.getVentana2_ComboBox_llegada().getSelectedItem());

        if ((hora_llegada - (GTMDestino)) < (horaSalida - (GTMOrigen))) {
            Duracion = (24 - (horaSalida - (GTMOrigen))) + (hora_llegada - (GTMDestino));

        } else {
            Duracion = (hora_llegada - (GTMDestino)) - (horaSalida - (GTMOrigen));
        }

        Object[] columna = new Object[ventana2.getModelito_2().getColumnCount()];
        columna[0] = String.valueOf(numeroidentificador);
        columna[1] = Descripcion;
        columna[2] = String.valueOf(horaSalida);
        columna[3] = String.valueOf(hora_llegada);
        columna[4] = String.valueOf(Duracion);

        Vuelo vuelo = new Vuelo(numeroidentificador, Ciudad_Orige, Ciudad_Destino, horaSalida, hora_llegada);
        modelo.getLista_Vuelos().add(vuelo);

        ventana2.getModelito_2().addRow(columna);
        ventana2.getVentana2_Tabla_Vuelos().setModel(ventana2.getModelito_2());

    }

    public static void Actualizar_vuelo() {
        int numeroidentificador = 0;
        String Ciudad_Orige = null;
        String Ciudad_Destino = null;
        String Descripcion;
        int horaSalida;
        int hora_llegada;// horas local

        int GTMOrigen = 0;
        int GTMDestino = 0;
        int Duracion;

        if (ventana2.getVentana2_Tabla_Vuelos().getSelectedRow() >= 0) {

            // Seleccionar una fila existente para editar
            int selectedRow = ventana2.getVentana2_Tabla_Vuelos().getSelectedRow();
            // Modificar los valores de la fila seleccionada

//            String seleccion = (String) ventana.getVENTANA1_ComboBox_GMT().getSelectedItem();
            numeroidentificador = Integer.parseInt(ventana2.getVentana2_numerode_vuelo().getText());

            int total = ventana2.getVentana2_ComboBox1_origen().getSelectedIndex();
            int total2 = ventana2.getVentana2_ComboBox_Destino().getSelectedIndex();

            if (total >= 0) {

                for (int i = 0; i < modelo.getList_Ciudades().size(); i++) {
                    if (total == i) {
                        Ciudad_Orige = modelo.getList_Ciudades().get(i).getNombre_Ciudad();
                        GTMOrigen = Integer.parseInt(modelo.getList_Ciudades().get(i).getGMT());
                    }
                    if (total2 == i) {
                        Ciudad_Destino = modelo.getList_Ciudades().get(i).getNombre_Ciudad();
                        GTMDestino = Integer.parseInt(modelo.getList_Ciudades().get(i).getGMT());
                    }
                }
            }

            Descripcion = Ciudad_Orige + "-" + Ciudad_Destino;

            horaSalida = Integer.parseInt((String) ventana2.getVentana2_ComboBox_salida().getSelectedItem());
            hora_llegada = Integer.parseInt((String) ventana2.getVentana2_ComboBox_llegada().getSelectedItem());

            if ((hora_llegada - (GTMDestino)) < (horaSalida - (GTMOrigen))) {
                Duracion = (24 - (horaSalida - (GTMOrigen))) + (hora_llegada - (GTMDestino));

            } else {
                Duracion = (hora_llegada - (GTMDestino)) - (horaSalida - (GTMOrigen));
            }

//             for (int i = 0; i < modelo.getLista_Vuelos().size(); i++) {
//                if (String.valueOf(modelo.getLista_Vuelos().get(i).getIdentificador()).equals(ventana2.getVentana2_numerode_vuelo().getText())) {
//                    modelo.getLista_Vuelos().get(i).setIdentificador(Integer.parseInt(ventana2.getVentana2_numerode_vuelo().getText()));
//                }
//            }
            ventana2.getVentana2_Tabla_Vuelos().setValueAt(String.valueOf(numeroidentificador), selectedRow, 0);
            ventana2.getVentana2_Tabla_Vuelos().setValueAt(Descripcion, selectedRow, 1);
            ventana2.getVentana2_Tabla_Vuelos().setValueAt(String.valueOf(horaSalida), selectedRow, 2);
            ventana2.getVentana2_Tabla_Vuelos().setValueAt(String.valueOf(hora_llegada), selectedRow, 3);
            ventana2.getVentana2_Tabla_Vuelos().setValueAt(String.valueOf(Duracion), selectedRow, 4);

        }

        ventana2.getVentana2_numerode_vuelo().setEnabled(true);
        ventana2.getVentana2_numerode_vuelo().setText("");

        ventana2.getVentana2_Tabla_Vuelos().clearSelection();

    }

    public static void AgregarEscala() {

        int numeroidentificador;
        String Ciudad_Orige = null;
        String Ciudad_Destino = null;
        String Descripcion;
        int horaSalida;
        int hora_llegada;// horas local

        int GTMOrigen = 0;
        int GTMDestino = 0;
        int Duracion;

        String identificador_vuelo = ventana2.getVentana2_numerode_vuelo().getText();

        for (int i = 0; i < modelo.getLista_Vuelos().size(); i++) {

            if (String.valueOf(modelo.getLista_Vuelos().get(i).getIdentificador()).equals(identificador_vuelo)) {

                int total = ventana2.getVentana_combox_Escala().getSelectedIndex();

                if (total >= 0) {
                    for (int j = 0; j < modelo.getList_Ciudades().size(); j++) {
                        if (total == j) {

                            Ciudad_Orige = modelo.getList_Ciudades().get(j).getNombre_Ciudad();
                            GTMOrigen = Integer.parseInt(modelo.getList_Ciudades().get(j).getGMT());

                        }

                    }
                }

                hora_llegada = Integer.parseInt((String) ventana2.getVentana2_comboEscala_salida().getSelectedItem());
                horaSalida = Integer.parseInt((String) ventana2.getVentana2_comboEscala_llegada().getSelectedItem());

                modelo.getLista_Vuelos().get(i).getLista_escalas().add(new Escala(String.valueOf(Ciudad_Orige), String.valueOf(hora_llegada), String.valueOf(horaSalida), String.valueOf(GTMOrigen)));

                Object[] columna = new Object[ventana2.getModelito().getColumnCount()];

                int duracion_de_escala = Math.abs(hora_llegada - horaSalida);

                columna[0] = String.valueOf(Ciudad_Orige);
                columna[1] = String.valueOf(hora_llegada);
                columna[2] = String.valueOf(horaSalida);
                columna[3] = String.valueOf(duracion_de_escala);

                ventana2.getModelito().addRow(columna);
                ventana2.getVentana2_Tabla_Escalas().setModel(ventana2.getModelito());
            }

        }

    }

    public static void tablla_de_vuelo_mouseclic(java.awt.event.MouseEvent evt) {

        String ciudad;
        String hora_llegada;
        String hora_salida;
        String Escala;

        if (evt.getClickCount() == 1) { // Detectar un solo clic

            ventana2.getModelito().setRowCount(0);

            ventana2.getVentana2_Tabla_Escalas();

            for (int i = ventana2.getModelito().getRowCount() - 1; i >= 0; i--) {
                ventana2.getModelito().removeRow(i);
            }
            ventana2.getVentana2_Tabla_Escalas().setModel(ventana2.getModelito());

            int selectedRow = ventana2.getVentana2_Tabla_Vuelos().getSelectedRow();
            if (selectedRow >= 0) {

                ventana2.getVentana2_numerode_vuelo().setEnabled(false);
                ventana2.getVentana2_actualizar_vuelo().setEnabled(true);
                ventana2.getVentan2_boton_agregar_escala().setEnabled(true);
                ventana2.getVentana2_Tabla_Escalas().setEnabled(true);

                String numero_vuelo = (String) ventana2.getVentana2_Tabla_Vuelos().getValueAt(selectedRow, 0);

                for (int i = 0; i < modelo.getLista_Vuelos().size(); i++) {
                    if (String.valueOf(modelo.getLista_Vuelos().get(i).getIdentificador()).equals(numero_vuelo)) {

                        for (int j = 0; j < modelo.getLista_Vuelos().get(i).getLista_escalas().size(); j++) {

                            ciudad = modelo.getLista_Vuelos().get(i).getLista_escalas().get(j).getCiudad();
                            hora_llegada = modelo.getLista_Vuelos().get(i).getLista_escalas().get(j).getHora_llegada();
                            hora_salida = modelo.getLista_Vuelos().get(i).getLista_escalas().get(j).getHora_salida();
                            Escala = modelo.getLista_Vuelos().get(i).getLista_escalas().get(j).getHora_salida();

                            Object[] columna = new Object[ventana2.getModelito().getColumnCount()];

                            columna[0] = String.valueOf(ciudad);
                            columna[1] = String.valueOf(hora_llegada);
                            columna[2] = String.valueOf(hora_salida);
                            columna[3] = String.valueOf(Escala);

                            ventana2.getModelito().addRow(columna);
                            ventana2.getVentana2_Tabla_Escalas().setModel(ventana2.getModelito());

                        }

                    }
                }

                ventana2.getVentana2_numerode_vuelo().setText(numero_vuelo);
            }

        }

    }

    //---------------------------------------------------------eventos------------------------------------------------ 
    @Override
    public void actionPerformed(ActionEvent e) {

        //primera ventana-----------------------------------------
        if (e.getSource() == ventana.getVentana1_boton_agregar()) {
            String Id = ventana.getVentana1_caja_ID().getText();
            String Nombre = ventana.getVentana1_nombre_CIUDAD().getText();
            String seleccion = (String) ventana.getVENTANA1_ComboBox_GMT().getSelectedItem();

            for (int i = 0; i < modelo.getList_Ciudades().size(); i++) {
                if (modelo.getList_Ciudades().get(i).getId_Ciudad().equals(Id)) {

                    JOptionPane.showMessageDialog(ventana, "Esta ciudad ya existe!!  Digite otro ID");
                    return;
                }
            }

            Ciudad generica = new Ciudad(Id, Nombre, seleccion);
            modelo.getList_Ciudades().add(generica);

            ventana2.getVentana2_ComboBox1_origen().addItem(Nombre + "(" + seleccion + "gmt)");
            ventana2.getVentana2_ComboBox_Destino().addItem(Nombre + "(" + seleccion + "gmt)");
            ventana2.getVentana_combox_Escala().addItem(Nombre + "(" + seleccion + "gmt)");

            Object[] columna = new Object[ventana.getModelito().getColumnCount()];
            columna[0] = Id;
            columna[1] = Nombre;
            columna[2] = seleccion;

            ventana.getModelito().addRow(columna);
            ventana.getTabla_ciudad().setModel(ventana.getModelito());

        } else if (e.getSource() == ventana.getVentana1_boton_actualizar()) {
            if (ventana.getTabla_ciudad().getSelectedRow() >= 0) {

                // Seleccionar una fila existente para editar
                int selectedRow = ventana.getTabla_ciudad().getSelectedRow();
                // Modificar los valores de la fila seleccionada

                String seleccion = (String) ventana.getVENTANA1_ComboBox_GMT().getSelectedItem();

                ventana.getTabla_ciudad().setValueAt(ventana.getVentana1_caja_ID().getText(), selectedRow, 0);
                ventana.getTabla_ciudad().setValueAt(ventana.getVentana1_nombre_CIUDAD().getText(), selectedRow, 1);
                ventana.getTabla_ciudad().setValueAt(seleccion, selectedRow, 2);

                for (int i = 0; i < modelo.getList_Ciudades().size(); i++) {
                    if (modelo.getList_Ciudades().get(i).getId_Ciudad().equals(ventana.getVentana1_caja_ID().getText())) {

                        modelo.getList_Ciudades().get(i).setNombre_vuelo(ventana.getVentana1_nombre_CIUDAD().getText());
                        modelo.getList_Ciudades().get(i).setId_Ciudad(ventana.getVentana1_caja_ID().getText());
                        modelo.getList_Ciudades().get(i).setGMT(seleccion);

                    }

                }

                ventana2.getVentana2_ComboBox1_origen().removeAllItems();
                ventana2.getVentana2_ComboBox_Destino().removeAllItems();
                ventana2.getVentana_combox_Escala().removeAllItems();

                for (int i = 0; i < modelo.getList_Ciudades().size(); i++) {

                    ventana2.getVentana2_ComboBox1_origen().addItem(modelo.getList_Ciudades().get(i).getNombre_Ciudad() + "(" + modelo.getList_Ciudades().get(i).getGMT() + "gmt)");
                    ventana2.getVentana2_ComboBox_Destino().addItem(modelo.getList_Ciudades().get(i).getNombre_Ciudad() + "(" + modelo.getList_Ciudades().get(i).getGMT() + "gmt)");
                    ventana2.getVentana_combox_Escala().addItem(modelo.getList_Ciudades().get(i).getNombre_Ciudad() + "(" + modelo.getList_Ciudades().get(i).getGMT() + "gmt)");

                }

                ventana.getVentana1_caja_ID().setEnabled(true);
                ventana.getVentana1_nombre_CIUDAD().setText("");
                ventana.getVentana1_caja_ID().setText("");
                ventana.getVentana1_boton_agregar().setEnabled(true);

            }
            ventana.getTabla_ciudad().clearSelection();

        } else if (e.getSource() == ventana.getCaja1_Bonton_buscar()) {

            String cadena;
            boolean bandera;
            bandera = false;

            for (int i = 0; i < ventana.getTabla_ciudad().getRowCount(); i++) {
                cadena = (String) ventana.getTabla_ciudad().getValueAt(i, 0);

                if (cadena.equals(ventana.getVentana1_caja_buscar_nombre().getText())) {
                    ventana.getTabla_ciudad().changeSelection(i, 0, true, false);
                    ventana.getVentana1_caja_buscar_nombre().setText("");
                    bandera = true;
                    break;
                }
            }
            if (bandera == false) {
                JOptionPane.showMessageDialog(null, "Este registro no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
                ventana.getVentana1_caja_buscar_nombre().setText("");

            }

        } else if (e.getSource() == ventana2.getVentana2_agregar_vuelo()) {

            int numeroidentificador;
            String Ciudad_Orige = null;
            String Ciudad_Destino = null;
            String Descripcion;
            int horaSalida;
            int hora_llegada;// horas local

            int GTMOrigen = 0;
            int GTMDestino = 0;
            int Duracion;

            ventana2.getVentan2_boton_agregar_escala().setEnabled(false);
            ventana2.getVentana2_Tabla_Escalas().setEnabled(false);

            numeroidentificador = Integer.parseInt(ventana2.getVentana2_numerode_vuelo().getText());

            for (int i = 0; i < modelo.getLista_Vuelos().size(); i++) {
                if (modelo.getLista_Vuelos().get(i).getIdentificador() == (numeroidentificador)) {

                    JOptionPane.showMessageDialog(ventana, "Este vuelo ya existe!!  Digite otro Numero identificador");
                    return;
                }
            }

            int total = ventana2.getVentana2_ComboBox1_origen().getSelectedIndex();
            int total2 = ventana2.getVentana2_ComboBox_Destino().getSelectedIndex();

            if (total >= 0) {
                for (int i = 0; i < modelo.getList_Ciudades().size(); i++) {
                    if (total == i) {
                        Ciudad_Orige = modelo.getList_Ciudades().get(i).getNombre_Ciudad();
                        GTMOrigen = Integer.parseInt(modelo.getList_Ciudades().get(i).getGMT());
                    }
                    if (total2 == i) {
                        Ciudad_Destino = modelo.getList_Ciudades().get(i).getNombre_Ciudad();
                        GTMDestino = Integer.parseInt(modelo.getList_Ciudades().get(i).getGMT());
                    }
                }
            }

            Descripcion = Ciudad_Orige + "-" + Ciudad_Destino;

            horaSalida = Integer.parseInt((String) ventana2.getVentana2_ComboBox_salida().getSelectedItem());
            hora_llegada = Integer.parseInt((String) ventana2.getVentana2_ComboBox_llegada().getSelectedItem());

            if ((hora_llegada - (GTMDestino)) < (horaSalida - (GTMOrigen))) {
                Duracion = (24 - (horaSalida - (GTMOrigen))) + (hora_llegada - (GTMDestino));

            } else {
                Duracion = (hora_llegada - (GTMDestino)) - (horaSalida - (GTMOrigen));
            }

            Object[] columna = new Object[ventana2.getModelito_2().getColumnCount()];
            columna[0] = String.valueOf(numeroidentificador);
            columna[1] = Descripcion;
            columna[2] = String.valueOf(horaSalida);
            columna[3] = String.valueOf(hora_llegada);
            columna[4] = String.valueOf(Duracion);

            Vuelo vuelo = new Vuelo(numeroidentificador, Ciudad_Orige, Ciudad_Destino, horaSalida, hora_llegada);
            modelo.getLista_Vuelos().add(vuelo);

            ventana2.getModelito_2().addRow(columna);
            ventana2.getVentana2_Tabla_Vuelos().setModel(ventana2.getModelito_2());

        } else if (e.getSource() == ventana2.getVentana2_actualizar_vuelo()) {
            int numeroidentificador = 0;
            String Ciudad_Orige = null;
            String Ciudad_Destino = null;
            String Descripcion;
            int horaSalida;
            int hora_llegada;// horas local

            int GTMOrigen = 0;
            int GTMDestino = 0;
            int Duracion;

            if (ventana2.getVentana2_Tabla_Vuelos().getSelectedRow() >= 0) {

                // Seleccionar una fila existente para editar
                int selectedRow = ventana2.getVentana2_Tabla_Vuelos().getSelectedRow();
                // Modificar los valores de la fila seleccionada

//            String seleccion = (String) ventana.getVENTANA1_ComboBox_GMT().getSelectedItem();
                numeroidentificador = Integer.parseInt(ventana2.getVentana2_numerode_vuelo().getText());

                int total = ventana2.getVentana2_ComboBox1_origen().getSelectedIndex();
                int total2 = ventana2.getVentana2_ComboBox_Destino().getSelectedIndex();

                if (total >= 0) {

                    for (int i = 0; i < modelo.getList_Ciudades().size(); i++) {
                        if (total == i) {
                            Ciudad_Orige = modelo.getList_Ciudades().get(i).getNombre_Ciudad();
                            GTMOrigen = Integer.parseInt(modelo.getList_Ciudades().get(i).getGMT());
                        }
                        if (total2 == i) {
                            Ciudad_Destino = modelo.getList_Ciudades().get(i).getNombre_Ciudad();
                            GTMDestino = Integer.parseInt(modelo.getList_Ciudades().get(i).getGMT());
                        }
                    }
                }

                Descripcion = Ciudad_Orige + "-" + Ciudad_Destino;

                horaSalida = Integer.parseInt((String) ventana2.getVentana2_ComboBox_salida().getSelectedItem());
                hora_llegada = Integer.parseInt((String) ventana2.getVentana2_ComboBox_llegada().getSelectedItem());

                if ((hora_llegada - (GTMDestino)) < (horaSalida - (GTMOrigen))) {
                    Duracion = (24 - (horaSalida - (GTMOrigen))) + (hora_llegada - (GTMDestino));

                } else {
                    Duracion = (hora_llegada - (GTMDestino)) - (horaSalida - (GTMOrigen));
                }

//             for (int i = 0; i < modelo.getLista_Vuelos().size(); i++) {
//                if (String.valueOf(modelo.getLista_Vuelos().get(i).getIdentificador()).equals(ventana2.getVentana2_numerode_vuelo().getText())) {
//                    modelo.getLista_Vuelos().get(i).setIdentificador(Integer.parseInt(ventana2.getVentana2_numerode_vuelo().getText()));
//                }
//            }
                ventana2.getVentana2_Tabla_Vuelos().setValueAt(String.valueOf(numeroidentificador), selectedRow, 0);
                ventana2.getVentana2_Tabla_Vuelos().setValueAt(Descripcion, selectedRow, 1);
                ventana2.getVentana2_Tabla_Vuelos().setValueAt(String.valueOf(horaSalida), selectedRow, 2);
                ventana2.getVentana2_Tabla_Vuelos().setValueAt(String.valueOf(hora_llegada), selectedRow, 3);
                ventana2.getVentana2_Tabla_Vuelos().setValueAt(String.valueOf(Duracion), selectedRow, 4);

            }

            ventana2.getVentana2_numerode_vuelo().setEnabled(true);
            ventana2.getVentana2_numerode_vuelo().setText("");

            ventana2.getVentana2_Tabla_Vuelos().clearSelection();

        } else if (e.getSource() == ventana2.getVentan2_boton_agregar_escala()) {
            int numeroidentificador;
            String Ciudad_Orige = null;
            String Ciudad_Destino = null;
            String Descripcion;
            int horaSalida;
            int hora_llegada;// horas local

            int GTMOrigen = 0;
            int GTMDestino = 0;
            int Duracion;

            String identificador_vuelo = ventana2.getVentana2_numerode_vuelo().getText();

            for (int i = 0; i < modelo.getLista_Vuelos().size(); i++) {

                if (String.valueOf(modelo.getLista_Vuelos().get(i).getIdentificador()).equals(identificador_vuelo)) {

                    int total = ventana2.getVentana_combox_Escala().getSelectedIndex();

                    if (total >= 0) {
                        for (int j = 0; j < modelo.getList_Ciudades().size(); j++) {
                            if (total == j) {

                                Ciudad_Orige = modelo.getList_Ciudades().get(j).getNombre_Ciudad();
                                GTMOrigen = Integer.parseInt(modelo.getList_Ciudades().get(j).getGMT());

                            }

                        }
                    }

                    hora_llegada = Integer.parseInt((String) ventana2.getVentana2_comboEscala_salida().getSelectedItem());
                    horaSalida = Integer.parseInt((String) ventana2.getVentana2_comboEscala_llegada().getSelectedItem());

                    modelo.getLista_Vuelos().get(i).getLista_escalas().add(new Escala(String.valueOf(Ciudad_Orige), String.valueOf(hora_llegada), String.valueOf(horaSalida), String.valueOf(GTMOrigen)));

                    Object[] columna = new Object[ventana2.getModelito().getColumnCount()];

                    int duracion_de_escala = Math.abs(hora_llegada - horaSalida);

                    columna[0] = String.valueOf(Ciudad_Orige);
                    columna[1] = String.valueOf(hora_llegada);
                    columna[2] = String.valueOf(horaSalida);
                    columna[3] = String.valueOf(duracion_de_escala);

                    ventana2.getModelito().addRow(columna);
                    ventana2.getVentana2_Tabla_Escalas().setModel(ventana2.getModelito());
                }

            }

        }

    }

    @Override
    public void mouseClicked(MouseEvent evt) {

        if (evt.getSource() == ventana.getTabla_ciudad()) {

            if (evt.getClickCount() == 1) { // Detectar un solo clic

                int selectedRow = ventana.getTabla_ciudad().getSelectedRow();
                if (selectedRow >= 0) {

                    String id = (String) ventana.getTabla_ciudad().getValueAt(selectedRow, 0);
                    String nombre = (String) ventana.getTabla_ciudad().getValueAt(selectedRow, 1);
                    String gmt = (String) ventana.getTabla_ciudad().getValueAt(selectedRow, 2);

                    ventana.getVentana1_nombre_CIUDAD().setText(nombre);
                    ventana.getVentana1_caja_ID().setText(id);

                    ventana.getVentana1_caja_ID().setEnabled(false);
                    ventana.getVentana1_boton_actualizar().setEnabled(true);
                    ventana.getVentana1_boton_agregar().setEnabled(false);

                }

            }
            //comienza la segunda ventana

        }else if(evt.getSource()==ventana2.getVentana2_Tabla_Vuelos()){
        
        String ciudad;
        String hora_llegada;
        String hora_salida;
        String Escala;

        if (evt.getClickCount() == 1) { // Detectar un solo clic

            ventana2.getModelito().setRowCount(0);

            ventana2.getVentana2_Tabla_Escalas();

            for (int i = ventana2.getModelito().getRowCount() - 1; i >= 0; i--) {
                ventana2.getModelito().removeRow(i);
            }
            ventana2.getVentana2_Tabla_Escalas().setModel(ventana2.getModelito());

            int selectedRow = ventana2.getVentana2_Tabla_Vuelos().getSelectedRow();
            if (selectedRow >= 0) {

                ventana2.getVentana2_numerode_vuelo().setEnabled(false);
                ventana2.getVentana2_actualizar_vuelo().setEnabled(true);
                ventana2.getVentan2_boton_agregar_escala().setEnabled(true);
                ventana2.getVentana2_Tabla_Escalas().setEnabled(true);

                String numero_vuelo = (String) ventana2.getVentana2_Tabla_Vuelos().getValueAt(selectedRow, 0);

                for (int i = 0; i < modelo.getLista_Vuelos().size(); i++) {
                    if (String.valueOf(modelo.getLista_Vuelos().get(i).getIdentificador()).equals(numero_vuelo)) {

                        for (int j = 0; j < modelo.getLista_Vuelos().get(i).getLista_escalas().size(); j++) {

                            ciudad = modelo.getLista_Vuelos().get(i).getLista_escalas().get(j).getCiudad();
                            hora_llegada = modelo.getLista_Vuelos().get(i).getLista_escalas().get(j).getHora_llegada();
                            hora_salida = modelo.getLista_Vuelos().get(i).getLista_escalas().get(j).getHora_salida();
                            Escala = modelo.getLista_Vuelos().get(i).getLista_escalas().get(j).getHora_salida();

                            Object[] columna = new Object[ventana2.getModelito().getColumnCount()];

                            columna[0] = String.valueOf(ciudad);
                            columna[1] = String.valueOf(hora_llegada);
                            columna[2] = String.valueOf(hora_salida);
                            columna[3] = String.valueOf(Escala);

                            ventana2.getModelito().addRow(columna);
                            ventana2.getVentana2_Tabla_Escalas().setModel(ventana2.getModelito());

                        }

                    }
                }

                ventana2.getVentana2_numerode_vuelo().setText(numero_vuelo);
            }

        }
        
        
        }
       
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
