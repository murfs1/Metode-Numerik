import java.util.Scanner;

public class tugasSesiDua {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan bilangan: ");
        int bilangan = scanner.nextInt();

        long hasil = hitungPangkatDuaIteratif(bilangan);
        System.out.println("Hasil pangkat dua dari " + bilangan + " adalah: " + hasil);
    }

    public static long hitungPangkatDuaIteratif(int bilangan) {
        long hasil = 1;

        for (int i = 0; i < 2; i++) {  // Melakukan iterasi dua kali untuk pangkat dua
            hasil *= bilangan;
        }

        return hasil;
    }

}
