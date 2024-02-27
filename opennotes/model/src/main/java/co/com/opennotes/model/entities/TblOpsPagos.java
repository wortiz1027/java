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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "tbl_ops_pagos", catalog = "opennotes", schema = "")
@NamedQueries({
    @NamedQuery(name = "TblOpsPagos.findAll", query = "SELECT t FROM TblOpsPagos t")
    , @NamedQuery(name = "TblOpsPagos.findByIdPago", query = "SELECT t FROM TblOpsPagos t WHERE t.idPago = :idPago")
    , @NamedQuery(name = "TblOpsPagos.findByFechaPago", query = "SELECT t FROM TblOpsPagos t WHERE t.fechaPago = :fechaPago")
    , @NamedQuery(name = "TblOpsPagos.findByValorPago", query = "SELECT t FROM TblOpsPagos t WHERE t.valorPago = :valorPago")
    , @NamedQuery(name = "TblOpsPagos.findByCodigoBarras", query = "SELECT t FROM TblOpsPagos t WHERE t.codigoBarras = :codigoBarras")
    , @NamedQuery(name = "TblOpsPagos.findByIdMatricula", query = "SELECT t FROM TblOpsPagos t WHERE t.idMatricula = :idMatricula")})
public class TblOpsPagos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pago")
    private Long idPago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_pago")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_pago")
    private long valorPago;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "codigo_barras")
    private String codigoBarras;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_matricula")
    private long idMatricula;
    @JoinColumn(name = "id_estado_pago", referencedColumnName = "id_estado_pago")
    @ManyToOne(optional = false)
    private TblOpsEstadoPago idEstadoPago;
    @JoinColumn(name = "id_estado_pago", referencedColumnName = "id_matricula")
    @ManyToOne(optional = false)
    private TblOpsMatricula idEstadoPago1;

    public TblOpsPagos() {
    }

    public TblOpsPagos(Long idPago) {
        this.idPago = idPago;
    }

    public TblOpsPagos(Long idPago, Date fechaPago, long valorPago, String codigoBarras, long idMatricula) {
        this.idPago = idPago;
        this.fechaPago = fechaPago;
        this.valorPago = valorPago;
        this.codigoBarras = codigoBarras;
        this.idMatricula = idMatricula;
    }

    public Long getIdPago() {
        return idPago;
    }

    public void setIdPago(Long idPago) {
        this.idPago = idPago;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public long getValorPago() {
        return valorPago;
    }

    public void setValorPago(long valorPago) {
        this.valorPago = valorPago;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public long getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(long idMatricula) {
        this.idMatricula = idMatricula;
    }

    public TblOpsEstadoPago getIdEstadoPago() {
        return idEstadoPago;
    }

    public void setIdEstadoPago(TblOpsEstadoPago idEstadoPago) {
        this.idEstadoPago = idEstadoPago;
    }

    public TblOpsMatricula getIdEstadoPago1() {
        return idEstadoPago1;
    }

    public void setIdEstadoPago1(TblOpsMatricula idEstadoPago1) {
        this.idEstadoPago1 = idEstadoPago1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPago != null ? idPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblOpsPagos)) {
            return false;
        }
        TblOpsPagos other = (TblOpsPagos) object;
        if ((this.idPago == null && other.idPago != null) || (this.idPago != null && !this.idPago.equals(other.idPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.opennotes.model.entities.TblOpsPagos[ idPago=" + idPago + " ]";
    }
    
}
