package view;

import javax.swing.*;

public class MainToolBar extends JToolBar {
    private final JButton adicionar, remover;


    public MainToolBar() {
        adicionar = new JButton("Adicionar");
        remover = new JButton("Remover");

        add(adicionar);
        add(remover);

        setFloatable(false);
    }

    public JButton getAdicionar() {
        return adicionar;
    }

    public JButton getRemover() {
        return remover;
    }
}
