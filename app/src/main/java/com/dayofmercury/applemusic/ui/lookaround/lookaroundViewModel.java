package com.dayofmercury.applemusic.ui.lookaround;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class lookaroundViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public lookaroundViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is lookaround fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}