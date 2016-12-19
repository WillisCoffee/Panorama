/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Remote;
import pckEntites.PersonnelSoutien;

/**
 *
 * @author clocal
 */
@Remote
public interface PersonnelSoutienFacadeRemote {

    void create(PersonnelSoutien personnelSoutien);

    void edit(PersonnelSoutien personnelSoutien);

    void remove(PersonnelSoutien personnelSoutien);

    PersonnelSoutien find(Object id);

    List<PersonnelSoutien> findAll();

    List<PersonnelSoutien> findRange(int[] range);
    
    PersonnelSoutien findByNumeroEmployePK(String noEmploye);
    
    List<PersonnelSoutien> findByNomPrenom(String nom, String prenom);
    
    List<PersonnelSoutien> findByPrenom(String prenom);
    
    List<PersonnelSoutien> findByNom(String nom);

    int count();

    PersonnelSoutien rechercherPersonnelConnecter(String psChaine);
    
    List<PersonnelSoutien> chargerListAdresse();
}
