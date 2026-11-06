package soal1;

/**
 * Merepresentasikan laptop gaming sebagai subclass dari Laptop.
 * Memiliki atribut tambahan berupa jenis kartu grafis (GPU) yang digunakan,
 * serta otomatis menambahkan 6 bulan garansi tambahan di atas garansi dasar laptop.
 */
public class LaptopGaming extends Laptop {

    /** Jumlah bulan garansi tambahan khusus untuk laptop gaming. */
    private static final int GARANSI_TAMBAHAN_BULAN = 6;

    private String kartuGrafis;

    /**
     * Membuat objek LaptopGaming baru. Garansi yang diteruskan ke superclass
     * akan ditambah {@value #GARANSI_TAMBAHAN_BULAN} bulan secara otomatis.
     *
     * @param merek          nama merek laptop gaming
     * @param harga          harga laptop gaming dalam rupiah, wajib positif
     * @param garansiBulan   lama garansi dasar dalam bulan (akan ditambah 6)
     * @param ramGb          kapasitas RAM dalam gigabyte
     * @param ukuranLayarInci ukuran layar dalam inci
     * @param kartuGrafis    jenis atau seri kartu grafis yang digunakan
     * @throws IllegalArgumentException jika merek kosong atau harga negatif
     */
    public LaptopGaming(String merek, double harga, int garansiBulan,
                        int ramGb, double ukuranLayarInci, String kartuGrafis) {
        super(merek, harga, garansiBulan + GARANSI_TAMBAHAN_BULAN, ramGb, ukuranLayarInci);
        this.kartuGrafis = kartuGrafis;
    }

    /**
     * Mengembalikan informasi singkat laptop gaming termasuk jenis kartu grafis.
     * Memanggil super.infoSingkat() terlebih dahulu sebelum menambahkan atribut sendiri.
     *
     * @return string informasi singkat laptop gaming
     */
    @Override
    public String infoSingkat() {
        return super.infoSingkat() + " | GPU " + kartuGrafis;
    }
}

