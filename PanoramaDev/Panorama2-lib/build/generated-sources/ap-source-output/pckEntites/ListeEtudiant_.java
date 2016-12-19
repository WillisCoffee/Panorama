package pckEntites;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pckEntites.Etudiant;
import pckEntites.Groupe;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-16T11:03:42")
@StaticMetamodel(ListeEtudiant.class)
public class ListeEtudiant_ { 

    public static volatile SingularAttribute<ListeEtudiant, Integer> heuresAbsences;
    public static volatile SingularAttribute<ListeEtudiant, Groupe> idGroupeFK;
    public static volatile SingularAttribute<ListeEtudiant, Etudiant> matriculeFK;
    public static volatile SingularAttribute<ListeEtudiant, Integer> idListePK;

}