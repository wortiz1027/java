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
@Table(name = "tbl_ops_acudiente", catalog = "opennotes", schema = "")
@NamedQueries({
    @NamedQuery(name = "TblOpsAcudiente.findAll", query = "SELECT t FROM TblOpsAcudiente t")
    , @NamedQuery(name = "TblOpsAcudiente.findByIdAcudiente", query = "SELECT t FROM TblOpsAcudiente t WHERE t.idAcudiente = :idAcudiente")
    , @NamedQuery(name = "TblOpsAcudiente.findByCodigoAcudiente", query = "SELECT t FROM TblOpsAcudiente t WHERE t.codigoAcudiente = :codigoAcudiente")
    , @NamedQuery(name = "TblOpsAcudiente.findByNombreAcudiente", query = "SELECT t FROM TblOpsAcudiente t WHERE t.nombreAcudiente = :nombreAcudiente")
    , @NamedQuery(name = "TblOpsAcudiente.findByApellidoAcudiente", query = "SELECT t FROM TblOpsAcudiente t WHERE t.apellidoAcudiente = :apellidoAcudiente")
    , @NamedQuery(name = "TblOpsAcudiente.findByTelefonoAcudiente", query = "SELECT t FROM TblOpsAcudiente t WHERE t.telefonoAcudiente = :telefonoAcudiente")})
public class TblOpsAcudiente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_acudiente")
    private Long idAcudiente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_acudiente")
    private long codigoAcudiente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_acudiente")
    private String nombreAcudiente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "apellido_acudiente")
    private String apellidoAcudiente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefono_acudiente")
    private long telefonoAcudiente;
    @OneToMany(mappedBy = "idAcudiente")
    private List<TblSecUsers> tblSecUsersList;

    public TblOpsAcudiente() {
    }

    public TblOpsAcudiente(Long idAcudiente) {
        this.idAcudiente = idAcudiente;
    }

    public TblOpsAcudiente(Long idAcudiente, long codigoAcudiente, String nombreAcudiente, String apellidoAcudiente, long telefonoAcudiente) {
        this.idAcudiente = idAcudiente;
        this.codigoAcudiente = codigoAcudiente;
        this.nombreAcudiente = nombreAcudiente;
        this.apellidoAcudiente = apellidoAcudiente;
        this.telefonoAcudiente = telefonoAcudiente;
    }

    public Long getIdAcudiente() {
        return idAcudiente;
    }

    public void setIdAcudiente(Long idAcudiente) {
        this.idAcudiente = idAcudiente;
    }

    public long getCodigoAcudiente() {
        return codigoAcudiente;
    }

    public void setCodigoAcudiente(long codigoAcudiente) {
        this.codigoAcudiente = codigoAcudiente;
    }

    public String getNombreAcudiente() {
        return nombreAcudiente;
    }

    public void setNombreAcudiente(String nombreAcudiente) {
        this.nombreAcudiente = nombreAcudiente;
    }

    public String getApellidoAcudiente() {
        return apellidoAcudiente;
    }

    public void setApellidoAcudiente(String apellidoAcudiente) {
        this.apellidoAcudiente = apellidoAcudiente;
    }

    public long getTelefonoAcudiente() {
        return telefonoAcudiente;
    }

    public void setTelefonoAcudiente(long telefonoAcudiente) {
        this.telefonoAcudiente = telefonoAcudiente;
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
        hash += (idAcudiente != null ? idAcudiente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblOpsAcudiente)) {
            return false;
        }
        TblOpsAcudiente other = (TblOpsAcudiente) object;
        if ((this.idAcudiente == null && other.idAcudiente != null) || (this.idAcudiente != null && !this.idAcudiente.equals(other.idAcudiente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.opennotes.model.entities.TblOpsAcudiente[ idAcudiente=" + idAcudiente + " ]";
    }
    
}
