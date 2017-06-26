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
public class productoDTO implements Serializable{
    private int id_producto;
    private String descripcion_producto;
    private int stock_producto;
    private String imagen_pructo;
    private int estado_producto;
    private String observacion_producto;
    private String ubicacion_producto;
    private int id_categoria;
    private int id_marca;
    private int id_proveedor;
    private int id_unidad;

    public productoDTO() {
    }

    public productoDTO(String descripcion_producto, int stock_producto, String imagen_pructo, int estado_producto, String observacion_producto, String ubicacion_producto, int id_categoria, int id_marca, int id_proveedor, int id_unidad) {
        this.descripcion_producto = descripcion_producto;
        this.stock_producto = stock_producto;
        this.imagen_pructo = imagen_pructo;
        this.estado_producto = estado_producto;
        this.observacion_producto = observacion_producto;
        this.ubicacion_producto = ubicacion_producto;
        this.id_categoria = id_categoria;
        this.id_marca = id_marca;
        this.id_proveedor = id_proveedor;
        this.id_unidad = id_unidad;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    public int getStock_producto() {
        return stock_producto;
    }

    public void setStock_producto(int stock_producto) {
        this.stock_producto = stock_producto;
    }

    public String getImagen_pructo() {
        return imagen_pructo;
    }

    public void setImagen_pructo(String imagen_pructo) {
        this.imagen_pructo = imagen_pructo;
    }

    public int getEstado_producto() {
        return estado_producto;
    }

    public void setEstado_producto(int estado_producto) {
        this.estado_producto = estado_producto;
    }

    public String getObservacion_producto() {
        return observacion_producto;
    }

    public void setObservacion_producto(String observacion_producto) {
        this.observacion_producto = observacion_producto;
    }

    public String getUbicacion_producto() {
        return ubicacion_producto;
    }

    public void setUbicacion_producto(String ubicacion_producto) {
        this.ubicacion_producto = ubicacion_producto;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public int getId_unidad() {
        return id_unidad;
    }

    public void setId_unidad(int id_unidad) {
        this.id_unidad = id_unidad;
    }

    @Override
    public String toString() {
        return "productoDTO{" + "id_producto=" + id_producto + ", descripcion_producto=" + descripcion_producto + ", stock_producto=" + stock_producto + ", imagen_pructo=" + imagen_pructo + ", estado_producto=" + estado_producto + ", observacion_producto=" + observacion_producto + ", ubicacion_producto=" + ubicacion_producto + ", id_categoria=" + id_categoria + ", id_marca=" + id_marca + ", id_proveedor=" + id_proveedor + ", id_unidad=" + id_unidad + '}';
    }

    
}
