package pckEntites;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pckEntites.PlageHoraire;
import pckEntites.ReserverLocaux;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-16T11:03:42")
@StaticMetamodel(Locaux.class)
public class Locaux_ { 

    public static volatile ListAttribute<Locaux, ReserverLocaux> reserverLocauxList;
    public static volatile SingularAttribute<Locaux, Integer> nombrePlace;
    public static volatile SingularAttribute<Locaux, String> categorie;
    public static volatile SingularAttribute<Locaux, String> reserverA;
    public static volatile ListAttribute<Locaux, PlageHoraire> plageHoraireList;
    public static volatile SingularAttribute<Locaux, String> numeroLocal;
    public static volatile SingularAttribute<Locaux, Integer> idLocauxPK;

}