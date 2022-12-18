package entidades;

public class Yape implements tipoPago{

    private String celPas;
    private String celChof;

    @Override
    public double calcularPago() {
        return 0;
    }

    @Override
    public boolean confirmarPago() {
        return false;
    }
}
