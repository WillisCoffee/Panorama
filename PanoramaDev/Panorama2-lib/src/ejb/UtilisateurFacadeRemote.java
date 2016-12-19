/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Remote;
import pckEntites.Utilisateur;

/**
 *
 * @author clocal
 */
@Remote
public interface UtilisateurFacadeRemote {

    void create(Utilisateur utilisateur);

    void edit(Utilisateur utilisateur);

    void remove(Utilisateur utilisateur);

    Utilisateur find(Object id);
    
    Utilisateur findByNas(int nas);

    List<Utilisateur> findAll();

    List<Utilisateur> findRange(int[] range);
    
    Utilisateur findByIdUtilisateurPK(Utilisateur id);
    
    int count();
    
    
    
}