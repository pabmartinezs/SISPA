/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sispa.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Pablo
 */
@Entity
@Table(name = "escuela", catalog = "bdingsoft", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Escuela.getALL", query = "SELECT NEW sispa.dto.escuelaDTO(e.idEscuela,e.nombreEscuela,e.estadoEscuela) FROM Escuela e"),
    
    @NamedQuery(name = "Escuela.findAll", query = "SELECT e FROM Escuela e"),
    @NamedQuery(name = "Escuela.findByIdEscuela", query = "SELECT e FROM Escuela e WHERE e.idEscuela = :idEscuela"),
    @NamedQuery(name = "Escuela.findByNombreEscuela", query = "SELECT e FROM Escuela e WHERE e.nombreEscuela = :nombreEscuela"),
    @NamedQuery(name = "Escuela.findByEstadoEscuela", query = "SELECT e FROM Escuela e WHERE e.estadoEscuela = :estadoEscuela")})
public class Escuela implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_escuela", nullable = false)
    private Integer idEscuela;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_escuela", nullable = false, length = 100)
    private String nombreEscuela;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_escuela", nullable = false)
    private int estadoEscuela;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEscuela")
    private List<Usuario> usuarioList;

    public Escuela() {
    }

    public Escuela(Integer idEscuela) {
        this.idEscuela = idEscuela;
    }

    public Escuela(Integer idEscuela, String nombreEscuela, int estadoEscuela) {
        this.idEscuela = idEscuela;
        this.nombreEscuela = nombreEscuela;
        this.estadoEscuela = estadoEscuela;
    }

    public Integer getIdEscuela() {
        return idEscuela;
    }

    public void setIdEscuela(Integer idEscuela) {
        this.idEscuela = idEscuela;
    }

    public String getNombreEscuela() {
        return nombreEscuela;
    }

    public void setNombreEscuela(String nombreEscuela) {
        this.nombreEscuela = nombreEscuela;
    }

    public int getEstadoEscuela() {
        return estadoEscuela;
    }

    public void setEstadoEscuela(int estadoEscuela) {
        this.estadoEscuela = estadoEscuela;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEscuela != null ? idEscuela.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Escuela)) {
            return false;
        }
        Escuela other = (Escuela) object;
        if ((this.idEscuela == null && other.idEscuela != null) || (this.idEscuela != null && !this.idEscuela.equals(other.idEscuela))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sispa.entity.Escuela[ idEscuela=" + idEscuela + " ]";
    }
    
}
