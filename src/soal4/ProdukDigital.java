package soal4;

/**
 * Merepresentasikan produk digital yang mendapatkan diskon 10 persen
 * dari harga dasar. Harga akhir dihitung setelah potongan diskon digital.
 */
public class ProdukDigital extends Produk {

    /** Diskon yang diberikan untuk semua produk digital, dalam persentase. */
    protected static final double DISKON_DIGITAL_PERSEN = 10;

    private double ukuranMb;

    /**
     * Membuat objek ProdukDigital baru.
     *
     * @param kode       kode unik produk
     * @param nama       nama produk, tidak boleh kosong
     * @param hargaDasar harga dasar dalam rupiah, wajib tidak negatif
     * @param ukuranMb   ukuran file produk digital dalam megabyte
     * @throws IllegalArgumentException jika nama kosong atau harga dasar negatif
     */
    public ProdukDigital(String kode, String nama, double hargaDasar, double ukuranMb) {
        super(kode, nama, hargaDasar);
        this.ukuranMb = ukuranMb;
    }

    /**
     * Menghitung harga akhir produk digital setelah diskon 10 persen.
     * Harga akhir = harga dasar × (1 - diskon digital / 100).
     *
     * @return harga akhir produk digital dalam rupiah
     */
    @Override
    public double hitungHargaAkhir() {
        return getHargaDasar() * (1 - DISKON_DIGITAL_PERSEN / 100);
    }

    /**
     * Mengembalikan deskripsi produk digital beserta ukuran filenya.
     *
     * @return deskripsi berformat "digital X.X MB"
     */
    @Override
    public String deskripsi() {
        return "digital " + ukuranMb + " MB";
    }

    /**
     * Mengembalikan ukuran file produk digital dalam megabyte.
     *
     * @return ukuran dalam megabyte
     */
    public double getUkuranMb() {
        return ukuranMb;
    }
}

