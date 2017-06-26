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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "producto", catalog = "bdingsoft", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.getAll", query = "SELECT NEW sispa.dto.productofullDTO(p,p.idCategoria,p.idMarca,p.idUnidad,p.idProveedor) FROM Producto p"),
    
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByIdProducto", query = "SELECT p FROM Producto p WHERE p.idProducto = :idProducto"),
    @NamedQuery(name = "Producto.findByDescripcionProducto", query = "SELECT p FROM Producto p WHERE p.descripcionProducto = :descripcionProducto"),
    @NamedQuery(name = "Producto.findByStockProducto", query = "SELECT p FROM Producto p WHERE p.stockProducto = :stockProducto"),
    @NamedQuery(name = "Producto.findByImagenProducto", query = "SELECT p FROM Producto p WHERE p.imagenProducto = :imagenProducto"),
    @NamedQuery(name = "Producto.findByEstadoProducto", query = "SELECT p FROM Producto p WHERE p.estadoProducto = :estadoProducto"),
    @NamedQuery(name = "Producto.findByObservacionProducto", query = "SELECT p FROM Producto p WHERE p.observacionProducto = :observacionProducto"),
    @NamedQuery(name = "Producto.findByUbicacionproducto", query = "SELECT p FROM Producto p WHERE p.ubicacionproducto = :ubicacionproducto")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_producto", nullable = false)
    private Integer idProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "descripcion_producto", nullable = false, length = 250)
    private String descripcionProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stock_producto", nullable = false)
    private int stockProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "imagen_producto", nullable = false, length = 250)
    private String imagenProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_producto", nullable = false)
    private int estadoProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "observacion_producto", nullable = false, length = 250)
    private String observacionProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Ubicacion_producto", nullable = false, length = 50)
    private String ubicacionproducto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMaterial")
    private List<SolicitudPedido> solicitudPedidoList;
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria", nullable = false)
    @ManyToOne(optional = false)
    private Categoria idCategoria;
    @JoinColumn(name = "id_marca", referencedColumnName = "id_marca", nullable = false)
    @ManyToOne(optional = false)
    private Marca idMarca;
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id_proveedor", nullable = false)
    @ManyToOne(optional = false)
    private Proveedor idProveedor;
    @JoinColumn(name = "id_unidad", referencedColumnName = "id_unidad", nullable = false)
    @ManyToOne(optional = false)
    private Unidad idUnidad;

    public Producto() {
    }

    public Producto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Producto(Integer idProducto, String descripcionProducto, int stockProducto, String imagenProducto, int estadoProducto, String observacionProducto, String ubicacionproducto) {
        this.idProducto = idProducto;
        this.descripcionProducto = descripcionProducto;
        this.stockProducto = stockProducto;
        this.imagenProducto = imagenProducto;
        this.estadoProducto = estadoProducto;
        this.observacionProducto = observacionProducto;
        this.ubicacionproducto = ubicacionproducto;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public int getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(int stockProducto) {
        this.stockProducto = stockProducto;
    }

    public String getImagenProducto() {
        return imagenProducto;
    }

    public void setImagenProducto(String imagenProducto) {
        this.imagenProducto = imagenProducto;
    }

    public int getEstadoProducto() {
        return estadoProducto;
    }

    public void setEstadoProducto(int estadoProducto) {
        this.estadoProducto = estadoProducto;
    }

    public String getObservacionProducto() {
        return observacionProducto;
    }

    public void setObservacionProducto(String observacionProducto) {
        this.observacionProducto = observacionProducto;
    }

    public String getUbicacionproducto() {
        return ubicacionproducto;
    }

    public void setUbicacionproducto(String ubicacionproducto) {
        this.ubicacionproducto = ubicacionproducto;
    }

    @XmlTransient
    public List<SolicitudPedido> getSolicitudPedidoList() {
        return solicitudPedidoList;
    }

    public void setSolicitudPedidoList(List<SolicitudPedido> solicitudPedidoList) {
        this.solicitudPedidoList = solicitudPedidoList;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Marca getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Marca idMarca) {
        this.idMarca = idMarca;
    }

    public Proveedor getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedor idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Unidad getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Unidad idUnidad) {
        this.idUnidad = idUnidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sispa.entity.Producto[ idProducto=" + idProducto + " ]";
    }
    
}
