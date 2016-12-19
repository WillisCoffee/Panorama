/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Local;
import pckEntites.ReserverLocaux;

/**
 *
 * @author clocal
 */
@Local
public interface ReserverLocauxFacadeLocal {

    void create(ReserverLocaux reserverLocaux);

    void edit(ReserverLocaux reserverLocaux);

    void remove(ReserverLocaux reserverLocaux);

    ReserverLocaux find(Object id);

    List<ReserverLocaux> findAll();

    List<ReserverLocaux> findRange(int[] range);

    int count();
    
}
