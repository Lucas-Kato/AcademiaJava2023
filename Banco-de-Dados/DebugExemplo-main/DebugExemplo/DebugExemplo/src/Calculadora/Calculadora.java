package Calculadora;

public class Calculadora {
    public float calcular(float a, float b, char operacao) {
        float resultado = 0;
        float maior = a;
        float menor = b;

        switch (operacao) {
            case '+': {
                if (maior > menor) {
                    resultado = maior + menor;
                    break;
                } else {
                    resultado = menor + maior;
                    break;
                }
            }
            case '-': {
                if (maior > menor) {
                    resultado = maior - menor;
                    break;
                } else {
                    resultado = menor - maior;
                    break;
                }
            }
            case '/': {
                if (maior > menor) {
                    resultado = maior / menor;
                    break;
                } else {
                    resultado = menor / maior;
                    break;
                }

            }
            case '*': {
                if (maior > menor) {
                    resultado = maior * menor;
                    break;
                } else {
                    resultado = menor * maior;
                    break;
                }

            }

        }
        return resultado;

    }
}
