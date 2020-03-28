package trabprog2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class listaAlugueis {
    private static List<alugueis> listaC = new ArrayList<>();    
    private static int count = 0;    
    
    //Construtor
    public listaAlugueis(alugueis aAluguel, boolean aFlag) throws FileNotFoundException, UnsupportedEncodingException {
        this.listaC.add(aAluguel);  
        if(!aFlag) { //False para arquivo            
            this.printaFile(); 
            this.count++; 
            this.printaFileCount();
        }
    }
    
    private void printaFile() throws FileNotFoundException, UnsupportedEncodingException {        
        PrintWriter wr = new PrintWriter(new FileOutputStream(new File("alugueis.txt"), true)); //True para concatenar                
        wr.println(this.listaC.get(this.count).getAlugPlaca()); 
        wr.println(this.listaC.get(this.count).getAlugCpf());  
        wr.println(this.listaC.get(this.count).getAlugDate());
        wr.println(this.listaC.get(this.count).getOp());
        wr.close();  
    }

    private void printaFileCount() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter wr = new PrintWriter(new FileOutputStream(new File("countAlugueis.txt"),false)); 
        wr.println(this.count);
        wr.close(); 
    } 

    //Get Set
    public static List<alugueis> getListaC() {
        return listaC;
    }

    public static void setListaC(List<alugueis> listaC) {
        listaAlugueis.listaC = listaC;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        listaAlugueis.count = count;
    }   
    
}
