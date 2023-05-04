//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import br.com.academiaAtos.calcu.Calculadora;
import br.com.academiaAtos.log.Log;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;

public class logTest {
    public logTest() {
    }

    public static void main(String[] args) throws IOException {
        Log meuLog = new Log("Log.txt");

        try {
            meuLog.logger.setLevel(Level.FINE);
            meuLog.logger.info("Log de informação");
            meuLog.logger.warning("Log de aviso");
            meuLog.logger.severe("Log severo");
        } catch (Exception var10) {
            meuLog.logger.info("Exception: " + var10.getMessage());
            var10.printStackTrace();
        }

        meuLog.logger.info("\n O programa iniciou a Calculadora!");
        Scanner leitura = new Scanner(System.in);

        try {
            Calculadora c = new Calculadora();
            float a = 0.0F;
            float b = 0.0F;
            float resultado = 0.0F;
            System.out.println("Calculadora");

            String operador;
            do {
                System.out.println("Insira o operador +, -, *, /");
                operador = leitura.nextLine();
            } while(!operador.contains("+") && !operador.contains("-") && !operador.contains("*") && !operador.contains("/"));

            System.out.println("Insira o 1o valor");
            a = leitura.nextFloat();
            System.out.println("Insira o 2o valor");
            b = leitura.nextFloat();
            resultado = c.calcular(a, b, operador.charAt(0));
            if (operador.contains("-") && b > a) {
                float k = a;
                a = b;
                b = k;
            }

            System.out.println("O resultado de " + a + " " + operador + " " + b + " é: " + resultado);
            System.out.printf("\n");
            meuLog.logger.info("\n O programa terminou as operações da calculadora com Resultado igual a " + resultado);
        } catch (Throwable var11) {
            try {
                leitura.close();
            } catch (Throwable var9) {
                var11.addSuppressed(var9);
            }

            throw var11;
        }

        leitura.close();
    }
}
