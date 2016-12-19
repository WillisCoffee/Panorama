/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pckEntites.ReserverLocaux;

/**
 *
 * @author clocal
 */
@Stateless
public class ReserverLocauxFacade extends AbstractFacade<ReserverLocaux> implements ReserverLocauxFacadeLocal, ejb.ReserverLocauxFacadeRemote {

    @PersistenceContext(unitName = "Panorama2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReserverLocauxFacade() {
        super(ReserverLocaux.class);
    }
    
}
