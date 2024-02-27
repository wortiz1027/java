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
import javax.validation.constraints.Size;

/**
 *
 * @author PX60
 */
@Entity
@Table(name = "tbl_ops_estado_pago", catalog = "opennotes", schema = "")
@NamedQueries({
    @NamedQuery(name = "TblOpsEstadoPago.findAll", query = "SELECT t FROM TblOpsEstadoPago t")
    , @NamedQuery(name = "TblOpsEstadoPago.findByIdEstadoPago", query = "SELECT t FROM TblOpsEstadoPago t WHERE t.idEstadoPago = :idEstadoPago")
    , @NamedQuery(name = "TblOpsEstadoPago.findByEstadoPago", query = "SELECT t FROM TblOpsEstadoPago t WHERE t.estadoPago = :estadoPago")})
public class TblOpsEstadoPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado_pago")
    private Long idEstadoPago;
    @Size(max = 100)
    @Column(name = "estado_pago")
    private String estadoPago;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoPago")
    private List<TblOpsPagos> tblOpsPagosList;

    public TblOpsEstadoPago() {
    }

    public TblOpsEstadoPago(Long idEstadoPago) {
        this.idEstadoPago = idEstadoPago;
    }

    public Long getIdEstadoPago() {
        return idEstadoPago;
    }

    public void setIdEstadoPago(Long idEstadoPago) {
        this.idEstadoPago = idEstadoPago;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }

    public List<TblOpsPagos> getTblOpsPagosList() {
        return tblOpsPagosList;
    }

    public void setTblOpsPagosList(List<TblOpsPagos> tblOpsPagosList) {
        this.tblOpsPagosList = tblOpsPagosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoPago != null ? idEstadoPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblOpsEstadoPago)) {
            return false;
        }
        TblOpsEstadoPago other = (TblOpsEstadoPago) object;
        if ((this.idEstadoPago == null && other.idEstadoPago != null) || (this.idEstadoPago != null && !this.idEstadoPago.equals(other.idEstadoPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.opennotes.model.entities.TblOpsEstadoPago[ idEstadoPago=" + idEstadoPago + " ]";
    }
    
}
