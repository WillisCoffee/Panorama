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
@Table(name = "Cours")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cours.findAll", query = "SELECT c FROM Cours c"),
    @NamedQuery(name = "Cours.findByIdCoursPK", query = "SELECT c FROM Cours c WHERE c.idCoursPK = :idCoursPK"),
    @NamedQuery(name = "Cours.findByNumeroCours", query = "SELECT c FROM Cours c WHERE c.numeroCours = :numeroCours"),
    @NamedQuery(name = "Cours.findByNomCours", query = "SELECT c FROM Cours c WHERE c.nomCours = :nomCours"),
    @NamedQuery(name = "Cours.findByPonderation", query = "SELECT c FROM Cours c WHERE c.ponderation = :ponderation"),
    @NamedQuery(name = "Cours.findByDep", query = "SELECT c FROM Cours c WHERE c.idDepartementFK = :departement")})

public class Cours implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCours_PK")
    private Integer idCoursPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numeroCours")
    private int numeroCours;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "nomCours")
    private String nomCours;
    @Size(max = 8)
    @Column(name = "ponderation")
    private String ponderation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCoursFK")
    private List<Groupe> groupeList;
    @JoinColumn(name = "idDepartement_FK", referencedColumnName = "idDepartement_PK")
    @ManyToOne(optional = false)
    private Departement idDepartementFK;

    public Cours() {
    }

    public Cours(Integer idCoursPK) {
        this.idCoursPK = idCoursPK;
    }

    public Cours(Integer idCoursPK, int numeroCours, String nomCours) {
        this.idCoursPK = idCoursPK;
        this.numeroCours = numeroCours;
        this.nomCours = nomCours;
    }

    public Integer getIdCoursPK() {
        return idCoursPK;
    }

    public void setIdCoursPK(Integer idCoursPK) {
        this.idCoursPK = idCoursPK;
    }

    public int getNumeroCours() {
        return numeroCours;
    }

    public void setNumeroCours(int numeroCours) {
        this.numeroCours = numeroCours;
    }

    public String getNomCours() {
        return nomCours;
    }

    public void setNomCours(String nomCours) {
        this.nomCours = nomCours;
    }

    public String getPonderation() {
        return ponderation;
    }

    public void setPonderation(String ponderation) {
        this.ponderation = ponderation;
    }

    @XmlTransient
    public List<Groupe> getGroupeList() {
        return groupeList;
    }

    public void setGroupeList(List<Groupe> groupeList) {
        this.groupeList = groupeList;
    }

    public Departement getIdDepartementFK() {
        return idDepartementFK;
    }

    public void setIdDepartementFK(Departement idDepartementFK) {
        this.idDepartementFK = idDepartementFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCoursPK != null ? idCoursPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cours)) {
            return false;
        }
        Cours other = (Cours) object;
        if ((this.idCoursPK == null && other.idCoursPK != null) || (this.idCoursPK != null && !this.idCoursPK.equals(other.idCoursPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "pckEntites.Cours[ idCoursPK=" + idCoursPK + " ]";
        return nomCours;
    }
    
}
