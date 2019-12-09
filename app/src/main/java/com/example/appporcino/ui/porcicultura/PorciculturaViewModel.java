package com.example.appporcino.ui.porcicultura;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PorciculturaViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PorciculturaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is share fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}