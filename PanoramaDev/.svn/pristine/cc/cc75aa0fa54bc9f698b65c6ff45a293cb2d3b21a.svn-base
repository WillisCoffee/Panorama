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
import pckEntites.Evaluation;
import pckEntites.Groupe;
import pckEntites.ListeEtudiant;

/**
 *
 * @author clocal
 */
@Stateless
public class EvaluationFacade extends AbstractFacade<Evaluation> implements EvaluationFacadeLocal, ejb.EvaluationFacadeRemote {

    @PersistenceContext(unitName = "Panorama2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EvaluationFacade() {
        super(Evaluation.class);
    }
    
    @Override
    public List<Evaluation> getEvalByGroupe(Groupe id)
    {
        TypedQuery<Evaluation> req = em.createNamedQuery("Evaluation.findByGroupe", Evaluation.class);
        req.setParameter("groupe", id);
        return req.getResultList();
    }
    
}
