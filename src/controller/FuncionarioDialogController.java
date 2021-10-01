package controller;

import main.Main;
import model.Endereco;
import model.Loja;
import view.FuncionarioDetails;
import view.FuncionarioDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FuncionarioDialogController implements ActionListener {
  FuncionarioDialog view;

  public FuncionarioDialogController(FuncionarioDialog view) {
    this.view = view;
  }

  @Override
  public void actionPerformed(ActionEvent e) {

    // TODO certificar que os campos não são nulos

    if (e.getSource().equals(view.getDetails().getSubmit())) {

      FuncionarioDetails details = view.getDetails();

      String idade = details.getIdade().getText();

      // Tenta converter a idade para Inteiro
      int idadeInt;
      try {
        idadeInt = Integer.parseInt(idade);
      } catch (NumberFormatException ignored) {
        // TODO não permitir que a idade seja inválida
        idadeInt = 0;
      }

      Endereco endereco = new Endereco(details.getBairro().getText(), details.getRua().getText(),
              details.getNumero().getText(), details.getCep().getText());

      double salario;
      try {
        salario = Double.parseDouble(details.getSalario().getText());
      } catch (NumberFormatException ignored) {
        salario = 0.0;
      }
      // Cadastra o funcionario
      Loja.getInstance().cadastrarFuncionario(Loja.getInstance().getProximoIdFuncionario(),
              idadeInt, details.getNome().getText(), details.getCpf().getText(),
              details.getTelefone().getText(), details.getEmail().getText(), endereco, salario,
              details.getCargo().getText());

      // Atualiza a lista de clientes que é mostrada.
      Main.getFrame().getFuncionariosTab().getListaFuncionarios().updateLista();
      Main.getFrame().getFuncionariosTab().resetListSelectionController();

      view.dispose();
    }
  }
}
