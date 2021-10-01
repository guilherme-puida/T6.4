package controller;

import main.Main;
import model.Chocolate;
import model.Cliente;
import model.Funcionario;
import model.Loja;
import view.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainToolBarController implements ActionListener {
  MainToolBar bar;
  JFrame parent;

  public MainToolBarController(MainToolBar bar) {
    this.bar = bar;
    parent = (JFrame) SwingUtilities.getWindowAncestor(bar);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == bar.getAdicionarCliente()) {
      new ClienteDialog(parent);
    } else if (e.getSource() == bar.getAdicionarProduto()) {
      new ProdutoDialog(parent);
    } else if (e.getSource() == bar.getAdicionarFuncionario()) {
      new FuncionarioDialog(parent);
    } else if (e.getSource() == bar.getAdicionarVenda()) {
      System.out.println("Adicionar Venda!");
    } else if (e.getSource() == bar.getRemover()) {

      MainFrame frame = Main.getFrame();
      JTabbedPane tabs = frame.getTabs();

      switch (tabs.getSelectedIndex()) {
        // TODO outras abas
        case 0 -> {
          Cliente r =
                  (Cliente) frame.getClientesTab().getListaClientes().getLista().getSelectedValue();
          Loja.getInstance().removerCliente(r);
          frame.getClientesTab().getListaClientes().updateLista();
          frame.getClientesTab().resetListSelectionController();
        }
        case 1 -> {
          Funcionario r =
                  (Funcionario) frame.getFuncionariosTab().getListaFuncionarios().getLista().getSelectedValue();
          Loja.getInstance().removerFuncionario(r);
          frame.getFuncionariosTab().getListaFuncionarios().updateLista();
          frame.getFuncionariosTab().resetListSelectionController();
        }
        case 2 -> {
          Chocolate r =
                  (Chocolate) frame.getProdutosTab().getListaProdutos().getLista().getSelectedValue();
          Loja.getInstance().getEstoque().removerChocolate(r);
          frame.getProdutosTab().getListaProdutos().updateLista();
          frame.getProdutosTab().resetListSelectionController();
        }
      }
    } else if (e.getSource() == bar.getPesquisar()) {
      System.out.println("Pesquisa!");
    }
  }
}
