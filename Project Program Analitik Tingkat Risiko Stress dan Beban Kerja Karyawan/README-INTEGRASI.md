# EquiMind — Frontend + Backend Terintegrasi

Frontend HTML/CSS/JavaScript ditempatkan pada `src/main/resources/static` agar disajikan langsung oleh Spring Boot. Backend menggunakan Java 17, Spring Boot 3.5.5, MySQL, Spring Security, dan JWT.

## Menjalankan
1. Backup database terlebih dahulu.
2. Jalankan MySQL di XAMPP.
3. Pastikan database `analitik_beban_kerja` tersedia. Untuk database baru, jalankan `database/schema.sql`.
4. Untuk database lama, cek tabel `surveys`; jalankan `database/migration_v3_nasa_tlx_weighted.sql` satu kali hanya jika kolom NASA-TLX belum tersedia.
5. Sesuaikan kredensial MySQL di `src/main/resources/application.properties`.
6. Buka terminal pada folder yang berisi `pom.xml`, jalankan `mvn clean` lalu `mvn spring-boot:run`.
7. Buka `http://localhost:8080/`, registrasi di `signup.html`, kemudian login.

## Integrasi yang diaktifkan
- Registrasi: `POST /api/auth/signup`
- Login dan penyimpanan JWT: `POST /api/auth/login`
- Form survei NASA-TLX berbobot: `POST /api/surveys`
- Riwayat survei karyawan: `GET /api/surveys/me`
- Ringkasan dashboard manajer: `GET /api/analytics/dashboard`

Frontend memakai URL API relatif `/api`, sehingga tidak perlu konfigurasi CORS saat diakses melalui server Spring Boot. JWT disimpan di `localStorage` browser.

## Batasan integrasi saat ini
- Form signup memiliki pilihan divisi, tetapi API signup belum menyimpan divisi; profil perlu diisi melalui endpoint profil.
- Halaman profil dan form alokasi tugas visual dari frontend asli belum seluruhnya dipetakan ke request API.
- Form NASA-TLX baru ditambahkan pada halaman survei tanpa menghapus tampilan survei lama. Bobot awal hanyalah contoh dan harus disesuaikan dengan hasil 15 perbandingan berpasangan responden; jumlah bobot wajib 15.
- NASA-TLX mengukur beban kerja subjektif. Label RENDAH/SEDANG/TINGGI merupakan batas operasional aplikasi, bukan kategori klinis resmi.
