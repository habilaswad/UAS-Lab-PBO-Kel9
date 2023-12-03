/**
 * @author : Fathiya Namira Fardhi
 */
public class Akun {
  public String id; // Identifikasi unik untuk akun
  public String password; // Kata sandi yang digunakan untuk otentikasi akun

  /**
   * Konstruktor default untuk objek kelas Akun.
   * Inisialisasi nilai awal id menjadi "id" dan password menjadi "password".
   */
  public Akun() {
      this.id = "id";
      this.password = "password";
  }

  /**
   * Method untuk mendapatkan id akun.
   *
   * @return String id akun.
   */
  public String getId() {
      return this.id;
  }

  /**
   * Method untuk mengatur id akun.
   *
   * @param id String id baru yang akan diatur untuk akun.
   */
  public void setId(String id) {
      this.id = id;
  }

  /**
   * Method untuk mendapatkan password akun.
   *
   * @return String password akun.
   */
  public String getPassword() {
      return this.password;
  }

  /**
   * Method untuk mengatur password akun.
   *
   * @param password String password baru yang akan diatur untuk akun.
   */
  public void setPassword(String password) {
      this.password = password;
}
}
