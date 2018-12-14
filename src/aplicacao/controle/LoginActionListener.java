package aplicacao.controle;


import aplicacao.utils.GravaLog;
import aplicacao.view.Login;
import aplicacao.view.Principal;
import aplicacao.modelo.Motorista;
import aplicacao.modelo.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

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
                System.exit(0);
            break;
            case "Login":
                UsuarioDao dao = new UsuarioDao();
                Usuario u  = new Usuario();
                u = frame.getUsuario();
                
                if(dao.existis(u)){
                    Principal princi = new Principal();
                    princi.setVisible(true);
                    GravaLog log = new GravaLog();

                    try {
                        log.escreverLog(u.getUsuario(), 1);
                        log.acessoLog(frame.getTitle());
                        princi.setTitle("Agendamento de Veículos - Bem vindo(a) "+log.Ler("logado.txt")+"!!!");
                    } catch (Exception ex) {
                        log.logPrintStackTrace(ex);
                    }
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(frame, "Usuário ou Senha Incorretos", "Atenção!!!", 0);
                }     
             
            break;
        }
    }
}
