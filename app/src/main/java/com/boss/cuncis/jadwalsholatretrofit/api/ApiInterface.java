package com.boss.cuncis.jadwalsholatretrofit.api;

import com.boss.cuncis.jadwalsholatretrofit.model.Item;
import com.boss.cuncis.jadwalsholatretrofit.model.ItemResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET("{periode}/dayli.json")
    Call<ItemResponse> getJadwalSholat(@Path("periode") String periode);
}
