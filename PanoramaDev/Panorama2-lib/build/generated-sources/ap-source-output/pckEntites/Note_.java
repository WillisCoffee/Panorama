package pckEntites;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pckEntites.Etudiant;
import pckEntites.Evaluation;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-16T11:03:42")
@StaticMetamodel(Note.class)
public class Note_ { 

    public static volatile SingularAttribute<Note, Evaluation> idEvaluationFK;
    public static volatile SingularAttribute<Note, Etudiant> matriculeFK;
    public static volatile SingularAttribute<Note, BigDecimal> pointsObtenus;
    public static volatile SingularAttribute<Note, Integer> idNotePK;

}