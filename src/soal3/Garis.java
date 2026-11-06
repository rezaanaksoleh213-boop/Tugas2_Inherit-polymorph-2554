package soal3;

/**
 * Merepresentasikan sebuah garis yang dibentuk oleh dua buah titik (komposisi).
 * Garis memiliki relasi has-a terhadap Titik, bukan is-a.
 * Menggunakan defensive copy agar perubahan titik dari luar tidak memengaruhi
 * titik yang tersimpan di dalam Garis.
 */
public class Garis {

    private Titik awal;
    private Titik akhir;

    /**
     * Membuat objek Garis dari dua objek Titik yang diberikan.
     * Defensive copy diterapkan agar Garis menyimpan salinan titik,
     * bukan referensi ke objek aslinya.
     *
     * @param awal  titik awal garis
     * @param akhir titik akhir garis
     */
    public Garis(Titik awal, Titik akhir) {
        this.awal = new Titik(awal.getX(), awal.getY());
        this.akhir = new Titik(akhir.getX(), akhir.getY());
    }

    /**
     * Membuat objek Garis dari empat koordinat titik awal dan akhir.
     * Constructor ini memanfaatkan constructor pertama lewat this(...),
     * sehingga logika tidak ditulis ulang.
     *
     * @param x1 koordinat x titik awal
     * @param y1 koordinat y titik awal
     * @param x2 koordinat x titik akhir
     * @param y2 koordinat y titik akhir
     */
    public Garis(double x1, double y1, double x2, double y2) {
        this(new Titik(x1, y1), new Titik(x2, y2));
    }

    /**
     * Mengembalikan salinan dari titik awal garis.
     *
     * @return salinan titik awal
     */
    public Titik getAwal() {
        return new Titik(awal.getX(), awal.getY());
    }

    /**
     * Mengembalikan salinan dari titik akhir garis.
     *
     * @return salinan titik akhir
     */
    public Titik getAkhir() {
        return new Titik(akhir.getX(), akhir.getY());
    }

    /**
     * Mengubah titik awal garis dengan melakukan defensive copy.
     *
     * @param awal titik awal yang baru
     */
    public void setAwal(Titik awal) {
        this.awal = new Titik(awal.getX(), awal.getY());
    }

    /**
     * Mengubah titik akhir garis dengan melakukan defensive copy.
     *
     * @param akhir titik akhir yang baru
     */
    public void setAkhir(Titik akhir) {
        this.akhir = new Titik(akhir.getX(), akhir.getY());
    }

    /**
     * Menghitung panjang garis dengan mendelegasikan perhitungan jarak
     * ke method jarakKe() milik Titik. Rumus jarak tidak disalin di sini.
     *
     * @return panjang garis
     */
    public double getPanjang() {
        return awal.jarakKe(akhir);
    }

    /**
     * Mengembalikan representasi teks garis dalam format (x1, y1) - (x2, y2).
     * Memanfaatkan toString() dari Titik untuk masing-masing ujung garis.
     *
     * @return string representasi garis
     */
    @Override
    public String toString() {
        return awal.toString() + " - " + akhir.toString();
    }
}

