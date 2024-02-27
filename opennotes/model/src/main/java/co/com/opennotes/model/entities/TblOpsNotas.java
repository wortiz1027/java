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
@Table(name = "tbl_ops_notas", catalog = "opennotes", schema = "")
@NamedQueries({
    @NamedQuery(name = "TblOpsNotas.findAll", query = "SELECT t FROM TblOpsNotas t")
    , @NamedQuery(name = "TblOpsNotas.findByIdNotas", query = "SELECT t FROM TblOpsNotas t WHERE t.idNotas = :idNotas")
    , @NamedQuery(name = "TblOpsNotas.findByQuiz1", query = "SELECT t FROM TblOpsNotas t WHERE t.quiz1 = :quiz1")
    , @NamedQuery(name = "TblOpsNotas.findByProyecto1", query = "SELECT t FROM TblOpsNotas t WHERE t.proyecto1 = :proyecto1")
    , @NamedQuery(name = "TblOpsNotas.findByMidterm", query = "SELECT t FROM TblOpsNotas t WHERE t.midterm = :midterm")
    , @NamedQuery(name = "TblOpsNotas.findByExamen1", query = "SELECT t FROM TblOpsNotas t WHERE t.examen1 = :examen1")
    , @NamedQuery(name = "TblOpsNotas.findByQuiz2", query = "SELECT t FROM TblOpsNotas t WHERE t.quiz2 = :quiz2")
    , @NamedQuery(name = "TblOpsNotas.findByProyecto2", query = "SELECT t FROM TblOpsNotas t WHERE t.proyecto2 = :proyecto2")
    , @NamedQuery(name = "TblOpsNotas.findByExamenFinal", query = "SELECT t FROM TblOpsNotas t WHERE t.examenFinal = :examenFinal")
    , @NamedQuery(name = "TblOpsNotas.findByFechaCargaNotas", query = "SELECT t FROM TblOpsNotas t WHERE t.fechaCargaNotas = :fechaCargaNotas")
    , @NamedQuery(name = "TblOpsNotas.findByIdUsuario", query = "SELECT t FROM TblOpsNotas t WHERE t.idUsuario = :idUsuario")})
public class TblOpsNotas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_notas")
    private Long idNotas;
    @Column(name = "quiz_1")
    private Long quiz1;
    @Column(name = "proyecto_1")
    private Long proyecto1;
    @Column(name = "midterm")
    private Long midterm;
    @Column(name = "examen_1")
    private Long examen1;
    @Column(name = "quiz_2")
    private Long quiz2;
    @Column(name = "proyecto_2")
    private Long proyecto2;
    @Column(name = "examen_final")
    private Long examenFinal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_carga_notas")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCargaNotas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario")
    private long idUsuario;
    @JoinColumn(name = "id_corte", referencedColumnName = "id_corte")
    @ManyToOne(optional = false)
    private TblOpsCortes idCorte;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblOpsNotas")
    private List<TblOpsReportes> tblOpsReportesList;

    public TblOpsNotas() {
    }

    public TblOpsNotas(Long idNotas) {
        this.idNotas = idNotas;
    }

    public TblOpsNotas(Long idNotas, Date fechaCargaNotas, long idUsuario) {
        this.idNotas = idNotas;
        this.fechaCargaNotas = fechaCargaNotas;
        this.idUsuario = idUsuario;
    }

    public Long getIdNotas() {
        return idNotas;
    }

    public void setIdNotas(Long idNotas) {
        this.idNotas = idNotas;
    }

    public Long getQuiz1() {
        return quiz1;
    }

    public void setQuiz1(Long quiz1) {
        this.quiz1 = quiz1;
    }

    public Long getProyecto1() {
        return proyecto1;
    }

    public void setProyecto1(Long proyecto1) {
        this.proyecto1 = proyecto1;
    }

    public Long getMidterm() {
        return midterm;
    }

    public void setMidterm(Long midterm) {
        this.midterm = midterm;
    }

    public Long getExamen1() {
        return examen1;
    }

    public void setExamen1(Long examen1) {
        this.examen1 = examen1;
    }

    public Long getQuiz2() {
        return quiz2;
    }

    public void setQuiz2(Long quiz2) {
        this.quiz2 = quiz2;
    }

    public Long getProyecto2() {
        return proyecto2;
    }

    public void setProyecto2(Long proyecto2) {
        this.proyecto2 = proyecto2;
    }

    public Long getExamenFinal() {
        return examenFinal;
    }

    public void setExamenFinal(Long examenFinal) {
        this.examenFinal = examenFinal;
    }

    public Date getFechaCargaNotas() {
        return fechaCargaNotas;
    }

    public void setFechaCargaNotas(Date fechaCargaNotas) {
        this.fechaCargaNotas = fechaCargaNotas;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public TblOpsCortes getIdCorte() {
        return idCorte;
    }

    public void setIdCorte(TblOpsCortes idCorte) {
        this.idCorte = idCorte;
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
        hash += (idNotas != null ? idNotas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblOpsNotas)) {
            return false;
        }
        TblOpsNotas other = (TblOpsNotas) object;
        if ((this.idNotas == null && other.idNotas != null) || (this.idNotas != null && !this.idNotas.equals(other.idNotas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.opennotes.model.entities.TblOpsNotas[ idNotas=" + idNotas + " ]";
    }
    
}
