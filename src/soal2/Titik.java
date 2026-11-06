package soal2;

/**
 * Merepresentasikan titik sebagai subclass dari Lingkaran dengan jari-jari nol.
 * Kelas ini mendemonstrasikan kelemahan relasi is-a yang tidak tepat:
 * "Titik adalah sebuah Lingkaran" tidak masuk akal secara konseptual,
 * meskipun secara teknis dapat dikompilasi dan dijalankan.
 */
public class Titik extends Lingkaran {

    /**
     * Membuat objek Titik dengan jari-jari 0, merepresentasikan sebuah titik.
     */
    public Titik() {
        super(0);
    }

    /**
     * Mengembalikan luas titik, yaitu 0.0, karena jari-jari adalah nol.
     *
     * @return 0.0
     */
    @Override
    public double luas() {
        return 0.0;
    }

    /**
     * Mengembalikan keliling titik, yaitu 0.0, karena jari-jari adalah nol.
     *
     * @return 0.0
     */
    @Override
    public double keliling() {
        return 0.0;
    }
}

