package com.example.appporcino.ui.porcicultura;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.appporcino.R;

public class PorciculturaFragment extends Fragment {

    private PorciculturaViewModel porciculturaViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        porciculturaViewModel =
                ViewModelProviders.of(this).get(PorciculturaViewModel.class);
        View root = inflater.inflate(R.layout.fragment_porcicultura, container, false);
        final TextView textView = root.findViewById(R.id.text_share);
        porciculturaViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}