/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Remote;
import pckEntites.Etudiant;
import pckEntites.Groupe;
import pckEntites.PlageHoraire;
import pckEntites.Professeur;

/**
 *
 * @author clocal
 */
@Remote
public interface PlageHoraireFacadeRemote {

    void create(PlageHoraire plageHoraire);

    void edit(PlageHoraire plageHoraire);

    void remove(PlageHoraire plageHoraire);

    PlageHoraire find(Object id);

    List<PlageHoraire> findAll();

    List<PlageHoraire> findRange(int[] range);
    
    List<PlageHoraire> findPlageParMatricule(Etudiant id);
    
    List<PlageHoraire> findByGroupe(Groupe id);
    
    List<PlageHoraire> findPlageParNoEmploye(Professeur id);

    int count();
    
}
