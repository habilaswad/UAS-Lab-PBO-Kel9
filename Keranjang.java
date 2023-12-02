import java.util.*;

/**
 * Kelas Keranjang mewakili keranjang belanja pelanggan.
 * Kelas ini akan menyimpan daftar barang yang dimasukkan oleh pelanggan ke dalam keranjang.
 * 
 * @author Firjatullah Afny Abus
 * @version 1.0
 */
public class Keranjang {
  // list barang digunakan untuk menyimpan daftar barang dalam keranjang.
  public List < Barang > barang;
  // variabel transaksi digunakan untuk menyimpan objek Transaksi yang terkait dengan keranjang.
  public Transaksi transaksi; 

  /**
   * konstruktor default untuk kelas Keranjang.
   * inisialisasi daftar barang sebagai ArrayList dan transaksi sebagai null.
   */
  public Keranjang() {
    this.barang = new ArrayList < > ();
    this.transaksi = null; // Initialize the transaksi field
  }

  /**
   * metode untuk menambahkan barang ke dalam keranjang.
   */
  public void addBarang(Barang barang) {
    this.barang.add(barang);
  }

  /**
   * metode untuk menampilkan detail keranjang, termasuk daftar barang dan total belanja.
   */
  public void DetailKeranjang() {
    System.out.println("\n+=======================================================================+");
    System.out.println("+                              KERANJANG                                +");
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
    System.out.println("+=======================================================================+\n");
  }

}