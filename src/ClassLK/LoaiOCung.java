package ClassLK;

public class LoaiOCung {

    int MaLoaiOCung;
    String LoaiOCung;

    public LoaiOCung(int MaLoaiOCung, String LoaiOCung) {
        this.MaLoaiOCung = MaLoaiOCung;
        this.LoaiOCung = LoaiOCung;
    }

    public LoaiOCung() {
        MaLoaiOCung = 0;
        LoaiOCung = new String();
    }

    public LoaiOCung(LoaiOCung m) {
        MaLoaiOCung = m.getMaLoaiOCung();
        LoaiOCung = new String(m.getLoaiOCung());
    }

    public int getMaLoaiOCung() {
        return MaLoaiOCung;
    }

    public void setMaLoaiOCung(int MaLoaiOCung) {
        this.MaLoaiOCung = MaLoaiOCung;
    }

    public String getLoaiOCung() {
        return LoaiOCung;
    }

    public void setLoaiOCung(String LoaiOCung) {
        this.LoaiOCung = LoaiOCung;
    }

    @Override
    public String toString() {
        return LoaiOCung;
    }

}
