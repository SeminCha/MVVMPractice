package com.example.krinlech.mvvmpractice;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class TestData extends BaseObservable {
    private String id;
    private String name;

    TestData(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Bindable
    public String getId() {
        return id;
    }

    @Bindable
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "TestData{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
