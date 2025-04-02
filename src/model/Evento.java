package model;

public abstract class Evento {
    protected String codigo;
    protected Double precio;
    protected String fechaReserva;
    protected String horaReserva;
    protected String horaFinalizacion;
    protected Double anticipo;

    public Evento(String codigo, Double precio, String fechaReserva, String horaReserva, String horaFinalizacion, Double anticipo) {
        this.codigo = codigo;
        this.precio = precio;
        this.fechaReserva = fechaReserva;
        this.horaReserva = horaReserva;
        this.horaFinalizacion = horaFinalizacion;
        this.anticipo = anticipo;
    }
}

