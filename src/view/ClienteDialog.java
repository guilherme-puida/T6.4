package view;

import controller.ClienteDialogController;
import model.Loja;

import javax.swing.*;
import java.awt.*;

public class ClienteDialog extends JDialog{
    private final ClienteDetails details;
    private final JFrame parent;

    public ClienteDialog(JFrame parent) {
        super(parent, "Cliente");
        this.parent = parent;
        setModalityType(ModalityType.APPLICATION_MODAL);

        details = new ClienteDetails();
        add(details);

        details.getId().setText(
                String.valueOf(Loja.getInstance().showProximoIdCliente())
        );

        details.getSubmit().addActionListener(new ClienteDialogController(this));


        setMinimumSize(new Dimension(600, 200));
        pack();
        setResizable(false);
        setVisible(true);
    }

    public ClienteDetails getDetails() {
        return details;
    }
}
