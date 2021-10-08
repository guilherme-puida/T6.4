package view;

import controller.MainToolBarController;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Classe que cria uma JToolBar, com os botões de adicionar cliente, funcionario, produto e venda, alem do botão de remover e o sistema de pesquisa.
 * @author Guilherme e Tiago
 * @version 1.0
 */
public class MainToolBar extends JToolBar {
  private final JButton adicionarCliente;
  private final JButton adicionarProduto;
  private final JButton adicionarFuncionario;
  private final JButton adicionarVenda;
  private final JButton remover;

  private final JTextField pesquisar;

  /**
   * Cria e adiciona todos os botões necessarios e seus ActionListeners.
   */
  public MainToolBar() {
    adicionarCliente = new JButton("Adicionar Cliente");
    adicionarProduto = new JButton("Adicionar Produto");
    adicionarFuncionario = new JButton("Adicionar Funcinario");
    adicionarVenda = new JButton("Adicionar Venda");

    remover = new JButton("Remover");

    JLabel pesquisaLabel = new JLabel("Pesquisar:");
    pesquisar = new JTextField();

    add(adicionarCliente);
    add(adicionarFuncionario);
    add(adicionarProduto);
    add(adicionarVenda);
    add(remover);
    add(pesquisaLabel);
    add(pesquisar);

    pesquisaLabel.setToolTipText("Digite e aperte ENTER para pesquisar. Limpe a caixa de pesquisa" +
            " e aperte ENTER para limpar o filtro.");

    setFloatable(false);
    ActionListener actionListener = new MainToolBarController(this);
    adicionarCliente.addActionListener(actionListener);
    adicionarProduto.addActionListener(actionListener);
    adicionarFuncionario.addActionListener(actionListener);
    adicionarVenda.addActionListener(actionListener);
    remover.addActionListener(actionListener);
    pesquisar.addActionListener(actionListener);
  }

  /**
   * Getter do botão de adicionar cliente.
   * @return JButton de adicionar cliente.
   */
  public JButton getAdicionarCliente() {
    return adicionarCliente;
  }

  /**
   * Getter do botão de adicionar produto.
   * @return JButton de adicionar produto.
   */
  public JButton getAdicionarProduto() {
    return adicionarProduto;
  }

  /**
   * Getter do botão de adicionar funcionario.
   * @return JButton de adicionar funcionario.
   */
  public JButton getAdicionarFuncionario() {
    return adicionarFuncionario;
  }

  /**
   * Getter do botão de adicionar venda.
   * @return JButton de adicionar venda.
   */
  public JButton getAdicionarVenda() {
    return adicionarVenda;
  }

  /**
   * Getter do botão de remover elemento de uma lista.
   * @return JButton de remover elemento.
   */
  public JButton getRemover() {
    return remover;
  }

  /**
   * Getter do text field do sistema de pesquisa.
   * @return JTextField do sistema de pesquisa.
   */
  public JTextField getPesquisar() {return pesquisar;}
}
//TODO sistema de remover vendas.
//TODO bug de remover um produto que ta numa venda ja criada.