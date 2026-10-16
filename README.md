# EquiMind: Program Analitik Tingkat Risiko, Stress, dan Beban Kerja Karyawan

[![HTML](https://img.shields.io/badge/HTML-5-blue)] [![CSS](https://img.shields.io/badge/CSS-3-blue)] [![JavaScript](https://img.shields.io/badge/JavaScript-ES6-yellow)] [![Bootstrap](https://img.shields.io/badge/Bootstrap-5.3.3-purple)]

EquiMind adalah sebuah platform inovatif yang dirancang untuk menganalisis tingkat risiko, stress, dan beban kerja karyawan di sebuah perusahaan. Dengan antarmuka yang intuitif dan fitur-fitur canggih, EquiMind membantu organisasi memahami kondisi kerja karyawannya secara akurat, cepat, dan presisi, yang pada akhirnya berkontribusi pada peningkatan kesejahteraan dan produktivitas.

## Table of Contents 📜

* [Tentang Proyek](#tentang-proyek)
* [Fitur Utama](#fitur-utama) ✨
* [Teknologi yang Digunakan](#teknologi-yang-digunakan) 💻
* [Struktur Proyek](#struktur-proyek) 📁
* [Cara Penggunaan](#cara-penggunaan) ▶️
* [Instalasi](#instalasi) ⚙️
* [Penggunaan Nyata](#penggunaan-nyata) 💡
* [Kontribusi](#kontribusi) 🤝
* [Lisensi](#lisensi) 📄
* [Tentang Pengembang](#tentang-pengembang) 👨‍💻

## Tentang Proyek 🚀

Proyek ini bertujuan untuk menyediakan solusi komprehensif bagi perusahaan dalam mengukur dan mengelola berbagai aspek kesejahteraan karyawan, termasuk:

*   **Analisis Tingkat Risiko:** Mengidentifikasi potensi risiko pekerjaan yang dapat mempengaruhi karyawan.
*   **Pengukuran Stress:** Memantau tingkat stress karyawan melalui survei terstruktur.
*   **Evaluasi Beban Kerja:** Menganalisis beban kerja karyawan untuk memastikan keseimbangan yang sehat.

Platform ini dirancang untuk memberikan wawasan mendalam kepada manajemen mengenai kondisi internal perusahaan, memungkinkan pengambilan keputusan yang lebih baik untuk meningkatkan lingkungan kerja.

## Fitur Utama ✨

*   **Login & Registrasi Pengguna:** Sistem otentikasi yang aman untuk karyawan dan manajer.
*   **Dashboard Karyawan:** Tampilan ringkasan dan navigasi untuk pengguna biasa.
*   **Dashboard Manajer:** Fitur tambahan untuk mengelola tugas dan melihat data agregat.
*   **Profil Pengguna:** Halaman untuk melihat dan mengelola informasi profil pribadi.
*   **Survei Beban Kerja & Stress:** Kuesioner terstruktur untuk mengumpulkan data subjektif karyawan.
*   **Alokasi Tugas (Manajer):** Fitur untuk manajer dalam menugaskan tugas kepada karyawan.
*   **Desain Responsif:** Antarmuka yang beradaptasi dengan berbagai ukuran layar (desktop, tablet, mobile).
*   **Integrasi Bootstrap:** Menggunakan Bootstrap untuk styling yang cepat dan konsisten.
*   **Visualisasi Waktu:** Menampilkan tanggal dan waktu real-time di top bar.

## Teknologi yang Digunakan 💻

*   **Bahasa Pemrograman:** HTML, CSS, JavaScript
*   **Framework & Library:** Bootstrap (v5.3.3 & v6.0.0-alpha.1)
*   **Icon Library:** Bootstrap Icons
*   **Font:** Montserrat, Bodoni Moda

## Struktur Proyek 📁

```
Program-Analitik-Tingkat-Risiko-Stress-dan-Beban-Kerja-Karyawan/
├── CSS/
│   ├── index.css
│   ├── karyawan/
│   │   ├── dashboard_karyawan.css
│   │   ├── profile.css
│   │   └── survei.css
│   ├── manajer/
│   │   ├── dashboard_manajer.css
│   │   ├── form_task.css
│   │   └── profile.css
│   └── signup.css
├── Diagram.vsdx
├── html/
│   ├── karyawan/
│   │   ├── dashboard_karyawan.html
│   │   ├── profile.html
│   │   └── survei.html
│   └── manajer/
│       ├── alokasi_tugas.html
│       ├── dashboard_manajer.html
│       └── profile.html
├── JavaScript/
│   └── tanggal.js
├── index.html
├── signup.html
├── LOGO.cdr
├── .prettierrc
└── README.md
```

## Cara Penggunaan ▶️

Proyek ini merupakan aplikasi web frontend yang dirancang untuk diakses melalui browser.

1.  **Login:** Buka `html/index.html` di browser Anda. Masukkan email dan password untuk login.
2.  **Registrasi:** Jika belum memiliki akun, buka `html/signup.html` untuk membuat akun baru.
3.  **Navigasi Karyawan:** Setelah login sebagai karyawan, Anda dapat mengakses:
    *   **Dashboard:** Tampilan utama setelah login.
    *   **Profile:** Melihat dan mengelola informasi profil Anda.
    *   **Survei:** Mengisi kuesioner terkait beban kerja dan stress.
4.  **Navigasi Manajer:** Setelah login sebagai manajer, Anda memiliki akses ke:
    *   **Dashboard:** Tampilan ringkasan manajer.
    *   **Profile:** Mengelola profil manajer.
    *   **Alokasi Tugas:** Membuat dan menugaskan tugas kepada karyawan.

## Instalasi ⚙️

Proyek ini tidak memerlukan instalasi khusus karena merupakan aplikasi web frontend yang berjalan di browser.

1.  **Clone Repository:**
    ```bash
    git clone https://github.com/Rizalnendian/Program-Analitik-Tingkat-Risiko-Stress-dan-Beban-Kerja-Karyawan.git
    cd Program-Analitik-Tingkat-Risiko-Stress-dan-Beban-Kerja-Karyawan
    ```
2.  **Buka di Browser:** Buka file `html/index.html` (untuk halaman login) atau `html/signup.html` (untuk registrasi) langsung dari browser Anda.

**Catatan:** Proyek ini bergantung pada file-file statis (HTML, CSS, JavaScript) dan tidak memerlukan server backend atau database untuk fungsionalitas dasar yang ditampilkan.

## Penggunaan Nyata 💡

*   **Perusahaan:** Menggunakan EquiMind untuk memantau kesejahteraan karyawan, mengidentifikasi area yang memerlukan perbaikan dalam lingkungan kerja, dan mengelola beban kerja tim secara efektif.
*   **Manajer:** Memanfaatkan fitur alokasi tugas untuk mendistribusikan pekerjaan secara efisien dan memantau progres tim.
*   **Karyawan:** Memberikan umpan balik jujur melalui survei untuk berkontribusi pada penciptaan lingkungan kerja yang lebih baik, serta melihat informasi profil mereka.

## Kontribusi 🤝

Kontribusi selalu diterima! Jika Anda ingin berkontribusi pada proyek ini, silakan:

1.  Fork repository ini.
2.  Buat branch fitur baru (`git checkout -b feature/AmazingFeature`).
3.  Commit perubahan Anda (`git commit -m 'Add some AmazingFeature'`).
4.  Push ke branch (`git push origin feature/AmazingFeature`).
5.  Buka Pull Request.

Silakan laporkan isu atau ajukan saran melalui fitur 'Issues' di GitHub.

## Lisensi 📄

Tidak ada lisensi yang ditentukan dalam repositori ini.

## Tentang Pengembang 👨‍💻

*   **Frontend:** Rizalnendian
*   **Backend:** Firdaus
*   **URL Repositori:** [https://github.com/Rizalnendian/Program-Analitik-Tingkat-Risiko-Stress-dan-Beban-Kerja-Karyawan](https://github.com/Rizalnendian/Program-Analitik-Tingkat-Risiko-Stress-dan-Beban-Kerja-Karyawan)

## Footer 🛠️

© 2026 Program-Analitik-Tingkat-Risiko-Stress-dan-Beban-Kerja-Karyawan

[Kembali ke Atas](#table-of-contents)

--- ✨


