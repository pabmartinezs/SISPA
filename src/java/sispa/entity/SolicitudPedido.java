/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sispa.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Pablo
 */
@Entity
@Table(name = "solicitud_pedido", catalog = "bdingsoft", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SolicitudPedido.Listar", query = "SELECT NEW sispa.dto.solicitudFullDTO(s,s.idUsuario,s.idMaterial) FROM SolicitudPedido s"),
    
    @NamedQuery(name = "SolicitudPedido.findAll", query = "SELECT s FROM SolicitudPedido s"),
    @NamedQuery(name = "SolicitudPedido.findByIdPedido", query = "SELECT s FROM SolicitudPedido s WHERE s.idPedido = :idPedido"),
    @NamedQuery(name = "SolicitudPedido.findByFechaPedido", query = "SELECT s FROM SolicitudPedido s WHERE s.fechaPedido = :fechaPedido"),
    @NamedQuery(name = "SolicitudPedido.findByFechaRetiro", query = "SELECT s FROM SolicitudPedido s WHERE s.fechaRetiro = :fechaRetiro"),
    @NamedQuery(name = "SolicitudPedido.findByEstadoPedido", query = "SELECT s FROM SolicitudPedido s WHERE s.estadoPedido = :estadoPedido"),
    @NamedQuery(name = "SolicitudPedido.findByObservacionesPedido", query = "SELECT s FROM SolicitudPedido s WHERE s.observacionesPedido = :observacionesPedido")})
public class SolicitudPedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pedido", nullable = false)
    private Integer idPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_pedido", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_retiro", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaRetiro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_pedido", nullable = false)
    private int estadoPedido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "observaciones_pedido", nullable = false, length = 250)
    private String observacionesPedido;
    @JoinColumn(name = "id_material", referencedColumnName = "id_producto", nullable = false)
    @ManyToOne(optional = false)
    private Producto idMaterial;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false)
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPedido")
    private List<SolicitudDevolucion> solicitudDevolucionList;

    public SolicitudPedido() {
    }

    public SolicitudPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public SolicitudPedido(Integer idPedido, Date fechaPedido, Date fechaRetiro, int estadoPedido, String observacionesPedido) {
        this.idPedido = idPedido;
        this.fechaPedido = fechaPedido;
        this.fechaRetiro = fechaRetiro;
        this.estadoPedido = estadoPedido;
        this.observacionesPedido = observacionesPedido;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Date getFechaRetiro() {
        return fechaRetiro;
    }

    public void setFechaRetiro(Date fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }

    public int getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(int estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public String getObservacionesPedido() {
        return observacionesPedido;
    }

    public void setObservacionesPedido(String observacionesPedido) {
        this.observacionesPedido = observacionesPedido;
    }

    public Producto getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Producto idMaterial) {
        this.idMaterial = idMaterial;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public List<SolicitudDevolucion> getSolicitudDevolucionList() {
        return solicitudDevolucionList;
    }

    public void setSolicitudDevolucionList(List<SolicitudDevolucion> solicitudDevolucionList) {
        this.solicitudDevolucionList = solicitudDevolucionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPedido != null ? idPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitudPedido)) {
            return false;
        }
        SolicitudPedido other = (SolicitudPedido) object;
        if ((this.idPedido == null && other.idPedido != null) || (this.idPedido != null && !this.idPedido.equals(other.idPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sispa.entity.SolicitudPedido[ idPedido=" + idPedido + " ]";
    }
    
}
