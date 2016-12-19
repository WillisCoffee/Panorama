/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Local;
import pckEntites.PersonnelSoutien;

/**
 *
 * @author clocal
 */
@Local
public interface PersonnelSoutienFacadeLocal {

    void create(PersonnelSoutien personnelSoutien);

    void edit(PersonnelSoutien personnelSoutien);

    void remove(PersonnelSoutien personnelSoutien);

    PersonnelSoutien find(Object id);

    List<PersonnelSoutien> findAll();

    List<PersonnelSoutien> findRange(int[] range);

    int count();
    
}
