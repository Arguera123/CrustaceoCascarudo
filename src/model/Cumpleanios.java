package model;

public class Cumpleanios extends Evento {
    private String nombreCumpleaniero;
    private Integer edadCumpleaniero;
    private String colorFavorito;
    private Integer cantidadPersonas;
    private String modalidadRegalo;
    private Double anticipo;

    public Cumpleanios(String codigo, double precio, String nombreCumpleaniero, int edadCumpleaniero, String colorFavorito,
                       int cantidadPersonas, String modalidadRegalo, Double anticipo, String comida, String bebida) {
        super(codigo, precio, anticipo, cantidadPersonas, comida, bebida);
        this.nombreCumpleaniero = nombreCumpleaniero;
        this.edadCumpleaniero = edadCumpleaniero;
        this.colorFavorito = colorFavorito;
        this.cantidadPersonas = cantidadPersonas;
        this.modalidadRegalo = modalidadRegalo;
        this.anticipo = anticipo;
    }
}

