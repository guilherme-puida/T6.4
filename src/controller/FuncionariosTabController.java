package controller;


import model.Funcionario;
import view.FuncionariosTab;


import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class FuncionariosTabController implements ListSelectionListener{
    FuncionariosTab funcionariosTab;

    public FuncionariosTabController(FuncionariosTab funcionariosTab) { this.funcionariosTab = funcionariosTab; }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            Funcionario funcionario = (Funcionario) funcionariosTab.getListaFuncionarios().getLista().getSelectedValue();
            funcionariosTab.getDetails().popularDados(funcionario);
        }
    }
}
