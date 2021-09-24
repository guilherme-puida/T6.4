package model;

public class Funcionario extends Pessoa{
    private double salario;
    private String cargo;

    public Funcionario(int id, int idade, String nome, String cpf, String telefone, String email,
                       Endereco endereco, double salario, String cargo) {
        super(id, idade, nome, cpf, telefone, email, endereco);
        this.salario = salario;
        this.cargo = cargo;
    }

    public String infoBasica() {
        return String.format("Id: %d | Nome: %s | Salário: %.2f | Cargo: %s",
                super.getId(), super.getNome(), salario, cargo);
    }

    public String infoCompleta() {
        return String.format(
                "Id: %d|Idade: %d|Nome: %s|CPF:%s|Telefone:%s|Email:%s|Endereco:%s|Salario:%.2f|Cargo:%s",
                super.getId(), super.getIdade(), super.getNome(), super.getCpf(), super.getTelefone(), super.getEmail(),
                super.getEndereco().stringEndereco(), salario, cargo
        );
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
