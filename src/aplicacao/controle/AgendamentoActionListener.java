package aplicacao.controle;


import aplicacao.exception.AgendamentoException;
import aplicacao.view.CadastroAgendamento;
import aplicacao.modelo.Agendamento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AgendamentoActionListener implements ActionListener{
    private CadastroAgendamento frame;
    List<Agendamento> agendamentos = new ArrayList<>();
    
    public AgendamentoActionListener(CadastroAgendamento frame){
        this.frame = frame;
    } 
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        AgendamentoDao dao = new AgendamentoDao();
        Agendamento a  = new Agendamento();
        a = frame.getAgendamento();
        
        switch(ae.getActionCommand()){
            case "Fechar":
                frame.dispose();
            break;
            case "Limpar":
                limpaCampos();
            break;
            case "Buscar":
                try {
                    if(dao.existis(a.getCodAgend())){
                        Agendamento nv  = new Agendamento();
                        nv = dao.getAgendamento(a.getCodAgend());
                        frame.setAgendamento(nv);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Não Há Resultados Para Sua Busca", "Atenção!!!", 0);
                    }
                } catch (AgendamentoException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage(), "Atenção!!!", 0);
                }
            break;
            case "Salvar":
                try {
                    if(!dao.existis(a.getCodAgend())){
                        dao.insert(a);
                    } else {
                        dao.update(a);
                    }
                } catch (AgendamentoException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage(), "Atenção!!!", 0);
                }
            break;
            case "Excluir":
                try {
                    if(dao.existis(a.getCodAgend())){
                        dao.delete(a);
                        limpaCampos();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Código Inexistente", "Atenção!!!", 0);
                    }
                } catch (AgendamentoException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage(), "Atenção!!!", 0);
                }
            break;
        }
    }
    
    private void limpaCampos(){
        Agendamento a  = new Agendamento();
        
        a.setCodAgend(0);
        a.setStatus(0);
        a.setDataIni("");
        a.setHoraIni("");
        a.setKmIni(0);
        a.setDataFin("");
        a.setHorafin("");
        a.setKmFin(0);
        a.setCodMot(0);
        a.setCodVei(0);
        a.setObs("");
        frame.setAgendamento(a);
    }
}
