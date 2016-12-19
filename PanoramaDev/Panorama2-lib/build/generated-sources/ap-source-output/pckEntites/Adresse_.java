package pckEntites;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pckEntites.Cegep;
import pckEntites.CodePostal;
import pckEntites.Utilisateur;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-16T11:03:42")
@StaticMetamodel(Adresse.class)
public class Adresse_ { 

    public static volatile SingularAttribute<Adresse, Integer> idAdressePK;
    public static volatile SingularAttribute<Adresse, String> rue;
    public static volatile SingularAttribute<Adresse, CodePostal> idCodePostalFK;
    public static volatile ListAttribute<Adresse, Cegep> cegepList;
    public static volatile SingularAttribute<Adresse, Utilisateur> idUtilisateurFK;
    public static volatile SingularAttribute<Adresse, Integer> numeroCivique;

}