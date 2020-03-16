package com.dicoding.sarjanasantuy.belajardatabase;

public class MahasiswaModel {
    private String Nama;
    private String Alamat;
    private char Jkel;

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String alamat) {
        Alamat = alamat;
    }

    public char getJkel() {
        return Jkel;
    }

    public void setJkel(char jkel) {
        Jkel = jkel;
    }

    public MahasiswaModel(String Nama, String Alamat, char Jkel){
        this.Nama = Nama;
        this.Alamat = Alamat;
        this.Jkel = Jkel;
    }
}
