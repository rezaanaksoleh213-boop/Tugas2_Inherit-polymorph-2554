package soal4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Merepresentasikan produk bundel yang berisi beberapa produk sekaligus
 * dengan potongan diskon khusus paket (bundel).
 * Merupakan implementasi dari tantangan opsional Soal 4 (Composite Pattern).
 */
public class ProdukBundel extends Produk {

    /** Tarif diskon default untuk paket bundel sebesar 15 persen. */
    public static final double DISKON_BUNDEL_DEFAULT_PERSEN = 15.0;

    private final List<Produk> daftarItem;
    private final double diskonBundelPersen;

    /**
     * Membuat objek ProdukBundel baru dengan diskon default 15%.
     *
     * @param kode kode unik bundel
     * @param nama nama paket bundel
     * @throws IllegalArgumentException jika nama kosong
     */
    public ProdukBundel(String kode, String nama) {
        this(kode, nama, DISKON_BUNDEL_DEFAULT_PERSEN);
    }

    /**
     * Membuat objek ProdukBundel baru dengan persentase diskon kustom.
     *
     * @param kode               kode unik bundel
     * @param nama               nama paket bundel
     * @param diskonBundelPersen persentase diskon bundel (misal 15 untuk 15%)
     * @throws IllegalArgumentException jika nama kosong atau diskon di luar rentang 0-100
     */
    public ProdukBundel(String kode, String nama, double diskonBundelPersen) {
        super(kode, nama, 0.0);
        if (diskonBundelPersen < 0 || diskonBundelPersen > 100) {
            throw new IllegalArgumentException("Persentase diskon bundel harus antara 0 dan 100.");
        }
        this.daftarItem = new ArrayList<>();
        this.diskonBundelPersen = diskonBundelPersen;
    }

    /**
     * Menambahkan produk ke dalam paket bundel ini.
     *
     * @param produk produk yang dimasukkan ke dalam bundel
     * @throws IllegalArgumentException jika produk bernilai null
     */
    public void tambahItem(Produk produk) {
        if (produk == null) {
            throw new IllegalArgumentException("Item produk tidak boleh null.");
        }
        daftarItem.add(produk);
    }

    /**
     * Mengembalikan daftar produk di dalam bundel secara unmodifiable.
     *
     * @return daftar item produk dalam bundel
     */
    public List<Produk> getDaftarItem() {
        return Collections.unmodifiableList(daftarItem);
    }

    /**
     * Menghitung total harga akhir dari seluruh produk di dalam bundel,
     * kemudian memotongnya dengan persentase diskon bundel.
     *
     * @return harga akhir paket bundel dalam rupiah
     */
    @Override
    public double hitungHargaAkhir() {
        double subtotal = 0.0;
        for (Produk p : daftarItem) {
            subtotal += p.hitungHargaAkhir();
        }
        return subtotal * (1.0 - diskonBundelPersen / 100.0);
    }

    /**
     * Mengembalikan deskripsi paket bundel beserta jumlah item dan diskonnya.
     *
     * @return deskripsi bundel
     */
    @Override
    public String deskripsi() {
        return "bundel " + daftarItem.size() + " produk (diskon " + diskonBundelPersen + "%)";
    }
}

