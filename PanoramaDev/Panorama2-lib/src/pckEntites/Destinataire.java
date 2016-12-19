/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pckEntites;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author clocal
 */
@Entity
@Table(name = "Destinataire")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Destinataire.findAll", query = "SELECT d FROM Destinataire d"),
    @NamedQuery(name = "Destinataire.findByIdDestinatairePK", query = "SELECT d FROM Destinataire d WHERE d.idDestinatairePK = :idDestinatairePK")})
public class Destinataire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idDestinataire_PK")
    private Integer idDestinatairePK;
    @JoinColumn(name = "idMessage_FK", referencedColumnName = "idMessage_PK")
    @ManyToOne(optional = false)
    private Message idMessageFK;
    @JoinColumn(name = "idUtilisateur_FK", referencedColumnName = "idUtilisateur_PK")
    @ManyToOne(optional = false)
    private Utilisateur idUtilisateurFK;

    public Destinataire() {
    }

    public Destinataire(Integer idDestinatairePK) {
        this.idDestinatairePK = idDestinatairePK;
    }

    public Integer getIdDestinatairePK() {
        return idDestinatairePK;
    }

    public void setIdDestinatairePK(Integer idDestinatairePK) {
        this.idDestinatairePK = idDestinatairePK;
    }

    public Message getIdMessageFK() {
        return idMessageFK;
    }

    public void setIdMessageFK(Message idMessageFK) {
        this.idMessageFK = idMessageFK;
    }

    public Utilisateur getIdUtilisateurFK() {
        return idUtilisateurFK;
    }

    public void setIdUtilisateurFK(Utilisateur idUtilisateurFK) {
        this.idUtilisateurFK = idUtilisateurFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDestinatairePK != null ? idDestinatairePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Destinataire)) {
            return false;
        }
        Destinataire other = (Destinataire) object;
        if ((this.idDestinatairePK == null && other.idDestinatairePK != null) || (this.idDestinatairePK != null && !this.idDestinatairePK.equals(other.idDestinatairePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pckEntites.Destinataire[ idDestinatairePK=" + idDestinatairePK + " ]";
    }
    
}
