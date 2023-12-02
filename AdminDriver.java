import java.util.*;

/**
 * Kelas AdminDriver yang digunakan untuk menangani alur kerja admin.
 * @author Muhammad Habil Aswad
 */
public class AdminDriver extends Driver {
  public Admin akun;
  public ListBarang daftarBarang;
  public List < Transaksi > listTransaksi = new ArrayList < > ();
  public int pilihan1 = 0;
  public Transaksi transaksi;
  public Invoice invoice;
  Scanner scanner = new Scanner(System.in);

  /**
   * method konstraktor default AdminDriver
   */
  public AdminDriver() {
    this.daftarBarang = ListBarang.getInstance();
    this.transaksi = new Transaksi(akun, new ArrayList < > ());
    this.listTransaksi = ListTransaksi.getInstance().getDaftarTransaksi();
  }

  /**
   * Menampilkan menu utama admin.
   * @return void
   */
  public void MENU() {
    System.out.println("\n+===============================================+");
    System.out.println("+ SELAMAT DATANG \"admin\"!                 \t+");

    //Perulangan Menu
    do {
      try {
        //Tampilan Awal MENU
        System.out.println("+===============================================+");
        System.out.println("+ Apa yang ingin Anda lakukan?                  +");
        System.out.println("+===============================================+");
        System.out.println("+ (1) Tampilkan Daftar Barang!                  +");
        System.out.println("+ (2) Tambah Barang!                            +");
        System.out.println("+ (3) Hapus Barang!                             +");
        System.out.println("+ (4) Edit Barang!                              +");
        System.out.println("+ (5) Terima Pesanan!                           +");
        System.out.println("+ (6) Logout!                                   +");
        System.out.println("+===============================================+");

        System.out.print("Pilihan: ");
        pilihan1 = scanner.nextInt();

        //Pengecekan Kesalahan inputan
        if (pilihan1 < 1 || pilihan1 > 6) {
          System.out.println("Tidak terdapat pilihan " + pilihan1 + "!");
          System.out.println("Silakan Masukkan Kembali!\n");
          continue;
        }

        //PILIHAN 1 (Menampilkan List Barang)
        if (pilihan1 == 1) {
          daftarBarang.tampilkanListBarang();
          System.out.println("");
        }

        // PILIHAN 2 (Menambahkan Barang Baru ke List Barang)
        if (pilihan1 == 2) {
          daftarBarang.tampilkanListBarang();
          Scanner scanner = new Scanner(System.in);

          // Meminta informasi barang baru dari admin
          System.out.println("\n+===============================================+");
          System.out.println("+              TAMBAH BARANG BARU               +");
          System.out.println("+===============================================+");
          System.out.print("Nama: ");
          String nama = scanner.nextLine();

          System.out.print("Harga: ");
          int harga = scanner.nextInt();

          System.out.print("Jumlah Stock: ");
          int stock = scanner.nextInt();

          // Membuat objek Barang baru
          Barang newItem = new Barang(nama, harga, stock);

          System.out.println("+===============================================+");

          // Menambahkan barang baru ke ListBarang
          daftarBarang.add(newItem);
          System.out.println("Barang Berhasil Ditambah!\n");
        }

        //PILIHAN 3 (Menghapus Barang pada List Barang)
        if (pilihan1 == 3) {
          daftarBarang.tampilkanListBarang();
          Scanner scanner = new Scanner(System.in);

          // Meminta admin untuk memilih barang yang ingin dihapus
          System.out.println("\n+===============================================+");
          System.out.print(" Pilih nomor barang yg ingin dihapus: ");
          int remove = scanner.nextInt();
          System.out.println("+===============================================+");

          // Memeriksa apakah indeks valid sebelum menghapus barang
          if (remove >= 0 && remove < daftarBarang.size()) {
            // Menghapus barang dari ListBarang
            Barang removedItem = daftarBarang.get(remove);
            daftarBarang.barang.remove(remove);

            System.out.println("'" + removedItem.getNama() + "' Berhasil Dihapus!\n");
          } else {
            System.out.println("angka inputan tidak valid.");
            System.out.println("+===============================================+");
          }
        }

        //PILIHAN 4 (Melakukan Pengeditan Barang)
        if (pilihan1 == 4) {
          daftarBarang.tampilkanListBarang();
          Scanner scanner = new Scanner(System.in);

          // Meminta admin untuk memilih barang yang ingin diedit
          System.out.print("Pilih nomor barang yang ingin diedit: ");
          int indexToEdit = scanner.nextInt();

          // Memeriksa apakah indeks valid sebelum mengedit barang
          if (indexToEdit >= 0 && indexToEdit < daftarBarang.size()) {
            // Meminta admin untuk memilih atribut yang ingin diubah
            System.out.println("\n+===============================================+");
            System.out.println("+ Attribut yang ingin Anda edit?                +");
            System.out.println("+===============================================+");
            System.out.println("+ (1) Nama                                      +");
            System.out.println("+ (2) Harga                                     +");
            System.out.println("+ (3) Jumlah Stock                              +");
            System.out.println("+===============================================+");

            System.out.print("Pilihan: ");
            int pilihan2 = scanner.nextInt();

            // Mendapatkan objek Barang yang dipilih
            Barang barangToEdit = daftarBarang.get(indexToEdit);

            // Mengedit atribut yang dipilih berdasarkan pilihan admin
            if (pilihan2 == 1) {
              System.out.print("Masukkan nama baru: ");
              String newNama = scanner.next();
              barangToEdit.setNama(newNama);
            } else if (pilihan2 == 2) {
              System.out.print("Masukkan harga baru: ");
              int newHarga = scanner.nextInt();
              barangToEdit.setHarga(newHarga);
            } else if (pilihan2 == 3) {
              System.out.print("Masukkan jumlah stock baru: ");
              int newStock = scanner.nextInt();
              barangToEdit.setStock(newStock);
            } else {
              System.out.println("Pilihan tidak valid.");
              return;
            }

            System.out.println("Barang berhasil diubah!\n");
          } else {
            System.out.println("angka inputan tidak valid.\n");
          }
        }

        //PILIHAN 5 (Menerima Transaksi Yang ada)
        if (pilihan1 == 5) {
          List < Transaksi > listTransaksi = ListTransaksi.getInstance().getDaftarTransaksi();
          if (listTransaksi.isEmpty()) {
            System.out.println("Tidak ada Transaksi\n");
            continue;
          }

          System.out.println("\n+===============================================+");
          System.out.println("+               DAFTAR TRANSAKI                 +");
          System.out.println("+===============================================+");

          //Menampilkan ID transaksi yang ada
          int i = 1;
          for (Transaksi transaksi: listTransaksi) {
            System.out.println("+ (" + (i++) + ")" + transaksi.id + "\t\t\t\t\t+");
          }

          //Memilih nomor index yang mau diterima
          System.out.println("+===============================================+");
          System.out.print("Terima Nomor: ");
          int nomorTransaksi = scanner.nextInt();

          //Pengecekan bahwa nomor inputan valid
          if (nomorTransaksi < 1 || nomorTransaksi > listTransaksi.size()) {
            System.out.println("Nomor transaksi tidak valid.\n");
            continue;
          }

          //Mengambil transaksi dari listTransaksi
          transaksi = listTransaksi.get(nomorTransaksi - 1);

          if (Boolean.FALSE.equals(transaksi.getStatusPemesanan())) {
            // Mengubah status pesanan menjadi diterima
            transaksi.setStatusPemesanan(true);
            System.out.println("\n+===============================================+");
            System.out.println("+Transaksi dengan ID " + transaksi.getUniqueId() + " BERHASIL diterima+");
            System.out.println("+===============================================+\n");
          } else if (Boolean.TRUE.equals(transaksi.getStatusPemesanan())) {
            System.out.println("\n+===============================================+");
            System.out.println("+Transaksi dengan ID " + transaksi.getUniqueId() + " TELAH diterima   +");
            System.out.println("+===============================================+\n");
          }

        }
      } catch (InputMismatchException e) {
        // Menangani kesalahan input
        System.out.println("Mohon Hanya Menginput ANGKA yang tertera");
        System.out.println("+===============================================+\n");
        scanner.nextLine(); // Membersihkan buffer input
      }
    } while (pilihan1 != 6);
  }
}
