package com.example.jorda.provasub2.Service;

import com.example.jorda.provasub2.Model.Currently;
import com.example.jorda.provasub2.Model.Exemple;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface InterfaceDeServicos {
    @GET("forecast/8eeafa93fa171bb970bfac9b03caa3a3/{latitude},{longitude}?exclud e=minutely,hourly,daily,flags,alerts")
            Call<Exemple> consulta(@Path("latitude") double latitude,
                                   @Path("longitude") double longitude);
}
