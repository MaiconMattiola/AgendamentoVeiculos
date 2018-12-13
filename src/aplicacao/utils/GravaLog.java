package aplicacao.utils;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class GravaLog {
    public void escreverLog(String texto, Integer tipo) {
        try {
            String arquivo = "";
            boolean log = false;
            switch(tipo){
                case 1:
                    arquivo = "logado.txt";
                    log = false;
                    break;
                case 2:
                    arquivo = "acesso.txt";
                    log = true;
                    break;
                case 3:
                    arquivo = "logErro.txt";
                    log = true;
                    break;
            }
            
            FileWriter fileWriter = new FileWriter(arquivo, log);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(texto);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String Ler(String arquivo) throws FileNotFoundException, IOException{
        String texto = "";
        
        FileReader fileReader = new FileReader(arquivo);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while (bufferedReader.ready()) {
            texto += bufferedReader.readLine();
        }
        bufferedReader.close();
        
        return texto;
    }
    
    public void acessoLog(String descricao) throws IOException, Exception, NullPointerException{
        String texto = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))+" - "+Ler("logado.txt")+" - "+descricao+"";
        escreverLog(texto, 2);
        //Erro Proposital para gravar no log//
        String s = null;
        System.out.println(s.toString());
        //**********************************//
    }
    
    public void logPrintStackTrace(Throwable exception) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        exception.printStackTrace(pw);
        escreverLog(sw.toString(),3);
    }
}
