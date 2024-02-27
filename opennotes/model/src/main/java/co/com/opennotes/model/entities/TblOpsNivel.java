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
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author PX60
 */
@Entity
@Table(name = "tbl_ops_nivel", catalog = "opennotes", schema = "")
@NamedQueries({
    @NamedQuery(name = "TblOpsNivel.findAll", query = "SELECT t FROM TblOpsNivel t")
    , @NamedQuery(name = "TblOpsNivel.findByIdNivel", query = "SELECT t FROM TblOpsNivel t WHERE t.idNivel = :idNivel")
    , @NamedQuery(name = "TblOpsNivel.findByDescripcionNivel", query = "SELECT t FROM TblOpsNivel t WHERE t.descripcionNivel = :descripcionNivel")})
public class TblOpsNivel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_nivel")
    private Long idNivel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "descripcion_nivel")
    private String descripcionNivel;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tblOpsNivel")
    private TblOpsGrupo tblOpsGrupo;

    public TblOpsNivel() {
    }

    public TblOpsNivel(Long idNivel) {
        this.idNivel = idNivel;
    }

    public TblOpsNivel(Long idNivel, String descripcionNivel) {
        this.idNivel = idNivel;
        this.descripcionNivel = descripcionNivel;
    }

    public Long getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(Long idNivel) {
        this.idNivel = idNivel;
    }

    public String getDescripcionNivel() {
        return descripcionNivel;
    }

    public void setDescripcionNivel(String descripcionNivel) {
        this.descripcionNivel = descripcionNivel;
    }

    public TblOpsGrupo getTblOpsGrupo() {
        return tblOpsGrupo;
    }

    public void setTblOpsGrupo(TblOpsGrupo tblOpsGrupo) {
        this.tblOpsGrupo = tblOpsGrupo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNivel != null ? idNivel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblOpsNivel)) {
            return false;
        }
        TblOpsNivel other = (TblOpsNivel) object;
        if ((this.idNivel == null && other.idNivel != null) || (this.idNivel != null && !this.idNivel.equals(other.idNivel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.opennotes.model.entities.TblOpsNivel[ idNivel=" + idNivel + " ]";
    }
    
}
