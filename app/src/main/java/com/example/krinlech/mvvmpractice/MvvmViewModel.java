package com.example.krinlech.mvvmpractice;

import android.content.Context;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CompoundButton;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class MvvmViewModel {
    private Context mContext;
    public final ObservableBoolean masterMode = new ObservableBoolean();
    public final ObservableBoolean subMode = new ObservableBoolean();
    public final ObservableField<String> valueText = new ObservableField<>();
    public final ObservableField<String> resultText = new ObservableField<>();

    public ObservableField<TestData> testData = new ObservableField<>();

    MvvmViewModel(Context context) {
        mContext = context;
        load();
    }

    private void load() {

        masterMode.set(false);
        subMode.set(false);
    }

    CompoundButton.OnCheckedChangeListener switchListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            switch (compoundButton.getId()) {
                case R.id.master_mode:
                    masterMode.set(b);
                    break;
                case R.id.sub_mode:
                    subMode.set(b);
                    break;
            }
        }
    };

    TextWatcher valueWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

        @Override
        public void afterTextChanged(Editable editable) {
            valueText.set(editable.toString());
            resultText.set(editable.toString());
        }
    };

    private void getData(int index) {
        testData.set(Repository.get().findTestData(index));
    }

    public void onButton(View view) {
        switch (view.getId()) {
            case R.id.preset1:
                Observable.just(1)
                        .delay(1, TimeUnit.SECONDS)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(this::getData);
                break;
            case R.id.preset2:
                Observable.just(2)
                        .delay(1, TimeUnit.SECONDS)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(this::getData);
                break;
        }
    }

}
