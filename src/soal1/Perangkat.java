package soal1;

/**
 * Merepresentasikan sebuah perangkat elektronik yang dijual di toko.
 * Kelas ini menyimpan data dasar perangkat (merek, harga, garansi) dan
 * memastikan setiap nilai yang disimpan lolos validasi sebelum diterima.
 */
public class Perangkat {

    /** Tarif pajak 10 persen yang dikenakan atas harga perangkat. */
    private static final double TARIF_PAJAK = 0.10;

    private String merek;
    protected double harga;
    private int garansiBulan;

    /**
     * Membuat objek Perangkat baru dengan data lengkap.
     *
     * @param merek        nama merek perangkat, tidak boleh kosong
     * @param harga        harga perangkat dalam rupiah, wajib bernilai positif
     * @param garansiBulan lama garansi dalam bulan, wajib bernilai positif
     * @throws IllegalArgumentException jika merek kosong atau harga negatif
     */
    public Perangkat(String merek, double harga, int garansiBulan) {
        validasiMerek(merek);
        validasiHarga(harga);
        this.merek = merek;
        this.harga = harga;
        this.garansiBulan = garansiBulan;
    }

    /**
     * Memvalidasi bahwa merek tidak null dan tidak kosong.
     *
     * @param merek nilai merek yang akan divalidasi
     * @throws IllegalArgumentException jika merek null atau kosong
     */
    private void validasiMerek(String merek) {
        if (merek == null || merek.trim().isEmpty()) {
            throw new IllegalArgumentException("Merek tidak boleh kosong.");
        }
    }

    /**
     * Memvalidasi bahwa harga bernilai positif (tidak negatif).
     *
     * @param harga nilai harga yang akan divalidasi
     * @throws IllegalArgumentException jika harga bernilai negatif
     */
    private void validasiHarga(double harga) {
        if (harga < 0) {
            throw new IllegalArgumentException("Harga tidak boleh negatif.");
        }
    }

    /**
     * Mengembalikan nama merek perangkat.
     *
     * @return merek perangkat
     */
    public String getMerek() {
        return merek;
    }

    /**
     * Mengembalikan lama garansi perangkat dalam satuan bulan.
     *
     * @return garansi dalam bulan
     */
    public int getGaransiBulan() {
        return garansiBulan;
    }

    /**
     * Menghitung nilai pajak yang dikenakan atas perangkat ini.
     * Tarif pajak sebesar 10 persen dikalikan harga perangkat.
     *
     * @return nilai pajak dalam rupiah
     */
    public double hitungPajak() {
        return harga * TARIF_PAJAK;
    }

    /**
     * Mengembalikan informasi singkat perangkat dalam format teks.
     * Subclass wajib memanggil super.infoSingkat() dan menambahkan
     * atribut miliknya sendiri.
     *
     * @return string informasi singkat perangkat
     */
    public String infoSingkat() {
        return merek + " | garansi " + garansiBulan + " bulan";
    }
}

