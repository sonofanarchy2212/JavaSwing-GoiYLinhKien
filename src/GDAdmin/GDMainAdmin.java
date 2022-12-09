package GDAdmin;

import ClassLK.CPU;
import ClassLK.Socket;
import ClassLK.loaiRAM;
import ClassLK.RAM;
import ClassLK.Mainboard;
import ClassLK.LoaiOCung;
import ClassLK.OCung;
import ClassLK.Case;
import ClassLK.VGA;
import ClassLK.PSU;
import ClassLK.connection.connection;
import com.sun.org.apache.regexp.internal.recompile;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jdk.nashorn.internal.runtime.regexp.joni.constants.CCSTATE;

public class GDMainAdmin extends javax.swing.JFrame {

    DefaultTableModel modelTBCPU;
    DefaultTableModel modelTBMainboard;
    DefaultTableModel modelTBRAM;
    DefaultTableModel modelTBOCung;
    DefaultTableModel modelTBSocket;
    DefaultTableModel modelTBCase;
    DefaultTableModel modelTBVGA;
    DefaultTableModel modelTBPSU;

    ArrayList<CPU> listCPU;
    ArrayList<Mainboard> listMainboard;
    ArrayList<RAM> listRAM;
    ArrayList<OCung> listOCung;
    ArrayList<Socket> listSocket;
    ArrayList<loaiRAM> listLoaiRAM;
    ArrayList<LoaiOCung> listloaiOCung;
    ArrayList<Case> listCase;
    ArrayList<VGA> listVGA;
    ArrayList<PSU> listPSU;

    int selectedIndex;

