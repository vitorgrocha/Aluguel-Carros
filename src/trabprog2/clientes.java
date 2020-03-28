package trabprog2;

public class clientes {
    private String nomeCliente;
    private int cpf;
    private String enderecoCliente;
    private int telefoneCliente;
    private float dividaCliente;
    
    //Construtor
    public clientes(String aNomeClient, int aCpf, String aEnderecoCliente, int aTelefoneCliente, float aDividaCliente) {
        this.nomeCliente = aNomeClient;
        this.cpf = aCpf;
        this.enderecoCliente = aEnderecoCliente;
        this.telefoneCliente = aTelefoneCliente;
        this.dividaCliente = aDividaCliente;
    }   
    
    //Metodos Get e Set
    public int getCpf() {
        return this.cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }    
    
    public String getNomeCliente() {
        return this.nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEnderecoCliente() {
        return this.enderecoCliente;
    }

    public void setEnderecoCliente(String enderecoCliente) {
        this.enderecoCliente = enderecoCliente;
    }

    public int getTelefoneCliente() {
        return this.telefoneCliente;
    }

    public void setTelefoneCliente(int telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public float getDividaCliente() {
        return this.dividaCliente;
    }

    public void setDividaCliente(float dividaCliente) {
        this.dividaCliente = dividaCliente;
    } 
}