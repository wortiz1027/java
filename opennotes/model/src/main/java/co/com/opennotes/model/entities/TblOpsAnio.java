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

/**
 *
 * @author PX60
 */
@Entity
@Table(name = "tbl_ops_anio", catalog = "opennotes", schema = "")
@NamedQueries({
    @NamedQuery(name = "TblOpsAnio.findAll", query = "SELECT t FROM TblOpsAnio t")
    , @NamedQuery(name = "TblOpsAnio.findByIdAnio", query = "SELECT t FROM TblOpsAnio t WHERE t.idAnio = :idAnio")
    , @NamedQuery(name = "TblOpsAnio.findByAnio", query = "SELECT t FROM TblOpsAnio t WHERE t.anio = :anio")})
public class TblOpsAnio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_anio")
    private Long idAnio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anio")
    private int anio;
    @OneToMany(mappedBy = "idAnio")
    private List<TblOpsPeriodo> tblOpsPeriodoList;

    public TblOpsAnio() {
    }

    public TblOpsAnio(Long idAnio) {
        this.idAnio = idAnio;
    }

    public TblOpsAnio(Long idAnio, int anio) {
        this.idAnio = idAnio;
        this.anio = anio;
    }

    public Long getIdAnio() {
        return idAnio;
    }

    public void setIdAnio(Long idAnio) {
        this.idAnio = idAnio;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public List<TblOpsPeriodo> getTblOpsPeriodoList() {
        return tblOpsPeriodoList;
    }

    public void setTblOpsPeriodoList(List<TblOpsPeriodo> tblOpsPeriodoList) {
        this.tblOpsPeriodoList = tblOpsPeriodoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnio != null ? idAnio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblOpsAnio)) {
            return false;
        }
        TblOpsAnio other = (TblOpsAnio) object;
        if ((this.idAnio == null && other.idAnio != null) || (this.idAnio != null && !this.idAnio.equals(other.idAnio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.opennotes.model.entities.TblOpsAnio[ idAnio=" + idAnio + " ]";
    }
    
}
