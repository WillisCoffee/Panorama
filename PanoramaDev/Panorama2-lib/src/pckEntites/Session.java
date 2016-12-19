/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pckEntites;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author clocal
 */
@Entity
@Table(name = "Session")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Session.findAll", query = "SELECT s FROM Session s"),
    @NamedQuery(name = "Session.findByIdSessionPK", query = "SELECT s FROM Session s WHERE s.idSessionPK = :idSessionPK"),
    @NamedQuery(name = "Session.findByCodeSession", query = "SELECT s FROM Session s WHERE s.codeSession = :codeSession"),
    @NamedQuery(name = "Session.findBySaison", query = "SELECT s FROM Session s WHERE s.saison = :saison"),
    @NamedQuery(name = "Session.findByAnnee", query = "SELECT s FROM Session s WHERE s.annee = :annee"),
    @NamedQuery(name = "Session.findByAnneeSaison", query = "SELECT s FROM Session s WHERE s.saison = :saison and s.annee = :annee"),
    @NamedQuery(name = "Session.findByDateDebutSession", query = "SELECT s FROM Session s WHERE s.dateDebutSession = :dateDebutSession"),
    @NamedQuery(name = "Session.findByDateFinSession", query = "SELECT s FROM Session s WHERE s.dateFinSession = :dateFinSession")})
public class Session implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSession_PK")
    private Integer idSessionPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "codeSession")
    private String codeSession;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "saison")
    private String saison;
    @Basic(optional = false)
    @NotNull
    @Column(name = "annee")
    private int annee;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateDebutSession")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDebutSession;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateFinSession")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFinSession;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSessionFK")
    private List<Groupe> groupeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSessionFK")
    private List<PlageHoraire> plageHoraireList;

    public Session() {
    }

    public Session(Integer idSessionPK) {
        this.idSessionPK = idSessionPK;
    }

    public Session(Integer idSessionPK, String codeSession, String saison, int annee, Date dateDebutSession, Date dateFinSession) {
        this.idSessionPK = idSessionPK;
        this.codeSession = codeSession;
        this.saison = saison;
        this.annee = annee;
        this.dateDebutSession = dateDebutSession;
        this.dateFinSession = dateFinSession;
    }

    public Integer getIdSessionPK() {
        return idSessionPK;
    }

    public void setIdSessionPK(Integer idSessionPK) {
        this.idSessionPK = idSessionPK;
    }

    public String getCodeSession() {
        return codeSession;
    }

    public void setCodeSession(String codeSession) {
        this.codeSession = codeSession;
    }

    public String getSaison() {
        return saison;
    }

    public void setSaison(String saison) {
        this.saison = saison;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public Date getDateDebutSession() {
        return dateDebutSession;
    }

    public void setDateDebutSession(Date dateDebutSession) {
        this.dateDebutSession = dateDebutSession;
    }

    public Date getDateFinSession() {
        return dateFinSession;
    }

    public void setDateFinSession(Date dateFinSession) {
        this.dateFinSession = dateFinSession;
    }

    @XmlTransient
    public List<Groupe> getGroupeList() {
        return groupeList;
    }

    public void setGroupeList(List<Groupe> groupeList) {
        this.groupeList = groupeList;
    }

    @XmlTransient
    public List<PlageHoraire> getPlageHoraireList() {
        return plageHoraireList;
    }

    public void setPlageHoraireList(List<PlageHoraire> plageHoraireList) {
        this.plageHoraireList = plageHoraireList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSessionPK != null ? idSessionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Session)) {
            return false;
        }
        Session other = (Session) object;
        if ((this.idSessionPK == null && other.idSessionPK != null) || (this.idSessionPK != null && !this.idSessionPK.equals(other.idSessionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "pckEntites.Session[ idSessionPK=" + idSessionPK + " ]";
        return codeSession;
    }
    
}
