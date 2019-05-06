package modelo;

import java.awt.*;

import javax.swing.*;

public class BarraEnergia extends JProgressBar {
	public BarraEnergia() {
		super.setStringPainted(true);
		super.setValue(0);
		super.setSize(new Dimension(100, 23));
		super.setString("Barra de energia");
	}

	public JProgressBar getBarraDeEnergia(){
		return this;
	}
}