    public GDMainAdmin() {
        initComponents();
        //LẤY DỮ LIỆU TỪ CSDL
        listSocket = new connection().getListSocket();
        listCPU = new connection().getListCPU();
        listMainboard = new connection().getListMainboard();
        listLoaiRAM = new connection().getListLoaiRAM();
        listloaiOCung = new connection().getListLoaiOCung();
        listRAM = new connection().getListRAM();
        listOCung = new connection().getListOCung();
        listCase = new connection().getListCase();
        listVGA = new connection().getListVGA();
        listPSU = new connection().getListPSU();
        // GET MODEL CHO CÁC BẢNG 
        modelTBCPU = (DefaultTableModel) tbCPU.getModel();
        modelTBMainboard = (DefaultTableModel) tbMainboard.getModel();
        modelTBRAM = (DefaultTableModel) tbRAM.getModel();
        modelTBOCung = (DefaultTableModel) tbOCung.getModel();
        modelTBSocket = (DefaultTableModel) tbSocket.getModel();
        modelTBCase = (DefaultTableModel) tbCase.getModel();
        modelTBVGA = (DefaultTableModel) tbVGA.getModel();
        modelTBPSU = (DefaultTableModel) tbPSU.getModel();
        // THÊM DỮ LIỆU VÀO COMBOBOX
        for (Socket socket : listSocket) {
            CBSocketCPU.addItem(socket.getSocket());
            CBSocketMain.addItem(socket.getSocket());
        }
        for (loaiRAM l : listLoaiRAM) {
            CBLoaiRAMMB.addItem(l.getLoaiRAM());
        }
        for (loaiRAM l : listLoaiRAM) {
            cbLoaiRAM.addItem(l.getLoaiRAM());
        }
        for (LoaiOCung l : listloaiOCung) {
            CBloaiOCung.addItem(l.getLoaiOCung());
        }
        // SET TÊN CỘT CHO CÁC BẢNG 
        modelTBCPU.setColumnIdentifiers(new Object[]{
            "MÃ CPU", "HẢNG", "DÒNG", "THẾ HỆ", "NHÂN (GHz)", "LUỒNG", "XUNG NHỊP(GHz)", "CACHE", "SOCKET", "GIÁ(VND)"
        });
        modelTBMainboard.setColumnIdentifiers(new Object[]{
            "MÃ MAINBOARD", "HẢNG", "CHIPSET", "KHE RAM", "LOẠI RAM", "SOCKET", "GIÁ(VND)"
        });
        modelTBRAM.setColumnIdentifiers(new Object[]{
            "MÃ RAM", "HẢNG", "TÊN RAM", "DUNG LƯỢNG(GB)", "BUS(MB/s)", "LOẠI RAM", "GIÁ(VND)"
        });
        modelTBOCung.setColumnIdentifiers(new Object[]{
            "MÃ Ổ CỨNG", "HẢNG", "TÊN Ổ CỨNG", "LOẠI Ổ CỨNG", "DUNG LƯỢNG", "GHI(MB/s)", "ĐỌC(MB/s)", "GIÁ(VND)"
        });
        modelTBSocket.setColumnIdentifiers(new Object[]{
            "MÃ SOCKET", "TÊN SOCKET"
        });
        modelTBCase.setColumnIdentifiers(new Object[]{
            "MÃ CASE", "HẢNG", "TÊN SOCKET", "MÀU SẮC", "CHẤT LIỆU", "GIÁ(VND)", "LINKS"
        });
        modelTBVGA.setColumnIdentifiers(new Object[]{
            "MÃ VGA", "HẢNG", "TÊN VGA", "DÒNG", "NHÂN(GHz)", "XUNG NHỊP(GHz)", "GIÁ(VND)"
        });
        modelTBPSU.setColumnIdentifiers(new Object[]{
            "MÃ PSU", "HẢNG", "CÔNG SUẤT", "CHUẨN", "GIÁ"
        });
        showTBCPU();
        showTBMainboard();
        showTBRAM();
        showTBOCung();
        showTBSocket();
        showTBCase();
        showTBVGA();
        showTBPSU();
        autoGenIDCPU();
        autoGenIDMainboard();
        autoGenIDRAM();
        autoGenIDOC();
        autoGenIDCase();
        autoGenIDVGA();
        autoGenIDPSU();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
        ImageIcon img = new ImageIcon("D:\\HOCTAP\\LapTrinhJAVA\\NienLuan\\src\\image\\logo.png");
        this.setIconImage(img.getImage());
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel28 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelMB = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtHangMain = new java.awt.TextField();
        txtChipset = new java.awt.TextField();
        txtKheRAM = new java.awt.TextField();
        txtGiaMain = new java.awt.TextField();
        CBLoaiRAMMB = new javax.swing.JComboBox<>();
        CBSocketMain = new javax.swing.JComboBox<>();
        jLabel36 = new javax.swing.JLabel();
        txtMaMain = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        btThemMain = new javax.swing.JButton();
        btSuaMain = new javax.swing.JButton();
        btXoaMain = new javax.swing.JButton();
        btRFMain = new javax.swing.JButton();
        jPanelMainb = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMainboard = new javax.swing.JTable();
        jPanelRAM = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        txtMaRAM = new javax.swing.JTextField();
        txtHangRAM = new javax.swing.JTextField();
        txtTenRAM = new javax.swing.JTextField();
        txtDLRAM = new javax.swing.JTextField();
        txtBusRAM = new javax.swing.JTextField();
        txtGiaRAM = new javax.swing.JTextField();
        cbLoaiRAM = new javax.swing.JComboBox<>();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        btThemRAM = new javax.swing.JButton();
        btSuaRAM = new javax.swing.JButton();
        btRFRAM = new javax.swing.JButton();
        btXoaRAM = new javax.swing.JButton();
        jPanel27 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tbRAM = new javax.swing.JTable();
        jPanelCase = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        txtMaCase = new javax.swing.JTextField();
        txtHangCase = new javax.swing.JTextField();
        txtTenCase = new javax.swing.JTextField();
        txtMauSac = new javax.swing.JTextField();
        txtChatLieu = new javax.swing.JTextField();
        txtGiaCase = new javax.swing.JTextField();
        jPanel22 = new javax.swing.JPanel();
        btThemCase = new javax.swing.JButton();
        btSuaCase = new javax.swing.JButton();
        btRFCase = new javax.swing.JButton();
        btXoaCase = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbCase = new javax.swing.JTable();
        jPanelVGA = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtMaVGA = new javax.swing.JTextField();
        txtHangVGA = new javax.swing.JTextField();
        txtDongVGA = new javax.swing.JTextField();
        txtNhanVGA = new javax.swing.JTextField();
        txtXungVGA = new javax.swing.JTextField();
        txtGiaVGA = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        txtTenVGA = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        btThemVGA = new javax.swing.JButton();
        btSuaVGA = new javax.swing.JButton();
        btRFVGA = new javax.swing.JButton();
        btXoaVGA = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbVGA = new javax.swing.JTable();
        jPanelPSU = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtMaPSU = new javax.swing.JTextField();
        txtHangPSU = new javax.swing.JTextField();
        txtCongSuatPSU = new javax.swing.JTextField();
        txtChuanPSU = new javax.swing.JTextField();
        txtGiaPSU = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        btThemPSU = new javax.swing.JButton();
        btSuaPSU = new javax.swing.JButton();
        btXoaPSU = new javax.swing.JButton();
        btRFPSU = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbPSU = new javax.swing.JTable();
        jPanelOCung = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtHangOC = new java.awt.TextField();
        txtDLOC = new java.awt.TextField();
        txtGhiOC = new java.awt.TextField();
        txtDocOC = new java.awt.TextField();
        txtGiaOC = new java.awt.TextField();
        CBloaiOCung = new javax.swing.JComboBox<>();
        jLabel34 = new javax.swing.JLabel();
        txtMaOC = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        txtTenOC = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        btThemOC = new javax.swing.JButton();
        btSuaOC = new javax.swing.JButton();
        btXoaOC = new javax.swing.JButton();
        btRFOC = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbOCung = new javax.swing.JTable();
        jPanelCPU = new javax.swing.JPanel();
        jPanelNhapCPU = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        CBSocketCPU = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        txtMaCPU = new javax.swing.JTextField();
        txtHangCPU = new javax.swing.JTextField();
        txtDongCPU = new javax.swing.JTextField();
        txtTheheCPU = new javax.swing.JTextField();
        txtNhanCPU = new javax.swing.JTextField();
        txtLuongCPU = new javax.swing.JTextField();
        txtXungCPU = new javax.swing.JTextField();
        txtCacheCPU = new javax.swing.JTextField();
        txtGiaCPU = new javax.swing.JTextField();
        jPanelTBCPU = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbCPU = new javax.swing.JTable();
        jPanelbuttonMB = new javax.swing.JPanel();
        btThemCPU = new javax.swing.JButton();
        btSuaCPU = new javax.swing.JButton();
        btXoaCPU = new javax.swing.JButton();
        btRFCPU = new javax.swing.JButton();
        jPanelSocket = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        txtTenSocket = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        txtMaSocket = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        btThemSocket = new javax.swing.JButton();
        btSuaSocket = new javax.swing.JButton();
        btXoaSocket = new javax.swing.JButton();
        btRFSocket = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbSocket = new javax.swing.JTable();
        btBackLogin = new javax.swing.JButton();
        jLabel53 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QUẢN LÝ LINH KIỆN");

        jPanel28.setBackground(new java.awt.Color(204, 255, 255));
        jPanel28.setToolTipText("");

        jTabbedPane1.setBackground(new java.awt.Color(204, 204, 204));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jPanelMB.setBackground(new java.awt.Color(53, 196, 192));
        jPanelMB.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("HÃNG");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("CHIPSET");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("KHE RAM");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("LOẠI RAM");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("SOCKET");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("GÍA");

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel36.setText("MÃ MAINBOARD");

        txtMaMain.setEnabled(false);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel12)
                    .addComponent(jLabel36))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHangMain, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaMain, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtChipset, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKheRAM, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CBLoaiRAMMB, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CBSocketMain, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGiaMain, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(txtMaMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(txtHangMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(txtChipset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(txtKheRAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(CBLoaiRAMMB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(CBSocketMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15)
                    .addComponent(txtGiaMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        btThemMain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add icon (1).png"))); // NOI18N
        btThemMain.setText("THÊM");
        btThemMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemMainActionPerformed(evt);
            }
        });

        btSuaMain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/edit icon (1).png"))); // NOI18N
        btSuaMain.setText("SỬA");
        btSuaMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaMainActionPerformed(evt);
            }
        });

        btXoaMain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete icon (1).png"))); // NOI18N
        btXoaMain.setText("XÓA");
        btXoaMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaMainActionPerformed(evt);
            }
        });

        btRFMain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/refresh icon (1).png"))); // NOI18N
        btRFMain.setText("LÀM MỚI");
        btRFMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRFMainActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btThemMain)
                .addGap(18, 18, 18)
                .addComponent(btSuaMain)
                .addGap(18, 18, 18)
                .addComponent(btXoaMain)
                .addGap(18, 18, 18)
                .addComponent(btRFMain)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSuaMain)
                    .addComponent(btThemMain)
                    .addComponent(btXoaMain)
                    .addComponent(btRFMain))
                .addGap(24, 24, 24))
        );

        jPanelMainb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        tbMainboard.setBackground(new java.awt.Color(204, 255, 255));
        tbMainboard.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tbMainboard.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ MAINBOARD", "HÃNG", "CHIPSET", "KHE RAM", "LOẠI RAM", "SOCKET", "GIÁ"
            }
        ));
        tbMainboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMainboardMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbMainboard);

        javax.swing.GroupLayout jPanelMainbLayout = new javax.swing.GroupLayout(jPanelMainb);
        jPanelMainb.setLayout(jPanelMainbLayout);
        jPanelMainbLayout.setHorizontalGroup(
            jPanelMainbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainbLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 991, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelMainbLayout.setVerticalGroup(
            jPanelMainbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        javax.swing.GroupLayout jPanelMBLayout = new javax.swing.GroupLayout(jPanelMB);
        jPanelMB.setLayout(jPanelMBLayout);
        jPanelMBLayout.setHorizontalGroup(
            jPanelMBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMBLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelMBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMBLayout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelMBLayout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                        .addComponent(jPanelMainb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79))))
        );
        jPanelMBLayout.setVerticalGroup(
            jPanelMBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMBLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanelMBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelMainb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("MAINBOARD", jPanelMB);

        jPanelRAM.setBackground(new java.awt.Color(53, 196, 196));

        jPanel25.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel46.setText("MÃ RAM");

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel47.setText("TÊN RAM");

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel48.setText("HÃNG");

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel49.setText("DUNG LƯỢNG");

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel50.setText("BUS");

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel51.setText("LOẠI RAM");

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel52.setText("GIÁ");

        txtMaRAM.setEnabled(false);

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel54.setText("GB");

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel55.setText("Mhz");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel52)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel46)
                            .addComponent(jLabel48)
                            .addComponent(jLabel47)
                            .addComponent(jLabel49)
                            .addComponent(jLabel50)
                            .addComponent(jLabel51))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtGiaRAM)
                            .addComponent(txtMaRAM, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(txtHangRAM)
                            .addComponent(txtTenRAM)
                            .addComponent(txtDLRAM)
                            .addComponent(txtBusRAM)
                            .addComponent(cbLoaiRAM, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel54)
                            .addComponent(jLabel55))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(txtMaRAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(txtHangRAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(txtTenRAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(txtDLRAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54))
                .addGap(47, 47, 47)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(txtBusRAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel55))
                .addGap(43, 43, 43)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel51)
                            .addComponent(cbLoaiRAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addComponent(jLabel52))
                    .addComponent(txtGiaRAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel26.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        btThemRAM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add icon (1).png"))); // NOI18N
        btThemRAM.setText("THÊM");
        btThemRAM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemRAMActionPerformed(evt);
            }
        });

        btSuaRAM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/edit icon (1).png"))); // NOI18N
        btSuaRAM.setText("SỬA");
        btSuaRAM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaRAMActionPerformed(evt);
            }
        });

        btRFRAM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/refresh icon (1).png"))); // NOI18N
        btRFRAM.setText("LÀM MỚI");
        btRFRAM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRFRAMActionPerformed(evt);
            }
        });

        btXoaRAM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete icon (1).png"))); // NOI18N
        btXoaRAM.setText("XÓA");
        btXoaRAM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaRAMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btThemRAM)
                .addGap(28, 28, 28)
                .addComponent(btSuaRAM)
                .addGap(18, 18, 18)
                .addComponent(btXoaRAM)
                .addGap(20, 20, 20)
                .addComponent(btRFRAM)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btThemRAM)
                    .addComponent(btSuaRAM)
                    .addComponent(btRFRAM)
                    .addComponent(btXoaRAM))
                .addGap(34, 34, 34))
        );

        jPanel27.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        tbRAM.setBackground(new java.awt.Color(204, 255, 255));
        tbRAM.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tbRAM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ RAM", "HÃNG", "TÊN RAM", "DUNG LƯỢNG", "BUS", "LOẠI RAM", "GIÁ"
            }
        ));
        tbRAM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbRAMMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tbRAM);

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE)
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8)
        );

        javax.swing.GroupLayout jPanelRAMLayout = new javax.swing.GroupLayout(jPanelRAM);
        jPanelRAM.setLayout(jPanelRAMLayout);
        jPanelRAMLayout.setHorizontalGroup(
            jPanelRAMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRAMLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanelRAMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );
        jPanelRAMLayout.setVerticalGroup(
            jPanelRAMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRAMLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanelRAMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("RAM", jPanelRAM);

        jPanelCase.setBackground(new java.awt.Color(53, 196, 196));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel38.setText("MÃ CASE");

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel39.setText("HÃNG");

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel40.setText("TÊN CASE");

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel41.setText("MÀU SẮC");

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel42.setText("CHẤT LIỆU");

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel43.setText("GIÁ");

        txtMaCase.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addComponent(jLabel39)
                    .addComponent(jLabel40)
                    .addComponent(jLabel41)
                    .addComponent(jLabel42)
                    .addComponent(jLabel43))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHangCase, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaCase, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenCase, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGiaCase, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(txtMaCase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel39)
                            .addComponent(txtHangCase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel40)
                            .addComponent(txtTenCase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel41)
                            .addComponent(txtMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addComponent(jLabel42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(txtChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(txtGiaCase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        btThemCase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add icon (1).png"))); // NOI18N
        btThemCase.setText("THÊM");
        btThemCase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemCaseActionPerformed(evt);
            }
        });

        btSuaCase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/edit icon (1).png"))); // NOI18N
        btSuaCase.setText("SỬA");
        btSuaCase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaCaseActionPerformed(evt);
            }
        });

        btRFCase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/refresh icon (1).png"))); // NOI18N
        btRFCase.setText("LÀM MỚI");
        btRFCase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRFCaseActionPerformed(evt);
            }
        });

        btXoaCase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete icon (1).png"))); // NOI18N
        btXoaCase.setText("XÓA");
        btXoaCase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaCaseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btThemCase)
                .addGap(18, 18, 18)
                .addComponent(btSuaCase)
                .addGap(18, 18, 18)
                .addComponent(btXoaCase)
                .addGap(18, 18, 18)
                .addComponent(btRFCase)
                .addGap(32, 32, 32))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btThemCase)
                    .addComponent(btSuaCase)
                    .addComponent(btRFCase)
                    .addComponent(btXoaCase))
                .addGap(23, 23, 23))
        );

        jPanel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        tbCase.setBackground(new java.awt.Color(204, 255, 255));
        tbCase.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tbCase.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ CASE", "HÃNG", "TÊN CASE", "MÀU SẮC", "CHẤT LIỆU", "GIÁ"
            }
        ));
        tbCase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCaseMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tbCase);

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 997, Short.MAX_VALUE)
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanelCaseLayout = new javax.swing.GroupLayout(jPanelCase);
        jPanelCase.setLayout(jPanelCaseLayout);
        jPanelCaseLayout.setHorizontalGroup(
            jPanelCaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCaseLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanelCaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, 440, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        jPanelCaseLayout.setVerticalGroup(
            jPanelCaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCaseLayout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(jPanelCaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        jTabbedPane1.addTab("CASE", jPanelCase);

        jPanelVGA.setBackground(new java.awt.Color(53, 196, 196));

        jPanel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setText("MÃ VGA");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setText("HÃNG");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setText("DÒNG");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel31.setText("NHÂN");

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel32.setText("XUNG NHỊP");

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel33.setText("GIÁ");

        txtMaVGA.setEnabled(false);

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel45.setText("TÊN VGA");

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel56.setText("Ghz");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33)
                    .addComponent(jLabel45))
                .addGap(29, 29, 29)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtXungVGA, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                    .addComponent(txtNhanVGA, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDongVGA, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenVGA, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHangVGA, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaVGA, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtGiaVGA))
                .addGap(18, 18, 18)
                .addComponent(jLabel56)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(txtMaVGA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(txtHangVGA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(txtTenVGA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtDongVGA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txtNhanVGA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(txtXungVGA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56))
                .addGap(46, 46, 46)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel33)
                    .addComponent(txtGiaVGA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        btThemVGA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add icon (1).png"))); // NOI18N
        btThemVGA.setText("THÊM");
        btThemVGA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemVGAActionPerformed(evt);
            }
        });

        btSuaVGA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/edit icon (1).png"))); // NOI18N
        btSuaVGA.setText("SỬA");
        btSuaVGA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaVGAActionPerformed(evt);
            }
        });

        btRFVGA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/refresh icon (1).png"))); // NOI18N
        btRFVGA.setText("LÀM MỚI");
        btRFVGA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRFVGAActionPerformed(evt);
            }
        });

        btXoaVGA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete icon (1).png"))); // NOI18N
        btXoaVGA.setText("XÓA");
        btXoaVGA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaVGAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btThemVGA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btSuaVGA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btXoaVGA)
                .addGap(10, 10, 10)
                .addComponent(btRFVGA)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSuaVGA)
                    .addComponent(btThemVGA)
                    .addComponent(btXoaVGA)
                    .addComponent(btRFVGA))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        tbVGA.setBackground(new java.awt.Color(204, 255, 255));
        tbVGA.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tbVGA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ VGA", "HÃNG", "TÊN VGA", "DÒNG", "NHÂN", "XUNG NHỊP", "GIÁ"
            }
        ));
        tbVGA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbVGAMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbVGA);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 931, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanelVGALayout = new javax.swing.GroupLayout(jPanelVGA);
        jPanelVGA.setLayout(jPanelVGALayout);
        jPanelVGALayout.setHorizontalGroup(
            jPanelVGALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVGALayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanelVGALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );
        jPanelVGALayout.setVerticalGroup(
            jPanelVGALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVGALayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanelVGALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("VGA", jPanelVGA);

        jPanelPSU.setBackground(new java.awt.Color(53, 196, 196));

        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("MÃ PSU");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setText("HÃNG");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setText("CÔNG SUẤT");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setText("CHUẨN");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setText("GIÁ");

        txtMaPSU.setEnabled(false);

        txtHangPSU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHangPSUActionPerformed(evt);
            }
        });

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel57.setText("V");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27))
                .addGap(47, 47, 47)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaPSU)
                    .addComponent(txtHangPSU)
                    .addComponent(txtCongSuatPSU)
                    .addComponent(txtChuanPSU)
                    .addComponent(txtGiaPSU, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addComponent(jLabel57)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtMaPSU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtHangPSU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtCongSuatPSU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel57))
                .addGap(37, 37, 37)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtChuanPSU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txtGiaPSU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(108, Short.MAX_VALUE))
        );

        jPanel16.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        btThemPSU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add icon (1).png"))); // NOI18N
        btThemPSU.setText("THÊM");
        btThemPSU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemPSUActionPerformed(evt);
            }
        });

        btSuaPSU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/edit icon (1).png"))); // NOI18N
        btSuaPSU.setText("SỬA");
        btSuaPSU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaPSUActionPerformed(evt);
            }
        });

        btXoaPSU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete icon (1).png"))); // NOI18N
        btXoaPSU.setText("XÓA");
        btXoaPSU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaPSUActionPerformed(evt);
            }
        });

        btRFPSU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/refresh icon (1).png"))); // NOI18N
        btRFPSU.setText("LÀM MỚI");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btThemPSU)
                .addGap(18, 18, 18)
                .addComponent(btSuaPSU)
                .addGap(33, 33, 33)
                .addComponent(btXoaPSU)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(btRFPSU)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btSuaPSU)
                        .addComponent(btThemPSU))
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btXoaPSU)
                        .addComponent(btRFPSU)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        tbPSU.setBackground(new java.awt.Color(204, 255, 255));
        tbPSU.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tbPSU.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ PSU", "HÃNG", "CÔNG SUẤT", "CHUẨN", "GIÁ"
            }
        ));
        tbPSU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPSUMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbPSU);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 877, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelPSULayout = new javax.swing.GroupLayout(jPanelPSU);
        jPanelPSU.setLayout(jPanelPSULayout);
        jPanelPSULayout.setHorizontalGroup(
            jPanelPSULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPSULayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanelPSULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );
        jPanelPSULayout.setVerticalGroup(
            jPanelPSULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPSULayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanelPSULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("PSU", jPanelPSU);

        jPanelOCung.setBackground(new java.awt.Color(53, 196, 196));

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("HÃNG");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("LOẠI Ổ CỨNG");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("DUNG LƯỢNG");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("GHI");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("ĐỌC");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("GIÁ");

        txtDocOC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDocOCActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel34.setText("MÃ Ổ CỨNG");

        txtMaOC.setEnabled(false);
        txtMaOC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaOCActionPerformed(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel44.setText("TÊN Ổ CỨNG");

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel58.setText("TB");

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel59.setText("Mb/s");

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel60.setText("Mb/s");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel19)
                    .addComponent(jLabel18)
                    .addComponent(jLabel17)
                    .addComponent(jLabel44)
                    .addComponent(jLabel16)
                    .addComponent(jLabel34))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHangOC, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaOC, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenOC, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(txtDLOC, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel58)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(txtGhiOC, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel59))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(CBloaiOCung, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addComponent(txtDocOC, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel60))
                                            .addComponent(txtGiaOC, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(txtMaOC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16)
                    .addComponent(txtHangOC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(txtTenOC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CBloaiOCung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(27, 27, 27)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18)
                    .addComponent(txtDLOC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58))
                .addGap(34, 34, 34)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtGhiOC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel59))
                .addGap(20, 20, 20)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel20)
                        .addComponent(txtDocOC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel60))
                .addGap(24, 24, 24)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtGiaOC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        btThemOC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add icon (1).png"))); // NOI18N
        btThemOC.setText("THÊM");
        btThemOC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemOCActionPerformed(evt);
            }
        });

        btSuaOC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/edit icon (1).png"))); // NOI18N
        btSuaOC.setText("SỬA");
        btSuaOC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaOCActionPerformed(evt);
            }
        });

        btXoaOC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete icon (1).png"))); // NOI18N
        btXoaOC.setText("XÓA");
        btXoaOC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaOCActionPerformed(evt);
            }
        });

        btRFOC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/refresh icon (1).png"))); // NOI18N
        btRFOC.setText("LÀM MỚI");
        btRFOC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRFOCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btThemOC)
                .addGap(18, 18, 18)
                .addComponent(btSuaOC)
                .addGap(18, 18, 18)
                .addComponent(btXoaOC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btRFOC)
                .addGap(6, 6, 6))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btThemOC)
                    .addComponent(btSuaOC)
                    .addComponent(btXoaOC)
                    .addComponent(btRFOC))
                .addContainerGap())
        );

        jPanel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        tbOCung.setBackground(new java.awt.Color(204, 255, 255));
        tbOCung.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tbOCung.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ Ổ CỨNG", "HÃNG", "TÊN Ổ CỨNG", "LOẠI Ổ CỨNG", "DUNG LƯỢNG", "GHI", "ĐỌC", "GIÁ"
            }
        ));
        tbOCung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbOCungMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tbOCung);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 935, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelOCungLayout = new javax.swing.GroupLayout(jPanelOCung);
        jPanelOCung.setLayout(jPanelOCungLayout);
        jPanelOCungLayout.setHorizontalGroup(
            jPanelOCungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOCungLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanelOCungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelOCungLayout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelOCungLayout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                        .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93))))
        );
        jPanelOCungLayout.setVerticalGroup(
            jPanelOCungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOCungLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanelOCungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ổ CỨNG", jPanelOCung);

        jPanelCPU.setBackground(new java.awt.Color(53, 198, 198));
        jPanelCPU.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jPanelNhapCPU.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanelNhapCPU.setForeground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel1.setText("DÒNG");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel2.setText("THẾ HỆ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel4.setText("LUỒNG");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel3.setText("NHÂN");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel5.setText("XUNG NHỊP");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel6.setText("CACHE");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel7.setText("SOCKET");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel8.setText("GIÁ");

        CBSocketCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBSocketCPUActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("HÃNG");

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel37.setText("MÃ CPU");

        txtMaCPU.setEnabled(false);

        javax.swing.GroupLayout jPanelNhapCPULayout = new javax.swing.GroupLayout(jPanelNhapCPU);
        jPanelNhapCPU.setLayout(jPanelNhapCPULayout);
        jPanelNhapCPULayout.setHorizontalGroup(
            jPanelNhapCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNhapCPULayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelNhapCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelNhapCPULayout.createSequentialGroup()
                        .addGroup(jPanelNhapCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelNhapCPULayout.createSequentialGroup()
                                .addComponent(jLabel37)
                                .addGap(113, 113, 113)
                                .addComponent(txtMaCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelNhapCPULayout.createSequentialGroup()
                                .addGroup(jPanelNhapCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9))
                                .addGap(108, 108, 108)
                                .addGroup(jPanelNhapCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtGiaCPU)
                                    .addComponent(txtDongCPU)
                                    .addComponent(txtHangCPU)
                                    .addComponent(txtTheheCPU)
                                    .addComponent(txtNhanCPU)
                                    .addComponent(txtLuongCPU)
                                    .addComponent(txtXungCPU)
                                    .addComponent(txtCacheCPU)
                                    .addGroup(jPanelNhapCPULayout.createSequentialGroup()
                                        .addComponent(CBSocketCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(208, 208, 208))
                    .addGroup(jPanelNhapCPULayout.createSequentialGroup()
                        .addGroup(jPanelNhapCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanelNhapCPULayout.setVerticalGroup(
            jPanelNhapCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNhapCPULayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanelNhapCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(txtMaCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanelNhapCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtHangCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanelNhapCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDongCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanelNhapCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTheheCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelNhapCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNhanCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanelNhapCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtLuongCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanelNhapCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtXungCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelNhapCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCacheCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanelNhapCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(CBSocketCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelNhapCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGiaCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(30, 30, 30))
        );

        jPanelTBCPU.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        tbCPU.setBackground(new java.awt.Color(204, 255, 255));
        tbCPU.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tbCPU.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ CPU", "HẢNG", "DÒNG", "THẾ HỆ", "NHÂN", "LUÔNG", "XUNG NHỊP", "CACHE", "SOCKET", "GIÁ"
            }
        ));
        tbCPU.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        tbCPU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCPUMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbCPU);

        javax.swing.GroupLayout jPanelTBCPULayout = new javax.swing.GroupLayout(jPanelTBCPU);
        jPanelTBCPU.setLayout(jPanelTBCPULayout);
        jPanelTBCPULayout.setHorizontalGroup(
            jPanelTBCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 983, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanelTBCPULayout.setVerticalGroup(
            jPanelTBCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
        );

        jPanelbuttonMB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        btThemCPU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add icon (1).png"))); // NOI18N
        btThemCPU.setText("THÊM");
        btThemCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemCPUActionPerformed(evt);
            }
        });

        btSuaCPU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/edit icon (1).png"))); // NOI18N
        btSuaCPU.setText("SỬA");
        btSuaCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaCPUActionPerformed(evt);
            }
        });

        btXoaCPU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete icon (1).png"))); // NOI18N
        btXoaCPU.setText("XÓA");
        btXoaCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaCPUActionPerformed(evt);
            }
        });

        btRFCPU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/refresh icon (1).png"))); // NOI18N
        btRFCPU.setText("LÀM MỚI");
        btRFCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRFCPUActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelbuttonMBLayout = new javax.swing.GroupLayout(jPanelbuttonMB);
        jPanelbuttonMB.setLayout(jPanelbuttonMBLayout);
        jPanelbuttonMBLayout.setHorizontalGroup(
            jPanelbuttonMBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelbuttonMBLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btThemCPU)
                .addGap(27, 27, 27)
                .addComponent(btSuaCPU)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btXoaCPU)
                .addGap(18, 18, 18)
                .addComponent(btRFCPU)
                .addContainerGap())
        );
        jPanelbuttonMBLayout.setVerticalGroup(
            jPanelbuttonMBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelbuttonMBLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelbuttonMBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btThemCPU)
                    .addComponent(btSuaCPU)
                    .addComponent(btXoaCPU)
                    .addComponent(btRFCPU))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelCPULayout = new javax.swing.GroupLayout(jPanelCPU);
        jPanelCPU.setLayout(jPanelCPULayout);
        jPanelCPULayout.setHorizontalGroup(
            jPanelCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCPULayout.createSequentialGroup()
                .addGroup(jPanelCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCPULayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jPanelNhapCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addComponent(jPanelTBCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelCPULayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jPanelbuttonMB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanelCPULayout.setVerticalGroup(
            jPanelCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCPULayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanelCPULayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelTBCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelCPULayout.createSequentialGroup()
                        .addComponent(jPanelNhapCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanelbuttonMB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("CPU", jPanelCPU);

        jPanelSocket.setBackground(new java.awt.Color(53, 196, 196));

        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("TÊN SOCKET");

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel35.setText("MÃ SOCKET");

        txtMaSocket.setEnabled(false);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jLabel35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTenSocket, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                    .addComponent(txtMaSocket))
                .addGap(31, 31, 31))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel35)
                    .addComponent(txtMaSocket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTenSocket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        btThemSocket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add icon (1).png"))); // NOI18N
        btThemSocket.setText("THÊM");
        btThemSocket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemSocketActionPerformed(evt);
            }
        });

        btSuaSocket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/edit icon (1).png"))); // NOI18N
        btSuaSocket.setText("SỬA");
        btSuaSocket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaSocketActionPerformed(evt);
            }
        });

        btXoaSocket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete icon (1).png"))); // NOI18N
        btXoaSocket.setText("XÓA");
        btXoaSocket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaSocketActionPerformed(evt);
            }
        });

        btRFSocket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/refresh icon (1).png"))); // NOI18N
        btRFSocket.setText("LÀM MỚI");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btThemSocket)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(btSuaSocket)
                .addGap(18, 18, 18)
                .addComponent(btXoaSocket)
                .addGap(18, 18, 18)
                .addComponent(btRFSocket)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btThemSocket)
                    .addComponent(btSuaSocket)
                    .addComponent(btXoaSocket)
                    .addComponent(btRFSocket))
                .addGap(35, 35, 35))
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        tbSocket.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tbSocket.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ SOCKET", "TÊN SOCKET"
            }
        ));
        tbSocket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSocketMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbSocket);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelSocketLayout = new javax.swing.GroupLayout(jPanelSocket);
        jPanelSocket.setLayout(jPanelSocketLayout);
        jPanelSocketLayout.setHorizontalGroup(
            jPanelSocketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSocketLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanelSocketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(187, 187, 187)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(282, Short.MAX_VALUE))
        );
        jPanelSocketLayout.setVerticalGroup(
            jPanelSocketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSocketLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanelSocketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("SOCKET", jPanelSocket);

        btBackLogin.setBackground(new java.awt.Color(204, 255, 255));
        btBackLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Back-icon.png"))); // NOI18N
        btBackLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBackLoginActionPerformed(evt);
            }
        });

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel53.setText("QUẢN LÝ LINH KIỆN");

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(btBackLogin)
                        .addGap(647, 647, 647)
                        .addComponent(jLabel53))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1584, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(btBackLogin))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel53)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, 745, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbOCungMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbOCungMouseClicked
        selectedIndex = tbOCung.getSelectedRow();
        OCung o = listOCung.get(selectedIndex);
        txtMaOC.setText(o.getMaOCung());
        txtHangOC.setText(o.getHang());
        txtTenOC.setText(o.getTenOCung());
        txtDLOC.setText(String.valueOf(o.getDungLuong()));
        txtGhiOC.setText(String.valueOf(o.getGhi()));
        txtDocOC.setText(String.valueOf(o.getDoc()));
        txtGiaOC.setText(String.valueOf(o.getGia()));
    }//GEN-LAST:event_tbOCungMouseClicked

    private void btXoaOCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaOCActionPerformed
        JOptionPane.showConfirmDialog(this, "Bạn đã chắc chắn muốn xóa chưa ?");
        new connection().deleteOCung(txtMaOC.getText());
        modelTBOCung.setNumRows(0);
        listOCung = new connection().getListOCung();
        modelTBOCung.setColumnIdentifiers(new Object[]{
            "MÃ Ổ CỨNG", "HẢNG", "TÊN Ổ CỨNG", "LOẠI Ổ CỨNG", "DUNG LƯỢNG", "GHI", "ĐỌC", "GIÁ"
        });
        showTBOCung();
    }//GEN-LAST:event_btXoaOCActionPerformed

    private void btSuaOCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaOCActionPerformed
        OCung m = new OCung();
        m.setMaOCung(txtMaOC.getText());
        m.setHang(txtHangOC.getText());
        m.setTenOCung(txtTenOC.getText());
        m.setDoc(Integer.parseInt(txtDocOC.getText()));
        m.setGhi(Integer.parseInt(txtGhiOC.getText()));
        m.getLoaiOCung().setMaLoaiOCung(CBloaiOCung.getSelectedIndex() + 1);
        m.getLoaiOCung().setLoaiOCung((String) (CBloaiOCung.getSelectedItem()));
        m.setDungLuong(Integer.parseInt(txtDLOC.getText()));
        m.setGia(Integer.parseInt(txtGiaOC.getText()));
        new connection().updateOCung(m);
        JOptionPane.showMessageDialog(rootPane, "Thêm thông tin O Cung mới thành công!");
        modelTBOCung.setNumRows(0);
        listOCung = new connection().getListOCung();
        modelTBOCung.setColumnIdentifiers(new Object[]{
            "MÃ Ổ CỨNG", "HẢNG", "TÊN Ổ CỨNG", "LOẠI Ổ CỨNG", "DUNG LƯỢNG", "GHI", "ĐỌC", "GIÁ"
        });
        showTBOCung();
    }//GEN-LAST:event_btSuaOCActionPerformed

    private void btThemOCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemOCActionPerformed
        OCung m = new OCung();
        m.setMaOCung(txtMaOC.getText());
        m.setHang(txtHangOC.getText());
        m.setTenOCung(txtTenOC.getText());
        m.setDoc(Integer.parseInt(txtDocOC.getText()));
        m.setGhi(Integer.parseInt(txtGhiOC.getText()));
        m.getLoaiOCung().setMaLoaiOCung(CBloaiOCung.getSelectedIndex() + 1);
        m.getLoaiOCung().setLoaiOCung((String) (CBloaiOCung.getSelectedItem()));
        m.setDungLuong(Integer.parseInt(txtDLOC.getText()));
        m.setGia(Integer.parseInt(txtGiaOC.getText()));
        if (new connection().addOCung(m)) {
            JOptionPane.showMessageDialog(rootPane, "Thêm thông tin O Cung mới thành công!");
            listOCung.add(m); // them vao danh sach CPU
            modelTBOCung.setNumRows(0);
            listOCung = new connection().getListOCung();
            modelTBOCung.setColumnIdentifiers(new Object[]{
                "MÃ Ổ CỨNG", "HẢNG", "TÊN Ổ CỨNG", "LOẠI Ổ CỨNG", "DUNG LƯỢNG", "GHI", "ĐỌC", "GIÁ"
            });
            showTBOCung();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Trung khoa chinh");
        }
    }//GEN-LAST:event_btThemOCActionPerformed

    private void txtMaOCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaOCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaOCActionPerformed

    private void txtDocOCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDocOCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDocOCActionPerformed

    private void tbPSUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPSUMouseClicked
        selectedIndex = tbPSU.getSelectedRow();
        PSU p = listPSU.get(selectedIndex);
        txtMaPSU.setText(p.getMaPSU());
        txtHangPSU.setText(p.getHang());
        txtCongSuatPSU.setText(String.valueOf(p.getCongsuat()));
        txtChuanPSU.setText(p.getChuan());
        txtGiaPSU.setText(String.valueOf(p.getGia()));
    }//GEN-LAST:event_tbPSUMouseClicked

    private void btXoaPSUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaPSUActionPerformed
        JOptionPane.showConfirmDialog(this, "Bạn đã chắc chắn muốn xóa chưa ?");
        new connection().deletePSU(txtMaPSU.getText());
        modelTBPSU.setNumRows(0);
        listPSU = new connection().getListPSU();
        modelTBPSU.setColumnIdentifiers(new Object[]{
            "MÃ PSU", "HẢNG", "CÔNG SUẤT", "CHUẨN", "GIÁ"
        });
        showTBPSU();
    }//GEN-LAST:event_btXoaPSUActionPerformed

    private void btSuaPSUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaPSUActionPerformed
        PSU m = new PSU();
        m.setMaPSU(txtMaPSU.getText());
        m.setHang(txtHangPSU.getText());
        m.setCongsuat(Integer.parseInt(txtCongSuatPSU.getText()));
        m.setChuan(txtChuanPSU.getText());
        m.setGia(Integer.parseInt(txtGiaPSU.getText()));
        new connection().updatePSU(m);
        JOptionPane.showMessageDialog(rootPane, "Thêm thông tin PSU mới thành công!");
        modelTBPSU.setNumRows(0);
        listPSU = new connection().getListPSU();
        modelTBPSU.setColumnIdentifiers(new Object[]{
            "MÃ PSU", "HẢNG", "CÔNG SUẤT", "CHUẨN", "GIÁ"
        });
        showTBPSU();
    }//GEN-LAST:event_btSuaPSUActionPerformed

    private void btThemPSUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemPSUActionPerformed
        PSU m = new PSU();
        m.setMaPSU(txtMaPSU.getText());
        m.setHang(txtHangPSU.getText());
        m.setCongsuat(Integer.parseInt(txtCongSuatPSU.getText()));
        m.setChuan(txtChuanPSU.getText());
        m.setGia(Integer.parseInt(txtGiaPSU.getText()));
        if (new connection().addPSU(m)) {
            JOptionPane.showMessageDialog(rootPane, "Thêm thông tin PSU mới thành công!");
            listPSU.add(m); // them vao danh sach CPU
            modelTBPSU.setNumRows(0);
            listPSU = new connection().getListPSU();
            modelTBPSU.setColumnIdentifiers(new Object[]{
                "MÃ PSU", "HẢNG", "CÔNG SUẤT", "CHUẨN", "GIÁ"
            });
            showTBPSU();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Trung khoa chinh");
    }//GEN-LAST:event_btThemPSUActionPerformed
    }
    private void txtHangPSUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHangPSUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHangPSUActionPerformed

    private void tbVGAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbVGAMouseClicked
        selectedIndex = tbVGA.getSelectedRow();
        VGA v = listVGA.get(selectedIndex);
        txtMaVGA.setText(v.getMaVGA());
        txtHangVGA.setText(v.getHang());
        txtTenVGA.setText(v.getTenVGA());
        txtDongVGA.setText(v.getDong());
        txtNhanVGA.setText(String.valueOf(v.getNhan()));
        txtXungVGA.setText(String.valueOf(v.getXungnhip()));
        txtGiaVGA.setText(String.valueOf(v.getGia()));
    }//GEN-LAST:event_tbVGAMouseClicked

    private void btXoaVGAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaVGAActionPerformed
        JOptionPane.showConfirmDialog(this, "Bạn đã chắc chắn muốn xóa chưa ?");
        new connection().deleteVGA(txtMaVGA.getText());
        modelTBVGA.setNumRows(0);
        listVGA = new connection().getListVGA();
        modelTBVGA.setColumnIdentifiers(new Object[]{
            "MÃ VGA", "HẢNG", "TÊN VGA", "DÒNG", "NHÂN", "XUNG NHỊP", "GIÁ"
        });
        showTBVGA();
    }//GEN-LAST:event_btXoaVGAActionPerformed

    private void btRFVGAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRFVGAActionPerformed
        txtHangVGA.setText(null);
        txtDongVGA.setText(null);
        txtNhanVGA.setText(null);
        txtXungVGA.setText(null);
        txtGiaVGA.setText(null);
        txtTenVGA.setText(null);
    }//GEN-LAST:event_btRFVGAActionPerformed

    private void btSuaVGAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaVGAActionPerformed
        VGA m = new VGA();
        m.setMaVGA(txtMaVGA.getText());
        m.setHang(txtHangVGA.getText());
        m.setDong(txtDongVGA.getText());
        m.setNhan(Integer.parseInt(txtNhanVGA.getText()));
        m.setXungnhip(Float.parseFloat(txtChatLieu.getText()));
        m.setGia(Integer.parseInt(txtGiaVGA.getText()));
        new connection().updateVGA(m);
        JOptionPane.showMessageDialog(rootPane, "Thêm thông tin Case mới thành công!");
        modelTBVGA.setNumRows(0);
        listVGA = new connection().getListVGA();
        modelTBVGA.setColumnIdentifiers(new Object[]{
            "MÃ VGA", "HẢNG", "TÊN VGA", "DÒNG", "NHÂN", "XUNG NHỊP", "GIÁ"
        });
        showTBVGA();
    }//GEN-LAST:event_btSuaVGAActionPerformed

    private void btThemVGAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemVGAActionPerformed
        VGA m = new VGA();
        m.setMaVGA(txtMaVGA.getText());
        m.setHang(txtHangVGA.getText());
        m.setDong(txtDongVGA.getText());
        m.setNhan(Integer.parseInt(txtNhanVGA.getText()));
        m.setXungnhip(Float.parseFloat(txtChatLieu.getText()));
        m.setGia(Integer.parseInt(txtGiaVGA.getText()));
        if (new connection().addVGA(m)) {
            JOptionPane.showMessageDialog(rootPane, "Thêm thông tin Case mới thành công!");
            listVGA.add(m); // them vao danh sach CPU
            modelTBVGA.setNumRows(0);
            listVGA = new connection().getListVGA();
            modelTBVGA.setColumnIdentifiers(new Object[]{
                "MÃ VGA", "HẢNG", "TÊN VGA", "DÒNG", "NHÂN", "XUNG NHỊP", "GIÁ"
            });
            showTBVGA();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Trung khoa chinh");
    }//GEN-LAST:event_btThemVGAActionPerformed
    }
    private void tbCaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCaseMouseClicked
        selectedIndex = tbCase.getSelectedRow();
        Case c = listCase.get(selectedIndex);
        txtMaCase.setText(c.getMaCase());
        txtTenCase.setText(c.getTenCase());
        txtHangCase.setText(c.getHang());
        txtChatLieu.setText(c.getChatLieu());
        txtMauSac.setText(c.getMaCase());
        txtGiaCase.setText(String.valueOf(c.getGia()));
    }//GEN-LAST:event_tbCaseMouseClicked

    private void btXoaCaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaCaseActionPerformed
        JOptionPane.showConfirmDialog(this, "Bạn đã chắc chắn muốn xóa chưa ?");
        new connection().deleteCase(txtMaCase.getText());
        modelTBCase.setNumRows(0);
        listCase = new connection().getListCase();
        modelTBCase.setColumnIdentifiers(new Object[]{
            "MÃ CASE", "HẢNG", "TÊN SOCKET", "MÀU SẮC", "CHẤT LIỆU", "GIÁ"
        });
        showTBCase();
    }//GEN-LAST:event_btXoaCaseActionPerformed

    private void btSuaCaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaCaseActionPerformed
        Case m = new Case();
        m.setMaCase(txtMaCase.getText());
        m.setHang(txtHangCase.getText());
        m.setTenCase(txtTenCase.getText());
        m.setMauSac(txtMauSac.getText());
        m.setChatLieu(txtChatLieu.getText());
        m.setGia(Integer.parseInt(txtGiaCase.getText()));
        new connection().updateCase(m);
        JOptionPane.showMessageDialog(rootPane, "Thêm thông tin Case mới thành công!");
        modelTBCase.setNumRows(0);
        listCase = new connection().getListCase();
        modelTBCase.setColumnIdentifiers(new Object[]{
            "MÃ CASE", "HẢNG", "TÊN SOCKET", "MÀU SẮC", "CHẤT LIỆU", "GIÁ"
        });
        showTBCase();
    }//GEN-LAST:event_btSuaCaseActionPerformed

    private void btThemCaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemCaseActionPerformed
        Case m = new Case();
        m.setMaCase(txtMaCase.getText());
        m.setHang(txtHangCase.getText());
        m.setTenCase(txtTenCase.getText());
        m.setMauSac(txtMauSac.getText());
        m.setChatLieu(txtChatLieu.getText());
        m.setGia(Integer.parseInt(txtGiaCase.getText()));
        if (new connection().addCase(m)) {
            JOptionPane.showMessageDialog(rootPane, "Thêm thông tin Case mới thành công!");
            listCase.add(m); // them vao danh sach CPU
            modelTBCase.setNumRows(0);
            listCase = new connection().getListCase();
            modelTBCase.setColumnIdentifiers(new Object[]{
                "MÃ CASE", "HẢNG", "TÊN SOCKET", "MÀU SẮC", "CHẤT LIỆU", "GIÁ"
            });
            showTBCase();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Trung khoa chinh");
    }//GEN-LAST:event_btThemCaseActionPerformed
    }
    private void tbSocketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSocketMouseClicked
        selectedIndex = tbSocket.getSelectedRow();
        Socket s = listSocket.get(selectedIndex);
        txtMaSocket.setText(String.valueOf(s.getMaSocket()));
        txtTenSocket.setText(s.getSocket());
    }//GEN-LAST:event_tbSocketMouseClicked

    private void btXoaSocketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaSocketActionPerformed
        JOptionPane.showConfirmDialog(this, "Bạn đã chắc chắn muốn xóa chưa ?");
        new connection().deleteSocket(Integer.parseInt(txtMaSocket.getText()));
        modelTBSocket.setNumRows(0);
        listSocket = new connection().getListSocket();
        modelTBSocket.setColumnIdentifiers(new Object[]{
            "MÃ SOCKET", "TÊN SOCKET"
        });
        showTBSocket();
    }//GEN-LAST:event_btXoaSocketActionPerformed

    private void btSuaSocketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaSocketActionPerformed
        Socket m = new Socket();
        m.setMaSocket(Integer.parseInt(txtMaSocket.getText()));
        m.setSocket(txtTenSocket.getText());
        new connection().updateSocket(m);
        JOptionPane.showMessageDialog(rootPane, "Thêm thông tin Socket mới thành công!");
        modelTBSocket.setNumRows(0);
        listSocket = new connection().getListSocket();
        modelTBSocket.setColumnIdentifiers(new Object[]{
            "MÃ SOCKET", "TÊN SOCKET"
        });
        showTBSocket();
    }//GEN-LAST:event_btSuaSocketActionPerformed

    private void btThemSocketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemSocketActionPerformed
        Socket m = new Socket();
        m.setMaSocket(Integer.parseInt(txtMaSocket.getText()));
        m.setSocket(txtTenSocket.getText());
        if (new connection().addSocket(m)) {
            JOptionPane.showMessageDialog(rootPane, "Thêm thông tin Socket mới thành công!");
            listSocket.add(m); // them vao danh sach CPU
            modelTBSocket.setNumRows(0);
            listSocket = new connection().getListSocket();
            modelTBSocket.setColumnIdentifiers(new Object[]{
                "MÃ SOCKET", "TÊN SOCKET"
            });
            showTBSocket();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Trung khoa chinh");
    }//GEN-LAST:event_btThemSocketActionPerformed
    }
    private void tbRAMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbRAMMouseClicked
        selectedIndex = tbRAM.getSelectedRow();
        RAM r = listRAM.get(selectedIndex);
        txtMaRAM.setText(r.getMaRAM());
        txtHangRAM.setText(r.getHang());
        txtTenRAM.setText(r.getTenRAM());
        txtDLRAM.setText(String.valueOf(r.getDungLuong()));
        txtBusRAM.setText(String.valueOf(r.getBus()));
        CBLoaiRAMMB.setSelectedItem(r.getLoaiRAM());
        txtGiaRAM.setText(String.valueOf(r.getGia()));
    }//GEN-LAST:event_tbRAMMouseClicked

    private void btXoaRAMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaRAMActionPerformed
        JOptionPane.showConfirmDialog(this, "Bạn đã chắc chắn muốn xóa chưa ?");
        new connection().deleteRAM(txtMaRAM.getText());
        modelTBRAM.setNumRows(0);
        listRAM = new connection().getListRAM();
        modelTBRAM.setColumnIdentifiers(new Object[]{
            "MÃ RAM", "HẢNG", "TÊN RAM", "DUNG LƯỢNG", "BUS", "LOẠI RAM", "GIÁ"
        });
        showTBRAM();
    }//GEN-LAST:event_btXoaRAMActionPerformed

    private void btSuaRAMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaRAMActionPerformed
        RAM m = new RAM();
        autoGenIDMainboard();
        m.setMaRAM(txtMaRAM.getText());
        m.setHang(txtHangRAM.getText());
        m.setTenRAM(txtTenRAM.getText());
        m.setDungLuong(Integer.parseInt(txtDLRAM.getText()));
        m.getLoaiRAM().setMaLoaiRAM(cbLoaiRAM.getSelectedIndex() + 1);
        m.getLoaiRAM().setLoaiRAM((String) (cbLoaiRAM.getSelectedItem()));
        m.setBus(Integer.parseInt(txtBusRAM.getText()));
        m.setGia(Integer.parseInt(txtGiaRAM.getText()));
        new connection().updateRAM(m);
        JOptionPane.showMessageDialog(rootPane, "Sửa thông tin RAM mới thành công!");
        modelTBRAM.setNumRows(0);
        listRAM = new connection().getListRAM();
        modelTBRAM.setColumnIdentifiers(new Object[]{
            "MÃ RAM", "HẢNG", "TÊN RAM", "DUNG LƯỢNG", "BUS", "LOẠI RAM", "GIÁ"
        });
        showTBRAM();
    }//GEN-LAST:event_btSuaRAMActionPerformed

    private void btThemRAMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemRAMActionPerformed
        RAM m = new RAM();
        autoGenIDMainboard();
        m.setMaRAM(txtMaRAM.getText());
        m.setHang(txtHangRAM.getText());
        m.setTenRAM(txtTenRAM.getText());
        m.setDungLuong(Integer.parseInt(txtDLRAM.getText()));
        m.getLoaiRAM().setMaLoaiRAM(cbLoaiRAM.getSelectedIndex() + 1);
        m.getLoaiRAM().setLoaiRAM((String) (cbLoaiRAM.getSelectedItem()));
        m.setBus(Integer.parseInt(txtBusRAM.getText()));
        m.setGia(Integer.parseInt(txtGiaRAM.getText()));
        if (new connection().addRAM(m)) {
            JOptionPane.showMessageDialog(rootPane, "Thêm thông tin RAM mới thành công!");
            listRAM.add(m); // them vao danh sach CPU
            modelTBRAM.setNumRows(0);
            listRAM = new connection().getListRAM();
            modelTBRAM.setColumnIdentifiers(new Object[]{
                "MÃ RAM", "HẢNG", "TÊN RAM", "DUNG LƯỢNG", "BUS", "LOẠI RAM", "GIÁ"
            });
            showTBRAM();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Trung khoa chinh");
        }
    }//GEN-LAST:event_btThemRAMActionPerformed

    private void tbMainboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMainboardMouseClicked
        selectedIndex = tbMainboard.getSelectedRow();
        Mainboard m = listMainboard.get(selectedIndex);
        txtMaMain.setText(m.getMaMainboard());
        txtHangMain.setText(m.getHang());
        txtChipset.setText(m.getChipset());
        txtKheRAM.setText(String.valueOf(m.getKheRAM()));
        CBLoaiRAMMB.setSelectedItem(m.getLoaiRAM());
        CBSocketMain.setSelectedItem(m.getSocket());
        txtGiaMain.setText(String.valueOf(m.getGia()));
    }//GEN-LAST:event_tbMainboardMouseClicked

    private void btXoaMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaMainActionPerformed

        JOptionPane.showConfirmDialog(this, "Bạn đã chắc chắn muốn xóa chưa ?");
        new connection().deleteMainboard(txtMaMain.getText());
        modelTBMainboard.setNumRows(0);
        listMainboard = new connection().getListMainboard();
        modelTBMainboard.setColumnIdentifiers(new Object[]{
            "MÃ MAINBOARD", "HẢNG", "CHIPSET", "KHE RAM", "LOẠI RAM", "SOCKET", "GIÁ"
        });
        showTBMainboard();
    }//GEN-LAST:event_btXoaMainActionPerformed

    private void btSuaMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaMainActionPerformed
        Mainboard m = new Mainboard();
        m.setMaMainboard(txtMaMain.getText());
        m.setHang(txtHangMain.getText());
        m.setChipset(txtChipset.getText());
        m.setKheRAM(Integer.parseInt(txtKheRAM.getText()));
        m.getLoaiRAM().setMaLoaiRAM(CBLoaiRAMMB.getSelectedIndex() + 1);
        m.getLoaiRAM().setLoaiRAM((String) (CBLoaiRAMMB.getSelectedItem()));
        m.getSocket().setMaSocket(CBSocketMain.getSelectedIndex() + 1);
        m.getSocket().setSocket((String) (CBSocketMain.getSelectedItem()));
        m.setGia(Integer.parseInt(txtGiaMain.getText()));
        new connection().updateMainboard(m);
        JOptionPane.showMessageDialog(rootPane, "Sửa thông tin Mainboard mới thành công!");
        modelTBMainboard.setNumRows(0);
        listMainboard = new connection().getListMainboard();
        modelTBMainboard.setColumnIdentifiers(new Object[]{
            "MÃ MAINBOARD", "HẢNG", "CHIPSET", "KHE RAM", "LOẠI RAM", "SOCKET", "GIÁ"
        });
        showTBMainboard();
    }//GEN-LAST:event_btSuaMainActionPerformed

    private void btThemMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemMainActionPerformed
        Mainboard m = new Mainboard();
        autoGenIDMainboard();
        m.setMaMainboard(txtMaMain.getText());
        m.setHang(txtHangMain.getText());
        m.setChipset(txtChipset.getText());
        m.setKheRAM(Integer.parseInt(txtKheRAM.getText()));
        m.getLoaiRAM().setMaLoaiRAM(CBLoaiRAMMB.getSelectedIndex() + 1);
        m.getLoaiRAM().setLoaiRAM((String) (CBLoaiRAMMB.getSelectedItem()));
        m.getSocket().setMaSocket(CBSocketMain.getSelectedIndex() + 1);
        m.getSocket().setSocket((String) (CBSocketMain.getSelectedItem()));
        m.setGia(Integer.parseInt(txtGiaMain.getText()));
        if (new connection().addMainboard(m)) {
            JOptionPane.showMessageDialog(rootPane, "Thêm thông tin Mainboard mới thành công!");
            listMainboard.add(m); // them vao danh sach CPU
            modelTBMainboard.setNumRows(0);
            listMainboard = new connection().getListMainboard();
            modelTBMainboard.setColumnIdentifiers(new Object[]{
                "MÃ MAINBOARD", "HẢNG", "CHIPSET", "KHE RAM", "LOẠI RAM", "SOCKET", "GIÁ"
            });
            showTBMainboard();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Trung khoa chinh");
        }
    }//GEN-LAST:event_btThemMainActionPerformed

    private void btXoaCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaCPUActionPerformed

        int output = JOptionPane.showConfirmDialog(null, "Bạn đã chắc chắn muốn xóa chưa ?");
        System.out.println(output);
        new connection().deleteCPU(txtMaCPU.getText());
        modelTBCPU.setNumRows(0);
        listCPU = new connection().getListCPU();
        modelTBCPU.setColumnIdentifiers(new Object[]{
            "MÃ CPU", "HẢNG", "DÒNG", "THẾ HỆ", "NHÂN", "LUỒNG", "XUNG NHỊP", "CACHE", "SOCKET", "GIÁ"
        });
        showTBCPU();
    }//GEN-LAST:event_btXoaCPUActionPerformed

    private void btSuaCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaCPUActionPerformed
        CPU cpu = new CPU();
        cpu.setMaCPU(txtMaCPU.getText());
        cpu.setHang(txtHangCPU.getText());
        cpu.setDong(txtDongCPU.getText());
        cpu.setThehe(Integer.parseInt(txtTheheCPU.getText()));
        cpu.setNhan(Integer.parseInt(txtNhanCPU.getText()));
        cpu.setLuong(Integer.parseInt(txtLuongCPU.getText()));
        cpu.setXungnhip(Float.parseFloat(txtXungCPU.getText()));
        cpu.setCache(Integer.parseInt(txtCacheCPU.getText()));
        cpu.getSocket().setMaSocket((CBSocketCPU.getSelectedIndex() + 1));
        cpu.getSocket().setSocket((String) (CBSocketCPU.getSelectedItem()));
        cpu.setGia(Integer.parseInt(txtGiaCPU.getText()));
        new connection().updateCPU(cpu);
        JOptionPane.showMessageDialog(rootPane, "Thêm thông tin CPU mới thành công!");
        modelTBCPU.setNumRows(0);
        listCPU = new connection().getListCPU();
        modelTBCPU.setColumnIdentifiers(new Object[]{
            "MÃ CPU", "HẢNG", "DÒNG", "THẾ HỆ", "NHÂN", "LUỒNG", "XUNG NHỊP", "CACHE", "SOCKET", "GIÁ"
        });
        showTBCPU();
    }//GEN-LAST:event_btSuaCPUActionPerformed

    private void btThemCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemCPUActionPerformed
        CPU cpu = new CPU();
        autoGenIDCPU();
        cpu.setMaCPU(txtMaCPU.getText());
        cpu.setHang(txtHangCPU.getText());
        cpu.setDong(txtDongCPU.getText());
        cpu.setThehe(Integer.parseInt(txtTheheCPU.getText()));
        cpu.setNhan(Integer.parseInt(txtNhanCPU.getText()));
        cpu.setLuong(Integer.parseInt(txtLuongCPU.getText()));
        cpu.setXungnhip(Float.parseFloat(txtXungCPU.getText()));
        cpu.setCache(Integer.parseInt(txtCacheCPU.getText()));
        cpu.getSocket().setMaSocket((CBSocketCPU.getSelectedIndex() + 1));
        cpu.getSocket().setSocket((String) (CBSocketCPU.getSelectedItem()));
        cpu.setGia(Integer.parseInt(txtGiaCPU.getText()));
        if (new connection().addCPU(cpu)) {
            JOptionPane.showMessageDialog(rootPane, "Thêm thông tin CPU mới thành công!");
            listCPU.add(cpu); // them vao danh sach CPU
            modelTBCPU.setNumRows(0);
            listCPU = new connection().getListCPU();
            modelTBCPU.setColumnIdentifiers(new Object[]{
                "MÃ CPU", "HẢNG", "DÒNG", "THẾ HỆ", "NHÂN", "LUỒNG", "XUNG NHỊP", "CACHE", "SOCKET", "GIÁ"
            });
            showTBCPU();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Student's ID cannot be duplicated!");
        }
    }//GEN-LAST:event_btThemCPUActionPerformed

    private void tbCPUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCPUMouseClicked

        selectedIndex = tbCPU.getSelectedRow();
        CPU cpu = listCPU.get(selectedIndex);
        txtMaCPU.setText(String.valueOf(cpu.getMaCPU()));
        txtHangCPU.setText(cpu.getHang());
        txtDongCPU.setText(cpu.getDong());
        txtTheheCPU.setText(String.valueOf(cpu.getThehe()));
        txtNhanCPU.setText(String.valueOf(cpu.getNhan()));
        txtLuongCPU.setText(String.valueOf(cpu.getLuong()));
        txtXungCPU.setText(String.valueOf(cpu.getXungnhip()));
        txtCacheCPU.setText(String.valueOf(cpu.getCache()));
        CBSocketCPU.setSelectedItem(cpu.getSocket());
        txtGiaCPU.setText(String.valueOf(cpu.getGia()));
    }//GEN-LAST:event_tbCPUMouseClicked

    private void btBackLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBackLoginActionPerformed
        this.setVisible(false);
        new GDLogin().setVisible(true);
    }//GEN-LAST:event_btBackLoginActionPerformed

    private void CBSocketCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBSocketCPUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBSocketCPUActionPerformed

    private void btRFOCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRFOCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btRFOCActionPerformed

    private void btRFMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRFMainActionPerformed
        txtHangMain.setText(null);
        txtChipset.setText(null);
        txtKheRAM.setText(null);
        CBLoaiRAMMB.setSelectedIndex(0);
        CBSocketMain.setSelectedIndex(0);
        txtGiaMain.setText(null);
    }//GEN-LAST:event_btRFMainActionPerformed

    private void btRFRAMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRFRAMActionPerformed
        txtHangRAM.setText(null);
        txtTenRAM.setText(null);
        txtDLRAM.setText(null);
        txtBusRAM.setText(null);
        txtGiaRAM.setText(null);
        cbLoaiRAM.setSelectedIndex(0);
    }//GEN-LAST:event_btRFRAMActionPerformed

    private void btRFCaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRFCaseActionPerformed
        txtHangCase.setText(null);
        txtTenCase.setText(null);
        txtMauSac.setText(null);
        txtChatLieu.setText(null);
        txtGiaCase.setText(null);
    }//GEN-LAST:event_btRFCaseActionPerformed

    private void btRFCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRFCPUActionPerformed
        txtHangCPU.setText(null);
        txtDongCPU.setText(null);
        txtTheheCPU.setText(null);
        txtNhanCPU.setText(null);
        txtLuongCPU.setText(null);
        txtXungCPU.setText(null);
        txtCacheCPU.setText(null);
        txtGiaCPU.setText(null);
        CBSocketCPU.setSelectedIndex(0);
    }//GEN-LAST:event_btRFCPUActionPerformed
