
import java.time.LocalDate;

public class Motorista {
    private Integer codMot;
    private String nome;
    private Integer CNH;
    private Integer tipoCNH;
    private LocalDate valCNH;

    public Integer getCodMot() {
        return codMot;
    }

    public void setCodMot(Integer codMot) {
        this.codMot = codMot;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCNH() {
        return CNH;
    }

    public void setCNH(Integer CNH) {
        this.CNH = CNH;
    }

    public Integer getTipoCNH() {
        return tipoCNH;
    }

    public void setTipoCNH(Integer tipoCNH) {
        this.tipoCNH = tipoCNH;
    }

    public LocalDate getValCNH() {
        return valCNH;
    }

    public void setValCNH(LocalDate valCNH) {
        this.valCNH = valCNH;
    }
}
