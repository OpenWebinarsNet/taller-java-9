package net.openwebinars.java9.unmodulo;

import otra.ruta.de.paquetes.Alumno;

import java.util.logging.Logger;

public class UnaClaseEnUnModulo {

    private static final Logger logger = Logger.getLogger("UnaClaseEnUnModulo");

    public static void main(String[] args) {
        Alumno a = new Alumno("Luis Miguel", "López Magaña");
        logger.info(a.getNombreCompleto());
    }


}
