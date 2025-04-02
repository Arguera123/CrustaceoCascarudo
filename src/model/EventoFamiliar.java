package model;

public class EventoFamiliar extends Evento {
    protected String apellido;
    protected String bebidas;

    public EventoFamiliar(String codigo, Double precio, String fechaReserva, String horaReserva, String horaFinalizacion, Double anticipo) {
        super(codigo, precio, fechaReserva, horaReserva, horaFinalizacion, anticipo);
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getBebidas() {
        return bebidas;
    }

    public void setBebidas(String bebidas) {
        this.bebidas = bebidas;
    }
}
