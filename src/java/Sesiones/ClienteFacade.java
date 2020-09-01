/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sesiones;

import Entidades.Cliente;
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
public class ClienteFacade extends AbstractFacade<Cliente> implements ClienteFacadeLocal {
    @PersistenceContext(unitName = "FindFastProPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }
      //todos los metodos deberian ir por aqui 
    public List<Cliente> ListaClientes() {
        List<Cliente> ListaClientes;
        Query sql = em.createNamedQuery("Cliente.findAll");
        ListaClientes = sql.getResultList();
        return ListaClientes;
    }
    
}
