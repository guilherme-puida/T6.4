package model;

public abstract class Pessoa {
  /*
   * Classe representando uma pessoa, que pode virar Cliente ou Funcionário
   */
  private int id, idade;
  private String nome, cpf, telefone, email;
  private Endereco endereco;

  public Pessoa(
      int id,
      int idade,
      String nome,
      String cpf,
      String telefone,
      String email,
      Endereco endereco) {
    this.id = id;
    this.idade = idade;
    this.nome = nome;
    this.cpf = cpf;
    this.telefone = telefone;
    this.email = email;
    this.endereco = endereco;
  }

  public abstract String infoBasica();

  public abstract String infoCompleta();

  @Override
  public String toString() {
    return String.format("%d - %s", id, nome);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getIdade() {
    return idade;
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Endereco getEndereco() {
    return endereco;
  }

  public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
  }
}
