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
import pckEntites.Groupe;
import pckEntites.PlageHoraire;
import pckEntites.Professeur;

/**
 *
 * @author clocal
 */
@Stateless
public class PlageHoraireFacade extends AbstractFacade<PlageHoraire> implements PlageHoraireFacadeLocal, ejb.PlageHoraireFacadeRemote {

    @PersistenceContext(unitName = "Panorama2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlageHoraireFacade() {
        super(PlageHoraire.class);
    }

    @Override
    public List<PlageHoraire> findPlageParMatricule(Etudiant id) 
    {
        TypedQuery<PlageHoraire> req = em.createNamedQuery("PlageHoraire.findPlageParMatricule", PlageHoraire.class);
        req.setParameter("matricule",id);
        return req.getResultList();    
    }

    @Override
    public List<PlageHoraire> findPlageParNoEmploye(Professeur id) 
    {
        TypedQuery<PlageHoraire> req = em.createNamedQuery("PlageHoraire.findPlageParNoEmploye",PlageHoraire.class);
        req.setParameter("noEmploye",id);
        return req.getResultList();
    }
    
    @Override
    public List<PlageHoraire> findByGroupe(Groupe id)
    {
        TypedQuery<PlageHoraire> req = em.createNamedQuery("PlageHoraire.findByGroupe", PlageHoraire.class);
        req.setParameter("groupe" ,id);
        return req.getResultList();
    }
    
}
