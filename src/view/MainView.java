package view;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MainView {
	static GraphicsConfiguration gc;
	public static void main(String[] args){
		Artefacts artefacts = new Artefacts();
		JFrame frame= new JFrame(gc);
		frame.setTitle("Bem vindo ao Mario kart Tab");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setJMenuBar(getMenubar());
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		try {
			frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("/home/gabriel/IdeaProjects/Mario Kart Tab/src/view/mario-kart-64.jpg")))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		frame.add(artefacts.ataque());
		frame.pack();
		frame.setVisible(true);
	}

	public static JMenuBar getMenubar(){
		// Cria uma barra de menu para o JFrame
		JMenuBar menuBar = new JMenuBar();

		// Define e adiciona dois menus drop down na barra de menus
		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");
		menuBar.add(fileMenu);
		menuBar.add(editMenu);

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
