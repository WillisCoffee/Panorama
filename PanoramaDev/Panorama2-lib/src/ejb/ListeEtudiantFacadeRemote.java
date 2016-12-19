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
import pckEntites.ListeEtudiant;

/**
 *
 * @author clocal
 */
@Remote
public interface ListeEtudiantFacadeRemote {

    void create(ListeEtudiant listeEtudiant);

    void edit(ListeEtudiant listeEtudiant);

    void remove(ListeEtudiant listeEtudiant);

    ListeEtudiant find(Object id);

    List<ListeEtudiant> findAll();

    List<ListeEtudiant> findRange(int[] range);

    int count();
    
    List<ListeEtudiant> getListeEtudiant(Groupe id);
    
    ListeEtudiant getListeEtudiantByidGroupeMatricule(Groupe id,Etudiant matricule);

    List<ListeEtudiant> getListeEtudiantByMatricule(Etudiant id);
    
}
