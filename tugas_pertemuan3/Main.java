package com.mycompany.tugas_pertemuan3;

import com.mycompany.tugas_pertemuan3.Film;
import com.mycompany.tugas_pertemuan3.FilmOperations;
import com.mycompany.tugas_pertemuan3.Transaksi;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Transaksi> transaksiList = new ArrayList<>();
    
    public static void main(String[] args) {
        try {
            FilmOperations filmOperations = new FilmOperations();
            Scanner scanner = new Scanner(System.in);
            int choice;
            do {
                System.out.println("\n--- Menu Bioskop ---");
                System.out.println("1. Tambahkan Film");
                System.out.println("2. Lihat Semua Film");
                System.out.println("3. Beli Tiket");
                System.out.println("4. Lihat Data Transaksi");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1:
                        System.out.print("Masukkan Nama Film: ");
                        String namaFilm = scanner.nextLine();
                        System.out.print("Masukkan Genre Film: ");
                        String genreFilm = scanner.nextLine();
                        filmOperations.addFilm(new Film(namaFilm, genreFilm));
                        break;

                    case 2:
                        System.out.println("Lihat Semua Film:");
                        filmOperations.getFilms().forEach(System.out::println);
                        break;

                    case 3:         
                      System.out.print("Masukkan ID Film: ");
                      int idFilm = scanner.nextInt();
                      System.out.print("Masukkan Jumlah Tiket: ");
                      int jumlahTicket = scanner.nextInt();

                      Transaksi transaksi = new Transaksi(idFilm, jumlahTicket);

                      try {
                          TransaksiOperations transaksiOperations = new TransaksiOperations();
                          transaksiOperations.addTransaksi(transaksi);
                          System.out.println("Transaksi berhasil ditambahkan! ID Pemesanan: " + transaksi.getIdPemesanan());
                          transaksiList.add(transaksi); 
                      } catch (SQLException e) {
                          System.out.println("Gagal menambahkan transaksi:");
                          e.printStackTrace();
                      }
                      break;

                    case 4:
                      System.out.println("Data Transaksi:");
                      try {
                          TransaksiOperations transaksiOperations = new TransaksiOperations();
                          List<Transaksi> daftarTransaksi = transaksiOperations.getAllTransaksi();

                          if (daftarTransaksi.isEmpty()) {
                              System.out.println("Tidak ada transaksi yang tersedia.");
                          } else {
                              daftarTransaksi.forEach(System.out::println);
                          }
                      } catch (SQLException e) {
                          System.out.println("Gagal mengambil data transaksi:");
                          e.printStackTrace();
                      }
                      break;
                    case 0:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } while (choice != 0);

            scanner.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}