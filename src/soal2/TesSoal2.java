package soal2;

/**
 * Kelas pengujian untuk Soal 2: Analisis Output, Error, dan Polimorfisme.
 * Mendemonstrasikan upcasting, downcasting, ClassCastException,
 * urutan constructor, dan bahaya memanggil method overridable dari constructor.
 */
public class TesSoal2 {

    /**
     * Titik masuk program pengujian Soal 2.
     * Menjalankan ketiga bagian (A, B, C) secara berurutan.
     *
     * @param args argumen baris perintah (tidak digunakan)
     */
    public static void main(String[] args) {
        System.out.println("=== Bagian A ===");
        bagianA();

        System.out.println("\n=== Bagian B ===");
        bagianB();

        System.out.println("\n=== Bagian C ===");
        bagianC();
    }

    /**
     * Menjalankan demo Bagian A: upcasting, downcasting, dan ClassCastException.
     * Baris h.panjat() dikomentari karena tipe statis h adalah Hewan (tidak ada method panjat).
     * Downcasting h2 ke Kucing akan melempar ClassCastException karena
     * tipe dinamis h2 adalah Hewan, bukan Kucing. Diperbaiki dengan instanceof.
     */
    private static void bagianA() {
        Hewan h = new Kucing("Tom");
        h.makan();
        h.suara();
        // h.panjat(); // Error kompilasi: tipe statis h adalah Hewan, tidak punya method panjat()

        Kucing k = (Kucing) h;
        k.panjat();

        Hewan h2 = new Hewan("Generik");
        // Kucing k2 = (Kucing) h2; // Ini menyebabkan ClassCastException
        // Perbaikan dengan instanceof (aman):
        if (h2 instanceof Kucing k2) {
            k2.panjat();
        } else {
            System.out.println("h2 bukan Kucing, downcasting dilewati.");
        }
    }

    /**
     * Menjalankan demo Bagian B: risiko memanggil method overridable dari constructor.
     * Ketika new B() dipanggil, constructor A memanggil init() versi B, namun
     * field nilai belum diinisialisasi ke 5 saat itu, sehingga mencetak 0.
     */
    private static void bagianB() {
        new B();
    }

    /**
     * Menjalankan demo Bagian C: polimorfisme dengan Lingkaran dan Titik.
     * l3 bertipe statis Lingkaran namun tipe dinamisnya Titik, sehingga
     * luas() yang dipanggil adalah versi Titik, menghasilkan 0.0.
     */
    private static void bagianC() {
        Lingkaran l1 = new Lingkaran(5);
        Titik l2 = new Titik();
        Lingkaran l3 = new Titik();

        System.out.println(l1.luas());
        System.out.println(l2.luas());
        System.out.println(l3.luas());
    }
}

