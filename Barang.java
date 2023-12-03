/**
 * @author : Fathiya Namira Fardhi
 */
public class Barang {

  private String nama; // Nama barang
  private int harga; // Harga per unit barang
  private int stock; // Jumlah stok barang

  /**
   * Konstruktor untuk objek kelas Barang dengan parameter nama, harga, dan stock.
   *
   * @param nama  Nama barang.
   * @param harga Harga per unit barang.
   * @param stock Jumlah stok barang.
   */
  public Barang(String nama, int harga, int stock) {
    this.nama = nama;
    this.harga = harga;
    this.stock = stock;
  }

  /**
   * Konstruktor untuk objek kelas Barang dengan parameter nama dan harga.
   *
   * @param nama  Nama barang.
   * @param harga Harga per unit barang.
   */
  public Barang(String nama, int harga) {
    this.nama = nama;
    this.harga = harga;
  }

  /**
   * Method untuk mendapatkan nama barang.
   *
   * @return Nama barang.
   */
  public String getNama() {
    return nama;
  }

  /**
   * Method untuk mendapatkan harga per unit barang.
   *
   * @return Harga per unit barang.
   */
  public int getHarga() {
    return harga;
  }

  /**
   * Method untuk mendapatkan jumlah stok barang.
   *
   * @return Jumlah stok barang.
   */
  public int getStock() {
    return stock;
  }

  /**
   * Method untuk mengatur nama barang.
   *
   * @param nama Nama baru yang akan diatur untuk barang.
   */
  public void setNama(String nama) {
    this.nama = nama;
  }

  /**
   * Method untuk mengatur harga per unit barang.
   *
   * @param harga Harga baru yang akan diatur untuk barang.
   */
  public void setHarga(int harga) {
    this.harga = harga;
  }

  /**
   * Method untuk mengatur jumlah stok barang.
   *
   * @param stock Jumlah stok baru yang akan diatur untuk barang.
   */
  public void setStock(int stock) {
    this.stock = stock;
}
}
