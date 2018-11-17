
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginActionListener implements ActionListener{
    private Login frame;
    List<Motorista> motorista = new ArrayList<>();
    
    public LoginActionListener(Login frame){
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch(ae.getActionCommand()){
            case "Cancelar":
                frame.dispose();
            break;
            case "Login":
                Principal princi = new Principal();
                princi.setVisible(true);
                String senha   = frame.getTxtPassword().getText().toString();
                String usuario = frame.getTxtUsuario().getText().toString();
                
                GravaLog log = new GravaLog();
                try {
                    log.escreverLog(usuario, 1);
                    log.acessoLog(frame.getTitle());
                    princi.setTitle("Agendamento de Veículos - Bem vindo(a) "+log.Ler("logado.txt")+"!!!");
                } catch (Exception ex) {
                    log.logPrintStackTrace(ex);
                }
                frame.dispose();
             
            break;
            case "Excluir":
            break;
        }
    }
}
