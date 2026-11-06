package soal2;

/**
 * Kelas A sebagai superclass untuk mendemonstrasikan bahaya memanggil
 * method yang dapat di-override dari dalam constructor.
 */
public class A {

    /**
     * Membuat objek A baru dan memanggil method init() di dalamnya.
     * Karena init() bisa di-override, ini berpotensi memanggil versi
     * subclass sebelum subclass selesai diinisialisasi.
     */
    public A() {
        System.out.println("A dibuat");
        init();
    }

    /**
     * Method inisialisasi yang dapat di-override oleh subclass.
     * Dipanggil dari constructor A, sehingga jika subclass meng-override
     * method ini, versi subclass akan berjalan sebelum field subclass diinisialisasi.
     */
    public void init() {
        System.out.println("init A");
    }
}

