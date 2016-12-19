package pckEntites;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pckEntites.Groupe;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-16T11:03:42")
@StaticMetamodel(Communique.class)
public class Communique_ { 

    public static volatile SingularAttribute<Communique, Date> debutAffichage;
    public static volatile SingularAttribute<Communique, Groupe> idGroupeFK;
    public static volatile SingularAttribute<Communique, Integer> idCommuniquePK;
    public static volatile SingularAttribute<Communique, String> message;
    public static volatile SingularAttribute<Communique, Date> finAffichage;

}