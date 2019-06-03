package controlador;

import br.ufsc.inf.leobr.cliente.Jogada;
import br.ufsc.inf.leobr.cliente.OuvidorProxy;
import br.ufsc.inf.leobr.cliente.Proxy;
import br.ufsc.inf.leobr.cliente.exception.ArquivoMultiplayerException;
import br.ufsc.inf.leobr.cliente.exception.JahConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoPossivelConectarException;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

public class CNetGames implements Jogada, OuvidorProxy {
    private static CNetGames ourInstance = new CNetGames();
    public final Proxy proxy = Proxy.getInstance();
    private Logger logger = Logger.getRootLogger();

    public CNetGames() {
        this.proxy.addOuvinte(this);
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
        String suxesso = null;
        try {
            this.proxy.conectar(ipServidor, nomeJogador);
            suxesso = "Conectou";
            CGeral.setIsConectado(true);
        } catch (JahConectadoException e) {
            suxesso = "Ja esta conectado";
            this.logger.log(Priority.INFO, suxesso + e.getMessage());
        } catch (NaoPossivelConectarException e) {
            suxesso = "Nao foi possivel conectar";
            this.logger.log(Priority.INFO, suxesso + e.getMessage());
        } catch (ArquivoMultiplayerException e) {
            suxesso = "Alguma exception que nao entendi";
            this.logger.log(Priority.INFO, suxesso + e.getMessage());
        }
        return suxesso;
    }
}
