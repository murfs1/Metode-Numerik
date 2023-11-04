import java.util.Scanner;

public class tugasSesi2 {
   public static void main(String[] args){

    Scanner scan = new Scanner(System.in);

    System.out.print("Masukkan bilangan yang mau di pangkatkan : " );
    int angka = scan.nextInt();

    int hasilPangkat = angka*angka;

    System.out.print("pangkat dua dari "+ angka + " adalah " + hasilPangkat);

    scan.close();
   } 
}
