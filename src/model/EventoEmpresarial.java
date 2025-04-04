package model;

public class EventoEmpresarial extends Evento {
    private String nombreEmpresa;
    private String tematicaColor;
    private String codigoVestimenta;
    private String postre;

    public EventoEmpresarial() {}

    public EventoEmpresarial(String codigo, Double precio, Double anticipo, Integer cantidadPersonas,
                             String comida, String nombreEmpresa, String tematicaColor, String codigoVestimenta,
                             String postre) {
        super(codigo, precio, anticipo, cantidadPersonas, comida);
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
