package pckEntites;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pckEntites.PlageHoraire;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-16T11:03:42")
@StaticMetamodel(CoursAnnule.class)
public class CoursAnnule_ { 

    public static volatile SingularAttribute<CoursAnnule, Date> dateAnnule;
    public static volatile SingularAttribute<CoursAnnule, PlageHoraire> idHoraireFK;
    public static volatile SingularAttribute<CoursAnnule, Integer> idCoursAnnulePK;

}