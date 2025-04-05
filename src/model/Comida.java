package model;

public class Comida {
    String id;
    String tipo;
    String nombre;
    String descripcion;

    public Comida(String id, String tipo, String cangreburguerConQueso, String laClasicaConQuesoExtra) {
        this.id = id;
        this.tipo = tipo;
        this.nombre = cangreburguerConQueso;
        this.descripcion = laClasicaConQuesoExtra;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
