/**
 * Kelas COD mewakili metode pembayaran Cash On Delivery dari kelas pembayaran.
 * Kelas ini menampilkan syarat dan ketentuan tentang metode COD pada customer.
 *
 * @author Firjatullah Afny Abus
 * @version 1.0
 */
public class COD extends Pembayaran {
  /** 
   * method override dari kelas pembayaran.
   * menampilkan syarat dan ketentuan metode COD.
   */
  @Override
  public void metode() {
    System.out.println("\n+==================================================================================================+");
    System.out.println("+Terms and Conditions for Cash on Delivery (COD):                                                  +");
    System.out.println("+==================================================================================================+");
    System.out.println("+ 1. Metode pembayaran hanya melibatkan uang tunai saat penerimaan barang.                         +");
    System.out.println("+ 2. Tim kami akan menghubungi Anda untuk verifikasi pesanan sebelum pengiriman dilakukan.         +");
    System.out.println("+ 3. Barang yang dibeli melalui COD dapat dikembalikan sesuai dengan kebijakan pengembalian kami.  +");
    System.out.println("+ 4. Jika tidak disetujui, silahkan batalkan pesanan.                                              +");
    System.out.println("+==================================================================================================+");
  }
}