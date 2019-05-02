package modelo;

import java.awt.*;

import javax.swing.*;

public class BarraEnergia extends JProgressBar {
	public BarraEnergia() {
		super.setStringPainted(true);
		super.setValue(0);
		super.setSize(new Dimension(100, 23));
	}
	public final SwingWorker w = new SwingWorker() {
		@Override
		protected Object doInBackground() throws Exception {
			for (int i = 1; i <= 100; i++) {
				try {
					super.setValue(i);
					super.setString(i + "%");
					Thread.sleep(20);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}
			return 0;
		}
	};

	});
}
}
