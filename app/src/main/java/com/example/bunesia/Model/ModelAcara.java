package com.example.bunesia.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelAcara {

    public static String id;
    @SerializedName("id_acara")
    @Expose
    private String idAcara;
    @SerializedName("judul_acara")
    @Expose
    private String judulAcara;
    @SerializedName("asal_acara")
    @Expose
    private String asalAcara;
    @SerializedName("isi_acara")
    @Expose
    private String isiAcara;
    @SerializedName("youtube_code")
    @Expose
    private String youtubeCode;
    @SerializedName("gambar_acara")
    @Expose
    private String gambarAcara;
    @SerializedName("audio_acara")
    @Expose
    private String audioAcara;
    @SerializedName("targetpic_acara")
    @Expose
    private String targetpicAcara;
    @SerializedName("kategori_acara")
    @Expose
    private String kategoriAcara;

    public ModelAcara(String idAcara, String gambarAcara, String judulAcara, String targetpicAcara, String asalAcara) {
        this.idAcara = idAcara;
        this.gambarAcara = gambarAcara;
        this.judulAcara = judulAcara;
        this.targetpicAcara = targetpicAcara;
        this.asalAcara = asalAcara;
    }

    public String getIdAcara() {
        return idAcara;
    }

    public void setIdAcara(String idAcara) {
        this.idAcara = idAcara;
    }

    public String getJudulAcara() {
        return judulAcara;
    }

    public void setJudulAcara(String judulAcara) {
        this.judulAcara = judulAcara;
    }

    public String getAsalAcara() {
        return asalAcara;
    }

    public void setAsalAcara(String asalAcara) {
        this.asalAcara = asalAcara;
    }

    public String getIsiAcara() {
        return isiAcara;
    }

    public void setIsiAcara(String isiAcara) {
        this.isiAcara = isiAcara;
    }

    public String getYoutubeCode() {
        return youtubeCode;
    }

    public void setYoutubeCode(String youtubeCode) {
        this.youtubeCode = youtubeCode;
    }

    public String getGambarAcara() {
        return gambarAcara;
    }

    public void setGambarAcara(String gambarAcara) {
        this.gambarAcara = gambarAcara;
    }

    public String getAudioAcara() {
        return audioAcara;
    }

    public void setAudioAcara(String audioAcara) {
        this.audioAcara = audioAcara;
    }

    public String getTargetpicAcara() {
        return targetpicAcara;
    }

    public void setTargetpicAcara(String targetpicAcara) {
        this.targetpicAcara = targetpicAcara;
    }

    public String getKategoriAcara() {
        return kategoriAcara;
    }

    public void setKategoriAcara(String kategoriAcara) {
        this.kategoriAcara = kategoriAcara;
    }

}