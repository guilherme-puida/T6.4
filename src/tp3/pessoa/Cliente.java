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

    public String infoBasica() {
        return String.format("Id: %d | Nome: %s | Telefone: %s | Categoria: %s",
                super.getId(), super.getNome(), super.getTelefone(), categoria);
    }

    public String infoCompleta() {
        return String.format(
                "Id: %d|Idade: %d|Nome: %s|CPF: %s|Telefone: %s|Email: %s|Endereco: %s|Categoria: %s",
        super.getId(), super.getIdade(), super.getNome(), super.getCpf(), super.getTelefone(), super.getEmail(),
                super.getEndereco().stringEndereco(), categoria);
    }
}
