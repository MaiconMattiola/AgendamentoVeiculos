package aplicacao.modelo;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Agendamento {
    private Integer codAgend;
    private String dataIni;
    private String horaIni;
    private String dataFin;
    private String horafin;
    private Integer codMot;
    private Integer codVei;
    private Integer kmIni;
    private Integer kmFin;
    private String obs;
    private Integer status;

    public Integer getCodAgend() {
        return codAgend;
    }

    public void setCodAgend(Integer codAgend) {
        this.codAgend = codAgend;
    }

    public String getDataIni() {
        return dataIni;
    }

    public void setDataIni(String dataIni) {
        this.dataIni = dataIni;
    }

    public String getHoraIni() {
        return horaIni;
    }

    public void setHoraIni(String horaIni) {
        this.horaIni = horaIni;
    }

    public String getDataFin() {
        return dataFin;
    }

    public void setDataFin(String dataFin) {
        this.dataFin = dataFin;
    }

    public String getHorafin() {
        return horafin;
    }

    public void setHorafin(String horafin) {
        this.horafin = horafin;
    }

    public Integer getCodMot() {
        return codMot;
    }

    public void setCodMot(Integer codMot) {
        this.codMot = codMot;
    }

    public Integer getCodVei() {
        return codVei;
    }

    public void setCodVei(Integer codVei) {
        this.codVei = codVei;
    }

    public Integer getKmIni() {
        return kmIni;
    }

    public void setKmIni(Integer kmIni) {
        this.kmIni = kmIni;
    }

    public Integer getKmFin() {
        return kmFin;
    }

    public void setKmFin(Integer kmFin) {
        this.kmFin = kmFin;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
    
    
    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof Agendamento)) {
            return false;
        }
        Agendamento a = (Agendamento) obj;
        return Objects.equals(a.getCodAgend() , getCodAgend());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getCodAgend());
    }
    
}
