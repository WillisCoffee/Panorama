/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pckEntites.Cegep;

/**
 *
 * @author clocal
 */
@Stateless
public class CegepFacade extends AbstractFacade<Cegep> implements CegepFacadeLocal, ejb.CegepFacadeRemote {

    @PersistenceContext(unitName = "Panorama2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CegepFacade() {
        super(Cegep.class);
    }
    
}
