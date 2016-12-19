/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Local;
import pckEntites.PlageHoraire;

/**
 *
 * @author clocal
 */
@Local
public interface PlageHoraireFacadeLocal {

    void create(PlageHoraire plageHoraire);

    void edit(PlageHoraire plageHoraire);

    void remove(PlageHoraire plageHoraire);

    PlageHoraire find(Object id);

    List<PlageHoraire> findAll();

    List<PlageHoraire> findRange(int[] range);

    int count();
    
}
