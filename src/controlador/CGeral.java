package controlador;

import br.ufsc.inf.leobr.cliente.Jogada;
import br.ufsc.inf.leobr.cliente.OuvidorProxy;
import br.ufsc.inf.leobr.cliente.Proxy;
import modelo.Dado;
import utils.Constantes;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CGeral implements OuvidorProxy {
    private Proxy proxy;
    private static CGeral ourInstance = new CGeral();
    public static GraphicsConfiguration gc;
    private CInformacoes cInformacoes;
    private CJogadores cJogadores;
    private CMenu cMenu;
    private CPista cPista;
    private CTelas cTelas;
    private Dado dado = new Dado();

    public Dado getDado() {
        return this.dado;
    }

    public void setDado(Dado dado) {
        this.dado = dado;
    }

    public static CGeral getInstance() {
        return ourInstance;
    }

    private CGeral() {
        this.cInformacoes = CInformacoes.getInstance();
        this.cJogadores = CJogadores.getInstance();
        this.cMenu = CMenu.getInstance();
        this.cPista = CPista.getInstance();
        this.cTelas = CTelas.getInstance();
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame(gc);
        frame.setTitle(Constantes.BOAS_VINDAS);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setJMenuBar(CMenu.getInstance().getMenu());
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
        frame.setLayout(new GridLayout(row, column));

        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void iniciarNovaPartida(Integer posicao) {
    }

    @Override
    public void finalizarPartidaComErro(String message) {

    }

    @Override
    public void receberMensagem(String msg) {

    }

    @Override
    public void receberJogada(Jogada jogada) {

    }

    @Override
    public void tratarConexaoPerdida() {

    }

    @Override
    public void tratarPartidaNaoIniciada(String message) {

    }
}
