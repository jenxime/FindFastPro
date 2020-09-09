/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sesiones;

import Entidades.Cliente;
import Entidades.Empleado;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author andre
 */
@Stateless
public class ValidarAcceso implements ValidarAccesoLocal {

    @PersistenceContext(unitName = "FindFastProPU")
    private EntityManager em;

    public ValidarAcceso() {
    }

    
    @Override
    public Cliente ValidarCliente(String usuario, String clave) {
        Cliente cli = null;

        try {
            Query sql = em.createNamedQuery("Cliente.validarCliente")
                    .setParameter("usuario", usuario)
                    .setParameter("clave", clave);

            List<Cliente> ListarClientes = sql.getResultList();
            if (!ListarClientes.isEmpty()) {
                cli = ListarClientes.get(0);
            }

        } catch (Exception e) {
            throw e;
        }
        return cli;
    }

    @Override
    public Empleado ValidarEmpleado(String usuario, String clave) {
        Empleado emp = null;
        try {
            Query sql = em.createNamedQuery("Empleado.validarEmpleado")
                    .setParameter("usuario", usuario)
                    .setParameter("clave", clave);

            List<Empleado> ListarEmpleado = sql.getResultList();
            if (!ListarEmpleado.isEmpty()) {
                emp = ListarEmpleado.get(0);
            }
        } catch (Exception e) {
        }
        return emp;
    }
}
