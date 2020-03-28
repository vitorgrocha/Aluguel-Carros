package trabprog2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

public class loadFileRelatorio {
    private ArrayList<String> listaFile = new ArrayList<String>();
    private File arquivoRela = new File("relatorios.txt");
    private File arquivoCountRela = new File("countRelatorio.txt");    
    
    //Construtor
    public loadFileRelatorio() throws FileNotFoundException, UnsupportedEncodingException {       
        /**********************************************************************/
    }      
    
    public int getCountFile() throws FileNotFoundException { //Metodo pegar oque esta no arquivo countRelatorio.txt, usado como contador de relatorios cadastrados
        Scanner s = new Scanner(new File("countRelatorio.txt"));       
        if(s.hasNextInt()){           
            return s.nextInt();            
        }
        s.close();
        return 0;               
    }
    
    public boolean checkFile() throws FileNotFoundException { //Metodo checar arquivo / abrir
        if(arquivoRela.length() == 0) {
            System.out.println("Arquivo vazio! Relatorios");
            return false;
        } else {
            try {
                Scanner s = new Scanner(new File("relatorios.txt"));          
                while (s.hasNextLine()){            
                    this.listaFile.add(s.nextLine());
                }
                s.close();
                return true;
            } catch(Exception e) {
                System.out.println("File Relatorio! Erro!");
                return false;
            }
        }           
    } 
    
    //Get
    public ArrayList<String> getListaFile() { //Retorna lista que foi preenchida com o arquivo
        return this.listaFile;
    }   
}
    
