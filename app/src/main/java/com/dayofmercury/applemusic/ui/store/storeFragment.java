package com.dayofmercury.applemusic.ui.store;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.dayofmercury.applemusic.R;

public class storeFragment extends Fragment {

    private storeViewModel storeViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        storeViewModel =
                ViewModelProviders.of(this).get(storeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_store, container, false);
//        final TextView textView = root.findViewById(R.id.text_notifications);
//        storeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
}
