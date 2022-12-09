package ClassLK;

public class Mainboard {

    int KheRAM, Gia;
    String MaMainboard, Hang, Chipset;
    loaiRAM loaiRAM;
    Socket Socket;

    public Mainboard(String MaMain, int KheRAM, int Gia, String Hang, String Chipset, loaiRAM loaiRAM, Socket Socket) {
        this.MaMainboard = MaMainboard;
        this.KheRAM = KheRAM;
        this.Gia = Gia;
        this.Hang = Hang;
        this.Chipset = Chipset;
        this.loaiRAM = loaiRAM;
        this.Socket = Socket;
    }

    public Mainboard() {
        KheRAM = Gia = 0;
        Hang = new String();
        Chipset = new String();
        loaiRAM = new loaiRAM();
        Socket = new Socket();
        MaMainboard = new String();
    }

    public Mainboard(Mainboard m) {
        KheRAM = m.getKheRAM();
        Gia = m.getGia();
        Hang = new String(m.getHang());
        Chipset = new String(m.getChipset());
        loaiRAM = new loaiRAM(m.getLoaiRAM());
        Socket = new Socket(m.getSocket());
        MaMainboard = new String(m.getMaMainboard());
    }

    public String getMaMainboard() {
        return MaMainboard;
    }

    public void setMaMainboard(String MaMainboard) {
        this.MaMainboard = MaMainboard;
    }

    public int getKheRAM() {
        return KheRAM;
    }

    public void setKheRAM(int KheRAM) {
        this.KheRAM = KheRAM;
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

    public String getChipset() {
        return Chipset;
    }

    public void setChipset(String Chipset) {
        this.Chipset = Chipset;
    }

    public loaiRAM getLoaiRAM() {
        return loaiRAM;
    }

    public void setLoaiRAM(loaiRAM loaiRAM) {
        this.loaiRAM = loaiRAM;
    }

    public Socket getSocket() {
        return Socket;
    }

    public void setSocket(Socket Socket) {
        this.Socket = Socket;
    }

    @Override

    public String toString() {
        return  "\t\tMAINBOARD"+"\nHang=" + Hang + "\nChipset=" + Chipset + "\nloaiRAM=" + loaiRAM + "\nSocket=" + Socket + "\nKheRAM=" + KheRAM + "\nGia=" + Gia +" VND";
    }

}
