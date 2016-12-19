/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pckEntites.PieceJointe;

/**
 *
 * @author clocal
 */
@Stateless
public class PieceJointeFacade extends AbstractFacade<PieceJointe> implements PieceJointeFacadeLocal, ejb.PieceJointeFacadeRemote {

    @PersistenceContext(unitName = "Panorama2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PieceJointeFacade() {
        super(PieceJointe.class);
    }
    
}
