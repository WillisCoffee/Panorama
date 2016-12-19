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
import pckEntites.Note;

/**
 *
 * @author clocal
 */
@Stateless
public class NoteFacade extends AbstractFacade<Note> implements NoteFacadeLocal, ejb.NoteFacadeRemote {

    @PersistenceContext(unitName = "Panorama2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NoteFacade() {
        super(Note.class);
    }
    
    @Override
    public List<Note> getNoteByMatricule(Etudiant id, Groupe grp)
    {
        TypedQuery<Note> req = em.createNamedQuery("Note.findByMatricule", Note.class);
        req.setParameter("matricule", id);
        req.setParameter("groupe", grp);

        return req.getResultList();
    }
    
}
