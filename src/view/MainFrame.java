package view;

import javax.swing.*;
import java.awt.*;

/**
 * Classe MainFrame que: (1)Adiciona o MainToolBar. (2)Cria o JTabbedPane e adiciona as tabs de clientes, funcionarios, produtos e vendas nele.
 * @author Guilherme
 * @version 1.0
 */
public class MainFrame extends JFrame {
  private final MainToolBar toolBar;
  private final JTabbedPane tabs;

  private final ClientesTab clientesTab;
  private final FuncionariosTab funcionariosTab;
  private final ProdutosTab produtosTab;
  private final VendasTab vendasTab;

  /**
   * Adiciona a MainToolBar e cria o JTabbedPane, com todas as tabs necessarias.
   * @param title String do titulo, varia dependendo de qual objeto é requerido.
   */
  public MainFrame(String title) {
    super(title);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    tabs = new JTabbedPane();
    clientesTab = new ClientesTab();
    funcionariosTab = new FuncionariosTab();
    produtosTab = new ProdutosTab();
    vendasTab = new VendasTab();

    tabs.add("Clientes", clientesTab);
    tabs.add("Funcionarios", funcionariosTab);
    tabs.add("Produtos", produtosTab);
    tabs.add("Vendas", vendasTab);

    toolBar = new MainToolBar();

    getContentPane().add(tabs, BorderLayout.CENTER);
    add(toolBar, BorderLayout.BEFORE_FIRST_LINE);

    setSize(1000, 600);
    setVisible(true);
    setResizable(false);
  }

  /**
   * Getter da MainToolBar.
   * @return MainToolBar toolBar.
   */
  public MainToolBar getToolBar() {
    return toolBar;
  }

  /**
   * Getter das tabs criadas.
   * @return tabs de JTabbedPane.
   */
  public JTabbedPane getTabs() {
    return tabs;
  }

  /**
   * Getter da tab de clientes.
   * @return tab de clientes.
   */
  public ClientesTab getClientesTab() {
    return clientesTab;
  }

  /**
   * Getter da tab de funcionarios.
   * @return tab de funcionarios.
   */
  public FuncionariosTab getFuncionariosTab() {
    return funcionariosTab;
  }

  /**
   * Getter da tab de produtos.
   * @return tab de produtos.
   */
  public ProdutosTab getProdutosTab() {
    return produtosTab;
  }

  /**
   * Getter da tab de vendas.
   * @return tab de vendas
   */
  public VendasTab getVendasTab() {
    return vendasTab;
  }
}
