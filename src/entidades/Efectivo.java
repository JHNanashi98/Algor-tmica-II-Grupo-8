package entidades;

public class Efectivo implements tipoPago{

    @Override
    public double calcularPago() {
        return 0;
    }

    @Override
    public boolean confirmarPago() {
        return false;
    }
}
