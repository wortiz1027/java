package co.edu.javeriana.wcc;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

public class Documento implements Serializable {
    @SuppressWarnings("compatibility:8167328740546934800")
    private static final long serialVersionUID = 1L;

    private int dID;
    private String revision;
    private String dDocName;
    private String nombreOriginal;
    private String titulo;
    private String tipo;
    private String autor;
    private String grupoSeguridad;
    private String cuenta;
    private String extension;
    private String extensionWeb;
    private String fechaCreacion;
    private String formato;
    private String url;
    private List<NameValue> customDocMetaData;
    private ArchivoPrimario archivoPrimario;
    
    public Documento() {
        this.customDocMetaData = new ArrayList<>();
        this.archivoPrimario = new ArchivoPrimario();
    }

    public void setDID(int dID) {
        this.dID = dID;
    }

    public int getDID() {
        return dID;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public String getRevision() {
        return revision;
    }

    public void setDDocName(String dDocName) {
        this.dDocName = dDocName;
    }

    public String getDDocName() {
        return dDocName;
    }

    public void setNombreOriginal(String nombreOriginal) {
        this.nombreOriginal = nombreOriginal;
    }

    public String getNombreOriginal() {
        return nombreOriginal;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    public void setGrupoSeguridad(String grupoSeguridad) {
        this.grupoSeguridad = grupoSeguridad;
    }

    public String getGrupoSeguridad() {
        return grupoSeguridad;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtensionWeb(String extensionWeb) {
        this.extensionWeb = extensionWeb;
    }

    public String getExtensionWeb() {
        return extensionWeb;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getFormato() {
        return formato;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setCustomDocMetaData(List<NameValue> customDocMetaData) {
        this.customDocMetaData = customDocMetaData;
    }

    public List<NameValue> getCustomDocMetaData() {
        return customDocMetaData;
    }

    public void setArchivoPrimario(ArchivoPrimario archivoPrimario) {
        this.archivoPrimario = archivoPrimario;
    }

    public ArchivoPrimario getArchivoPrimario() {
        return archivoPrimario;
    }

}
