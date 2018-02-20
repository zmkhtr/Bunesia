package com.example.bunesia.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelTanya {

    @SerializedName("id_tanya")
    @Expose
    private String idTanya;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("pertanyaan")
    @Expose
    private String pertanyaan;
    @SerializedName("jawaban")
    @Expose
    private String jawaban;


    public ModelTanya(String nama, String pertanyaan, String jawaban) {
        this.nama = nama;
        this.pertanyaan = pertanyaan;
        this.jawaban = jawaban;
    }

    public String getIdTanya() {
        return idTanya;
    }

    public void setIdTanya(String idTanya) {
        this.idTanya = idTanya;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPertanyaan() {
        return pertanyaan;
    }

    public void setPertanyaan(String pertanyaan) {
        this.pertanyaan = pertanyaan;
    }

    public String getJawaban() {
        return jawaban;
    }

    public void setJawaban(String jawaban) {
        this.jawaban = jawaban;
    }

}