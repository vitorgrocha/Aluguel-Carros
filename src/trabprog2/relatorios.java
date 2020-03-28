package trabprog2;

import java.time.LocalDate;

public class relatorios {       
    private String relaPlaca;
    private int relaCpf;   
    private LocalDate dataRela;
    private boolean flagDevolucao;
    
    public relatorios(String aRelaPlaca, int aRelaCpf, LocalDate aLocalDate, boolean aFlagDevolucao) {
        this.relaPlaca = aRelaPlaca;
        this.relaCpf = aRelaCpf;
        this.dataRela = aLocalDate;
        this.flagDevolucao = aFlagDevolucao;
    }

    public String getRelaPlaca() {
        return relaPlaca;
    }

    public void setRelaPlaca(String relaPlaca) {
        this.relaPlaca = relaPlaca;
    }

    public int getRelaCpf() {
        return relaCpf;
    }

    public void setRelaCpf(int relaCpf) {
        this.relaCpf = relaCpf;
    }    
    
    public LocalDate getDataRela() {
        return dataRela;
    }

    public void setDataRela(LocalDate dataRela) {
        this.dataRela = dataRela;
    }    
    public boolean getFlagDevolucao() {
        return flagDevolucao;
    }

    public void setFlagDevolucao(boolean flagDevolucao) {
        this.flagDevolucao = flagDevolucao;
    }
    
    /*public void gerarRelatorio() throws FileNotFoundException {
        PrintWriter wr = new PrintWriter(new FileOutputStream(new File("relatorio.txt"),true)); //True para concatenar           
        wr.println(this.listaC.get(this.count).getNomeCliente());  //Aqui    
        wr.println(this.listaC.get(this.count).getCpf());  //Aqui 
        wr.println(this.listaC.get(this.count).getEnderecoCliente());  //Aqui 
        wr.println(this.listaC.get(this.count).getTelefoneCliente());  //Aqui    
        wr.println(this.listaC.get(this.count).getDividaCliente());  //Aqui
        wr.close();  
    }*/    
}
