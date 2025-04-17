public class Mahasiswa {
    String nim;
    String nama;

    public Mahasiswa(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public void tampilkanData() {
        System.out.println("NIM  : " + nim);
        System.out.println("Nama : " + nama);
    }
}
