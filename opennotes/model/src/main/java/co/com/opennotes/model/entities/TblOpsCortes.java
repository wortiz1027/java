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
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author PX60
 */
@Entity
@Table(name = "tbl_ops_cortes", catalog = "opennotes", schema = "")
@NamedQueries({
    @NamedQuery(name = "TblOpsCortes.findAll", query = "SELECT t FROM TblOpsCortes t")
    , @NamedQuery(name = "TblOpsCortes.findByIdCorte", query = "SELECT t FROM TblOpsCortes t WHERE t.idCorte = :idCorte")
    , @NamedQuery(name = "TblOpsCortes.findByDescripcionCorte", query = "SELECT t FROM TblOpsCortes t WHERE t.descripcionCorte = :descripcionCorte")
    , @NamedQuery(name = "TblOpsCortes.findByFechaCorte", query = "SELECT t FROM TblOpsCortes t WHERE t.fechaCorte = :fechaCorte")})
public class TblOpsCortes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_corte")
    private Long idCorte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion_corte")
    private String descripcionCorte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_corte")
    @Temporal(TemporalType.DATE)
    private Date fechaCorte;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCorte")
    private List<TblOpsNotas> tblOpsNotasList;
    @JoinColumn(name = "id_periodo", referencedColumnName = "id_periodo")
    @ManyToOne
    private TblOpsPeriodo idPeriodo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblOpsCortes")
    private List<TblOpsReportes> tblOpsReportesList;

    public TblOpsCortes() {
    }

    public TblOpsCortes(Long idCorte) {
        this.idCorte = idCorte;
    }

    public TblOpsCortes(Long idCorte, String descripcionCorte, Date fechaCorte) {
        this.idCorte = idCorte;
        this.descripcionCorte = descripcionCorte;
        this.fechaCorte = fechaCorte;
    }

    public Long getIdCorte() {
        return idCorte;
    }

    public void setIdCorte(Long idCorte) {
        this.idCorte = idCorte;
    }

    public String getDescripcionCorte() {
        return descripcionCorte;
    }

    public void setDescripcionCorte(String descripcionCorte) {
        this.descripcionCorte = descripcionCorte;
    }

    public Date getFechaCorte() {
        return fechaCorte;
    }

    public void setFechaCorte(Date fechaCorte) {
        this.fechaCorte = fechaCorte;
    }

    public List<TblOpsNotas> getTblOpsNotasList() {
        return tblOpsNotasList;
    }

    public void setTblOpsNotasList(List<TblOpsNotas> tblOpsNotasList) {
        this.tblOpsNotasList = tblOpsNotasList;
    }

    public TblOpsPeriodo getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(TblOpsPeriodo idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public List<TblOpsReportes> getTblOpsReportesList() {
        return tblOpsReportesList;
    }

    public void setTblOpsReportesList(List<TblOpsReportes> tblOpsReportesList) {
        this.tblOpsReportesList = tblOpsReportesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCorte != null ? idCorte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblOpsCortes)) {
            return false;
        }
        TblOpsCortes other = (TblOpsCortes) object;
        if ((this.idCorte == null && other.idCorte != null) || (this.idCorte != null && !this.idCorte.equals(other.idCorte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.opennotes.model.entities.TblOpsCortes[ idCorte=" + idCorte + " ]";
    }
    
}
