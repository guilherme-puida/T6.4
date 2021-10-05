package view;

import model.Cliente;
import model.Pessoa;

import javax.swing.*;

/**
 * Classe de detalhes para o cliente. Mostra todas as informações do cliente selecionado. Usa a classe DetailsPanel como template.
 * @author Guilherme e Tiago
 * @version 1.0
 */
public class ClienteDetails extends PessoaDetails {
  private final JTextField categoria;
  private final JLabel labelCategoria;

  /**
   * Cria os JLabels e os JTextFields dos detalhes dos clientes.
   */
  public ClienteDetails() {
    super("Detalhes do Cliente.");

    labelCategoria = new JLabel("Categoria:");
    categoria = new JTextField();

    getInnerDetailsPanel().add(labelCategoria, getLeft());
    getInnerDetailsPanel().add(categoria, getRight());
  }

  /**
   * Popula os JTextFields do metodo ClienteDetails() com os detalhes do cliente requerido.
   * @param pessoa objeto da Pessoa, com os dados do cliente.
   */
  @Override
  public void popularDados(Pessoa pessoa) {
    Cliente cliente = (Cliente) pessoa;
    super.popularDados(cliente);

    categoria.setText(cliente.getCategoria());
  }

  /**
   * Getter da categoria do cliente.
   * @return JTextField com a categoria do cliente.
   */
  public JTextField getCategoria() {
    return categoria;
  }

  /**
   * Getter do Label da categoria do cliente.
   * @return JLabel da categoria do cliente.
   */
  public JLabel getLabelCategoria() {
    return labelCategoria;
  }
}
