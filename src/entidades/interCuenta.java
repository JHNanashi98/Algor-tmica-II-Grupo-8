package entidades;

import procesos.registroConfig;

public interface interCuenta {
    void actualizarDatos(registroConfig config, Cuenta c);
    Cuenta IniciarSesion(String email, String contra, registroConfig config);
}
