package sispa.dto;

import java.io.Serializable;

public class escuelaDTO implements Serializable{
    private int id_escuela;
    private String nombre_escuela;
    private int estado_escuela;

    public escuelaDTO() {
    }

    public escuelaDTO(int id_escuela, String nombre_escuela, int estado_escuela) {
        this.id_escuela = id_escuela;
        this.nombre_escuela = nombre_escuela;
        this.estado_escuela = estado_escuela;
    }

    public escuelaDTO(String nombre_escuela, int estado_escuela) {
        this.nombre_escuela = nombre_escuela;
        this.estado_escuela = estado_escuela;
    }

    public int getId_escuela() {
        return id_escuela;
    }

    public void setId_escuela(int id_escuela) {
        this.id_escuela = id_escuela;
    }

    public String getNombre_escuela() {
        return nombre_escuela;
    }

    public void setNombre_escuela(String nombre_escuela) {
        this.nombre_escuela = nombre_escuela;
    }

    public int getEstado_escuela() {
        return estado_escuela;
    }

    public void setEstado_escuela(int estado_escuela) {
        this.estado_escuela = estado_escuela;
    }

    @Override
    public String toString() {
        return "escuelaDTO{" + "id_escuela=" + id_escuela + ", nombre_escuela=" + nombre_escuela + ", estado_escuela=" + estado_escuela + '}';
    }

    
}
