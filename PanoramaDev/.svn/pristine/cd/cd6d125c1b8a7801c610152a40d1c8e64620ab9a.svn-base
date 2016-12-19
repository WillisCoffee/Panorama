/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Remote;
import pckEntites.Departement;
import pckEntites.Professeur;

/**
 *
 * @author clocal
 */
@Remote
public interface ProfesseurFacadeRemote {

    void create(Professeur professeur);

    void edit(Professeur professeur);

    void remove(Professeur professeur);

    Professeur find(Object id);

    List<Professeur> findAll();

    List<Professeur> findRange(int[] range);
    
    Professeur findByNumeroEmployePK(String noEmploye);
    
    List<Professeur> findByNomPrenom(String nom, String prenom);
    
    List<Professeur> findByPrenom(String prenom);
    
    List<Professeur> findByNom(String nom);
    
            

    int count();
    
    List<Professeur> findByDep(Departement id);
    
    List<Professeur> chargerListAdresse();
}
