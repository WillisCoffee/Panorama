package pckEntites;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pckEntites.Cegep;
import pckEntites.Cours;
import pckEntites.Professeur;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-16T11:03:42")
@StaticMetamodel(Departement.class)
public class Departement_ { 

    public static volatile SingularAttribute<Departement, String> nomDep;
    public static volatile SingularAttribute<Departement, String> responsable;
    public static volatile SingularAttribute<Departement, Cegep> idCegepFK;
    public static volatile SingularAttribute<Departement, String> numeroDep;
    public static volatile ListAttribute<Departement, Professeur> professeurList;
    public static volatile ListAttribute<Departement, Cours> coursList;
    public static volatile SingularAttribute<Departement, Integer> idDepartementPK;

}