package com.example.jorda.provasub2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.jorda.provasub2.Model.Currently;
import com.example.jorda.provasub2.Model.Exemple;
import com.example.jorda.provasub2.Service.InterfaceDeServicos;
import com.example.jorda.provasub2.Service.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button bt;
    EditText lat;
    EditText longi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = (Button) findViewById(R.id.consuta_clima);
        lat = (EditText) findViewById(R.id.latitude);
        longi = (EditText) findViewById(R.id.longitude);
    }

    public void consulta(View v) {
        final double latitudes = Double.parseDouble(lat.getText().toString());
        final double longitudes = Double.parseDouble(longi.getText().toString());
        Call<Exemple> call = RetrofitService.getServico().consulta(latitudes, longitudes);
        call.enqueue(new Callback<Exemple>() {
            @Override
            public void onResponse(Call<Exemple> call, Response<Exemple> response) {
                //pega o conteúdo do corpo do do resultado - incluindo todos os dados da busca
                Exemple dadosClima = response.body();

                ImageView imagem = (ImageView) findViewById(R.id.imagemClima);

                String i = dadosClima.getCurrently().getIcon();
                Log.i("teste", "icon: " + i);

                //Relacionar com os dados recebidos pelo servico
                if (i.equals("rain")) {
                    imagem.setImageResource(R.drawable.rain);
                } else if (i.equals("clear-day")) {
                    imagem.setImageResource(R.drawable.clearday);
                } else if (i.equals("clear-night")) {
                    imagem.setImageResource(R.drawable.clearnight);
                } else if (i.equals("snow")) {
                    imagem.setImageResource(R.drawable.snow);
                } else if (i.equals("sleet")) {
                    imagem.setImageResource(R.drawable.sleet);
                } else if (i.equals("wind")) {
                    imagem.setImageResource(R.drawable.wind);
                } else if (i.equals("fog")) {
                    imagem.setImageResource(R.drawable.fog);
                } else if (i.equals("cloudy")) {
                    imagem.setImageResource(R.drawable.cloud);
                } else if (i.equals("partly-cloudy-night")) {
                    imagem.setImageResource(R.drawable.partlycloudynight);
                } else if (i.equals("partly-cloudy-day")) {
                    imagem.setImageResource(R.drawable.partlycloudyday);
                }
            }

            @Override
            public void onFailure(Call<Exemple> call, Throwable t) {
                Log.i("debug", t.getMessage());
            }
        });
    }
}
