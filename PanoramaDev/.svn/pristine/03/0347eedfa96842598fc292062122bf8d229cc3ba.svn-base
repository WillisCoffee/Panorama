/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pckEntites;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author clocal
 */
@Entity
@Table(name = "Message")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Message.findAll", query = "SELECT m FROM Message m"),
    @NamedQuery(name = "Message.findByIdMessagePK", query = "SELECT m FROM Message m WHERE m.idMessagePK = :idMessagePK"),
    @NamedQuery(name = "Message.findByTitre", query = "SELECT m FROM Message m WHERE m.titre = :titre")})
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMessage_PK")
    private Integer idMessagePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "titre")
    private String titre;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "message")
    private String message;
    @JoinColumn(name = "idUtilisateur_FK", referencedColumnName = "idUtilisateur_PK")
    @ManyToOne(optional = false)
    private Utilisateur idUtilisateurFK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMessageFK")
    private List<Destinataire> destinataireList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMessageFK")
    private List<PieceJointe> pieceJointeList;

    public Message() {
    }

    public Message(Integer idMessagePK) {
        this.idMessagePK = idMessagePK;
    }

    public Message(Integer idMessagePK, String titre, String message) {
        this.idMessagePK = idMessagePK;
        this.titre = titre;
        this.message = message;
    }

    public Integer getIdMessagePK() {
        return idMessagePK;
    }

    public void setIdMessagePK(Integer idMessagePK) {
        this.idMessagePK = idMessagePK;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Utilisateur getIdUtilisateurFK() {
        return idUtilisateurFK;
    }

    public void setIdUtilisateurFK(Utilisateur idUtilisateurFK) {
        this.idUtilisateurFK = idUtilisateurFK;
    }

    @XmlTransient
    public List<Destinataire> getDestinataireList() {
        return destinataireList;
    }

    public void setDestinataireList(List<Destinataire> destinataireList) {
        this.destinataireList = destinataireList;
    }

    @XmlTransient
    public List<PieceJointe> getPieceJointeList() {
        return pieceJointeList;
    }

    public void setPieceJointeList(List<PieceJointe> pieceJointeList) {
        this.pieceJointeList = pieceJointeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMessagePK != null ? idMessagePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Message)) {
            return false;
        }
        Message other = (Message) object;
        if ((this.idMessagePK == null && other.idMessagePK != null) || (this.idMessagePK != null && !this.idMessagePK.equals(other.idMessagePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pckEntites.Message[ idMessagePK=" + idMessagePK + " ]";
    }
    
}
