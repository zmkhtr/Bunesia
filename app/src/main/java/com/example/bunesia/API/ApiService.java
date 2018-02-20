package com.example.bunesia.API;

/**
 * Created by acer on 2/16/2018.
 */


import com.example.bunesia.Model.ModelAcara;
import com.example.bunesia.Model.ModelAlat;
import com.example.bunesia.Model.ModelCerita;
import com.example.bunesia.Model.ModelLagu;
import com.example.bunesia.Model.ModelPakaian;
import com.example.bunesia.Model.ModelRumah;
import com.example.bunesia.Model.ModelSenjata;
import com.example.bunesia.Model.ModelTanya;
import com.example.bunesia.Model.ModelTari;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface ApiService {

    @GET("content_cerita.php")
    Call<List<ModelCerita>> getSemuaContentCerita();

    @GET("content_cerita_single.php")
    Call<List<ModelCerita>> getSingleDataCerita(@Query("id") String id);

    @GET("content_alat.php")
    Call<List<ModelAlat>> getSemuaContentAlat();

    @GET("content_alat_single.php")
    Call<List<ModelAlat>> getSingleDataAlat(@Query("id") String id);

    @GET("content_lagu.php")
    Call<List<ModelLagu>> getSemuaContentLagu();

    @GET("content_lagu_single.php")
    Call<List<ModelLagu>> getSingleDataLagu(@Query("id") String id);

    @GET("content_tari.php")
    Call<List<ModelTari>> getSemuaContentTari();

    @GET("content_tari_single.php")
    Call<List<ModelTari>> getSingleDataTari(@Query("id") String id);

    @GET("content_pakaian.php")
    Call<List<ModelPakaian>> getSemuaContentPakaian();

    @GET("content_pakaian_single.php")
    Call<List<ModelPakaian>> getSingleDataPakaian(@Query("id") String id);

    @GET("content_senjata.php")
    Call<List<ModelSenjata>> getSemuaContentSenjata();

    @GET("content_senjata_single.php")
    Call<List<ModelSenjata>> getSingleDataSenjata(@Query("id") String id);

    @GET("content_rumah.php")
    Call<List<ModelRumah>> getSemuaContentRumah();

    @GET("content_rumah_single.php")
    Call<List<ModelRumah>> getSingleDataRumah(@Query("id") String id);

    @GET("content_acara.php")
    Call<List<ModelAcara>> getSemuaContentAcara();

    @GET("content_acara_single.php")
    Call<List<ModelAcara>> getSingleDataAcara(@Query("id") String id);

    @FormUrlEncoded
    @POST("tambah_pertanyaan.php")
    Call<ResponseBody> tambahPertanyaan(@Field("nama") String nama, @Field("pertanyaan") String pertanyaan, @Field("jawaban") String jawaban);

    @GET("content_tanya.php")
    Call<List<ModelTanya>> getSemuaContentTanya();

}
