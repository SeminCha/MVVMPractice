package com.example.krinlech.mvvmpractice;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.krinlech.mvvmpractice.databinding.ActivityMvvmBinding;

public class MvvmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MvvmViewModel viewModel = new MvvmViewModel(this);

        ActivityMvvmBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_mvvm);
        binding.setViewModel(viewModel);
        binding.masterMode.setOnCheckedChangeListener(viewModel.switchListener);
        binding.subMode.setOnCheckedChangeListener(viewModel.switchListener);
        binding.valueText.addTextChangedListener(viewModel.valueWatcher);
    }
}
