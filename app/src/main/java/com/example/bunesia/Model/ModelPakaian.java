package com.example.bunesia.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelPakaian {

    public static String id;
    @SerializedName("id_pakaian")
    @Expose
    private String idPakaian;
    @SerializedName("judul_pakaian")
    @Expose
    private String judulPakaian;
    @SerializedName("asal_pakaian")
    @Expose
    private String asalPakaian;
    @SerializedName("isi_pakaian")
    @Expose
    private String isiPakaian;
    @SerializedName("youtube_code")
    @Expose
    private String youtubeCode;
    @SerializedName("gambar_pakaian")
    @Expose
    private String gambarPakaian;
    @SerializedName("audio_pakaian")
    @Expose
    private String audioPakaian;
    @SerializedName("targetpic_pakaian")
    @Expose
    private String targetpicPakaian;
    @SerializedName("kategori_pakaian")
    @Expose
    private String kategoriPakaian;

    public ModelPakaian(String idPakaian, String gambarPakaian, String judulPakaian, String targetpicPakaian, String asalPakaian) {
        this.idPakaian = idPakaian;
        this.gambarPakaian = gambarPakaian;
        this.judulPakaian = judulPakaian;
        this.targetpicPakaian = targetpicPakaian;
        this.asalPakaian = asalPakaian;
    }


    public String getIdPakaian() {
        return idPakaian;
    }

    public void setIdPakaian(String idPakaian) {
        this.idPakaian = idPakaian;
    }

    public String getJudulPakaian() {
        return judulPakaian;
    }

    public void setJudulPakaian(String judulPakaian) {
        this.judulPakaian = judulPakaian;
    }

    public String getAsalPakaian() {
        return asalPakaian;
    }

    public void setAsalPakaian(String asalPakaian) {
        this.asalPakaian = asalPakaian;
    }

    public String getIsiPakaian() {
        return isiPakaian;
    }

    public void setIsiPakaian(String isiPakaian) {
        this.isiPakaian = isiPakaian;
    }

    public String getYoutubeCode() {
        return youtubeCode;
    }

    public void setYoutubeCode(String youtubeCode) {
        this.youtubeCode = youtubeCode;
    }

    public String getGambarPakaian() {
        return gambarPakaian;
    }

    public void setGambarPakaian(String gambarPakaian) {
        this.gambarPakaian = gambarPakaian;
    }

    public String getAudioPakaian() {
        return audioPakaian;
    }

    public void setAudioPakaian(String audioPakaian) {
        this.audioPakaian = audioPakaian;
    }

    public String getTargetpicPakaian() {
        return targetpicPakaian;
    }

    public void setTargetpicPakaian(String targetpicPakaian) {
        this.targetpicPakaian = targetpicPakaian;
    }

    public String getKategoriPakaian() {
        return kategoriPakaian;
    }

    public void setKategoriPakaian(String kategoriPakaian) {
        this.kategoriPakaian = kategoriPakaian;
    }

}