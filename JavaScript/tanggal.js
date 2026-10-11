// Fungsi untuk mengambil waktu dasar dari API
async function dapatkanWaktuAPI() {
    try {
        // Menggunakan endpoint /ip untuk mendeteksi wilayah pengguna secara otomatis
        const respon = await fetch('https://timeapi.world');
        const data = await respon.json();

        // Mengonversi string ISO 8601 dari API menjadi objek Date JavaScript
        let waktuServer = new Date(data.datetime);

        // Jalankan jam realtime berbasis waktu server yang sudah didapatkan
        mulaiJamRealtime(waktuServer);
    } catch (error) {
        console.error(
            'Gagal mengambil data dari API, menggunakan waktu lokal perangkat:',
            error
        );
        // Cadangan jika API bermasalah: gunakan waktu lokal perangkat
        mulaiJamRealtime(new Date());
    }
}

// Fungsi untuk menjalankan jam agar terus berdetak setiap detik
function mulaiJamRealtime(waktuAwal) {
    let waktuSekarang = waktuAwal;

    setInterval(() => {
        // Tambahkan 1 detik ke objek waktu setiap interval berjalan
        waktuSekarang.setSeconds(waktuSekarang.getSeconds() + 1);

        // Opsi format untuk Hari dan Tanggal (Bahasa Indonesia)
        const opsiTanggal = {
            weekday: 'long',
            year: 'numeric',
            month: 'long',
            day: 'numeric',
        };

        // Format Jam (HH:MM:SS)
        const opsiJam = {
            hour: '2-digit',
            minute: '2-digit',
            second: '2-digit',
            hour12: false,
        };

        // Tampilkan hasil format ke elemen HTML
        document.getElementById('hari-tanggal').innerText =
            waktuSekarang.toLocaleDateString('id-ID', opsiTanggal);
        document.getElementById('jam').innerText =
            waktuSekarang.toLocaleTimeString('id-ID', opsiJam);
    }, 1000); // Diperbarui setiap 1 detik
}

// Panggil fungsi API saat halaman selesai dimuat
window.onload = dapatkanWaktuAPI;
