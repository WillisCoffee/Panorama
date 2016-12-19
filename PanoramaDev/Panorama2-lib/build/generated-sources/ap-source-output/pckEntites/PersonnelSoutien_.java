package pckEntites;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pckEntites.Utilisateur;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-16T11:03:42")
@StaticMetamodel(PersonnelSoutien.class)
public class PersonnelSoutien_ { 

    public static volatile SingularAttribute<PersonnelSoutien, String> numeroPersonnelPK;
    public static volatile SingularAttribute<PersonnelSoutien, String> numeroPosteSoutien;
    public static volatile SingularAttribute<PersonnelSoutien, String> disponibilite;
    public static volatile SingularAttribute<PersonnelSoutien, String> fonction;
    public static volatile SingularAttribute<PersonnelSoutien, Utilisateur> idUtilisateurFK;

}