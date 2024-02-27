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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "tbl_sec_users", catalog = "opennotes", schema = "")
@NamedQueries({
    @NamedQuery(name = "TblSecUsers.findAll", query = "SELECT t FROM TblSecUsers t")
    , @NamedQuery(name = "TblSecUsers.findByIdUser", query = "SELECT t FROM TblSecUsers t WHERE t.idUser = :idUser")
    , @NamedQuery(name = "TblSecUsers.findByLogin", query = "SELECT t FROM TblSecUsers t WHERE t.login = :login")
    , @NamedQuery(name = "TblSecUsers.findByPassword", query = "SELECT t FROM TblSecUsers t WHERE t.password = :password")
    , @NamedQuery(name = "TblSecUsers.findByEnable", query = "SELECT t FROM TblSecUsers t WHERE t.enable = :enable")
    , @NamedQuery(name = "TblSecUsers.findByAccountNonExpired", query = "SELECT t FROM TblSecUsers t WHERE t.accountNonExpired = :accountNonExpired")
    , @NamedQuery(name = "TblSecUsers.findByCredentialNonExpired", query = "SELECT t FROM TblSecUsers t WHERE t.credentialNonExpired = :credentialNonExpired")
    , @NamedQuery(name = "TblSecUsers.findByAccountNonLocked", query = "SELECT t FROM TblSecUsers t WHERE t.accountNonLocked = :accountNonLocked")
    , @NamedQuery(name = "TblSecUsers.findByCodigoUsuario", query = "SELECT t FROM TblSecUsers t WHERE t.codigoUsuario = :codigoUsuario")
    , @NamedQuery(name = "TblSecUsers.findByNombreUsuario", query = "SELECT t FROM TblSecUsers t WHERE t.nombreUsuario = :nombreUsuario")
    , @NamedQuery(name = "TblSecUsers.findByApellidoUsuario", query = "SELECT t FROM TblSecUsers t WHERE t.apellidoUsuario = :apellidoUsuario")
    , @NamedQuery(name = "TblSecUsers.findByDireccionUsuario", query = "SELECT t FROM TblSecUsers t WHERE t.direccionUsuario = :direccionUsuario")
    , @NamedQuery(name = "TblSecUsers.findByEdadUsuario", query = "SELECT t FROM TblSecUsers t WHERE t.edadUsuario = :edadUsuario")
    , @NamedQuery(name = "TblSecUsers.findByTelefonoUsuario", query = "SELECT t FROM TblSecUsers t WHERE t.telefonoUsuario = :telefonoUsuario")
    , @NamedQuery(name = "TblSecUsers.findByEmailUsuario", query = "SELECT t FROM TblSecUsers t WHERE t.emailUsuario = :emailUsuario")
    , @NamedQuery(name = "TblSecUsers.findBySisbenUsuario", query = "SELECT t FROM TblSecUsers t WHERE t.sisbenUsuario = :sisbenUsuario")})
