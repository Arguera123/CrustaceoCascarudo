package model;

public class EventoEmpresarial extends Evento {
    protected String nombreEmpresa;
    protected String tematicaColor;
    protected String codigoVestimenta;
    protected String postre;

    public EventoEmpresarial(String codigo, Double precio, Double anticipo, String correlativo, Integer cantidadPersonas, String comida, String nombreEmpresa, String tematicaColor, String codigoVestimenta, String postre) {
        super(codigo, precio, anticipo, correlativo, cantidadPersonas, comida);
        this.nombreEmpresa = nombreEmpresa;
        this.tematicaColor = tematicaColor;
        this.codigoVestimenta = codigoVestimenta;
        this.postre = postre;
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
