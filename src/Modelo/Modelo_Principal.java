/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author alexb
 */
public class Modelo_Principal {
   ArrayList<Vuelo> lista_Vuelos;
   ArrayList<Ciudad> List_Ciudades;

    public Modelo_Principal() {
        lista_Vuelos=new ArrayList<> ();
       List_Ciudades=new ArrayList<> ();
    }

    public ArrayList<Vuelo> getLista_Vuelos() {
        return lista_Vuelos;
    }

    public void setLista_Vuelos(ArrayList<Vuelo> lista_Vuelos) {
        this.lista_Vuelos = lista_Vuelos;
    }

    public ArrayList<Ciudad> getList_Ciudades() {
        return List_Ciudades;
    }

    public void setList_Ciudades(ArrayList<Ciudad> List_Ciudades) {
        this.List_Ciudades = List_Ciudades;
    }
   
}
