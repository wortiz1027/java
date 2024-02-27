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
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author PX60
 */
@Embeddable
public class TblOpsReportesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_informe")
    private long idInforme;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario")
    private long idUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cortes")
    private long idCortes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_notas")
    private long idNotas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_logros")
    private long idLogros;

    public TblOpsReportesPK() {
    }

    public TblOpsReportesPK(long idInforme, long idUsuario, long idCortes, long idNotas, long idLogros) {
        this.idInforme = idInforme;
        this.idUsuario = idUsuario;
        this.idCortes = idCortes;
        this.idNotas = idNotas;
        this.idLogros = idLogros;
    }

    public long getIdInforme() {
        return idInforme;
    }

    public void setIdInforme(long idInforme) {
        this.idInforme = idInforme;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public long getIdCortes() {
        return idCortes;
    }

    public void setIdCortes(long idCortes) {
        this.idCortes = idCortes;
    }

    public long getIdNotas() {
        return idNotas;
    }

    public void setIdNotas(long idNotas) {
        this.idNotas = idNotas;
    }

    public long getIdLogros() {
        return idLogros;
    }

    public void setIdLogros(long idLogros) {
        this.idLogros = idLogros;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idInforme;
        hash += (int) idUsuario;
        hash += (int) idCortes;
        hash += (int) idNotas;
        hash += (int) idLogros;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblOpsReportesPK)) {
            return false;
        }
        TblOpsReportesPK other = (TblOpsReportesPK) object;
        if (this.idInforme != other.idInforme) {
            return false;
        }
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        if (this.idCortes != other.idCortes) {
            return false;
        }
        if (this.idNotas != other.idNotas) {
            return false;
        }
        if (this.idLogros != other.idLogros) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.opennotes.model.entities.TblOpsReportesPK[ idInforme=" + idInforme + ", idUsuario=" + idUsuario + ", idCortes=" + idCortes + ", idNotas=" + idNotas + ", idLogros=" + idLogros + " ]";
    }
    
}
