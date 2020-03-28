package trabprog2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

public class loadFileCar {
    private ArrayList<String> listaFile = new ArrayList<String>();
    private File arquivoCarro = new File("carros.txt");
    private File arquivoCountCarro = new File("countCarros.txt");    
    
    //Construtor
    public loadFileCar() throws FileNotFoundException, UnsupportedEncodingException {       
        /**********************************************************************/
    } 
    
    public int getCountFile() throws FileNotFoundException { //Metodo pegar oque esta no arquivo countCarros.txt, usado como contador de carros cadastrados
        Scanner s = new Scanner(new File("countCarros.txt"));       
        if(s.hasNextInt()){           
            return s.nextInt();            
        }
        s.close();
        return 0;               
    }
    
    public boolean checkFile() throws FileNotFoundException { //Metodo checar arquivo / abrir
        if(arquivoCarro.length() == 0) {
            System.out.println("Arquivo vazio! Carros");
            return false;
        } else {
            try {
                Scanner s = new Scanner(new File("carros.txt"));          
                while (s.hasNextLine()){            
                    this.listaFile.add(s.nextLine());
                }
                s.close();
                return true;
            } catch(Exception e) {
                System.out.println("File Carros! Erro!");
                return false;
            }
        }           
    }
    //Get
    public ArrayList<String> getListaFile() { //Retorna lista que foi preenchida com o arquivo
        return this.listaFile;
    }  
}
    
