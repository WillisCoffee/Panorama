/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Local;
import pckEntites.CoursAnnule;

/**
 *
 * @author clocal
 */
@Local
public interface CoursAnnuleFacadeLocal {

    void create(CoursAnnule coursAnnule);

    void edit(CoursAnnule coursAnnule);

    void remove(CoursAnnule coursAnnule);

    CoursAnnule find(Object id);

    List<CoursAnnule> findAll();

    List<CoursAnnule> findRange(int[] range);

    int count();
    
}
