package aplicacao.controle;


import aplicacao.view.CadastroAgendamento;
import aplicacao.modelo.Agendamento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoActionListener implements ActionListener{
    private CadastroAgendamento frame;
    List<Agendamento> agendamentos = new ArrayList<>();
    
    public AgendamentoActionListener(CadastroAgendamento frame){
        this.frame = frame;
    } 
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        switch(ae.getActionCommand()){
            case "Fechar":
            break;
            case "Salvar":
            break;
            case "Excluir":
            break;
        }
    }
    
}
