package menu;

import model.Cumpleanios;
import model.Evento;
import model.EventoEmpresarial;
import model.EventoFamiliar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class MenuEvento {
    private static final Double PRECIO_CENA_EMPRESARIAL = 320.00;
    private static final Double PRECIO_ALMUERZO_EMPRESARIAL = 300.00;
    private static final Double PRECIO_CENA_FAMILIAR = 200.00;
    private static final Double PRECIO_ALMUERZO_FAMILIAR = 180.00;

    private static final String CODIGO_CENA_EMPRESARIAL = "ED-E-03";
    private static final String CODIGO_ALMUERZO_EMPRESARIAL = "EE-E-03";
    private static final String CODIGO_ALMUERZO_FAMILIAR = "EE-E-02";
    private static final String CODIGO_CENA_FAMILIAR = "FD-E-04";

    public static Evento createEvento(String horaReserva) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Tipo de evento:");
        System.out.println("1. Cumpleaños\n2. Evento Familiar\n3. Evento Empresarial");
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
                evento = createEventoFamiliar(horaReserva);
                break;
            case 3:
                evento = createEventoEmpresarial(horaReserva);
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
        return evento;
    }

    private static EventoEmpresarial createEventoEmpresarial(String horaReserva) {
        Scanner scanner = new Scanner(System.in);
        String codigo = "";
        Double precio = 0.0;
        System.out.println("Evento Empresarial");

        System.out.println("Anticipo: ");
        Double anticipo = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Cantidad de personas: ");
        Integer cantidadPersonas = scanner.nextInt();
        scanner.nextLine();


        System.out.println("Nombre de la empresa: ");
        String nombreEmpresa = scanner.nextLine();

        System.out.println("Tematica de colores: ");
        String tematicaColor = scanner.nextLine();

        System.out.println("Codigo de vestimenta: ");
        String codigoVestimenta = scanner.nextLine();

        String comida = MenuComida.selectComida("comidaEmpresarial");

        System.out.println("Postre: ");
        String postre = scanner.nextLine();

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

    private static EventoFamiliar createEventoFamiliar(String horaReserva) {
        Scanner scanner = new Scanner(System.in);
        Double precio = 0.0;
        String codigo = "";
        System.out.println("Evento Familiar");

        System.out.println("Apellido de la familia: ");
        String apellido = scanner.nextLine();

        System.out.println("Anticipo: ");
        Double anticipo = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Cantidad de personas: ");
        Integer cantidadPersonas = scanner.nextInt();
        scanner.nextLine();

        String comida = MenuComida.selectComida("comidaNormal");
        String bebidas = MenuComida.selectComida("bebidaNormal");

        if(determinarCenaAlumerzo(horaReserva).equals("ALMUERZO")) {
            codigo = CODIGO_ALMUERZO_FAMILIAR;
            precio = PRECIO_ALMUERZO_FAMILIAR;
        } else if (determinarCenaAlumerzo(horaReserva).equals("CENA")) {
            codigo = CODIGO_CENA_FAMILIAR;
            precio = PRECIO_CENA_FAMILIAR;
        }

        return new EventoFamiliar(codigo, precio, anticipo, cantidadPersonas, comida, apellido, bebidas);
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
