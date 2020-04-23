package net.openwebinars.java9;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        // Ejemplo de métodos factoría para las colecciones

        List<String> lista = List.of("Uno", "Dos", "Tres");
        Set<Integer> conjunto = Set.of(1,2,3);
        Map<String, Integer> mapa = Map.of("Uno", 1, "Dos", 2, "Tres", 3);

        // NUEVOS MÉTODOS PARA LOS STREAMS

        // Nueva versión de "iterate", que permite indicar a través
        // de un predicado "cuándo terminar"
        System.out.println("EJEMPLO DE ITERATE");
        Stream.iterate(0, i -> i < 10, i -> i+1)
                .forEach(x -> System.out.print(x + ", "));


        // Métodos dropWhile y takeWhile
        System.out.println("\n\nEJEMPLO DE DROPWHILE");
        Stream.of(1,2,3,4,5).dropWhile(i -> i < 3).forEach(x -> System.out.print(x + " "));

        System.out.println("\nEJEMPLO DE TAKEWHILE");
        Stream.of(1,2,3,4,5).takeWhile(i -> i <= 3).forEach(x -> System.out.print(x + " "));

        // Stream con nulos
        System.out.println("\n\nEJEMPLO DE STREAM QUE PUEDE O NO TENER NULOS");
        Stream<String> s1 = Stream.ofNullable(null);
        System.out.println("Nº de elementos del stream s1: " + s1.count());

        Stream<String> s2 = Stream.of("valor");
        System.out.println("Nº de elementos del stream s2: " + s2.count());


        // Puede ser útil con flatMap

        // En este caso, se busca para ver si existe alguna de estas tres
        // variables de entorno, y a través de flatMap, se unifican los 3 streams
        // en uno solo.
        // Si no existe ninguna, se lanza una excepción.
        System.out.println("\nUSO DE OFNULLABLE CON FLATMAP");
        final String directorioDeConfiguracion =
                Stream.of("app.config", "app.home", "user.home")
                        .flatMap(key -> Stream.ofNullable(System.getProperty(key)))
                        .findFirst()
                        .orElseThrow(IllegalStateException::new);
        System.out.println(directorioDeConfiguracion);


        // NUEVOS MÉTODOS EN OPTIONAL
        System.out.println("\n\nNUEVOS MÉTODOS DE OPTIONAL");

        // ifPresentOrElse: un if-else compacto

        Optional<String> usuario = Optional.empty();
        // Optional<String> usuario = Optional.of("luismi");
        usuario.ifPresentOrElse(user -> System.out.println("El usuario logueado es " + user),
                () -> System.out.println("Para utilizar el sistema primero debe loguearse"));

        // Método or: nos permite devolver un optional si otro optional está vacío.
        System.out.println("\nEJEMPLO DE USO DE OR");
        System.out.println(usuario.or(() -> Optional.of("anonymous")).get());

        // Creación de un stream a partir de un Optional
        // Si el Optional contiene valor, devuelve un Stream con dicho valor.
        // Si no, devuelve un stream vacío
        List<Optional<Integer>> listaOptional = List.of(
                Optional.of(1), Optional.of(2), Optional.empty(), Optional.of(4), Optional.empty()
        );

        List<String> listaNumerosEnBinario =
                listaOptional.stream()
                        .flatMap(Optional::stream)
                        .map(Integer::toBinaryString)
                        .collect(Collectors.toList());

        System.out.println("\n"+listaNumerosEnBinario);


        // EJEMPLO DE USO DE UNA INTERFAZ CON MÉTODOS PRIVADOS
        System.out.println("\n\nEJEMPLO DE USO DE UNA INTERFAZ CON MÉTODOS PRIVADOS");
        MyJava9Logging logger = new MyJava9Logging();
        logger.logInfo("Mensaje de información");




    }
}
