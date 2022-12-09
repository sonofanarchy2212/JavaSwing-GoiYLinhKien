
package ClassLK;


public class CPU {
     String Hang, Dong,MaCPU,links;
     int Thehe,Luong, Nhan, Congsuat,Gia,Cache;
     float Xungnhip;
     Socket Socket;

    public CPU(String Hang, String Dong, String MaCPU, String links, int Thehe, int Luong, int Nhan, int Congsuat, int Gia, int Cache, float Xungnhip, Socket Socket) {
        this.Hang = Hang;
        this.Dong = Dong;
        this.MaCPU = MaCPU;
        this.links = links;
        this.Thehe = Thehe;
        this.Luong = Luong;
        this.Nhan = Nhan;
        this.Congsuat = Congsuat;
        this.Gia = Gia;
        this.Cache = Cache;
        this.Xungnhip = Xungnhip;
        this.Socket = Socket;
    }



    public CPU(CPU cpu){
        Hang= new String(cpu.getHang());
        Dong=new String(cpu.getDong());
        Socket=new Socket(cpu.getSocket());
        MaCPU=cpu.getMaCPU();
        Thehe=cpu.getThehe();
        Nhan=cpu.getNhan();
        Luong=cpu.getLuong();
        Xungnhip=cpu.getXungnhip();
        Cache=cpu.getCache();
        Gia=cpu.getGia();
        links = cpu.getLinks();
    }

    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
    }
    
    public int getCache() {
        return Cache;
    }

    public void setCache(int Cache) {
        this.Cache = Cache;
    }

    public String getMaCPU() {
        return MaCPU;
    }

    public void setMaCPU(String MaCPU) {
        this.MaCPU = MaCPU;
    }

 



    public CPU(){
        Hang = new String();
        Dong = new String();
        MaCPU = new String();
        Socket = new Socket();
        Xungnhip = 0;
        Thehe = Luong = Nhan = Congsuat = Gia =Cache= 0;
    };

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

    public Socket getSocket() {
        return Socket;
    }

    public void setSocket(Socket Socket) {
        this.Socket = Socket;
    }

    public int getThehe() {
        return Thehe;
    }

    public void setThehe(int Thehe) {
        this.Thehe = Thehe;
    }

    public float getXungnhip() {
        return Xungnhip;
    }

    public void setXungnhip(float Xungnhip) {
        this.Xungnhip = Xungnhip;
    }

    public int getLuong() {
        return Luong;
    }

    public void setLuong(int Luong) {
        this.Luong = Luong;
    }

    public int getNhan() {
        return Nhan;
    }

    public void setNhan(int Nhan) {
        this.Nhan = Nhan;
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

    public Object getTenSocket() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "CPU:\n" + "Hãng=" + Hang + "\nDòng=" + Dong + "\nThế hệ=" + Thehe + "\nLuồng=" + Luong + "\nNhân=" + Nhan + "\nCông suất=" + Congsuat + "\nCache=" + Cache +"MB" + "\nXung nhịp=" + Xungnhip + " GHz" + "\nSocket=" + Socket + "\nLink:" +links+ "\nGiá=" + Gia +" VND";
    }


    
}
