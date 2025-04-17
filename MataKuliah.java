public class MataKuliah {
    String kodeMK;
    String namaMK;
    int sksMK;

    public MataKuliah(String kodeMK, String namaMK, int sksMK) {
        this.kodeMK = kodeMK;
        this.namaMK = namaMK;
        this.sksMK = sksMK;
    }

    public String getKodeMK() {
        return kodeMK;
    }

    public String getNamaMK() {
        return namaMK;
    }

    public int getSKSMk() {
        return sksMK;
    }

    public void tampilMataKuliah() {
        System.out.println("Kode MK : " + kodeMK);
        System.out.println("Nama MK : " + namaMK);
        System.out.println("SKS : " + sksMK);
    }
}
