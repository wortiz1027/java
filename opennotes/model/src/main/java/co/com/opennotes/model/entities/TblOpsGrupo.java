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
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author PX60
 */
@Entity
@Table(name = "tbl_ops_grupo", catalog = "opennotes", schema = "")
@NamedQueries({
    @NamedQuery(name = "TblOpsGrupo.findAll", query = "SELECT t FROM TblOpsGrupo t")
    , @NamedQuery(name = "TblOpsGrupo.findByIdGrupo", query = "SELECT t FROM TblOpsGrupo t WHERE t.idGrupo = :idGrupo")
    , @NamedQuery(name = "TblOpsGrupo.findByNombreGrupo", query = "SELECT t FROM TblOpsGrupo t WHERE t.nombreGrupo = :nombreGrupo")
    , @NamedQuery(name = "TblOpsGrupo.findByCupoGrupo", query = "SELECT t FROM TblOpsGrupo t WHERE t.cupoGrupo = :cupoGrupo")
    , @NamedQuery(name = "TblOpsGrupo.findByIdNivel", query = "SELECT t FROM TblOpsGrupo t WHERE t.idNivel = :idNivel")})
public class TblOpsGrupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_grupo")
    private Long idGrupo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_grupo")
    private String nombreGrupo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cupo_grupo")
    private int cupoGrupo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_nivel")
    private long idNivel;
    @OneToMany(mappedBy = "idGrupo")
    private List<TblSecUsers> tblSecUsersList;
    @JoinColumn(name = "id_grupo", referencedColumnName = "id_nivel", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private TblOpsNivel tblOpsNivel;

    public TblOpsGrupo() {
    }

    public TblOpsGrupo(Long idGrupo) {
        this.idGrupo = idGrupo;
    }

    public TblOpsGrupo(Long idGrupo, String nombreGrupo, int cupoGrupo, long idNivel) {
        this.idGrupo = idGrupo;
        this.nombreGrupo = nombreGrupo;
        this.cupoGrupo = cupoGrupo;
        this.idNivel = idNivel;
    }

    public Long getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Long idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    public int getCupoGrupo() {
        return cupoGrupo;
    }

    public void setCupoGrupo(int cupoGrupo) {
        this.cupoGrupo = cupoGrupo;
    }

    public long getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(long idNivel) {
        this.idNivel = idNivel;
    }

    public List<TblSecUsers> getTblSecUsersList() {
        return tblSecUsersList;
    }

    public void setTblSecUsersList(List<TblSecUsers> tblSecUsersList) {
        this.tblSecUsersList = tblSecUsersList;
    }

    public TblOpsNivel getTblOpsNivel() {
        return tblOpsNivel;
    }

    public void setTblOpsNivel(TblOpsNivel tblOpsNivel) {
        this.tblOpsNivel = tblOpsNivel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGrupo != null ? idGrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblOpsGrupo)) {
            return false;
        }
        TblOpsGrupo other = (TblOpsGrupo) object;
        if ((this.idGrupo == null && other.idGrupo != null) || (this.idGrupo != null && !this.idGrupo.equals(other.idGrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.opennotes.model.entities.TblOpsGrupo[ idGrupo=" + idGrupo + " ]";
    }
    
}
