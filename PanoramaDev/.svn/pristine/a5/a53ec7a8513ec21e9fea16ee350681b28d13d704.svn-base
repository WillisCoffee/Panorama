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
import pckEntites.PersonnelSoutien;

/**
 *
 * @author clocal
 */


@Stateless
public class PersonnelSoutienFacade extends AbstractFacade<PersonnelSoutien> implements PersonnelSoutienFacadeLocal, ejb.PersonnelSoutienFacadeRemote {

    @PersistenceContext(unitName = "Panorama2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonnelSoutienFacade() {
        super(PersonnelSoutien.class);
    }

    public PersonnelSoutien rechercherPersonnelConnecter(String psChaine) 
    {
        TypedQuery<PersonnelSoutien> laRequetePersonnel = em.createNamedQuery("PersonnelSoutien.findByNumeroPersonnelPK", PersonnelSoutien.class);
        laRequetePersonnel.setParameter("numeroPersonnelPK", psChaine);

        return laRequetePersonnel.getSingleResult();
    }

    @Override
    public PersonnelSoutien findByNumeroEmployePK(String noEmploye) 
    {
        TypedQuery<PersonnelSoutien> req = em.createNamedQuery("PersonnelSoutien.findByNumeroPersonnelPK", PersonnelSoutien.class);
        req.setParameter("numeroPersonnelPK",noEmploye);
          try
        {
            PersonnelSoutien et = req.getSingleResult();
            return req.getSingleResult();
        }
        catch(Exception x)
        {
            return null;
        }      
    }

    @Override
    public List<PersonnelSoutien> findByNomPrenom(String nom, String prenom) 
    {
        TypedQuery<PersonnelSoutien> req = em.createNamedQuery("PersonnelSoutien.findByNomPrenom",PersonnelSoutien.class);
        req.setParameter("nom",nom);
        req.setParameter("prenom",prenom);
        return req.getResultList();
    }

    @Override
    public List<PersonnelSoutien> findByPrenom(String prenom) 
    {
        TypedQuery<PersonnelSoutien> req = em.createNamedQuery("PersonnelSoutien.findByPrenom",PersonnelSoutien.class);
        req.setParameter("prenom",prenom);
        return req.getResultList();  
    }

    @Override
    public List<PersonnelSoutien> findByNom(String nom)
    {
        TypedQuery<PersonnelSoutien> req = em.createNamedQuery("PersonnelSoutien.findByNom",PersonnelSoutien.class);
        req.setParameter("nom",nom);
        return req.getResultList();
    }

    public List<PersonnelSoutien> chargerListAdresse()
    {
        List<PersonnelSoutien> liste = findAll();
        
        for (PersonnelSoutien e : liste)
        {
            e.getIdUtilisateurFK().getAdresseList().size();//.size pour aller cherché tout
        }
        return liste;
    }
    
    
    
}
