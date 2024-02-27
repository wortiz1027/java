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
@Table(name = "tbl_ops_banco_logros", catalog = "opennotes", schema = "")
@NamedQueries({
    @NamedQuery(name = "TblOpsBancoLogros.findAll", query = "SELECT t FROM TblOpsBancoLogros t")
    , @NamedQuery(name = "TblOpsBancoLogros.findByIdLogro", query = "SELECT t FROM TblOpsBancoLogros t WHERE t.idLogro = :idLogro")
    , @NamedQuery(name = "TblOpsBancoLogros.findByCodigoLogro", query = "SELECT t FROM TblOpsBancoLogros t WHERE t.codigoLogro = :codigoLogro")
    , @NamedQuery(name = "TblOpsBancoLogros.findByDescripcionLogro", query = "SELECT t FROM TblOpsBancoLogros t WHERE t.descripcionLogro = :descripcionLogro")})
public class TblOpsBancoLogros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_logro")
    private Long idLogro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "codigo_logro")
    private String codigoLogro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "descripcion_logro")
    private String descripcionLogro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblOpsBancoLogros")
    private List<TblOpsReportes> tblOpsReportesList;

    public TblOpsBancoLogros() {
    }

    public TblOpsBancoLogros(Long idLogro) {
        this.idLogro = idLogro;
    }

    public TblOpsBancoLogros(Long idLogro, String codigoLogro, String descripcionLogro) {
        this.idLogro = idLogro;
        this.codigoLogro = codigoLogro;
        this.descripcionLogro = descripcionLogro;
    }

    public Long getIdLogro() {
        return idLogro;
    }

    public void setIdLogro(Long idLogro) {
        this.idLogro = idLogro;
    }

    public String getCodigoLogro() {
        return codigoLogro;
    }

    public void setCodigoLogro(String codigoLogro) {
        this.codigoLogro = codigoLogro;
    }

    public String getDescripcionLogro() {
        return descripcionLogro;
    }

    public void setDescripcionLogro(String descripcionLogro) {
        this.descripcionLogro = descripcionLogro;
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
        hash += (idLogro != null ? idLogro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblOpsBancoLogros)) {
            return false;
        }
        TblOpsBancoLogros other = (TblOpsBancoLogros) object;
        if ((this.idLogro == null && other.idLogro != null) || (this.idLogro != null && !this.idLogro.equals(other.idLogro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.opennotes.model.entities.TblOpsBancoLogros[ idLogro=" + idLogro + " ]";
    }
    
}
