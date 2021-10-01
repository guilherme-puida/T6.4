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
  private final ArrayList<JLabel> listaLabels;
  private final ArrayList<JSpinner> listaProdutos;


  public VendaDetails() {
    super("Detalhes da venda:");

    listaLabels = new ArrayList<>();
    listaProdutos = new ArrayList<>();

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
    // Retirando os labels e spinners antigos
    for (JLabel label : listaLabels) {
      getInnerDetailsPanel().remove(label);
    }
    for (JSpinner spinner : listaProdutos) {
      getInnerDetailsPanel().remove(spinner);
    }
    listaLabels.clear();
    listaProdutos.clear();

    // Atualizando a tela.
    getInnerDetailsPanel().validate();
    getInnerDetailsPanel().repaint();

    Loja loja = Loja.getInstance();
    cliente.setModel(new DefaultComboBoxModel<>(
            loja.getClientes()
    ));

    funcionario.setModel(new DefaultComboBoxModel<>(
            loja.getFuncionarios()
    ));

    id.setText(String.valueOf(venda.getId()));
    valor.setText(String.valueOf(venda.getValor()));
    data.setText(venda.getData().toString());

    // Adicionando os produtos
    for (Map.Entry<Chocolate, Integer> entry : venda.getChocolateVendidos().entrySet()) {
      Chocolate chocolate = entry.getKey();
      int quantidade = entry.getValue();

      int maxQuantidade = Loja.getInstance().getEstoque().getQuantidadeEmEstoque(chocolate);


      listaProdutos.add(new JSpinner( new SpinnerNumberModel(
              quantidade,
              quantidade,
              maxQuantidade,
              1
              )
      ));

      listaLabels.add(new JLabel(chocolate.getNome() + " :"));
    }

    for (int i = 0; i < listaProdutos.size(); i++) {
      getInnerDetailsPanel().add(listaLabels.get(i), getLeft());
      getInnerDetailsPanel().add(listaProdutos.get(i), getRight());
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

  public ArrayList<JLabel> getListaLabels() {
    return listaLabels;
  }

  public ArrayList<JSpinner> getListaProdutos() {
    return listaProdutos;
  }
}
