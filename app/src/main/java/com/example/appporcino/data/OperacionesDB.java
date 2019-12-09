package com.example.appporcino.data;

import android.content.Context;

public final class OperacionesDB {
    private static BaseDatosGranja database;
    private static OperacionesDB instancia = new OperacionesDB();

    private OperacionesDB(){}

    public static OperacionesDB getInstancia(Context contexto) {
        if (database == null) {
            database = new BaseDatosGranja(contexto);
        }
        return instancia;
    }

}
