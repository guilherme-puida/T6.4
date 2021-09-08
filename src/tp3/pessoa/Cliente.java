package tp3.pessoa;

public class Cliente extends Pessoa{
    private String categoria;


    public Cliente(int id, int idade, String nome, String cpf, String telefone, String email,
                   Endereco endereco, String categoria) {
        super(id, idade, nome, cpf, telefone, email, endereco);
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
