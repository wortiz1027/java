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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "tbl_ops_reportes", catalog = "opennotes", schema = "")
@NamedQueries({
    @NamedQuery(name = "TblOpsReportes.findAll", query = "SELECT t FROM TblOpsReportes t")
    , @NamedQuery(name = "TblOpsReportes.findByIdInforme", query = "SELECT t FROM TblOpsReportes t WHERE t.tblOpsReportesPK.idInforme = :idInforme")
    , @NamedQuery(name = "TblOpsReportes.findByIdUsuario", query = "SELECT t FROM TblOpsReportes t WHERE t.tblOpsReportesPK.idUsuario = :idUsuario")
    , @NamedQuery(name = "TblOpsReportes.findByIdCortes", query = "SELECT t FROM TblOpsReportes t WHERE t.tblOpsReportesPK.idCortes = :idCortes")
    , @NamedQuery(name = "TblOpsReportes.findByIdNotas", query = "SELECT t FROM TblOpsReportes t WHERE t.tblOpsReportesPK.idNotas = :idNotas")
    , @NamedQuery(name = "TblOpsReportes.findByIdLogros", query = "SELECT t FROM TblOpsReportes t WHERE t.tblOpsReportesPK.idLogros = :idLogros")
    , @NamedQuery(name = "TblOpsReportes.findByFechaInforme", query = "SELECT t FROM TblOpsReportes t WHERE t.fechaInforme = :fechaInforme")
    , @NamedQuery(name = "TblOpsReportes.findByObservaciones", query = "SELECT t FROM TblOpsReportes t WHERE t.observaciones = :observaciones")})
public class TblOpsReportes implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TblOpsReportesPK tblOpsReportesPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_informe")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInforme;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "id_cortes", referencedColumnName = "id_corte", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TblOpsCortes tblOpsCortes;
    @JoinColumn(name = "id_logros", referencedColumnName = "id_logro", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TblOpsBancoLogros tblOpsBancoLogros;
    @JoinColumn(name = "id_notas", referencedColumnName = "id_notas", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TblOpsNotas tblOpsNotas;

    public TblOpsReportes() {
    }

    public TblOpsReportes(TblOpsReportesPK tblOpsReportesPK) {
        this.tblOpsReportesPK = tblOpsReportesPK;
    }

    public TblOpsReportes(TblOpsReportesPK tblOpsReportesPK, Date fechaInforme, String observaciones) {
        this.tblOpsReportesPK = tblOpsReportesPK;
        this.fechaInforme = fechaInforme;
        this.observaciones = observaciones;
    }

    public TblOpsReportes(long idInforme, long idUsuario, long idCortes, long idNotas, long idLogros) {
        this.tblOpsReportesPK = new TblOpsReportesPK(idInforme, idUsuario, idCortes, idNotas, idLogros);
    }

    public TblOpsReportesPK getTblOpsReportesPK() {
        return tblOpsReportesPK;
    }

    public void setTblOpsReportesPK(TblOpsReportesPK tblOpsReportesPK) {
        this.tblOpsReportesPK = tblOpsReportesPK;
    }

    public Date getFechaInforme() {
        return fechaInforme;
    }

    public void setFechaInforme(Date fechaInforme) {
        this.fechaInforme = fechaInforme;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public TblOpsCortes getTblOpsCortes() {
        return tblOpsCortes;
    }

    public void setTblOpsCortes(TblOpsCortes tblOpsCortes) {
        this.tblOpsCortes = tblOpsCortes;
    }

    public TblOpsBancoLogros getTblOpsBancoLogros() {
        return tblOpsBancoLogros;
    }

    public void setTblOpsBancoLogros(TblOpsBancoLogros tblOpsBancoLogros) {
        this.tblOpsBancoLogros = tblOpsBancoLogros;
    }

    public TblOpsNotas getTblOpsNotas() {
        return tblOpsNotas;
    }

    public void setTblOpsNotas(TblOpsNotas tblOpsNotas) {
        this.tblOpsNotas = tblOpsNotas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tblOpsReportesPK != null ? tblOpsReportesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblOpsReportes)) {
            return false;
        }
        TblOpsReportes other = (TblOpsReportes) object;
        if ((this.tblOpsReportesPK == null && other.tblOpsReportesPK != null) || (this.tblOpsReportesPK != null && !this.tblOpsReportesPK.equals(other.tblOpsReportesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.opennotes.model.entities.TblOpsReportes[ tblOpsReportesPK=" + tblOpsReportesPK + " ]";
    }
    
}
