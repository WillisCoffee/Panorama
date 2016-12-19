/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import pckEntites.CodePostal;

/**
 *
 * @author clocal
 */
@Stateless
public class CodePostalFacade extends AbstractFacade<CodePostal> implements CodePostalFacadeLocal, ejb.CodePostalFacadeRemote {

    @PersistenceContext(unitName = "Panorama2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CodePostalFacade() {
        super(CodePostal.class);
    }

    @Override
    public CodePostal findByCodePostal(String codePostal) {
        TypedQuery<CodePostal> req = em.createNamedQuery("CodePostal.findByCodePostal", CodePostal.class);
        req.setParameter("CodePostal", codePostal );
        return req.getSingleResult();
    }
    
    
    
}
