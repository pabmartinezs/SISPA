/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sispa.dto;

import java.io.Serializable;
import sispa.entity.Producto;
import sispa.entity.SolicitudDevolucion;
import sispa.entity.SolicitudPedido;

/**
 *
 * @author Pablo
 */
public class devolucionFullDTO implements Serializable{
    private SolicitudDevolucion objdevolucion;
    private Producto objproducto;
    private SolicitudPedido objpedido;

    public devolucionFullDTO() {
    }

    public devolucionFullDTO(SolicitudDevolucion objdevolucion, Producto objproducto, SolicitudPedido objpedido) {
        this.objdevolucion = objdevolucion;
        this.objproducto = objproducto;
        this.objpedido = objpedido;
    }

    public SolicitudDevolucion getObjdevolucion() {
        return objdevolucion;
    }

    public void setObjdevolucion(SolicitudDevolucion objdevolucion) {
        this.objdevolucion = objdevolucion;
    }

    public Producto getObjproducto() {
        return objproducto;
    }

    public void setObjproducto(Producto objproducto) {
        this.objproducto = objproducto;
    }

    public SolicitudPedido getObjpedido() {
        return objpedido;
    }

    public void setObjpedido(SolicitudPedido objpedido) {
        this.objpedido = objpedido;
    }

    @Override
    public String toString() {
        return "devolucionFullDTO{" + "objdevolucion=" + objdevolucion + ", objproducto=" + objproducto + ", objpedido=" + objpedido + '}';
    }
    
    
}
