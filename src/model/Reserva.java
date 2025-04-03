package model;

import java.util.Random;

public class Reserva{
    private Persona persona;
    private Evento evento;
    private String codigoReserva;
    private String fechaReserva;
    private String horaReserva;
    private String horaFinalizacion;

    public Reserva(Persona persona, Evento evento, String fecha, String horaReserva,
                   Integer numeroReserva, String horaFinalizacion) {
        this.persona = persona;
        this.evento = evento;
        this.fechaReserva = fecha;
        this.horaReserva = horaReserva;
        this.horaFinalizacion = horaFinalizacion;
        this.codigoReserva = gen_numero_reserva(fecha, evento.getCorrelativo(), numeroReserva);
    }

    public Persona getPersona() {
        return persona;
    }

    public Evento getEvento() {
        return evento;
    }

    public String getCodigoReserva() {
        return codigoReserva;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public String getHoraReserva() {
        return horaReserva;
    }

    public String getHoraFinalizacion() {
        return horaFinalizacion;
    }

    private String gen_numero_reserva(String fecha, String codigo, Integer numeroReserva) {
        Random r = new Random();
        return "KB-" + numeroReserva + "T" + codigo + r.nextInt(10) + fecha;
    }
}
