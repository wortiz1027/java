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
import java.util.List;
import javax.persistence.Basic;
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

/**
 *
 * @author PX60
 */
@Entity
@Table(name = "tbl_ops_eps", catalog = "opennotes", schema = "")
@NamedQueries({
    @NamedQuery(name = "TblOpsEps.findAll", query = "SELECT t FROM TblOpsEps t")
    , @NamedQuery(name = "TblOpsEps.findByIdEps", query = "SELECT t FROM TblOpsEps t WHERE t.idEps = :idEps")
    , @NamedQuery(name = "TblOpsEps.findByDescripcionEps", query = "SELECT t FROM TblOpsEps t WHERE t.descripcionEps = :descripcionEps")})
public class TblOpsEps implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_eps")
    private Long idEps;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion_eps")
    private String descripcionEps;
    @OneToMany(mappedBy = "idEps")
    private List<TblSecUsers> tblSecUsersList;

    public TblOpsEps() {
    }

    public TblOpsEps(Long idEps) {
        this.idEps = idEps;
    }

    public TblOpsEps(Long idEps, String descripcionEps) {
        this.idEps = idEps;
        this.descripcionEps = descripcionEps;
    }

    public Long getIdEps() {
        return idEps;
    }

    public void setIdEps(Long idEps) {
        this.idEps = idEps;
    }

    public String getDescripcionEps() {
        return descripcionEps;
    }

    public void setDescripcionEps(String descripcionEps) {
        this.descripcionEps = descripcionEps;
    }

    public List<TblSecUsers> getTblSecUsersList() {
        return tblSecUsersList;
    }

    public void setTblSecUsersList(List<TblSecUsers> tblSecUsersList) {
        this.tblSecUsersList = tblSecUsersList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEps != null ? idEps.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblOpsEps)) {
            return false;
        }
        TblOpsEps other = (TblOpsEps) object;
        if ((this.idEps == null && other.idEps != null) || (this.idEps != null && !this.idEps.equals(other.idEps))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.opennotes.model.entities.TblOpsEps[ idEps=" + idEps + " ]";
    }
    
}
