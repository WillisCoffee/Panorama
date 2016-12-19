package pckEntites;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pckEntites.Groupe;
import pckEntites.Note;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-16T11:03:42")
@StaticMetamodel(Evaluation.class)
public class Evaluation_ { 

    public static volatile SingularAttribute<Evaluation, String> fichier;
    public static volatile SingularAttribute<Evaluation, Date> dateRemise;
    public static volatile SingularAttribute<Evaluation, Date> dateDebutEval;
    public static volatile SingularAttribute<Evaluation, Groupe> idGroupeFK;
    public static volatile SingularAttribute<Evaluation, String> description;
    public static volatile SingularAttribute<Evaluation, Integer> idEvaluationPK;
    public static volatile ListAttribute<Evaluation, Note> noteList;
    public static volatile SingularAttribute<Evaluation, Date> dateFinEval;
    public static volatile SingularAttribute<Evaluation, String> nom;
    public static volatile SingularAttribute<Evaluation, BigDecimal> nombrePoints;
    public static volatile SingularAttribute<Evaluation, String> enonce;
    public static volatile SingularAttribute<Evaluation, Integer> poidsNote;
    public static volatile SingularAttribute<Evaluation, String> categorieEval;
    public static volatile SingularAttribute<Evaluation, String> methodeRemise;
    public static volatile SingularAttribute<Evaluation, String> correction;
    public static volatile SingularAttribute<Evaluation, Boolean> evaluer;
    public static volatile SingularAttribute<Evaluation, String> commentaire;
    public static volatile SingularAttribute<Evaluation, String> statut;
    public static volatile SingularAttribute<Evaluation, BigDecimal> moyenne;

}