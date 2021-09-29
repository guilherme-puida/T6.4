package view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private final MainToolBar toolBar;
    private final JTabbedPane tabs;

    public MainFrame(String title) {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        tabs = new JTabbedPane();

        tabs.add("ClientesTab", new ClientesTab());
        tabs.add("Funcionarios", new FuncionariosTab());

        toolBar = new MainToolBar();

        getContentPane().add(tabs, BorderLayout.CENTER);
        add(toolBar, BorderLayout.BEFORE_FIRST_LINE);

        setSize(1000, 600);
        setVisible(true);
        setResizable(false);
    }

}
