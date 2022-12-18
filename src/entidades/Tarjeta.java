package entidades;

public class Tarjeta implements tipoPago{

    private String ccvPas;
    private int mesVencPas;
    private int anioVencPas;
    private String ccvChof;

    @Override
    public double calcularPago() {
        return 0;
    }

    @Override
    public boolean confirmarPago() {
        return false;
    }
}
