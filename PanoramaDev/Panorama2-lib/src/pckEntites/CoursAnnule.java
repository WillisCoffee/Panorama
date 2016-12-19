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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author clocal
 */
@Entity
@Table(name = "CoursAnnule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoursAnnule.findAll", query = "SELECT c FROM CoursAnnule c"),
    @NamedQuery(name = "CoursAnnule.findByIdCoursAnnulePK", query = "SELECT c FROM CoursAnnule c WHERE c.idCoursAnnulePK = :idCoursAnnulePK"),
    @NamedQuery(name = "CoursAnnule.findByDateAnnule", query = "SELECT c FROM CoursAnnule c WHERE c.dateAnnule = :dateAnnule")})
public class CoursAnnule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCoursAnnule_PK")
    private Integer idCoursAnnulePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateAnnule")
    @Temporal(TemporalType.DATE)
    private Date dateAnnule;
    @JoinColumn(name = "idHoraire_FK", referencedColumnName = "idHoraire_PK")
    @ManyToOne(optional = false)
    private PlageHoraire idHoraireFK;

    public CoursAnnule() {
    }

    public CoursAnnule(Integer idCoursAnnulePK) {
        this.idCoursAnnulePK = idCoursAnnulePK;
    }

    public CoursAnnule(Integer idCoursAnnulePK, Date dateAnnule) {
        this.idCoursAnnulePK = idCoursAnnulePK;
        this.dateAnnule = dateAnnule;
    }

    public Integer getIdCoursAnnulePK() {
        return idCoursAnnulePK;
    }

    public void setIdCoursAnnulePK(Integer idCoursAnnulePK) {
        this.idCoursAnnulePK = idCoursAnnulePK;
    }

    public Date getDateAnnule() {
        return dateAnnule;
    }

    public void setDateAnnule(Date dateAnnule) {
        this.dateAnnule = dateAnnule;
    }

    public PlageHoraire getIdHoraireFK() {
        return idHoraireFK;
    }

    public void setIdHoraireFK(PlageHoraire idHoraireFK) {
        this.idHoraireFK = idHoraireFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCoursAnnulePK != null ? idCoursAnnulePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoursAnnule)) {
            return false;
        }
        CoursAnnule other = (CoursAnnule) object;
        if ((this.idCoursAnnulePK == null && other.idCoursAnnulePK != null) || (this.idCoursAnnulePK != null && !this.idCoursAnnulePK.equals(other.idCoursAnnulePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pckEntites.CoursAnnule[ idCoursAnnulePK=" + idCoursAnnulePK + " ]";
    }
    
}
