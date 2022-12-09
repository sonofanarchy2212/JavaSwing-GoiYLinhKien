package ClassLK;

public class Case {

    int Gia;
    String MaCase, Hang, tenCase, mauSac, chatLieu, Links;

    public Case(int Gia, String MaCase, String Hang, String tenCase, String mauSac, String chatLieu, String Links) {
        this.Gia = Gia;
        this.MaCase = MaCase;
        this.Hang = Hang;
        this.tenCase = tenCase;
        this.mauSac = mauSac;
        this.chatLieu = chatLieu;
        this.Links = Links;
    }

    @Override
    public String toString() {
        return "\t\t\tCASE" + "\nHÃNG=" + Hang + "\nTÊN CASE=" + tenCase + "\nMÀU SẮC=" + mauSac + "\nCHẤT LIỆU=" + chatLieu  + "\nGIÁ=" + Gia +"VND";
    }



    public Case() {
        Gia = 0;
        MaCase = new String();
        Hang = new String();
        tenCase = new String();
        mauSac = new String();
        chatLieu = new String();
        Links = new String();

    }

    public Case(Case m) {
        Gia = m.getGia();
        MaCase = new String(m.getMaCase());
        Hang = new String(m.getHang());
        tenCase = new String(m.getTenCase());
        mauSac = new String(m.getMauSac());
        chatLieu = new String(m.getChatLieu());
        Links = new String(m.getLinks());
    }

    public String getLinks() {
        return Links;
    }

    public void setLinks(String Links) {
        this.Links = Links;
    }

    public String getMaCase() {
        return MaCase;
    }

    public void setMaCase(String MaCase) {
        this.MaCase = MaCase;
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

    public String getTenCase() {
        return tenCase;
    }

    public void setTenCase(String tenCase) {
        this.tenCase = tenCase;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

}
