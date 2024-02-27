package co.com.adf.modelo.negocio;

import java.util.ArrayList;
import java.util.List;

public class Pais implements java.io.Serializable {
    @SuppressWarnings("compatibility:5985165038323319907")
    private static final long serialVersionUID = 1L;

    private String codigo;
    private String nombre;
    private String capital;
    private String bandera;
    private String moneda;
    private List<ParNombreValor> idiomas;
    
    public Pais() {
        this.idiomas = new ArrayList<ParNombreValor>();
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getCapital() {
        return capital;
    }

    public void setBandera(String bandera) {
        this.bandera = bandera;
    }

    public String getBandera() {
        return bandera;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setIdiomas(List<ParNombreValor> idiomas) {
        this.idiomas = idiomas;
    }

    public List<ParNombreValor> getIdiomas() {
        return idiomas;
    }
}