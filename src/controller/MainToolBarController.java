package controller;

import main.Main;
import model.Cliente;
import model.Funcionario;
import model.Loja;
import view.ClienteDialog;
import view.FuncionarioDialog;
import view.MainFrame;
import view.MainToolBar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainToolBarController implements ActionListener {
    Loja loja = Loja.getInstance();
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
            System.out.println("Adicionar Produto!");
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
                    Cliente r = (Cliente) frame.getClientesTab().getListaClientes().getLista().getSelectedValue();
                    Loja.getInstance().removerCliente(r);
                    frame.getClientesTab().getListaClientes().updateLista();
                    frame.getClientesTab().resetListSelectionController();
                }
                case 1 -> {
                    Funcionario r = (Funcionario) frame.getFuncionariosTab()
                            .getListaFuncionarios().getLista().getSelectedValue();
                    Loja.getInstance().removerFuncionario(r);
                    frame.getFuncionariosTab().getListaFuncionarios().updateLista();
                    frame.getFuncionariosTab().resetListSelectionController();
                }
            }
        }
    }
}
