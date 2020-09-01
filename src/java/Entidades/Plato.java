/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

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
 * @author Xime
 */
@Entity
@Table(name = "plato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plato.findAll", query = "SELECT p FROM Plato p"),
    @NamedQuery(name = "Plato.findByIdPlato", query = "SELECT p FROM Plato p WHERE p.idPlato = :idPlato"),
    @NamedQuery(name = "Plato.findByDescripcionPlato", query = "SELECT p FROM Plato p WHERE p.descripcionPlato = :descripcionPlato"),
    @NamedQuery(name = "Plato.findByCategoria", query = "SELECT p FROM Plato p WHERE p.categoria = :categoria"),
    @NamedQuery(name = "Plato.findByPrecioPlato", query = "SELECT p FROM Plato p WHERE p.precioPlato = :precioPlato"),
    @NamedQuery(name = "Plato.findByImagen", query = "SELECT p FROM Plato p WHERE p.imagen = :imagen"),
    @NamedQuery(name = "Plato.findByEstadoPlato", query = "SELECT p FROM Plato p WHERE p.estadoPlato = :estadoPlato")})
public class Plato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_plato")
    private Integer idPlato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descripcion_plato")
    private String descripcionPlato;
    @Size(max = 255)
    @Column(name = "categoria")
    private String categoria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_plato")
    private double precioPlato;
    @Size(max = 255)
    @Column(name = "imagen")
    private String imagen;
    @Column(name = "estado_plato")
    @Temporal(TemporalType.TIME)
    private Date estadoPlato;
    @JoinColumn(name = "restaurante_ruc", referencedColumnName = "ruc")
    @ManyToOne(optional = false)
    private Restaurante restauranteRuc;

    public Plato() {
    }

    public Plato(Integer idPlato) {
        this.idPlato = idPlato;
    }

    public Plato(Integer idPlato, String descripcionPlato, double precioPlato) {
        this.idPlato = idPlato;
        this.descripcionPlato = descripcionPlato;
        this.precioPlato = precioPlato;
    }

    public Integer getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(Integer idPlato) {
        this.idPlato = idPlato;
    }

    public String getDescripcionPlato() {
        return descripcionPlato;
    }

    public void setDescripcionPlato(String descripcionPlato) {
        this.descripcionPlato = descripcionPlato;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecioPlato() {
        return precioPlato;
    }

    public void setPrecioPlato(double precioPlato) {
        this.precioPlato = precioPlato;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Date getEstadoPlato() {
        return estadoPlato;
    }

    public void setEstadoPlato(Date estadoPlato) {
        this.estadoPlato = estadoPlato;
    }

    public Restaurante getRestauranteRuc() {
        return restauranteRuc;
    }

    public void setRestauranteRuc(Restaurante restauranteRuc) {
        this.restauranteRuc = restauranteRuc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlato != null ? idPlato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plato)) {
            return false;
        }
        Plato other = (Plato) object;
        if ((this.idPlato == null && other.idPlato != null) || (this.idPlato != null && !this.idPlato.equals(other.idPlato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Plato[ idPlato=" + idPlato + " ]";
    }
    
}
