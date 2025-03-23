package com.mycompany.tugas_pertemuan3;

import com.mycompany.tugas_pertemuan3.DatabaseConnection;
import com.mycompany.tugas_pertemuan3.Transaksi;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransaksiOperations {
    private Connection connection;

    public TransaksiOperations() throws SQLException {
        connection = DatabaseConnection.getConnection(); 
    }

    public void addTransaksi(Transaksi transaksi) {
        String query = "INSERT INTO transaksi (id_film, jumlah_ticket) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, transaksi.getIdFilm());
            stmt.setInt(2, transaksi.getJumlahTicket());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    transaksi.setIdPemesanan(generatedKeys.getInt(1)); 
                } else {
                    System.out.println("Tidak ada ID pemesanan yang dihasilkan.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error saat menambahkan transaksi:");
            e.printStackTrace();
        }
    }

        public List<Transaksi> getAllTransaksi() {
        List<Transaksi> transaksiList = new ArrayList<>();
        String query = "SELECT * FROM transaksi";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                int idPemesanan = rs.getInt("id_pemesanan");
                int idFilm = rs.getInt("id_film");
                int jumlahTicket = rs.getInt("jumlah_ticket");
                Transaksi transaksi = new Transaksi(idFilm, jumlahTicket);
                transaksi.setIdPemesanan(idPemesanan); 
                transaksiList.add(transaksi);
            }
            System.out.println("Jumlah transaksi yang ditemukan: " + transaksiList.size());
        } catch (SQLException e) {
            System.out.println("Error saat mengambil data transaksi:");
            e.printStackTrace();
        }
        return transaksiList;
    }
    }
