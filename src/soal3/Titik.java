package soal3;

/**
 * Merepresentasikan sebuah titik dalam sistem koordinat dua dimensi.
 * Menyediakan operasi dasar titik termasuk perhitungan jarak ke titik lain.
 */
public class Titik {

    private double x;
    private double y;

    /**
     * Membuat objek Titik pada posisi asal (0, 0).
     */
    public Titik() {
        this(0, 0);
    }

    /**
     * Membuat objek Titik pada koordinat (x, y) yang ditentukan.
     *
     * @param x koordinat horizontal
     * @param y koordinat vertikal
     */
    public Titik(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Mengembalikan nilai koordinat x titik ini.
     *
     * @return koordinat x
     */
    public double getX() {
        return x;
    }

    /**
     * Mengubah nilai koordinat x titik ini.
     *
     * @param x koordinat x yang baru
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Mengembalikan nilai koordinat y titik ini.
     *
     * @return koordinat y
     */
    public double getY() {
        return y;
    }

    /**
     * Mengubah nilai koordinat y titik ini.
     *
     * @param y koordinat y yang baru
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Menghitung jarak Euclidean dari titik ini ke titik lain yang diberikan.
     * Menggunakan rumus akar dari jumlah kuadrat selisih koordinat.
     *
     * @param lain titik tujuan yang akan dihitung jaraknya
     * @return jarak antara titik ini dan titik lain
     */
    public double jarakKe(Titik lain) {
        double deltaX = this.x - lain.x;
        double deltaY = this.y - lain.y;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    /**
     * Mengembalikan representasi teks titik dalam format (x, y).
     *
     * @return string koordinat titik
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

