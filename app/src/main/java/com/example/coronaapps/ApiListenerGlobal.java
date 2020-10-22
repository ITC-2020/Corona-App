package com.example.coronaapps;

import com.example.coronaapps.model.ModelDataGlobal;

import java.util.List;

public interface ApiListenerGlobal<T> {

        void onSuccess(T items);
        void onFailed(String msg);

}
