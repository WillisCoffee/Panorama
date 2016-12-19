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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Etudiant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Etudiant.findAll", query = "SELECT e FROM Etudiant e"),
    @NamedQuery(name = "Etudiant.findByMatriculePK", query = "SELECT e FROM Etudiant e WHERE e.matriculePK = :matriculePK"),
    @NamedQuery(name = "Etudiant.findByDateInscription", query = "SELECT e FROM Etudiant e WHERE e.dateInscription = :dateInscription"),
    @NamedQuery(name = "Etudiant.findByNomPrenom", query = "Select e from Etudiant e inner join Utilisateur u on u.idUtilisateur_PK = e.idUtilisateurFK where u.nom = :nom and u.prenom = :prenom"),
    @NamedQuery(name = "Etudiant.findByPrenom", query = "Select e from Etudiant e inner join Utilisateur u on u.idUtilisateur_PK = e.idUtilisateurFK where u.prenom = :prenom"),
    @NamedQuery(name = "Etudiant.findByNom", query = "Select e from Etudiant e inner join Utilisateur u on u.idUtilisateur_PK = e.idUtilisateurFK where u.nom = :nom"),
    @NamedQuery(name = "Etudiant.findByCodePermanent", query = "SELECT e FROM Etudiant e WHERE e.codePermanent = :codePermanent")})
public class Etudiant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "matricule_PK")
    private String matriculePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateInscription")
    @Temporal(TemporalType.DATE)
    private Date dateInscription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "codePermanent")
    private String codePermanent;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matriculeFK")
    private List<ListeEtudiant> listeEtudiantList;
    @JoinColumn(name = "idUtilisateur_FK", referencedColumnName = "idUtilisateur_PK")
    @ManyToOne(optional = false)
    private Utilisateur idUtilisateurFK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matriculeFK")
    private List<Note> noteList;

    public Etudiant() {
    }

    public Etudiant(String matriculePK) {
        this.matriculePK = matriculePK;
    }

    public Etudiant(String matriculePK, Date dateInscription, String codePermanent) {
        this.matriculePK = matriculePK;
        this.dateInscription = dateInscription;
        this.codePermanent = codePermanent;
    }

    public String getMatriculePK() {
        return matriculePK;
    }

    public void setMatriculePK(String matriculePK) {
        this.matriculePK = matriculePK;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public String getCodePermanent() {
        return codePermanent;
    }

    public void setCodePermanent(String codePermanent) {
        this.codePermanent = codePermanent;
    }

    @XmlTransient
    public List<ListeEtudiant> getListeEtudiantList() {
        return listeEtudiantList;
    }

    public void setListeEtudiantList(List<ListeEtudiant> listeEtudiantList) {
        this.listeEtudiantList = listeEtudiantList;
    }

    public Utilisateur getIdUtilisateurFK() {
        return idUtilisateurFK;
    }

    public void setIdUtilisateurFK(Utilisateur idUtilisateurFK) {
        this.idUtilisateurFK = idUtilisateurFK;
    }

    @XmlTransient
    public List<Note> getNoteList() {
        return noteList;
    }

    public void setNoteList(List<Note> noteList) {
        this.noteList = noteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matriculePK != null ? matriculePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etudiant)) {
            return false;
        }
        Etudiant other = (Etudiant) object;
        if ((this.matriculePK == null && other.matriculePK != null) || (this.matriculePK != null && !this.matriculePK.equals(other.matriculePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pckEntites.Etudiant[ matriculePK=" + matriculePK + " ]";
    }
    
}
