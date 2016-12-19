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
import pckEntites.Departement;
import pckEntites.Professeur;

/**
 *
 * @author clocal
 */
@Stateless
public class ProfesseurFacade extends AbstractFacade<Professeur> implements ProfesseurFacadeLocal, ejb.ProfesseurFacadeRemote {

    @PersistenceContext(unitName = "Panorama2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProfesseurFacade() {
        super(Professeur.class);
    }

    @Override
    public Professeur findByNumeroEmployePK(String noEmploye) 
    {
        TypedQuery<Professeur> req = em.createNamedQuery("Professeur.findByNumeroEmployePK", Professeur.class);
        req.setParameter("numeroEmployePK",noEmploye);
        try
        {
            Professeur et = req.getSingleResult();
            return req.getSingleResult();
        }
        catch(Exception x)
        {
            return null;
        }
    }

    @Override
    public List<Professeur> findByNomPrenom(String nom, String prenom) 
    {
        TypedQuery<Professeur> req = em.createNamedQuery("Professeur.findByNomPrenom",Professeur.class);
        req.setParameter("nom",nom);
        req.setParameter("prenom",prenom);
        return req.getResultList();
    }

    @Override
    public List<Professeur> findByPrenom(String prenom) 
    {
        TypedQuery<Professeur> req = em.createNamedQuery("Professeur.findByPrenom",Professeur.class);
        req.setParameter("prenom",prenom);
        return req.getResultList();  
    }

    @Override
    public List<Professeur> findByNom(String nom) 
    {
        TypedQuery<Professeur> req = em.createNamedQuery("Professeur.findByNom",Professeur.class);
        req.setParameter("nom",nom);
        return req.getResultList();
    }
    
    @Override
    public List<Professeur> findByDep(Departement id) 
    {
    TypedQuery<Professeur> req = em.createNamedQuery("Professeur.findByDep",Professeur.class);
    req.setParameter("departement", id);
    return req.getResultList();
    }
    
    public List<Professeur> chargerListAdresse()
    {
        List<Professeur> liste = findAll();
        
        for (Professeur e : liste)
        {
            e.getIdUtilisateurFK().getAdresseList().size();//.size pour aller cherché tout
        }
        return liste;
    }
}
