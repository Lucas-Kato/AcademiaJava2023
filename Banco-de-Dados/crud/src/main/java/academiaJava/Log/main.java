package academiaJava.Log;

import java.util.logging.Level;

public class main {
    public static void main(String[] args)  throws InterruptedException {

        try {
            Log meuLogger = new Log("Log.txt");
            meuLogger.logger.setLevel(Level.FINE);
            //meuLogger.logger.setLevel(Level.WARNING);
            meuLogger.logger.info("Log de informação");
            meuLogger.logger.warning("Log de Aviso");
            meuLogger.logger.severe("Log Severo");


        } catch (Exception e) {


        }

    }
}