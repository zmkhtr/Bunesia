package com.example.bunesia.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelAlat {

    public static String id;
    @SerializedName("id_alat")
    @Expose
    private String idAlat;
    @SerializedName("judul_alat")
    @Expose
    private String judulAlat;
    @SerializedName("asal_alat")
    @Expose
    private String asalAlat;
    @SerializedName("isi_alat")
    @Expose
    private String isiAlat;
    @SerializedName("youtube_code")
    @Expose
    private String youtubeCode;
    @SerializedName("gambar_alat")
    @Expose
    private String gambarAlat;
    @SerializedName("audio_alat")
    @Expose
    private String audioAlat;
    @SerializedName("targetpic_alat")
    @Expose
    private String targetpicAlat;
    @SerializedName("kategori_alat")
    @Expose
    private String kategoriAlat;

    public ModelAlat(String idAlat, String gambarAlat, String judulAlat, String audioAlat, String asalAlat) {
        this.idAlat = idAlat;
        this.gambarAlat = gambarAlat;
        this.judulAlat = judulAlat;
        this.audioAlat = audioAlat;
        this.asalAlat = asalAlat;
    }

    public String getIdAlat() {
        return idAlat;
    }

    public void setIdAlat(String idAlat) {
        this.idAlat = idAlat;
    }

    public String getJudulAlat() {
        return judulAlat;
    }

    public void setJudulAlat(String judulAlat) {
        this.judulAlat = judulAlat;
    }

    public String getAsalAlat() {
        return asalAlat;
    }

    public void setAsalAlat(String asalAlat) {
        this.asalAlat = asalAlat;
    }

    public String getIsiAlat() {
        return isiAlat;
    }

    public void setIsiAlat(String isiAlat) {
        this.isiAlat = isiAlat;
    }

    public String getYoutubeCode() {
        return youtubeCode;
    }

    public void setYoutubeCode(String youtubeCode) {
        this.youtubeCode = youtubeCode;
    }

    public String getGambarAlat() {
        return gambarAlat;
    }

    public void setGambarAlat(String gambarAlat) {
        this.gambarAlat = gambarAlat;
    }

    public String getAudioAlat() {
        return audioAlat;
    }

    public void setAudioAlat(String audioAlat) {
        this.audioAlat = audioAlat;
    }

    public String getTargetpicAlat() {
        return targetpicAlat;
    }

    public void setTargetpicAlat(String targetpicAlat) {
        this.targetpicAlat = targetpicAlat;
    }

    public String getKategoriAlat() {
        return kategoriAlat;
    }

    public void setKategoriAlat(String kategoriAlat) {
        this.kategoriAlat = kategoriAlat;
    }

}