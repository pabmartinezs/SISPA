/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sispa.dto;

import java.io.Serializable;
import sispa.entity.Producto;
import sispa.entity.SolicitudPedido;
import sispa.entity.Usuario;

/**
 *
 * @author Pablo
 */
public class solicitudFullDTO implements Serializable{
    private SolicitudPedido objsolicitudpedido;
    private Usuario objusuario;
    private Producto objproducto;

    public solicitudFullDTO() {
    }

    public solicitudFullDTO(SolicitudPedido objsolicitudpedido, Usuario objusuario, Producto objproducto) {
        this.objsolicitudpedido = objsolicitudpedido;
        this.objusuario = objusuario;
        this.objproducto = objproducto;
    }

    public SolicitudPedido getObjsolicitudpedido() {
        return objsolicitudpedido;
    }

    public void setObjsolicitudpedido(SolicitudPedido objsolicitudpedido) {
        this.objsolicitudpedido = objsolicitudpedido;
    }

    public Usuario getObjusuario() {
        return objusuario;
    }

    public void setObjusuario(Usuario objusuario) {
        this.objusuario = objusuario;
    }

    public Producto getObjproducto() {
        return objproducto;
    }

    public void setObjproducto(Producto objproducto) {
        this.objproducto = objproducto;
    }

    @Override
    public String toString() {
        return "solicitudFullDTO{" + "objsolicitudpedido=" + objsolicitudpedido + ", objusuario=" + objusuario + ", objproducto=" + objproducto + '}';
    }
    
    
}
