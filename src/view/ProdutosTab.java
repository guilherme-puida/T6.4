package view;

import javax.swing.*;
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

        }

        public ListaPanel getListaProdutos() {
            return listaProdutos;
        }

        public ProdutoDetails getDetails() {
            return details;
        }
}
