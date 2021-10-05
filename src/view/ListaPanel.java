package view;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe que cria o template do painel de listagem que será usado em outras classes.
 */
public class ListaPanel extends JPanel {

  public static final int CLIENTE = 0;
  public static final int FUNCIONARIO = 1;
  public static final int CHOCOLATE = 2;
  public static final int VENDA = 3;

  private final int selection;
  private final JScrollPane listaScroller;
  private JList<?> lista;

  /**
   * Cria o JScrollPane de listagem.
   * @param selection inteiro para a seleção do objeto desejado.
   */
  public ListaPanel(int selection) {
    this.selection = selection;
    listaScroller = new JScrollPane();
    updateLista();


    listaScroller.setPreferredSize(new Dimension(200, 600));
    listaScroller.setMinimumSize(new Dimension(200, 600));

    add(listaScroller);
  }

  /**
   * Faz o update da lista, para quando são feitas mudanças.
   */
  public void updateLista() {
    switch (selection) {
      case CLIENTE -> lista = new JList<>(Loja.getInstance().getClientes());
      case FUNCIONARIO -> lista = new JList<>(Loja.getInstance().getFuncionarios());
      case CHOCOLATE -> lista =
              new JList<>(Loja.getInstance().getEstoque().getChocolates().toArray(new Chocolate[0]));
      case VENDA -> lista = new JList<>(Loja.getInstance().getVendas());
    }

    lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    lista.setLayoutOrientation(JList.VERTICAL);
    lista.setVisibleRowCount(-1);

    listaScroller.setViewportView(lista);
  }

  //TODO Javadoc desse metodo kk
  // Esse método é pura mágica.
  public void updateLista(String text) {
    switch (selection) {
      case CLIENTE -> {
        List<Cliente> clientesFiltrado = Arrays.asList(Loja.getInstance().getClientes());
        clientesFiltrado = clientesFiltrado.stream().filter(p -> p.toString().contains(text)).collect(Collectors.toList());
        lista = new JList<>(clientesFiltrado.toArray());
      }
      case FUNCIONARIO -> {
        List<Funcionario> funcionariosFiltrado = Arrays.asList(Loja.getInstance().getFuncionarios());
        funcionariosFiltrado = funcionariosFiltrado.stream().filter(p -> p.toString().contains(text)).collect(Collectors.toList());
        lista = new JList<>(funcionariosFiltrado.toArray());
      }
      case CHOCOLATE -> {
        List<Chocolate> chocolatesFiltrados =
                Arrays.asList(Loja.getInstance().getEstoque().getChocolates().toArray(new Chocolate[0]));
        chocolatesFiltrados = chocolatesFiltrados.stream().filter(p -> p.toString().contains(text)).collect(Collectors.toList());
        lista = new JList<>(chocolatesFiltrados.toArray());
      }
      case VENDA -> {
        List<Venda> vendasFiltradas = Arrays.asList(Loja.getInstance().getVendas());
        vendasFiltradas = vendasFiltradas.stream().filter(p -> p.toString().contains(text)).collect(Collectors.toList());
        lista = new JList<>(vendasFiltradas.toArray());
      }
    }

    lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    lista.setLayoutOrientation(JList.VERTICAL);
    lista.setVisibleRowCount(-1);

    listaScroller.setViewportView(lista);
  }

  /**
   * Getter da seleção do objeto requerido.
   * @return inteiro de seleção de objeto.
   */
  public int getSelection() {
    return selection;
  }

  /**
   * Getter da lista
   * @return JList do modelo de lista
   */
  public JList<?> getLista() {
    return lista;
  }

  /**
   * Getter do scroller da lista
   * @return JScrollPane do modelo de scroller de lista.
   */
  public JScrollPane getListaScroller() {
    return listaScroller;
  }
}
