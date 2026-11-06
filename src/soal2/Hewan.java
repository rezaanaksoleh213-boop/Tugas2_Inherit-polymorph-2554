package soal2;

/**
 * Merepresentasikan hewan generik dengan nama dan kemampuan dasar.
 * Digunakan sebagai superclass untuk mendemonstrasikan polimorfisme
 * dan urutan pemanggilan constructor dalam inheritance.
 */
public class Hewan {

    /** Nama hewan yang disimpan sebagai atribut protected. */
    protected String nama;

    /**
     * Membuat objek Hewan baru dengan nama tertentu.
     *
     * @param nama nama hewan
     */
    public Hewan(String nama) {
        this.nama = nama;
        System.out.println("Hewan dibuat: " + nama);
    }

    /**
     * Mengeluarkan suara generik dari hewan.
     * Dapat di-override oleh subclass untuk suara yang lebih spesifik.
     */
    public void suara() {
        System.out.println("...");
    }

    /**
     * Mensimulasikan perilaku makan hewan, lalu memanggil suara().
     * Karena suara() bisa di-override, perilakunya ditentukan oleh
     * tipe dinamis objek saat runtime (polimorfisme).
     */
    public void makan() {
        System.out.println(nama + " makan");
        suara();
    }
}

