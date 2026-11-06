package soal1;

/**
 * Merepresentasikan laptop sebagai subclass dari Perangkat.
 * Menyimpan informasi tambahan berupa kapasitas RAM dan ukuran layar,
 * serta mendukung perhitungan harga promosi dengan diskon tertentu.
 */
public class Laptop extends Perangkat {

    private int ramGb;
    private double ukuranLayarInci;

    /**
     * Membuat objek Laptop baru dengan seluruh atribut yang diperlukan.
     *
     * @param merek          nama merek laptop
     * @param harga          harga laptop dalam rupiah, wajib positif
     * @param garansiBulan   lama garansi dalam bulan
     * @param ramGb          kapasitas RAM dalam gigabyte
     * @param ukuranLayarInci ukuran layar dalam inci
     * @throws IllegalArgumentException jika merek kosong atau harga negatif
     */
    public Laptop(String merek, double harga, int garansiBulan, int ramGb, double ukuranLayarInci) {
        super(merek, harga, garansiBulan);
        this.ramGb = ramGb;
        this.ukuranLayarInci = ukuranLayarInci;
    }

    /**
     * Menghitung harga laptop setelah diberikan diskon promosi.
     * Metode ini mengakses atribut harga (protected) dari superclass secara langsung.
     *
     * @param diskonPersen persentase diskon yang diberikan (misalnya 10 untuk 10%)
     * @return harga laptop setelah dipotong diskon
     */
    public double hitungHargaPromo(double diskonPersen) {
        return harga * (1 - diskonPersen / 100);
    }

    /**
     * Mengembalikan informasi singkat laptop termasuk data RAM dan ukuran layar.
     * Memanggil super.infoSingkat() terlebih dahulu sebelum menambahkan atribut sendiri.
     *
     * @return string informasi singkat laptop
     */
    @Override
    public String infoSingkat() {
        return super.infoSingkat() + " | RAM " + ramGb + " GB | layar " + ukuranLayarInci + " inci";
    }
}

