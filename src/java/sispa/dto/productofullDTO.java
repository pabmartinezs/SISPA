/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sispa.dto;

import java.io.Serializable;
import sispa.entity.Categoria;
import sispa.entity.Marca;
import sispa.entity.Producto;
import sispa.entity.Proveedor;
import sispa.entity.Unidad;

/**
 *
 * @author Pablo
 */
public class productofullDTO implements Serializable{
    private Producto objproducto;
    private Categoria objcategoria;
    private Marca objmarca;
    private Unidad objunidad;
    private Proveedor objProveedor;

    public productofullDTO(Producto objproducto, Categoria objcategoria, Marca objmarca, Unidad objunidad, Proveedor objProveedor) {
        this.objproducto = objproducto;
        this.objcategoria = objcategoria;
        this.objmarca = objmarca;
        this.objunidad = objunidad;
        this.objProveedor = objProveedor;
    }

    public Producto getObjproducto() {
        return objproducto;
    }

    public void setObjproducto(Producto objproducto) {
        this.objproducto = objproducto;
    }

    public Categoria getObjcategoria() {
        return objcategoria;
    }

    public void setObjcategoria(Categoria objcategoria) {
        this.objcategoria = objcategoria;
    }

    public Marca getObjmarca() {
        return objmarca;
    }

    public void setObjmarca(Marca objmarca) {
        this.objmarca = objmarca;
    }

    public Unidad getObjunidad() {
        return objunidad;
    }

    public void setObjunidad(Unidad objunidad) {
        this.objunidad = objunidad;
    }

    public Proveedor getObjProveedor() {
        return objProveedor;
    }

    public void setObjProveedor(Proveedor objProveedor) {
        this.objProveedor = objProveedor;
    }

    @Override
    public String toString() {
        return "productofullDTO{" + "objproducto=" + objproducto + ", objcategoria=" + objcategoria + ", objmarca=" + objmarca + ", objunidad=" + objunidad + ", objProveedor=" + objProveedor + '}';
    }
    
    
}
