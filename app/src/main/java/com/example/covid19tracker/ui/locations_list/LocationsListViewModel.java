package com.example.covid19tracker.ui.locations_list;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LocationsListViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public LocationsListViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("AP Locations Table Goes Here");
    }

    public LiveData<String> getText() {
        return mText;
    }
}