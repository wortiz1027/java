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
@Table(name = "tbl_ops_tipo_usuario", catalog = "opennotes", schema = "")
@NamedQueries({
    @NamedQuery(name = "TblOpsTipoUsuario.findAll", query = "SELECT t FROM TblOpsTipoUsuario t")
    , @NamedQuery(name = "TblOpsTipoUsuario.findByIdTipoUsuario", query = "SELECT t FROM TblOpsTipoUsuario t WHERE t.idTipoUsuario = :idTipoUsuario")
    , @NamedQuery(name = "TblOpsTipoUsuario.findByTipoUsuario", query = "SELECT t FROM TblOpsTipoUsuario t WHERE t.tipoUsuario = :tipoUsuario")})
public class TblOpsTipoUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_usuario")
    private Long idTipoUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "tipo_usuario")
    private String tipoUsuario;
    @OneToMany(mappedBy = "idTipoUsuario")
    private List<TblSecUsers> tblSecUsersList;

    public TblOpsTipoUsuario() {
    }

    public TblOpsTipoUsuario(Long idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public TblOpsTipoUsuario(Long idTipoUsuario, String tipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
        this.tipoUsuario = tipoUsuario;
    }

    public Long getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(Long idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
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
        hash += (idTipoUsuario != null ? idTipoUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblOpsTipoUsuario)) {
            return false;
        }
        TblOpsTipoUsuario other = (TblOpsTipoUsuario) object;
        if ((this.idTipoUsuario == null && other.idTipoUsuario != null) || (this.idTipoUsuario != null && !this.idTipoUsuario.equals(other.idTipoUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.opennotes.model.entities.TblOpsTipoUsuario[ idTipoUsuario=" + idTipoUsuario + " ]";
    }
    
}
