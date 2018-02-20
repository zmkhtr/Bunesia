package com.example.bunesia.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelRumah {

    public static String id;
    @SerializedName("id_rumah")
    @Expose
    private String idRumah;
    @SerializedName("judul_rumah")
    @Expose
    private String judulRumah;
    @SerializedName("asal_rumah")
    @Expose
    private String asalRumah;
    @SerializedName("isi_rumah")
    @Expose
    private String isiRumah;
    @SerializedName("youtube_code")
    @Expose
    private String youtubeCode;
    @SerializedName("gambar_rumah")
    @Expose
    private String gambarRumah;
    @SerializedName("audio_rumah")
    @Expose
    private String audioRumah;
    @SerializedName("targetpic_rumah")
    @Expose
    private String targetpicRumah;
    @SerializedName("kategori_rumah")
    @Expose
    private String kategoriRumah;

    public ModelRumah(String idRumah, String gambarRumah, String judulRumah, String targetpicRumah, String asalRumah) {
        this.idRumah = idRumah;
        this.gambarRumah = gambarRumah;
        this.judulRumah = judulRumah;
        this.targetpicRumah = targetpicRumah;
        this.asalRumah = asalRumah;
    }

    public String getIdRumah() {
        return idRumah;
    }

    public void setIdRumah(String idRumah) {
        this.idRumah = idRumah;
    }

    public String getJudulRumah() {
        return judulRumah;
    }

    public void setJudulRumah(String judulRumah) {
        this.judulRumah = judulRumah;
    }

    public String getAsalRumah() {
        return asalRumah;
    }

    public void setAsalRumah(String asalRumah) {
        this.asalRumah = asalRumah;
    }

    public String getIsiRumah() {
        return isiRumah;
    }

    public void setIsiRumah(String isiRumah) {
        this.isiRumah = isiRumah;
    }

    public String getYoutubeCode() {
        return youtubeCode;
    }

    public void setYoutubeCode(String youtubeCode) {
        this.youtubeCode = youtubeCode;
    }

    public String getGambarRumah() {
        return gambarRumah;
    }

    public void setGambarRumah(String gambarRumah) {
        this.gambarRumah = gambarRumah;
    }

    public String getAudioRumah() {
        return audioRumah;
    }

    public void setAudioRumah(String audioRumah) {
        this.audioRumah = audioRumah;
    }

    public String getTargetpicRumah() {
        return targetpicRumah;
    }

    public void setTargetpicRumah(String targetpicRumah) {
        this.targetpicRumah = targetpicRumah;
    }

    public String getKategoriRumah() {
        return kategoriRumah;
    }

    public void setKategoriRumah(String kategoriRumah) {
        this.kategoriRumah = kategoriRumah;
    }

}