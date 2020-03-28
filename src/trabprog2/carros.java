package trabprog2;

public class carros {
    private String placa;
    private String descricao;
    private int sitiacao;
    private int km;
    private float precoKm;
    private float taxaDiaria;
    private String observacao;    
    
    //Construtor
    public carros(String aPlaca, String aDescricao, int aSituacao, int aKm, float aPrecoKm, float aTaxaDiaria, String aObservacao) {
        this.placa = aPlaca;
        this.descricao = aDescricao;
        this.sitiacao = aSituacao;
        this.km = aKm;
        this.precoKm = aPrecoKm;
        this.taxaDiaria = aTaxaDiaria;
        this.observacao = aObservacao;        
    }
    
    //Get Set
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getSitiacao() {
        return sitiacao;
    }

    public void setSitiacao(int sitiacao) {
        this.sitiacao = sitiacao;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public float getPrecoKm() {
        return precoKm;
    }

    public void setPrecoKm(int precoKm) {
        this.precoKm = precoKm;
    }

    public float getTaxaDiaria() {
        return taxaDiaria;
    }

    public void setTaxaDiaria(int taxaDiaria) {
        this.taxaDiaria = taxaDiaria;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }      
}