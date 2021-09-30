package view;

import controller.ProdutosTabController;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class ProdutosTab extends JPanel {
        private final ListaPanel listaProdutos;

        private final ProdutoDetails details;

        public ProdutosTab() {
            setLayout(new BorderLayout());

            listaProdutos = new ListaPanel(ListaPanel.CHOCOLATE);
            add(listaProdutos, BorderLayout.LINE_START);

            details = new ProdutoDetails();
            add(details, BorderLayout.CENTER);

            listaProdutos.getLista().addListSelectionListener(new ProdutosTabController(this));

        }

        public ListaPanel getListaProdutos() {
            return listaProdutos;
        }

        public ProdutoDetails getDetails() {
            return details;
        }

        public void resetListSelectionController() {
            for (ListSelectionListener l : listaProdutos.getLista().getListSelectionListeners()) {
                listaProdutos.getLista().removeListSelectionListener(l);
            }

            listaProdutos.getLista().addListSelectionListener(new ProdutosTabController(this));
        }
}
