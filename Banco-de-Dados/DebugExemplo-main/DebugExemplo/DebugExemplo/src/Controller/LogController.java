package Controller;

import Log.Log;

import java.util.logging.Level;

public class LogController {
    public static void main(String[] args) {
        try {
            Log meuLogger = new Log("Log.txt");
            meuLogger.logger.setLevel(Level.WARNING);
            meuLogger.logger.info("Log de informação");
            meuLogger.logger.warning("Aviso o código foi executado");
            meuLogger.logger.severe("Log Severo");
            meuLogger.logger.warning("Finalizado.");


        } catch (Exception e) {


        }

    }
}
