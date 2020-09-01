/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sesiones;

import Entidades.Restaurante;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Xime
 */
@Stateless
public class RestauranteFacade extends AbstractFacade<Restaurante> implements RestauranteFacadeLocal {
    @PersistenceContext(unitName = "FindFastProPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RestauranteFacade() {
        super(Restaurante.class);
    }
    
    //todos los metodos deberian ir por aqui 
    public List<Restaurante> ListaRestaurante() {
        List<Restaurante> ListaRestaurante;
        Query sql = em.createNamedQuery("Restaurante.findAll");
        ListaRestaurante = sql.getResultList();
        return ListaRestaurante;
    }
    
}
