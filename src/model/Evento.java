package model;

public abstract class Evento {
    private String codigo;
    private Double precio;
    private Double anticipo;
    private Integer cantidadPersonas;
    private String comida;

    public Evento(String codigo, Double precio, Double anticipo, Integer cantidadPersonas, String comida) {
        this.codigo = codigo;
        this.precio = precio;
        this.anticipo = anticipo;
        this.cantidadPersonas = cantidadPersonas;
        this.comida = comida;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getAnticipo() {
        return anticipo;
    }

    public void setAnticipo(Double anticipo) {
        this.anticipo = anticipo;
    }

    public Integer getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(Integer cantidad) {
        this.cantidadPersonas = cantidad;
    }

    public String getComida() {
        return comida;
    }

    public void setComida(String comida) {
        this.comida = comida;
    }
}

