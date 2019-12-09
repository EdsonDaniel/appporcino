package com.example.appporcino.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class BaseDatosGranja extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "granja.db";
    private static final String SQL_CREATE_PORCINO =
            "CREATE TABLE PORCINO(" + BaseColumns._ID+"INTEGER PRIMARY KEY AUTOINCREMENT,"
                    +"nombre varchar(100), fecha_nac text, tipo varchar(30)," +
                    "foto_url varchar(100),genero char, raza varchar(100)," +
                    "descripcion text, fecha_compra text, fecha_venta text, peso double)";

    private static final String SQL_CREATE_VERRACO =
            "CREATE TABLE VERRACO(" + BaseColumns._ID
                    +"INTEGER PRIMARY KEY AUTOINCREMENT,"
                    +"nombre varchar(100), fecha_nac text, tipo varchar(30)," +
                    "foto_url varchar(100),genero char, raza varchar(100)," +
                    "descripcion text, fecha_compra text, fecha_venta text, " +
                    "peso double, num_montas integer)";
    private static final String SQL_CREATE_HEMBRA =
            "CREATE TABLE VERRACO(" + BaseColumns._ID
                    +"INTEGER PRIMARY KEY AUTOINCREMENT,"
                    +"nombre varchar(100), fecha_nac text, tipo varchar(30)," +
                    "foto_url varchar(100),genero char, raza varchar(100)," +
                    "descripcion text, fecha_compra text, fecha_venta text, " +
                    "peso double, num_crias integer)";


    private static final String SQL_DELETE_PORCINO =
            "DROP TABLE IF EXISTS PORCINO";
    private static final String SQL_DELETE_VERRACO =
            "DROP TABLE IF EXISTS VERRACO";
    private static final String SQL_DELETE_HEMBRA =
            "DROP TABLE IF EXISTS HEMBRA";

    public BaseDatosGranja(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_PORCINO);
        db.execSQL(SQL_CREATE_VERRACO);
        db.execSQL(SQL_CREATE_HEMBRA);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_PORCINO);
        db.execSQL(SQL_DELETE_VERRACO);
        db.execSQL(SQL_DELETE_HEMBRA);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}