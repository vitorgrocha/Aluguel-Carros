package trabprog2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class listaRelatorios {
    private static List<relatorios> listaRela = new ArrayList<relatorios>(); 
    private static int count = 0;
    
    //Construtor
    public listaRelatorios(relatorios aRelatorio, boolean aFlag) throws FileNotFoundException, UnsupportedEncodingException {
        this.listaRela.add(aRelatorio);
        if(!aFlag) {            
            this.printaFile(); 
            this.count++; 
            this.printaFileCount();
        }       
    }
    
    public void printaFile() throws FileNotFoundException{
        PrintWriter wr = new PrintWriter(new FileOutputStream(new File("relatorios.txt"),true)); //True para concatenar               
        wr.println(this.listaRela.get(this.count).getRelaPlaca());     
        wr.println(this.listaRela.get(this.count).getRelaCpf()); 
        wr.println(this.listaRela.get(this.count).getDataRela());
        wr.println(this.listaRela.get(this.count).getFlagDevolucao()); 
        wr.close();  
    }
    
    private void printaFileCount() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter wr = new PrintWriter(new FileOutputStream(new File("countRelatorio.txt"),false)); 
        wr.println(this.count);
        wr.close(); 
    } 

    //Get Set
    public static List<relatorios> getListaRela() {
        return listaRela;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        listaRelatorios.count = count;
    }   

    public static void setListaRela(List<relatorios> listaRela) {
        listaRelatorios.listaRela = listaRela;
    }      
}