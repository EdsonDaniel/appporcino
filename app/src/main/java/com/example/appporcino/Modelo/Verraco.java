package com.example.appporcino.Modelo;


public class Verraco extends Porcino {

    private int num_montas;


    public Verraco(String nombre, String fecha_nac, String tipo,
                   String foto_url, String genero, String raza,
                   String descripcion, String fecha_compra, String fecha_venta,
                   int num_montas,double peso) {

        super(nombre, fecha_nac, tipo, foto_url, genero, raza,
                descripcion, fecha_compra,fecha_venta,peso);
        this.num_montas = num_montas;

    }

    public int getNum_montas() {
        return num_montas;
    }

    public void setNum_montas(int num_montas) {
        this.num_montas = num_montas;
    }
}
