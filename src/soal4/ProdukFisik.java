package soal4;

/**
 * Merepresentasikan produk fisik yang dikenakan biaya ongkos kirim
 * berdasarkan berat barang dalam kilogram.
 * Harga akhir dihitung dari harga dasar ditambah (berat kali ongkos kirim per kg).
 */
public class ProdukFisik extends Produk {

    /** Ongkos kirim per kilogram dalam rupiah. */
    private static final double ONGKOS_KIRIM_PER_KG = 10000;

    private double beratKg;

    /**
     * Membuat objek ProdukFisik baru.
     *
     * @param kode       kode unik produk
     * @param nama       nama produk, tidak boleh kosong
     * @param hargaDasar harga dasar dalam rupiah, wajib tidak negatif
     * @param beratKg    berat produk dalam kilogram
     * @throws IllegalArgumentException jika nama kosong atau harga dasar negatif
     */
    public ProdukFisik(String kode, String nama, double hargaDasar, double beratKg) {
        super(kode, nama, hargaDasar);
        this.beratKg = beratKg;
    }

    /**
     * Menghitung harga akhir produk fisik.
     * Harga akhir = harga dasar + (berat × ongkos kirim per kg).
     *
     * @return harga akhir produk fisik dalam rupiah
     */
    @Override
    public double hitungHargaAkhir() {
        return getHargaDasar() + (beratKg * ONGKOS_KIRIM_PER_KG);
    }

    /**
     * Mengembalikan deskripsi produk fisik beserta beratnya.
     *
     * @return deskripsi berformat "fisik X.X kg"
     */
    @Override
    public String deskripsi() {
        return "fisik " + beratKg + " kg";
    }
}

