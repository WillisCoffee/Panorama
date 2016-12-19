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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author clocal
 */
@Entity
@Table(name = "Groupe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Groupe.findAll", query = "SELECT g FROM Groupe g"),
    @NamedQuery(name = "Groupe.findByCours", query = "SELECT g FROM Groupe g WHERE g.idCoursFK = :idCoursFK "),
    @NamedQuery(name = "Groupe.findByProfesseur", query = "SELECT g FROM Groupe g WHERE g.professeurFK = :professeurFK "),
    @NamedQuery(name = "Groupe.findByIdGroupePK", query = "SELECT g FROM Groupe g WHERE g.idGroupePK = :idGroupePK")})
public class Groupe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idGroupe_PK")
    private Integer idGroupePK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGroupeFK")
    private List<ListeEtudiant> listeEtudiantList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGroupeFK")
    private List<Evaluation> evaluationList;
    @JoinColumn(name = "idCours_FK", referencedColumnName = "idCours_PK")
    @ManyToOne(optional = false)
    private Cours idCoursFK;
    @JoinColumn(name = "idSession_FK", referencedColumnName = "idSession_PK")
    @ManyToOne(optional = false)
    private Session idSessionFK;
    @JoinColumn(name = "professeur_FK", referencedColumnName = "numeroEmploye_PK")
    @ManyToOne(optional = false)
    private Professeur professeurFK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGroupeFK")
    private List<Document> documentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGroupeFK")
    private List<Communique> communiqueList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGroupeFK")
    private List<PlageHoraire> plageHoraireList;

    public Groupe() {
    }

    public Groupe(Integer idGroupePK) {
        this.idGroupePK = idGroupePK;
    }

    public Integer getIdGroupePK() {
        return idGroupePK;
    }

    public void setIdGroupePK(Integer idGroupePK) {
        this.idGroupePK = idGroupePK;
    }

    @XmlTransient
    public List<ListeEtudiant> getListeEtudiantList() {
        return listeEtudiantList;
    }

    public void setListeEtudiantList(List<ListeEtudiant> listeEtudiantList) {
        this.listeEtudiantList = listeEtudiantList;
    }

    @XmlTransient
    public List<Evaluation> getEvaluationList() {
        return evaluationList;
    }

    public void setEvaluationList(List<Evaluation> evaluationList) {
        this.evaluationList = evaluationList;
    }

    public Cours getIdCoursFK() {
        return idCoursFK;
    }

    public void setIdCoursFK(Cours idCoursFK) {
        this.idCoursFK = idCoursFK;
    }

    public Session getIdSessionFK() {
        return idSessionFK;
    }

    public void setIdSessionFK(Session idSessionFK) {
        this.idSessionFK = idSessionFK;
    }

    public Professeur getProfesseurFK() {
        return professeurFK;
    }

    public void setProfesseurFK(Professeur professeurFK) {
        this.professeurFK = professeurFK;
    }

    @XmlTransient
    public List<Document> getDocumentList() {
        return documentList;
    }

    public void setDocumentList(List<Document> documentList) {
        this.documentList = documentList;
    }

    @XmlTransient
    public List<Communique> getCommuniqueList() {
        return communiqueList;
    }

    public void setCommuniqueList(List<Communique> communiqueList) {
        this.communiqueList = communiqueList;
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
        hash += (idGroupePK != null ? idGroupePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Groupe)) {
            return false;
        }
        Groupe other = (Groupe) object;
        if ((this.idGroupePK == null && other.idGroupePK != null) || (this.idGroupePK != null && !this.idGroupePK.equals(other.idGroupePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pckEntites.Groupe[ idGroupePK=" + idGroupePK + " ]";
    }
    
}
