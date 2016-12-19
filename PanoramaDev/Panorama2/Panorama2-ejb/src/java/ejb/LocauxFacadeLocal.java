/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Local;
import pckEntites.Locaux;

/**
 *
 * @author clocal
 */
@Local
public interface LocauxFacadeLocal {

    void create(Locaux locaux);

    void edit(Locaux locaux);

    void remove(Locaux locaux);

    Locaux find(Object id);

    List<Locaux> findAll();

    List<Locaux> findRange(int[] range);

    int count();
    
}
