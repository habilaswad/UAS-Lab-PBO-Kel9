/**
 * @author : Fathiya Namira Fardhi
 */
import java.util.*;

public class Main {
  /**
   * Metode main untuk menjalankan aplikasi PBOSHOP.
   *
   * @param args ini argumen dari baris perintah.
   */
  public static void main(String[] args) {

    Akun akun = new Akun(); // Objek untuk menyimpan informasi akun pengguna
    Scanner scanner = new Scanner(System.in); // Objek scanner untuk membaca input dari pengguna
    AdminDriver menuAdmin = new AdminDriver(); // Objek untuk mengelola menu admin

    Customer akunCustomer = new Customer(); // Objek untuk menyimpan informasi akun customer
    akunCustomer.keranjang = new Keranjang(); // Objek untuk menyimpan keranjang belanja customer

    CustomerDriver menuCustomer = new CustomerDriver(); // Objek untuk mengelola menu customer
    System.out.print("\n+========== SELAMAT DATANG DI PBOSHOP ==========+");

    Transaksi transaksi = new Transaksi(akunCustomer, new ArrayList<> (akunCustomer.keranjang.barang)); // Objek transaksi

    do {
      System.out.println("\n+=============== SILAHKAN LOGIN ================+");
      System.out.println(" '0' untuk keluar\t\t\t\t");

      System.out.print("  username  : ");
      akun.setId(scanner.nextLine());
      System.out.print("  Password  : ");
      akun.setPassword(scanner.nextLine());
      System.out.println("+===============================================+");

      if (akun.getId().equals("admin") && akun.getPassword().equals("admin")) {
        menuAdmin.MENU();
        continue;
      } else if (akun.getId().equals("customer") && akun.getPassword().equals("customer")) {
        menuCustomer.setTransaksi(transaksi);
        menuCustomer.setCustomer(akunCustomer);
        menuCustomer.MENU();
        continue;
      } else {
        System.out.println("username atau password salah!");
        System.out.println("+===============================================+");
      }

    } while (!akun.getId().equals("0"));
}
}
