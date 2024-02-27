package co.edu.javeriana.configuracion.utils;

import co.edu.javeriana.configuracion.extend.BaseToString;

import java.io.Serializable;

public class RenderedFragment extends BaseToString implements Serializable{
    @SuppressWarnings("compatibility:4144782855896719203")
    private static final long serialVersionUID = 1L;
    private Boolean visible;
    private Boolean modificable;
    private Boolean mostrarDisclosure;
    private Boolean disclosed;
    private Boolean mostrarTitulo;
    private Boolean formularioExtendido;
    private Boolean habilitarHipotecario;
    private Boolean verDetalle;
    private Boolean habilitarCheck;
    public RenderedFragment() {
        super();
        this.mostrarDisclosure=Boolean.TRUE;
        this.disclosed=Boolean.FALSE;
        this.modificable=Boolean.TRUE;
        this.visible=Boolean.TRUE;
        this.mostrarTitulo=Boolean.TRUE;
        this.formularioExtendido=Boolean.FALSE;
        this.verDetalle=Boolean.FALSE;
        this.habilitarHipotecario=Boolean.FALSE;
        this.habilitarCheck = Boolean.FALSE;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setModificable(Boolean modificable) {
        this.modificable = modificable;
    }

    public Boolean getModificable() {
        return modificable;
    }

    public void setMostrarDisclosure(Boolean mostrarDisclosure) {
        this.mostrarDisclosure = mostrarDisclosure;
    }

    public Boolean getMostrarDisclosure() {
        return mostrarDisclosure;
    }

    public void setDisclosed(Boolean disclosed) {
        this.disclosed = disclosed;
    }

    public Boolean getDisclosed() {
        return disclosed;
    }

    public void setMostrarTitulo(Boolean mostrarTitulo) {
        this.mostrarTitulo = mostrarTitulo;
    }

    public Boolean getMostrarTitulo() {
        return mostrarTitulo;
    }

    public void setFormularioExtendido(Boolean formularioExtendido) {
        this.formularioExtendido = formularioExtendido;
    }

    public Boolean getFormularioExtendido() {
        return formularioExtendido;
    }

    public void setVerDetalle(Boolean verDetalle) {
        this.verDetalle = verDetalle;
    }

    public Boolean getVerDetalle() {
        return verDetalle;
    }

    public void setHabilitarHipotecario(Boolean habilitarHipotecario) {
        this.habilitarHipotecario = habilitarHipotecario;
    }

    public Boolean getHabilitarHipotecario() {
        return habilitarHipotecario;
    }

    public void setHabilitarCheck(Boolean habilitarCheck) {
        this.habilitarCheck = habilitarCheck;
    }

    public Boolean getHabilitarCheck() {
        return habilitarCheck;
    }
}
