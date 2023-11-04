import java.util.Scanner;

public class KonversiNilai {
    public static void main(String[] args) {
        // Membuat objek Scanner untuk menerima input dari pengguna
        Scanner scanner = new Scanner(System.in);
        
        // Meminta pengguna memasukkan nilai
        System.out.print("Masukkan nilai Anda: ");
        int nilai = scanner.nextInt();
        
        // Menggunakan if-else untuk mengkonversi nilai ke huruf
        String nilaiHuruf;
        if (nilai >= 85 && nilai <= 100) {
            nilaiHuruf = "A";
        } else if (nilai >= 75 && nilai < 85) {
            nilaiHuruf = "B";
        } else if (nilai >= 65 && nilai < 75) {
            nilaiHuruf = "C";
        } else if (nilai >= 55 && nilai < 65) {
            nilaiHuruf = "D";
        } else if (nilai < 55 && nilai >= 0) {
            nilaiHuruf = "E";
        } else {
            nilaiHuruf = "Nilai tidak valid"; // Penanganan nilai di luar rentang valid
        }
        
        // Menampilkan hasil konversi
        System.out.println("Nilai Anda dalam huruf: " + nilaiHuruf);
        
        // Menutup objek Scanner
        scanner.close();
    }
}