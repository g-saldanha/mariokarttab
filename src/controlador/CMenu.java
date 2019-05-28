package controlador;

import modelo.Menu;

import javax.swing.*;

public class CMenu {
    private static CMenu cMenu = new CMenu();
    private Menu menu;

    public static CMenu getInstance() {
        return cMenu;
    }

    private CMenu() {
        this.menu = new Menu();
        this.menu = this.colocarAcoesNoMenu();
    }

    public Menu getMenu() {
        return this.menu;
    }

    public Menu colocarAcoesNoMenu() {
        Menu menu = this.getMenu();
        JMenuItem sair = menu.getMenu().getMenu(0).getItem(3);
        sair.addActionListener(acao -> System.exit(0));
        JMenuItem conectar = menu.getMenu().getMenu(0).getItem(0);
        conectar.addActionListener(acao -> this.conectarOption());
        JMenuItem iniciar = menu.getMenu().getMenu(0).getItem(1);
        iniciar.addActionListener(acao -> this.iniciarOption());
        return menu;
    }

    private void iniciarOption() {
        CGeral.getInstance().iniciarPartida();
    }

    private void conectarOption() {
        JTextField username = new JTextField();
        JTextField conection = new JTextField();
        Object[] message = {
                "Usuario:", username,
                "Conexao:", conection
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Conectar", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            if (!username.getText().isEmpty() && !conection.getText().isEmpty()) {
                String result = CGeral.getInstance().listenerConectar(conection.getText(), username.getText());
                JOptionPane.showMessageDialog(null, result);
            }
        }

    }
}
