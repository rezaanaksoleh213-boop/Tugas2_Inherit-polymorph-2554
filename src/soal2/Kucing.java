package soal2;

/**
 * Merepresentasikan kucing sebagai subclass dari Hewan.
 * Mengoverride method suara() dengan suara khas kucing
 * dan menambahkan kemampuan memanjat yang spesifik.
 */
public class Kucing extends Hewan {

    /**
     * Membuat objek Kucing baru. Constructor memanggil super(nama) terlebih
     * dahulu sehingga constructor Hewan dijalankan lebih dulu.
     *
     * @param nama nama kucing
     */
    public Kucing(String nama) {
        super(nama);
        System.out.println("Kucing dibuat");
    }

    /**
     * Mengeluarkan suara khas kucing, menggantikan suara generik dari Hewan.
     */
    @Override
    public void suara() {
        System.out.println("meong");
    }

    /**
     * Mensimulasikan perilaku kucing yang sedang memanjat.
     * Method ini hanya tersedia pada tipe Kucing, bukan pada tipe Hewan.
     */
    public void panjat() {
        System.out.println(nama + " memanjat");
    }
}

