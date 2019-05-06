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
        this.menu = this.colocarAcoesNoMenu();
    }

    public Menu getMenu() {
        return this.menu;
    }

    public Menu colocarAcoesNoMenu() {
        Menu menu = this.getMenu();
        JMenuItem sair = menu.getMenu().getMenu(0).getItem(3);
        sair.addActionListener(acao -> System.exit(0));
        return menu;
    }
}
