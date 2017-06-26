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
public class usuarioDTO implements Serializable{
    private int id_usuario;
    private String nombre_usuario;
    private String apellido_usuario;
    private String run_usuario;
    private String username_usuario;
    private String email_usuario;
    private String pass_usuario;
    private int estado_cuenta_usuario;
    private String domicilio_usuario;
    private int id_perfil;
    private int id_escuela;
    
    public usuarioDTO(){}
    
    public usuarioDTO(int idusu, String nomusu, String apeusu, String runusu, 
            String usrusu, String mailusu, String passusu, int statusu, String domusu, int perusu, int schusu){
        this.id_usuario = idusu;
        this.nombre_usuario = nomusu;
        this.apellido_usuario = apeusu;
        this.run_usuario = runusu;
        this.username_usuario = usrusu;
        this.email_usuario = mailusu;
        this.pass_usuario = passusu;
        this.estado_cuenta_usuario = statusu;
        this.domicilio_usuario = domusu;
        this.id_perfil = perusu;
        this.id_escuela = schusu;
    }
    
    public usuarioDTO(String nomusu, String apeusu, String runusu, 
            String usrusu, String mailusu, String passusu, int statusu, String domusu, int perusu, int schusu){
        this.nombre_usuario = nomusu;
        this.apellido_usuario = apeusu;
        this.run_usuario = runusu;
        this.username_usuario = usrusu;
        this.email_usuario = mailusu;
        this.pass_usuario = passusu;
        this.estado_cuenta_usuario = statusu;
        this.domicilio_usuario = domusu;
        this.id_perfil = perusu;
        this.id_escuela = schusu;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getApellido_usuario() {
        return apellido_usuario;
    }

    public void setApellido_usuario(String apellido_usuario) {
        this.apellido_usuario = apellido_usuario;
    }

    public String getRun_usuario() {
        return run_usuario;
    }

    public void setRun_usuario(String run_usuario) {
        this.run_usuario = run_usuario;
    }

    public String getUsername_usuario() {
        return username_usuario;
    }

    public void setUsername_usuario(String username_usuario) {
        this.username_usuario = username_usuario;
    }

    public String getEmail_usuario() {
        return email_usuario;
    }

    public void setEmail_usuario(String email_usuario) {
        this.email_usuario = email_usuario;
    }

    public String getPass_usuario() {
        return pass_usuario;
    }

    public void setPass_usuario(String pass_usuario) {
        this.pass_usuario = pass_usuario;
    }

    public int isEstado_cuenta_usuario() {
        return estado_cuenta_usuario;
    }

    public void setEstado_cuenta_usuario(int estado_cuenta_usuario) {
        this.estado_cuenta_usuario = estado_cuenta_usuario;
    }

    public String getDomicilio_usuario() {
        return domicilio_usuario;
    }

    public void setDomicilio_usuario(String domicilio_usuario) {
        this.domicilio_usuario = domicilio_usuario;
    }

    public int getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(int id_perfil) {
        this.id_perfil = id_perfil;
    }

    public int getId_escuela() {
        return id_escuela;
    }

    public void setId_escuela(int id_escuela) {
        this.id_escuela = id_escuela;
    }

    @Override
    public String toString() {
        return "usuarioDTO{" + "id_usuario=" + id_usuario + ", nombre_usuario=" + nombre_usuario + ", apellido_usuario=" + apellido_usuario + ", run_usuario=" + run_usuario + ", username_usuario=" + username_usuario + ", email_usuario=" + email_usuario + ", pass_usuario=" + pass_usuario + ", estado_cuenta_usuario=" + estado_cuenta_usuario + ", domicilio_usuario=" + domicilio_usuario + ", id_perfil=" + id_perfil + ", id_escuela=" + id_escuela + '}';
    }
    
    
    
    
}

