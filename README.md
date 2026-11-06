# Tugas 2 – Inheritance, Composition, dan Polimorfisme

| Keterangan | Detail |
|---|---|
| **Nama** | Reza Nurhakim |
| **NPM** | 250810701100054 |
| **Kelas** | Praktikum PBO A |
| **Repository** | [Tugas2_Inherit-polymorph-2554](https://github.com/rezaanaksoleh213-boop/Tugas2_Inherit-polymorph-2554) |

---

## Deskripsi Singkat

Tugas ini mengimplementasikan empat soal yang menguji konsep inti Pemrograman Berorientasi Objek: inheritance berlapis, komposisi objek, dan polimorfisme. Program ditulis dalam Java murni (tanpa BlueJ), dibagi ke dalam empat package terpisah sesuai soal.

---

## Fitur Utama

| Soal | Fungsionalitas |
|---|---|
| **Soal 1** | Hierarki perangkat elektronik (Perangkat → Laptop/Ponsel → LaptopGaming) dengan validasi input, perhitungan pajak, dan harga promo |
| **Soal 2** | Analisis output polimorfisme, urutan constructor, ClassCastException, dan risiko memanggil method overridable dari constructor |
| **Soal 3** | Objek Garis berbasis komposisi dua Titik, dengan defensive copy untuk mencegah aliasing |
| **Soal 4** | Mini toko digital: keranjang belanja dengan produk fisik, digital, dan langganan, menggunakan polimorfisme penuh dan instanceof aman |

---

## Konsep OOP yang Diterapkan

| Konsep | Lokasi | Alasan |
|---|---|---|
| **Inheritance** | `Laptop extends Perangkat`, `LaptopGaming extends Laptop`, `Ponsel extends Perangkat` | Menghindari duplikasi atribut dan perilaku yang sama pada setiap jenis perangkat |
| **Multi-level inheritance** | `LaptopGaming → Laptop → Perangkat` | Menambah lapisan spesialisasi secara bertahap tanpa menyalin ulang kode |
| **Protected access** | `harga` di `Perangkat` | Memungkinkan `Laptop` mengakses `harga` langsung untuk `hitungHargaPromo()` tanpa membuka akses ke luar hierarki |
| **super()** | Semua constructor subclass | Meneruskan inisialisasi ke superclass sesuai aturan Java |
| **Method overriding** | `infoSingkat()`, `hitungHargaAkhir()`, `deskripsi()` | Polimorfisme sehingga perilaku setiap kelas dapat berbeda tanpa mengubah kode pemanggil |
| **Composition (has-a)** | `Garis` memiliki dua `Titik`; `Keranjang` memiliki `ArrayList<Produk>` | Lebih fleksibel daripada inheritance bila tidak ada relasi is-a yang nyata |
| **Defensive copy** | Constructor `Garis(Titik, Titik)` | Mencegah aliasing agar perubahan titik eksternal tidak memengaruhi isi `Garis` |
| **Polimorfisme** | `cetakStruk()` dan `hitungTotal()` di `Keranjang` | Loop atas daftar `Produk` tanpa instanceof; perilaku ditentukan oleh tipe dinamis |
| **Upcasting** | `Hewan h = new Kucing("Tom")` | Menyimpan subclass dalam variabel superclass, digunakan untuk polimorfisme |
| **Downcasting aman** | `hitungPerJenis()` di `Keranjang` | Memakai instanceof sebelum cast untuk menghindari ClassCastException |
| **Abstract class** | `Produk` di soal4 | Mendefinisikan kontrak yang wajib diimplementasikan oleh setiap jenis produk |

---

## Struktur Project

```
Tugas2_Inherit-polymorph-2554/
├── src/
│   ├── soal1/
│   │   ├── Perangkat.java       ← superclass dengan harga (protected)
│   │   ├── Laptop.java          ← extends Perangkat
│   │   ├── Ponsel.java          ← extends Perangkat
│   │   ├── LaptopGaming.java    ← extends Laptop (multi-level)
│   │   └── TesSoal1.java
│   ├── soal2/
│   │   ├── Hewan.java
│   │   ├── Kucing.java
│   │   ├── A.java
│   │   ├── B.java
│   │   ├── Lingkaran.java
│   │   ├── Titik.java
│   │   └── TesSoal2.java
│   ├── soal3/
│   │   ├── Titik.java
│   │   ├── Garis.java           ← composition dari dua Titik
│   │   └── TesSoal3.java
│   └── soal4/
│       ├── Produk.java          ← abstract superclass
│       ├── ProdukFisik.java
│       ├── ProdukDigital.java
│       ├── Langganan.java       ← extends ProdukDigital
│       ├── ProdukBundel.java    ← tantangan opsional (composite)
│       ├── Keranjang.java       ← composition dari List<Produk>
│       └── TesSoal4.java
├── .gitignore
└── README.md
```

---

## Prasyarat

- **JDK**: 17 atau lebih baru (menggunakan pattern matching untuk instanceof, fitur Java 16+)
- **IDE yang disarankan**: IntelliJ IDEA

---

## Cara Menjalankan

### Via IntelliJ IDEA
1. Buka project (folder root ini) di IntelliJ.
2. Tandai folder `src` sebagai **Sources Root** (klik kanan → Mark Directory as → Sources Root).
3. Buat Run Configuration untuk masing-masing kelas tes (`TesSoal1` s.d. `TesSoal4`), dengan field **Main class** diisi lengkap: `soal1.TesSoal1`, dst.
4. Klik **Run**.

### Via Command Line
```bash
# Dari folder root project
javac -d out src/soal1/*.java src/soal2/*.java src/soal3/*.java src/soal4/*.java

java -cp out soal1.TesSoal1
java -cp out soal2.TesSoal2
java -cp out soal3.TesSoal3
java -cp out soal4.TesSoal4
```

---

## Contoh Output

### Soal 1
```
Asus | garansi 24 bulan | RAM 16 GB | layar 14.0 inci
Samsung | garansi 12 bulan | 128 GB | 3 kamera
MSI | garansi 18 bulan | RAM 32 GB | layar 15.6 inci | GPU RTX 4060
Pajak laptop: Rp800000
Promo laptop 10 persen: Rp7200000
```

### Soal 2 – Bagian A
```
Hewan dibuat: Tom
Kucing dibuat
Tom makan
meong
meong
Tom memanjat
Hewan dibuat: Generik
h2 bukan Kucing, downcasting dilewati.
```

### Soal 2 – Bagian B
```
A dibuat
init B, nilai=0
B dibuat, nilai=5
```

### Soal 2 – Bagian C
```
78.53981633974483
0.0
0.0
```

### Soal 3
```
(0.0, 0.0) - (3.0, 4.0) panjang=5.0
(1.0, 1.0) - (5.0, 5.0)
```

### Soal 4
```
F01 | Keyboard Mekanik | fisik 1.5 kg | Rp515000
D01 | Ebook Java | digital 20.0 MB | Rp90000
L01 | Kelas Online | langganan 12 bulan | Rp1440000
TOTAL: Rp2045000
Fisik: 1, Digital: 1, Langganan: 1
Gagal: Produk dengan kode 'F01' sudah ada di keranjang.
```

---

## Jawaban Soal dan Analisis Konsep

### Soal 1 – Pertanyaan Tambahan: Jika `harga` Dijadikan `private`

Jika atribut `harga` di kelas `Perangkat` diubah dari `protected` menjadi `private`, maka akan muncul error kompilasi seperti ini saat mengompilasi `Laptop.java`:

```
error: harga has private access in Perangkat
        return harga * (1 - diskonPersen / 100);
               ^
```

Error ini muncul karena atribut `private` hanya dapat diakses dari dalam kelas itu sendiri (dalam hal ini `Perangkat`). Subclass seperti `Laptop` tidak mendapatkan akses ke atribut `private` superclass, meskipun `Laptop` adalah turunan langsung dari `Perangkat`. Solusinya adalah menggunakan `protected` (seperti semula) agar atribut tetap tersembunyi dari luar hierarki tetapi bisa diakses oleh subclass, atau menyediakan getter `getHarga()` lalu memakai getter tersebut di `Laptop`.

---

### Soal 2 – Jawaban Pertanyaan

**Pertanyaan 1 – Output lengkap Bagian A:**
```
Hewan dibuat: Tom
Kucing dibuat
Tom makan
meong
meong
Tom memanjat
Hewan dibuat: Generik
```
Program berhenti dengan `ClassCastException` pada baris `Kucing k2 = (Kucing) h2` karena tipe dinamis `h2` adalah `Hewan`, bukan `Kucing`.

**Pertanyaan 2 – Jika `h.panjat()` tidak dikomentari:**
Error terjadi pada tahap **kompilasi**, bukan runtime. Sebab: tipe statis variabel `h` adalah `Hewan`, dan kelas `Hewan` tidak memiliki method `panjat()`. Compiler Java memeriksa ketersediaan method berdasarkan tipe statis variabel, bukan tipe dinamis objek yang ditunjuk.

**Pertanyaan 3 – Baris yang menyebabkan `ClassCastException`:**
Baris `Kucing k2 = (Kucing) h2;` — tipe dinamis `h2` adalah `Hewan` biasa, bukan `Kucing`, sehingga cast tidak valid di runtime. Perbaikan dengan `instanceof`:
```java
if (h2 instanceof Kucing k2) {
    k2.panjat();
} else {
    System.out.println("h2 bukan Kucing, downcasting dilewati.");
}
```

**Pertanyaan 4 – Method `suara()` milik kelas mana yang dijalankan pada `h.makan()`?**
Yang dijalankan adalah `suara()` milik kelas **Kucing**. Tipe statis `h` adalah `Hewan`, tetapi tipe dinamisnya (objek yang sebenarnya ditunjuk) adalah `Kucing`. Java menggunakan **dynamic dispatch** (virtual method invocation): ketika memanggil method yang bisa di-override, JVM melihat tipe dinamis objek di heap, bukan tipe statis variabel. Sehingga meskipun `makan()` ditulis di `Hewan` dan memanggil `suara()`, JVM tetap menjalankan `suara()` versi `Kucing`.

**Pertanyaan 5 – Output `new B()` dan penjelasan:**
```
A dibuat
init B, nilai=0
B dibuat, nilai=5
```
Ketika `new B()` dipanggil, JVM pertama-tama menjalankan constructor `A`. Di dalam constructor `A`, `init()` dipanggil. Karena JVM menggunakan dynamic dispatch, `init()` versi `B` yang dijalankan. Saat itu, field `nilai` di `B` **belum diinisialisasi ke 5** karena inisialisasi field instance (`int nilai = 5`) baru dilakukan setelah constructor superclass selesai. Nilai default `int` adalah `0`, sehingga tercetak `init B, nilai=0`. Risiko ini adalah alasan mengapa **memanggil method yang dapat di-override dari dalam constructor sangat berbahaya**: subclass bisa belum siap saat method-nya dipanggil, berpotensi memunculkan `NullPointerException` atau hasil yang tidak terduga.

**Pertanyaan 6 – Mengapa `l3.luas()` menghasilkan 0.0?**
Karena tipe dinamis `l3` adalah `Titik`, bukan `Lingkaran`. Meskipun tipe statis variabelnya `Lingkaran`, JVM selalu mengeksekusi versi method berdasarkan tipe dinamis objek (dynamic dispatch). Relasi "Titik adalah sebuah Lingkaran" (is-a) **tidak masuk akal** secara konseptual; titik bukanlah lingkaran hanya dengan jari-jari nol. Konsekuensinya: jika suatu method mengharapkan `Lingkaran` yang selalu punya luas > 0, ia bisa menerima `Titik` yang mengembalikan 0 dan menyebabkan pembagian dengan nol atau hasil yang tidak valid. Ini adalah pelanggaran Liskov Substitution Principle (LSP).

---

### Soal 3 – Jawaban Pertanyaan

**Pertanyaan 1 – Apa yang tercetak pada baris kedua (sebelum defensive copy)?**
Tanpa defensive copy, `g2` menyimpan referensi ke objek `Titik` yang sama dengan variabel `t`. Ketika `t.setX(100)` dipanggil, titik awal `g2` juga berubah. Baris kedua akan mencetak:
```
(100.0, 1.0) - (5.0, 5.0)
```
Ini disebut **aliasing** — dua variabel menunjuk ke objek yang sama.

**Pertanyaan 2 – Setelah defensive copy diperbaiki:**
Constructor `Garis` membuat salinan baru dari setiap `Titik` yang diterima. Sehingga perubahan pada `t` tidak lagi memengaruhi `g2`. Baris kedua mencetak:
```
(1.0, 1.0) - (5.0, 5.0)
```

**Pertanyaan 3 – Kapan masing-masing lebih tepat?**
- **Aliasing (tanpa defensive copy)** lebih tepat jika objek yang di-share memang dimaksudkan untuk diedit bersama (misalnya, penanda real-time yang bergerak).
- **Defensive copy** lebih tepat saat objek harus bersifat independen dan tidak ingin perubahan luar memengaruhi isi objek yang menyimpannya.

**Pertanyaan 4 – Masalah desain jika `Garis extends Titik`:**
- **Relasi is-a salah**: "Garis adalah sebuah Titik" tidak masuk akal. Garis bukan titik.
- **Relasi has-a yang lebih tepat diabaikan**: Garis memiliki dua titik, bukan menjadi satu titik.
- Inheritance akan memaksa `Garis` mewarisi `x` dan `y` dari `Titik`, padahal garis butuh dua pasang koordinat.
- Polimorfisme menjadi rusak: kode yang mengharapkan `Titik` bisa menerima `Garis` secara tidak sengaja.

---

### Analisis Konsep

**1. Perbedaan Method Overriding dan Method Overloading**

**Method overriding** terjadi ketika subclass mendefinisikan ulang method dengan nama dan tanda tangan (signature) yang **sama persis** dengan method di superclass, ditandai `@Override`. Contoh: `infoSingkat()` di `Laptop` meng-override `infoSingkat()` di `Perangkat`. Overriding berkaitan erat dengan inheritance dan polimorfisme: JVM menentukan versi method yang dipanggil berdasarkan tipe dinamis objek saat runtime.

**Method overloading** terjadi ketika sebuah kelas memiliki beberapa method dengan nama yang **sama** tetapi parameter yang **berbeda** (jumlah atau tipe). Contoh: `Garis` di soal 3 memiliki dua constructor — satu menerima dua objek `Titik`, satunya menerima empat `double`. Ini adalah overloading. Overloading diselesaikan oleh compiler berdasarkan tipe argumen yang diberikan saat compile time.

**2. Kapan Memilih Inheritance, Kapan Memilih Composition?**

Gunakan **inheritance** ketika ada relasi is-a yang nyata dan subclass memang merupakan versi yang lebih spesifik dari superclass. Contoh: `Laptop` adalah sebuah `Perangkat` — ini wajar karena semua laptop memiliki merek, harga, dan garansi.

Gunakan **composition** ketika relasi yang ada adalah has-a. Contoh: `Garis` memiliki dua `Titik` — ini lebih tepat daripada membuat `Garis extends Titik`, karena garis bukanlah titik. Composition juga lebih fleksibel saat hierarki kelas berubah.

**3. Mengapa `cetakStruk()` Tidak Perlu instanceof, Sedangkan `hitungPerJenis()` Perlu?**

`cetakStruk()` hanya memanggil `deskripsi()` dan `hitungHargaAkhir()` yang didefinisikan di `Produk` sebagai method abstract. Setiap subclass sudah menyediakan implementasinya, sehingga polimorfisme cukup untuk menentukan perilaku yang benar — tidak perlu tahu jenis spesifiknya.

`hitungPerJenis()` perlu instanceof karena tugasnya justru membedakan jenis produk untuk menghitung jumlah per kategori. Ini adalah kasus di mana kita memerlukan informasi tipe dinamis objek secara eksplisit, yang tidak bisa diperoleh dari interface umum `Produk`.

Downcasting tidak selalu aman karena JVM hanya bisa memastikan kebenaran cast saat runtime, bukan saat compile time. Jika objek yang di-cast tidak benar-benar merupakan instance dari tipe target, `ClassCastException` dilempar. Oleh karena itu, selalu gunakan `instanceof` sebelum melakukan cast eksplisit.

---

## Batasan dan Pengembangan Lanjutan

- Tantangan opsional `ProdukBundel` belum diimplementasikan.
- Belum ada mekanisme persistensi (database atau file) untuk menyimpan produk dan keranjang.
- Keranjang belum mendukung penghapusan produk atau pembaruan kuantitas.

