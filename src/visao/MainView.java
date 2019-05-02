package visao;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class MainView {
	private static Artifacts artifacts = new Artifacts();
	static GraphicsConfiguration gc;
	public static void main(String[] args){

		JFrame frame= new JFrame(gc);
		frame.setTitle("Bem vindo ao Mario kart Tab");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setJMenuBar(getMenubar());
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		try {
			frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("/home/gabriel/IdeaProjects/Mario Kart Tab/src/visao/mario-kart-64.jpg")))));
		} catch (IOException e) {
			e.printStackTrace();
		}

		int row = 20;
		int column = 10;
		JPanel[][] panelHolder = new JPanel[row][column];
		frame.setLayout(new GridLayout(row,column));

		criarPista(panelHolder, frame);
		addBotoes(panelHolder);
		criarPanelDeInfo(panelHolder);

		frame.pack();
		frame.setVisible(true);
	}

	private static void criarPanelDeInfo(JPanel[][] panelHolder) {
		panelHolder[0][8].add(artifacts.info());
		panelHolder[1][7].add(artifacts.turno());
		panelHolder[2][7].add(artifacts.jogador());
		panelHolder[14][5].add(artifacts.pista());
	}

	private static void criarPista(JPanel[][] panelHolder, JFrame frame) {
		int row = 20;
		int column = 10;
		for(int m = 0; m < 15; m++) {
			for(int n = 0; n < column; n++) {
				panelHolder[m][n] = new JPanel();
				frame.add(panelHolder[m][n]);
			}
		}

		for(int m = 15; m < 20; m++) {
			for(int n = 0; n < 10; n++) {
				JPanel jPanel = new JPanel();
				jPanel.setBackground(Color.GRAY);
				jPanel.setBorder(new LineBorder(Color.WHITE));
				panelHolder[m][n] = jPanel;
				frame.add(panelHolder[m][n]);
			}
		}
	}

	private static void addBotoes(JPanel[][] panelHolder) {
		panelHolder[0][0].add(artifacts.ataque());
		panelHolder[0][1].add(artifacts.movimentar());
		panelHolder[0][2].add(new JLabel("Energia ->"));
		panelHolder[0][3].add(artifacts.energia());
	}

	public static JMenuBar getMenubar(){
		// Cria uma barra de menu para o JFrame
		JMenuBar menuBar = new JMenuBar();

		// Define e adiciona dois menus drop down na barra de menus
		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");
		JMenuItem exit = new JMenu("Exit");

		exit.addActionListener(e -> System.exit(0));
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(exit);

		// Cria e adiciona um item simples para o menu
		JMenuItem newAction = new JMenuItem("New");
		JMenuItem openAction = new JMenuItem("Open");
		JMenuItem exitAction = new JMenuItem("Exit");
		JMenuItem cutAction = new JMenuItem("Cut");
		JMenuItem copyAction = new JMenuItem("Copy");
		JMenuItem pasteAction = new JMenuItem("Paste");

		// Cria e aiciona um CheckButton como um item de menu
		JCheckBoxMenuItem checkAction = new JCheckBoxMenuItem("Check Action");
		// Cria e aiciona um RadioButton como um item de menu
		JRadioButtonMenuItem radioAction1 = new JRadioButtonMenuItem(
				"Radio Button1");
		JRadioButtonMenuItem radioAction2 = new JRadioButtonMenuItem(
				"Radio Button2");
		// Cria um ButtonGroup e adiciona os dois radio Button
		ButtonGroup bg = new ButtonGroup();
		bg.add(radioAction1);
		bg.add(radioAction2);
		fileMenu.add(newAction);
		fileMenu.add(openAction);
		fileMenu.add(checkAction);
		fileMenu.addSeparator();
		fileMenu.add(exitAction);
		editMenu.add(cutAction);
		editMenu.add(copyAction);
		editMenu.add(pasteAction);
		return menuBar;
	}

}
