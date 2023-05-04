package br.com.academiaAtos.calcu;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Calculadora {
    public Calculadora() {
    }

    public float calcular(float a, float b, char operacao) {
        float resultado = 0.0F;
        switch (operacao) {
            case '*':
                resultado = a * b;
                break;
            case '+':
                resultado = a + b;
            case ',':
            case '.':
            default:
                break;
            case '-':
                if (!(a > b) && a != b) {
                    if (b > a) {
                        System.out.println("B era maior que A");
                        resultado = b - a;
                    }
                } else {
                    resultado = a - b;
                }
                break;
            case '/':
                if (b != 0.0F) {
                    resultado = a / b;
                } else {
                    System.out.println("nÃ£o podemos dividir por zero");
                }
        }

        return resultado;
    }
}
