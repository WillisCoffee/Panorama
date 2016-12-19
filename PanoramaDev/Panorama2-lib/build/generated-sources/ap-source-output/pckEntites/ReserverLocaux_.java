package pckEntites;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pckEntites.Locaux;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-16T11:03:42")
@StaticMetamodel(ReserverLocaux.class)
public class ReserverLocaux_ { 

    public static volatile SingularAttribute<ReserverLocaux, Integer> idReserverLocauxPK;
    public static volatile SingularAttribute<ReserverLocaux, Locaux> idLocauxFK;
    public static volatile SingularAttribute<ReserverLocaux, String> reserverA;
    public static volatile SingularAttribute<ReserverLocaux, Date> heureDebut;
    public static volatile SingularAttribute<ReserverLocaux, Date> heureFin;
    public static volatile SingularAttribute<ReserverLocaux, Date> dateReservation;

}