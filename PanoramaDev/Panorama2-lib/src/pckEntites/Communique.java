/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pckEntites;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author clocal
 */
@Entity
@Table(name = "Communique")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Communique.findAll", query = "SELECT c FROM Communique c"),
    @NamedQuery(name = "Communique.findByIdCommuniquePK", query = "SELECT c FROM Communique c WHERE c.idCommuniquePK = :idCommuniquePK"),
    @NamedQuery(name = "Communique.findByMessage", query = "SELECT c FROM Communique c WHERE c.message = :message"),
    @NamedQuery(name = "Communique.findByDebutAffichage", query = "SELECT c FROM Communique c WHERE c.debutAffichage = :debutAffichage"),
    @NamedQuery(name = "Communique.findByFinAffichage", query = "SELECT c FROM Communique c WHERE c.finAffichage = :finAffichage")})
public class Communique implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCommunique_PK")
    private Integer idCommuniquePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "message")
    private String message;
    @Basic(optional = false)
    @NotNull
    @Column(name = "debutAffichage")
    @Temporal(TemporalType.TIMESTAMP)
    private Date debutAffichage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "finAffichage")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finAffichage;
    @JoinColumn(name = "idGroupe_FK", referencedColumnName = "idGroupe_PK")
    @ManyToOne(optional = false)
    private Groupe idGroupeFK;

    public Communique() {
    }

    public Communique(Integer idCommuniquePK) {
        this.idCommuniquePK = idCommuniquePK;
    }

    public Communique(Integer idCommuniquePK, String message, Date debutAffichage, Date finAffichage) {
        this.idCommuniquePK = idCommuniquePK;
        this.message = message;
        this.debutAffichage = debutAffichage;
        this.finAffichage = finAffichage;
    }

    public Integer getIdCommuniquePK() {
        return idCommuniquePK;
    }

    public void setIdCommuniquePK(Integer idCommuniquePK) {
        this.idCommuniquePK = idCommuniquePK;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDebutAffichage() {
        return debutAffichage;
    }

    public void setDebutAffichage(Date debutAffichage) {
        this.debutAffichage = debutAffichage;
    }

    public Date getFinAffichage() {
        return finAffichage;
    }

    public void setFinAffichage(Date finAffichage) {
        this.finAffichage = finAffichage;
    }

    public Groupe getIdGroupeFK() {
        return idGroupeFK;
    }

    public void setIdGroupeFK(Groupe idGroupeFK) {
        this.idGroupeFK = idGroupeFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCommuniquePK != null ? idCommuniquePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Communique)) {
            return false;
        }
        Communique other = (Communique) object;
        if ((this.idCommuniquePK == null && other.idCommuniquePK != null) || (this.idCommuniquePK != null && !this.idCommuniquePK.equals(other.idCommuniquePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pckEntites.Communique[ idCommuniquePK=" + idCommuniquePK + " ]";
    }
    
}
