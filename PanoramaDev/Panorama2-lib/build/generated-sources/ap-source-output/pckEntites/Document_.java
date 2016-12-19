package pckEntites;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pckEntites.Groupe;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-16T11:03:42")
@StaticMetamodel(Document.class)
public class Document_ { 

    public static volatile SingularAttribute<Document, Integer> idDocumentPK;
    public static volatile SingularAttribute<Document, String> fichier;
    public static volatile SingularAttribute<Document, String> categorie;
    public static volatile SingularAttribute<Document, String> taille;
    public static volatile SingularAttribute<Document, Date> dateDebut;
    public static volatile SingularAttribute<Document, Groupe> idGroupeFK;
    public static volatile SingularAttribute<Document, String> titre;
    public static volatile SingularAttribute<Document, String> descriptionDoc;
    public static volatile SingularAttribute<Document, Date> dateFin;

}