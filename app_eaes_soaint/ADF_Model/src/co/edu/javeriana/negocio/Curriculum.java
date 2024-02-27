package co.edu.javeriana.negocio;

import java.io.Serializable;

import java.math.BigDecimal;

public class Curriculum implements Serializable {
    @SuppressWarnings("compatibility:-2635808137583357067")
    private static final long serialVersionUID = 1L;
    private BigDecimal codigo;
    private Candidato candidato;
    private Documento documento;
    
    public Curriculum() {
        super();
        this.candidato = new Candidato();
        this.documento = new Documento();
    }

    public void setCodigo(BigDecimal codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getCodigo() {
        return codigo;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public Documento getDocumento() {
        return documento;
    }
}
