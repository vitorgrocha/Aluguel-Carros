package trabprog2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList; //Library para Lista
import java.util.List;

public class listaClientes {
    private static List<clientes> listaC = new ArrayList<clientes>();    
    private static int count = 0;
    
    //Construtor    
    public listaClientes(clientes aCliente, boolean aFlag) throws FileNotFoundException, UnsupportedEncodingException {        
        this.listaC.add(aCliente);  
        if(!aFlag) {            
            this.printaFile(); 
            this.count++; 
            this.printaFileCount();
        }               
    }     
    
    private void printaFile() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter wr = new PrintWriter(new FileOutputStream(new File("clientes.txt"),true)); //True para concatenar        
        wr.println(this.listaC.get(this.count).getNomeCliente());     
        wr.println(this.listaC.get(this.count).getCpf());  
        wr.println(this.listaC.get(this.count).getEnderecoCliente());  
        wr.println(this.listaC.get(this.count).getTelefoneCliente());      
        wr.println(this.listaC.get(this.count).getDividaCliente());  
        wr.close();  
    }

    private void printaFileCount() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter wr = new PrintWriter(new FileOutputStream(new File("count.txt"),false)); 
        wr.println(this.count);
        wr.close(); 
    }    

    //Get Set
    public List<clientes> getListaClientes() {
        return this.listaC;
    }

    public int getCount() {
        return this.count;
    }
    
    public static void setCount(int aCount) {
        listaClientes.count = aCount;
    }

    public void setListaClientes(List<clientes> listaClientes) {
        this.listaC = listaClientes;
    }    
}