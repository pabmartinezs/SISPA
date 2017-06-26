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
public class unidadDTO implements Serializable{
    private int id_unidad;
    private String nombre_unidad;
    private int estado_unidad;

    public unidadDTO() {
    }

    public unidadDTO(int id_unidad, String nombre_unidad, int estado_unidad) {
        this.id_unidad = id_unidad;
        this.nombre_unidad = nombre_unidad;
        this.estado_unidad = estado_unidad;
    }

    public unidadDTO(String nombre_unidad, int estado_unidad) {
        this.nombre_unidad = nombre_unidad;
        this.estado_unidad = estado_unidad;
    }

    public int getId_unidad() {
        return id_unidad;
    }

    public String getNombre_unidad() {
        return nombre_unidad;
    }

    public void setNombre_unidad(String nombre_unidad) {
        this.nombre_unidad = nombre_unidad;
    }

    public int isEstado_unidad() {
        return estado_unidad;
    }

    public void setEstado_unidad(int estado_unidad) {
        this.estado_unidad = estado_unidad;
    }

    @Override
    public String toString() {
        return "unidadDTO{" + "id_unidad=" + id_unidad + ", nombre_unidad=" + nombre_unidad + ", estado_unidad=" + estado_unidad + '}';
    }
    
    
}
