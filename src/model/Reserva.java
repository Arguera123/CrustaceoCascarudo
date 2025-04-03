package model;

import java.util.Random;

public class Reserva{
    private Persona persona;
    private Evento evento;
    private String codigoReserva;
    private String fechaReserva;
    private String horaReserva;
    private String horaFinalizacion;

    public Reserva(Persona persona, Evento evento, String codigoReserva, String fecha, String horaReserva, String horaFinalizacion) {
        this.persona = persona;
        this.evento = evento;
        this.codigoReserva = codigoReserva;
        this.fechaReserva = fecha;
        this.horaReserva = horaReserva;
        this.horaFinalizacion = horaFinalizacion;
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
}
