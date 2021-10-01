package view;

import model.Funcionario;
import model.Pessoa;

import javax.swing.*;

public class FuncionarioDetails extends PessoaDetails {

  private final JTextField salario;
  private final JTextField cargo;

  public FuncionarioDetails() {
    super("Detalhes do funcionário.");

    JLabel labelSalario = new JLabel("Salário");
    JLabel labelCargo = new JLabel("Cargo:");

    salario = new JTextField();
    salario.setToolTipText("Double.");
    cargo = new JTextField();

    getInnerDetailsPanel().add(labelSalario, getLeft());
    getInnerDetailsPanel().add(salario, getRight());
    getInnerDetailsPanel().add(labelCargo, getLeft());
    getInnerDetailsPanel().add(cargo, getRight());
  }

  @Override
  public void popularDados(Pessoa pessoa) {
    Funcionario funcionario = (Funcionario) pessoa;
    super.popularDados(funcionario);
    salario.setText(String.valueOf(funcionario.getSalario()));
    cargo.setText(funcionario.getCargo());
  }

  public JTextField getSalario() {
    return salario;
  }

  public JTextField getCargo() {
    return cargo;
  }
}
