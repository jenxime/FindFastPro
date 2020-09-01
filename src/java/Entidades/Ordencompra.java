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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Xime
 */
@Entity
@Table(name = "ordencompra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordencompra.findAll", query = "SELECT o FROM Ordencompra o"),
    @NamedQuery(name = "Ordencompra.findByIdPedido", query = "SELECT o FROM Ordencompra o WHERE o.idPedido = :idPedido"),
    @NamedQuery(name = "Ordencompra.findByFechaPedido", query = "SELECT o FROM Ordencompra o WHERE o.fechaPedido = :fechaPedido"),
    @NamedQuery(name = "Ordencompra.findBySubtotalPedido", query = "SELECT o FROM Ordencompra o WHERE o.subtotalPedido = :subtotalPedido"),
    @NamedQuery(name = "Ordencompra.findByDescuentoPedido", query = "SELECT o FROM Ordencompra o WHERE o.descuentoPedido = :descuentoPedido"),
    @NamedQuery(name = "Ordencompra.findByTotalPedido", query = "SELECT o FROM Ordencompra o WHERE o.totalPedido = :totalPedido"),
    @NamedQuery(name = "Ordencompra.findByDuracionPedido", query = "SELECT o FROM Ordencompra o WHERE o.duracionPedido = :duracionPedido")})
public class Ordencompra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pedido")
    private Integer idPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_pedido")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "subtotal_pedido")
    private double subtotalPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "descuento_pedido")
    private double descuentoPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_pedido")
    private double totalPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duracion_pedido")
    @Temporal(TemporalType.TIME)
    private Date duracionPedido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPedido")
    private Collection<DetallePedido> detallePedidoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordencompraIdPedido")
    private Collection<Factura> facturaCollection;
    @JoinColumn(name = "restaurante_ruc", referencedColumnName = "ruc")
    @ManyToOne(optional = false)
    private Restaurante restauranteRuc;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false)
    private Cliente idCliente;

    public Ordencompra() {
    }

    public Ordencompra(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Ordencompra(Integer idPedido, Date fechaPedido, double subtotalPedido, double descuentoPedido, double totalPedido, Date duracionPedido) {
        this.idPedido = idPedido;
        this.fechaPedido = fechaPedido;
        this.subtotalPedido = subtotalPedido;
        this.descuentoPedido = descuentoPedido;
        this.totalPedido = totalPedido;
        this.duracionPedido = duracionPedido;
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

    public double getSubtotalPedido() {
        return subtotalPedido;
    }

    public void setSubtotalPedido(double subtotalPedido) {
        this.subtotalPedido = subtotalPedido;
    }

    public double getDescuentoPedido() {
        return descuentoPedido;
    }

    public void setDescuentoPedido(double descuentoPedido) {
        this.descuentoPedido = descuentoPedido;
    }

    public double getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(double totalPedido) {
        this.totalPedido = totalPedido;
    }

    public Date getDuracionPedido() {
        return duracionPedido;
    }

    public void setDuracionPedido(Date duracionPedido) {
        this.duracionPedido = duracionPedido;
    }

    @XmlTransient
    public Collection<DetallePedido> getDetallePedidoCollection() {
        return detallePedidoCollection;
    }

    public void setDetallePedidoCollection(Collection<DetallePedido> detallePedidoCollection) {
        this.detallePedidoCollection = detallePedidoCollection;
    }

    @XmlTransient
    public Collection<Factura> getFacturaCollection() {
        return facturaCollection;
    }

    public void setFacturaCollection(Collection<Factura> facturaCollection) {
        this.facturaCollection = facturaCollection;
    }

    public Restaurante getRestauranteRuc() {
        return restauranteRuc;
    }

    public void setRestauranteRuc(Restaurante restauranteRuc) {
        this.restauranteRuc = restauranteRuc;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
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
        if (!(object instanceof Ordencompra)) {
            return false;
        }
        Ordencompra other = (Ordencompra) object;
        if ((this.idPedido == null && other.idPedido != null) || (this.idPedido != null && !this.idPedido.equals(other.idPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Ordencompra[ idPedido=" + idPedido + " ]";
    }
    
}
