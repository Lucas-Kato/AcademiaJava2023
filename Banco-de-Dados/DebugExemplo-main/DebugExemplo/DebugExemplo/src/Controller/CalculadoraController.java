package Controller;

import Calculadora.Calculadora;

import java.util.Scanner;

public class CalculadoraController {

    public static void main(String[] args) {
        try (Scanner leitura = new Scanner(System.in)) {
            Calculadora c = new Calculadora();
            float a = 0, b = 0, resultado = 0;
            String operador;
            System.out.println("Calculadora");
            do {
                System.out.println("Insira o operador +, -, *, /");
                operador = leitura.nextLine();
            } while (!(operador.contains("+") || operador.contains("-") || operador.contains("*")
                    || operador.contains("/")));

            System.out.println("Insira o 1o valor");
            a = leitura.nextFloat();
            System.out.println("Insira o 2o valor");
            b = leitura.nextFloat();

            resultado = c.calcular(a, b, operador.charAt(0));
            System.out.println("O resultado de " + a + " " + operador + " " + b + " é:" + resultado);
        }

    }

}
