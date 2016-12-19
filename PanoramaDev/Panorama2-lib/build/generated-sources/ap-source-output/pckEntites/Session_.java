package pckEntites;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pckEntites.Groupe;
import pckEntites.PlageHoraire;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-16T11:03:42")
@StaticMetamodel(Session.class)
public class Session_ { 

    public static volatile SingularAttribute<Session, String> saison;
    public static volatile ListAttribute<Session, Groupe> groupeList;
    public static volatile ListAttribute<Session, PlageHoraire> plageHoraireList;
    public static volatile SingularAttribute<Session, Date> dateDebutSession;
    public static volatile SingularAttribute<Session, Integer> annee;
    public static volatile SingularAttribute<Session, Date> dateFinSession;
    public static volatile SingularAttribute<Session, String> codeSession;
    public static volatile SingularAttribute<Session, Integer> idSessionPK;

}