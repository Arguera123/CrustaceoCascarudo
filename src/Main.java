import menu.Reservas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Reservas reservas = new Reservas();
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("Bienvenido al Crustaceo Cascarudo\nQue desea hacer?");
            System.out.println("1. Agregar nueva reserva\n2. Mostrar reservas pendientes\n3. Mostrar reservas terminadas\n0. Salir");
            System.out.print("Ingrese una opcion: ");
            Integer opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Agregar nueva reserva");
                    reservas.agregarReserva();
                    break;
                case 2:
                    System.out.println("Mostrar reservas pendientes");
                    break;
                case 3:
                    System.out.println("Mostrar resevas terminadas");
                    break;
                case 0:
                    System.out.println("Saliendo del programa");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opcion no valida");
            }
        }

    }
}