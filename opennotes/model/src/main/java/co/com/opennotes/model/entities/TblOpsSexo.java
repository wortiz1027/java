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
import javax.persistence.CascadeType;
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
@Table(name = "tbl_ops_sexo", catalog = "opennotes", schema = "")
@NamedQueries({
    @NamedQuery(name = "TblOpsSexo.findAll", query = "SELECT t FROM TblOpsSexo t")
    , @NamedQuery(name = "TblOpsSexo.findByIdSexo", query = "SELECT t FROM TblOpsSexo t WHERE t.idSexo = :idSexo")
    , @NamedQuery(name = "TblOpsSexo.findByDescSexo", query = "SELECT t FROM TblOpsSexo t WHERE t.descSexo = :descSexo")})
public class TblOpsSexo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sexo")
    private Long idSexo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "desc_sexo")
    private String descSexo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSexo")
    private List<TblSecUsers> tblSecUsersList;

    public TblOpsSexo() {
    }

    public TblOpsSexo(Long idSexo) {
        this.idSexo = idSexo;
    }

    public TblOpsSexo(Long idSexo, String descSexo) {
        this.idSexo = idSexo;
        this.descSexo = descSexo;
    }

    public Long getIdSexo() {
        return idSexo;
    }

    public void setIdSexo(Long idSexo) {
        this.idSexo = idSexo;
    }

    public String getDescSexo() {
        return descSexo;
    }

    public void setDescSexo(String descSexo) {
        this.descSexo = descSexo;
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
        hash += (idSexo != null ? idSexo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblOpsSexo)) {
            return false;
        }
        TblOpsSexo other = (TblOpsSexo) object;
        if ((this.idSexo == null && other.idSexo != null) || (this.idSexo != null && !this.idSexo.equals(other.idSexo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.opennotes.model.entities.TblOpsSexo[ idSexo=" + idSexo + " ]";
    }
    
}
