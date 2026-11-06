package soal3;

/**
 * Kelas pengujian untuk Soal 3: Titik dan Garis.
 * Mendemonstrasikan composition (relasi has-a), method overloading pada constructor,
 * serta pentingnya defensive copy untuk mencegah aliasing.
 */
public class TesSoal3 {

    /**
     * Titik masuk program pengujian Soal 3.
     *
     * @param args argumen baris perintah (tidak digunakan)
     */
    public static void main(String[] args) {
        Garis g = new Garis(0, 0, 3, 4);
        System.out.println(g + " panjang=" + g.getPanjang());

        Titik t = new Titik(1, 1);
        Garis g2 = new Garis(t, new Titik(5, 5));
        t.setX(100);
        System.out.println(g2);
    }
}

