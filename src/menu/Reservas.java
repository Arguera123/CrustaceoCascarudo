package menu;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reservas {
    private static Integer contadorReservas = 0;
    private static List<Reserva> reservas = new ArrayList<Reserva>();
    private static List<ReservaDTO> reservasDTO = new ArrayList<ReservaDTO>();

    //Devuelve un objeto de tipo reserva
    public Reserva agregarReserva() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Nombre completo: ");
            String nombreCliente = scanner.nextLine();

            System.out.println("DUI: ");
            String DUI = scanner.nextLine();

            System.out.println("Lugar de residencia: ");
            String lugarResidencia = scanner.nextLine();

            System.out.println("Edad: ");
            Integer edad = scanner.nextInt();

            System.out.println("Telefono: ");
            String telefono = scanner.nextLine();

            System.out.println("Lugar de trabajo: ");
            String lugarTrabajo = scanner.nextLine();

            System.out.println("Ingrese fecha de reserva (Formato DD/MM/AAAA): ");
            String fechaReserva = scanner.nextLine();
            // Validar fecha
            if(!isValidDate(fechaReserva)){
                throw new Exception();
            }

            System.out.println("Ingrese hora de reserva (Formato HH:MM): ");
            String horaReserva = scanner.nextLine();
            // Validar hora
            if(!isValidHour(horaReserva)){
                throw new Exception();
            }

            System.out.println("Tipo de evento:");
            System.out.println("1. Cumpleaños\n2. Almuerzo Familiar\n3. Cena Empresarial\n4. Almuerzo empresarial\n5. Cena Familiar");
            Integer tipoEvento = scanner.nextInt();
            if(tipoEvento > 5 || tipoEvento < 1){
                throw new Exception();
            }

            String numeroReserva = gen_numero_reserva(fechaReserva, tipoEvento);

            System.out.println("Reserva creada con exito");
            System.out.println("Numero de reserva: " + numeroReserva);
            System.out.println("Fecha de reserva: " + fechaReserva);
            System.out.println("Hora de reserva: " + horaReserva);

            Reserva nuevaReserva = new Reserva(nombreCliente, DUI, lugarResidencia,
                    edad, telefono, lugarTrabajo, fechaReserva, horaReserva, numeroReserva, tipoEvento);

            reservas.add(nuevaReserva);
            reservasDTO.add(new ReservaDTO(numeroReserva, nombreCliente, fechaReserva, horaReserva, tipoEvento.toString()));

            return nuevaReserva; //Necesario??
        }
        catch (Exception e) {
            System.out.println("Error al ingresar los datos");
            return null;
        }

    }

    public void reservasPendientes() {
        Date fechaActual = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        for (ReservaDTO reserva : reservasDTO) {
            String fechaReserva = reserva.getFechaReserva();
            try {
                Date fechaReservaDate = dateFormat.parse(fechaReserva);
                if (fechaReservaDate.after(fechaActual)) {
                    System.out.println("Reserva pendiente: " + reserva.getNombreCliente() +
                            ", Fecha: " + reserva.getFechaReserva() +
                            ", Hora: " + reserva.getHoraReserva() +
                            ", Codigo de reserva: " + reserva.getNumeroReserva() +
                            ", Tipo de evento: " + reserva.getTipoEvento());
                    System.out.println("--------------------------------------------------");
                }
            } catch (Exception e) {
                System.out.println("Error al parsear la fecha de reserva: " + e.getMessage());
            }
        }


    }

    public void reservasTerminadas() {
        Date fechaActual = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        for (ReservaDTO reserva : reservasDTO) {
            String fechaReserva = reserva.getFechaReserva();
            try {
                Date fechaReservaDate = dateFormat.parse(fechaReserva);
                if (fechaReservaDate.before(fechaActual)) {
                    System.out.println("Reserva terminada: " + reserva.getNombreCliente() +
                            ", Fecha: " + reserva.getFechaReserva() +
                            ", Hora: " + reserva.getHoraReserva() +
                            ", Codigo de reserva: " + reserva.getNumeroReserva() +
                            ", Tipo de evento: " + reserva.getTipoEvento());
                    System.out.println("--------------------------------------------------");
                }
            } catch (Exception e) {
                System.out.println("Error al parsear la fecha de reserva: " + e.getMessage());
            }
        }
    }


    private String gen_numero_reserva(String fecha, Integer evento){
        contadorReservas++;
        String codigo = switch (evento) {
            case 1 -> "BD"; // Cumpleaños
            case 2 -> "AF"; // Almuerzo Familiar
            case 3 -> "CE"; // Cena Empresarial
            case 4 -> "AE"; // Almuerzo Empresarial
            case 5 -> "CF"; // Cena Familiar
            default -> "XX"; // Error
        };
        Random r = new Random();
        return "KB-" + contadorReservas + "T" + codigo + r.nextInt(10) + fecha;
    }

    private boolean isValidDate(String date) {
        final String DATE_PATTERN = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";
        Pattern pattern = Pattern.compile(DATE_PATTERN);
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }
    private boolean isValidHour(String hour) {
        final String HOUR_PATTERN = "^([01]\\d|2[0-3]):([0-5]\\d)$";
        Pattern pattern = Pattern.compile(HOUR_PATTERN);
        Matcher matcher = pattern.matcher(hour);
        return matcher.matches();
    }
}


