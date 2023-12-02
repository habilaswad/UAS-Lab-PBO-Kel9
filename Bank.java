import java.util.*;

/**
 * Kelas Bank mewakili metode pembayaran melalui bank dari kelas pembayaran.
 * Kelas ini memberikan pilihan bank yang dapat dipilih customer kemudian.
 *
 * @author Firjatullah Afny Abus
 * @version 1.0
 */
public class Bank extends Pembayaran {
  // variabel pilihan digunakan untuk menyimpan pilihan bank yang dipilih oleh customer.
  public int pilihan = 0;
  // scanner digunakan untuk membaca input dari pengguna.
  Scanner scanner = new Scanner(System.in);

  /**
   * metode override dari kelas induk Pembayaran.
   * menampilkan daftar bank yang dapat dipilih oleh customer dan
   * membaca input pengguna untuk menentukan pilihan bank.
   */
  @Override
  public void metode() {
    System.out.println("\n+===============================================+");
    System.out.println("+Pilih Bank yang ingin digunakan:               +");
    System.out.println("+===============================================+");
    System.out.println("+ (1).BSI                                       +");
    System.out.println("+ (2).BCA Syariah                               +");
    System.out.println("+ (3).BCA                                       +");
    System.out.println("+===============================================+");

    // membaca input pengguna untuk menentukan pilihan bank.
    System.out.print("Pilihan: ");
    pilihan = scanner.nextInt();
  }
}