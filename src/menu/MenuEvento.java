package menu;

import model.Evento;

import java.util.Scanner;

public class MenuEvento {
    public static Evento createEvento() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tipo de evento:");
        System.out.println("1. Cumpleaños\n2. Almuerzo Familiar\n3. Cena Empresarial\n4. Almuerzo empresarial\n5. Cena Familiar");
        Integer tipoEvento = Integer.parseInt(scanner.nextLine());
        Evento evento = null;

        switch (tipoEvento) {
            case 1:
                System.out.println("Cumpleaños");
                System.out.println("Nombre del cumpleañero: ");
                String nombre = scanner.nextLine();
                System.out.println("Edad que cumple: ");
                Integer edad = Integer.parseInt(scanner.nextLine());
                System.out.println("Color favorito: ");
                String colorFavorito = scanner.nextLine();
                System.out.println("Modalidad de regalo: ");
                String modalidad = scanner.nextLine();
                String comida = MenuComida.selectComida("comidaNormal");
                break;
            case 2:
                System.out.println("Almuerzo Familiar");
                System.out.println("Apellido de la familia: ");
                String apellido = scanner.nextLine();

                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }

        return evento;
    }
}
