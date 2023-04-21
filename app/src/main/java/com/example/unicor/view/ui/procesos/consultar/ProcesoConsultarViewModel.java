package com.example.unicor.view.ui.procesos.consultar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProcesoConsultarViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ProcesoConsultarViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}