/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Controlador;

import Modelo.Modelo_Principal;
import vista.Ventana_1;
import vista.Ventana_2;

/**
 *
 * @author alexb
 */
public class Tarea20 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Ventana_1 v1=new Ventana_1();
        Ventana_2 v2=new Ventana_2();
        Modelo.Modelo_Principal mod=new Modelo_Principal();
         
        
        Controlador p =new Controlador(mod, v2, v1);
        
    }
    
}
