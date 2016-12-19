/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Local;
import pckEntites.Groupe;

/**
 *
 * @author clocal
 */
@Local
public interface GroupeFacadeLocal {

    void create(Groupe groupe);

    void edit(Groupe groupe);

    void remove(Groupe groupe);

    Groupe find(Object id);

    List<Groupe> findAll();

    List<Groupe> findRange(int[] range);

    int count();
    
}
