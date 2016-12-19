/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Local;
import pckEntites.Communique;

/**
 *
 * @author clocal
 */
@Local
public interface CommuniqueFacadeLocal {

    void create(Communique communique);

    void edit(Communique communique);

    void remove(Communique communique);

    Communique find(Object id);

    List<Communique> findAll();

    List<Communique> findRange(int[] range);

    int count();
    
}
