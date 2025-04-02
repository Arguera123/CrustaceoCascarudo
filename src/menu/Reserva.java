package menu;

import java.util.Date;

public class Reserva{

    //Convertir a clase persona??
    private String nombreCliente;
    private String DUI;
    private String lugarResidencia;
    private Integer edad;
    private String telefono;
    private String lugarTrabajo;

    private String codigoReserva;
    private String fechaReserva;
    private String horaReserva;
    private Integer tipoEvento;


    //Constructor
    public Reserva(String nombreCliente, String dui, String lugarResidencia, Integer edad,
                   String telefono, String lugarTrabajo, String fecha, String horaReserva,
                   String numeroReserva, Integer tipoEvento) {
        this.nombreCliente = nombreCliente;
        this.DUI = dui;
        this.lugarResidencia = lugarResidencia;
        this.edad = edad;
        this.telefono = telefono;
        this.lugarTrabajo = lugarTrabajo;

        this.codigoReserva = numeroReserva;
        this.fechaReserva = fecha;
        this.horaReserva = horaReserva;
        this.tipoEvento = tipoEvento;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getDUI() {
        return DUI;
    }

    public String getLugarResidencia() {
        return lugarResidencia;
    }

    public Integer getEdad() {
        return edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getLugarTrabajo() {
        return lugarTrabajo;
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

    public Integer getTipoEvento() {
        return tipoEvento;
    }
}
