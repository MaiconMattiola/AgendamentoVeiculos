package aplicacao.controle;


import aplicacao.exception.AgendamentoException;
import aplicacao.view.CadastroMotorista;
import aplicacao.modelo.Motorista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MotoristaActionListener implements ActionListener{
    private CadastroMotorista frame;
    List<Motorista> motorista = new ArrayList<>();
    
    public MotoristaActionListener(CadastroMotorista frame){
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        MotoristaDao dao = new MotoristaDao();
        Motorista m  = new Motorista();
        m = frame.getMotorista();
        
        switch(ae.getActionCommand()){
            case "Fechar":
                frame.dispose();
            break;
            case "Limpar":
                limpaCampos();
            break;
            case "Buscar":
                try {
                    if(dao.existis(m.getCodMot())){
                        Motorista nv  = new Motorista();
                        nv = dao.getMotorista(m.getCodMot());
                        frame.setMotorista(nv);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Não Há Resultados Para Sua Busca", "Atenção!!!", 0);
                    }
                } catch (AgendamentoException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage(), "Atenção!!!", 0);
                }
            break;
            case "Salvar":
                try {
                    if(!dao.existis(m.getCodMot())){
                        dao.insert(m);
                    } else {
                        dao.update(m);
                    }
                } catch (AgendamentoException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage(), "Atenção!!!", 0);
                }
            break;
            case "Excluir":
                try {
                    if(dao.existis(m.getCodMot())){
                        dao.delete(m);
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
        Motorista m  = new Motorista();
        
        m.setCodMot(0);
        m.setNome("");
        m.setTipoCNH(0);
        m.setCNH(0);
        m.setValCNH("");
        frame.setMotorista(m);
    }
}
