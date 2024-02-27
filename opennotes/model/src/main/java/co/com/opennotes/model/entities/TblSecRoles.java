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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author PX60
 */
@Entity
@Table(name = "tbl_sec_roles", catalog = "opennotes", schema = "")
@NamedQueries({
    @NamedQuery(name = "TblSecRoles.findAll", query = "SELECT t FROM TblSecRoles t")
    , @NamedQuery(name = "TblSecRoles.findByIdRole", query = "SELECT t FROM TblSecRoles t WHERE t.idRole = :idRole")
    , @NamedQuery(name = "TblSecRoles.findByRole", query = "SELECT t FROM TblSecRoles t WHERE t.role = :role")})
public class TblSecRoles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_role")
    private Long idRole;
    @Size(max = 50)
    @Column(name = "role")
    private String role;
    @JoinTable(name = "tbl_sec_user_roles", joinColumns = {
        @JoinColumn(name = "role_id", referencedColumnName = "id_role")}, inverseJoinColumns = {
        @JoinColumn(name = "user_id", referencedColumnName = "id_user")})
    @ManyToMany
    private List<TblSecUsers> tblSecUsersList;

    public TblSecRoles() {
    }

    public TblSecRoles(Long idRole) {
        this.idRole = idRole;
    }

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
        hash += (idRole != null ? idRole.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblSecRoles)) {
            return false;
        }
        TblSecRoles other = (TblSecRoles) object;
        if ((this.idRole == null && other.idRole != null) || (this.idRole != null && !this.idRole.equals(other.idRole))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.opennotes.model.entities.TblSecRoles[ idRole=" + idRole + " ]";
    }
    
}
