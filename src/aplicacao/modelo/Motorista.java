package aplicacao.modelo;
import java.util.Objects;

public class Motorista {
    private Integer codMot;
    private String nome;
    private Integer CNH;
    private Integer tipoCNH;
    private String valCNH;

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

    public String getValCNH() {
        return valCNH;
    }

    public void setValCNH(String valCNH) {
        this.valCNH = valCNH;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof Motorista)) {
            return false;
        }
        Motorista m = (Motorista) obj;
        return Objects.equals(m.getCodMot(), getCodMot());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getCodMot());
    }
}
