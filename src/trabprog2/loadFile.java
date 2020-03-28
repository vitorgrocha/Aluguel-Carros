package trabprog2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

public class loadFile {
    private ArrayList<String> listaFile = new ArrayList<String>();
    private File arquivo = new File("clientes.txt");
    private File arquivoC = new File("count.txt");    
    
    //Construtor
    public loadFile() throws FileNotFoundException, UnsupportedEncodingException {       
        /**********************************************************************/
    }     
    
    public int getCountFile() throws FileNotFoundException { //Metodo para pegar oque esta no arquivo count.txt, usado como contador de clientes cadastrados
        Scanner s = new Scanner(new File("count.txt"));       
        if(s.hasNextInt()){           
            return s.nextInt();            
        }
        s.close();
        return 0;               
    }
    
    public boolean checkFile() throws FileNotFoundException { //Metodo checar arquivo / abrir
        if(arquivo.length() == 0) {
            System.out.println("Arquivo vazio! Clientes");
            return false;
        } else {
            try {
                Scanner s = new Scanner(new File("clientes.txt"));          
                while (s.hasNextLine()){            
                    this.listaFile.add(s.nextLine());
                }
                s.close();
                return true;
            } catch(Exception e) {
                System.out.println("File Clientes! Erro!");
                return false;
            }
        }           
    }
    //Get
    public ArrayList<String> getListaFile() { //Retorna lista que foi preenchida com o arquivo
        return this.listaFile;
    }
}
    
