package aplicacao.controle;


import aplicacao.view.CadastroMotorista;
import aplicacao.modelo.Motorista;
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
        MotoristaDao dao = new MotoristaDao();
        Motorista m  = new Motorista();
        m = frame.getMotorista();
        
        switch(ae.getActionCommand()){
            case "Fechar":
                frame.dispose();
            break;
            case "Salvar":
                if(!dao.existis(m.getCodMot())){
                    dao.insert(m);
                } else {
                    dao.update(m);
                }
            break;
            case "Excluir":
                dao.delete(m);
            break;
        }
    }
}