// <editor-fold defaultstate="collapsed" desc="XU LI gen ID  ">

    public void autoGenIDCPU() {
        int count = 1;
        for (CPU cpu1 : listCPU) {
            int trim0_10 = Integer.parseInt(cpu1.getMaCPU().substring(3));
            if (trim0_10 > count && count <= 9) {
                txtMaCPU.setText("CPU0" + count);
                break;
            } else if (trim0_10 > count && count > 9) {
                txtMaCPU.setText("CPU" + count);
                break;
            } else if (count < 9) {
                count++;
                txtMaCPU.setText("CPU0" + count);
            } else {
                count++;
                txtMaCPU.setText("CPU" + count);
            }
        }
    }

    public void autoGenIDMainboard() {
        int count = 1;
        for (Mainboard m1 : listMainboard) {
            int trim0_10 = Integer.parseInt(m1.getMaMainboard().substring(4));
            if (trim0_10 > count && count <= 9) {
                txtMaMain.setText("Main0" + count);
                break;
            } else if (trim0_10 > count && count > 9) {
                txtMaMain.setText("Main" + count);
                break;
            } else if (count < 9) {
                count++;
                txtMaMain.setText("Main0" + count);
            } else {
                count++;
                txtMaMain.setText("Main" + count);
            }
        }
    }

    public void autoGenIDRAM() {
        int count = 1;
        for (RAM r : listRAM) {
            int trim0_10 = Integer.parseInt(r.getMaRAM().substring(3));
            if (trim0_10 > count && count <= 9) {
                txtMaRAM.setText("RAM0" + count);
                break;
            } else if (trim0_10 > count && count > 9) {
                txtMaRAM.setText("RAM" + count);
                break;
            } else if (count < 9) {
                count++;
                txtMaRAM.setText("RAM0" + (count));
            } else {
                count++;
                txtMaRAM.setText("RAM" + count);
            }
        }
    }

    public void autoGenIDOC() {
        int count = 1;
        for (OCung r : listOCung) {
            int trim0_10 = Integer.parseInt(r.getMaOCung().substring(2));
            if (trim0_10 > count && count <= 9) {
                txtMaOC.setText("OC0" + count);
                break;
            } else if (trim0_10 > count && count > 9) {
                txtMaOC.setText("OC" + count);
                break;
            } else if (count < 9) {
                count++;
                txtMaOC.setText("OC0" + count);

            } else {
                count++;
                txtMaOC.setText("OC" + count);
            }
        }
    }

    public void autoGenIDCase() {
        int count = 1;
        for (Case r : listCase) {
            int trim0_10 = Integer.parseInt(r.getMaCase().substring(4));
            if (trim0_10 > count && count <= 9) {
                txtMaCase.setText("Case0" + count);
                break;
            } else if (trim0_10 > count && count > 9) {
                txtMaCase.setText("Case" + count);
                break;
            } else if (count < 9) {
                count++;
                txtMaCase.setText("Case0" + count);

            } else {
                count++;
                txtMaCase.setText("Case" + count);
            }
        }
    }

    public void autoGenIDVGA() {
        int count = 1;
        for (VGA r : listVGA) {
            int trim0_10 = Integer.parseInt(r.getMaVGA().substring(3));
            if (trim0_10 > count && count <= 9) {
                txtMaVGA.setText("VGA0" + count);
                break;
            } else if (trim0_10 > count && count > 9) {
                txtMaVGA.setText("VGA" + count);
                break;
            } else if (count < 9) {
                count++;
                txtMaVGA.setText("VGA0" + count);
            } else {
                count++;
                txtMaVGA.setText("VGA" + count);
            }
        }
    }

    public void autoGenIDPSU() {
        int count = 1;
        for (PSU r : listPSU) {
            int trim0_10 = Integer.parseInt(r.getMaPSU().substring(3));
            if (trim0_10 > count && count <= 9) {
                txtMaPSU.setText("PSU0" + count);
                break;
            } else if (trim0_10 > count && count > 9) {
                txtMaPSU.setText("PSU" + count);
                break;
            } else if (count < 9) {
                count++;
                txtMaPSU.setText("PSU0" + count);
            } else {
                count++;
                txtMaPSU.setText("Case" + count);
            }
        }
    }
