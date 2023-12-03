/**
 * @author : Fathiya Namira Fardhi
 */
import java.util.*;

public class ListBarang {
  private static ListBarang instance; // Instansiasi singleton ListBarang
  public ArrayList<Barang> barang; // ArrayList untuk menyimpan daftar barang

  /**
   * Konstruktor private untuk ListBarang.
   * Inisialisasi daftar barang dengan beberapa barang awal.
   */
  private ListBarang() {
    this.barang = new ArrayList<>();
    barang.add(new Barang("Indomie", 3000, 20));
    barang.add(new Barang("SariMie", 4000, 20));
    barang.add(new Barang("Mie Sedap", 2000, 20));
    barang.add(new Barang("Mie Gelas", 7000, 20));
    barang.add(new Barang("Aqua", 2000, 20));
    barang.add(new Barang("Vit", 1000, 20));
    barang.add(new Barang("LeMineral", 5000, 20));
    barang.add(new Barang("Prima", 2500, 20));
    barang.add(new Barang("Crystalin", 3000, 20));
    barang.add(new Barang("Coca-cola", 9000, 20));
    barang.add(new Barang("Pepsi", 8000, 20));
    barang.add(new Barang("Sprite", 7000, 20));
    barang.add(new Barang("Fanta", 6500, 20));
  }

  /**
   * Method untuk mengatur daftar barang pada ListBarang.
   *
   * @param barang ArrayList baru yang akan diatur untuk daftar barang.
   */
  public void setListBarang(ArrayList<Barang> barang) {
    this.barang = barang;
  }

  /**
   * Method untuk mendapatkan instance dari ListBarang (singleton pattern).
   *
   * @return Instance dari ListBarang.
   */
  public static ListBarang getInstance() {
    if (instance == null) {
      instance = new ListBarang();
    }
    return instance;
  }

  /**
   * Method untuk menampilkan daftar barang.
   */
  public void tampilkanListBarang() {
    System.out.println("\n+===============================================+");
    System.out.println("+                DAFTAR BARANG                  +");
    System.out.println("+===============================================+");
    for (int i = 0; i < barang.size(); i++) {
      Barang b = barang.get(i);
      System.out.println("+ (" + i + ") " + b.getNama() + "\t\t\t\t\t+\n+  Harga: " + b.getHarga() + ", Stock: " + b.getStock() + "\t\t\t+");
    }
    System.out.println("+===============================================+");
  }

  /**
   * Method untuk menambahkan barang ke daftar.
   *
   * @param barang Barang yang akan ditambahkan.
   */
  public void add(Barang barang) {
    this.barang.add(barang);
  }

  /**
   * Method untuk mendapatkan jumlah barang pada daftar.
   *
   * @return Jumlah barang pada daftar.
   */
  public int size() {
    return barang.size();
  }

  /**
   * Method untuk mendapatkan barang pada indeks tertentu pada daftar.
   *
   * @param index Indeks barang yang akan diambil.
   * @return Barang pada indeks tersebut.
   */
  public Barang get(int index) {
    return barang.get(index);
  }

  /**
   * Method untuk mengatur jumlah stok barang pada indeks tertentu pada daftar.
   *
   * @param index    Indeks barang yang akan diubah stoknya.
   * @param newStock Jumlah stok baru yang akan diatur untuk barang tersebut.
   */
  public void setStock(int index, int newStock) {
    if (index >= 0 && index < barang.size()) {
      barang.get(index).setStock(newStock);
    } else {
      System.out.println("Invalid index.");
}
}
}
