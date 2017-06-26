/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sispa.entity;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pablo
 */
@Entity
@Table(name = "menu", catalog = "bdingsoft", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(
            name = "Menu.Listar",
            query = "SELECT NEW sispa.dto.menuperfilDTO(m,m.perfilCodPerfil)"
            + "FROM Menu m"
    ),
    
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m"),
    @NamedQuery(name = "Menu.findByIdMenu", query = "SELECT m FROM Menu m WHERE m.idMenu = :idMenu"),
    @NamedQuery(name = "Menu.findByNombreMenu", query = "SELECT m FROM Menu m WHERE m.nombreMenu = :nombreMenu"),
    @NamedQuery(name = "Menu.findByPadreMenu", query = "SELECT m FROM Menu m WHERE m.padreMenu = :padreMenu"),
    @NamedQuery(name = "Menu.findByDestinoMenu", query = "SELECT m FROM Menu m WHERE m.destinoMenu = :destinoMenu")})
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_menu", nullable = false)
    private Integer idMenu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "nombre_menu", nullable = false, length = 35)
    private String nombreMenu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "padre_menu", nullable = false)
    private int padreMenu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "destino_menu", nullable = false, length = 30)
    private String destinoMenu;
    @JoinColumn(name = "perfil_cod_perfil", referencedColumnName = "id_perfil", nullable = false)
    @ManyToOne(optional = false)
    private Perfil perfilCodPerfil;

    public Menu() {
    }

    public Menu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public Menu(Integer idMenu, String nombreMenu, int padreMenu, String destinoMenu) {
        this.idMenu = idMenu;
        this.nombreMenu = nombreMenu;
        this.padreMenu = padreMenu;
        this.destinoMenu = destinoMenu;
    }

    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public String getNombreMenu() {
        return nombreMenu;
    }

    public void setNombreMenu(String nombreMenu) {
        this.nombreMenu = nombreMenu;
    }

    public int getPadreMenu() {
        return padreMenu;
    }

    public void setPadreMenu(int padreMenu) {
        this.padreMenu = padreMenu;
    }

    public String getDestinoMenu() {
        return destinoMenu;
    }

    public void setDestinoMenu(String destinoMenu) {
        this.destinoMenu = destinoMenu;
    }

    public Perfil getPerfilCodPerfil() {
        return perfilCodPerfil;
    }

    public void setPerfilCodPerfil(Perfil perfilCodPerfil) {
        this.perfilCodPerfil = perfilCodPerfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMenu != null ? idMenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.idMenu == null && other.idMenu != null) || (this.idMenu != null && !this.idMenu.equals(other.idMenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sispa.entity.Menu[ idMenu=" + idMenu + " ]";
    }
    
}
