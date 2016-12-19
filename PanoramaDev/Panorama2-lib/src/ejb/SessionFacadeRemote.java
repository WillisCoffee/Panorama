/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Remote;
import pckEntites.Session;

/**
 *
 * @author clocal
 */
@Remote
public interface SessionFacadeRemote {

    void create(Session session);

    void edit(Session session);

    void remove(Session session);

    Session find(Object id);

    List<Session> findAll();

    List<Session> findRange(int[] range);
    
    List<Session> findByAnnee(int annee);
    
    List<Session> findBySaison(String saison);
    
    Session findByAnneeSaison(String saison_,int annee_);
    
    int count();
    
}
