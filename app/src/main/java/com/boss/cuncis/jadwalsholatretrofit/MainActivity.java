package com.boss.cuncis.jadwalsholatretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.boss.cuncis.jadwalsholatretrofit.api.ApiClient;
import com.boss.cuncis.jadwalsholatretrofit.api.ApiInterface;
import com.boss.cuncis.jadwalsholatretrofit.model.Item;
import com.boss.cuncis.jadwalsholatretrofit.model.ItemResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView tvSubuh, tvDuhur, tvAshar, tvMaghrib, tvIsya;
    Button btnLoadData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initListener() {
        btnLoadData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
                Call<ItemResponse> call = apiService.getJadwalSholat("surabaya");
                call.enqueue(new Callback<ItemResponse>() {
                    @Override
                    public void onResponse(Call<ItemResponse> call, Response<ItemResponse> response) {
                        List<Item> items = response.body().getItems();
                        loadData(items);
                    }

                    @Override
                    public void onFailure(Call<ItemResponse> call, Throwable t) {

                    }
                });
            }
        });
    }

    private void loadData(List<Item> items) {
        for (Item data: items) {
            tvSubuh.setText(data.getShurooq());
            tvDuhur.setText(data.getDhuhr());
            tvAshar.setText(data.getAsr());
            tvMaghrib.setText(data.getMaghrib());
            tvIsya.setText(data.getIsha());
        }
    }

    private void initView() {
        tvSubuh = findViewById(R.id.tvSubuh);
        tvDuhur = findViewById(R.id.tvZuhur);
        tvAshar = findViewById(R.id.tvAshar);
        tvMaghrib = findViewById(R.id.tvMagrhib);
        tvIsya = findViewById(R.id.tvIsya);

        btnLoadData = findViewById(R.id.btnLoadData);
    }
}
