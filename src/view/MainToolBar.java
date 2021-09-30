package view;

import controller.MainToolBarController;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MainToolBar extends JToolBar {
  private final JButton adicionarCliente, // Tiago mudou de private final para public static.
      adicionarProduto,
      adicionarFuncionario,
      adicionarVenda,
      remover;

  public MainToolBar() {
    adicionarCliente = new JButton("Adicionar Cliente");
    adicionarProduto = new JButton("Adicionar Produto");
    adicionarFuncionario = new JButton("Adicionar Funcinario");
    adicionarVenda = new JButton("Adicionar Venda");

    remover = new JButton("Remover");

    add(adicionarCliente);
    add(adicionarFuncionario);
    add(adicionarProduto);
    add(adicionarVenda);
    add(remover);

    setFloatable(false);
    ActionListener actionListener = new MainToolBarController(this);
    adicionarCliente.addActionListener(actionListener);
    adicionarProduto.addActionListener(actionListener);
    adicionarFuncionario.addActionListener(actionListener);
    adicionarVenda.addActionListener(actionListener);
    remover.addActionListener(actionListener);
  }

  public JButton getAdicionarCliente() {
    return adicionarCliente;
  }

  public JButton getAdicionarProduto() {
    return adicionarProduto;
  }

  public JButton getAdicionarFuncionario() {
    return adicionarFuncionario;
  }

  public JButton getAdicionarVenda() {
    return adicionarVenda;
  }

  public JButton getRemover() {
    return remover;
  }
}
