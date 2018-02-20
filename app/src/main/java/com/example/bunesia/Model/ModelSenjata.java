package com.example.bunesia.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelSenjata {

    public static String id;
    @SerializedName("id_senjata")
    @Expose
    private String idSenjata;
    @SerializedName("judul_senjata")
    @Expose
    private String judulSenjata;
    @SerializedName("asal_senjata")
    @Expose
    private String asalSenjata;
    @SerializedName("isi_senjata")
    @Expose
    private String isiSenjata;
    @SerializedName("youtube_code")
    @Expose
    private String youtubeCode;
    @SerializedName("gambar_senjata")
    @Expose
    private String gambarSenjata;
    @SerializedName("audio_senjata")
    @Expose
    private String audioSenjata;
    @SerializedName("targetpic_senjata")
    @Expose
    private String targetpicSenjata;
    @SerializedName("kategori_senjata")
    @Expose
    private String kategoriSenjata;

    public ModelSenjata(String idSenjata, String gambarSenjata, String judulSenjata, String targetpicSenjata, String asalSenjata) {
        this.idSenjata = idSenjata;
        this.gambarSenjata = gambarSenjata;
        this.judulSenjata = judulSenjata;
        this.targetpicSenjata = targetpicSenjata;
        this.asalSenjata = asalSenjata;
    }

    public String getIdSenjata() {
        return idSenjata;
    }

    public void setIdSenjata(String idSenjata) {
        this.idSenjata = idSenjata;
    }

    public String getJudulSenjata() {
        return judulSenjata;
    }

    public void setJudulSenjata(String judulSenjata) {
        this.judulSenjata = judulSenjata;
    }

    public String getAsalSenjata() {
        return asalSenjata;
    }

    public void setAsalSenjata(String asalSenjata) {
        this.asalSenjata = asalSenjata;
    }

    public String getIsiSenjata() {
        return isiSenjata;
    }

    public void setIsiSenjata(String isiSenjata) {
        this.isiSenjata = isiSenjata;
    }

    public String getYoutubeCode() {
        return youtubeCode;
    }

    public void setYoutubeCode(String youtubeCode) {
        this.youtubeCode = youtubeCode;
    }

    public String getGambarSenjata() {
        return gambarSenjata;
    }

    public void setGambarSenjata(String gambarSenjata) {
        this.gambarSenjata = gambarSenjata;
    }

    public String getAudioSenjata() {
        return audioSenjata;
    }

    public void setAudioSenjata(String audioSenjata) {
        this.audioSenjata = audioSenjata;
    }

    public String getTargetpicSenjata() {
        return targetpicSenjata;
    }

    public void setTargetpicSenjata(String targetpicSenjata) {
        this.targetpicSenjata = targetpicSenjata;
    }

    public String getKategoriSenjata() {
        return kategoriSenjata;
    }

    public void setKategoriSenjata(String kategoriSenjata) {
        this.kategoriSenjata = kategoriSenjata;
    }

}