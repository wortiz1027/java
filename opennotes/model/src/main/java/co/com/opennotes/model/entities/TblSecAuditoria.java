/*
 * Copyright (C) 2017 PX60
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package co.com.opennotes.model.entities;

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

/**
 *
 * @author PX60
 */
@Entity
@Table(name = "tbl_sec_auditoria", catalog = "opennotes", schema = "")
@NamedQueries({
    @NamedQuery(name = "TblSecAuditoria.findAll", query = "SELECT t FROM TblSecAuditoria t")
    , @NamedQuery(name = "TblSecAuditoria.findByIdAuditoria", query = "SELECT t FROM TblSecAuditoria t WHERE t.idAuditoria = :idAuditoria")
    , @NamedQuery(name = "TblSecAuditoria.findByFechaIngreso", query = "SELECT t FROM TblSecAuditoria t WHERE t.fechaIngreso = :fechaIngreso")
    , @NamedQuery(name = "TblSecAuditoria.findByFechaSalida", query = "SELECT t FROM TblSecAuditoria t WHERE t.fechaSalida = :fechaSalida")})
public class TblSecAuditoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_auditoria")
    private Long idAuditoria;
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso;
    @Column(name = "fecha_salida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSalida;
    @JoinColumn(name = "id_users", referencedColumnName = "id_user")
    @ManyToOne(optional = false)
    private TblSecUsers idUsers;

    public TblSecAuditoria() {
    }

    public TblSecAuditoria(Long idAuditoria) {
        this.idAuditoria = idAuditoria;
    }

    public Long getIdAuditoria() {
        return idAuditoria;
    }

    public void setIdAuditoria(Long idAuditoria) {
        this.idAuditoria = idAuditoria;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public TblSecUsers getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(TblSecUsers idUsers) {
        this.idUsers = idUsers;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAuditoria != null ? idAuditoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblSecAuditoria)) {
            return false;
        }
        TblSecAuditoria other = (TblSecAuditoria) object;
        if ((this.idAuditoria == null && other.idAuditoria != null) || (this.idAuditoria != null && !this.idAuditoria.equals(other.idAuditoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.opennotes.model.entities.TblSecAuditoria[ idAuditoria=" + idAuditoria + " ]";
    }
    
}
