
package ClassLK;

public class VGA {
    int Nhan,Gia;
    float Xungnhip;
    String MaVGA,Hang,Dong,TenVGA;

    public VGA(int Nhan, int Gia, float Xungnhip, String MaVGA, String Hang, String Dong, String TenVGA) {
        this.Nhan = Nhan;
        this.Gia = Gia;
        this.Xungnhip = Xungnhip;
        this.MaVGA = MaVGA;
        this.Hang = Hang;
        this.Dong = Dong;
        this.TenVGA = TenVGA;
    }




    public VGA(){
        Nhan = Gia = 0;
        Xungnhip = 0;
        Hang = new String();
        Dong = new String();
        MaVGA = new String();
        TenVGA = new String();
    }
    public VGA(VGA v){
        Nhan =v.getNhan();
        Gia = v.getGia();
        Xungnhip = v.getXungnhip();
        Hang = new String(v.getHang());
        Dong = new String(v.getDong());
        MaVGA = new String(v.getMaVGA());
        TenVGA = new String(v.TenVGA);
    }
    public String getMaVGA() {
        return MaVGA;
    }

    public void setMaVGA(String MaVGA) {
        this.MaVGA = MaVGA;
    }


    public int getNhan() {
        return Nhan;
    }

    public String getTenVGA() {
        return TenVGA;
    }

    public void setTenVGA(String TenVGA) {
        this.TenVGA = TenVGA;
    }

    public void setNhan(int Nhan) {
        this.Nhan = Nhan;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int Gia) {
        this.Gia = Gia;
    }

    public float getXungnhip() {
        return Xungnhip;
    }

    public void setXungnhip(float Xungnhip) {
        this.Xungnhip = Xungnhip;
    }

    public String getHang() {
        return Hang;
    }

    public void setHang(String Hang) {
        this.Hang = Hang;
    }

    public String getDong() {
        return Dong;
    }

    public void setDong(String Dong) {
        this.Dong = Dong;
    }

    @Override
    public String toString() {
        return "\t\t\tVGA"+ "\nHÃNG=" + Hang + "\nDÒNG=" + Dong + "\nTÊN VGA=" + TenVGA + "\nNHÂN=" + Nhan+ "\nXUNG NHỊP=" + Xungnhip + "GHz" + ", GIÁ=" + Gia+"VND";
    }
    
}
