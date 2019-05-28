package controlador;

import visao.*;

import javax.swing.*;
import java.util.HashMap;

public class CTelas {
    private static final String TELA_PRINCIPAL = "TELA_PRINCIPAL";
    private static final String TELA_JOGADORES = "TELA_JOGADORES";
    private static final String TELA_MODAL = "TELA MODAL";
    private static final String TELA_PREMIACAO = "TELA_PREMIACAO";
    private static CTelas cTelas = new CTelas();
    private HashMap<String, ITela> telas;

    public static CTelas getInstance() {
        return cTelas;
    }

    private CTelas() {
        this.telas = new HashMap<>();
        this.telas.put(CTelas.TELA_PRINCIPAL, new TelaPrincipal());
        this.telas.put(CTelas.TELA_JOGADORES, new TelaEscolherJogadores());
        this.telas.put(CTelas.TELA_MODAL, new TelaModal());
        this.telas.put(CTelas.TELA_PREMIACAO, new TelaPremiacao());
    }

    public void pintarTela() {
        this.telas.get(CTelas.TELA_PRINCIPAL).renderizar();
    }

    public void notifica(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}
