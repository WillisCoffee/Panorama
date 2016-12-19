package pckEntites;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pckEntites.Adresse;
import pckEntites.Departement;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-16T11:03:42")
@StaticMetamodel(Cegep.class)
public class Cegep_ { 

    public static volatile SingularAttribute<Cegep, String> nomCegep;
    public static volatile SingularAttribute<Cegep, String> numeroTel;
    public static volatile SingularAttribute<Cegep, Adresse> idAdresseFK;
    public static volatile ListAttribute<Cegep, Departement> departementList;
    public static volatile SingularAttribute<Cegep, byte[]> logoCegep;
    public static volatile SingularAttribute<Cegep, Integer> idCegepPK;
    public static volatile SingularAttribute<Cegep, String> adresseWEB;

}