public class TblSecUsers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_user")
    private Long idUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "password")
    private String password;
    @Size(max = 45)
    @Column(name = "enable")
    private String enable;
    @Size(max = 45)
    @Column(name = "account_non_expired")
    private String accountNonExpired;
    @Size(max = 45)
    @Column(name = "credential_non_expired")
    private String credentialNonExpired;
    @Size(max = 45)
    @Column(name = "account_non_locked")
    private String accountNonLocked;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_usuario")
    private long codigoUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "apellido_usuario")
    private String apellidoUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "direccion_usuario")
    private String direccionUsuario;
    @Column(name = "edad_usuario")
    private Integer edadUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefono_usuario")
    private long telefonoUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email_usuario")
    private String emailUsuario;
    @Size(max = 100)
    @Column(name = "sisben_usuario")
    private String sisbenUsuario;
    @ManyToMany(mappedBy = "tblSecUsersList")
    private List<TblSecRoles> tblSecRolesList;
    @JoinColumn(name = "id_acudiente", referencedColumnName = "id_acudiente")
    @ManyToOne
    private TblOpsAcudiente idAcudiente;
    @OneToMany(mappedBy = "idProfesor")
    private List<TblSecUsers> tblSecUsersList;
    @JoinColumn(name = "id_profesor", referencedColumnName = "id_user")
    @ManyToOne
    private TblSecUsers idProfesor;
    @JoinColumn(name = "id_eps", referencedColumnName = "id_eps")
    @ManyToOne
    private TblOpsEps idEps;
    @JoinColumn(name = "id_grupo", referencedColumnName = "id_grupo")
    @ManyToOne
    private TblOpsGrupo idGrupo;
    @JoinColumn(name = "id_sexo", referencedColumnName = "id_sexo")
    @ManyToOne(optional = false)
    private TblOpsSexo idSexo;
    @JoinColumn(name = "id_tipo_identificacion", referencedColumnName = "id_tipo_identificacion")
    @ManyToOne
    private TblOpsTipoIdentificacion idTipoIdentificacion;
    @JoinColumn(name = "id_tipo_usuario", referencedColumnName = "id_tipo_usuario")
    @ManyToOne
    private TblOpsTipoUsuario idTipoUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private List<TblOpsMatricula> tblOpsMatriculaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsers")
    private List<TblSecAuditoria> tblSecAuditoriaList;

    public TblSecUsers() {
    }

    public TblSecUsers(Long idUser) {
        this.idUser = idUser;
    }

    public TblSecUsers(Long idUser, String login, String password, long codigoUsuario, String nombreUsuario, String apellidoUsuario, String direccionUsuario, long telefonoUsuario, String emailUsuario) {
        this.idUser = idUser;
        this.login = login;
        this.password = password;
        this.codigoUsuario = codigoUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.direccionUsuario = direccionUsuario;
        this.telefonoUsuario = telefonoUsuario;
        this.emailUsuario = emailUsuario;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

    public String getAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(String accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public String getCredentialNonExpired() {
        return credentialNonExpired;
    }

    public void setCredentialNonExpired(String credentialNonExpired) {
        this.credentialNonExpired = credentialNonExpired;
    }

    public String getAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(String accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public long getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(long codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getDireccionUsuario() {
        return direccionUsuario;
    }

    public void setDireccionUsuario(String direccionUsuario) {
        this.direccionUsuario = direccionUsuario;
    }

    public Integer getEdadUsuario() {
        return edadUsuario;
    }

    public void setEdadUsuario(Integer edadUsuario) {
        this.edadUsuario = edadUsuario;
    }

    public long getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(long telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getSisbenUsuario() {
        return sisbenUsuario;
    }

    public void setSisbenUsuario(String sisbenUsuario) {
        this.sisbenUsuario = sisbenUsuario;
    }

    public List<TblSecRoles> getTblSecRolesList() {
        return tblSecRolesList;
    }

    public void setTblSecRolesList(List<TblSecRoles> tblSecRolesList) {
        this.tblSecRolesList = tblSecRolesList;
    }

    public TblOpsAcudiente getIdAcudiente() {
        return idAcudiente;
    }

    public void setIdAcudiente(TblOpsAcudiente idAcudiente) {
        this.idAcudiente = idAcudiente;
    }

    public List<TblSecUsers> getTblSecUsersList() {
        return tblSecUsersList;
    }

    public void setTblSecUsersList(List<TblSecUsers> tblSecUsersList) {
        this.tblSecUsersList = tblSecUsersList;
    }

    public TblSecUsers getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(TblSecUsers idProfesor) {
        this.idProfesor = idProfesor;
    }

    public TblOpsEps getIdEps() {
        return idEps;
    }

    public void setIdEps(TblOpsEps idEps) {
        this.idEps = idEps;
    }

    public TblOpsGrupo getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(TblOpsGrupo idGrupo) {
        this.idGrupo = idGrupo;
    }

    public TblOpsSexo getIdSexo() {
        return idSexo;
    }

    public void setIdSexo(TblOpsSexo idSexo) {
        this.idSexo = idSexo;
    }

    public TblOpsTipoIdentificacion getIdTipoIdentificacion() {
        return idTipoIdentificacion;
    }

    public void setIdTipoIdentificacion(TblOpsTipoIdentificacion idTipoIdentificacion) {
        this.idTipoIdentificacion = idTipoIdentificacion;
    }

    public TblOpsTipoUsuario getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(TblOpsTipoUsuario idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public List<TblOpsMatricula> getTblOpsMatriculaList() {
        return tblOpsMatriculaList;
    }

    public void setTblOpsMatriculaList(List<TblOpsMatricula> tblOpsMatriculaList) {
        this.tblOpsMatriculaList = tblOpsMatriculaList;
    }

    public List<TblSecAuditoria> getTblSecAuditoriaList() {
        return tblSecAuditoriaList;
    }

    public void setTblSecAuditoriaList(List<TblSecAuditoria> tblSecAuditoriaList) {
        this.tblSecAuditoriaList = tblSecAuditoriaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblSecUsers)) {
            return false;
        }
        TblSecUsers other = (TblSecUsers) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.opennotes.model.entities.TblSecUsers[ idUser=" + idUser + " ]";
    }
    
}
