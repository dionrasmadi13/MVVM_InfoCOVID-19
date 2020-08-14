package com.example.infocovid_19.models;
import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import com.example.infocovid_19.network.CoronaDataService;
import com.example.infocovid_19.network.RetrofitClient;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CoronaRepository {
    private String TAG = "CoronaRepository";
    private MutableLiveData<List<CoronaCase>> mutableLiveData = new MutableLiveData<>();
    public CoronaRepository() {
    }
    public MutableLiveData<List<CoronaCase>> getMutableLiveData() {
        final CoronaDataService coronaDataService = RetrofitClient.getService();
        Call<List<CoronaCase>> call = coronaDataService.getCorona();
        call.enqueue(new Callback<List<CoronaCase>>() {
            @Override
            public void onResponse(Call<List<CoronaCase>> call, Response<List<CoronaCase>> response) {
                if (response.isSuccessful()) {
                    mutableLiveData.setValue(response.body());;
                }
            }
            @Override
            public void onFailure(Call<List<CoronaCase>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getCause());
                Log.e(TAG, "onFailure: " + t.getLocalizedMessage());
                Log.e(TAG, "onFailure: " + t.getMessage());
                Log.e(TAG, "onFailure: " + t.toString());
            }
        });
        return mutableLiveData;
    }
}
