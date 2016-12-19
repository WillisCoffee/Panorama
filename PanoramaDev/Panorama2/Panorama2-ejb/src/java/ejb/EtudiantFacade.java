/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.awt.Component;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import pckEntites.Etudiant;

/**
 *
 * @author clocal
 */
@Stateless
public class EtudiantFacade extends AbstractFacade<Etudiant> implements EtudiantFacadeLocal, ejb.EtudiantFacadeRemote {

    @PersistenceContext(unitName = "Panorama2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EtudiantFacade() {
        super(Etudiant.class);
    }

    @Override
    public Etudiant findByMatriculePK(String matricule) 
    {
        TypedQuery<Etudiant> req = em.createNamedQuery("Etudiant.findByMatriculePK", Etudiant.class);
        req.setParameter("matriculePK",matricule);
        try
        {
            Etudiant et = req.getSingleResult();
            return req.getSingleResult();
        }
        catch(Exception x)
        {
            return null;
        }
    }

    @Override
    public List<Etudiant> findByNomPrenom(String nom, String prenom)
    {
        TypedQuery<Etudiant> req = em.createNamedQuery("Etudiant.findByNomPrenom",Etudiant.class);
        req.setParameter("nom",nom);
        req.setParameter("prenom",prenom);
        return req.getResultList();
    }

    @Override
    public List<Etudiant> findByPrenom(String prenom) 
    {
        TypedQuery<Etudiant> req = em.createNamedQuery("Etudiant.findByPrenom",Etudiant.class);
        req.setParameter("prenom",prenom);
        return req.getResultList();    
    }

    @Override
    public List<Etudiant> findByNom(String nom) 
    {
        TypedQuery<Etudiant> req = em.createNamedQuery("Etudiant.findByNom",Etudiant.class);
        req.setParameter("nom",nom);
        return req.getResultList();
    }
    
    public List<Etudiant> chargerListAdresse()
    {
        List<Etudiant> liste = findAll();
        
        for (Etudiant e : liste)
        {
            e.getIdUtilisateurFK().getAdresseList().size();//.size pour aller cherché tout
        }
        return liste;
    }
}
