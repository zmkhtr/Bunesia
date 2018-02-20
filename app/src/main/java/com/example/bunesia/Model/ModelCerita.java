package com.example.bunesia.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelCerita {

    public static String id;
    @SerializedName("id_cerita")
    @Expose
    private String idCerita;
    @SerializedName("judul_cerita")
    @Expose
    private String judulCerita;
    @SerializedName("asal_cerita")
    @Expose
    private String asalCerita;
    @SerializedName("isi_cerita")
    @Expose
    private String isiCerita;
    @SerializedName("gambar_cerita")
    @Expose
    private String gambarCerita;
    @SerializedName("audio_cerita")
    @Expose
    private String audioCerita;
    @SerializedName("targetpic_cerita")
    @Expose
    private String targetpicCerita;
    @SerializedName("kategori_cerita")
    @Expose
    private String kategoriCerita;

    public ModelCerita(String idCerita, String gambarCerita, String judulCerita, String audioCerita, String asalCerita) {
        this.idCerita = idCerita;
        this.gambarCerita = gambarCerita;
        this.judulCerita = judulCerita;
        this.asalCerita = asalCerita;
        this.audioCerita = audioCerita;
    }


    public String getIdCerita() {
        return idCerita;
    }

    public void setIdCerita(String idCerita) {
        this.idCerita = idCerita;
    }

    public String getJudulCerita() {
        return judulCerita;
    }

    public void setJudulCerita(String judulCerita) {
        this.judulCerita = judulCerita;
    }

    public String getAsalCerita() {
        return asalCerita;
    }

    public void setAsalCerita(String asalCerita) {
        this.asalCerita = asalCerita;
    }

    public String getIsiCerita() {
        return isiCerita;
    }

    public void setIsiCerita(String isiCerita) {
        this.isiCerita = isiCerita;
    }

    public String getGambarCerita() {
        return gambarCerita;
    }

    public void setGambarCerita(String gambarCerita) {
        this.gambarCerita = gambarCerita;
    }

    public String getAudioCerita() {
        return audioCerita;
    }

    public void setAudioCerita(String audioCerita) {
        this.audioCerita = audioCerita;
    }

    public String getTargetpicCerita() {
        return targetpicCerita;
    }

    public void setTargetpicCerita(String targetpicCerita) {
        this.targetpicCerita = targetpicCerita;
    }

    public String getKategoriCerita() {
        return kategoriCerita;
    }

    public void setKategoriCerita(String kategoriCerita) {
        this.kategoriCerita = kategoriCerita;
    }

}