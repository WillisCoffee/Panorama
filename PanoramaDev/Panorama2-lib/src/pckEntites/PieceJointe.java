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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "PieceJointe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PieceJointe.findAll", query = "SELECT p FROM PieceJointe p"),
    @NamedQuery(name = "PieceJointe.findByIdPieceJointePK", query = "SELECT p FROM PieceJointe p WHERE p.idPieceJointePK = :idPieceJointePK")})
public class PieceJointe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPieceJointe_PK")
    private Integer idPieceJointePK;
    @Lob
    @Column(name = "pieceJointe")
    private byte[] pieceJointe;
    @JoinColumn(name = "idMessage_FK", referencedColumnName = "idMessage_PK")
    @ManyToOne(optional = false)
    private Message idMessageFK;

    public PieceJointe() {
    }

    public PieceJointe(Integer idPieceJointePK) {
        this.idPieceJointePK = idPieceJointePK;
    }

    public Integer getIdPieceJointePK() {
        return idPieceJointePK;
    }

    public void setIdPieceJointePK(Integer idPieceJointePK) {
        this.idPieceJointePK = idPieceJointePK;
    }

    public byte[] getPieceJointe() {
        return pieceJointe;
    }

    public void setPieceJointe(byte[] pieceJointe) {
        this.pieceJointe = pieceJointe;
    }

    public Message getIdMessageFK() {
        return idMessageFK;
    }

    public void setIdMessageFK(Message idMessageFK) {
        this.idMessageFK = idMessageFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPieceJointePK != null ? idPieceJointePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PieceJointe)) {
            return false;
        }
        PieceJointe other = (PieceJointe) object;
        if ((this.idPieceJointePK == null && other.idPieceJointePK != null) || (this.idPieceJointePK != null && !this.idPieceJointePK.equals(other.idPieceJointePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pckEntites.PieceJointe[ idPieceJointePK=" + idPieceJointePK + " ]";
    }
    
}
