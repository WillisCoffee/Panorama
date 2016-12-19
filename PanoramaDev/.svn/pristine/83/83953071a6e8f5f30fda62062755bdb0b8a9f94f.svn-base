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
@Table(name = "Adresse")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adresse.findAll", query = "SELECT a FROM Adresse a"),
    @NamedQuery(name = "Adresse.findByIdAdressePK", query = "SELECT a FROM Adresse a WHERE a.idAdressePK = :idAdressePK"),
    @NamedQuery(name = "Adresse.findByNumeroCivique", query = "SELECT a FROM Adresse a WHERE a.numeroCivique = :numeroCivique"),
    @NamedQuery(name = "Adresse.findByRue", query = "SELECT a FROM Adresse a WHERE a.rue = :rue")})
public class Adresse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAdresse_PK")
    private Integer idAdressePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numeroCivique")
    private int numeroCivique;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "rue")
    private String rue;
    @JoinColumn(name = "idCodePostal_FK", referencedColumnName = "idCodePostal_PK")
    @ManyToOne(optional = false)
    private CodePostal idCodePostalFK;
    @JoinColumn(name = "idUtilisateur_FK", referencedColumnName = "idUtilisateur_PK")
    @ManyToOne
    private Utilisateur idUtilisateurFK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAdresseFK")
    private List<Cegep> cegepList;

    public Adresse() {
    }

    public Adresse(Integer idAdressePK) {
        this.idAdressePK = idAdressePK;
    }

    public Adresse(Integer idAdressePK, int numeroCivique, String rue) {
        this.idAdressePK = idAdressePK;
        this.numeroCivique = numeroCivique;
        this.rue = rue;
    }

    public Integer getIdAdressePK() {
        return idAdressePK;
    }

    public void setIdAdressePK(Integer idAdressePK) {
        this.idAdressePK = idAdressePK;
    }

    public int getNumeroCivique() {
        return numeroCivique;
    }

    public void setNumeroCivique(int numeroCivique) {
        this.numeroCivique = numeroCivique;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public CodePostal getIdCodePostalFK() {
        return idCodePostalFK;
    }

    public void setIdCodePostalFK(CodePostal idCodePostalFK) {
        this.idCodePostalFK = idCodePostalFK;
    }

    public Utilisateur getIdUtilisateurFK() {
        return idUtilisateurFK;
    }

    public void setIdUtilisateurFK(Utilisateur idUtilisateurFK) {
        this.idUtilisateurFK = idUtilisateurFK;
    }

    @XmlTransient
    public List<Cegep> getCegepList() {
        return cegepList;
    }

    public void setCegepList(List<Cegep> cegepList) {
        this.cegepList = cegepList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAdressePK != null ? idAdressePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adresse)) {
            return false;
        }
        Adresse other = (Adresse) object;
        if ((this.idAdressePK == null && other.idAdressePK != null) || (this.idAdressePK != null && !this.idAdressePK.equals(other.idAdressePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pckEntites.Adresse[ idAdressePK=" + idAdressePK + " ]";
    }
    
}
