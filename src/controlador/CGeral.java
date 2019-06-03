package controlador;

import javax.swing.*;

import modelo.Dado;
import utils.Constantes;

public class CGeral {

	private static CGeral ourInstance = new CGeral();
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
		if (!isConectado) {
			CTelas.getInstance().notifica(Constantes.VOCE_JA_ESTA_CONECTADO);
		} else {
			CNetGames.getInstance().iniciarNovaPartida(2);
			CTelas.getInstance().notifica(Constantes.PARIDA_INICIADA);
		}
	}
}
