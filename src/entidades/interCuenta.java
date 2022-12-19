package entidades;

import procesos.registroConfig;

public interface interCuenta {
    void actualizarDatos(registroConfig config, Cuenta c);
    Cuenta IniciarSesion(String email, String contra, registroConfig config);

    void escribePerfil(registroConfig config, Cuenta c);
    void mostrarViaje();
}
