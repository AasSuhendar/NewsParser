/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testpreprocessing;

import java.util.List;



/**
 *
 * @author Basis Data
 */
public class News {
     String isi;
     String url;
     String penulis;
     String Tanggal;
     String judul;

    public News() {
    }

    public News(String isi, String url, String penulis, String Tanggal, String judul) {
        this.isi = isi;
        this.url = url;
        this.penulis = penulis;
        this.Tanggal = Tanggal;
        this.judul = judul;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public String getUrl() {
        return url;
    }

    public String getPenulis() {
        return penulis;
    }

    public String getTanggal() {
        return Tanggal;
    }

    

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public void setTanggal(String Tanggal) {
        this.Tanggal = Tanggal;
    }
     
    
}
