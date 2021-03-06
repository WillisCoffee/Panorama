/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Local;
import pckEntites.Cegep;

/**
 *
 * @author clocal
 */
@Local
public interface CegepFacadeLocal {

    void create(Cegep cegep);

    void edit(Cegep cegep);

    void remove(Cegep cegep);

    Cegep find(Object id);

    List<Cegep> findAll();

    List<Cegep> findRange(int[] range);

    int count();
    
}
