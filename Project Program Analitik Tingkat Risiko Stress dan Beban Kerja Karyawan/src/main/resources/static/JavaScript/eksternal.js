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

const sidebar = document.getElementById('sidebar');
const sidebarToggleBtn = document.getElementById('sidebarToggleBtn');
const sidebarCloseBtn = document.getElementById('sidebarCloseBtn');
const sidebarOverlay = document.getElementById('sidebarOverlay');

function openSidebar() {
    sidebar.classList.add('open');
    sidebarOverlay.classList.add('active');
}

function closeSidebar() {
    sidebar.classList.remove('open');
    sidebarOverlay.classList.remove('active');
}

sidebarToggleBtn.addEventListener('click', openSidebar);
sidebarCloseBtn.addEventListener('click', closeSidebar);
sidebarOverlay.addEventListener('click', closeSidebar);

type = 'module';
src =
    'https://cdn.jsdelivr.net/npm/bootstrap@6.0.0-alpha.1/dist/js/bootstrap.bundle.min.js';
integrity =
    'sha384-1a/pXj49ZQ1aHEmrJ+gMw1otqoVsYwlEnlD8mIfY2TV03r20Y0CN7uqx1tQogjPL';
crossorigin = 'anonymous';

const sliderWrappers = document.querySelectorAll('.slider-wrapper');
sliderWrappers.forEach((wrapper) => {
    const rangeInput = wrapper.querySelector('input[type="range"]');
    const rangeValue = wrapper.querySelector('.slider-value');

    if (rangeInput && rangeValue) {
        rangeInput.addEventListener('input', (e) => {
            rangeValue.textContent = e.target.value;
        });
    }
});
