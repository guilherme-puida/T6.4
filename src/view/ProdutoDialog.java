package view;

import controller.ProdutoDialogController;
import model.Loja;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class ProdutoDialog extends JDialog {
    private final ProdutoDetails details;
    private final JComboBox<String> seletor;

    public ProdutoDialog(JFrame parent) {
        super(parent, "Produto");
        setLayout(new BorderLayout());
        setModalityType(ModalityType.APPLICATION_MODAL);

        ProdutoDialogController controller = new ProdutoDialogController(this);

        String[] opcoes = {"Barra", "Chocotone", "Trufa"};
        seletor = new JComboBox<>(opcoes);
        seletor.setSelectedIndex(0);
        add(seletor, BorderLayout.BEFORE_FIRST_LINE);

        seletor.addActionListener(controller);

        details = new ProdutoDetails();
        add(details, BorderLayout.CENTER);

        details.getId().setText(
                String.valueOf(Loja.getInstance().showProximoIdChocolate())
        );
        details.getDataCompra().setText(
                LocalDate.now().toString()
        );

        details.getSubmit().addActionListener(controller);

        setMinimumSize(new Dimension(600, 400));
        pack();
        setResizable(false);
        setVisible(true);
    }

    public ProdutoDetails getDetails() {
        return details;
    }

    public JComboBox<String> getSeletor() {
        return seletor;
    }
}
