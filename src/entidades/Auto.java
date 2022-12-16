package entidades;

public class Auto {
    private String placa;
    private int capacidad;
    private String marca;
    public Auto(int capacidad, String marca, String placa){
        this.capacidad = capacidad;
        this.marca = marca;
        this.placa = placa;
    }
    public String getPlaca() {
        return placa;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public String getMarca() {
        return marca;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
