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
public class perfilDTO implements Serializable{
    private int id_perfil;
    private String descripcion_perfil;
    
    public perfilDTO(){}
    
    public perfilDTO(int idperfil, String desc){
        this.id_perfil = idperfil;
        this.descripcion_perfil = desc;
    }

    public int getId_perfil() {
        return id_perfil;
    }

    public String getDescripcion_perfil() {
        return descripcion_perfil;
    }

    public void setDescripcion_perfil(String descripcion_perfil) {
        this.descripcion_perfil = descripcion_perfil;
    }

    @Override
    public String toString() {
        return "perfilDTO{" + "id_perfil=" + id_perfil + ", descripcion_perfil=" + descripcion_perfil + '}';
    }
    
    
    
}
