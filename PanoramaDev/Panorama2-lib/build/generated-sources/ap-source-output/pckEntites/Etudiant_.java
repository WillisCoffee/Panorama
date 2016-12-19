package pckEntites;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pckEntites.ListeEtudiant;
import pckEntites.Note;
import pckEntites.Utilisateur;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-16T11:03:42")
@StaticMetamodel(Etudiant.class)
public class Etudiant_ { 

    public static volatile SingularAttribute<Etudiant, String> matriculePK;
    public static volatile ListAttribute<Etudiant, ListeEtudiant> listeEtudiantList;
    public static volatile SingularAttribute<Etudiant, Date> dateInscription;
    public static volatile SingularAttribute<Etudiant, Utilisateur> idUtilisateurFK;
    public static volatile ListAttribute<Etudiant, Note> noteList;
    public static volatile SingularAttribute<Etudiant, String> codePermanent;

}