//</editor-fold>

// <editor-fold defaultstate="collapsed" desc="XU LI SHOW TABLE ">
    public void showTBCPU() {
        for (CPU c : listCPU) {
            modelTBCPU.addRow(new Object[]{
                c.getMaCPU(), c.getHang(), c.getDong(), c.getThehe(), c.getNhan(), c.getLuong(), c.getXungnhip(), c.getCache(), c.getSocket(), c.getGia()
            });
        }
    }

    public void showTBMainboard() {
        for (Mainboard m : listMainboard) {
            modelTBMainboard.addRow(new Object[]{
                m.getMaMainboard(), m.getHang(), m.getChipset(), m.getKheRAM(), m.getLoaiRAM(), m.getSocket(), m.getGia()
            });
        }
    }

    public void showTBRAM() {
        for (RAM r : listRAM) {
            modelTBRAM.addRow(new Object[]{
                r.getMaRAM(), r.getHang(), r.getTenRAM(), r.getDungLuong(), r.getBus(), r.getLoaiRAM(), r.getGia()
            });
        }
    }

    public void showTBOCung() {
        for (OCung o : listOCung) {
            modelTBOCung.addRow(new Object[]{
                o.getMaOCung(), o.getHang(), o.getTenOCung(), o.getLoaiOCung(), o.getDungLuong(), o.getGhi(), o.getDoc(), o.getGia()
            });
        }
    }

    public void showTBSocket() {
        for (Socket s : listSocket) {
            modelTBSocket.addRow(new Object[]{
                s.getMaSocket(), s.getSocket()
            });
        }
    }

    public void showTBCase() {
        for (Case c : listCase) {
            modelTBCase.addRow(new Object[]{
                c.getMaCase(), c.getHang(), c.getTenCase(), c.getMauSac(), c.getChatLieu(), c.getGia(), c.getLinks()
            });
        }
    }

    public void showTBVGA() {
        for (VGA c : listVGA) {
            modelTBVGA.addRow(new Object[]{
                c.getMaVGA(), c.getHang(), c.getTenVGA(), c.getDong(), c.getNhan(), c.getXungnhip(), c.getGia()
            });
        }
    }

    public void showTBPSU() {
        for (PSU c : listPSU) {
            modelTBPSU.addRow(new Object[]{
                c.getMaPSU(), c.getHang(), c.getCongsuat(), c.getChuan(), c.getGia()
            });
        }
    }
