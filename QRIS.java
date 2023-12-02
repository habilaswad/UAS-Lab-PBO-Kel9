/**
 * Kelas QRIS mewakili metode pembayaran melalui qris dari kelas pembayaran.
 * Kelas ini menggambarkan tampilan barcode QR yang dapat digunakan dalam transaksi pembayaran.
 *
 * @author Firjatullah Afny Abus
 * @version 1.0
 */
public class QRIS extends Pembayaran {
  /** 
   * method override dari kelas pembayaran.
   * menampilkan gambaran QR barcode.
   */
  @Override
  public void metode() {
    System.out.println("\nSilahkan Scan Barcode ini!");
    System.out.println("+ + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + +");
    System.out.println("+ ||||||||| | || || || || || || | || || || || || || ||||||||| +");
    System.out.println("+ ||     || ||||| | | || ||| | | || || || || || | | ||     || +");
    System.out.println("+ || ||| || | || | || | ||||| | | |||| | | ||| | || || ||| || +");
    System.out.println("+ || ||| || ||| || || || || | || || | |||| || | | | || ||| || +");
    System.out.println("+ ||     || || | ||| |||| || ||| | ||| | ||| || ||| ||     || +");
    System.out.println("+ ||||||||| | ||| || | || | || ||  | || || | || ||| ||||||||| +");
    System.out.println("+            || | | | ||  || | |||||  ||| |  || ||            +");
    System.out.println("+ | | |  || || |  | || ||||  || | | ||  || || || | || || |||| +");
    System.out.println("+ | | | |  || |||| | ||  || | |||| || |  || || || ||| ||| ||| +");
    System.out.println("+ | | | ||||| || || || | |  ||||||||||| | |||| || ||||| ||| ||+");
    System.out.println("+ | ||| || || ||| | | | ||  ||       || || || | | || || || || +");
    System.out.println("+ || || || | || | || |||| | ||  |||  ||| ||| || || || || | || +");
    System.out.println("+ | || ||| || || |  ||| || |||  |||  |||| | ||| || || || |||| +");
    System.out.println("+ | | | ||| |||| |||  || |  ||       |||| | ||| || || |  |||| +");
    System.out.println("+ | | | ||| || || |    || | |||||||||||| |  || ||| || || |||| +");
    System.out.println("+ | | |  || || |  | || ||||  || | | ||  || || || | || || |||| +");
    System.out.println("+ | | | |  || |||| | ||  || | |||| || |  || || || ||| ||| ||| +");
    System.out.println("+           |||| ||| || | || || || | | || || || | | || || ||| +");
    System.out.println("+ |||||||||  | || | || |||| || || || ||| ||| || || || || | || +");
    System.out.println("+ ||     || || || |  ||| |||| || ||| | ||| | |||   || || |||| +");
    System.out.println("+ || ||| ||  || | || |||| || || || || || || | || || | || | || +");
    System.out.println("+ || ||| ||  || || |  ||| |||| || ||| | ||| |  ||  || || |||| +");
    System.out.println("+ ||     || |||| |||  || | || || || || || | ||| || || || |||| +");
    System.out.println("+ |||||||||  |||| |||  || | || || || || || | ||| || || || ||| +");
    System.out.println("+ + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + +");
  }
}