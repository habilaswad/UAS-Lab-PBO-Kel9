import java.util.*;

/**
 * Kelas CustomerDriver yang digunakan untuk menangani alur kerja customer.
 * @author Muhammad Habil Aswad
 */
public class CustomerDriver extends Driver {
  public Customer akun;
  public Transaksi transaksi;
  public ListBarang daftarBarang;
  public int pilihan1 = 0;
  public int pilihan2 = 0;
  public int metodePembayaran = 0;
  Scanner scanner = new Scanner(System.in);
  public int totalBelanja = 0;

  Invoice invoice = new Invoice(null, "none");

  public List < Transaksi > listTransaksi;

  /**
   * method konstraktor default CustomerDriver
   */
  public CustomerDriver() {
    this.daftarBarang = ListBarang.getInstance();
  }

  /**
   * Memasukkan transaksi
   * @param transaksi mengambil objek transaksi yang dilakukan
   */
  public void setTransaksi(Transaksi transaksi) {
    this.transaksi = transaksi;
  }

  /**
   * Memasukkan akun customer
   * @param transaksi mengambil objek akun yang digunakan
   */
  public void setCustomer(Customer akun) {
    this.akun = akun;
  }

  /**
   * Menampilkan menu utama Customer.
   * @return void
   */
  public void MENU() {
    System.out.println("\n+===============================================+");
    System.out.println("+ SELAMAT DATANG \"customer\"!\t\t\t+");
    do {
      try {
        //Tampilan Opsi awal customer
        System.out.println("+===============================================+");
        System.out.println("+ Apa yang ingin Anda lakukan?\t\t\t+");
        System.out.println("+===============================================+");
        System.out.println("+ (1) Lihat Barang!\t\t\t\t+");
        System.out.println("+ (2) Lihat Keranjang!\t\t\t\t+");
        System.out.println("+ (3) Hapus di Keranjang\t\t\t+");
        System.out.println("+ (4) Checkout\t\t\t\t\t+");
        System.out.println("+ (5) Lihat Invoice!\t\t\t\t+");
        System.out.println("+ (6) Logout!\t\t\t\t\t+");
        System.out.println("+===============================================+");

        System.out.print(" Pilihan: ");
        pilihan1 = scanner.nextInt();

        // pengecekan inputan
        if (pilihan1 < 1 || pilihan1 > 6) {
          System.out.println("Tidak terdapat pilihan " + pilihan1 + "!");
          System.out.println("Silakan Masukkan Kembali!\n");
          continue;
        }

        // PILIHAN 1 (Menampilkan daftar barang)
        if (pilihan1 == 1) {
          daftarBarang.tampilkanListBarang();

          System.out.print("Masukkan nomor barang yang ingin dibeli: ");
          int nomorBarang = scanner.nextInt();

          System.out.print("Masukkan jumlah barang yang ingin dibeli: ");
          int jumlahBarang = scanner.nextInt();

          if (nomorBarang < 0 || nomorBarang >= daftarBarang.size()) {
            System.out.println("Nomor barang tidak valid.\n");
            continue;
          }

          if (jumlahBarang < 1) {
            System.out.println("Jumlah barang tidak valid.\n");
            continue;
          }

          // Mengambil objek Barang yang akan dibeli dari daftarBarang berdasarkan nomorBarang yang dimasukkan pengguna
          Barang barangDibeli = daftarBarang.get(nomorBarang);

          // Memeriksa apakah stok barang yang akan dibeli mencukupi
          if (barangDibeli.getStock() >= jumlahBarang) {
            // Jika mencukupi, tambahkan barang ke dalam keranjang dengan membuat objek Barang baru
            // yang memiliki nama, harga, dan jumlah sesuai dengan barang yang dibeli
            akun.keranjang.barang.add(new Barang(barangDibeli.getNama(), barangDibeli.getHarga(), jumlahBarang));

            // Kurangi stok barang dalam daftarBarang setelah ditambahkan ke dalam keranjang
            daftarBarang.setStock(nomorBarang, barangDibeli.getStock() - jumlahBarang);

            System.out.println("Barang berhasil ditambahkan ke keranjang.\n");
          } else {
            // Jika stok tidak mencukupi
            System.out.println("Stock barang tidak mencukupi.\n");
          }
        }

        // PILIHAN 2 (Menampilkan isi keranjang saat ini)
        if (pilihan1 == 2) {
          // Cek apakah keranjang kosong
          if (akun.keranjang.barang.isEmpty()) {
            System.out.println("Keranjang Kosong\n");
            continue;
          }

          //tampilkan isi keranjang
          akun.keranjang.DetailKeranjang();
        }

        // PILIHAN 3 (Menghapus barang dari keranjang)
        if (pilihan1 == 3) {
          // Cek apakah keranjang kosong
          if (akun.keranjang.barang.isEmpty()) {
            System.out.println("Keranjang Kosong\n");
            continue;
          }

          //tampilkan isi keranjang
          akun.keranjang.DetailKeranjang();

          //Memilih barang apa yang ingin dihapus dari keranjang
          System.out.println("+===============================================+");
          System.out.println("+ Barang keberapa yang ingin dihapus?\t\t+");
          System.out.println("+===============================================+");
          System.out.print("Pilihan: ");
          int itemNumberToRemove = scanner.nextInt();

          //Mengecek inputan user
          if (itemNumberToRemove > 0 && itemNumberToRemove <= akun.keranjang.barang.size()) {
            // Menghapus barang dari keranjang
            Barang removedItem = akun.keranjang.barang.remove(itemNumberToRemove - 1);

            // Mengupdate list barang pada sistem
            for (int i = 0; i < daftarBarang.size(); i++) {
              if (daftarBarang.get(i).getNama().equals(removedItem.getNama())) {
                daftarBarang.setStock(i, daftarBarang.get(i).getStock() + removedItem.getStock());
                System.out.println(removedItem.getNama() + " Berhasil dihapus!");
                break;
              }
            }
          } else {
            System.out.println("Inputan tidak valid.\n");
          }
        }

        //PILIHAN 4 (Proses Checkout)
        if (pilihan1 == 4) {
          //Pemeriksaan keranjang tidak kosong
          if (akun.keranjang.barang.isEmpty()) {
            System.out.println("Keranjang Kosong\n");
            continue;
          }

          //tampilkan keranjang
          akun.keranjang.DetailKeranjang();

          //Pemilihan checkout atau kembali ke menu awal
          do {
            System.out.println("+===============================================+");
            System.out.println("+ Checkout Pesanan?                             +");
            System.out.println("+===============================================+");
            System.out.println("+ (1).CHECKOUT                                  +");
            System.out.println("+ (2).KEMBALI                                   +");
            System.out.println("+===============================================+");

            System.out.print("Pilihan: ");

            pilihan2 = scanner.nextInt();
            System.out.println("");

            if (pilihan2 == 2) {
              break;
            }

            if (pilihan2 < 1 || pilihan2 > 2) {
              System.out.println("Pilihan tidak valid.\n");
              continue;
            }

            //Menu Checkout
            if (pilihan2 == 1) {
              do {
                //Memilih metode pembayaran
                System.out.println("+===============================================+");
                System.out.println("+ Pilih metode pembayaran:                      +");
                System.out.println("+===============================================+");
                System.out.println("+ (1) QRIS                                      +");
                System.out.println("+ (2) Bank                                      +");
                System.out.println("+ (3) COD                                       +");
                System.out.println("+===============================================+");

                System.out.print("Pilihan: ");
                metodePembayaran = scanner.nextInt();

                if (metodePembayaran < 1 || metodePembayaran > 3) {
                  System.out.println("Pilihan tidak valid.\n");
                  continue;
                }

                //Memasukan barang di keranjang ke proses transaksi
                akun.keranjang.transaksi = new Transaksi(akun, new ArrayList < > (akun.keranjang.barang));

                // Memproses pembayaran
                akun.keranjang.transaksi.prosesPembayaran(metodePembayaran);

                //Mengambil nama metode pembayaran agar dapat ditampilkan
                String namaMetode = akun.keranjang.transaksi.getMetode(metodePembayaran);

                //Membuat ListTransaksi
                List < Transaksi > listTransaksi = ListTransaksi.getInstance().getDaftarTransaksi();

                // Tambahkan transaksi ke ListTransaksi
                listTransaksi.add(akun.keranjang.transaksi);

                // Membuat Invoice sesuai transaksi
                Invoice invoice = new Invoice(akun.keranjang.transaksi, namaMetode);

                System.out.println("\nPesanan Telah Diajukan ke Admin!\n");

                // Mengkosongkan kembali keranjang setelah checkout
                akun.keranjang.barang.clear();

              } while (metodePembayaran < 1 || metodePembayaran > 3);
            }

            //keluar dari menu pembayaran setelah checkout
            if (pilihan2 == 1) {
              break;
            }

          } while (pilihan2 != 2 || pilihan2 != 1);
        }

        //PILIHAN 5 (Melihat Invoice)
        if (pilihan1 == 5) {

          //Mendeklarasi List Transaksi agar dapat dipanggil
          List < Transaksi > listTransaksi = ListTransaksi.getInstance().getDaftarTransaksi();
          //Pengecekan tidak ada transaksi
          if (listTransaksi.isEmpty()) {
            System.out.println("Tidak ada Transaksi\n");
            continue;
          }

          //Tampilan ID Pesanan yang ada
          System.out.println("\n+===============================================+");
          System.out.println("+                DAFTAR PESANAN                 +");
          System.out.println("+===============================================+");

          int i = 1;

          //perulangan menampilkan id transaksi yang ada diambil dari ListTransaksi
          for (Transaksi transaksi: listTransaksi) {
            System.out.println("+ (" + (i++) + ")" + transaksi.id + "\t\t\t\t\t+");
          }

          // Memilih id pesanan yang mau dilihat invoicenya
          System.out.println("+===============================================+");
          System.out.print("Lihat Invoice Nomor     : ");
          int nomorTransaksi = scanner.nextInt();

          if (nomorTransaksi < 1 || nomorTransaksi > listTransaksi.size()) {
            System.out.println("Nomor transaksi tidak valid.\n");
            continue;
          }

          // Mengambil Transaksi seusai pilihan id customer
          transaksi = listTransaksi.get(nomorTransaksi - 1);

          //Pengecekan sudah diterima admin atau belum
          if (Boolean.FALSE.equals(transaksi.getStatusPemesanan())) {
            System.out.println("Status Pesanan          : Belum Diterima.");
            System.out.println("Invoice tidak dapat dicetak.\n");
            continue;
          } else if (Boolean.TRUE.equals(transaksi.getStatusPemesanan())) {
            System.out.print("\nINVOICE:");
            transaksi.DetailPemesanan();
            System.out.println("+ Tanggal Pemesanan   : " + transaksi.getTanggal() + "\t\t\t+");
            System.out.println("+ Metode Pembayaran   : " + transaksi.metode + "\t\t\t\t\t\t+");
            System.out.println("+ Status Pesanan      : Diterima\t\t\t\t\t+");
            System.out.print("+=======================================================================+\n\n");

          }

        }

      } catch (InputMismatchException e) {
        //Exception inputan huruf agar program tidak berhenti
        System.out.println(" Mohon Hanya Menginput ANGKA yang tertera");
        System.out.println("+===============================================+\n");
        scanner.nextLine();
      }
    } while (pilihan1 != 6);

  }
}