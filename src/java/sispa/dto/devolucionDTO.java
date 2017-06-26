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
public class devolucionDTO implements Serializable{
    private int id_devolucion;
    private Date fecha_devolucion;
    private String observacion_devolucion;
    private int id_pedido;
    private int id_usuario;

    public devolucionDTO(int id_devolucion, Date fecha_devolucion, String observacion_devolucion, int id_pedido, int id_usuario) {
        this.id_devolucion = id_devolucion;
        this.fecha_devolucion = fecha_devolucion;
        this.observacion_devolucion = observacion_devolucion;
        this.id_pedido = id_pedido;
        this.id_usuario = id_usuario;
    }

    public devolucionDTO() {
    }

    public devolucionDTO(Date fecha_devolucion, String observacion_devolucion, int id_pedido, int id_usuario) {
        this.fecha_devolucion = fecha_devolucion;
        this.observacion_devolucion = observacion_devolucion;
        this.id_pedido = id_pedido;
        this.id_usuario = id_usuario;
    }

    public int getId_devolucion() {
        return id_devolucion;
    }

    public void setId_devolucion(int id_devolucion) {
        this.id_devolucion = id_devolucion;
    }

    public Date getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setFecha_devolucion(Date fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    public String getObservacion_devolucion() {
        return observacion_devolucion;
    }

    public void setObservacion_devolucion(String observacion_devolucion) {
        this.observacion_devolucion = observacion_devolucion;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    @Override
    public String toString() {
        return "devolucionDTO{" + "id_devolucion=" + id_devolucion + ", fecha_devolucion=" + fecha_devolucion + ", observacion_devolucion=" + observacion_devolucion + ", id_pedido=" + id_pedido + ", id_usuario=" + id_usuario + '}';
    }
    
    
}
