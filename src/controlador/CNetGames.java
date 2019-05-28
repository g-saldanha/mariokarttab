package controlador;

import br.ufsc.inf.leobr.cliente.Jogada;
import br.ufsc.inf.leobr.cliente.OuvidorProxy;
import br.ufsc.inf.leobr.cliente.Proxy;
import br.ufsc.inf.leobr.cliente.exception.ArquivoMultiplayerException;
import br.ufsc.inf.leobr.cliente.exception.JahConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoPossivelConectarException;

public class CNetGames implements Jogada, OuvidorProxy {
    private static CNetGames ourInstance = new CNetGames();
    public Proxy proxy;

    public CNetGames() {
        this.proxy = Proxy.getInstance();
    }

    public static CNetGames getInstance() {
        return ourInstance;
    }

    @Override
    public void iniciarNovaPartida(Integer integer) {
        this.proxy.iniciarNovaPartida(integer);
    }

    @Override
    public void finalizarPartidaComErro(String s) {

    }

    @Override
    public void receberMensagem(String s) {

    }

    @Override
    public void receberJogada(Jogada jogada) {

    }

    @Override
    public void tratarConexaoPerdida() {

    }

    @Override
    public void tratarPartidaNaoIniciada(String s) {

    }

    public String conectar(String ipServidor, String nomeJogador) {
        String suxesso;
        try {
            this.proxy.conectar(ipServidor, nomeJogador);
            suxesso = "Conectou";
            CGeral.getInstance().setIsConectado(true);
        } catch (JahConectadoException e) {
            e.printStackTrace();
            suxesso = "Ja esta conectado";
        } catch (NaoPossivelConectarException e) {
            e.printStackTrace();
            suxesso = "Nao foi possivel conectar";
        } catch (ArquivoMultiplayerException e) {
            e.printStackTrace();
            suxesso = "Alguma exception que nao entendi";
        }
        return suxesso;
    }
}
