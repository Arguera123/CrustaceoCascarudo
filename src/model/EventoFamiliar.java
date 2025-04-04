package model;

public class EventoFamiliar extends Evento {
    protected String apellido;

    public EventoFamiliar(String codigo, Double precio, Double anticipo, Integer cantidadPersonas,
                          String comida, String apellido, String bebida) {
        super(codigo, precio, anticipo, cantidadPersonas, comida, bebida);
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

}
