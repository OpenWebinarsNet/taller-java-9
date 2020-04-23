package net.openwebinars.java9;

/**
 * Ejemplo de métodos privados en una interfaz
 *
 *
 */
public interface IJava9Logging {

    default void logInfo(String mensaje) {
        log(mensaje, "INFO");
    }

    default void logError(String mensaje) {
        log(mensaje, "ERROR");
    }

    default void logFatal(String mensaje) {
        log(mensaje, "ERROR FATAL");
    }

    private void log(String mensaje, String prefijo) {
        System.out.println(prefijo.toUpperCase() + " - " + mensaje);
    }


}
