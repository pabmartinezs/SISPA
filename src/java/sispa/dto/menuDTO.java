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
public class menuDTO implements Serializable{
    private int id_menu;
    private String nombre_menu;
    private int padreMenu;
    private String destino_menu;
    private int id_perfil;

    public menuDTO() {
    }

    public menuDTO(int id_menu, String nombre_menu, int padreMenu, String destino_menu, int id_perfil) {
        this.id_menu = id_menu;
        this.nombre_menu = nombre_menu;
        this.padreMenu = padreMenu;
        this.destino_menu = destino_menu;
        this.id_perfil = id_perfil;
    }

    public menuDTO(String nombre_menu, int padreMenu, String destino_menu, int id_perfil) {
        this.nombre_menu = nombre_menu;
        this.padreMenu = padreMenu;
        this.destino_menu = destino_menu;
        this.id_perfil = id_perfil;
    }

    public int getId_menu() {
        return id_menu;
    }

    
    public String getNombre_menu() {
        return nombre_menu;
    }

    public void setNombre_menu(String nombre_menu) {
        this.nombre_menu = nombre_menu;
    }

    public int getPadreMenu() {
        return padreMenu;
    }

    public void setPadreMenu(int padreMenu) {
        this.padreMenu = padreMenu;
    }

    public String getDestino_menu() {
        return destino_menu;
    }

    public void setDestino_menu(String destino_menu) {
        this.destino_menu = destino_menu;
    }

    public int getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(int id_perfil) {
        this.id_perfil = id_perfil;
    }

    @Override
    public String toString() {
        return "menuDTO{" + "id_menu=" + id_menu + ", nombre_menu=" + nombre_menu + ", padreMenu=" + padreMenu + ", destino_menu=" + destino_menu + ", id_perfil=" + id_perfil + '}';
    }
    
    
}
