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
    // Constantes
    private static final Double PRECIO_CUMPLEANIOS = 380.00;
    private static final Double PRECIO_CENA_EMPRESARIAL = 320.00;
    private static final Double PRECIO_ALMUERZO_EMPRESARIAL = 300.00;
    private static final Double PRECIO_CENA_FAMILIAR = 200.00;
    private static final Double PRECIO_ALMUERZO_FAMILIAR = 180.00;

    private static final String CODIGO_CUMPLEANIOS = "HBD-E-01";
    private static final String CODIGO_CENA_EMPRESARIAL = "ED-E-03";
    private static final String CODIGO_ALMUERZO_EMPRESARIAL = "EE-E-03";
    private static final String CODIGO_ALMUERZO_FAMILIAR = "EE-E-02";
    private static final String CODIGO_CENA_FAMILIAR = "FD-E-04";

    // Atributos
    private Scanner scanner;
    private Evento evento;

    public MenuEvento() {
        scanner = null;
        evento = null;
    }

    public Evento createEvento(String horaReserva) {
        scanner = new Scanner(System.in);
        System.out.println("Tipo de evento:");
        System.out.println("1. Cumpleaños\n2. Evento Familiar\n3. Evento Empresarial");
        Integer tipoEvento = Integer.parseInt(scanner.nextLine());

        switch (tipoEvento) {
            case 1:
                evento = createEventoCumpleanios();
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

    /**
     * Se solicitan datos del evento tipo cumpleanios para la creacion de este mismo
     * @return evento de tipo cumpleanios
     */
    private Cumpleanios createEventoCumpleanios() {
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
        Integer cantidadPersonas = scanner.nextInt();
        scanner.nextLine();

        while(cantidadPersonas < 50 || cantidadPersonas > 75) {
            System.out.println("La cantidad de personas debe ser minimo 50 y maximo 75");
            System.out.println("Digite otra vez la cantidad: ");
            cantidadPersonas = scanner.nextInt();
            scanner.nextLine();
        }

        System.out.println("Anticipo: ");
        Double anticipo = scanner.nextDouble();
        scanner.nextLine();

        String comida = MenuComida.selectComida("comidaNormal");
        String bebida = MenuComida.selectComida("bebidaNormal");


        return new Cumpleanios(
                CODIGO_CUMPLEANIOS, PRECIO_CUMPLEANIOS, nombre, edad, colorFavorito,
                cantidadPersonas, modalidad, anticipo, comida, bebida
        );
    }

    /**
     * Se solicitan datos del evento tipo empresarial para la creacion de este mismo
     * @param horaReserva se usa para determinar si es un almuerzo o cena.
     * @return evento de tipo empresarial
     */
    private EventoEmpresarial createEventoEmpresarial(String horaReserva) {
        String codigo = "";
        Double precio = 0.0;
        System.out.println("Evento Empresarial");

        System.out.println("Anticipo: ");
        Double anticipo = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Cantidad de personas: ");
        Integer cantidadPersonas = scanner.nextInt();
        scanner.nextLine();

        while(cantidadPersonas < 10 || cantidadPersonas > 40) {
            System.out.println("La cantidad de personas debe ser minimo 10 y maximo 40");
            System.out.println("Digite otra vez la cantidad: ");
            cantidadPersonas = scanner.nextInt();
            scanner.nextLine();
        }

        System.out.println("Nombre de la empresa: ");
        String nombreEmpresa = scanner.nextLine();

        System.out.println("Tematica de colores: ");
        String tematicaColor = scanner.nextLine();

        System.out.println("Codigo de vestimenta: ");
        String codigoVestimenta = scanner.nextLine();

        String comida = MenuComida.selectComida("comidaEmpresarial");
        String bebida = MenuComida.selectComida("bebidaEmpresarial");

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
                codigoVestimenta, postre, bebida
        );
    }

    /**
     * Se solicitan datos del evento tipo familiar para la creacion de este mismo
     * @param horaReserva se usa para determinar si es un almuerzo o cena.
     * @return evento de tipo familiar
     */
    private EventoFamiliar createEventoFamiliar(String horaReserva) {
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

        while(cantidadPersonas < 4 || cantidadPersonas > 10) {
            System.out.println("La cantidad de personas debe ser minimo 4 y maximo 10");
            System.out.println("Digite otra vez la cantidad: ");
            cantidadPersonas = scanner.nextInt();
            scanner.nextLine();
        }

        String comida = MenuComida.selectComida("comidaNormal");
        String bebida = MenuComida.selectComida("bebidaNormal");

        if(determinarCenaAlumerzo(horaReserva).equals("ALMUERZO")) {
            codigo = CODIGO_ALMUERZO_FAMILIAR;
            precio = PRECIO_ALMUERZO_FAMILIAR;
        } else if (determinarCenaAlumerzo(horaReserva).equals("CENA")) {
            codigo = CODIGO_CENA_FAMILIAR;
            precio = PRECIO_CENA_FAMILIAR;
        }

        return new EventoFamiliar(codigo, precio, anticipo, cantidadPersonas, comida, apellido, bebida);
    }

    /**
     * Esta funcion determina en base a la hora de reserva si se trata de un almuerzo o cena.
     * Si la hora es mayor-igual a 12 y menor-igual a 17 (5 pm), se considera almuerzo
     * sino, se considera cena.
     * @param horaReserva Hora a la cual la reserva sera efectiva
     * @return "ALMUERZO" si es en la tarde, "CENA" si es en la noche.
     */
    private String determinarCenaAlumerzo(String horaReserva) {
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
