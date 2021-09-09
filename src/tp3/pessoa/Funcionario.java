package tp3.pessoa;

public class Funcionario extends Pessoa{
    private double salario;
    private String cargo;

    public Funcionario(int id, int idade, String nome, String cpf, String telefone, String email,
                       Endereco endereco, double salario, String cargo) {
        super(id, idade, nome, cpf, telefone, email, endereco);
        this.salario = salario;
        this.cargo = cargo;
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
