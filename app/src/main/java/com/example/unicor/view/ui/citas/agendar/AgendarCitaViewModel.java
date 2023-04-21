package com.example.unicor.view.ui.citas.agendar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AgendarCitaViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public AgendarCitaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}