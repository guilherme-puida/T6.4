package view;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

public class VendaDetails extends DetailsPanel {
  private final JTextField id, valor, data;
  private final JComboBox<Cliente> cliente;
  private final JComboBox<Funcionario> funcionario;
  private final ArrayList<JComboBox<Chocolate>> listaChocolates;
  private final ArrayList<JSpinner> listaQuantidades;


  public VendaDetails() {
    super("Detalhes da venda:");

    listaChocolates = new ArrayList<>();
    listaQuantidades = new ArrayList<>();

    GridBagConstraints left = super.getLeft();
    GridBagConstraints right = super.getRight();

    id = new JTextField();
    id.setEditable(false);
    valor = new JTextField();
    valor.setEditable(false);
    data = new JTextField();
    data.setEditable(false);

    cliente = new JComboBox<>();
    funcionario = new JComboBox<>();


    getInnerDetailsPanel().add(new JLabel("Id:"), left);
    getInnerDetailsPanel().add(id, right);
    getInnerDetailsPanel().add(new JLabel("Valor:"), left);
    getInnerDetailsPanel().add(valor, right);
    getInnerDetailsPanel().add(new JLabel("Data:"), left);
    getInnerDetailsPanel().add(data, right);
    getInnerDetailsPanel().add(new JLabel("Cliente:"), left);
    getInnerDetailsPanel().add(cliente, right);
    getInnerDetailsPanel().add(new JLabel("Funcionário:"), left);
    getInnerDetailsPanel().add(funcionario, right);


    popularDados(Loja.getInstance().getVendaPorId(1));
  }

  public void popularDados(Venda venda) {
    // Retirando as boxes e spinners antigos
    for (JComboBox<Chocolate> label : listaChocolates) {
      getInnerDetailsPanel().remove(label);
    }
    for (JSpinner spinner : listaQuantidades) {
      getInnerDetailsPanel().remove(spinner);
    }
    listaChocolates.clear();
    listaQuantidades.clear();

    // Atualizando a tela.
    getInnerDetailsPanel().validate();
    getInnerDetailsPanel().repaint();

    Loja loja = Loja.getInstance();
    cliente.setModel(new DefaultComboBoxModel<>(loja.getClientes()));
    cliente.setSelectedItem(venda.getCliente());

    funcionario.setModel(new DefaultComboBoxModel<>(loja.getFuncionarios()));
    funcionario.setSelectedItem(venda.getFuncionario());

    id.setText(String.valueOf(venda.getId()));
    valor.setText(String.valueOf(venda.getValor()));
    data.setText(venda.getData().toString());

    // Adicionando os produtos
    for (Map.Entry<Chocolate, Integer> entry : venda.getChocolateVendidos().entrySet()) {
      Chocolate chocolate = entry.getKey();
      int quantidade = entry.getValue();

      int maxQuantidade = Loja.getInstance().getEstoque().getQuantidadeEmEstoque(chocolate);


      listaQuantidades.add(new JSpinner(new SpinnerNumberModel(quantidade, quantidade,
              maxQuantidade, 1)));

      DefaultComboBoxModel<Chocolate> model =
              new DefaultComboBoxModel<>(loja.getEstoque().getChocolates().toArray(new Chocolate[0]));

      JComboBox<Chocolate> opcoes = new JComboBox<>(model);
      opcoes.setSelectedItem(chocolate);

      listaChocolates.add(opcoes);
    }

    for (int i = 0; i < listaQuantidades.size(); i++) {
      getInnerDetailsPanel().add(listaChocolates.get(i), getLeft());
      getInnerDetailsPanel().add(listaQuantidades.get(i), getRight());
    }
  }

  public JTextField getId() {
    return id;
  }

  public JTextField getValor() {
    return valor;
  }

  public JTextField getData() {
    return data;
  }

  public JComboBox<Cliente> getCliente() {
    return cliente;
  }

  public JComboBox<Funcionario> getFuncionario() {
    return funcionario;
  }

  public ArrayList<JComboBox<Chocolate>> getListaChocolates() {
    return listaChocolates;
  }

  public ArrayList<JSpinner> getListaQuantidades() {
    return listaQuantidades;
  }
}
