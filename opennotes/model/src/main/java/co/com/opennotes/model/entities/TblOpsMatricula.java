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

/**
 *
 * @author PX60
 */
@Entity
@Table(name = "tbl_ops_matricula", catalog = "opennotes", schema = "")
@NamedQueries({
    @NamedQuery(name = "TblOpsMatricula.findAll", query = "SELECT t FROM TblOpsMatricula t")
    , @NamedQuery(name = "TblOpsMatricula.findByIdMatricula", query = "SELECT t FROM TblOpsMatricula t WHERE t.idMatricula = :idMatricula")
    , @NamedQuery(name = "TblOpsMatricula.findByFechaMatricula", query = "SELECT t FROM TblOpsMatricula t WHERE t.fechaMatricula = :fechaMatricula")
    , @NamedQuery(name = "TblOpsMatricula.findByValorMatricula", query = "SELECT t FROM TblOpsMatricula t WHERE t.valorMatricula = :valorMatricula")
    , @NamedQuery(name = "TblOpsMatricula.findByCuotasMatricula", query = "SELECT t FROM TblOpsMatricula t WHERE t.cuotasMatricula = :cuotasMatricula")
    , @NamedQuery(name = "TblOpsMatricula.findByValorCuotas", query = "SELECT t FROM TblOpsMatricula t WHERE t.valorCuotas = :valorCuotas")})
public class TblOpsMatricula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_matricula")
    private Long idMatricula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_matricula")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaMatricula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_matricula")
    private long valorMatricula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuotas_matricula")
    private int cuotasMatricula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_cuotas")
    private long valorCuotas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoPago1")
    private List<TblOpsPagos> tblOpsPagosList;
    @JoinColumn(name = "id_periodo", referencedColumnName = "id_periodo")
    @ManyToOne(optional = false)
    private TblOpsPeriodo idPeriodo;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_user")
    @ManyToOne(optional = false)
    private TblSecUsers idUsuario;

    public TblOpsMatricula() {
    }

    public TblOpsMatricula(Long idMatricula) {
        this.idMatricula = idMatricula;
    }

    public TblOpsMatricula(Long idMatricula, Date fechaMatricula, long valorMatricula, int cuotasMatricula, long valorCuotas) {
        this.idMatricula = idMatricula;
        this.fechaMatricula = fechaMatricula;
        this.valorMatricula = valorMatricula;
        this.cuotasMatricula = cuotasMatricula;
        this.valorCuotas = valorCuotas;
    }

    public Long getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(Long idMatricula) {
        this.idMatricula = idMatricula;
    }

    public Date getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(Date fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    public long getValorMatricula() {
        return valorMatricula;
    }

    public void setValorMatricula(long valorMatricula) {
        this.valorMatricula = valorMatricula;
    }

    public int getCuotasMatricula() {
        return cuotasMatricula;
    }

    public void setCuotasMatricula(int cuotasMatricula) {
        this.cuotasMatricula = cuotasMatricula;
    }

    public long getValorCuotas() {
        return valorCuotas;
    }

    public void setValorCuotas(long valorCuotas) {
        this.valorCuotas = valorCuotas;
    }

    public List<TblOpsPagos> getTblOpsPagosList() {
        return tblOpsPagosList;
    }

    public void setTblOpsPagosList(List<TblOpsPagos> tblOpsPagosList) {
        this.tblOpsPagosList = tblOpsPagosList;
    }

    public TblOpsPeriodo getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(TblOpsPeriodo idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public TblSecUsers getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(TblSecUsers idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMatricula != null ? idMatricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblOpsMatricula)) {
            return false;
        }
        TblOpsMatricula other = (TblOpsMatricula) object;
        if ((this.idMatricula == null && other.idMatricula != null) || (this.idMatricula != null && !this.idMatricula.equals(other.idMatricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.opennotes.model.entities.TblOpsMatricula[ idMatricula=" + idMatricula + " ]";
    }
    
}
