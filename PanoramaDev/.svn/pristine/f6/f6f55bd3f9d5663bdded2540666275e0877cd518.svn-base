/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Local;
import pckEntites.Cours;
import pckEntites.Departement;
import pckEntites.Professeur;

/**
 *
 * @author clocal
 */
@Local
public interface ProfesseurFacadeLocal {

    void create(Professeur professeur);

    void edit(Professeur professeur);

    void remove(Professeur professeur);

    Professeur find(Object id);

    List<Professeur> findAll();

    List<Professeur> findRange(int[] range);

    int count();    
    
    List<Professeur> findByDep(Departement id);

}
