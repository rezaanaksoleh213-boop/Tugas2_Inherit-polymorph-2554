package soal4;

/**
 * Merepresentasikan produk abstrak yang dijual di toko digital.
 * Setiap produk memiliki kode unik, nama, dan harga dasar.
 * Subclass wajib mengimplementasikan hitungHargaAkhir() dan deskripsi().
 */
public abstract class Produk {

    private String kode;
    private String nama;
    private double hargaDasar;

    /**
     * Membuat objek Produk baru dengan data dasar.
     *
     * @param kode      kode unik produk
     * @param nama      nama produk, tidak boleh kosong
     * @param hargaDasar harga dasar produk dalam rupiah, wajib tidak negatif
     * @throws IllegalArgumentException jika nama kosong atau harga dasar negatif
     */
    public Produk(String kode, String nama, double hargaDasar) {
        validasiNama(nama);
        validasiHargaDasar(hargaDasar);
        this.kode = kode;
        this.nama = nama;
        this.hargaDasar = hargaDasar;
    }

    /**
     * Memvalidasi bahwa nama produk tidak null dan tidak kosong.
     *
     * @param nama nama yang akan divalidasi
     * @throws IllegalArgumentException jika nama null atau kosong
     */
    private void validasiNama(String nama) {
        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama produk tidak boleh kosong.");
        }
    }

    /**
     * Memvalidasi bahwa harga dasar tidak bernilai negatif.
     *
     * @param hargaDasar harga yang akan divalidasi
     * @throws IllegalArgumentException jika harga dasar negatif
     */
    private void validasiHargaDasar(double hargaDasar) {
        if (hargaDasar < 0) {
            throw new IllegalArgumentException("Harga dasar tidak boleh negatif.");
        }
    }

    /**
     * Mengembalikan kode unik produk.
     *
     * @return kode produk
     */
    public String getKode() {
        return kode;
    }

    /**
     * Mengembalikan nama produk.
     *
     * @return nama produk
     */
    public String getNama() {
        return nama;
    }

    /**
     * Mengembalikan harga dasar produk sebelum perhitungan akhir.
     *
     * @return harga dasar produk
     */
    public double getHargaDasar() {
        return hargaDasar;
    }

    /**
     * Menghitung harga akhir produk sesuai aturan jenis produk masing-masing.
     * Setiap subclass wajib mengimplementasikan method ini.
     *
     * @return harga akhir produk dalam rupiah
     */
    public abstract double hitungHargaAkhir();

    /**
     * Mengembalikan keterangan singkat tentang jenis dan detail produk.
     * Setiap subclass wajib mengimplementasikan method ini.
     *
     * @return string deskripsi produk
     */
    public abstract String deskripsi();
}

