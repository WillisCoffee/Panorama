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
@Table(name = "CodePostal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CodePostal.findAll", query = "SELECT c FROM CodePostal c"),
    @NamedQuery(name = "CodePostal.findByIdCodePostalPK", query = "SELECT c FROM CodePostal c WHERE c.idCodePostalPK = :idCodePostalPK"),
    @NamedQuery(name = "CodePostal.findByCodePostal", query = "SELECT c FROM CodePostal c WHERE c.codePostal = :CodePostal"),
    @NamedQuery(name = "CodePostal.findByVille", query = "SELECT c FROM CodePostal c WHERE c.ville = :ville"),
    @NamedQuery(name = "CodePostal.findByProvince", query = "SELECT c FROM CodePostal c WHERE c.province = :province"),
    @NamedQuery(name = "CodePostal.findByPays", query = "SELECT c FROM CodePostal c WHERE c.pays = :pays")})
public class CodePostal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCodePostal_PK")
    private Integer idCodePostalPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "codePostal")
    private String codePostal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ville")
    private String ville;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "province")
    private String province;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "pays")
    private String pays;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCodePostalFK")
    private List<Adresse> adresseList;

    public CodePostal() {
    }

    public CodePostal(Integer idCodePostalPK) {
        this.idCodePostalPK = idCodePostalPK;
    }

    public CodePostal(Integer idCodePostalPK, String codePostal, String ville, String province, String pays) {
        this.idCodePostalPK = idCodePostalPK;
        this.codePostal = codePostal;
        this.ville = ville;
        this.province = province;
        this.pays = pays;
    }

    public Integer getIdCodePostalPK() {
        return idCodePostalPK;
    }

    public void setIdCodePostalPK(Integer idCodePostalPK) {
        this.idCodePostalPK = idCodePostalPK;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    @XmlTransient
    public List<Adresse> getAdresseList() {
        return adresseList;
    }

    public void setAdresseList(List<Adresse> adresseList) {
        this.adresseList = adresseList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCodePostalPK != null ? idCodePostalPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CodePostal)) {
            return false;
        }
        CodePostal other = (CodePostal) object;
        if ((this.idCodePostalPK == null && other.idCodePostalPK != null) || (this.idCodePostalPK != null && !this.idCodePostalPK.equals(other.idCodePostalPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pckEntites.CodePostal[ idCodePostalPK=" + idCodePostalPK + " ]";
    }
    
}
