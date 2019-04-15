package view;

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

}
