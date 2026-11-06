package soal1;

/**
 * Merepresentasikan ponsel sebagai subclass dari Perangkat.
 * Menyimpan informasi tambahan berupa kapasitas penyimpanan internal
 * dan jumlah kamera yang dimiliki ponsel.
 */
public class Ponsel extends Perangkat {

    private int kapasitasGb;
    private int jumlahKamera;

    /**
     * Membuat objek Ponsel baru dengan seluruh atribut yang diperlukan.
     *
     * @param merek        nama merek ponsel
     * @param harga        harga ponsel dalam rupiah, wajib positif
     * @param garansiBulan lama garansi dalam bulan
     * @param kapasitasGb  kapasitas penyimpanan internal dalam gigabyte
     * @param jumlahKamera jumlah kamera yang dimiliki ponsel
     * @throws IllegalArgumentException jika merek kosong atau harga negatif
     */
    public Ponsel(String merek, double harga, int garansiBulan, int kapasitasGb, int jumlahKamera) {
        super(merek, harga, garansiBulan);
        this.kapasitasGb = kapasitasGb;
        this.jumlahKamera = jumlahKamera;
    }

    /**
     * Mengembalikan informasi singkat ponsel termasuk kapasitas dan jumlah kamera.
     * Memanggil super.infoSingkat() terlebih dahulu sebelum menambahkan atribut sendiri.
     *
     * @return string informasi singkat ponsel
     */
    @Override
    public String infoSingkat() {
        return super.infoSingkat() + " | " + kapasitasGb + " GB | " + jumlahKamera + " kamera";
    }
}

