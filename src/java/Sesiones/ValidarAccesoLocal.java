/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sesiones;

import Entidades.Cliente;
import Entidades.Empleado;
import javax.ejb.Local;

/**
 *
 * @author andre
 */
@Local
public interface ValidarAccesoLocal {

    public Cliente ValidarCliente(String usuario, String clave);

    public Empleado ValidarEmpleado(String usuario, String clave);
    
}
