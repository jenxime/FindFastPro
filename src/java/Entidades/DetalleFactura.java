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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Xime
 */
@Entity
@Table(name = "detalle_factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleFactura.findAll", query = "SELECT d FROM DetalleFactura d"),
    @NamedQuery(name = "DetalleFactura.findByIdDetFact", query = "SELECT d FROM DetalleFactura d WHERE d.idDetFact = :idDetFact"),
    @NamedQuery(name = "DetalleFactura.findByIdPlato", query = "SELECT d FROM DetalleFactura d WHERE d.idPlato = :idPlato"),
    @NamedQuery(name = "DetalleFactura.findByCantidad", query = "SELECT d FROM DetalleFactura d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "DetalleFactura.findByPreciounitario", query = "SELECT d FROM DetalleFactura d WHERE d.preciounitario = :preciounitario"),
    @NamedQuery(name = "DetalleFactura.findByPreciototalDetFact", query = "SELECT d FROM DetalleFactura d WHERE d.preciototalDetFact = :preciototalDetFact")})
public class DetalleFactura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_det_fact")
    private Integer idDetFact;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_plato")
    private int idPlato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "preciounitario")
    private double preciounitario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "preciototal_det_fact")
    private double preciototalDetFact;
    @JoinColumn(name = "id_factura", referencedColumnName = "id_factura")
    @ManyToOne(optional = false)
    private Factura idFactura;

    public DetalleFactura() {
    }

    public DetalleFactura(Integer idDetFact) {
        this.idDetFact = idDetFact;
    }

    public DetalleFactura(Integer idDetFact, int idPlato, int cantidad, double preciounitario, double preciototalDetFact) {
        this.idDetFact = idDetFact;
        this.idPlato = idPlato;
        this.cantidad = cantidad;
        this.preciounitario = preciounitario;
        this.preciototalDetFact = preciototalDetFact;
    }

    public Integer getIdDetFact() {
        return idDetFact;
    }

    public void setIdDetFact(Integer idDetFact) {
        this.idDetFact = idDetFact;
    }

    public int getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(int idPlato) {
        this.idPlato = idPlato;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPreciounitario() {
        return preciounitario;
    }

    public void setPreciounitario(double preciounitario) {
        this.preciounitario = preciounitario;
    }

    public double getPreciototalDetFact() {
        return preciototalDetFact;
    }

    public void setPreciototalDetFact(double preciototalDetFact) {
        this.preciototalDetFact = preciototalDetFact;
    }

    public Factura getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Factura idFactura) {
        this.idFactura = idFactura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetFact != null ? idDetFact.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleFactura)) {
            return false;
        }
        DetalleFactura other = (DetalleFactura) object;
        if ((this.idDetFact == null && other.idDetFact != null) || (this.idDetFact != null && !this.idDetFact.equals(other.idDetFact))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.DetalleFactura[ idDetFact=" + idDetFact + " ]";
    }
    
}
