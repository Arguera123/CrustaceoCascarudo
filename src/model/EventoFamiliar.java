package model;

public class EventoFamiliar extends Evento {
    protected String apellido;
    protected String bebidas;

    public EventoFamiliar(String codigo, Double precio, Double anticipo, Integer cantidadPersonas,
                          String comida, String apellido, String bebidas) {
        super(codigo, precio, anticipo, cantidadPersonas, comida);
        this.apellido = apellido;
        this.bebidas = bebidas;
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
