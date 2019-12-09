package com.example.appporcino.ui.produccion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.appporcino.R;
import com.example.appporcino.ui.about.AboutFragment;
import com.example.appporcino.ui.alertas.AlertasFragment;
import com.example.appporcino.ui.eventos.EventosFragment;
import com.example.appporcino.ui.ganado.GanadoFragment;
import com.example.appporcino.ui.gastos.GastosFragment;
import com.example.appporcino.ui.home.HomeFragment;
import com.example.appporcino.ui.home.HomeViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;

public class ProduccionFragment extends Fragment {

    private ProduccionViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(ProduccionViewModel.class);
        View root = inflater.inflate(R.layout.fragment_produccion, container, false);
        final TextView textView = root.findViewById(R.id.text_produccion);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}