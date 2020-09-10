/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

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
 * @author Xime
 */
@Entity
@Table(name = "plato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plato.findAll", query = "SELECT p FROM Plato p"),
    @NamedQuery(name = "Plato.findByIdplato", query = "SELECT p FROM Plato p WHERE p.idplato = :idplato"),
    @NamedQuery(name = "Plato.findByDescripcionplato", query = "SELECT p FROM Plato p WHERE p.descripcionplato = :descripcionplato"),
    @NamedQuery(name = "Plato.findByCategoria", query = "SELECT p FROM Plato p WHERE p.categoria = :categoria"),
    @NamedQuery(name = "Plato.findByPrecioplato", query = "SELECT p FROM Plato p WHERE p.precioplato = :precioplato"),
    @NamedQuery(name = "Plato.findByNombre", query = "SELECT p FROM Plato p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Plato.findByImagen", query = "SELECT p FROM Plato p WHERE p.imagen = :imagen"),
    @NamedQuery(name = "Plato.findByEstadoplato", query = "SELECT p FROM Plato p WHERE p.estadoplato = :estadoplato")})
public class Plato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idplato")
    private Integer idplato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descripcionplato")
    private String descripcionplato;
    @Size(max = 255)
    @Column(name = "categoria")
    private String categoria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precioplato")
    private double precioplato;
    @Size(max = 255)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 255)
    @Column(name = "imagen")
    private String imagen;
    @Size(max = 255)
    @Column(name = "estadoplato")
    private String estadoplato;
    @JoinColumn(name = "restauranteruc", referencedColumnName = "ruc")
    @ManyToOne(optional = false)
    private Restaurante restauranteruc;

    public Plato() {
    }

    public Plato(Integer idplato) {
        this.idplato = idplato;
    }

    public Plato(Integer idplato, String descripcionplato, double precioplato) {
        this.idplato = idplato;
        this.descripcionplato = descripcionplato;
        this.precioplato = precioplato;
    }

    public Integer getIdplato() {
        return idplato;
    }

    public void setIdplato(Integer idplato) {
        this.idplato = idplato;
    }

    public String getDescripcionplato() {
        return descripcionplato;
    }

    public void setDescripcionplato(String descripcionplato) {
        this.descripcionplato = descripcionplato;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecioplato() {
        return precioplato;
    }

    public void setPrecioplato(double precioplato) {
        this.precioplato = precioplato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getEstadoplato() {
        return estadoplato;
    }

    public void setEstadoplato(String estadoplato) {
        this.estadoplato = estadoplato;
    }

    public Restaurante getRestauranteruc() {
        return restauranteruc;
    }

    public void setRestauranteruc(Restaurante restauranteruc) {
        this.restauranteruc = restauranteruc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idplato != null ? idplato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plato)) {
            return false;
        }
        Plato other = (Plato) object;
        if ((this.idplato == null && other.idplato != null) || (this.idplato != null && !this.idplato.equals(other.idplato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Plato[ idplato=" + idplato + " ]";
    }
    
}
