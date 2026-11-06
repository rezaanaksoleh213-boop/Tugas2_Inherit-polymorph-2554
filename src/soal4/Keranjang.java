package soal4;

import java.util.ArrayList;
import java.util.List;

/**
 * Merepresentasikan keranjang belanja yang menyimpan daftar produk.
 * Menggunakan composition (relasi has-a) dengan menyimpan ArrayList bertipe Produk.
 * Mendukung penambahan produk, pencetakan struk, dan penghitungan total serta per jenis.
 */
public class Keranjang {

    private final List<Produk> daftarProduk;

    /**
     * Membuat keranjang belanja kosong baru.
     */
    public Keranjang() {
        this.daftarProduk = new ArrayList<>();
    }

    /**
     * Menambahkan produk ke dalam keranjang.
     * Kode produk harus unik; jika sudah ada, exception akan dilempar.
     *
     * @param produk produk yang akan ditambahkan
     * @throws IllegalStateException jika kode produk sudah ada di keranjang
     */
    public void tambah(Produk produk) {
        if (kodeSudahAda(produk.getKode())) {
            throw new IllegalStateException(
                    "Produk dengan kode '" + produk.getKode() + "' sudah ada di keranjang."
            );
        }
        daftarProduk.add(produk);
    }

    /**
     * Memeriksa apakah kode produk tertentu sudah ada di keranjang.
     *
     * @param kode kode produk yang akan diperiksa
     * @return true jika kode sudah ada, false jika belum
     */
    private boolean kodeSudahAda(String kode) {
        for (Produk p : daftarProduk) {
            if (p.getKode().equals(kode)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Menghitung total harga akhir dari semua produk di keranjang.
     * Menggunakan polimorfisme melalui pemanggilan hitungHargaAkhir()
     * tanpa memerlukan instanceof.
     *
     * @return total harga semua produk dalam rupiah
     */
    public double hitungTotal() {
        double total = 0;
        for (Produk p : daftarProduk) {
            total += p.hitungHargaAkhir();
        }
        return total;
    }

    /**
     * Mencetak struk belanja ke konsol dengan format:
     * kode | nama | deskripsi | RpNNN, lalu diikuti total keseluruhan.
     * Menggunakan polimorfisme; tidak ada instanceof di method ini.
     */
    public void cetakStruk() {
        for (Produk p : daftarProduk) {
            System.out.printf("%s | %s | %s | Rp%.0f%n",
                    p.getKode(), p.getNama(), p.deskripsi(), p.hitungHargaAkhir());
        }
        System.out.printf("TOTAL: Rp%.0f%n", hitungTotal());
    }

    /**
     * Menghitung dan mencetak jumlah produk berdasarkan jenisnya ke konsol.
     * Menggunakan instanceof dan downcasting aman untuk membedakan jenis produk.
     * Pengecekan Langganan dilakukan sebelum ProdukDigital karena Langganan
     * adalah subclass ProdukDigital (instanceof ProdukDigital juga bernilai true untuk Langganan).
     */
    public void hitungPerJenis() {
        int jumlahFisik = 0;
        int jumlahDigital = 0;
        int jumlahLangganan = 0;

        for (Produk p : daftarProduk) {
            if (p instanceof Langganan) {
                jumlahLangganan++;
            } else if (p instanceof ProdukDigital) {
                jumlahDigital++;
            } else if (p instanceof ProdukFisik) {
                jumlahFisik++;
            }
        }

        System.out.println("Fisik: " + jumlahFisik + ", Digital: " + jumlahDigital
                + ", Langganan: " + jumlahLangganan);
    }
}

