package com.example.infocovid_19.network;
import com.example.infocovid_19.models.CoronaCase;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CoronaDataService {
    @GET("indonesia/provinsi")
    Call<List<CoronaCase>> getCorona();
}
