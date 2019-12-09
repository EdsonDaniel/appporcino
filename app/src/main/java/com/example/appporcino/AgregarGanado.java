package com.example.appporcino;

import android.app.DatePickerDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.appporcino.data.BaseDatosGranja;
import com.example.appporcino.data.FeedReaderContract;
import com.example.appporcino.ui.dialog.DatePickerFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.provider.BaseColumns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AgregarGanado extends AppCompatActivity
implements View.OnClickListener {

    private TextInputEditText fecha_nac;
    private TextInputEditText fecha_compra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_ganado);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final BaseDatosGranja db = new BaseDatosGranja(getApplicationContext());
        fecha_nac = findViewById(R.id.fecha_nac);
        fecha_nac.setOnClickListener(this);
        fecha_compra = findViewById(R.id.fecha_compra);
        fecha_compra.setOnClickListener(this);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource
        (this,R.array.tipos,R.layout.dropdown_menu_popup_item);

        AutoCompleteTextView editTextFilledExposedDropdown = findViewById(R.id.filled_exposed_dropdown);
        editTextFilledExposedDropdown.setAdapter(arrayAdapter);

        /*FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Gets the data repository in write mode
                SQLiteDatabase database = db.getWritableDatabase();
                // Create a new map of values, where column names are the keys
                ContentValues values = new ContentValues();
                values.put("nombre", "Pruebano1");
                values.put("fecha_nac", "10mayo");
                // Insert the new row, returning the primary key value of the new row
                long newRowId = database.insert("porcino", null, values);
                Toast toast1 = Toast.makeText(getApplicationContext(),
                        "ID: "+newRowId, Toast.LENGTH_LONG);
                toast1.show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Button boton  = findViewById(R.id.button);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase databaseb = db.getReadableDatabase();
                // Define a projection that specifies which columns from the database
                // you will actually use after this query.
                String[] projection = {
                        BaseColumns._ID,
                        "nombre",
                        "fecha_nac"
                };
                // Filter results WHERE "title" = 'My Title'
                String selection = FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE + " = ?";
                String[] selectionArgs = { "Pruebano1" };
                // How you want the results sorted in the resulting Cursor
                String sortOrder =
                        FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE + " DESC";
                Cursor cursor = databaseb.query(
                        "porcino",   // The table to query
                        projection,             // The array of columns to return (pass null to get all)
                        null,              // The columns for the WHERE clause
                        null,          // The values for the WHERE clause
                        null,                   // don't group the rows
                        null,                   // don't filter by row groups
                        sortOrder               // The sort order
                );
                String datos = obtenerElementos(cursor);
                Toast toast1 = Toast.makeText(getApplicationContext(),
                        "datos: "+datos, Toast.LENGTH_LONG);
                toast1.show();
            }
        }); */
    }


    private String obtenerElementos(Cursor cursor){
        List itemIds = new ArrayList<>();
        List titles = new ArrayList<>();
        List subtitles = new ArrayList<>();
        String datos = "";
        while(cursor.moveToNext()) {
            long itemId = cursor.getLong(
                    cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry._ID));
            itemIds.add(itemId);
            String title = cursor.getString(
                    cursor.getColumnIndexOrThrow("nombre"));
            titles.add(title);
        }
        for(int i = 0; i<titles.size(); i++){
            datos += itemIds.get(i) + "\t" + titles.get(i)+"\n";
        }
        cursor.close();
        return datos;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fecha_nac:
                showDatePickerDialog(fecha_nac);
                break;
            case R.id.fecha_compra:
                showDatePickerDialog(fecha_compra);
                break;
        }
    }
    private void showDatePickerDialog(final TextInputEditText edittext) {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                // +1 because January is zero
                final String selectedDate = twoDigits(day) + "/" + twoDigits(month+1) + "/" + year;
                edittext.setText(selectedDate);
            }
        });

        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
    private String twoDigits(int n) {
        return (n<=9) ? ("0"+n) : String.valueOf(n);
    }
}
