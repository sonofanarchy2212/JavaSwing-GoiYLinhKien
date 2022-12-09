package ClassLK.connection;

import ClassLK.CPU;
import ClassLK.Case;
import ClassLK.Mainboard;
import ClassLK.Socket;
import ClassLK.loaiRAM;
import ClassLK.RAM;
import ClassLK.OCung;
import ClassLK.LoaiOCung;
import ClassLK.PSU;
import ClassLK.Result;
import ClassLK.VGA;
import ClassLK.bangKetQua;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class connection {

    private Connection con;

    public connection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionURL = "jdbc:sqlserver://LAPTOP-M90NF5KC:1433;databaseName=LinhKien(new);integratedSecurity=true";
            con = DriverManager.getConnection(connectionURL, "sa", "123456");
            System.out.println("Success!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
// <editor-fold defaultstate="collapsed" desc="XU LI GET LIST LINH KIEN ">

    public ArrayList<Socket> getListSocket() {
        ArrayList<Socket> list = new ArrayList<>();
        String sql = "Select * From [dbo].Socket";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Socket s = new Socket();
                s.setMaSocket(rs.getInt("MaSocket"));
                s.setSocket(rs.getString("Socket"));
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<CPU> getListCPU() {
        ArrayList<CPU> list = new ArrayList<>();
        String SQL = "SELECT TOP (1000) [MaCPU]\n"
                + "      ,[Hang]\n"
                + "      ,[Dong]\n"
                + "      ,[TheHe]\n"
                + "      ,[Nhan]\n"
                + "      ,[Luong]\n"
                + "      ,[XungNhip]\n"
                + "      ,[Cache]\n"
                + "	  ,CPU.[MaSocket]\n"
                + "      ,Socket\n"
                + "      ,[Gia]\n"
                + "      ,[links]\n"
               
                + "  FROM [LinhKien(new)].[dbo].[CPU],Socket\n"
                + "  where CPU.MaSocket=Socket.MaSocket;";
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CPU s = new CPU();
                s.setMaCPU(rs.getString("MaCPU"));
                s.setHang(rs.getString("Hang"));
                s.setDong(rs.getString("Dong"));
                s.setThehe(rs.getInt("TheHe"));
                s.setNhan(rs.getInt("Nhan"));
                s.setLuong(rs.getInt("Luong"));
                s.setXungnhip(rs.getFloat("XungNhip"));
                s.setCache(rs.getInt("Cache"));
                s.getSocket().setMaSocket(rs.getInt("MaSocket"));
                s.getSocket().setSocket(rs.getString("Socket"));
                s.setGia(rs.getInt("Gia"));
                s.setLinks(rs.getString("links"));
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<Mainboard> getListMainboard() {
        ArrayList<Mainboard> list = new ArrayList<>();
        String SQL = "SELECT [MaMain]\n"
                + "      ,[Hang]\n"
                + "      ,[Chipset]\n"
                + "      ,[KheRAM]\n"
                + "      ,Mainboard.[MaLoaiRAM]\n"
                + "	  ,LoaiRAM\n"
                + "      ,Mainboard.[MaSocket]\n"
                + "	  ,Socket\n"
                + "      ,[Gia]\n"
                + "  FROM [dbo].[Mainboard],LoaiRAM, Socket\n"
                + "  WHERE Mainboard.MaLoaiRAM=LoaiRAM.MaLoaiRAM and Mainboard.MaSocket=Socket.MaSocket;";
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Mainboard m = new Mainboard();
                m.setMaMainboard(rs.getString("MaMain"));
                m.setHang(rs.getString("Hang"));
                m.setChipset(rs.getString(("Chipset")));
                m.setKheRAM(rs.getInt("KheRAM"));
                m.getSocket().setMaSocket(rs.getInt("MaSocket"));
                m.getSocket().setSocket(rs.getString("Socket"));
                m.getLoaiRAM().setMaLoaiRAM(rs.getInt("MaLoaiRAM"));
                m.getLoaiRAM().setLoaiRAM(rs.getString("LoaiRAM"));
                m.setGia(rs.getInt("Gia"));
                list.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<loaiRAM> getListLoaiRAM() {
        ArrayList<loaiRAM> list = new ArrayList<>();
        String sql = "Select * From [dbo].LoaiRAM";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                loaiRAM l = new loaiRAM();
                l.setMaLoaiRAM(rs.getInt("MaLoaiRAM"));
                l.setLoaiRAM(rs.getString("LoaiRAM"));
                list.add(l);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<RAM> getListRAM() {
        ArrayList<RAM> list = new ArrayList<>();
        String SQL = "SELECT [MaRAM]\n"
                + "      ,[Hang]\n"
                + "      ,[TenRAM]\n"
                + "      ,[DungLuong]\n"
                + "      ,[Bus]\n"
                + "      ,RAM.MaLoaiRAM\n"
                + "	  ,LoaiRAM\n"
                + "      ,[Gia]\n"
                + "  FROM [dbo].[RAM],LoaiRAM where RAM.MaLoaiRAM=LoaiRAM.MaLoaiRAM;";
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                RAM R = new RAM();
                R.setMaRAM(rs.getString("MaRAM"));
                R.setHang(rs.getString("Hang"));
                R.setTenRAM(rs.getString("TenRAM"));
                R.getLoaiRAM().setMaLoaiRAM(rs.getInt("MaLoaiRAM"));
                R.getLoaiRAM().setLoaiRAM(rs.getString("LoaiRAM"));
                R.setDungLuong(rs.getInt("DungLuong"));
                R.setBus(rs.getInt("Bus"));
                R.setGia(rs.getInt("Gia"));

                list.add(R);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<LoaiOCung> getListLoaiOCung() {
        ArrayList<LoaiOCung> list = new ArrayList<>();
        String sql = "Select * From [dbo].LoaiOCung";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LoaiOCung l = new LoaiOCung();
                l.setMaLoaiOCung(rs.getInt("MaLoaiOCung"));
                l.setLoaiOCung(rs.getString("LoaiOCung"));
                list.add(l);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<OCung> getListOCung() {
        ArrayList<OCung> list = new ArrayList<>();
        String SQL = "SELECT [MaOCung]\n"
                + "      ,[Hang]\n"
                + "      ,[TenOCung]\n"
                + "      ,OCung.[MaLoaiOCung]\n"
                + "	 ,LoaiOCung.LoaiOCung\n"
                + "      ,[DungLuong]\n"
                + "      ,[Ghi]\n"
                + "      ,[Doc]\n"
                + "      ,[Gia]\n"
                + "  FROM [dbo].[OCung], LoaiOCung WHERE OCung.MaLoaiOCung = LoaiOCung.MaLoaiOCung;";
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OCung o = new OCung();
                o.setMaOCung(rs.getString("MaOCung"));
                o.setHang(rs.getString("Hang"));
                o.setTenOCung(rs.getString("TenOCung"));
                o.getLoaiOCung().setMaLoaiOCung(rs.getInt("MaLoaiOCung"));
                o.getLoaiOCung().setLoaiOCung(rs.getString("LoaiOCung"));
                o.setDungLuong(rs.getInt("DungLuong"));
                o.setGhi(rs.getInt("Ghi"));
                o.setDoc(rs.getInt("Doc"));
                o.setGia(rs.getInt("Gia"));

                list.add(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<VGA> getListVGA() {
        ArrayList<VGA> list = new ArrayList<>();
        String SQL = "SELECT [MaVGA]\n"
                + "      ,[Hang]\n"
                + "      ,[TenVGA]\n"
                + "      ,[Nhan]\n"
                + "      ,[Xungnhip]\n"
                + "      ,[Dong]\n"
                + "      ,[Gia]\n"
                + "  FROM [dbo].[VGA];";
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                VGA v = new VGA();
                v.setMaVGA(rs.getString("MaVGA"));
                v.setHang(rs.getString("Hang"));
                v.setTenVGA(rs.getString("TenVGA"));
                v.setNhan(rs.getInt("Nhan"));
                v.setXungnhip(rs.getFloat("Xungnhip"));
                v.setDong(rs.getString("Dong"));
                v.setGia(rs.getInt("Gia"));
                list.add(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<Result> getListbangKetQua() {
        ArrayList<Result> list = new ArrayList<>();
        String sql = "Select * From [dbo].bangKetQua";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Result s = new Result();
                s.setMaCPU(rs.getString("MaCPU"));
                s.setMaMain(rs.getString("MaMain"));
                s.setMaRAM(rs.getString("MaRAM"));
                s.setMaOCung(rs.getString("MaOCung"));
                s.setMaCase(rs.getString("MaCase"));
                s.setMaPSU(rs.getString("MaPSU"));
                s.setMaVGA(rs.getString("MaVGA"));
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<PSU> getListPSU() {
        ArrayList<PSU> list = new ArrayList<>();
        String SQL = "SELECT [MaPSU]\n"
                + "      ,[Hang]\n"
                + "      ,[CongSuat]\n"
                + "      ,[Chuan]\n"
                + "      ,[Gia]\n"
                + "  FROM [dbo].[PSU];";
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PSU p = new PSU();
                p.setMaPSU(rs.getString("MaPSU"));
                p.setHang(rs.getString("Hang"));
                p.setCongsuat(rs.getInt("CongSuat"));
                p.setChuan(rs.getString("Chuan"));
                p.setGia(rs.getInt("Gia"));
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<Case> getListCase() {
        ArrayList<Case> list = new ArrayList<>();
        String SQL = "SELECT [MaCase]\n"
                + "      ,[Hang]\n"
                + "      ,[TenCase]\n"
                + "      ,[Mausac]\n"
                + "      ,[ChatLieu]\n"
                + "      ,[Gia]\n"
                + "      ,[links]\n"
                + "  FROM [dbo].[Case];";
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Case c = new Case();
                c.setMaCase(rs.getString("MaCase"));
                c.setHang(rs.getString("Hang"));
                c.setTenCase(rs.getString("TenCase"));
                c.setMauSac(rs.getString("Mausac"));
                c.setChatLieu(rs.getString("ChatLieu"));
                c.setLinks(rs.getString("links"));
                c.setGia(rs.getInt("Gia"));
                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
//</editor-fold>

// <editor-fold defaultstate="collapsed" desc="XU LI THEM DU LIEU VAO SQL ">
    public boolean addMainboard(Mainboard m) {

        String sql = "INSERT INTO [dbo].[Mainboard]\n"
                + "           ([MaMain]\n"
                + "           ,[Hang]\n"
                //                + "           ,[TenMainboard]\n"
                + "           ,[Chipset]\n"
                + "           ,[KheRAM]\n"
                + "           ,[MaLoaiRAM]\n"
                + "           ,[MaSocket]\n"
                + "           ,[Gia])\n"
                + "  VALUES (?,?,?,?,?,?,?);";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, m.getMaMainboard());
            ps.setString(2, m.getHang());
            ps.setString(3, m.getChipset());
            ps.setInt(4, m.getKheRAM());
            ps.setInt(5, m.getLoaiRAM().getMaLoaiRAM());
            ps.setInt(6, m.getSocket().getMaSocket());
            ps.setInt(7, m.getGia());
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean addRAM(RAM r) {
        String sql = "INSERT INTO [dbo].[RAM]\n"
                + "           ([MaRAM]\n"
                + "           ,[Hang]\n"
                + "           ,[TenRAM]\n"
                + "           ,[DungLuong]\n"
                + "           ,[Bus]\n"
                + "           ,[MaLoaiRAM]\n"
                + "           ,[Gia])\n"
                + "     VALUES(?,?,?,?,?,?,?);";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, r.getMaRAM());
            ps.setString(2, r.getHang());
            ps.setString(3, r.getTenRAM());
            ps.setInt(4, r.getDungLuong());
            ps.setInt(5, r.getBus());
            ps.setInt(6, r.getLoaiRAM().getMaLoaiRAM());
            ps.setInt(7, r.getGia());
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean addOCung(OCung r) {
        String sql = "INSERT INTO [dbo].[OCung]\n"
                + "           ([MaOCung]\n"
                + "           ,[Hang]\n"
                + "           ,[TenOCung]\n"
                + "           ,[MaLoaiOCung]\n"
                + "           ,[DungLuong]\n"
                + "           ,[Ghi]\n"
                + "           ,[Doc]\n"
                + "           ,[Gia])\n"
                + "     VALUES(?,?,?,?,?,?,?,?);";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, r.getMaOCung());
            ps.setString(2, r.getHang());
            ps.setString(3, r.getTenOCung());
            ps.setInt(4, r.getLoaiOCung().getMaLoaiOCung());
            ps.setInt(5, r.getDungLuong());
            ps.setInt(6, r.getGhi());
            ps.setInt(7, r.getDoc());
            ps.setInt(8, r.getGia());
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean addSocket(Socket s) {

        String sql = "INSERT INTO [dbo].[Socket]\n"
                + "           ([MaSocket]\n"
                + "           ,[Socket])\n"
                + "  VALUES (?,?);";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, s.getMaSocket());
            ps.setString(2, s.getSocket());
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean addCPU(CPU cpu) {

        String sql = "INSERT INTO CPU( Hang, Dong, TheHe, Nhan,Luong,XungNhip,Cache,MaSocket,Gia, MaCPU)\n"
                + "  VALUES (?,?,?,?,?,?,?,?,?,?);";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cpu.getHang());
            ps.setString(2, cpu.getDong());
            ps.setInt(3, cpu.getThehe());
            ps.setInt(4, cpu.getNhan());
            ps.setInt(5, cpu.getLuong());
            ps.setFloat(6, cpu.getXungnhip());
            ps.setInt(7, cpu.getCache());
            ps.setInt(8, cpu.getSocket().getMaSocket());
            ps.setInt(9, cpu.getGia());
            ps.setString(10, cpu.getMaCPU());
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean addVGA(VGA r) {
        String sql = "INSERT INTO [dbo].[VGA]\n"
                + "           ([MaVGA]\n"
                + "           ,[Hang]\n"
                + "           ,[TenVGA]\n"
                + "           ,[Xungnhip]\n"
                + "           ,[Dong]\n"
                + "           ,[Nhan]\n"
                + "           ,[Gia])\n"
                + "     VALUES(?,?,?,?,?,?,?);";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, r.getMaVGA());
            ps.setString(2, r.getHang());
            ps.setString(3, r.getTenVGA());
            ps.setFloat(4, r.getXungnhip());
            ps.setString(5, r.getDong());
            ps.setInt(6, r.getNhan());
            ps.setInt(7, r.getGia());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean addPSU(PSU r) {
        String sql = "INSERT INTO [dbo].[PSU]\n"
                + "           ([MaPSU]\n"
                + "           ,[Hang]\n"
                + "           ,[TenPSU]\n"
                + "           ,[CongSuat]\n"
                + "           ,[Chuan]\n"
                + "           ,[Gia])\n"
                + "     VALUES(?,?,?,?,?,?);";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, r.getMaPSU());
            ps.setString(2, r.getHang());
            ps.setString(3, r.getTenPSU());
            ps.setInt(4, r.getCongsuat());
            ps.setString(5, r.getChuan());
            ps.setInt(6, r.getGia());
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean addCase(Case r) {
        String sql = "INSERT INTO [dbo].[Case]\n"
                + "           ([MaCase]\n"
                + "           ,[Hang]\n"
                + "           ,[TenCase]\n"
                + "           ,[Mausac]\n"
                + "           ,[ChatLieu]\n"
                + "           ,[Gia])\n"
                + "     VALUES(?,?,?,?,?,?);";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, r.getMaCase());
            ps.setString(2, r.getHang());
            ps.setString(3, r.getTenCase());
            ps.setString(4, r.getMauSac());
            ps.setString(5, r.getChatLieu());
            ps.setInt(6, r.getGia());
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean addBangKetQua(bangKetQua s) {

        String sql = "INSERT INTO [dbo].[BangKetQua]\n"
                + "           ([MaCPU]\n"
                + "           ,[MaMain]\n"
                + "           ,[MaOCung]\n"
                + "           ,[MaRam]\n"
                + "           ,[MaPSU]\n"
                + "           ,[MaVGA]\n"
                + "           ,[MaCase])\n"
                + "  VALUES (?,?,?,?,?,?,?);";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, s.getCpu().getMaCPU());
            ps.setString(2, s.getM().getMaMainboard());
            ps.setString(3, s.getO().getMaOCung());
            ps.setString(4, s.getRam().getMaRAM());
            ps.setString(5, s.getP().getMaPSU());
            ps.setString(6, s.getV().getMaVGA());
            ps.setString(7, s.getC().getMaCase());
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
//</editor-fold>

// <editor-fold defaultstate="collapsed" desc="XU LI GET LIST USER ">
    public ArrayList<CPU> getListCPU_User(String MaCPU) {
        ArrayList<CPU> list = new ArrayList<>();
        String SQL = "SELECT TOP (1) [MaCPU]\n"
                + "      ,[Hang]\n"
                + "      ,[Dong]\n"
                + "      ,[TheHe]\n"
                + "      ,[Nhan]\n"
                + "      ,[Luong]\n"
                + "      ,[XungNhip]\n"
                + "      ,[Cache]\n"
                + "	  ,CPU.[MaSocket]\n"
                + "      ,Socket\n"
                + "      ,[Gia]\n"
                + "      ,[links]\n"
                + "  FROM [LinhKien(new)].[dbo].[CPU],Socket\n"
                + "  where CPU.MaSocket=Socket.MaSocket and MaCPU=" + "'" + MaCPU + "';";
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CPU s = new CPU();
                s.setMaCPU(rs.getString("MaCPU"));
                s.setHang(rs.getString("Hang"));
                s.setDong(rs.getString("Dong"));
                s.setThehe(rs.getInt("TheHe"));
                s.setNhan(rs.getInt("Nhan"));
                s.setLuong(rs.getInt("Luong"));
                s.setXungnhip(rs.getFloat("XungNhip"));
                s.setCache(rs.getInt("Cache"));
                s.getSocket().setMaSocket(rs.getInt("MaSocket"));
                s.getSocket().setSocket(rs.getString("Socket"));
                s.setGia(rs.getInt("Gia"));
                s.setLinks(rs.getString("links"));
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<Mainboard> getListMainboard_User(String MaMain) {
        ArrayList<Mainboard> list = new ArrayList<>();
        String SQL = "SELECT [MaMain]\n"
                + "      ,[Hang]\n"
                + "      ,[Chipset]\n"
                + "      ,[KheRAM]\n"
                + "      ,Mainboard.[MaLoaiRAM]\n"
                + "	  ,LoaiRAM\n"
                + "      ,Mainboard.[MaSocket]\n"
                + "	  ,Socket\n"
                + "      ,[Gia]\n"
                + "  FROM [dbo].[Mainboard],LoaiRAM, Socket\n"
                + "  WHERE Mainboard.MaLoaiRAM=LoaiRAM.MaLoaiRAM and Mainboard.MaSocket=Socket.MaSocket and MaMain=" + "'" + MaMain + "';";
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Mainboard m = new Mainboard();
                m.setMaMainboard(rs.getString("MaMain"));
                m.setHang(rs.getString("Hang"));
                m.setChipset(rs.getString(("Chipset")));
                m.setKheRAM(rs.getInt("KheRAM"));
                m.getSocket().setMaSocket(rs.getInt("MaSocket"));
                m.getSocket().setSocket(rs.getString("Socket"));
                m.getLoaiRAM().setMaLoaiRAM(rs.getInt("MaLoaiRAM"));
                m.getLoaiRAM().setLoaiRAM(rs.getString("LoaiRAM"));
                m.setGia(rs.getInt("Gia"));
                list.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<RAM> getListRAM_User(String MaRAM) {
        ArrayList<RAM> list = new ArrayList<>();
        String SQL = "SELECT [MaRAM]\n"
                + "      ,[Hang]\n"
                + "      ,[TenRAM]\n"
                + "      ,[DungLuong]\n"
                + "      ,[Bus]\n"
                + "      ,RAM.MaLoaiRAM\n"
                + "	  ,LoaiRAM\n"
                + "      ,[Gia]\n"
                + "  FROM [dbo].[RAM],LoaiRAM where RAM.MaLoaiRAM=LoaiRAM.MaLoaiRAM and MaRAM=" + "'" + MaRAM + "';";
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                RAM R = new RAM();
                R.setMaRAM(rs.getString("MaRAM"));
                R.setHang(rs.getString("Hang"));
                R.setTenRAM(rs.getString("TenRAM"));
                R.getLoaiRAM().setMaLoaiRAM(rs.getInt("MaLoaiRAM"));
                R.getLoaiRAM().setLoaiRAM(rs.getString("LoaiRAM"));
                R.setDungLuong(rs.getInt("DungLuong"));
                R.setBus(rs.getInt("Bus"));
                R.setGia(rs.getInt("Gia"));

                list.add(R);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<OCung> getListOCung_User(String MaOCung) {
        ArrayList<OCung> list = new ArrayList<>();
        String SQL = "SELECT [MaOCung]\n"
                + "      ,[Hang]\n"
                + "      ,[TenOCung]\n"
                + "      ,OCung.[MaLoaiOCung]\n"
                + "	 ,LoaiOCung.LoaiOCung\n"
                + "      ,[DungLuong]\n"
                + "      ,[Ghi]\n"
                + "      ,[Doc]\n"
                + "      ,[Gia]\n"
                + "  FROM [dbo].[OCung], LoaiOCung WHERE OCung.MaLoaiOCung = LoaiOCung.MaLoaiOCung and MaOCung=" + "'" + MaOCung + "';";
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OCung o = new OCung();
                o.setMaOCung(rs.getString("MaOCung"));
                o.setHang(rs.getString("Hang"));
                o.setTenOCung(rs.getString("TenOCung"));
                o.getLoaiOCung().setMaLoaiOCung(rs.getInt("MaLoaiOCung"));
                o.getLoaiOCung().setLoaiOCung(rs.getString("LoaiOCung"));
                o.setDungLuong(rs.getInt("DungLuong"));
                o.setGhi(rs.getInt("Ghi"));
                o.setDoc(rs.getInt("Doc"));
                o.setGia(rs.getInt("Gia"));

                list.add(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<VGA> getListVGA_User(String MaVGA) {
        ArrayList<VGA> list = new ArrayList<>();
        String SQL = "SELECT [MaVGA]\n"
                + "      ,[Hang]\n"
                + "      ,[TenVGA]\n"
                + "      ,[Nhan]\n"
                + "      ,[Xungnhip]\n"
                + "      ,[Dong]\n"
                + "      ,[Gia]\n"
                + "  FROM [dbo].[VGA] where MaVGA=" + "'" + MaVGA + "';";
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                VGA v = new VGA();
                v.setMaVGA(rs.getString("MaVGA"));
                v.setHang(rs.getString("Hang"));
                v.setTenVGA(rs.getString("TenVGA"));
                v.setNhan(rs.getInt("Nhan"));
                v.setXungnhip(rs.getFloat("Xungnhip"));
                v.setDong(rs.getString("Dong"));
                v.setGia(rs.getInt("Gia"));
                list.add(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<Case> getListCase_User(String MaCase) {
        ArrayList<Case> list = new ArrayList<>();
        String SQL = "SELECT [MaCase]\n"
                + "      ,[Hang]\n"
                + "      ,[TenCase]\n"
                + "      ,[Mausac]\n"
                + "      ,[ChatLieu]\n"
                + "      ,[Gia]\n"
                + "      ,[links]\n"
                + "  FROM [dbo].[Case] where MaCase=" + "'" + MaCase + "';";
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Case c = new Case();
                c.setMaCase(rs.getString("MaCase"));
                c.setHang(rs.getString("Hang"));
                c.setTenCase(rs.getString("TenCase"));
                c.setMauSac(rs.getString("Mausac"));
                c.setChatLieu(rs.getString("ChatLieu"));
                c.setGia(rs.getInt("Gia"));
                c.setLinks(rs.getString("links"));
                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<PSU> getListPSU_User(String MaPSU) {
        ArrayList<PSU> list = new ArrayList<>();
        String SQL = "SELECT [MaPSU]\n"
                + "      ,[Hang]\n"
                + "      ,[CongSuat]\n"
                + "      ,[Chuan]\n"
                + "      ,[Gia]\n"
                + "  FROM [dbo].[PSU] where MaPSU=" + "'" + MaPSU + ";";
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PSU p = new PSU();
                p.setMaPSU(rs.getString("MaPSU"));
                p.setHang(rs.getString("Hang"));
                p.setCongsuat(rs.getInt("CongSuat"));
                p.setChuan(rs.getString("Chuan"));
                p.setGia(rs.getInt("Gia"));
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
//</editor-fold>

// <editor-fold defaultstate="collapsed" desc="XU LI DELETE CAC LINH KIEN ">
    public void deleteCPU(String MaCPU) {
        String SQL = "DELETE FROM [dbo].[CPU] WHERE MaCPU=?";
        try {
            PreparedStatement ps = con.prepareCall(SQL);
            ps.setString(1, MaCPU);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteMainboard(String MaMain) {
        String SQL = "DELETE FROM [dbo].[Mainboard] WHERE MaMain=?";
        try {
            PreparedStatement ps = con.prepareCall(SQL);
            ps.setString(1, MaMain);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteRAM(String MaRAM) {
        String SQL = "DELETE FROM [dbo].[RAM] WHERE MaRAM=?";
        try {
            PreparedStatement ps = con.prepareCall(SQL);
            ps.setString(1, MaRAM);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteOCung(String MaOCung) {
        String SQL = "DELETE FROM [dbo].[OCung] WHERE MaOCung=?";
        try {
            PreparedStatement ps = con.prepareCall(SQL);
            ps.setString(1, MaOCung);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteSocket(int MaSocket) {
        String SQL = "DELETE FROM [dbo].[Socket] WHERE MaSocket=?";
        try {
            PreparedStatement ps = con.prepareCall(SQL);
            ps.setInt(1, MaSocket);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCase(String MaCase) {
        String SQL = "DELETE FROM [dbo].[Case] WHERE MaCase=?";
        try {
            PreparedStatement ps = con.prepareCall(SQL);
            ps.setString(1, MaCase);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteVGA(String MaVGA) {
        String SQL = "DELETE FROM [dbo].[VGA] WHERE MaVGA=?";
        try {
            PreparedStatement ps = con.prepareCall(SQL);
            ps.setString(1, MaVGA);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletePSU(String MaPSU) {
        String SQL = "DELETE FROM [dbo].[PSU] WHERE MaPSU=?";
        try {
            PreparedStatement ps = con.prepareCall(SQL);
            ps.setString(1, MaPSU);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//</editor-fold>

// <editor-fold defaultstate="collapsed" desc="XU LI UPDATE CAC LINH KIEN ">
    public void updateCPU(CPU cpu) {
        String SQL = "UPDATE [dbo].[CPU] SET [Hang] = ?,[Dong] = ?,[TheHe] = ?,[Nhan] = ?,[Luong] = ?,[XungNhip] = ?,[Cache] = ?,[MaSocket] = ?,[Gia] = ? WHERE MaCPU=?";
        try {
            PreparedStatement ps = con.prepareCall(SQL);
            ps.setString(1, cpu.getHang());
            ps.setString(2, cpu.getDong());
            ps.setInt(3, cpu.getThehe());
            ps.setInt(4, cpu.getNhan());
            ps.setInt(5, cpu.getLuong());
            ps.setFloat(6, cpu.getXungnhip());
            ps.setInt(7, cpu.getCache());
            ps.setInt(8, cpu.getSocket().getMaSocket());
            ps.setInt(9, cpu.getGia());
            ps.setString(10, cpu.getMaCPU());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateMainboard(Mainboard m) {
        String SQL = "UPDATE [dbo].[Mainboard] SET   [Hang] = ?,[Chipset] = ?,[KheRAM] = ?,[MaLoaiRAM] = ?,[MaSocket] = ?,[Gia] = ? WHERE MaMain=?;";
        try {
            PreparedStatement ps = con.prepareCall(SQL);
            ps.setString(1, m.getHang());
            ps.setString(2, m.getChipset());
            ps.setInt(3, m.getKheRAM());
            ps.setInt(4, m.getLoaiRAM().getMaLoaiRAM());
            ps.setInt(5, m.getSocket().getMaSocket());
            ps.setInt(6, m.getGia());
            ps.setString(7, m.getMaMainboard());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateRAM(RAM r) {
        String SQL = "UPDATE [dbo].[RAM] SET [Hang] = ?,[TenRAM] = ?,[DungLuong] = ?,[Bus] = ?, [MaLoaiRAM]=?,[Gia] = ? WHERE MaRAM=?;";
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(7, r.getMaRAM());
            ps.setString(1, r.getHang());
            ps.setString(2, r.getTenRAM());
            ps.setInt(3, r.getDungLuong());
            ps.setInt(4, r.getBus());
            ps.setInt(5, r.getLoaiRAM().getMaLoaiRAM());
            ps.setInt(6, r.getGia());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateOCung(OCung r) {
        String SQL = "UPDATE [dbo].[OCung] SET [Hang] = ?,[TenOCung] = ?,[MaLoaiOCung] = ?,[DungLuong] = ?,[Ghi] =?,[Doc] =?,[Gia] =? WHERE MaOCung=?;";
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(8, r.getMaOCung());
            ps.setString(1, r.getHang());
            ps.setString(2, r.getTenOCung());
            ps.setInt(3, r.getLoaiOCung().getMaLoaiOCung());
            ps.setInt(4, r.getDungLuong());
            ps.setInt(5, r.getGhi());
            ps.setInt(6, r.getDoc());
            ps.setInt(7, r.getGia());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateSocket(Socket s) {
        String SQL = "UPDATE [dbo].[Socket] SET [Socket] = ? WHERE MaSocket=?;";
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(2, s.getMaSocket());
            ps.setString(1, s.getSocket());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateCase(Case r) {
        String SQL = "UPDATE [dbo].[Case] SET [MaCase] = ?,[Hang] = ?,[TenCase] =?,[Mausac] = ?,[ChatLieu] = ?,[Gia] = ? WHERE MaCase=?;";
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(6, r.getMaCase());
            ps.setString(1, r.getHang());
            ps.setString(2, r.getTenCase());
            ps.setString(3, r.getMauSac());
            ps.setString(4, r.getChatLieu());
            ps.setInt(5, r.getGia());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateVGA(VGA r) {
        String SQL = "UPDATE [dbo].[VGA] SET [MaVGA] = ?,[Hang] = ?,[TenVGA] = ?,[Xungnhip] = ?,[Dong] = ?,[Nhan] = ?,[Gia] = ? WHERE MaVGA=?;";
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(7, r.getMaVGA());
            ps.setString(1, r.getHang());
            ps.setString(2, r.getTenVGA());
            ps.setFloat(3, r.getXungnhip());
            ps.setString(4, r.getDong());
            ps.setInt(5, r.getNhan());
            ps.setInt(6, r.getGia());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updatePSU(PSU r) {
        String SQL = "UPDATE [dbo].[PSU] SET [MaPSU] = ?,[Hang] = ?,[TenPSU] = ?,[CongSuat] = ?,[Chuan] = ?,[Gia] = ? WHERE MaPSU=?;";
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(6, r.getMaPSU());
            ps.setString(1, r.getHang());
            ps.setString(2, r.getTenPSU());
            ps.setInt(3, r.getCongsuat());
            ps.setString(4, r.getChuan());
            ps.setInt(5, r.getGia());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//</editor-fold>

    public static void main(String[] args) {
        new connection();
    }
}
