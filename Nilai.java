public class Nilai {
    Mahasiswa mahasiswa;
    MataKuliah mataKuliah;
    double nilaiTugas, nilaiUTS, nilaiUAS, nilaiAkhir;

    public Nilai(Mahasiswa mahasiswa, MataKuliah mataKuliah, double tugas, double uts, double uas) {
        this.mahasiswa = mahasiswa;
        this.mataKuliah = mataKuliah;
        this.nilaiTugas = tugas;
        this.nilaiUTS = uts;
        this.nilaiUAS = uas;
    }

    public double hitungNilaiAkhir() {
        return (nilaiTugas * 0.3) + (nilaiUTS * 0.3) + (nilaiUAS * 0.4);
    }

    public void tampilkanData() {
        System.out.println(mahasiswa.getNama() + " | " + mataKuliah.getNamaMK() + " | Nilai Akhir: " + String.format("%.1f", hitungNilaiAkhir()));
    }
}
