package model;

public class EventoEmpresarial extends Evento {
    protected String nombreEmpresa;
    protected String tematicaColor;
    protected String codigoVestimenta;
    protected String postre;

    public EventoEmpresarial(String codigo, Double precio, String fechaReserva, String horaReserva, String horaFinalizacion, Double anticipo) {
        super(codigo, precio, fechaReserva, horaReserva, horaFinalizacion, anticipo);
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getTematicaColor() {
        return tematicaColor;
    }

    public void setTematicaColor(String tematicaColor) {
        this.tematicaColor = tematicaColor;
    }

    public String getCodigoVestimenta() {
        return codigoVestimenta;
    }

    public void setCodigoVestimenta(String codigoVestimenta) {
        this.codigoVestimenta = codigoVestimenta;
    }

    public String getPostre() {
        return postre;
    }

    public void setPostre(String postre) {
        this.postre = postre;
    }
}
