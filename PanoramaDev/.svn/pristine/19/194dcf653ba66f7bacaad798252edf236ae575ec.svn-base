/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pckEntites;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author clocal
 */
@Entity
@Table(name = "Note")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Note.findAll", query = "SELECT n FROM Note n"),
    @NamedQuery(name = "Note.findByIdNotePK", query = "SELECT n FROM Note n WHERE n.idNotePK = :idNotePK"),
    @NamedQuery(name = "Note.findByPointsObtenus", query = "SELECT n FROM Note n WHERE n.pointsObtenus = :pointsObtenus"),
    @NamedQuery(name = "Note.findByMatricule", query = "SELECT n FROM Note n "
            + "INNER JOIN Evaluation E ON E.idEvaluation_PK = N.idEvaluationFK WHERE n.matriculeFK = :matricule AND E.idGroupeFK = :groupe")})
public class Note implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idNote_PK")
    private Integer idNotePK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "pointsObtenus")
    private BigDecimal pointsObtenus;
    @JoinColumn(name = "idEvaluation_FK", referencedColumnName = "idEvaluation_PK")
    @ManyToOne(optional = false)
    private Evaluation idEvaluationFK;
    @JoinColumn(name = "matricule_FK", referencedColumnName = "matricule_PK")
    @ManyToOne(optional = false)
    private Etudiant matriculeFK;

    public Note() {
    }

    public Note(Integer idNotePK) {
        this.idNotePK = idNotePK;
    }

    public Integer getIdNotePK() {
        return idNotePK;
    }

    public void setIdNotePK(Integer idNotePK) {
        this.idNotePK = idNotePK;
    }

    public BigDecimal getPointsObtenus() {
        return pointsObtenus;
    }

    public void setPointsObtenus(BigDecimal pointsObtenus) {
        this.pointsObtenus = pointsObtenus;
    }

    public Evaluation getIdEvaluationFK() {
        return idEvaluationFK;
    }

    public void setIdEvaluationFK(Evaluation idEvaluationFK) {
        this.idEvaluationFK = idEvaluationFK;
    }

    public Etudiant getMatriculeFK() {
        return matriculeFK;
    }

    public void setMatriculeFK(Etudiant matriculeFK) {
        this.matriculeFK = matriculeFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNotePK != null ? idNotePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Note)) {
            return false;
        }
        Note other = (Note) object;
        if ((this.idNotePK == null && other.idNotePK != null) || (this.idNotePK != null && !this.idNotePK.equals(other.idNotePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pckEntites.Note[ idNotePK=" + idNotePK + " ]";
    }
    
}
