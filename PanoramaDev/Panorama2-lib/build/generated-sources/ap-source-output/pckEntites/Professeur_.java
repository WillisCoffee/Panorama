package pckEntites;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pckEntites.Departement;
import pckEntites.Groupe;
import pckEntites.Utilisateur;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-16T11:03:42")
@StaticMetamodel(Professeur.class)
public class Professeur_ { 

    public static volatile SingularAttribute<Professeur, String> numeroEmployePK;
    public static volatile ListAttribute<Professeur, Groupe> groupeList;
    public static volatile SingularAttribute<Professeur, Departement> idDepartementFK;
    public static volatile SingularAttribute<Professeur, Utilisateur> idUtilisateurFK;
    public static volatile SingularAttribute<Professeur, String> bureau;
    public static volatile SingularAttribute<Professeur, String> disponibiliteProf;
    public static volatile SingularAttribute<Professeur, String> numeroPosteProf;

}