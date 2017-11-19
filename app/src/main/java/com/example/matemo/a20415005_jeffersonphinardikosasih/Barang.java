package com.example.matemo.a20415005_jeffersonphinardikosasih;

/**
 * Created by Matemo on 9/21/2017.
 */

public class Barang {
    String nama, harga, id;
    int img;

    public Barang(String nama, String harga, int img, String id)
    {
        this.nama=nama;
        this.harga=harga;
        this.img=img;
        this.id=id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

