
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Agendamento {
    private Integer codAgend;
    private LocalDate dataIni;
    private LocalTime horaIni;
    private LocalDate dataFin;
    private LocalTime horafin;
    private Integer codMot;
    private Integer codCar;
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

    public LocalDate getDataIni() {
        return dataIni;
    }

    public void setDataIni(LocalDate dataIni) {
        this.dataIni = dataIni;
    }

    public LocalTime getHoraIni() {
        return horaIni;
    }

    public void setHoraIni(LocalTime horaIni) {
        this.horaIni = horaIni;
    }

    public LocalDate getDataFin() {
        return dataFin;
    }

    public void setDataFin(LocalDate dataFin) {
        this.dataFin = dataFin;
    }

    public LocalTime getHorafin() {
        return horafin;
    }

    public void setHorafin(LocalTime horafin) {
        this.horafin = horafin;
    }

    public Integer getCodMot() {
        return codMot;
    }

    public void setCodMot(Integer codMot) {
        this.codMot = codMot;
    }

    public Integer getCodCar() {
        return codCar;
    }

    public void setCodCar(Integer codCar) {
        this.codCar = codCar;
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
