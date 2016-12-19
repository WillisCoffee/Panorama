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
import pckEntites.ListeEtudiant;

/**
 *
 * @author clocal
 */
@Stateless
public class ListeEtudiantFacade extends AbstractFacade<ListeEtudiant> implements ListeEtudiantFacadeLocal, ejb.ListeEtudiantFacadeRemote {

    @PersistenceContext(unitName = "Panorama2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ListeEtudiantFacade() {
        super(ListeEtudiant.class);
    }
    
     public List<ListeEtudiant> getListeEtudiant(Groupe id)
    {
        TypedQuery<ListeEtudiant> req = em.createNamedQuery("ListeEtudiant.findByIdGroupe", ListeEtudiant.class);
        req.setParameter("idGroupe", id );
        List<ListeEtudiant> liste = req.getResultList();
        
        for(ListeEtudiant e : liste)
        {
            e.getMatriculeFK().getIdUtilisateurFK();
        }
        
        return liste;
    }

    @Override
    public ListeEtudiant getListeEtudiantByidGroupeMatricule(Groupe id, Etudiant matricule) 
    {
        TypedQuery<ListeEtudiant> req = em.createNamedQuery("ListeEtudiant.findByIdGroupeMatricule",ListeEtudiant.class);
        req.setParameter("idGroupe",id);
        req.setParameter("matricule",matricule);
        ListeEtudiant unListe = req.getSingleResult();
        unListe.getIdGroupeFK();
        unListe.getMatriculeFK();
        return unListe;
    }
    
    @Override
    public List<ListeEtudiant> getListeEtudiantByMatricule(Etudiant id)
    {
        TypedQuery<ListeEtudiant> req = em.createNamedQuery("ListeEtudiant.findByMatricule", ListeEtudiant.class);
        req.setParameter("matricule", id);
        return req.getResultList();
        
    }
}
