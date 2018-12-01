package com.example.jorda.provasub2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.widget.ImageView;

import com.example.jorda.provasub2.Model.DadosClima;
import com.example.jorda.provasub2.Service.InterfaceDeServicos;
import com.example.jorda.provasub2.Service.RetrofitService;

import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       ImprimeImagem();
    }

    private void ImprimeImagem() {

        /*Esta classe imprime a imagem a partir de parte do jason recebido pela busca retrofit */

        InterfaceDeServicos service = RetrofitService.getServico();
        retrofit2.Call<DadosClima> call = service.consulta();

        call.enqueue(new Callback<DadosClima>() {
            @Override
            public void onResponse(retrofit2.Call<DadosClima> call, Response<DadosClima> response) {
                //pega o conteúdo do corpo do do resultado - incluindo todos os dados da busca
                DadosClima dadosClima = response.body();

                //seleciona a parte que interessa e passa a busca o valor para a imagem ser alterada
                ImprimeImagem(String );
            }

            @Override
            public void onFailure(retrofit2.Call<DadosClima> call, Throwable t) {
                Log.i("debug", t.getMessage());
            }
        });

    }
        public void ImprimeImagem(){
            ImageView imagem = (ImageView) findViewById(R.id.imagemClima);


            String i = "aaaaa";  //Relacionar com os dados recebidos pelo servico
            if (i.equals("rain")){
                imagem.setImageResource(R.drawable.rain);
            }
            else if (i.equals("clear-day")){
                imagem.setImageResource(R.drawable.clearday);
            }
            else if (i.equals("clear-night")){
                imagem.setImageResource(R.drawable.clearnight);
            }
            else if (i.equals("snow")){
                imagem.setImageResource(R.drawable.snow);
            }
            else if (i.equals("sleet")){
                imagem.setImageResource(R.drawable.sleet);
            }
            else if (i.equals("wind")){
                imagem.setImageResource(R.drawable.wind);
            }
            else if (i.equals("fog")){
                imagem.setImageResource(R.drawable.fog);
            }
            else if (i.equals("cloudy")){
                imagem.setImageResource(R.drawable.cloud);
            }
            else if (i.equals("partly-cloudy-night")){
                imagem.setImageResource(R.drawable.partlycloudynight);
            }
            else if (i.equals("partly-cloudy-day")){
                imagem.setImageResource(R.drawable.partlycloudyday);
            }
        }
}
