package pckEntites;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pckEntites.Departement;
import pckEntites.Groupe;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-16T11:03:42")
@StaticMetamodel(Cours.class)
public class Cours_ { 

    public static volatile SingularAttribute<Cours, Integer> idCoursPK;
    public static volatile SingularAttribute<Cours, String> nomCours;
    public static volatile ListAttribute<Cours, Groupe> groupeList;
    public static volatile SingularAttribute<Cours, Departement> idDepartementFK;
    public static volatile SingularAttribute<Cours, Integer> numeroCours;
    public static volatile SingularAttribute<Cours, String> ponderation;

}