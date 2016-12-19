package pckEntites;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pckEntites.CoursAnnule;
import pckEntites.Groupe;
import pckEntites.Locaux;
import pckEntites.Session;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-16T11:03:42")
@StaticMetamodel(PlageHoraire.class)
public class PlageHoraire_ { 

    public static volatile ListAttribute<PlageHoraire, CoursAnnule> coursAnnuleList;
    public static volatile SingularAttribute<PlageHoraire, Locaux> idLocauxFK;
    public static volatile SingularAttribute<PlageHoraire, String> jour;
    public static volatile SingularAttribute<PlageHoraire, Groupe> idGroupeFK;
    public static volatile SingularAttribute<PlageHoraire, Date> heureDebut;
    public static volatile SingularAttribute<PlageHoraire, Session> idSessionFK;
    public static volatile SingularAttribute<PlageHoraire, Date> heureFin;
    public static volatile SingularAttribute<PlageHoraire, Integer> idHorairePK;

}