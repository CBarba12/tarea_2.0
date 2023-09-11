/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author alexb
 */
public class Escala {
    private String ciudad;
    private String hora_llegada;
    private String hora_salida;
    private String Escala;

    public Escala(String ciudad, String hora_llegada, String hora_salida, String Escala) {
        this.ciudad = ciudad;
        this.hora_llegada = hora_llegada;
        this.hora_salida = hora_salida;
        this.Escala = Escala;
    }
    
    
    

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getHora_llegada() {
        return hora_llegada;
    }

    public void setHora_llegada(String hora_llegada) {
        this.hora_llegada = hora_llegada;
    }

    public String getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(String hora_salida) {
        this.hora_salida = hora_salida;
    }

    public String getEscala() {
        return Escala;
    }

    public void setEscala(String Escala) {
        this.Escala = Escala;
    }

}
