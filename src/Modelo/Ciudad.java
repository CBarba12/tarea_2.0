/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author alexb
 */
public class Ciudad {
    private String id_Ciudad;
    private String  nombre_vuelo;
    private String GMT;
  

    public Ciudad(String id_vuelos, String nombre_vuelo, String GMT) {
        this.id_Ciudad = id_vuelos;
        this.nombre_vuelo = nombre_vuelo;
        this.GMT = GMT;
       
        
    }

    public String getId_Ciudad() {
        return id_Ciudad;
    }

    public void setId_Ciudad(String id_Ciudad) {
        this.id_Ciudad = id_Ciudad;
    }

 

    public String getNombre_Ciudad() {
        return nombre_vuelo;
    }

    public void setNombre_vuelo(String nombre_vuelo) {
        this.nombre_vuelo = nombre_vuelo;
    }

    public String getGMT() {
        return GMT;
    }

    public void setGMT(String GMT) {
        this.GMT = GMT;
    }
}
