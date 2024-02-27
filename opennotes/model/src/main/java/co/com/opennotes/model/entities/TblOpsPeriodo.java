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
@Table(name = "tbl_ops_periodo", catalog = "opennotes", schema = "")
@NamedQueries({
    @NamedQuery(name = "TblOpsPeriodo.findAll", query = "SELECT t FROM TblOpsPeriodo t")
    , @NamedQuery(name = "TblOpsPeriodo.findByIdPeriodo", query = "SELECT t FROM TblOpsPeriodo t WHERE t.idPeriodo = :idPeriodo")
    , @NamedQuery(name = "TblOpsPeriodo.findByPeriodo", query = "SELECT t FROM TblOpsPeriodo t WHERE t.periodo = :periodo")
    , @NamedQuery(name = "TblOpsPeriodo.findByFechaInicio", query = "SELECT t FROM TblOpsPeriodo t WHERE t.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "TblOpsPeriodo.findByFechaFin", query = "SELECT t FROM TblOpsPeriodo t WHERE t.fechaFin = :fechaFin")})
public class TblOpsPeriodo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_periodo")
    private Long idPeriodo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "periodo")
    private String periodo;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPeriodo")
    private List<TblOpsMatricula> tblOpsMatriculaList;
    @JoinColumn(name = "id_anio", referencedColumnName = "id_anio")
    @ManyToOne
    private TblOpsAnio idAnio;
    @OneToMany(mappedBy = "idPeriodo")
    private List<TblOpsCortes> tblOpsCortesList;

    public TblOpsPeriodo() {
    }

    public TblOpsPeriodo(Long idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public TblOpsPeriodo(Long idPeriodo, String periodo) {
        this.idPeriodo = idPeriodo;
        this.periodo = periodo;
    }

    public Long getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(Long idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public List<TblOpsMatricula> getTblOpsMatriculaList() {
        return tblOpsMatriculaList;
    }

    public void setTblOpsMatriculaList(List<TblOpsMatricula> tblOpsMatriculaList) {
        this.tblOpsMatriculaList = tblOpsMatriculaList;
    }

    public TblOpsAnio getIdAnio() {
        return idAnio;
    }

    public void setIdAnio(TblOpsAnio idAnio) {
        this.idAnio = idAnio;
    }

    public List<TblOpsCortes> getTblOpsCortesList() {
        return tblOpsCortesList;
    }

    public void setTblOpsCortesList(List<TblOpsCortes> tblOpsCortesList) {
        this.tblOpsCortesList = tblOpsCortesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPeriodo != null ? idPeriodo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblOpsPeriodo)) {
            return false;
        }
        TblOpsPeriodo other = (TblOpsPeriodo) object;
        if ((this.idPeriodo == null && other.idPeriodo != null) || (this.idPeriodo != null && !this.idPeriodo.equals(other.idPeriodo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.opennotes.model.entities.TblOpsPeriodo[ idPeriodo=" + idPeriodo + " ]";
    }
    
}
