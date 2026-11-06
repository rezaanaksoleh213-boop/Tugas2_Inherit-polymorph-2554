package soal4;

/**
 * Merepresentasikan produk langganan yang diturunkan dari ProdukDigital.
 * Harga akhir dihitung berdasarkan harga dasar dikali durasi bulan,
 * dengan diskon tambahan 20 persen jika durasi minimal 12 bulan.
 * Produk langganan tidak mendapatkan diskon digital 10 persen dari ProdukDigital.
 */
public class Langganan extends ProdukDigital {

    /** Diskon yang diberikan jika durasi langganan mencapai batas minimum. */
    private static final double DISKON_LANGGANAN_PERSEN = 20;

    /** Durasi minimum dalam bulan untuk mendapatkan diskon langganan. */
    private static final int BATAS_DURASI_DISKON_BULAN = 12;

    private int durasiBulan;

    /**
     * Membuat objek Langganan baru.
     *
     * @param kode        kode unik produk
     * @param nama        nama produk, tidak boleh kosong
     * @param hargaDasar  harga dasar per bulan dalam rupiah, wajib tidak negatif
     * @param ukuranMb    ukuran konten digital dalam megabyte
     * @param durasiBulan durasi langganan dalam bulan
     * @throws IllegalArgumentException jika nama kosong atau harga dasar negatif
     */
    public Langganan(String kode, String nama, double hargaDasar, double ukuranMb, int durasiBulan) {
        super(kode, nama, hargaDasar, ukuranMb);
        this.durasiBulan = durasiBulan;
    }

    /**
     * Menghitung harga akhir langganan berdasarkan harga dasar dikali durasi,
     * dengan diskon 20 persen jika durasi minimal {@value #BATAS_DURASI_DISKON_BULAN} bulan.
     * Diskon digital 10 persen dari ProdukDigital tidak berlaku untuk langganan.
     *
     * @return harga akhir langganan dalam rupiah
     */
    @Override
    public double hitungHargaAkhir() {
        double totalSebelumDiskon = getHargaDasar() * durasiBulan;
        if (durasiBulan >= BATAS_DURASI_DISKON_BULAN) {
            return totalSebelumDiskon * (1 - DISKON_LANGGANAN_PERSEN / 100);
        }
        return totalSebelumDiskon;
    }

    /**
     * Mengembalikan deskripsi produk langganan beserta durasinya.
     *
     * @return deskripsi berformat "langganan X bulan"
     */
    @Override
    public String deskripsi() {
        return "langganan " + durasiBulan + " bulan";
    }
}

