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
@Table(name = "tbl_ops_tipo_identificacion", catalog = "opennotes", schema = "")
@NamedQueries({
    @NamedQuery(name = "TblOpsTipoIdentificacion.findAll", query = "SELECT t FROM TblOpsTipoIdentificacion t")
    , @NamedQuery(name = "TblOpsTipoIdentificacion.findByIdTipoIdentificacion", query = "SELECT t FROM TblOpsTipoIdentificacion t WHERE t.idTipoIdentificacion = :idTipoIdentificacion")
    , @NamedQuery(name = "TblOpsTipoIdentificacion.findByTipoIdentificacion", query = "SELECT t FROM TblOpsTipoIdentificacion t WHERE t.tipoIdentificacion = :tipoIdentificacion")
    , @NamedQuery(name = "TblOpsTipoIdentificacion.findByDescIdentificacion", query = "SELECT t FROM TblOpsTipoIdentificacion t WHERE t.descIdentificacion = :descIdentificacion")})
public class TblOpsTipoIdentificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_identificacion")
    private Long idTipoIdentificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "tipo_identificacion")
    private String tipoIdentificacion;
    @Size(max = 100)
    @Column(name = "desc_identificacion")
    private String descIdentificacion;
    @OneToMany(mappedBy = "idTipoIdentificacion")
    private List<TblSecUsers> tblSecUsersList;

    public TblOpsTipoIdentificacion() {
    }

    public TblOpsTipoIdentificacion(Long idTipoIdentificacion) {
        this.idTipoIdentificacion = idTipoIdentificacion;
    }

    public TblOpsTipoIdentificacion(Long idTipoIdentificacion, String tipoIdentificacion) {
        this.idTipoIdentificacion = idTipoIdentificacion;
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public Long getIdTipoIdentificacion() {
        return idTipoIdentificacion;
    }

    public void setIdTipoIdentificacion(Long idTipoIdentificacion) {
        this.idTipoIdentificacion = idTipoIdentificacion;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getDescIdentificacion() {
        return descIdentificacion;
    }

    public void setDescIdentificacion(String descIdentificacion) {
        this.descIdentificacion = descIdentificacion;
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
        hash += (idTipoIdentificacion != null ? idTipoIdentificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblOpsTipoIdentificacion)) {
            return false;
        }
        TblOpsTipoIdentificacion other = (TblOpsTipoIdentificacion) object;
        if ((this.idTipoIdentificacion == null && other.idTipoIdentificacion != null) || (this.idTipoIdentificacion != null && !this.idTipoIdentificacion.equals(other.idTipoIdentificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.opennotes.model.entities.TblOpsTipoIdentificacion[ idTipoIdentificacion=" + idTipoIdentificacion + " ]";
    }
    
}
