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
import pckEntites.Etudiant;
import pckEntites.Cours;
import pckEntites.Groupe;
import pckEntites.ListeEtudiant;
import pckEntites.Professeur;

/**
 *
 * @author clocal
 */
@Stateless
public class GroupeFacade extends AbstractFacade<Groupe> implements GroupeFacadeLocal, ejb.GroupeFacadeRemote {

    @PersistenceContext(unitName = "Panorama2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GroupeFacade() {
        super(Groupe.class);
    }

    @Override
    public List<Groupe> findByCours(Cours id) 
    {
        TypedQuery<Groupe> req = em.createNamedQuery("Groupe.findByCours",Groupe.class);
        req.setParameter("idCoursFK",id);
        return req.getResultList();
    }

    @Override
    public Groupe findByIdGroupePK(int numGroupe) 
    {
        TypedQuery<Groupe> req = em.createNamedQuery("Groupe.findByIdGroupePK",Groupe.class);
        req.setParameter("idGroupePK",numGroupe);
        try
        {
            Groupe g = req.getSingleResult();
            return req.getSingleResult();
        }
        catch(Exception x)
        {
            return null;
        }
    }

    @Override
    public List<Groupe> findByEnseignant(Professeur id) 
    {
        TypedQuery<Groupe> req = em.createNamedQuery("Groupe.findByProfesseur",Groupe.class);
        req.setParameter("professeurFK",id);
        return req.getResultList();
    }
    
}
