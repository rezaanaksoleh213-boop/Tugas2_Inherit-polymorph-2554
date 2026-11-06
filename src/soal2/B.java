package soal2;

/**
 * Kelas B sebagai subclass dari A yang mendemonstrasikan risiko
 * pemanggilan method overridable dari dalam constructor superclass.
 * Field {@code nilai} belum diinisialisasi ketika init() dipanggil
 * oleh constructor A, sehingga mencetak nilai default 0, bukan 5.
 */
public class B extends A {

    /** Field yang diinisialisasi setelah constructor A selesai berjalan. */
    int nilai = 5;

    /**
     * Membuat objek B baru. super() dipanggil secara implisit/eksplisit
     * terlebih dahulu, yang mengakibatkan init() versi B terpanggil
     * sebelum field nilai diinisialisasi ke 5.
     */
    public B() {
        super();
        System.out.println("B dibuat, nilai=" + nilai);
    }

    /**
     * Override init() dari A. Ketika dipanggil dari constructor A,
     * field nilai masih bernilai 0 (nilai default int), bukan 5.
     */
    @Override
    public void init() {
        System.out.println("init B, nilai=" + nilai);
    }
}

