package controller;

import model.Cliente;
import view.ClienteDetails;
import view.ClientesTab;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe controle para a tab de clientes. Implementa ActionListeners e ListSelectionListeners à tab.
 * @author Guilherme e Tiago
 * @version 1.0
 */
public class ClientesTabController implements ListSelectionListener, ActionListener {
  ClientesTab clientesTab;

  /**
   * Constroi um novo controller associado à aba de clientes.
   * @param clientesTab aba dos clientes.
   */
  public ClientesTabController(ClientesTab clientesTab) {
    this.clientesTab = clientesTab;
  }

  /**
   * Altera os detalhes para corresponder com os dados do cliente selecionado.
   * @param e evento recebido da lista de clientes.
   */
  @Override
  public void valueChanged(ListSelectionEvent e) {
    if (!e.getValueIsAdjusting()) {
      Cliente cliente = (Cliente) clientesTab.getListaClientes().getLista().getSelectedValue();
      clientesTab.getDetails().popularDados(cliente);
    }
  }

  /**
   * Altera os dados do cliente selecionado com base nos elementos do painel de detalhes.
   * @param e evento recebido.
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource().equals(clientesTab.getDetails().getSubmit())) {
      Cliente cliente = (Cliente) clientesTab.getListaClientes().getLista().getSelectedValue();

      ClienteDetails details = clientesTab.getDetails();

      int idadeInt;
      try {
        idadeInt = Integer.parseInt(details.getIdade().getText());
      } catch (NumberFormatException ignored) {
        idadeInt = 0;
      }

      cliente.setNome(details.getNome().getText());
      cliente.setCpf(details.getCpf().getText());
      cliente.setTelefone(details.getTelefone().getText());
      cliente.setIdade(idadeInt);
      cliente.setEmail(details.getEmail().getText());
      cliente.getEndereco().setBairro(details.getBairro().getText());
      cliente.getEndereco().setCep(details.getCep().getText());
      cliente.getEndereco().setRua(details.getRua().getText());
      cliente.getEndereco().setNumero(details.getNumero().getText());
      cliente.setCategoria(details.getCategoria().getText());
    }
  }
}
