/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sesiones;

import Entidades.Plato;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Xime
 */
@Local
public interface PlatoFacadeLocal {

    void create(Plato plato);

    void edit(Plato plato);

    void remove(Plato plato);

    Plato find(Object id);

    List<Plato> findAll();

    List<Plato> findRange(int[] range);

    int count();
    
    public List<Plato> ListaPlato();
    
}
