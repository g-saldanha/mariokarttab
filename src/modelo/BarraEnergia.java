package modelo;

import java.awt.*;

import javax.swing.*;

import utils.Constantes;

public class BarraEnergia extends JProgressBar {
	public BarraEnergia() {
		super.setStringPainted(true);
		super.setValue(0);
		super.setSize(new Dimension(100, 23));
		super.setString(Constantes.BARRA_DE_ENERGIA);
	}

	public JProgressBar getBarraDeEnergia() {
		return this;
	}
}
