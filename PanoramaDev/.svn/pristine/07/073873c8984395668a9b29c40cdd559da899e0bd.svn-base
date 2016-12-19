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
@Table(name = "Document")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Document.findAll", query = "SELECT d FROM Document d"),
    @NamedQuery(name = "Document.findByIdDocumentPK", query = "SELECT d FROM Document d WHERE d.idDocumentPK = :idDocumentPK"),
    @NamedQuery(name = "Document.findByCategorie", query = "SELECT d FROM Document d WHERE d.categorie = :categorie"),
    @NamedQuery(name = "Document.findByTitre", query = "SELECT d FROM Document d WHERE d.titre = :titre"),
    @NamedQuery(name = "Document.findByDescriptionDoc", query = "SELECT d FROM Document d WHERE d.descriptionDoc = :descriptionDoc"),
    @NamedQuery(name = "Document.findByTaille", query = "SELECT d FROM Document d WHERE d.taille = :taille"),
    @NamedQuery(name = "Document.findByFichier", query = "SELECT d FROM Document d WHERE d.fichier = :fichier"),
    @NamedQuery(name = "Document.findByDateDebut", query = "SELECT d FROM Document d WHERE d.dateDebut = :dateDebut"),
    @NamedQuery(name = "Document.findByDateFin", query = "SELECT d FROM Document d WHERE d.dateFin = :dateFin")})
public class Document implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDocument_PK")
    private Integer idDocumentPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "categorie")
    private String categorie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "titre")
    private String titre;
    @Size(max = 255)
    @Column(name = "descriptionDoc")
    private String descriptionDoc;
    @Size(max = 10)
    @Column(name = "taille")
    private String taille;
    @Size(max = 255)
    @Column(name = "fichier")
    private String fichier;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateDebut")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDebut;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateFin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFin;
    @JoinColumn(name = "idGroupe_FK", referencedColumnName = "idGroupe_PK")
    @ManyToOne(optional = false)
    private Groupe idGroupeFK;

    public Document() {
    }

    public Document(Integer idDocumentPK) {
        this.idDocumentPK = idDocumentPK;
    }

    public Document(Integer idDocumentPK, String categorie, String titre, Date dateDebut, Date dateFin) {
        this.idDocumentPK = idDocumentPK;
        this.categorie = categorie;
        this.titre = titre;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public Integer getIdDocumentPK() {
        return idDocumentPK;
    }

    public void setIdDocumentPK(Integer idDocumentPK) {
        this.idDocumentPK = idDocumentPK;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescriptionDoc() {
        return descriptionDoc;
    }

    public void setDescriptionDoc(String descriptionDoc) {
        this.descriptionDoc = descriptionDoc;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public String getFichier() {
        return fichier;
    }

    public void setFichier(String fichier) {
        this.fichier = fichier;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
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
        hash += (idDocumentPK != null ? idDocumentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Document)) {
            return false;
        }
        Document other = (Document) object;
        if ((this.idDocumentPK == null && other.idDocumentPK != null) || (this.idDocumentPK != null && !this.idDocumentPK.equals(other.idDocumentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pckEntites.Document[ idDocumentPK=" + idDocumentPK + " ]";
    }
    
}
