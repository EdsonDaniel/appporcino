package com.example.appporcino.Modelo;

public class Hembra extends Porcino {

    private int num_crias;
    public Hembra(String nombre, String fecha_nac, String tipo,
                  String foto_url, String genero, String raza,
                  String descripcion, String fecha_compra, String fecha_venta,
                  double peso, int num_crias) {

        super(nombre, fecha_nac, tipo, foto_url, genero, raza, descripcion,
                fecha_compra, fecha_venta,peso);
        this.num_crias = num_crias;
    }

    public int getNum_crias() {
        return num_crias;
    }

    public void setNum_crias(int num_crias) {
        this.num_crias = num_crias;
    }
}
