package controller;

import main.Main;
import model.*;
import view.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * Classe controller da MainToolBar. Implementa ActionListeners à MainToolBar.
 * @author Guilherme e Tiago
 * @version 1.0
 */
public class MainToolBarController implements ActionListener {
  protected MainToolBar bar;
  protected JFrame parent;

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
      new VendaDialog(parent);
    } else if (e.getSource() == bar.getRemover()) {

      MainFrame frame = Main.getFrame();
      JTabbedPane tabs = frame.getTabs();

      switch (tabs.getSelectedIndex()) {
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
          Loja.getInstance().removerChocolate(r);
          frame.getProdutosTab().getListaProdutos().updateLista();
          frame.getProdutosTab().resetListSelectionController();
        }
      }
      Venda v = (Venda) frame.getVendasTab().getListaVendas().getLista().getSelectedValue();

      // Teste para ver se ainda existe alguma lista na venda.
      if (v != null) {
        frame.getVendasTab().getDetails().popularDados(v);
      } else {
        // Caso não exista, deixar a tela de editar detalhes da venda desativada até outra venda
        // for adicionada.
        frame.getVendasTab().getDetails().popularDados();
      }
      frame.getVendasTab().getListaVendas().updateLista();

    } else if (e.getSource() == bar.getPesquisar()) {
      MainFrame frame = Main.getFrame();
      if (bar.getPesquisar().getText().equals("")) {
        frame.getClientesTab().getListaClientes().updateLista();
        frame.getFuncionariosTab().getListaFuncionarios().updateLista();
        frame.getProdutosTab().getListaProdutos().updateLista();
        frame.getVendasTab().getListaVendas().updateLista();
      } else {
        String text = bar.getPesquisar().getText();
        frame.getClientesTab().getListaClientes().updateLista(text);
        frame.getFuncionariosTab().getListaFuncionarios().updateLista(text);
        frame.getProdutosTab().getListaProdutos().updateLista(text);
        frame.getVendasTab().getListaVendas().updateLista(text);
        }
      }
      }
    }



