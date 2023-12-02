import java.util.*;

/**
 * Kelas Customer mewakili pengguna yang berperan sebagai pelanggan.
 * Kelas ini merupakan turunan dari kelas Akun.
 *
 * @author Firjatullah Afny Abus
 * @version 1.0
 */
public class Customer extends Akun {
  /**
   * konstruktor default untuk kelas Customer.
   */
  public Customer() {
    super();
  }

  // variabel keranjang digunakan untuk menyimpan objek Keranjang milik pelanggan.
  public Keranjang keranjang;
  // arrayList invoiceSelesai digunakan untuk menyimpan daftar invoice yang telah selesai.
  public ArrayList < Invoice > invoiceSelesai;

}