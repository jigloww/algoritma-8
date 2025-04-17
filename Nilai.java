public class Nilai {
    Mahasiswa mahasiswa;
    MataKuliah mataKuliah;
    double tugas, uts, uas;

    public Nilai(Mahasiswa mahasiswa, MataKuliah mataKuliah, double tugas, double uts, double uas) {
        this.mahasiswa = mahasiswa;
        this.mataKuliah = mataKuliah;
        this.tugas = tugas;
        this.uts = uts;
        this.uas = uas;
    }

    public double hitungNilaiAkhir() {
        return (tugas * 0.3) + (uts * 0.3) + (uas * 0.4);
    }

    public void tampilkanData() {
        System.out.println("NIM        : " + mahasiswa.getNim());
        System.out.println("Nama       : " + mahasiswa.getNama());
        System.out.println("Mata Kuliah: " + mataKuliah.getNamaMK());
        System.out.println("Tugas      : " + tugas);
        System.out.println("UTS        : " + uts);
        System.out.println("UAS        : " + uas);
        System.out.println("Nilai Akhir: " + hitungNilaiAkhir());
    }
}
