package aplicacao.controle;


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
            case "Fechar":
                frame.dispose();
            break;
            case "Salvar":
                if(!dao.existis(v.getCodVei())){
                    dao.insert(v);
                } else {
                    dao.update(v);
                }
            break;
            case "Excluir":
                dao.delete(v);
            break;
        }
    }
}
