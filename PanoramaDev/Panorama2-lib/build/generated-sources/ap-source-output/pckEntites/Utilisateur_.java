package pckEntites;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pckEntites.Adresse;
import pckEntites.Destinataire;
import pckEntites.Etudiant;
import pckEntites.Message;
import pckEntites.PersonnelSoutien;
import pckEntites.Professeur;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-16T11:03:42")
@StaticMetamodel(Utilisateur.class)
public class Utilisateur_ { 

    public static volatile SingularAttribute<Utilisateur, Integer> nas;
    public static volatile SingularAttribute<Utilisateur, Date> dateNaissance;
    public static volatile ListAttribute<Utilisateur, Adresse> adresseList;
    public static volatile SingularAttribute<Utilisateur, String> telephone;
    public static volatile SingularAttribute<Utilisateur, byte[]> photographie;
    public static volatile SingularAttribute<Utilisateur, String> nom;
    public static volatile SingularAttribute<Utilisateur, String> courriel;
    public static volatile ListAttribute<Utilisateur, Etudiant> etudiantList;
    public static volatile SingularAttribute<Utilisateur, BigDecimal> creditImpression;
    public static volatile ListAttribute<Utilisateur, Destinataire> destinataireList;
    public static volatile SingularAttribute<Utilisateur, Integer> idUtilisateurPK;
    public static volatile ListAttribute<Utilisateur, Message> messageList;
    public static volatile ListAttribute<Utilisateur, Professeur> professeurList;
    public static volatile SingularAttribute<Utilisateur, String> motPasse;
    public static volatile SingularAttribute<Utilisateur, String> cellulaire;
    public static volatile ListAttribute<Utilisateur, PersonnelSoutien> personnelSoutienList;
    public static volatile SingularAttribute<Utilisateur, String> prenom;

}