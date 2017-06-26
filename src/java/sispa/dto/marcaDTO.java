/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sispa.dto;

import java.io.Serializable;

/**
 *
 * @author Pablo
 */
public class marcaDTO implements Serializable{
    private int id_marca;
    private String nombre_marca;
    private int estado_marca;

    public marcaDTO() {
    }

    public marcaDTO(int id_marca, String nombre_marca, int estado_marca) {
        this.id_marca = id_marca;
        this.nombre_marca = nombre_marca;
        this.estado_marca = estado_marca;
    }

    public marcaDTO(String nombre_marca, int estado_marca) {
        this.nombre_marca = nombre_marca;
        this.estado_marca = estado_marca;
    }

    public int getId_marca() {
        return id_marca;
    }

    public String getNombre_marca() {
        return nombre_marca;
    }

    public void setNombre_marca(String nombre_marca) {
        this.nombre_marca = nombre_marca;
    }

    public int isEstado_marca() {
        return estado_marca;
    }

    public void setEstado_marca(int estado_marca) {
        this.estado_marca = estado_marca;
    }

    @Override
    public String toString() {
        return "marcaDTO{" + "id_marca=" + id_marca + ", nombre_marca=" + nombre_marca + ", estado_marca=" + estado_marca + '}';
    }
    
    
}
