package view;

import model.Funcionario;
import model.Pessoa;

import javax.swing.*;

/**
 * Classe de detalhes para o funcionario. Mostra todas as informações do funcionario selecionado. Usa a classe DetailsPanel como template.
 */
public class FuncionarioDetails extends PessoaDetails {

  private final JTextField salario;
  private final JTextField cargo;

  /**
   * Cria os JLabels e JTextFields dos detalhes dos funcionarios.
   */
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

  /**
   * Popula os JTextFields do metodo FuncionarioDetails() com os detalhes do funcionario requerido.
   * @param pessoa objeto da Pessoa, com os dados do funcionario.
   */
  @Override
  public void popularDados(Pessoa pessoa) {
    Funcionario funcionario = (Funcionario) pessoa;
    super.popularDados(funcionario);
    salario.setText(String.valueOf(funcionario.getSalario()));
    cargo.setText(funcionario.getCargo());
  }

  /**
   * Getter do salario do funcionario.
   * @return JTextField com o salario do funcionario.
   */
  public JTextField getSalario() {
    return salario;
  }

  /**
   * Getter do JTextField com o cargo do funcionario.
   * @return
   */
  public JTextField getCargo() {
    return cargo;
  }
}
