
package ClassLK;

public class RAM {
    int dungLuong,Bus, Gia;
    String Hang,maRAM,tenRAM;
    loaiRAM loaiRAM;


    

    public RAM(String maRAM, int dungLuong, int Bus, int Gia, String Hang, loaiRAM loaiRAM) {
        this.maRAM = maRAM;
        this.dungLuong = dungLuong;
        this.Bus = Bus;
        this.Gia = Gia;
        this.Hang = Hang;
        this.loaiRAM = loaiRAM;
    }

    public RAM() {
        dungLuong=Bus=Gia=0;
        Hang = new String();
        maRAM = new String();
        tenRAM = new String();
        loaiRAM = new loaiRAM();
    }
    public RAM(RAM m) {
        dungLuong=m.getDungLuong();
        Gia = m.getGia();
        Bus = m.getBus();
        Hang = new String(m.getHang());
        maRAM = new String(m.getMaRAM());
        tenRAM = new String(m.getTenRAM());
        loaiRAM = new loaiRAM(m.getLoaiRAM());
    }
    public loaiRAM getLoaiRAM() {
        return loaiRAM;
    }

    public void setLoaiRAM(loaiRAM loaiRAM) {
        this.loaiRAM = loaiRAM;
    }



    public String getMaRAM() {
        return maRAM;
    }

    public void setMaRAM(String maRAM) {
        this.maRAM = maRAM;
    }

    public String getTenRAM() {
        return tenRAM;
    }

    public void setTenRAM(String tenRAM) {
        this.tenRAM = tenRAM;
    }




    public int getDungLuong() {
        return dungLuong;
    }

    public void setDungLuong(int dungLuong) {
        this.dungLuong = dungLuong;
    }

    public int getBus() {
        return Bus;
    }

    public void setBus(int Bus) {
        this.Bus = Bus;
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

    @Override
    public String toString() {
        return "\t\t\tRAM"+ "\nHÃNG=" + Hang + "\nLOẠI RAM=" + loaiRAM + "\nDUNG LƯỢNG =" + dungLuong +"GB"+ "\nBus=" + Bus +"MB/s"+ "\nGIÁ=" + Gia +"VND";
    }
    
}
