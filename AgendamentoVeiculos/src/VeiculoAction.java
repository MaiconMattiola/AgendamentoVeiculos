
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class VeiculoAction implements ActionListener{
    private CadastroVeiculos frame;
    
    public VeiculoAction(CadastroVeiculos frame){
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println(ae.toString());
    }
}
