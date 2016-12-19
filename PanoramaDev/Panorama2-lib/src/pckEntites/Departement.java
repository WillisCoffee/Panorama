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
@Table(name = "Departement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departement.findAll", query = "SELECT d FROM Departement d"),
    @NamedQuery(name = "Departement.findByIdDepartementPK", query = "SELECT d FROM Departement d WHERE d.idDepartementPK = :idDepartementPK"),
    @NamedQuery(name = "Departement.findByNumeroDep", query = "SELECT d FROM Departement d WHERE d.numeroDep = :numeroDep"),
    @NamedQuery(name = "Departement.findByNomDep", query = "SELECT d FROM Departement d WHERE d.nomDep = :nomDep"),
    @NamedQuery(name = "Departement.findByNumeroNom",query = "SELECT d FROM Departement d WHERE d.numeroDep = :numeroDep and d.nomDep =:nomDep"),
    @NamedQuery(name = "Departement.findByResponsable", query = "SELECT d FROM Departement d WHERE d.responsable = :responsable")})
public class Departement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDepartement_PK")
    private Integer idDepartementPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "numeroDep")
    private String numeroDep;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "nomDep")
    private String nomDep;
    @Size(max = 128)
    @Column(name = "responsable")
    private String responsable;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDepartementFK")
    private List<Cours> coursList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDepartementFK")
    private List<Professeur> professeurList;
    @JoinColumn(name = "idCegep_FK", referencedColumnName = "idCegep_PK")
    @ManyToOne(optional = false)
    private Cegep idCegepFK;

    public Departement() {
    }

    public Departement(Integer idDepartementPK) {
        this.idDepartementPK = idDepartementPK;
    }

    public Departement(Integer idDepartementPK, String numeroDep, String nomDep) {
        this.idDepartementPK = idDepartementPK;
        this.numeroDep = numeroDep;
        this.nomDep = nomDep;
    }

    public Integer getIdDepartementPK() {
        return idDepartementPK;
    }

    public void setIdDepartementPK(Integer idDepartementPK) {
        this.idDepartementPK = idDepartementPK;
    }

    public String getNumeroDep() {
        return numeroDep;
    }

    public void setNumeroDep(String numeroDep) {
        this.numeroDep = numeroDep;
    }

    public String getNomDep() {
        return nomDep;
    }

    public void setNomDep(String nomDep) {
        this.nomDep = nomDep;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    @XmlTransient
    public List<Cours> getCoursList() {
        return coursList;
    }

    public void setCoursList(List<Cours> coursList) {
        this.coursList = coursList;
    }

    @XmlTransient
    public List<Professeur> getProfesseurList() {
        return professeurList;
    }

    public void setProfesseurList(List<Professeur> professeurList) {
        this.professeurList = professeurList;
    }

    public Cegep getIdCegepFK() {
        return idCegepFK;
    }

    public void setIdCegepFK(Cegep idCegepFK) {
        this.idCegepFK = idCegepFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDepartementPK != null ? idDepartementPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departement)) {
            return false;
        }
        Departement other = (Departement) object;
        if ((this.idDepartementPK == null && other.idDepartementPK != null) || (this.idDepartementPK != null && !this.idDepartementPK.equals(other.idDepartementPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "pckEntites.Departement[ idDepartementPK=" + idDepartementPK + " ]";
        return nomDep;
    }
    
}
