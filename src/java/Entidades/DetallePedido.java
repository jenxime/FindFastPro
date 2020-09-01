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
@Table(name = "detalle_pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetallePedido.findAll", query = "SELECT d FROM DetallePedido d"),
    @NamedQuery(name = "DetallePedido.findByIdDetPedido", query = "SELECT d FROM DetallePedido d WHERE d.idDetPedido = :idDetPedido"),
    @NamedQuery(name = "DetallePedido.findByCantidadDetPedido", query = "SELECT d FROM DetallePedido d WHERE d.cantidadDetPedido = :cantidadDetPedido"),
    @NamedQuery(name = "DetallePedido.findByDescripcionDetPedido", query = "SELECT d FROM DetallePedido d WHERE d.descripcionDetPedido = :descripcionDetPedido"),
    @NamedQuery(name = "DetallePedido.findByPreciounitarioDetPedido", query = "SELECT d FROM DetallePedido d WHERE d.preciounitarioDetPedido = :preciounitarioDetPedido")})
public class DetallePedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_det_pedido")
    private Integer idDetPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_det_pedido")
    private int cantidadDetPedido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descripcion_det_pedido")
    private String descripcionDetPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "preciounitario_det_pedido")
    private double preciounitarioDetPedido;
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")
    @ManyToOne(optional = false)
    private Ordencompra idPedido;

    public DetallePedido() {
    }

    public DetallePedido(Integer idDetPedido) {
        this.idDetPedido = idDetPedido;
    }

    public DetallePedido(Integer idDetPedido, int cantidadDetPedido, String descripcionDetPedido, double preciounitarioDetPedido) {
        this.idDetPedido = idDetPedido;
        this.cantidadDetPedido = cantidadDetPedido;
        this.descripcionDetPedido = descripcionDetPedido;
        this.preciounitarioDetPedido = preciounitarioDetPedido;
    }

    public Integer getIdDetPedido() {
        return idDetPedido;
    }

    public void setIdDetPedido(Integer idDetPedido) {
        this.idDetPedido = idDetPedido;
    }

    public int getCantidadDetPedido() {
        return cantidadDetPedido;
    }

    public void setCantidadDetPedido(int cantidadDetPedido) {
        this.cantidadDetPedido = cantidadDetPedido;
    }

    public String getDescripcionDetPedido() {
        return descripcionDetPedido;
    }

    public void setDescripcionDetPedido(String descripcionDetPedido) {
        this.descripcionDetPedido = descripcionDetPedido;
    }

    public double getPreciounitarioDetPedido() {
        return preciounitarioDetPedido;
    }

    public void setPreciounitarioDetPedido(double preciounitarioDetPedido) {
        this.preciounitarioDetPedido = preciounitarioDetPedido;
    }

    public Ordencompra getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Ordencompra idPedido) {
        this.idPedido = idPedido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetPedido != null ? idDetPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallePedido)) {
            return false;
        }
        DetallePedido other = (DetallePedido) object;
        if ((this.idDetPedido == null && other.idDetPedido != null) || (this.idDetPedido != null && !this.idDetPedido.equals(other.idDetPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.DetallePedido[ idDetPedido=" + idDetPedido + " ]";
    }
    
}
