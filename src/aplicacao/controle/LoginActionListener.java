package aplicacao.controle;


import aplicacao.utils.GravaLog;
import aplicacao.view.Login;
import aplicacao.view.Principal;
import aplicacao.modelo.Motorista;
import aplicacao.modelo.Usuario;
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
                GravaLog log = new GravaLog();
                
                Usuario u  = new Usuario();
                u = frame.getUsuario();
                
                try {
                    log.escreverLog(u.getUsuario(), 1);
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
