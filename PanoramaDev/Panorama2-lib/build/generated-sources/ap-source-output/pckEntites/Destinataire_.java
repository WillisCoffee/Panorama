package pckEntites;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pckEntites.Message;
import pckEntites.Utilisateur;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-16T11:03:42")
@StaticMetamodel(Destinataire.class)
public class Destinataire_ { 

    public static volatile SingularAttribute<Destinataire, Integer> idDestinatairePK;
    public static volatile SingularAttribute<Destinataire, Utilisateur> idUtilisateurFK;
    public static volatile SingularAttribute<Destinataire, Message> idMessageFK;

}