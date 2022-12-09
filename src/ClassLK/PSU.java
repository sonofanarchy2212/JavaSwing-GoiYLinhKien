package ClassLK;

public class PSU {

    int Congsuat, Gia;
    String Hang, Chuan, MaPSU, TenPSU;

    public PSU(int Congsuat, int Gia, String Hang, String Chuan, String MaPSU, String TenPSU) {
        this.Congsuat = Congsuat;
        this.Gia = Gia;
        this.Hang = Hang;
        this.Chuan = Chuan;
        this.MaPSU = MaPSU;
        this.TenPSU = TenPSU;
    }

    public PSU() {
        Congsuat = Gia = 0;
        Hang = new String();
        Chuan = new String();
        MaPSU = new String();
        TenPSU = new String();
    }

    public PSU(PSU m) {
        Congsuat = m.getCongsuat();
        Gia = m.getGia();
        Hang = new String(m.getHang());
        Chuan = new String(m.getChuan());
        MaPSU = new String(m.getMaPSU());
        TenPSU = new String(m.TenPSU);
    }

    public String getTenPSU() {
        return TenPSU;
    }

    public void setTenPSU(String TenPSU) {
        this.TenPSU = TenPSU;
    }

    public String getMaPSU() {
        return MaPSU;
    }

    public void setMaPSU(String MaPSU) {
        this.MaPSU = MaPSU;
    }

    public int getCongsuat() {
        return Congsuat;
    }

    public void setCongsuat(int Congsuat) {
        this.Congsuat = Congsuat;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int Gia) {
        this.Gia = Gia;
    }

    @Override
    public String toString() {
        return "\t\t\tPSU" + "\nTÊN PSU=" + TenPSU +"\nHÃNG=" + Hang +  "\nCÔNG SUẤT=" + Congsuat + "\nCHUẨN=" + Chuan + "\nGIÁ=" + Gia +" VND";
    }

    public String getHang() {
        return Hang;
    }

    public void setHang(String Hang) {
        this.Hang = Hang;
    }

    public String getChuan() {
        return Chuan;
    }

    public void setChuan(String Chuan) {
        this.Chuan = Chuan;
    }

}
