package controlador;

import visao.*;

import java.util.ArrayList;
import java.util.List;

public class CTelas {
    private static CTelas cTelas = new CTelas();
    private List<ITela> telas;

    public static CTelas getInstance() {
        return cTelas;
    }

    private CTelas() {
        this.telas = new ArrayList<>();
        this.telas.add(new TelaPrincipal());
        this.telas.add(new TelaEscolherJogadores());
        this.telas.add(new TelaModal());
        this.telas.add(new TelaPremiacao());
    }

    public void pintarTela() {

    }
}
