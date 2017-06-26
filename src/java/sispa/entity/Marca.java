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
@Table(name = "marca", catalog = "bdingsoft", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Marca.findAll", query = "SELECT m FROM Marca m"),
    @NamedQuery(name = "Marca.findByIdMarca", query = "SELECT m FROM Marca m WHERE m.idMarca = :idMarca"),
    @NamedQuery(name = "Marca.findByNombreMarca", query = "SELECT m FROM Marca m WHERE m.nombreMarca = :nombreMarca"),
    @NamedQuery(name = "Marca.findByEstadoMarca", query = "SELECT m FROM Marca m WHERE m.estadoMarca = :estadoMarca")})
public class Marca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_marca", nullable = false)
    private Integer idMarca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_marca", nullable = false, length = 100)
    private String nombreMarca;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_marca", nullable = false)
    private int estadoMarca;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMarca")
    private List<Producto> productoList;

    public Marca() {
    }

    public Marca(Integer idMarca) {
        this.idMarca = idMarca;
    }

    public Marca(Integer idMarca, String nombreMarca, int estadoMarca) {
        this.idMarca = idMarca;
        this.nombreMarca = nombreMarca;
        this.estadoMarca = estadoMarca;
    }

    public Integer getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public int getEstadoMarca() {
        return estadoMarca;
    }

    public void setEstadoMarca(int estadoMarca) {
        this.estadoMarca = estadoMarca;
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
        hash += (idMarca != null ? idMarca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Marca)) {
            return false;
        }
        Marca other = (Marca) object;
        if ((this.idMarca == null && other.idMarca != null) || (this.idMarca != null && !this.idMarca.equals(other.idMarca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sispa.entity.Marca[ idMarca=" + idMarca + " ]";
    }
    
}
