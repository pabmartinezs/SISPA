/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sispa.dto;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Pablo
 */
public class pedidoDTO implements Serializable{
    private int id_pedido;
    private Date fecha_pedido;
    private Date fecha_retiro;
    private int estado_pedido;
    private String observacion_pedido;
    private int id_producto;
    private int id_usuario;

    public pedidoDTO() {
    }

    public pedidoDTO(int id_pedido, Date fecha_pedido, Date fecha_retiro, int estado_pedido, String observacion_pedido, int id_producto, int id_usuario) {
        this.id_pedido = id_pedido;
        this.fecha_pedido = fecha_pedido;
        this.fecha_retiro = fecha_retiro;
        this.estado_pedido = estado_pedido;
        this.observacion_pedido = observacion_pedido;
        this.id_producto = id_producto;
        this.id_usuario = id_usuario;
    }

    public pedidoDTO(Date fecha_pedido, Date fecha_retiro, int estado_pedido, String observacion_pedido, int id_producto, int id_usuario) {
        this.fecha_pedido = fecha_pedido;
        this.fecha_retiro = fecha_retiro;
        this.estado_pedido = estado_pedido;
        this.observacion_pedido = observacion_pedido;
        this.id_producto = id_producto;
        this.id_usuario = id_usuario;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Date getFecha_pedido() {
        return fecha_pedido;
    }

    public void setFecha_pedido(Date fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }

    public Date getFecha_retiro() {
        return fecha_retiro;
    }

    public void setFecha_retiro(Date fecha_retiro) {
        this.fecha_retiro = fecha_retiro;
    }

    public int getEstado_pedido() {
        return estado_pedido;
    }

    public void setEstado_pedido(int estado_pedido) {
        this.estado_pedido = estado_pedido;
    }

    

    public String getObservacion_pedido() {
        return observacion_pedido;
    }

    public void setObservacion_pedido(String observacion_pedido) {
        this.observacion_pedido = observacion_pedido;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    @Override
    public String toString() {
        return "pedidoDTO{" + "id_pedido=" + id_pedido + ", fecha_pedido=" + fecha_pedido + ", fecha_retiro=" + fecha_retiro + ", estado_pedido=" + estado_pedido + ", observacion_pedido=" + observacion_pedido + ", id_producto=" + id_producto + ", id_usuario=" + id_usuario + '}';
    }
    
    
    
}
