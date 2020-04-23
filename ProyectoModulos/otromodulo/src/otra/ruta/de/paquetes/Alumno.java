package otra.ruta.de.paquetes;

public class Alumno {

    String nombre;
    String apellidos;

    public Alumno(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public String getNombreCompleto() {
        return this.nombre + " " + this.apellidos;
    }

}
