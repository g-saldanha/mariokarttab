package view;

import java.awt.*;

import javax.swing.*;

public class Artefacts {

	public JButton ataque(){
		JButton atacar = new JButton("Ataque");
		atacar.setSize(350,80);
		atacar.setVisible(true);
		atacar.addActionListener(
				e -> JOptionPane.showMessageDialog(null, "Este botão fará o ataque do personagem")
		);
		return atacar;
	}

	public JProgressBar energia(){
		JProgressBar nrg = new JProgressBar(0, 100);
		nrg.setSize(350, 80);
		nrg.setValue(20);
		nrg.setString("Barra de energia");
		nrg.setVisible(true);

		return nrg;
	}

	public JButton movimentar(){
		JButton move = new JButton("Movimentar-se");
		move.setSize(350, 80);
		move.setVisible(true);
		move.addActionListener(
				e -> JOptionPane.showMessageDialog(null, "Este botão será a movimentação do personagem")
		);
		return move;
	}

}
