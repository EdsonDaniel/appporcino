package com.example.appporcino.Modelo;

public class Porcino {
    protected String nombre;
    protected String fecha_nac;
    protected String tipo;
    protected String foto_url;
    protected String genero;
    protected String raza;
    protected String descripcion;
    protected String fecha_compra;
    protected String fecha_venta;
    protected double peso;

    public Porcino(String nombre, String fecha_nac, String tipo,
                   String foto_url, String genero, String raza,
                   String descripcion, String fecha_compra, String fecha_venta,
                   double peso) {
        this.nombre = nombre;
        this.fecha_nac = fecha_nac;
        this.tipo = tipo;
        this.foto_url = foto_url;
        this.genero = genero;
        this.raza = raza;
        this.descripcion = descripcion;
        this.fecha_compra = fecha_compra;
        this.fecha_venta = fecha_venta;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFoto_url() {
        return foto_url;
    }

    public void setFoto_url(String foto_url) {
        this.foto_url = foto_url;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(String fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public String getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(String fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public double getPeso() { return peso; }

    public void setPeso(double peso) { this.peso = peso; }
}
