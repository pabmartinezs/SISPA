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
@Table(name = "usuario", catalog = "bdingsoft", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(
            name = "Usuario.validar",
            query = "SELECT NEW sispa.dto.usuarioescuelaperfilDTO(u,u.idEscuela,u.idPerfil)"
            + "FROM Usuario u WHERE u.usernameUsuario = :usernameUsuario AND u.passUsuario = :passUsuario"
    ),
    
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuario.findByNombreUsuario", query = "SELECT u FROM Usuario u WHERE u.nombreUsuario = :nombreUsuario"),
    @NamedQuery(name = "Usuario.findByApellidoUsuario", query = "SELECT u FROM Usuario u WHERE u.apellidoUsuario = :apellidoUsuario"),
    @NamedQuery(name = "Usuario.findByRutUsuario", query = "SELECT u FROM Usuario u WHERE u.rutUsuario = :rutUsuario"),
    @NamedQuery(name = "Usuario.findByMailUsuario", query = "SELECT u FROM Usuario u WHERE u.mailUsuario = :mailUsuario"),
    @NamedQuery(name = "Usuario.findByUsernameUsuario", query = "SELECT u FROM Usuario u WHERE u.usernameUsuario = :usernameUsuario"),
    @NamedQuery(name = "Usuario.findByPassUsuario", query = "SELECT u FROM Usuario u WHERE u.passUsuario = :passUsuario"),
    @NamedQuery(name = "Usuario.findByEstadoUsuario", query = "SELECT u FROM Usuario u WHERE u.estadoUsuario = :estadoUsuario"),
    @NamedQuery(name = "Usuario.findByDomicilioUsuario", query = "SELECT u FROM Usuario u WHERE u.domicilioUsuario = :domicilioUsuario"),
    @NamedQuery(name = "Usuario.findByTelefonoUsuario", query = "SELECT u FROM Usuario u WHERE u.telefonoUsuario = :telefonoUsuario")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nombre_usuario", nullable = false, length = 150)
    private String nombreUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "apellido_usuario", nullable = false, length = 150)
    private String apellidoUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "rut_usuario", nullable = false, length = 15)
    private String rutUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "mail_usuario", nullable = false, length = 250)
    private String mailUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "username_usuario", nullable = false, length = 128)
    private String usernameUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "pass_usuario", nullable = false, length = 128)
    private String passUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_usuario", nullable = false)
    private int estadoUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "domicilio_usuario", nullable = false, length = 200)
    private String domicilioUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefono_usuario", nullable = false)
    private int telefonoUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<SolicitudPedido> solicitudPedidoList;
    @JoinColumn(name = "id_escuela", referencedColumnName = "id_escuela", nullable = false)
    @ManyToOne(optional = false)
    private Escuela idEscuela;
    @JoinColumn(name = "id_perfil", referencedColumnName = "id_perfil", nullable = false)
    @ManyToOne(optional = false)
    private Perfil idPerfil;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<SolicitudDevolucion> solicitudDevolucionList;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Integer idUsuario, String nombreUsuario, String apellidoUsuario, String rutUsuario, String mailUsuario, String usernameUsuario, String passUsuario, int estadoUsuario, String domicilioUsuario, int telefonoUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.rutUsuario = rutUsuario;
        this.mailUsuario = mailUsuario;
        this.usernameUsuario = usernameUsuario;
        this.passUsuario = passUsuario;
        this.estadoUsuario = estadoUsuario;
        this.domicilioUsuario = domicilioUsuario;
        this.telefonoUsuario = telefonoUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getRutUsuario() {
        return rutUsuario;
    }

    public void setRutUsuario(String rutUsuario) {
        this.rutUsuario = rutUsuario;
    }

    public String getMailUsuario() {
        return mailUsuario;
    }

    public void setMailUsuario(String mailUsuario) {
        this.mailUsuario = mailUsuario;
    }

    public String getUsernameUsuario() {
        return usernameUsuario;
    }

    public void setUsernameUsuario(String usernameUsuario) {
        this.usernameUsuario = usernameUsuario;
    }

    public String getPassUsuario() {
        return passUsuario;
    }

    public void setPassUsuario(String passUsuario) {
        this.passUsuario = passUsuario;
    }

    public int getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(int estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public String getDomicilioUsuario() {
        return domicilioUsuario;
    }

    public void setDomicilioUsuario(String domicilioUsuario) {
        this.domicilioUsuario = domicilioUsuario;
    }

    public int getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(int telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    @XmlTransient
    public List<SolicitudPedido> getSolicitudPedidoList() {
        return solicitudPedidoList;
    }

    public void setSolicitudPedidoList(List<SolicitudPedido> solicitudPedidoList) {
        this.solicitudPedidoList = solicitudPedidoList;
    }

    public Escuela getIdEscuela() {
        return idEscuela;
    }

    public void setIdEscuela(Escuela idEscuela) {
        this.idEscuela = idEscuela;
    }

    public Perfil getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Perfil idPerfil) {
        this.idPerfil = idPerfil;
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
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sispa.entity.Usuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
