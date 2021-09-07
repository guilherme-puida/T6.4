package tp3.pessoa;

public class Endereco {
    private String bairro, rua, numero, cep;

    public Endereco(String bairro, String rua, String numero, String cep) {
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
    }
    public void setBairro(String bairro) { this.bairro = bairro; }

    public String getBairro() { return bairro; }

    public void setRua(String rua) { this.rua = rua; }

    public String getRua() { return rua; }

    public void setNumero(String numero) { this.numero = numero; }

    public String getNumero() { return numero; }

    public void setCep(String cep) { this.cep = cep; }

    public String getCep() { return cep; }
}
