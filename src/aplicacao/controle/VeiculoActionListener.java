package aplicacao.controle;


import aplicacao.exception.AgendamentoException;
import aplicacao.view.CadastroVeiculos;
import aplicacao.modelo.Veiculo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class VeiculoActionListener implements ActionListener{
    private CadastroVeiculos frame;
    List<Veiculo> veiculos = new ArrayList<>();
    
    public VeiculoActionListener(CadastroVeiculos frame){
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        VeiculoDao dao = new VeiculoDao();
        Veiculo v  = new Veiculo();
        v = frame.getVeiculo();
        
        switch(ae.getActionCommand()){
            case "Limpar":
                limpaCampos();
            break;
            case "Fechar":
                frame.dispose();
            break;
            case "Buscar":
                try {
                    if(dao.existis(v.getCodVei())){
                        Veiculo nv  = new Veiculo();
                        nv = dao.getVeiculo(v.getCodVei());
                        frame.setVeiculo(nv);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Não Há Resultados Para Sua Busca", "Atenção!!!", 0);
                    }
                } catch (AgendamentoException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage(), "Atenção!!!", 0);
                }
            break;
            case "Salvar":
                try {
                    if(!dao.existis(v.getCodVei())){
                        dao.insert(v);
                    } else {
                        dao.update(v);
                    }
                } catch (AgendamentoException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage(), "Atenção!!!", 0);
                }
            break;
            case "Excluir":
                try {
                    if(dao.existis(v.getCodVei())){
                        dao.delete(v);
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
        Veiculo v  = new Veiculo();
        
        v.setCodVei(0);
        v.setDescricao("");
        v.setPlaca("");
        v.setRenavan("");
        v.setTipo(0);
        frame.setVeiculo(v);
    }
}
