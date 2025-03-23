package com.mycompany.tugas_pertemuan3;

public class Film {
    private int idFilm;
    private String namaFilm;
    private String genreFilm;

    public Film(int idFilm, String namaFilm, String genreFilm) {
        this.idFilm = idFilm;
        this.namaFilm = namaFilm;
        this.genreFilm = genreFilm;
    }

    public Film(String namaFilm, String genreFilm) {
        this.namaFilm = namaFilm;
        this.genreFilm = genreFilm;
    }

    // Getters and Setters
    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public String getNamaFilm() {
        return namaFilm;
    }

    public void setNamaFilm(String namaFilm) {
        this.namaFilm = namaFilm;
    }

    public String getGenreFilm() {
        return genreFilm;
    }

    public void setGenreFilm(String genreFilm) {
        this.genreFilm = genreFilm;
    }

    @Override
    public String toString() {
        return "Film{" +
                "idFilm=" + idFilm +
                ", namaFilm='" + namaFilm + '\'' +
                ", genreFilm='" + genreFilm + '\'' +
                '}';
    }
}