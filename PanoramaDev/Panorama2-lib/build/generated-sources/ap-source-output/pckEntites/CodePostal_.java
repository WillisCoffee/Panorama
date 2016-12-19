package pckEntites;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pckEntites.Adresse;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-16T11:03:42")
@StaticMetamodel(CodePostal.class)
public class CodePostal_ { 

    public static volatile SingularAttribute<CodePostal, String> ville;
    public static volatile SingularAttribute<CodePostal, Integer> idCodePostalPK;
    public static volatile SingularAttribute<CodePostal, String> province;
    public static volatile ListAttribute<CodePostal, Adresse> adresseList;
    public static volatile SingularAttribute<CodePostal, String> codePostal;
    public static volatile SingularAttribute<CodePostal, String> pays;

}