package com.jacob.fruitoftek.safecrop.sustain.fiis;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiServiceFIIS {
    @POST("oda_kade_ofoase_akroso_iis_response.php") // Replace with your endpoint enchi_iis_response.php
    Call<Void> uploadRecords(@Body List<ModelRecordFIIS> records);

}

