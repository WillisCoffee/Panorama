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
@Table(name = "ReserverLocaux")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReserverLocaux.findAll", query = "SELECT r FROM ReserverLocaux r"),
    @NamedQuery(name = "ReserverLocaux.findByIdReserverLocauxPK", query = "SELECT r FROM ReserverLocaux r WHERE r.idReserverLocauxPK = :idReserverLocauxPK"),
    @NamedQuery(name = "ReserverLocaux.findByHeureDebut", query = "SELECT r FROM ReserverLocaux r WHERE r.heureDebut = :heureDebut"),
    @NamedQuery(name = "ReserverLocaux.findByHeureFin", query = "SELECT r FROM ReserverLocaux r WHERE r.heureFin = :heureFin"),
    @NamedQuery(name = "ReserverLocaux.findByReserverA", query = "SELECT r FROM ReserverLocaux r WHERE r.reserverA = :reserverA")})
public class ReserverLocaux implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idReserverLocaux_PK")
    private Integer idReserverLocauxPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "heureDebut")
    @Temporal(TemporalType.TIMESTAMP)
    private Date heureDebut;
    @Basic(optional = false)
    @NotNull
    @Column(name = "heureFin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date heureFin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "reserverA")
    private String reserverA;
    @JoinColumn(name = "idLocaux_FK", referencedColumnName = "idLocaux_PK")
    @ManyToOne(optional = false)
    private Locaux idLocauxFK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateReservation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateReservation;

    public ReserverLocaux() {
    }

    public ReserverLocaux(Integer idReserverLocauxPK) {
        this.idReserverLocauxPK = idReserverLocauxPK;
    }

    public ReserverLocaux(Integer idReserverLocauxPK, Date heureDebut, Date heureFin, String reserverA, Date dateReservation) {
        this.idReserverLocauxPK = idReserverLocauxPK;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.reserverA = reserverA;
        this.dateReservation = dateReservation;
    }

    public Integer getIdReserverLocauxPK() {
        return idReserverLocauxPK;
    }

    public void setIdReserverLocauxPK(Integer idReserverLocauxPK) {
        this.idReserverLocauxPK = idReserverLocauxPK;
    }

    public Date getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(Date heureDebut) {
        this.heureDebut = heureDebut;
    }

    public Date getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(Date heureFin) {
        this.heureFin = heureFin;
    }

    public String getReserverA() {
        return reserverA;
    }

    public void setReserverA(String reserverA) {
        this.reserverA = reserverA;
    }

    public Locaux getIdLocauxFK() {
        return idLocauxFK;
    }

    public void setIdLocauxFK(Locaux idLocauxFK) {
        this.idLocauxFK = idLocauxFK;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReserverLocauxPK != null ? idReserverLocauxPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReserverLocaux)) {
            return false;
        }
        ReserverLocaux other = (ReserverLocaux) object;
        if ((this.idReserverLocauxPK == null && other.idReserverLocauxPK != null) || (this.idReserverLocauxPK != null && !this.idReserverLocauxPK.equals(other.idReserverLocauxPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pckEntites.ReserverLocaux[ idReserverLocauxPK=" + idReserverLocauxPK + " ]";
    }
    
}
