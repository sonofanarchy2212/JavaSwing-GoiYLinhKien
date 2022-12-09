package ClassLK;

public class loaiRAM {

    int maLoaiRAM;
    String loaiRAM;

    public loaiRAM(int maLoaiRAM, String loaiRAM) {
        this.maLoaiRAM = maLoaiRAM;
        this.loaiRAM = loaiRAM;
    }

    public loaiRAM() {
        maLoaiRAM = 0;
        loaiRAM = new String();
    }

    public loaiRAM(loaiRAM m) {
        maLoaiRAM = m.getMaLoaiRAM();
        loaiRAM = new String(m.getLoaiRAM());
    }

    public int getMaLoaiRAM() {
        return maLoaiRAM;
    }

    public void setMaLoaiRAM(int maLoaiRAM) {
        this.maLoaiRAM = maLoaiRAM;
    }

    public String getLoaiRAM() {
        return loaiRAM;
    }

    public void setLoaiRAM(String loaiRAM) {
        this.loaiRAM = loaiRAM;
    }

    @Override
    public String toString() {
        return loaiRAM;
    }

}
