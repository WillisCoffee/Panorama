package pckEntites;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pckEntites.Communique;
import pckEntites.Cours;
import pckEntites.Document;
import pckEntites.Evaluation;
import pckEntites.ListeEtudiant;
import pckEntites.PlageHoraire;
import pckEntites.Professeur;
import pckEntites.Session;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-16T11:03:42")
@StaticMetamodel(Groupe.class)
public class Groupe_ { 

    public static volatile ListAttribute<Groupe, ListeEtudiant> listeEtudiantList;
    public static volatile ListAttribute<Groupe, Document> documentList;
    public static volatile ListAttribute<Groupe, Evaluation> evaluationList;
    public static volatile SingularAttribute<Groupe, Professeur> professeurFK;
    public static volatile ListAttribute<Groupe, PlageHoraire> plageHoraireList;
    public static volatile SingularAttribute<Groupe, Session> idSessionFK;
    public static volatile SingularAttribute<Groupe, Cours> idCoursFK;
    public static volatile ListAttribute<Groupe, Communique> communiqueList;
    public static volatile SingularAttribute<Groupe, Integer> idGroupePK;

}