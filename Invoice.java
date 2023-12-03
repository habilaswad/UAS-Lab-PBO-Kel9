/**
 * @author : Fathiya Namira Fardhi
 */
public class Invoice {
  public Transaksi transaksi; // Objek transaksi yang terkait dengan faktur
  public String metodePembayaran; // Metode pembayaran yang digunakan
  public String id; // Identifikasi unik untuk faktur
  public static int i = 0; // Variabel statis untuk menghasilkan id unik

  /**
   * Konstruktor untuk objek kelas Invoice dengan parameter transaksi dan metodePembayaran.
   *
   * @param transaksi          Objek transaksi yang terkait dengan faktur.
   * @param metodePembayaran  Metode pembayaran yang digunakan.
   */
  public Invoice(Transaksi transaksi, String metodePembayaran) {
    this.transaksi = transaksi;
    this.metodePembayaran = metodePembayaran;
    this.id = "customer" + (i++);
  }

  /**
   * Method untuk mengatur metode pembayaran pada faktur.
   *
   * @param metodePembayaran Metode pembayaran baru yang akan diatur untuk faktur.
   */
  public void setMetodePembayaran(String metodePembayaran) {
    this.metodePembayaran = metodePembayaran;
}
}
