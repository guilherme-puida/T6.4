package model;

/**
 * Classe que representa um cliente.
 * @author Guilherme
 * @version 1.0
 */
public class Cliente extends Pessoa {
  private String categoria;

  /**
   * Representa um cliente.
   * @param id representa o id do cliente.
   * @param idade representa a idade do cliente.
   * @param nome representa o nome do cliente.
   * @param cpf representa o cpf do cliente.
   * @param telefone representa o telefone do cliente.
   * @param email representa o email do cliente.
   * @param endereco representa o endereço do cliente.
   * @param categoria representa a categoria do cliente.
   */
  public Cliente(int id, int idade, String nome, String cpf, String telefone, String email,
                 Endereco endereco, String categoria) {
    super(id, idade, nome, cpf, telefone, email, endereco);
    this.categoria = categoria;
  }

  /**
   * Retorna as informações basicas do cliente.
   * @return String de informações basicas do cliente.
   */
  public String infoBasica() {
    return String.format("Id: %d | Nome: %s | Telefone: %s | Categoria: %s", super.getId(),
            super.getNome(), super.getTelefone(), categoria);
  }

  /**
   * Retorna as informações completas do cliente.
   * @return String de informações completas do cliente.
   */
  public String infoCompleta() {
    return String.format("Id: %d|Idade: %d|Nome: %s|CPF: %s|Telefone: %s|Email: %s|Endereco: " +
            "%s|Categoria: %s", super.getId(), super.getIdade(), super.getNome(), super.getCpf(),
            super.getTelefone(), super.getEmail(), super.getEndereco().stringEndereco(), categoria);
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }
}
