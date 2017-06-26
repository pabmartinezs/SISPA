/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sispa.dto;

import java.io.Serializable;
import sispa.entity.Escuela;
import sispa.entity.Perfil;
import sispa.entity.Usuario;

/**
 *
 * @author Pablo
 */
public class usuarioescuelaperfilDTO implements Serializable{
    private Usuario objusuario;
    private Escuela objescuela;
    private Perfil objperfil;

    public usuarioescuelaperfilDTO() {
    }

    public usuarioescuelaperfilDTO(Usuario objusuario, Escuela objescuela, Perfil objperfil) {
        this.objusuario = objusuario;
        this.objescuela = objescuela;
        this.objperfil = objperfil;
    }

    public Usuario getObjusuario() {
        return objusuario;
    }

    public void setObjusuario(Usuario objusuario) {
        this.objusuario = objusuario;
    }

    public Escuela getObjescuela() {
        return objescuela;
    }

    public void setObjescuela(Escuela objescuela) {
        this.objescuela = objescuela;
    }

    public Perfil getObjperfil() {
        return objperfil;
    }

    public void setObjperfil(Perfil objperfil) {
        this.objperfil = objperfil;
    }

    @Override
    public String toString() {
        return "usuarioescuelaperfilDTO{" + "objusuario=" + objusuario + ", objescuela=" + objescuela + ", objperfil=" + objperfil + '}';
    }
    
    
    
}
