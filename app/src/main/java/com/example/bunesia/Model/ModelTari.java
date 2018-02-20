package com.example.bunesia.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelTari {

    public static String id;
    @SerializedName("id_tari")
    @Expose
    private String idTari;
    @SerializedName("judul_tari")
    @Expose
    private String judulTari;
    @SerializedName("asal_tari")
    @Expose
    private String asalTari;
    @SerializedName("isi_tari")
    @Expose
    private String isiTari;
    @SerializedName("youtube_code")
    @Expose
    private String youtubeCode;
    @SerializedName("gambar_tari")
    @Expose
    private String gambarTari;
    @SerializedName("audio_tari")
    @Expose
    private String audioTari;
    @SerializedName("targetpic_tari")
    @Expose
    private String targetpicTari;
    @SerializedName("kategori_tari")
    @Expose
    private String kategoriTari;



    public ModelTari(String idTari, String gambarTari, String judulTari, String audioTari, String asalTari) {
        this.idTari = idTari;
        this.gambarTari = gambarTari;
        this.judulTari = judulTari;
        this.audioTari = audioTari;
        this.asalTari = asalTari;
    }


    public String getIdTari() {
        return idTari;
    }

    public void setIdTari(String idTari) {
        this.idTari = idTari;
    }

    public String getJudulTari() {
        return judulTari;
    }

    public void setJudulTari(String judulTari) {
        this.judulTari = judulTari;
    }

    public String getAsalTari() {
        return asalTari;
    }

    public void setAsalTari(String asalTari) {
        this.asalTari = asalTari;
    }

    public String getIsiTari() {
        return isiTari;
    }

    public void setIsiTari(String isiTari) {
        this.isiTari = isiTari;
    }

    public String getYoutubeCode() {
        return youtubeCode;
    }

    public void setYoutubeCode(String youtubeCode) {
        this.youtubeCode = youtubeCode;
    }

    public String getGambarTari() {
        return gambarTari;
    }

    public void setGambarTari(String gambarTari) {
        this.gambarTari = gambarTari;
    }

    public String getAudioTari() {
        return audioTari;
    }

    public void setAudioTari(String audioTari) {
        this.audioTari = audioTari;
    }

    public String getTargetpicTari() {
        return targetpicTari;
    }

    public void setTargetpicTari(String targetpicTari) {
        this.targetpicTari = targetpicTari;
    }

    public String getKategoriTari() {
        return kategoriTari;
    }

    public void setKategoriTari(String kategoriTari) {
        this.kategoriTari = kategoriTari;
    }

}