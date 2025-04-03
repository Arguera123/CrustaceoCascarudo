package menu;

import dto.ReservaDTO;
import model.Evento;
import model.Persona;
import model.Reserva;

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
            Integer edad = Integer.parseInt(scanner.nextLine());

            System.out.println("Telefono: ");
            String telefono = scanner.nextLine();

            System.out.println("Lugar de trabajo: ");
            String lugarTrabajo = scanner.nextLine();

            System.out.println("Ingrese fecha de reserva (Formato DD/MM/AAAA): ");
            String fechaReserva = scanner.nextLine();

            // Validar fecha
            while (!isValidDate(fechaReserva)) {
                System.out.println("Fecha de reserva incorrecta vuelva a digitar (Formato DD/MM/AAAA): ");
                fechaReserva = scanner.nextLine();
            }

            System.out.println("Ingrese hora de reserva (Formato HH:MM): ");
            String horaReserva = scanner.nextLine();

            // Validar hora
            while (!isValidHour(horaReserva)) {
                System.out.println("Hora de reserva incorrecta vuelva a digitar (Formato HH:MM): ");
                horaReserva = scanner.nextLine();
            }

            System.out.println("Ingrese hora de que finaliza la reserva (Formato HH:MM): ");
            String horaFinalizacion = scanner.nextLine();

            // Validar hora
            while (!isValidHour(horaFinalizacion)) {
                System.out.println("Hora de reserva incorrecta vuelva a digitar (Formato HH:MM): ");
                horaFinalizacion = scanner.nextLine();
            }



            Persona nuevaPersona = new Persona(nombreCliente, DUI, lugarResidencia, edad, telefono, lugarTrabajo);

            Evento evento = MenuEvento.createEvento();
            String numeroReserva = gen_numero_reserva(fechaReserva, evento.getCodigo());

            Reserva nuevaReserva = new Reserva(nuevaPersona, evento, fechaReserva, horaReserva, evento.getCodigo(), horaFinalizacion);

            System.out.println("Reserva creada con exito");
            System.out.println("Numero de reserva: " + nuevaReserva.getCodigoReserva());
            System.out.println("Fecha de reserva: " + fechaReserva);
            System.out.println("Hora de reserva: " + horaReserva);

            reservas.add(nuevaReserva);
            reservasDTO.add(new ReservaDTO(nuevaReserva.getCodigoReserva(), nombreCliente, fechaReserva, horaReserva, evento.getCodigo()));

            return nuevaReserva; //Necesario??
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
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

    private String gen_numero_reserva(String fecha, String evento){
        contadorReservas++;
        String codigo = switch (evento) {
            case "HBD-E-01" -> "BD"; // Cumpleaños
            case "EE-E-02" -> "AF"; // Almuerzo Familiar
            case "ED-E-03" -> "CE"; // Cena Empresarial
            case "EE-E-03" -> "AE"; // Almuerzo Empresarial
            case "FD-E-04" -> "CF"; // Cena Familiar
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


