/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sispa.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pablo
 */
@Entity
@Table(name = "solicitud_devolucion", catalog = "bdingsoft", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SolicitudDevolucion.findAll", query = "SELECT s FROM SolicitudDevolucion s"),
    @NamedQuery(name = "SolicitudDevolucion.findByIdDevolucion", query = "SELECT s FROM SolicitudDevolucion s WHERE s.idDevolucion = :idDevolucion"),
    @NamedQuery(name = "SolicitudDevolucion.findByFechaDevolucion", query = "SELECT s FROM SolicitudDevolucion s WHERE s.fechaDevolucion = :fechaDevolucion"),
    @NamedQuery(name = "SolicitudDevolucion.findByObservaiones", query = "SELECT s FROM SolicitudDevolucion s WHERE s.observaiones = :observaiones")})
public class SolicitudDevolucion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_devolucion", nullable = false)
    private Integer idDevolucion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_devolucion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaDevolucion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "observaiones", nullable = false, length = 250)
    private String observaiones;
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido", nullable = false)
    @ManyToOne(optional = false)
    private SolicitudPedido idPedido;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false)
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public SolicitudDevolucion() {
    }

    public SolicitudDevolucion(Integer idDevolucion) {
        this.idDevolucion = idDevolucion;
    }

    public SolicitudDevolucion(Integer idDevolucion, Date fechaDevolucion, String observaiones) {
        this.idDevolucion = idDevolucion;
        this.fechaDevolucion = fechaDevolucion;
        this.observaiones = observaiones;
    }

    public Integer getIdDevolucion() {
        return idDevolucion;
    }

    public void setIdDevolucion(Integer idDevolucion) {
        this.idDevolucion = idDevolucion;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getObservaiones() {
        return observaiones;
    }

    public void setObservaiones(String observaiones) {
        this.observaiones = observaiones;
    }

    public SolicitudPedido getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(SolicitudPedido idPedido) {
        this.idPedido = idPedido;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDevolucion != null ? idDevolucion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitudDevolucion)) {
            return false;
        }
        SolicitudDevolucion other = (SolicitudDevolucion) object;
        if ((this.idDevolucion == null && other.idDevolucion != null) || (this.idDevolucion != null && !this.idDevolucion.equals(other.idDevolucion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sispa.entity.SolicitudDevolucion[ idDevolucion=" + idDevolucion + " ]";
    }
    
}
