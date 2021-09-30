package view;

import model.*;

import javax.swing.*;
import java.awt.*;

public class VendaDetails extends DetailsPanel {
  private final JTextField id, valor, data;
  private final JComboBox<Cliente> cliente;
  private final JComboBox<Funcionario> funcionario;

  public VendaDetails() {
    super("Detalhes da venda:");

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

  }

}
