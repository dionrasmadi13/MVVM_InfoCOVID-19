package com.example.infocovid_19.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.infocovid_19.models.CoronaCase;
import com.example.infocovid_19.models.CoronaRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private CoronaRepository coronaRepository;
    public MainViewModel(@NonNull Application application) {
        super(application);
        coronaRepository = new CoronaRepository();
    }
    public LiveData<List<CoronaCase>> getAllCorona() {
        return coronaRepository.getMutableLiveData();
    }
}
