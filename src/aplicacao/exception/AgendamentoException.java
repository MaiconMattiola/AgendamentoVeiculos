package aplicacao.exception;

public class AgendamentoException extends Exception{
    public AgendamentoException(){
        super("Ouve Um Erro Na Aplicação");
    }
    
    public  AgendamentoException(String msg){
        super(msg);
    }
}
