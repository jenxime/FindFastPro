/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
 * @author Xime
 */
@Entity
@Table(name = "factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f"),
    @NamedQuery(name = "Factura.findByIdFactura", query = "SELECT f FROM Factura f WHERE f.idFactura = :idFactura"),
    @NamedQuery(name = "Factura.findByFechaFactura", query = "SELECT f FROM Factura f WHERE f.fechaFactura = :fechaFactura"),
    @NamedQuery(name = "Factura.findByHoraFactura", query = "SELECT f FROM Factura f WHERE f.horaFactura = :horaFactura"),
    @NamedQuery(name = "Factura.findBySubtotalFactura", query = "SELECT f FROM Factura f WHERE f.subtotalFactura = :subtotalFactura"),
    @NamedQuery(name = "Factura.findByIvaFactura", query = "SELECT f FROM Factura f WHERE f.ivaFactura = :ivaFactura"),
    @NamedQuery(name = "Factura.findByTotalFactura", query = "SELECT f FROM Factura f WHERE f.totalFactura = :totalFactura"),
    @NamedQuery(name = "Factura.findByValoracion", query = "SELECT f FROM Factura f WHERE f.valoracion = :valoracion")})
public class Factura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_factura")
    private Integer idFactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_factura")
    @Temporal(TemporalType.DATE)
    private Date fechaFactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_factura")
    @Temporal(TemporalType.TIME)
    private Date horaFactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "subtotal_factura")
    private double subtotalFactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iva_factura")
    private double ivaFactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_factura")
    private double totalFactura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "valoracion")
    private String valoracion;
    @JoinColumn(name = "ordencompra_id_pedido", referencedColumnName = "id_pedido")
    @ManyToOne(optional = false)
    private Ordencompra ordencompraIdPedido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFactura")
    private Collection<DetalleFactura> detalleFacturaCollection;

    public Factura() {
    }

    public Factura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Factura(Integer idFactura, Date fechaFactura, Date horaFactura, double subtotalFactura, double ivaFactura, double totalFactura, String valoracion) {
        this.idFactura = idFactura;
        this.fechaFactura = fechaFactura;
        this.horaFactura = horaFactura;
        this.subtotalFactura = subtotalFactura;
        this.ivaFactura = ivaFactura;
        this.totalFactura = totalFactura;
        this.valoracion = valoracion;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public Date getHoraFactura() {
        return horaFactura;
    }

    public void setHoraFactura(Date horaFactura) {
        this.horaFactura = horaFactura;
    }

    public double getSubtotalFactura() {
        return subtotalFactura;
    }

    public void setSubtotalFactura(double subtotalFactura) {
        this.subtotalFactura = subtotalFactura;
    }

    public double getIvaFactura() {
        return ivaFactura;
    }

    public void setIvaFactura(double ivaFactura) {
        this.ivaFactura = ivaFactura;
    }

    public double getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(double totalFactura) {
        this.totalFactura = totalFactura;
    }

    public String getValoracion() {
        return valoracion;
    }

    public void setValoracion(String valoracion) {
        this.valoracion = valoracion;
    }

    public Ordencompra getOrdencompraIdPedido() {
        return ordencompraIdPedido;
    }

    public void setOrdencompraIdPedido(Ordencompra ordencompraIdPedido) {
        this.ordencompraIdPedido = ordencompraIdPedido;
    }

    @XmlTransient
    public Collection<DetalleFactura> getDetalleFacturaCollection() {
        return detalleFacturaCollection;
    }

    public void setDetalleFacturaCollection(Collection<DetalleFactura> detalleFacturaCollection) {
        this.detalleFacturaCollection = detalleFacturaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFactura != null ? idFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.idFactura == null && other.idFactura != null) || (this.idFactura != null && !this.idFactura.equals(other.idFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Factura[ idFactura=" + idFactura + " ]";
    }
    
}
