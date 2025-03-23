/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tugas_pertemuan3;

/**
 *
 * @author LENOVO
 */
public class Transaksi {
    private int idPemesanan;
    private int idFilm;
    private int jumlahTicket;

    
    public Transaksi(int idFilm, int jumlahTicket) {
        this.idFilm = idFilm;
        this.jumlahTicket = jumlahTicket;
        this.idPemesanan = 0; 
    }

    // Getter dan Setter
    public int getIdPemesanan() {
        return idPemesanan;
    }

    public void setIdPemesanan(int idPemesanan) {
        this.idPemesanan = idPemesanan;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public int getJumlahTicket() {
        return jumlahTicket;
    }

    public void setJumlahTicket(int jumlahTicket) {
        this.jumlahTicket = jumlahTicket;
    }

    @Override
    public String toString() {
        return "Transaksi{" +
                "idPemesanan=" + idPemesanan +
                ", idFilm=" + idFilm +
                ", jumlahTicket=" + jumlahTicket +
                '}';
    }
}

