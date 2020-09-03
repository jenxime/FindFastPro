/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sesiones;

import Entidades.Plato;
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
public class PlatoFacade extends AbstractFacade<Plato> implements PlatoFacadeLocal {
    @PersistenceContext(unitName = "FindFastProPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlatoFacade() {
        super(Plato.class);
    }
    
     public List<Plato> ListaPlato() {
        List<Plato> ListaPlato;
        Query sql = em.createNamedQuery("Plato.findAll");
        ListaPlato = sql.getResultList();
        return ListaPlato;
    }
    
}
