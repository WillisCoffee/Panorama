/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Remote;
import pckEntites.Cours;
import pckEntites.Departement;

/**
 *
 * @author clocal
 */
@Remote
public interface CoursFacadeRemote {

    void create(Cours cours);

    void edit(Cours cours);

    void remove(Cours cours);

    Cours find(Object id);

    List<Cours> findAll();

    List<Cours> findRange(int[] range);
    
    Cours findByIdCoursFK(Cours id);
    
    Cours findByNumeroCours(int numero);
    
    Cours findByNom (String nom);
    
    List<Cours> findByDep(Departement id);
    
    int count();
    
}
