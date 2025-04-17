public class Mahasiswa {
    String nim;
    String nama;
    String prodi;

    public Mahasiswa(String nim, String nama, String prodi) {
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public String getProdi() {
        return prodi;
    }

    public void tampilMahasiswa() {
        System.out.println("NIM  : " + nim);
        System.out.println("Nama : " + nama);
        System.out.println("Prodi : " + prodi);
    }
}
