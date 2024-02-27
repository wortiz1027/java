package co.edu.javeriana.wcc;

public class VisorDocumentoBean implements java.io.Serializable {
    @SuppressWarnings("compatibility:3472492796741133704")
    private static final long serialVersionUID = 1L;
    public static final String URL = "http://wcc-dv1:16225/wcc/faces/wccdoc?dID=";
    private String idDocumento;
    private String urlDocumento;
    private Integer ancho;
    private Integer alto;
    
    public VisorDocumentoBean() {
        super();
    }

    public void setIdDocumento(final String idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getIdDocumento() {
        return idDocumento;
    }

    public void setUrlDocumento(final String urlDocumento) {
        this.urlDocumento = urlDocumento;
    }

    public String getUrlDocumento() {
        return urlDocumento;
    }

    public void setAncho(final Integer ancho) {
        this.ancho = ancho;
    }

    public Integer getAncho() {
        return ancho;
    }

    public void setAlto(final Integer alto) {
        this.alto = alto;
    }

    public Integer getAlto() {
        return alto;
    }
}