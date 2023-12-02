/**
 * Kelas Pembayaran mewakili metode pembayaran yang akan dipilih oleh pelanggan.
 * Kelas ini menggunakan metode abstrak yang harus diimplementasikan oleh kelas turunannya.
 *
 * @author Firjatullah Afny Abus
 * @version 1.0
 */
public abstract class Pembayaran {
  /**
   * metode abstrak yang akan menangani proses pembayaran sesuai dengan metode yang dipilih.
   */
  public abstract void metode();
}