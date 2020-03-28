package trabprog2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

public class loadFileAluguel {
    private ArrayList<String> listaFile = new ArrayList<String>();
    private File arquivo = new File("alugueis.txt");
    private File arquivoC = new File("countAlugueis.txt");
    
    //Construtor
    public loadFileAluguel() {
        /***************************************/
    }
    
    public int getCountFile() throws FileNotFoundException { //Metodo para pegar oque esta no arquivo countAlugueis.txt, usado como contador de alugueis
        Scanner s = new Scanner(new File("countAlugueis.txt"));       
        if(s.hasNextInt()){           
            return s.nextInt();            
        }
        s.close();
        return 0;               
    }
    
    public boolean checkFile() throws FileNotFoundException { //Metodo checar arquivo / abrir
        if(arquivo.length() == 0) {
            System.out.println("Arquivo vazio! Alugueis");
            return false;
        } else {
            try {
                Scanner s = new Scanner(new File("alugueis.txt"));          
                while (s.hasNextLine()){            
                    this.listaFile.add(s.nextLine());
                }
                s.close();
                return true;
            } catch(Exception e) {
                System.out.println("File Alugueis! Erro!");
                return false;
            }
        }           
    }

    //Get
    public ArrayList<String> getListaFile() {
        return listaFile;
    }   
}
