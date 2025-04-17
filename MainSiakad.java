import java.util.Scanner;

public class MainSiakad {

    public static void bubbleSortNilai(Nilai[] data, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (data[j].hitungNilaiAkhir() < data[j + 1].hitungNilaiAkhir()) {
                    Nilai temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    public static void cariMahasiswaByNIM(Nilai[] data, int n, String nim) {
        boolean ditemukan = false;
        for (int i = 0; i < n; i++) {
            if (data[i].mahasiswa.getNim().equals(nim)) {
                data[i].tampilkanData();
                System.out.println("------------------------");
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Mahasiswa[] daftarMahasiswa = {
            new Mahasiswa("22001", "Ali Rahman"),
            new Mahasiswa("22002", "Budi Santoso"),
            new Mahasiswa("22003", "Citra Dewi")
        };

        MataKuliah[] daftarMK = {
            new MataKuliah("MK001", "Struktur Data"),
            new MataKuliah("MK002", "Basis Data"),
            new MataKuliah("MK003", "Desain Web")
        };

        Nilai[] daftarNilai = {
            new Nilai(daftarMahasiswa[0], daftarMK[0], 80, 85, 90), 
            new Nilai(daftarMahasiswa[0], daftarMK[1], 60, 75, 70), 
            new Nilai(daftarMahasiswa[1], daftarMK[0], 75, 70, 80), 
            new Nilai(daftarMahasiswa[2], daftarMK[2], 80, 90, 65) 
        };
        int jumlahNilai = daftarNilai.length;

        int pilihan;
        do {
            System.out.println("\n===== MENU SIAKAD =====");
            System.out.println("1. Tampilkan Data Mahasiswa dan Mata Kuliah");
            System.out.println("2. Input Nilai Mahasiswa");
            System.out.println("3. Tampilkan Daftar Nilai Mahasiswa");
            System.out.println("4. Urutkan Mahasiswa Berdasarkan Nilai Akhir");
            System.out.println("5. Cari Mahasiswa Berdasarkan NIM");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.println("\n=== Data Mahasiswa ===");
                    for (int i = 0; i < daftarMahasiswa.length; i++) {
                        System.out.println((i + 1) + ". " + daftarMahasiswa[i].getNim() + " - " + daftarMahasiswa[i].getNama());
                    }

                    System.out.println("\n=== Data Mata Kuliah ===");
                    for (int i = 0; i < daftarMK.length; i++) {
                        System.out.println((i + 1) + ". " + daftarMK[i].getKodeMK() + " - " + daftarMK[i].getNamaMK());
                    }
                    break;

                case 2:
                    System.out.println("\n== Input Nilai Mahasiswa ==");
                    System.out.println("Pilih Mahasiswa:");
                    for (int i = 0; i < daftarMahasiswa.length; i++) {
                        System.out.println((i + 1) + ". " + daftarMahasiswa[i].getNama());
                    }
                    System.out.print("Masukkan pilihan: ");
                    int indexMhs = input.nextInt() - 1;

                    System.out.println("Pilih Mata Kuliah:");
                    for (int i = 0; i < daftarMK.length; i++) {
                        System.out.println((i + 1) + ". " + daftarMK[i].getNamaMK());
                    }
                    System.out.print("Masukkan pilihan: ");
                    int indexMK = input.nextInt() - 1;

                    System.out.print("Nilai Tugas: ");
                    double tugas = input.nextDouble();
                    System.out.print("Nilai UTS  : ");
                    double uts = input.nextDouble();
                    System.out.print("Nilai UAS  : ");
                    double uas = input.nextDouble();

                    daftarNilai[jumlahNilai] = new Nilai(daftarMahasiswa[indexMhs], daftarMK[indexMK], tugas, uts, uas);
                    jumlahNilai++;

                    System.out.println("Data nilai berhasil ditambahkan!");
                    break;

                case 3:
                    System.out.println("\n=== Daftar Nilai Mahasiswa ===");
                    if (jumlahNilai == 0) {
                        System.out.println("Belum ada data nilai.");
                    } else {
                        for (int i = 0; i < jumlahNilai; i++) {
                            System.out.println("Data ke-" + (i + 1));
                            daftarNilai[i].tampilkanData();
                            System.out.println("-------------------------------");
                        }
                    }
                    break;

                case 4:
                    System.out.println("\n== Sorting Nilai Akhir Mahasiswa (Descending) ==");
                    if (jumlahNilai == 0) {
                        System.out.println("Belum ada data nilai untuk diurutkan.");
                    } else {
                        bubbleSortNilai(daftarNilai, jumlahNilai);
                        System.out.println("Data berhasil diurutkan berdasarkan nilai akhir.");
                        for (int i = 0; i < jumlahNilai; i++) {
                            System.out.println("Ranking " + (i + 1));
                            daftarNilai[i].tampilkanData();
                            System.out.println("------------------------");
                        }
                    }
                    break;

                case 5:
                    input.nextLine(); // clear buffer
                    System.out.println("\n== Cari Nilai Mahasiswa berdasarkan NIM ==");
                    System.out.print("Masukkan NIM Mahasiswa: ");
                    String cariNIM = input.nextLine();
                    cariMahasiswaByNIM(daftarNilai, jumlahNilai, cariNIM);
                    break;

                case 0:
                    System.out.println("Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);

        input.close();
    }
}
