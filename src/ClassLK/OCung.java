package ClassLK;

public class OCung {

    int  Ghi, Doc, Gia,dungLuong;
    String Hang, TenOCung, MaOCung;
    LoaiOCung loaiOCung;

    public OCung(int dungLuong, int Ghi, int Doc, int Gia, String Hang, String TenOCung, String MaOCung, LoaiOCung loaiOCung) {
        this.dungLuong = dungLuong;
        this.Ghi = Ghi;
        this.Doc = Doc;
        this.Gia = Gia;
        this.Hang = Hang;
        this.TenOCung = TenOCung;
        this.MaOCung = MaOCung;
        this.loaiOCung = loaiOCung;
    }

    public OCung() {
        Ghi = Doc = Gia = dungLuong = 0;
        Hang = new String();
        TenOCung = new String();
        MaOCung = new String();
        loaiOCung = new LoaiOCung();
    }

    public OCung(OCung m) {
        dungLuong = m.getDungLuong();
        Doc = m.getDoc();
        Ghi = m.getGhi();
        Gia = m.getGia();
        Hang = new String(m.getHang());
        TenOCung = new String(m.getTenOCung());
        MaOCung = new String(m.getMaOCung());
        loaiOCung = new LoaiOCung(m.getLoaiOCung());
    }

    public String getMaOCung() {
        return MaOCung;
    }

    public void setMaOCung(String MaOCung) {
        this.MaOCung = MaOCung;
    }

    public int getDungLuong() {
        return dungLuong;
    }

    public void setDungLuong(int dungLuong) {
        this.dungLuong = dungLuong;
    }


    public int getGhi() {
        return Ghi;
    }

    public void setGhi(int Ghi) {
        this.Ghi = Ghi;
    }

    public int getDoc() {
        return Doc;
    }

    public void setDoc(int Doc) {
        this.Doc = Doc;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int Gia) {
        this.Gia = Gia;
    }

    public String getHang() {
        return Hang;
    }

    public void setHang(String Hang) {
        this.Hang = Hang;
    }

    public LoaiOCung getLoaiOCung() {
        return loaiOCung;
    }

    public void setLoaiOCung(LoaiOCung loaiOCung) {
        this.loaiOCung = loaiOCung;
    }

    public String getTenOCung() {
        return TenOCung;
    }

    public void setTenOCung(String TenOCung) {
        this.TenOCung = TenOCung;
    }

    @Override
    public String toString() {
        return "\t\t\tỔ CỨNG" + "\nHÃNG=" + Hang + "\nLOẠI Ổ CỨNG=" + loaiOCung + "\nDUNG LƯỢNG=" + dungLuong +"GB"+ "\nTỐC ĐỘ GHI=" + Ghi + "MB/s"+ "\nTỐC ĐỘ ĐỌC=" + Doc +"MB/s" + "\nGIÁ=" + Gia + " VND";
    }

}
