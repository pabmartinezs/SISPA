package sispa.dto;

import java.io.Serializable;

public class categoriaDTO implements Serializable{
    private int id_categoria;
    private String descripcion_categoria;
    private int estado_categoria;

    public categoriaDTO() {
    }

    public categoriaDTO(int id_categoria, String descripcion_categoria, int estado_categoria) {
        this.id_categoria = id_categoria;
        this.descripcion_categoria = descripcion_categoria;
        this.estado_categoria = estado_categoria;
    }

    public categoriaDTO(String descripcion_categoria, int estado_categoria) {
        this.descripcion_categoria = descripcion_categoria;
        this.estado_categoria = estado_categoria;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getDescripcion_categoria() {
        return descripcion_categoria;
    }

    public void setDescripcion_categoria(String descripcion_categoria) {
        this.descripcion_categoria = descripcion_categoria;
    }

    public int getEstado_categoria() {
        return estado_categoria;
    }

    public void setEstado_categoria(int estado_categoria) {
        this.estado_categoria = estado_categoria;
    }

    @Override
    public String toString() {
        return "categoriaDTO{" + "id_categoria=" + id_categoria + ", descripcion_categoria=" + descripcion_categoria + ", estado_categoria=" + estado_categoria + '}';
    }
    
    
}
