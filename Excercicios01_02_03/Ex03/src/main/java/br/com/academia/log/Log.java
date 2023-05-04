//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package br.com.academia.log;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Log {
    public Logger logger;
    FileHandler fh;

    public Log(String nome_arquivo) throws IOException {
        File f = new File(nome_arquivo);
        if (!f.exists()) {
            f.createNewFile();
        }

        this.fh = new FileHandler(nome_arquivo, true);
        this.logger = Logger.getLogger("Teste Log");
        this.logger.addHandler(this.fh);
        SimpleFormatter formatter = new SimpleFormatter();
        this.fh.setFormatter(formatter);
    }
}
