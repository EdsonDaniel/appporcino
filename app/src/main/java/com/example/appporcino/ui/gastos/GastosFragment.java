package com.example.appporcino.ui.gastos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.appporcino.R;
import com.example.appporcino.ui.about.AboutFragment;
import com.example.appporcino.ui.alertas.AlertasFragment;
import com.example.appporcino.ui.eventos.EventosFragment;
import com.example.appporcino.ui.ganado.GanadoFragment;
import com.example.appporcino.ui.home.HomeFragment;
import com.example.appporcino.ui.produccion.ProduccionFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;

public class GastosFragment extends Fragment {

    private GastosViewModel gastosViewModel;
    private View root;
    private BottomNavigationView navView;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        gastosViewModel =
                ViewModelProviders.of(this).get(GastosViewModel.class);
        root = inflater.inflate(R.layout.fragment_gastos, container, false);
        final TextView textView = root.findViewById(R.id.text_gastos);
        gastosViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
