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
import pckEntites.Cours;
import pckEntites.Departement;

/**
 *
 * @author clocal
 */
@Stateless
public class CoursFacade extends AbstractFacade<Cours> implements CoursFacadeLocal, ejb.CoursFacadeRemote {

    @PersistenceContext(unitName = "Panorama2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CoursFacade() 
    {
        super(Cours.class);
    }

    @Override
    public Cours findByIdCoursFK(Cours id) 
    {
        TypedQuery<Cours> req = em.createNamedQuery("Cours.findByIdCoursPK",Cours.class);
        req.setParameter("idCoursPK",id.getIdCoursPK());
          try
        {
            Cours et = req.getSingleResult();
            return req.getSingleResult();
        }
        catch(Exception x)
        {
            return null;
        }
    }

    @Override
    public Cours findByNumeroCours(int numero) 
    {
        TypedQuery<Cours> req = em.createNamedQuery("Cours.findByNumeroCours",Cours.class);
        req.setParameter("numeroCours",numero);
          try
        {
            Cours et = req.getSingleResult();
            return req.getSingleResult();
        }
        catch(Exception x)
        {
            return null;
        }
    }

    @Override
    public Cours findByNom(String nom) 
    {
        TypedQuery<Cours> req = em.createNamedQuery("Cours.findByNomCours",Cours.class);
        req.setParameter("nomCours",nom);
          try
        {
            Cours et = req.getSingleResult();
            return req.getSingleResult();
        }
        catch(Exception x)
        {
            return null;
        }
    }
    
    @Override
    public List<Cours> findByDep(Departement id) 
    {
    TypedQuery<Cours> req = em.createNamedQuery("Cours.findByDep",Cours.class);
    req.setParameter("departement", id);
    return req.getResultList();
    }
    
}
