package model;

public class Persona {
    private String nombreCompleto;
    private String identificacion;
    private String residencia;
    private Integer edad;
    private String telefono;
    private String lugarTrabajo; // Puede ser null

    public Persona(String nombreCompleto, String identificacion, String residencia, int edad, String telefono, String lugarTrabajo) {
        this.nombreCompleto = nombreCompleto;
        this.identificacion = identificacion;
        this.residencia = residencia;
        this.edad = edad;
        this.telefono = telefono;
        this.lugarTrabajo = lugarTrabajo;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getResidencia() {
        return residencia;
    }

    public void setResidencia(String residencia) {
        this.residencia = residencia;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLugarTrabajo() {
        return lugarTrabajo;
    }

    public void setLugarTrabajo(String lugarTrabajo) {
        this.lugarTrabajo = lugarTrabajo;
    }
}