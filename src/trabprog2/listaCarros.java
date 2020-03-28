package trabprog2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class listaCarros {
    private static List<carros> listaC = new ArrayList<carros>();    
    private static int count = 0;
    
    //Construtor
    public listaCarros(carros aCarro, boolean aFlag) throws FileNotFoundException, UnsupportedEncodingException {
        this.listaC.add(aCarro);  
        if(!aFlag) { //False para arquivo            
            this.printaFile(); 
            this.count++; 
            this.printaFileCount();
        }    
    }
    
    private void printaFile() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter wr = new PrintWriter(new FileOutputStream(new File("carros.txt"),true)); //True para concatenar                
        wr.println(this.listaC.get(this.count).getPlaca()); 
        wr.println(this.listaC.get(this.count).getDescricao());  
        wr.println(this.listaC.get(this.count).getSitiacao());  
        wr.println(this.listaC.get(this.count).getKm());  
        wr.println(this.listaC.get(this.count).getPrecoKm());  
        wr.println(this.listaC.get(this.count).getTaxaDiaria()); 
        wr.println(this.listaC.get(this.count).getObservacao());       
        wr.close();  
    }

    private void printaFileCount() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter wr = new PrintWriter(new FileOutputStream(new File("countCarros.txt"),false)); 
        wr.println(this.count);
        wr.close(); 
    } 

    //Get Set
    public static List<carros> getListaC() {
        return listaC;
    }

    public static void setListaC(List<carros> listaC) {
        listaCarros.listaC = listaC;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        listaCarros.count = count;
    }   
}