package menu;

public class ReservaDTO {
    private String numeroReserva;
    private String nombreCliente;
    private String fechaReserva;
    private String horaReserva;
    private String TipoEvento;

    public ReservaDTO(String numeroReserva, String nombreCliente, String fechaReserva, String horaReserva, String tipoEvento) {
        this.numeroReserva = numeroReserva;
        this.nombreCliente = nombreCliente;
        this.fechaReserva = fechaReserva;
        this.horaReserva = horaReserva;
        TipoEvento = tipoEvento;
    }

    public String getNumeroReserva() {
        return numeroReserva;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public String getHoraReserva() {
        return horaReserva;
    }

    public String getTipoEvento() {
        return TipoEvento;
    }
}
