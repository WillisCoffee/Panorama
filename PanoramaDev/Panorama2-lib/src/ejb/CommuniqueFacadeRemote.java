/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Remote;
import pckEntites.Communique;

/**
 *
 * @author clocal
 */
@Remote
public interface CommuniqueFacadeRemote {

    void create(Communique communique);

    void edit(Communique communique);

    void remove(Communique communique);

    Communique find(Object id);

    List<Communique> findAll();

    List<Communique> findRange(int[] range);

    int count();
    
}
