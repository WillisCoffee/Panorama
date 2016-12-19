/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Local;
import pckEntites.ListeEtudiant;

/**
 *
 * @author clocal
 */
@Local
public interface ListeEtudiantFacadeLocal {

    void create(ListeEtudiant listeEtudiant);

    void edit(ListeEtudiant listeEtudiant);

    void remove(ListeEtudiant listeEtudiant);

    ListeEtudiant find(Object id);

    List<ListeEtudiant> findAll();

    List<ListeEtudiant> findRange(int[] range);

    int count();
    
}
