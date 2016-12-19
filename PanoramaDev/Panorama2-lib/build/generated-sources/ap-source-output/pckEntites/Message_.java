package pckEntites;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pckEntites.Destinataire;
import pckEntites.PieceJointe;
import pckEntites.Utilisateur;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-16T11:03:42")
@StaticMetamodel(Message.class)
public class Message_ { 

    public static volatile ListAttribute<Message, Destinataire> destinataireList;
    public static volatile SingularAttribute<Message, String> titre;
    public static volatile SingularAttribute<Message, Utilisateur> idUtilisateurFK;
    public static volatile SingularAttribute<Message, String> message;
    public static volatile SingularAttribute<Message, Integer> idMessagePK;
    public static volatile ListAttribute<Message, PieceJointe> pieceJointeList;

}