package menu;

import constants.IniciandoConstantes;
import model.Comida;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class MenuComida {
    public static String selectComida(String tipoEvento) {
        Scanner scanner = new Scanner(System.in);
        List<Comida> menuComidas = IniciandoConstantes.llenarConstanteComida();

        menuComidas.stream().forEach(comida -> {
            if(tipoEvento.equals(comida.getTipo())) {
                System.out.println(comida.getId() + ". " + comida.getNombre() + ": " + comida.getDescripcion());
            }
        });

        System.out.println("Digite el id de la comida que quiere seleccionar: ");
        Integer idComida = Integer.parseInt(scanner.nextLine());

        switch(tipoEvento) {
            case "comidaNormal":
                while (idComida < 0 || idComida > 4) {
                    System.out.println("Digite el id de la comida: ");
                    idComida = Integer.parseInt(scanner.nextLine());
                }
                break;
            case "bebidaNormal":
                while (idComida < 5 || idComida > 8) {
                    System.out.println("Digite el id de la comida: ");
                    idComida = Integer.parseInt(scanner.nextLine());
                }
                break;
            case "comidaEmpresarial":
                while (idComida < 9 || idComida > 12) {
                    System.out.println("Digite el id de la comida: ");
                    idComida = Integer.parseInt(scanner.nextLine());
                }
                break;
            case "comidaPelicula":
                while (idComida < 13 || idComida > 16) {
                    System.out.println("Digite el id de la comida: ");
                    idComida = Integer.parseInt(scanner.nextLine());
                }
                break;
        }

        while (idComida < 0 || idComida > menuComidas.size()) {
            System.out.println("Digite el id de la comida: ");
        }

        String finalIdComida = idComida.toString();
        Optional<Comida> comida = menuComidas.stream()
                .filter(c -> c.getId().equals(finalIdComida)).findFirst();

        return comida.orElse(null).getNombre();
    }
}
