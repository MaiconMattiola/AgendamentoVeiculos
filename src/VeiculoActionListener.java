
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
