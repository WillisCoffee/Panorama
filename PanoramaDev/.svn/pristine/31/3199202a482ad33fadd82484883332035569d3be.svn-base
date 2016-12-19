/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pckEntites;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author clocal
 */
@Entity
@Table(name = "PersonnelSoutien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonnelSoutien.findAll", query = "SELECT p FROM PersonnelSoutien p"),
    @NamedQuery(name = "PersonnelSoutien.findByNumeroPersonnelPK", query = "SELECT p FROM PersonnelSoutien p WHERE p.numeroPersonnelPK = :numeroPersonnelPK"),
    @NamedQuery(name = "PersonnelSoutien.findByNumeroPosteSoutien", query = "SELECT p FROM PersonnelSoutien p WHERE p.numeroPosteSoutien = :numeroPosteSoutien"),
    @NamedQuery(name = "PersonnelSoutien.findByNomPrenom", query = "Select p from PersonnelSoutien p inner join Utilisateur u on u.idUtilisateur_PK = p.idUtilisateurFK where u.nom = :nom and u.prenom = :prenom"),
    @NamedQuery(name = "PersonnelSoutien.findByPrenom", query = "Select p from PersonnelSoutien p inner join Utilisateur u on u.idUtilisateur_PK = p.idUtilisateurFK where u.prenom = :prenom"),
    @NamedQuery(name = "PersonnelSoutien.findByNom", query = "Select p from PersonnelSoutien p inner join Utilisateur u on u.idUtilisateur_PK = p.idUtilisateurFK where u.nom = :nom"),
    @NamedQuery(name = "PersonnelSoutien.findByFonction", query = "SELECT p FROM PersonnelSoutien p WHERE p.fonction = :fonction")})
public class PersonnelSoutien implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "numeroPersonnel_PK")
    private String numeroPersonnelPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "numeroPosteSoutien")
    private String numeroPosteSoutien;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "fonction")
    private String fonction;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "disponibilite")
    private String disponibilite;
    @JoinColumn(name = "idUtilisateur_FK", referencedColumnName = "idUtilisateur_PK")
    @ManyToOne(optional = false)
    private Utilisateur idUtilisateurFK;

    public PersonnelSoutien() {
    }

    public PersonnelSoutien(String numeroPersonnelPK) {
        this.numeroPersonnelPK = numeroPersonnelPK;
    }

    public PersonnelSoutien(String numeroPersonnelPK, String numeroPosteSoutien, String fonction) {
        this.numeroPersonnelPK = numeroPersonnelPK;
        this.numeroPosteSoutien = numeroPosteSoutien;
        this.fonction = fonction;
    }

    public String getNumeroPersonnelPK() {
        return numeroPersonnelPK;
    }

    public void setNumeroPersonnelPK(String numeroPersonnelPK) {
        this.numeroPersonnelPK = numeroPersonnelPK;
    }

    public String getNumeroPosteSoutien() {
        return numeroPosteSoutien;
    }

    public void setNumeroPosteSoutien(String numeroPosteSoutien) {
        this.numeroPosteSoutien = numeroPosteSoutien;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(String disponibilite) {
        this.disponibilite = disponibilite;
    }

    public Utilisateur getIdUtilisateurFK() {
        return idUtilisateurFK;
    }

    public void setIdUtilisateurFK(Utilisateur idUtilisateurFK) {
        this.idUtilisateurFK = idUtilisateurFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroPersonnelPK != null ? numeroPersonnelPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonnelSoutien)) {
            return false;
        }
        PersonnelSoutien other = (PersonnelSoutien) object;
        if ((this.numeroPersonnelPK == null && other.numeroPersonnelPK != null) || (this.numeroPersonnelPK != null && !this.numeroPersonnelPK.equals(other.numeroPersonnelPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pckEntites.PersonnelSoutien[ numeroPersonnelPK=" + numeroPersonnelPK + " ]";
    }
    
}
