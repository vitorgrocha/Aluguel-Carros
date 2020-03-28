package trabprog2;

import java.time.LocalDate;

public class alugueis {
    private String alugPlaca;
    private int alugCpf;  
    private LocalDate alugDate;
    private int op;
    
    //Construtor
    public alugueis(String aAlugPlaca, int aAlugCpf, LocalDate aAlugDate, int aOp) {
        this.alugPlaca = aAlugPlaca;
        this.alugCpf = aAlugCpf;
        this.alugDate = aAlugDate;
        this.op = aOp;
    }

    //Get Set
    public String getAlugPlaca() {
        return alugPlaca;
    }

    public void setAlugPlaca(String alugPlaca) {
        this.alugPlaca = alugPlaca;
    }

    public int getAlugCpf() {
        return alugCpf;
    }

    public void setAlugCpf(int alugCpf) {
        this.alugCpf = alugCpf;
    }   

    public LocalDate getAlugDate() {
        return alugDate;
    }

    public void setAlugDate(LocalDate alugDate) {
        this.alugDate = alugDate;
    } 

    public int getOp() {
        return op;
    }

    public void setOp(int op) {
        this.op = op;
    }
    
}
