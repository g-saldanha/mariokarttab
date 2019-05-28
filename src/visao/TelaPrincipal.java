package visao;

import controlador.CGeral;
import utils.Constantes;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class TelaPrincipal implements ITela {
    public static GraphicsConfiguration gc;


    @Override
    public void renderizar() {
        JFrame frame = new JFrame(gc);
        frame.setTitle(Constantes.BOAS_VINDAS);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(true);
        frame.setJMenuBar(this.getMenuBar());
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        try {
            String property = System.getProperty("user.dir");
            frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(property + "/src/visao/mario-kart-64.jpg")))));
        } catch (IOException e) {
            e.printStackTrace();
        }

        frame.setVisible(true);

    }

    private JMenuBar getMenuBar() {
        return CGeral.getInstance().meMandaOMenu();
    }
}
