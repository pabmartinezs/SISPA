/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sispa.dto;

import java.io.Serializable;
import sispa.entity.Menu;
import sispa.entity.Perfil;

/**
 *
 * @author Pablo
 */
public class menuperfilDTO implements Serializable{
    private Menu objmenu;
    private Perfil objperfil;

    public menuperfilDTO() {
    }

    public menuperfilDTO(Menu objmenu, Perfil objperfil) {
        this.objmenu = objmenu;
        this.objperfil = objperfil;
    }

    public Menu getObjmenu() {
        return objmenu;
    }

    public void setObjmenu(Menu objmenu) {
        this.objmenu = objmenu;
    }

    public Perfil getObjperfil() {
        return objperfil;
    }

    public void setObjperfil(Perfil objperfil) {
        this.objperfil = objperfil;
    }

    @Override
    public String toString() {
        return "menuperfilDTO{" + "objmenu=" + objmenu + ", objperfil=" + objperfil + '}';
    }
    
    

}
