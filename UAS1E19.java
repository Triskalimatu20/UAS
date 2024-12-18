import java.util.Scanner;

public class UAS1E19 {
    static String[][] skorTim = new String[10][4]; // [Nama Tim, Level 1, Level 2, Total Skor]
    static int jumlahTim = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean lanjut = true;

        while (lanjut) {
            System.out.println("\n=== MENU UTAMA ===");
            System.out.println("1. Input Data Skor Tim");
            System.out.println("2. Tampilkan Tabel Skor");
            System.out.println("3. Tentukan Juara");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");
            int menu = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (menu) {
                case 1:
                    inputSkorTim();
                    break;
                case 2:
                    tampilkanTabelSkor();
                    break;
                case 3:
                    tentukanJuara();
                    break;
                case 4:
                    System.out.println("Keluar dari program. Terima kasih!");
                    lanjut = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid, coba lagi!");
            }
        }
    }

    public static void inputSkorTim() {
        // Loop untuk memasukkan data tim, berhenti setelah 4 tim
        while (jumlahTim < 4) { // Ulangi selama jumlahTim kurang dari 4
            System.out.print("\nMasukkan nama tim ke-" + (jumlahTim + 1) + ": ");
            String namaTim = scanner.nextLine();
    
            int skorLevel1;
            while (true) {
                System.out.print("Masukkan skor " + namaTim + " untuk Level 1: ");
                if (scanner.hasNextInt()) {
                    skorLevel1 = scanner.nextInt();
                    if (skorLevel1 < 0) {
                        System.out.println("Skor tidak boleh negatif. Masukkan input ulang.");
                        continue; // Minta input ulang jika skor negatif
                    }
                    if (skorLevel1 < 35) {
                        skorLevel1 = 0;
                        System.out.println("Skor Level 1 kurang dari 35, maka skor dianggap 0.");
                    }
                    break; // Input valid, keluar dari loop
                } else {
                    System.out.println("Input tidak valid. Masukkan angka.");
                    scanner.next(); // Membersihkan input yang salah
                }
            }
    
            int skorLevel2;
            while (true) {
                System.out.print("Masukkan skor " + namaTim + " untuk Level 2: ");
                if (scanner.hasNextInt()) {
                    skorLevel2 = scanner.nextInt();
                    if (skorLevel2 < 0) {
                        System.out.println("Skor tidak boleh negatif. Masukkan input ulang.");
                        continue; // Minta input ulang jika skor negatif
                    }
                    break; // Input valid, keluar dari loop
                } else {
                    System.out.println("Input tidak valid. Masukkan angka.");
                    scanner.next(); // Membersihkan input yang salah
                }
            }
            scanner.nextLine(); // Membersihkan buffer setelah nextInt()
    
            // Menghitung total skor
            int totalSkor = skorLevel1 + skorLevel2;
    
            // Menyimpan data tim dalam array
            skorTim[jumlahTim][0] = namaTim;
            skorTim[jumlahTim][1] = String.valueOf(skorLevel1);
            skorTim[jumlahTim][2] = String.valueOf(skorLevel2);
            skorTim[jumlahTim][3] = String.valueOf(totalSkor);
    
            // Menambah jumlah tim yang telah dimasukkan
            jumlahTim++;
    
            // Setelah 4 tim selesai, keluar dari loop dan kembali ke menu utama
            if (jumlahTim == 4) {
                break; // Keluar dari loop input tim dan kembali ke menu utama
            }
        }
    }    

    // Tampilkan Tabel Skor
    public static void tampilkanTabelSkor() {
        if (jumlahTim == 0) {
            System.out.println("Tidak ada data yang bisa ditampilkan.");
            return;
        }

        System.out.println("\nTabel Skor Turnamen");
        System.out.printf("%-15s %-10s %-10s %-10s\n", "Nama Tim", "Level 1", "Level 2", "Total Skor");

        for (int i = 0; i < jumlahTim; i++) {
            System.out.printf("%-15s %-10s %-10s %-10s\n", skorTim[i][0], skorTim[i][1], skorTim[i][2], skorTim[i][3]);
        }
    }

    // Tentukan Juara
    public static void tentukanJuara() {
        if (jumlahTim == 0) {
            System.out.println("Tidak ada data untuk menentukan juara.");
            return;
        }

        String juaraTim = skorTim[0][0];
        int skorTertinggi = Integer.parseInt(skorTim[0][3]);

        for (int i = 1; i < jumlahTim; i++) {
            int totalSkor = Integer.parseInt(skorTim[i][3]);
            if (totalSkor > skorTertinggi) {
                juaraTim = skorTim[i][0];
                skorTertinggi = totalSkor;
            }
        }

        System.out.println("Selamat kepada Tim " + juaraTim + " yang telah memenangkan kompetisi dengan skor " + skorTertinggi +"!");
    }
}
