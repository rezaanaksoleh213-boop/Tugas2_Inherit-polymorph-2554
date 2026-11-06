package soal2;

/**
 * Merepresentasikan lingkaran dengan atribut jari-jari.
 * Menyediakan perhitungan luas dan keliling menggunakan konstanta Math.PI.
 */
public class Lingkaran {

    private double jariJari;

    /**
     * Membuat objek Lingkaran baru dengan jari-jari yang ditentukan.
     *
     * @param jariJari jari-jari lingkaran
     */
    public Lingkaran(double jariJari) {
        this.jariJari = jariJari;
    }

    /**
     * Mengembalikan jari-jari lingkaran.
     *
     * @return jari-jari lingkaran
     */
    public double getJariJari() {
        return jariJari;
    }

    /**
     * Menghitung luas lingkaran menggunakan rumus pi dikali jari-jari kuadrat.
     *
     * @return luas lingkaran
     */
    public double luas() {
        return Math.PI * jariJari * jariJari;
    }

    /**
     * Menghitung keliling lingkaran menggunakan rumus 2 dikali pi dikali jari-jari.
     *
     * @return keliling lingkaran
     */
    public double keliling() {
        return 2 * Math.PI * jariJari;
    }
}

