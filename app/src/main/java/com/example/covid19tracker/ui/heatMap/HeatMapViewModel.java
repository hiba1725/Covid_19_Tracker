package com.example.covid19tracker.ui.heatMap;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HeatMapViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HeatMapViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Heat map goes here");
    }

    public LiveData<String> getText() {
        return mText;
    }
}