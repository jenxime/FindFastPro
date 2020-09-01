/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sesiones;

import Entidades.Restaurante;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Xime
 */
@Local
public interface RestauranteFacadeLocal {

    void create(Restaurante restaurante);

    void edit(Restaurante restaurante);

    void remove(Restaurante restaurante);

    Restaurante find(Object id);

    List<Restaurante> findAll();

    List<Restaurante> findRange(int[] range);

    int count();

    public List<Restaurante> ListaRestaurante();
    
}
