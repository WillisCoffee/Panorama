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
@Table(name = "Cegep")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cegep.findAll", query = "SELECT c FROM Cegep c"),
    @NamedQuery(name = "Cegep.findByIdCegepPK", query = "SELECT c FROM Cegep c WHERE c.idCegepPK = :idCegepPK"),
    @NamedQuery(name = "Cegep.findByNomCegep", query = "SELECT c FROM Cegep c WHERE c.nomCegep = :nomCegep"),
    @NamedQuery(name = "Cegep.findByNumeroTel", query = "SELECT c FROM Cegep c WHERE c.numeroTel = :numeroTel"),
    @NamedQuery(name = "Cegep.findByAdresseWEB", query = "SELECT c FROM Cegep c WHERE c.adresseWEB = :adresseWEB")})
public class Cegep implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCegep_PK")
    private Integer idCegepPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "nomCegep")
    private String nomCegep;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "numeroTel")
    private String numeroTel;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "logoCegep")
    private byte[] logoCegep;
    @Size(max = 255)
    @Column(name = "adresseWEB")
    private String adresseWEB;
    @JoinColumn(name = "idAdresse_FK", referencedColumnName = "idAdresse_PK")
    @ManyToOne(optional = false)
    private Adresse idAdresseFK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCegepFK")
    private List<Departement> departementList;

    public Cegep() {
    }

    public Cegep(Integer idCegepPK) {
        this.idCegepPK = idCegepPK;
    }

    public Cegep(Integer idCegepPK, String nomCegep, String numeroTel, byte[] logoCegep) {
        this.idCegepPK = idCegepPK;
        this.nomCegep = nomCegep;
        this.numeroTel = numeroTel;
        this.logoCegep = logoCegep;
    }

    public Integer getIdCegepPK() {
        return idCegepPK;
    }

    public void setIdCegepPK(Integer idCegepPK) {
        this.idCegepPK = idCegepPK;
    }

    public String getNomCegep() {
        return nomCegep;
    }

    public void setNomCegep(String nomCegep) {
        this.nomCegep = nomCegep;
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }

    public byte[] getLogoCegep() {
        return logoCegep;
    }

    public void setLogoCegep(byte[] logoCegep) {
        this.logoCegep = logoCegep;
    }

    public String getAdresseWEB() {
        return adresseWEB;
    }

    public void setAdresseWEB(String adresseWEB) {
        this.adresseWEB = adresseWEB;
    }

    public Adresse getIdAdresseFK() {
        return idAdresseFK;
    }

    public void setIdAdresseFK(Adresse idAdresseFK) {
        this.idAdresseFK = idAdresseFK;
    }

    @XmlTransient
    public List<Departement> getDepartementList() {
        return departementList;
    }

    public void setDepartementList(List<Departement> departementList) {
        this.departementList = departementList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCegepPK != null ? idCegepPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cegep)) {
            return false;
        }
        Cegep other = (Cegep) object;
        if ((this.idCegepPK == null && other.idCegepPK != null) || (this.idCegepPK != null && !this.idCegepPK.equals(other.idCegepPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pckEntites.Cegep[ idCegepPK=" + idCegepPK + " ]";
    }
    
}
