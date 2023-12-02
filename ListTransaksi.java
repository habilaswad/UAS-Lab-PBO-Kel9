import java.util.*;

/**
 * Kelas ListTransaksi yang menyimpan daftar transaksi dan invoice dalam sistem.
 * @author Muhammad Habil Aswad
 */
public class ListTransaksi {
  private static ListTransaksi instance;
  private List < Transaksi > daftarTransaksi;
  private List < Invoice > listTransaksi = new ArrayList < > ();

  /**
   * Konstruktor privat yang digunakan untuk membuat objek {@code ListTransaksi}.
   * Daftar transaksi dan list invoice diinisialisasi sebagai objek ArrayList.
   */
  private ListTransaksi() {
    daftarTransaksi = new ArrayList < > ();
  }

  /**
   * Metode untuk mendapatkan instance tunggal dari {@code ListTransaksi}.
   * Jika instance belum ada, maka akan dibuat instance baru.
   * @return Instance tunggal dari {@code ListTransaksi}.
   */
  public static ListTransaksi getInstance() {
    if (instance == null) {
      instance = new ListTransaksi();
    }
    return instance;
  }

  /**
   * Metode untuk mendapatkan daftar transaksi dalam sistem.
   * @return List berisi objek-objek {@code Transaksi}.
   */
  public List < Transaksi > getDaftarTransaksi() {
    return daftarTransaksi;
  }

  /**
   * Metode untuk mendapatkan list invoice dalam sistem.
   * @return List berisi objek-objek {@code Invoice}.
   */
  public List < Invoice > getListTransaksi() {
    return listTransaksi;
  }

  /**
   * Metode untuk menambahkan objek {@code Invoice} ke dalam list invoice.
   * @param invoice Objek {@code Invoice} yang akan ditambahkan.
   */
  public void addInvoice(Invoice invoice) {
    listTransaksi.add(invoice);
  }
}