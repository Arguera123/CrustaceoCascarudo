package model;

public class Cumpleanios extends Evento {
    private String nombreCumpleaniero;
    private Integer edad;
    private String colorFavorito;
    private Integer cantidadPersonas;
    private String modalidadRegalo;
    private Double anticipo;
    private String alimento;

    public Cumpleanios(String codigo, double precio, String fechaReserva, String horaReserva, String horaFinalizacion,
                       String nombreCumpleaniero, int edad, String colorFavorito, int cantidadPersonas,
                       String modalidadRegalo, Double anticipo, String alimento) {
        super(codigo, precio, fechaReserva, horaReserva, horaFinalizacion,null);
        this.nombreCumpleaniero = nombreCumpleaniero;
        this.edad = edad;
        this.colorFavorito = colorFavorito;
        this.cantidadPersonas = cantidadPersonas;
        this.modalidadRegalo = modalidadRegalo;
        this.anticipo = anticipo;
        this.alimento = alimento;
    }
}

