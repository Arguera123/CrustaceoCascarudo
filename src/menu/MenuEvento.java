package menu;

import model.Cumpleanios;
import model.Evento;
import model.EventoEmpresarial;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class MenuEvento {
    private static final Double PRECIO_CENA_EMPRESARIAL = 320.00;
    private static final Double PRECIO_ALMUERZO_EMPRESARIAL = 300.00;

    private static final String CODIGO_CENA_EMPRESARIAL = "ED-E-03";
    private static final String CODIGO_ALMUERZO_EMPRESARIAL = "EE-E-03";

    public static Evento createEvento(String horaReserva) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Tipo de evento:");
        System.out.println("1. Cumpleaños\n2. Almuerzo Familiar\n3. Evento Empresarial\n4. Cena Familiar");
        Integer tipoEvento = Integer.parseInt(scanner.nextLine());
        Evento evento = null;
        String comida = "";
        Double anticipo = 0.0;
        Integer cantidadPersonas = 0;

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
                System.out.println("Cantidad personas: ");
                cantidadPersonas = Integer.parseInt(scanner.nextLine());
                System.out.println("Anticipo: ");
                anticipo = Double.parseDouble(scanner.nextLine());

                comida = MenuComida.selectComida("comidaNormal");
                evento = new Cumpleanios("HBD-E-01", 380, nombre, edad, colorFavorito, cantidadPersonas, modalidad, anticipo, comida);
                break;
            case 2:
                System.out.println("Almuerzo Familiar");
                System.out.println("Apellido de la familia: ");
                String apellido = scanner.nextLine();
                comida = MenuComida.selectComida("comidaNormal");
                break;
            case 3:
                evento = createEventoEmpresarial(horaReserva);
                break;
            case 4:
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }

        return evento;
    }

    private static EventoEmpresarial createEventoEmpresarial(String horaReserva) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cena Empresarial");
        System.out.println("Anticipo: ");
        Double anticipo = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Cantidad de personas: ");
        Integer cantidadPersonas = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Comida: ");
        String comida = scanner.nextLine();

        System.out.println("Nombre de la empresa: ");
        String nombreEmpresa = scanner.nextLine();

        System.out.println("Tematica de colores: ");
        String tematicaColor = scanner.nextLine();

        System.out.println("Codigo de vestimenta: ");
        String codigoVestimenta = scanner.nextLine();

        System.out.println("Postre: ");
        String postre = scanner.nextLine();

        String codigo = "";
        Double precio = 0.0;

        if(determinarCenaAlumerzo(horaReserva).equals("ALMUERZO")) {
            codigo = CODIGO_ALMUERZO_EMPRESARIAL;
            precio = PRECIO_ALMUERZO_EMPRESARIAL;
        } else if (determinarCenaAlumerzo(horaReserva).equals("CENA")) {
            codigo = CODIGO_CENA_EMPRESARIAL;
            precio = PRECIO_CENA_EMPRESARIAL;
        }

        return new EventoEmpresarial(
                codigo, precio, anticipo, cantidadPersonas, comida, nombreEmpresa, tematicaColor,
                codigoVestimenta, postre
        );
    }

    private static String determinarCenaAlumerzo(String horaReserva) {
        Calendar calendar = Calendar.getInstance();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Date date = sdf.parse(horaReserva);
            calendar.setTime(date);
        } catch (Exception e) {
            System.out.println("Error al parsear cadena hora");
        }
        Integer hora = calendar.get(Calendar.HOUR_OF_DAY);
        if(hora >= 12 && hora <= 17) {
            return "ALMUERZO";
        }else {
            return "CENA";
        }
    }

}
