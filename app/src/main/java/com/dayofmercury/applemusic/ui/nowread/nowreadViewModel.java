package com.dayofmercury.applemusic.ui.nowread;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class nowreadViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public nowreadViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is nowread fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}