package com.mycompany.tugas_pertemuan3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmOperations {
    private Connection connection;

    public FilmOperations() throws SQLException {
        connection = DatabaseConnection.getConnection();
    }

    // Create
    public void addFilm(Film film) {
        String query = "INSERT INTO film (nama_film, genre_film) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, film.getNamaFilm());
            stmt.setString(2, film.getGenreFilm());
            stmt.executeUpdate();
            System.out.println("Film added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read
    public List<Film> getFilms() {
        List<Film> films = new ArrayList<>();
        String query = "SELECT * FROM film"; // Ganti dari films menjadi film
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                films.add(new Film(
                        rs.getInt("id_film"),
                        rs.getString("nama_film"),
                        rs.getString("genre_film")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return films;
    }

    // Update
    public void updateFilm(int idFilm, String newNamaFilm, String newGenreFilm) {
        String query = "UPDATE film SET nama_film = ?, genre_film = ? WHERE id_film = ?"; // Ganti dari films menjadi film
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, newNamaFilm);
            stmt.setString(2, newGenreFilm);
            stmt.setInt(3, idFilm);
            stmt.executeUpdate();
            System.out.println("Film updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void deleteFilm(int idFilm) {
        String query = "DELETE FROM film WHERE id_film = ?"; // Ganti dari films menjadi film
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idFilm);
            stmt.executeUpdate();
            System.out.println("Film deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}