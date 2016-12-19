/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Remote;
import pckEntites.Etudiant;
import pckEntites.Cours;
import pckEntites.Groupe;
import pckEntites.Professeur;

/**
 *
 * @author clocal
 */
@Remote
public interface GroupeFacadeRemote {

    void create(Groupe groupe);

    void edit(Groupe groupe);

    void remove(Groupe groupe);

    Groupe find(Object id);

    List<Groupe> findAll();

    List<Groupe> findRange(int[] range);

    List<Groupe> findByCours(Cours id);
    
    List<Groupe> findByEnseignant(Professeur id);
    
    Groupe findByIdGroupePK(int numGroupe);
    
    int count();
    
}
