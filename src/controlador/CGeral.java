package controlador;

import javax.swing.*;

import modelo.Dado;
import utils.Constantes;

public class CGeral {

	private static CGeral ourInstance = new CGeral();
	private CInformacoes cInformacoes;
	private CJogadores cJogadores;
	private CMenu cMenu;
	private CPista cPista;
	private CTelas cTelas;
	private Dado dado = new Dado();

	public static void setIsConectado(boolean isConectado) {
		CGeral.isConectado = isConectado;
	}

	private static boolean isConectado = false;

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
		CTelas.getInstance().pintarTela();
	}

	public JMenuBar meMandaOMenu() {
		return CMenu.getInstance().getMenu();
	}

	public String listenerConectar(String ipServidor, String nomeJogador) {
		return CNetGames.getInstance().conectar(ipServidor, nomeJogador);
	}

	public void iniciarPartida() {
		if (isConectado) {
			this.cTelas.notifica(Constantes.VOCE_JA_ESTA_CONECTADO);
		} else {
			CNetGames.getInstance().iniciarNovaPartida(0);
			this.cTelas.notifica(Constantes.PARIDA_INICIADA);
		}
	}
}
