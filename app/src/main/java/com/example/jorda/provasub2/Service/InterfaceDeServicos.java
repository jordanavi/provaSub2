package com.example.jorda.provasub2.Service;

import com.example.jorda.provasub2.Model.DadosClima;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface InterfaceDeServicos {
    @GET ("forecast/8eeafa93fa171bb970bfac9b03caa3a3/{latitude},{longitude}?exclude=minutely,hourly,daily,flags,alerts")
    retrofit2.Call<DadosClima> consulta();
}
