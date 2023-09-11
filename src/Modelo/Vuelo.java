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
public class Vuelo {
    private int identificador;
    private String Ciudad_Orige;
    private String Ciudad_Destino;
    private int horaSalida;
    private int hora_llegada;// horas local
     ArrayList<Escala> lista_escalas;

     
    public Vuelo(int identificador, String Ciudad_Orige, String Ciudad_Destino, int horaSalida, int hora_llegada) {
        this.identificador = identificador;
        this.Ciudad_Orige = Ciudad_Orige;
        this.Ciudad_Destino = Ciudad_Destino;
        this.horaSalida = horaSalida;
        this.hora_llegada = hora_llegada;
       this.lista_escalas = new  ArrayList<>() ;
    }

   

    

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public ArrayList<Escala> getLista_escalas() {
        return lista_escalas;
    }

    public void setLista_escalas(ArrayList<Escala> lista_escalas) {
        this.lista_escalas = lista_escalas;
    }

    
  
    public String getCiudad_Orige() {
        return Ciudad_Orige;
    }

    public void setCiudad_Orige(String Ciudad_Orige) {
        this.Ciudad_Orige = Ciudad_Orige;
    }

    public String getCiudad_Destino() {
        return Ciudad_Destino;
    }

    public void setCiudad_Destino(String Ciudad_Destino) {
        this.Ciudad_Destino = Ciudad_Destino;
    }

    public int getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(int horaSalida) {
        this.horaSalida = horaSalida;
    }

    public int getHora_llegada() {
        return hora_llegada;
    }

    public void setHora_llegada(int hora_llegada) {
        this.hora_llegada = hora_llegada;
    }
    
      public void agregar_Escalas(Escala p){
       lista_escalas.add(p);
    }
      
      
}
