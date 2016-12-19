/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import pckEntites.Session;

/**
 *
 * @author clocal
 */
@Stateless
public class SessionFacade extends AbstractFacade<Session> implements SessionFacadeLocal, ejb.SessionFacadeRemote {

    @PersistenceContext(unitName = "Panorama2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SessionFacade() {
        super(Session.class);
    }

    @Override
    public List<Session> findByAnnee(int annee) 
    {
        TypedQuery<Session> req = em.createNamedQuery("Session.findByAnnee",Session.class);
        req.setParameter("annee",annee);
        return req.getResultList();
    }

    @Override
    public List<Session> findBySaison(String saison) 
    {
        TypedQuery<Session> req = em.createNamedQuery("Session.findBySaison",Session.class);
        req.setParameter("saison",saison);
        return req.getResultList();
    }
    @Override
    public Session findByAnneeSaison(String saison_,int annee_)
    {
        TypedQuery<Session> req = em.createNamedQuery("Session.findByAnneeSaison",Session.class);
        req.setParameter("annee",annee_);
        req.setParameter("saison",saison_);
         try
        {
            Session et = req.getSingleResult();
            return req.getSingleResult();
        }
        catch(Exception x)
        {
            return null;
        }
    }
    
}
