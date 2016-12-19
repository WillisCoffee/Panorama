/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Remote;
import pckEntites.Etudiant;

/**
 *
 * @author clocal
 */
@Remote
public interface EtudiantFacadeRemote {

    void create(Etudiant etudiant);

    void edit(Etudiant etudiant);

    void remove(Etudiant etudiant);

    Etudiant find(Object id);

    List<Etudiant> findAll();

    List<Etudiant> findRange(int[] range);
    
    Etudiant findByMatriculePK(String matricule);
    
    List<Etudiant> findByNomPrenom(String nom, String prenom);
    
    List<Etudiant> findByPrenom(String prenom);
    
    List<Etudiant> findByNom(String nom);
    
    List<Etudiant> chargerListAdresse();
   // Etudiant findByNomPrenom(String nom,String prenom);
    int count();
    
}
