import java.util.*;

/**
 * Kelas Transaksi yang mengurus jalannya transaksi yang akan dilakukan customer
 * @author Muhammad Habil Aswad
 */
public class Transaksi {
  public String id;
  public Akun customer;
  public ArrayList < Barang > barang;
  public Pembayaran bayar;
  public Invoice invoice;
  public boolean statusPemesanan = false;
  public String metode;
  public static int i = -1;
  private Date tanggal;

  /**
   * Konstruktor untuk membuat objek Transaksi dengan informasi pelanggan dan daftar barang.
   * Setiap transaksi memiliki identifikasi unik yang disusun dari kata "customer" dan nomor urut.
   * Tanggal transaksi diinisialisasi sebagai waktu pembuatan objek.
   * @param customer Objek Akun yang mewakili pelanggan yang melakukan transaksi.
   * @param barang Daftar barang yang dibeli dalam transaksi.
   */
  public Transaksi(Akun customer, ArrayList < Barang > barang) {
    this.customer = customer;
    this.barang = barang;
    this.id = "customer" + (i++);
    this.tanggal = new Date();
  }

  /**
   * Menampilkan detail keranjang, termasuk nama barang, jumlah, harga satuan, dan total harga.
   */
  public void DetailKeranjang() {
    System.out.println("\nDaftar barang di keranjang:");
    System.out.println("NO   Item\t\tJumlah\t\tHarga Satuan\t\tTotal");
    int totalBelanja = 0;
    for (Barang barang: this.barang) {
      System.out.println((this.barang.indexOf(barang) + 1) + ".   " + barang.getNama() + "\t\t" + barang.getStock() + "\t\t" + barang.getHarga() + "\t\t\t" + barang.getHarga() * barang.getStock());
      totalBelanja += barang.getHarga() * barang.getStock();
    }
    System.out.println("TOTAL BELANJA: " + totalBelanja + "\n");
  }

  /**
   * Menampilkan detail pemesanan, termasuk nomor item, nama barang, jumlah, harga satuan, dan total harga.
   */
  public void DetailPemesanan() {
    System.out.println("\n+=======================================================================+");
    System.out.println("+                             HISTORY TRANSAKSI                         +");
    System.out.println("+=======================================================================+");
    System.out.println("+ NO  | Item            | Jumlah | Harga Satuan |       Total           +");
    int totalBelanja = 0;
    for (Barang barang: this.barang) {
      int itemNumber = this.barang.indexOf(barang) + 1;
      System.out.println(String.format("+ %02d. | %-15s | %-6d | %-12d | %-16d \t+", itemNumber, barang.getNama(), barang.getStock(), barang.getHarga(), barang.getHarga() * barang.getStock()));
      totalBelanja += barang.getHarga() * barang.getStock();
    }
    System.out.println("+=======================================================================+");
    System.out.println(String.format("+ TOTAL BELANJA: %-50d \t+", totalBelanja));
    System.out.println("+=======================================================================+");
  }

  /**
   * Memproses pembayaran transaksi berdasarkan metode pembayaran yang dipilih.
   * @param metodePembayaran Pilihan metode pembayaran (1: QRIS, 2: Bank, 3: COD).
   */
  public void prosesPembayaran(int metodePembayaran) {
    if (metodePembayaran == 1) {
      QRIS bayar = new QRIS();
      bayar.metode();
    } else if (metodePembayaran == 2) {
      Bank bayar = new Bank();
      bayar.metode();
    } else if (metodePembayaran == 3) {
      COD bayar = new COD();
      bayar.metode();
    }
  }

  /**
   * Mengembalikan string yang mewakili metode pembayaran berdasarkan pilihan metode pembayaran.
   * @param metodePembayaran Pilihan metode pembayaran (1: QRIS, 2: Bank, 3: COD).
   * @return String yang mewakili metode pembayaran.
   * @throws IllegalArgumentException Jika pilihan metode pembayaran tidak valid.
   */
  public String getMetode(int metodePembayaran) {
    if (metodePembayaran == 1) {
      metode = "QRIS";
    } else if (metodePembayaran == 2) {
      metode = "Bank";
    } else if (metodePembayaran == 3) {
      metode = "COD";
    } else {
      // Handle invalid input
      throw new IllegalArgumentException("Invalid metodePembayaran value: " + metodePembayaran);
    }
    return metode; // Return the variable value
  }

  //Mengembalikan Id transaksi yang pasti berbeda
  public String getUniqueId() {
    return this.id;
  }

  /**
   * Mengatur status pemesanan transaksi.
   * @param statusPemesanan Status pemesanan yang akan diatur (false: belum diterima, true: sudah diterima).
   */
  public void setStatusPemesanan(boolean statusPemesanan) {
    this.statusPemesanan = statusPemesanan;
  }

  /**
   * Mengembalikan status pemesanan transaksi.
   * @return true jika transaksi sudah diterima, false jika belum diterima.
   */
  public boolean getStatusPemesanan() {
    return statusPemesanan;
  }

  /**
   * Mengembalikan tanggal transaksi.
   * @return Objek Date yang mewakili tanggal transaksi.
   */
  public Date getTanggal() {
    return tanggal;
  }
}