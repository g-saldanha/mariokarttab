package visao;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import controlador.CGeral;
import controlador.CTelas;
import utils.Constantes;

public class TelaPrincipal implements ITela {
	public static GraphicsConfiguration gc;
	private JFrame frame = new JFrame(gc);
	private JPanel panel = new JPanel();

	@Override
	public void renderizar() {
		this.frame.setTitle(Constantes.BOAS_VINDAS);
		this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.frame.setResizable(true);
		this.frame.setJMenuBar(this.getMenuBar());
		this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.getBotaoAtacar().addActionListener(e -> this.getBotaoMovimentar().setEnabled(true));
		this.panel.add(this.getBotaoAtacar());
		this.panel.add(this.getBotaoMovimentar());

		try {
			String property = System.getProperty("user.dir");
			JLabel contentPane = new JLabel(new ImageIcon(ImageIO.read(new File(property + "/src/visao/mario-kart-64.jpg"))));
			contentPane.setSize(500, 300);
			this.panel.add(contentPane);
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.frame.getContentPane().add(this.panel);
		this.frame.setVisible(true);

	}

	private JButton getBotaoMovimentar() {
		return CTelas.getInstance().enviarBotaoMovimentar();
	}

	public JFrame getFrame() {
		return this.frame;
	}

	private JMenuBar getMenuBar() {
		return CGeral.getInstance().meMandaOMenu();
	}

	private JButton getBotaoAtacar() {
		return CTelas.getInstance().enviarBotaoAtaque();
	}

}
