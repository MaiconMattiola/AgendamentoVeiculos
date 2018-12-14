package aplicacao.modelo;


import java.util.Objects;

public class Veiculo {
    private Integer codVei;
    private String descricao;
    private String placa;
    private String renavan;
    private Integer tipo;

    public Integer getCodVei() {
        return codVei;
    }

    public void setCodVei(Integer codVei) {
        this.codVei = codVei;
    }

    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getRenavan() {
        return renavan;
    }

    public void setRenavan(String renavan) {
        this.renavan = renavan;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }
    
    public String getTipoDesc() {
        String descricao = "";
        switch(this.tipo){
            case 1:
                descricao = "Carro";
            break;
            case 2:
                descricao = "Utilitário";
            break;
            case 3:
                descricao = "Caminhão";
            break;
            case 4:
                descricao = "Cavalo Mecânico";
            break;
         }
        return descricao;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof Veiculo)) {
            return false;
        }
        Veiculo v = (Veiculo) obj;
        return Objects.equals(v.getCodVei(), getCodVei());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getCodVei());
    }
}
