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
@Table(name = "unidad", catalog = "bdingsoft", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unidad.findAll", query = "SELECT u FROM Unidad u"),
    @NamedQuery(name = "Unidad.findByIdUnidad", query = "SELECT u FROM Unidad u WHERE u.idUnidad = :idUnidad"),
    @NamedQuery(name = "Unidad.findByNombreUnidad", query = "SELECT u FROM Unidad u WHERE u.nombreUnidad = :nombreUnidad"),
    @NamedQuery(name = "Unidad.findByEstadoUnidad", query = "SELECT u FROM Unidad u WHERE u.estadoUnidad = :estadoUnidad")})
public class Unidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_unidad", nullable = false)
    private Integer idUnidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_unidad", nullable = false, length = 100)
    private String nombreUnidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_unidad", nullable = false)
    private int estadoUnidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidad")
    private List<Producto> productoList;

    public Unidad() {
    }

    public Unidad(Integer idUnidad) {
        this.idUnidad = idUnidad;
    }

    public Unidad(Integer idUnidad, String nombreUnidad, int estadoUnidad) {
        this.idUnidad = idUnidad;
        this.nombreUnidad = nombreUnidad;
        this.estadoUnidad = estadoUnidad;
    }

    public Integer getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Integer idUnidad) {
        this.idUnidad = idUnidad;
    }

    public String getNombreUnidad() {
        return nombreUnidad;
    }

    public void setNombreUnidad(String nombreUnidad) {
        this.nombreUnidad = nombreUnidad;
    }

    public int getEstadoUnidad() {
        return estadoUnidad;
    }

    public void setEstadoUnidad(int estadoUnidad) {
        this.estadoUnidad = estadoUnidad;
    }

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUnidad != null ? idUnidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unidad)) {
            return false;
        }
        Unidad other = (Unidad) object;
        if ((this.idUnidad == null && other.idUnidad != null) || (this.idUnidad != null && !this.idUnidad.equals(other.idUnidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sispa.entity.Unidad[ idUnidad=" + idUnidad + " ]";
    }
    
}
