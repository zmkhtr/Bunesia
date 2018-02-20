package com.example.bunesia.Model;

/**
 * Created by acer on 2/18/2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelLagu {

    public static String id;
    @SerializedName("id_lagu")
    @Expose
    private String idLagu;
    @SerializedName("judul_lagu")
    @Expose
    private String judulLagu;
    @SerializedName("asal_lagu")
    @Expose
    private String asalLagu;
    @SerializedName("isi_lagu")
    @Expose
    private String isiLagu;
    @SerializedName("youtube_code")
    @Expose
    private String youtubeCode;
    @SerializedName("gambar_lagu")
    @Expose
    private String gambarLagu;
    @SerializedName("audio_lagu")
    @Expose
    private String audioLagu;
    @SerializedName("targetpic_lagu")
    @Expose
    private String targetpicLagu;
    @SerializedName("kategori_lagu")
    @Expose
    private String kategoriLagu;

    public ModelLagu(String idLagu, String gambarLagu, String judulLagu, String audioLagu, String asalLagu) {
        this.idLagu = idLagu;
        this.gambarLagu = gambarLagu;
        this.judulLagu = judulLagu;
        this.audioLagu = audioLagu;
        this.asalLagu = asalLagu;
    }

    public String getIdLagu() {
        return idLagu;
    }

    public void setIdLagu(String idLagu) {
        this.idLagu = idLagu;
    }

    public String getJudulLagu() {
        return judulLagu;
    }

    public void setJudulLagu(String judulLagu) {
        this.judulLagu = judulLagu;
    }

    public String getAsalLagu() {
        return asalLagu;
    }

    public void setAsalLagu(String asalLagu) {
        this.asalLagu = asalLagu;
    }

    public String getIsiLagu() {
        return isiLagu;
    }

    public void setIsiLagu(String isiLagu) {
        this.isiLagu = isiLagu;
    }

    public String getYoutubeCode() {
        return youtubeCode;
    }

    public void setYoutubeCode(String youtubeCode) {
        this.youtubeCode = youtubeCode;
    }

    public String getGambarLagu() {
        return gambarLagu;
    }

    public void setGambarLagu(String gambarLagu) {
        this.gambarLagu = gambarLagu;
    }

    public String getAudioLagu() {
        return audioLagu;
    }

    public void setAudioLagu(String audioLagu) {
        this.audioLagu = audioLagu;
    }

    public String getTargetpicLagu() {
        return targetpicLagu;
    }

    public void setTargetpicLagu(String targetpicLagu) {
        this.targetpicLagu = targetpicLagu;
    }

    public String getKategoriLagu() {
        return kategoriLagu;
    }

    public void setKategoriLagu(String kategoriLagu) {
        this.kategoriLagu = kategoriLagu;
    }

}
