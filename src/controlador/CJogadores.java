package controlador;

import br.ufsc.inf.leobr.cliente.Jogada;
import br.ufsc.inf.leobr.cliente.OuvidorProxy;
import br.ufsc.inf.leobr.cliente.Proxy;

public class CJogadores implements OuvidorProxy {
	private Proxy proxy;
	@Override public void iniciarNovaPartida(Integer posicao) {

	}

	@Override public void finalizarPartidaComErro(String message) {

	}

	@Override public void receberMensagem(String msg) {

	}

	@Override public void receberJogada(Jogada jogada) {

	}

	@Override public void tratarConexaoPerdida() {

	}

	@Override public void tratarPartidaNaoIniciada(String message) {

	}

	public Proxy getProxy() {
		return proxy;
	}

	public void setProxy(Proxy proxy) {
		this.proxy = proxy;
	}
}
