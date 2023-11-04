// Input pendapatan penjualan harian
var pendapatanHarian = 550000;

// Inisialisasi variabel uang jasa dan persentase komisi
var uangJasa = 0;
var persentaseKomisi = 0;

// Menghitung uang jasa dan persentase komisi berdasarkan pendapatan harian
if (pendapatanHarian <= 200000) {
  uangJasa = 10000;
  persentaseKomisi = 10;
} else if (pendapatanHarian <= 500000) {
  uangJasa = 20000;
  persentaseKomisi = 15;
} else {
  uangJasa = 30000;
  persentaseKomisi = 20;
}

// Menghitung total komisi
var komisi = (pendapatanHarian * persentaseKomisi) / 100;

// Menampilkan hasil
console.log("Pendapatan Harian: Rp. " + pendapatanHarian);
console.log("Uang Jasa: Rp. " + uangJasa);
console.log("Persentase Komisi: " + persentaseKomisi + "%");
console.log("Komisi: Rp. " + komisi);
