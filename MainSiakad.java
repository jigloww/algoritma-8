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
                System.out.print("Mahasiswa ditemukan: "); data[i].tampilkanData();
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
            new Mahasiswa("22001", "Ali Rahman", "Informatika"),
            new Mahasiswa("22002", "Budi Santoso", "Informatika"),
            new Mahasiswa("22003", "Citra Dewi", "Sistem Informasi Bisnis")
        };

        MataKuliah[] daftarMK = {
            new MataKuliah("MK001", "Struktur Data", 3),
            new MataKuliah("MK002", "Basis Data", 3),
            new MataKuliah("MK003", "Desain Web", 3)
        };

        Nilai[] daftarNilai = {
            new Nilai(daftarMahasiswa[0], daftarMK[0], 80, 85, 90), 
            new Nilai(daftarMahasiswa[0], daftarMK[1], 60, 75, 70), 
            new Nilai(daftarMahasiswa[1], daftarMK[0], 75, 70, 80), 
            new Nilai(daftarMahasiswa[2], daftarMK[1], 85, 90, 95), 
            new Nilai(daftarMahasiswa[2], daftarMK[2], 80, 90, 65)
        };
        int jumlahNilai = daftarNilai.length;

        int pilihan;
        do {
            System.out.println("===== MENU SIAKAD =====");
            System.out.println("1. Tampilkan Daftar Mahasiswa");
            System.out.println("2. Tampilkan Daftar Mata Kuliah");
            System.out.println("3. Tampilkan Data Penilaian");
            System.out.println("4. Urutkan Mahasiswa Berdasarkan Nilai Akhir");
            System.out.println("5. Cari Mahasiswa Berdasarkan NIM");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.println("=== Daftar Mahasiswa ===");
                    for (int i = 0; i < daftarMahasiswa.length; i++) {
                        System.out.println((i + 1) + ". " + "NIM: " + daftarMahasiswa[i].getNim() + " | " + "Nama: " + daftarMahasiswa[i].getNama() + " | " + "Prodi: " + daftarMahasiswa[i].getProdi());
                    }
                    break;

                case 2:
                System.out.println("=== Daftar Mata Kuliah ===");
                for (int i = 0; i < daftarMK.length; i++) {
                    System.out.println((i + 1) + ". " + "Kode MK: " + daftarMK[i].getKodeMK() + " | " + "Nama: " + daftarMK[i].getNamaMK() + " | " + "SKS: " + daftarMK[i].getSKSMk());
                }
                    break;

                case 3:
                System.out.println("Data Penilaian:");
                if (jumlahNilai == 0) {
                    System.out.println("Belum ada data nilai.");
                } else {
                    for (int i = 0; i < jumlahNilai; i++) {
                        daftarNilai[i].tampilkanData();
                    }
                }
                break;

                case 4:
                    System.out.println("Data Penilaian: ");
                    if (jumlahNilai == 0) {
                        System.out.println("Belum ada data nilai untuk diurutkan.");
                    } else {
                        bubbleSortNilai(daftarNilai, jumlahNilai);
                        for (int i = 0; i < jumlahNilai; i++) {
                            daftarNilai[i].tampilkanData();
                        }
                    }
                    break;

                case 5:
                    input.nextLine();
                    System.out.println("== Cari Nilai Mahasiswa berdasarkan NIM ==");
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
