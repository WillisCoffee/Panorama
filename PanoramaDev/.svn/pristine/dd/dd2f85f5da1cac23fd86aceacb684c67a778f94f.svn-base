/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Remote;
import pckEntites.Departement;

/**
 *
 * @author clocal
 */
@Remote
public interface DepartementFacadeRemote {

    void create(Departement departement);

    void edit(Departement departement);

    void remove(Departement departement);

    Departement find(Object id);

    List<Departement> findAll();

    List<Departement> findRange(int[] range);
    
    Departement findByIdDepartementPK(Departement id);
    
    Departement findByNumeroNom(String numero, String nom);
    
    Departement findByNumero(String numero);
    
    Departement findByNom (String nom);
    
    int count();
    
}
