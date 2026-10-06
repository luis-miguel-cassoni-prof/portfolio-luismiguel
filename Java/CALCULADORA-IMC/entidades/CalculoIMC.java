package entidades;
public class CalculoIMC {
    public double calcularImc(double peso, double altura) {
        return peso / (altura * altura);
    }
}
