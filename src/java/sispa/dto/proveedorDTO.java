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
public class proveedorDTO implements Serializable{
    private int id_proveedor;
    private String nombre_proveedor;
    private int estado_proveedor;

    public proveedorDTO() {
    }

    public proveedorDTO(int id_proveedor, String nombre_proveedor, int estado_proveedor) {
        this.id_proveedor = id_proveedor;
        this.nombre_proveedor = nombre_proveedor;
        this.estado_proveedor = estado_proveedor;
    }

    public proveedorDTO(String nombre_proveedor, int estado_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
        this.estado_proveedor = estado_proveedor;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public int isEstado_proveedor() {
        return estado_proveedor;
    }

    public void setEstado_proveedor(int estado_proveedor) {
        this.estado_proveedor = estado_proveedor;
    }

    @Override
    public String toString() {
        return "proveedorDTO{" + "id_proveedor=" + id_proveedor + ", nombre_proveedor=" + nombre_proveedor + ", estado_proveedor=" + estado_proveedor + '}';
    }
    
    
}