//</editor-fold>

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GDMainAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GDMainAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GDMainAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GDMainAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GDMainAdmin().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBLoaiRAMMB;
    private javax.swing.JComboBox<String> CBSocketCPU;
    private javax.swing.JComboBox<String> CBSocketMain;
    private javax.swing.JComboBox<String> CBloaiOCung;
    private javax.swing.JButton btBackLogin;
    private javax.swing.JButton btRFCPU;
    private javax.swing.JButton btRFCase;
    private javax.swing.JButton btRFMain;
    private javax.swing.JButton btRFOC;
    private javax.swing.JButton btRFPSU;
    private javax.swing.JButton btRFRAM;
    private javax.swing.JButton btRFSocket;
    private javax.swing.JButton btRFVGA;
    private javax.swing.JButton btSuaCPU;
    private javax.swing.JButton btSuaCase;
    private javax.swing.JButton btSuaMain;
    private javax.swing.JButton btSuaOC;
    private javax.swing.JButton btSuaPSU;
    private javax.swing.JButton btSuaRAM;
    private javax.swing.JButton btSuaSocket;
    private javax.swing.JButton btSuaVGA;
    private javax.swing.JButton btThemCPU;
    private javax.swing.JButton btThemCase;
    private javax.swing.JButton btThemMain;
    private javax.swing.JButton btThemOC;
    private javax.swing.JButton btThemPSU;
    private javax.swing.JButton btThemRAM;
    private javax.swing.JButton btThemSocket;
    private javax.swing.JButton btThemVGA;
    private javax.swing.JButton btXoaCPU;
    private javax.swing.JButton btXoaCase;
    private javax.swing.JButton btXoaMain;
    private javax.swing.JButton btXoaOC;
    private javax.swing.JButton btXoaPSU;
    private javax.swing.JButton btXoaRAM;
    private javax.swing.JButton btXoaSocket;
    private javax.swing.JButton btXoaVGA;
    private javax.swing.JComboBox<String> cbLoaiRAM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelCPU;
    private javax.swing.JPanel jPanelCase;
    private javax.swing.JPanel jPanelMB;
    private javax.swing.JPanel jPanelMainb;
    private javax.swing.JPanel jPanelNhapCPU;
    private javax.swing.JPanel jPanelOCung;
    private javax.swing.JPanel jPanelPSU;
    private javax.swing.JPanel jPanelRAM;
    private javax.swing.JPanel jPanelSocket;
    private javax.swing.JPanel jPanelTBCPU;
    private javax.swing.JPanel jPanelVGA;
    private javax.swing.JPanel jPanelbuttonMB;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbCPU;
    private javax.swing.JTable tbCase;
    private javax.swing.JTable tbMainboard;
    private javax.swing.JTable tbOCung;
    private javax.swing.JTable tbPSU;
    private javax.swing.JTable tbRAM;
    private javax.swing.JTable tbSocket;
    private javax.swing.JTable tbVGA;
    private javax.swing.JTextField txtBusRAM;
    private javax.swing.JTextField txtCacheCPU;
    private javax.swing.JTextField txtChatLieu;
    private java.awt.TextField txtChipset;
    private javax.swing.JTextField txtChuanPSU;
    private javax.swing.JTextField txtCongSuatPSU;
    private java.awt.TextField txtDLOC;
    private javax.swing.JTextField txtDLRAM;
    private java.awt.TextField txtDocOC;
    private javax.swing.JTextField txtDongCPU;
    private javax.swing.JTextField txtDongVGA;
    private java.awt.TextField txtGhiOC;
    private javax.swing.JTextField txtGiaCPU;
    private javax.swing.JTextField txtGiaCase;
    private java.awt.TextField txtGiaMain;
    private java.awt.TextField txtGiaOC;
    private javax.swing.JTextField txtGiaPSU;
    private javax.swing.JTextField txtGiaRAM;
    private javax.swing.JTextField txtGiaVGA;
    private javax.swing.JTextField txtHangCPU;
    private javax.swing.JTextField txtHangCase;
    private java.awt.TextField txtHangMain;
    private java.awt.TextField txtHangOC;
    private javax.swing.JTextField txtHangPSU;
    private javax.swing.JTextField txtHangRAM;
    private javax.swing.JTextField txtHangVGA;
    private java.awt.TextField txtKheRAM;
    private javax.swing.JTextField txtLuongCPU;
    private javax.swing.JTextField txtMaCPU;
    private javax.swing.JTextField txtMaCase;
    private javax.swing.JTextField txtMaMain;
    private javax.swing.JTextField txtMaOC;
    private javax.swing.JTextField txtMaPSU;
    private javax.swing.JTextField txtMaRAM;
    private javax.swing.JTextField txtMaSocket;
    private javax.swing.JTextField txtMaVGA;
    private javax.swing.JTextField txtMauSac;
    private javax.swing.JTextField txtNhanCPU;
    private javax.swing.JTextField txtNhanVGA;
    private javax.swing.JTextField txtTenCase;
    private javax.swing.JTextField txtTenOC;
    private javax.swing.JTextField txtTenRAM;
    private javax.swing.JTextField txtTenSocket;
    private javax.swing.JTextField txtTenVGA;
    private javax.swing.JTextField txtTheheCPU;
    private javax.swing.JTextField txtXungCPU;
    private javax.swing.JTextField txtXungVGA;
    // End of variables declaration//GEN-END:variables
}
