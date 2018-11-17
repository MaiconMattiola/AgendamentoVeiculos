
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MotoristaActionListener implements ActionListener{
    private CadastroMotorista frame;
    List<Motorista> motorista = new ArrayList<>();
    
    public MotoristaActionListener(CadastroMotorista frame){
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
