package GD;

import ClassLK.CPU;
import ClassLK.Case;
import ClassLK.Socket;
import ClassLK.loaiRAM;
import ClassLK.Mainboard;
import ClassLK.LoaiOCung;
import ClassLK.OCung;
import ClassLK.PSU;
import ClassLK.RAM;
import ClassLK.Result;
import ClassLK.VGA;
import ClassLK.connection.connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ClassLK.bangKetQua;
import GDAdmin.GDLogin;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import sun.applet.Main;

/**
 *
 * @author Admin
 */
public class GDUser extends javax.swing.JFrame {

    DefaultTableModel modelTBCPU1;
    DefaultTableModel modelTBMainboard1;
    DefaultTableModel modelTBRAM1;
    DefaultTableModel modelTBOCung1;
    DefaultTableModel modelTBSocket1;
    DefaultTableModel modelTBCase1;
    DefaultTableModel modelTBVGA1;
    DefaultTableModel modelTBPSU1;
    DefaultTableModel modelTBKQNull;

    ArrayList<CPU> listCPU1;
    ArrayList<Mainboard> listMainboard1;
    ArrayList<RAM> listRAM1;
    ArrayList<OCung> listOCung1;
    ArrayList<Socket> listSocket1;
    ArrayList<loaiRAM> listLoaiRAM1;
    ArrayList<LoaiOCung> listloaiOCung1;
    ArrayList<Case> listCase1;
    ArrayList<VGA> listVGA1;
    ArrayList<PSU> listPSU1;
    ArrayList<bangKetQua> listBKQ;
    ArrayList<Result> listResult;

    bangKetQua b1 = new bangKetQua();
    int type = 1;
    String outTxt = new String(); // Chuỗi lưu để xuất file txt gợi ý => Button Download

    public GDUser() {
        initComponents();
        modelTBCPU1 = (DefaultTableModel) tbKetQua.getModel();
        modelTBMainboard1 = (DefaultTableModel) tbKetQua.getModel();
        modelTBRAM1 = (DefaultTableModel) tbKetQua.getModel();
        modelTBOCung1 = (DefaultTableModel) tbKetQua.getModel();
        modelTBSocket1 = (DefaultTableModel) tbKetQua.getModel();
        modelTBCase1 = (DefaultTableModel) tbKetQua.getModel();
        modelTBVGA1 = (DefaultTableModel) tbKetQua.getModel();
        modelTBPSU1 = (DefaultTableModel) tbKetQua.getModel();
        modelTBKQNull = (DefaultTableModel) tbKetQua.getModel();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
        txtTien.setText("3000000");
        ImageIcon img = new ImageIcon("D:\\HOCTAP\\LapTrinhJAVA\\NienLuan\\src\\image\\logo.png");
        this.setIconImage(img.getImage());
    }
// <editor-fold defaultstate="collapsed" desc="XU LI SHOW TABLE ">

    public void showTBCPU() {
        for (CPU c : listCPU1) {
            modelTBCPU1.addRow(new Object[]{
                c.getHang(), c.getDong(), c.getThehe(), c.getNhan(), c.getLuong(), c.getXungnhip(), c.getCache(), c.getSocket(), c.getGia()
            });
        }
    }

    public void showTBMainboard() {
        for (Mainboard m : listMainboard1) {
            modelTBMainboard1.addRow(new Object[]{
                m.getHang(), m.getChipset(), m.getKheRAM(), m.getLoaiRAM(), m.getSocket(), m.getGia()
            });
        }
    }

    public void showTBRAM() {
        for (RAM r : listRAM1) {
            modelTBRAM1.addRow(new Object[]{
                r.getHang(), r.getTenRAM(), r.getDungLuong(), r.getBus(), r.getLoaiRAM(), r.getGia()
            });
        }
    }

    public void showTBOCung() {
        for (OCung o : listOCung1) {
            modelTBOCung1.addRow(new Object[]{
                o.getHang(), o.getTenOCung(), o.getLoaiOCung(), o.getDungLuong(), o.getGhi(), o.getDoc(), o.getGia()
            });
        }
    }

    public void showTBCase() {
        for (Case c : listCase1) {
            modelTBCase1.addRow(new Object[]{
                c.getHang(), c.getTenCase(), c.getMauSac(), c.getChatLieu(), c.getGia()
            });
        }
    }

    public void showTBVGA() {
        for (VGA c : listVGA1) {
            modelTBVGA1.addRow(new Object[]{
                c.getHang(), c.getTenVGA(), c.getDong(), c.getNhan(), c.getXungnhip(), c.getGia()
            });
        }
    }

    public void showTBPSU() {
        for (PSU c : listPSU1) {
            modelTBPSU1.addRow(new Object[]{
                c.getHang(), c.getCongsuat(), c.getChuan(), c.getGia()
            });
        }
    }
//</editor-fold>

// <editor-fold defaultstate="collapsed" desc="XU LI HEAP SORT">
    void heapify(ArrayList<CPU> list, int n, int i) {
        int max = i;    // Lưu vị trí đỉnh max ban đầu
        int l = i * 2 + 1;   // Vị trí con trái
        int r = l + 1;    // Vị trí con phải
        if (l < n && list.get(l).getGia() > list.get(max).getGia()) {   // Nếu tồn tại con trái lớn hơn cha, gán max = L
            max = l;
        }

        if (r < n && list.get(r).getGia() > list.get(max).getGia()) {   // Nếu tồn tại con phải lớn hơn arr[max], gán max = r
            max = r;
        }
        if (max != i) {      // Nếu max != i, tức là cha không phải lớn nhất
            CPU temp = new CPU(list.get(i));
            list.set(i, list.get(max));
            list.set(max, temp);   // Đổi chỗ cho phần tử lớn nhất làm cha swap(arr[i], arr[max]); 
            heapify(list, n, max);    // Đệ quy vun các node phía dưới
        }

    }

    void heapSort(ArrayList<CPU> list, int n) {

        // vun dong tu duoi len len de thanh heap
        for (int i = n / 2 - 1; i >= 0; i--) // i chạy từ n/2 - 1 về 0 sẽ có n/2 đỉnh
        {
            heapify(list, n, i);   // Vun từng đỉnh
        }
        // Vòng lặp để thực hiện vun đống và lấy phần tử
        for (int j = n - 1; j > 0; j--) {   // chạy hết j == 1 sẽ dừng
            // mỗi lần j - 1, tương đương với k xét phần tử cuối 
//        swap(arr[0], arr[j] );  // đổi chỗ phần tử lớn nhất
            CPU temp = new CPU(list.get(0));
            list.set(0, list.get(j));
            list.set(j, temp);
            heapify(list, j, 0);    // vun lại đống, 
        }
    }
    //</editor-fold>

// <editor-fold defaultstate="collapsed" desc="XU LI BUBBLESORT ">
    public void bubbleSort1(ArrayList<CPU> list) {
        int i, j;
        for (i = 0; i <= list.size() - 2; i++) {
            for (j = list.size() - 1; j >= i + 1; j--) {
                if (list.get(j).getGia() > list.get(j - 1).getGia()) {
                    CPU temp = new CPU(list.get(j));
                    list.set(j, list.get(j - 1));
                    list.set(j - 1, temp);
                }
            }
        }
    }

    public void bubbleSort2(ArrayList<Mainboard> list) {
        int i, j;
        for (i = 0; i <= list.size() - 2; i++) {
            for (j = list.size() - 1; j >= i + 1; j--) {
                if (list.get(j).getGia() > list.get(j - 1).getGia()) {
                    Mainboard temp = new Mainboard(list.get(j));
                    list.set(j, list.get(j - 1));
                    list.set(j - 1, temp);
                }
            }
        }
    }

    public void bubbleSort3(ArrayList<RAM> list) {
        int i, j;
        for (i = 0; i <= list.size() - 2; i++) {
            for (j = list.size() - 1; j >= i + 1; j--) {
                if (list.get(j).getGia() > list.get(j - 1).getGia()) {
                    RAM temp = new RAM(list.get(j));
                    list.set(j, list.get(j - 1));
                    list.set(j - 1, temp);
                }
            }
        }
    }

    public void bubbleSort4(ArrayList<OCung> list) {
        int i, j;
        for (i = 0; i <= list.size() - 2; i++) {
            for (j = list.size() - 1; j >= i + 1; j--) {
                if (list.get(j).getGia() > list.get(j - 1).getGia()) {
                    OCung temp = new OCung(list.get(j));
                    list.set(j, list.get(j - 1));
                    list.set(j - 1, temp);
                }
            }
        }
    }

    public void bubbleSort5(ArrayList<Case> list) {
        int i, j;
        for (i = 0; i <= list.size() - 2; i++) {
            for (j = list.size() - 1; j >= i + 1; j--) {
                if (list.get(j).getGia() > list.get(j - 1).getGia()) {
                    Case temp = new Case(list.get(j));
                    list.set(j, list.get(j - 1));
                    list.set(j - 1, temp);
                }
            }
        }
    }

    public void bubbleSort6(ArrayList<VGA> list) {
        int i, j;
        for (i = 0; i <= list.size() - 2; i++) {
            for (j = list.size() - 1; j >= i + 1; j--) {
                if (list.get(j).getGia() > list.get(j - 1).getGia()) {
                    VGA temp = new VGA(list.get(j));
                    list.set(j, list.get(j - 1));
                    list.set(j - 1, temp);
                }
            }
        }
    }

    public void bubbleSort7(ArrayList<PSU> list) {
        int i, j;
        for (i = 0; i <= list.size() - 2; i++) {
            for (j = list.size() - 1; j >= i + 1; j--) {
                if (list.get(j).getGia() > list.get(j - 1).getGia()) {
                    PSU temp = new PSU(list.get(j));
                    list.set(j, list.get(j - 1));
                    list.set(j - 1, temp);
                }
            }
        }
    }
//</editor-fold>

// <editor-fold defaultstate="collapsed" desc="XU LI KET QUA GOI Y">
    public bangKetQua CPUKQ1(int Tien) {
        bangKetQua b = new bangKetQua();
        ArrayList<CPU> list = new connection().getListCPU();
        int i, j, max = 0;
        int size = list.size();
        heapSort(list, size);
        for (i = list.size() - 1; i >= 0; i--) {
            if (max < list.get(i).getGia() && list.get(i).getGia() <= Tien) {
                max = list.get(i).getGia();
            }
        }

        for (CPU m : list) {
            {
                if (max >= m.getGia()) {
                    b.setCpu(m);
                }
            }
        }
        return b; // BANG KET QUA
    }

    public bangKetQua CPUKQ(int Tien) {
        bangKetQua b = new bangKetQua();
        ArrayList<CPU> list = new connection().getListCPU();
        int i, j, max = 0;
        bubbleSort1(list);
        for (i = 0; i < list.size(); i++) {
            if (max < list.get(i).getGia() && list.get(i).getGia() <= Tien) {
                max = list.get(i).getGia();
            }
        }
        for (CPU m : list) {
            {
                if (max <= m.getGia()) {
                    b.setCpu(m);
                }
            }
        }
        return b; // BANG KET QUA
    }

    public bangKetQua MainboardKQ(int Tien) {
        bangKetQua b = new bangKetQua();
        ArrayList<Mainboard> list = new connection().getListMainboard();
        int i, j, max = 0;
        bubbleSort2(list);
        for (i = 0; i < list.size(); i++) {
            if (max < list.get(i).getGia() && list.get(i).getGia() <= Tien) {
                max = list.get(i).getGia();
            }
        }
        for (Mainboard m : list) {
            {
                if (max <= m.getGia()) {
                    b.setM(m);
                }
            }
        }
        return b; // BANG KET QUA
    }

    public bangKetQua RAMKQ(int Tien) {
        bangKetQua b = new bangKetQua();
        ArrayList<RAM> list = new connection().getListRAM();
        int i, j, max = 0;
        bubbleSort3(list);
        for (i = 0; i < list.size(); i++) {
            if (max < list.get(i).getGia() && list.get(i).getGia() <= Tien) {
                max = list.get(i).getGia();
            }
        }
        for (RAM m : list) {
            {
                if (max <= m.getGia()) {
                    b.setRam(m);
                }
            }
        }
        return b; // BANG KET QUA
    }

    public bangKetQua OCungKQ(int Tien) {
        bangKetQua b = new bangKetQua();
        ArrayList<OCung> list = new connection().getListOCung();
        int i, j, max = 0;
        bubbleSort4(list);
        for (i = 0; i < list.size(); i++) {
            if (max < list.get(i).getGia() && list.get(i).getGia() <= Tien) {
                max = list.get(i).getGia();
            }
        }
        for (OCung m : list) {
            {
                if (max <= m.getGia()) {
                    b.setO(m);
                }
            }
        }
        return b; // BANG KET QUA
    }

    public bangKetQua CaseKQ(int Tien) {
        bangKetQua b = new bangKetQua();
        ArrayList<Case> list = new connection().getListCase();
        int i, j, max = 0;
        bubbleSort5(list);
        for (i = 0; i < list.size(); i++) {
            if (max < list.get(i).getGia() && list.get(i).getGia() <= Tien) {
                max = list.get(i).getGia();
            }
        }
        for (Case m : list) {
            {
                if (max <= m.getGia()) {
                    b.setC(m);
                }
            }
        }
        return b; // BANG KET QUA
    }

    public bangKetQua VGAKQ(int Tien) {
        bangKetQua b = new bangKetQua();
        ArrayList<VGA> list = new connection().getListVGA();
        int i, j, max = 0;
        bubbleSort6(list);
        for (i = 0; i < list.size(); i++) {
            if (max < list.get(i).getGia() && list.get(i).getGia() <= Tien) {
                max = list.get(i).getGia();
            }
        }
        for (VGA m : list) {
            {
                if (max <= m.getGia()) {
                    b.setV(m);
                }
            }
        }
        return b; // BANG KET QUA
    }

    public bangKetQua PSUKQ(int Tien) {
        bangKetQua b = new bangKetQua();
        ArrayList<PSU> list = new connection().getListPSU();
        int i, j, max = 0;
        bubbleSort7(list);
        for (i = 0; i < list.size(); i++) {
            if (max < list.get(i).getGia() && list.get(i).getGia() <= Tien) {
                max = list.get(i).getGia();
            }
        }
        for (PSU m : list) {
            {
                if (max <= m.getGia()) {
                    b.setP(m);
                }
            }
        }
        return b; // BANG KET QUA
    }
    //</editor-fold>


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupLK = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btSearchRCM = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        cpucoolerBT = new javax.swing.JButton();
        psuBT = new javax.swing.JButton();
        hddBT = new javax.swing.JButton();
        ramBT = new javax.swing.JButton();
        vgaBT = new javax.swing.JButton();
        cpuBT = new javax.swing.JButton();
        mainboardBT = new javax.swing.JButton();
        checkboxPSU = new javax.swing.JRadioButton();
        checkboxCPU = new javax.swing.JRadioButton();
        checkboxMB = new javax.swing.JRadioButton();
        checkboxOCung = new javax.swing.JRadioButton();
        checkboxRAM = new javax.swing.JRadioButton();
        checkboxVGA = new javax.swing.JRadioButton();
        checkboxCase = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        txtTien = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbKetQua = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btSearchmore = new javax.swing.JButton();
        btExport = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btDetail = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btBuynow = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btBackLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GỢI Ý CHỌN LINH KIỆN VỚI SỐ TIỀN HIỆN CÓ");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTabbedPane1.setBackground(new java.awt.Color(0, 204, 204));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(147, 208, 230));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        btSearchRCM.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btSearchRCM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/right icon.png"))); // NOI18N
        btSearchRCM.setText("TÌM GỢI Ý");
        btSearchRCM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSearchRCMActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        cpucoolerBT.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        cpucoolerBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/CASE.png"))); // NOI18N
        cpucoolerBT.setText("CASE");
        cpucoolerBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpucoolerBTActionPerformed(evt);
            }
        });

        psuBT.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        psuBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/PSU.png"))); // NOI18N
        psuBT.setText("NGUỒN MÁY TÍNH");
        psuBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                psuBTActionPerformed(evt);
            }
        });

        hddBT.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        hddBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/DRIVER.png"))); // NOI18N
        hddBT.setText("Ổ CỨNG");
        hddBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hddBTActionPerformed(evt);
            }
        });

        ramBT.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        ramBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/RAM.png"))); // NOI18N
        ramBT.setText("RAM");
        ramBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ramBTActionPerformed(evt);
            }
        });

        vgaBT.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        vgaBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/VGA.png"))); // NOI18N
        vgaBT.setText("VGA");
        vgaBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vgaBTActionPerformed(evt);
            }
        });

        cpuBT.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cpuBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/CPU.png"))); // NOI18N
        cpuBT.setText("CPU");
        cpuBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpuBTActionPerformed(evt);
            }
        });

        mainboardBT.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        mainboardBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/mainboard.png"))); // NOI18N
        mainboardBT.setText("MAINBOARD");
        mainboardBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainboardBTActionPerformed(evt);
            }
        });

        groupLK.add(checkboxPSU);

        groupLK.add(checkboxCPU);
        checkboxCPU.setSelected(true);

        groupLK.add(checkboxMB);

        groupLK.add(checkboxOCung);

        groupLK.add(checkboxRAM);

        groupLK.add(checkboxVGA);

        groupLK.add(checkboxCase);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cpuBT, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hddBT))
                .addGap(39, 39, 39))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(checkboxMB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(checkboxCPU)
                .addGap(119, 119, 119))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(checkboxRAM)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(checkboxOCung)
                .addGap(118, 118, 118))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(checkboxCase)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(checkboxVGA)
                .addGap(118, 118, 118))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ramBT, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cpucoolerBT, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(vgaBT, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(psuBT)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(checkboxPSU)))
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(mainboardBT)
                    .addContainerGap(236, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cpuBT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(checkboxCPU)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ramBT)
                                    .addComponent(hddBT))
                                .addGap(12, 12, 12)
                                .addComponent(checkboxOCung))
                            .addComponent(checkboxRAM, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(vgaBT)
                            .addComponent(cpucoolerBT))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkboxVGA)
                            .addComponent(checkboxCase))
                        .addGap(12, 12, 12)
                        .addComponent(psuBT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(checkboxPSU))
                    .addComponent(checkboxMB))
                .addGap(31, 31, 31))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(mainboardBT)
                    .addContainerGap(358, Short.MAX_VALUE)))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("SỐ TIỀN");

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        tbKetQua.setBackground(new java.awt.Color(204, 255, 255));
        tbKetQua.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 0, true));
        tbKetQua.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        tbKetQua.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbKetQua);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("VND");

        btSearchmore.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btSearchmore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Refresh_icon.png"))); // NOI18N
        btSearchmore.setText("TÌM LINH KIÊN KHÁC");
        btSearchmore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSearchmoreActionPerformed(evt);
            }
        });

        btExport.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/DOWNLOAD.png"))); // NOI18N
        btExport.setText("XUẤT GỢI Ý");
        btExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExportActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("BẢNG GỢI Ý");

        btDetail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btDetail.setText("Xem chi tiết");
        btDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDetailActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setText("BẢNG LINH KIỆN");

        btBuynow.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btBuynow.setText("MUA NGAY");
        btBuynow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btBuynowMouseClicked(evt);
            }
        });
        btBuynow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuynowActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel5.setText("BẠN CÓ THỂ THAM KHẢO TẠI =>");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/recommend.png"))); // NOI18N
        jLabel6.setText("GỢI Ý LINH KIỆN MÁY TÍNH");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(jLabel4)
                .addGap(412, 412, 412)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(42, 42, 42)
                        .addComponent(txtTien, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(351, 351, 351)
                        .addComponent(jLabel3))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 924, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(254, 254, 254)
                                .addComponent(jLabel5)
                                .addGap(38, 38, 38)
                                .addComponent(btBuynow))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btSearchmore)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btSearchRCM)
                                .addGap(41, 41, 41)
                                .addComponent(btExport)))
                        .addGap(28, 28, 28)
                        .addComponent(btDetail)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(69, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(15, 15, 15)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btDetail)
                            .addComponent(btBuynow)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btSearchmore)
                            .addComponent(btSearchRCM)
                            .addComponent(btExport))
                        .addGap(58, 58, 58))))
        );

        jTabbedPane1.addTab("GỢI Ý LINH KIỆN", jPanel1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        btBackLogin.setBackground(new java.awt.Color(255, 255, 255));
        btBackLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Back-icon.png"))); // NOI18N
        btBackLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBackLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btBackLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btBackLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

    }//GEN-LAST:event_formWindowClosing

    private void btBuynowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuynowActionPerformed
        String url = new String();
        if (checkboxCase.isSelected()) {
            url = listCase1.get(0).getLinks();
        } else if (checkboxCPU.isSelected()) {
            url = listCPU1.get(0).getLinks();

        }
        urlOpener(url);
    }//GEN-LAST:event_btBuynowActionPerformed

    private void btBuynowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btBuynowMouseClicked

    }//GEN-LAST:event_btBuynowMouseClicked

    private void btDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDetailActionPerformed
        GDChitietr d = new GDChitietr();
        d.setVisible(true);
        d.layChiTiet(type, b1);
    }//GEN-LAST:event_btDetailActionPerformed

    private void btExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExportActionPerformed
        //        if (checkboxCPU.isSelected()) {
        //            try {
        //                FileWriter fw = new FileWriter("D:\\KetQuaGoiY\\CPU.txt");
        //                fw.write(listCPU1.get(0).toString());
        //                fw.close();
        //            } catch (Exception e) {
        //                System.out.println(e);
        //            }
        //            JOptionPane.showMessageDialog(rootPane, "Đã tải file gợi ý CPU xuống" + "\n" + "Tại D:\\KetQuaGoiY\\CPU.txt");
        //        } else if (checkboxMB.isSelected()) {
        //            try {
        //                FileWriter fw = new FileWriter("D:\\KetQuaGoiY\\Mainboard.txt");
        //                fw.write(listMainboard1.get(0).toString());
        //                fw.close();
        //            } catch (Exception e) {
        //                System.out.println(e);
        //            }
        //            JOptionPane.showMessageDialog(rootPane, "Đã tải file gợi ý Mainboard xuống" + "\n" + "Tại D:\\KetQuaGoiY\\Mainboard.txt");
        //        } else if (checkboxRAM.isSelected()) {
        //            try {
        //                FileWriter fw = new FileWriter("D:\\KetQuaGoiY\\RAM.txt");
        //                fw.write(listRAM1.get(0).toString());
        //                fw.close();
        //            } catch (Exception e) {
        //                System.out.println(e);
        //            }
        //            JOptionPane.showMessageDialog(rootPane, "Đã tải file gợi ý RAM xuống" + "\n" + "Tại D:\\KetQuaGoiY\\RAM.txt");
        //        } else if (checkboxOCung.isSelected()) {
        //            try {
        //                FileWriter fw = new FileWriter("D:\\KetQuaGoiY\\OCung.txt");
        //                fw.write(listOCung1.get(0).toString());
        //                fw.close();
        //            } catch (Exception e) {
        //                System.out.println(e);
        //            }
        //            JOptionPane.showMessageDialog(rootPane, "Đã tải file gợi ý Ổ Cứng xuống" + "\n" + "Tại D:\\KetQuaGoiY\\OCung.txt");
        //        } else if (checkboxCase.isSelected()) {
        //            try {
        //                FileWriter fw = new FileWriter("D:\\KetQuaGoiY\\Case.txt");
        //                fw.write(listCase1.get(0).toString());
        //                fw.close();
        //            } catch (Exception e) {
        //                System.out.println(e);
        //            }
        //            JOptionPane.showMessageDialog(rootPane, "Đã tải file gợi ý Case xuống" + "\n" + "Tại D:\\KetQuaGoiY\\Case.txt");
        //        } else if (checkboxVGA.isSelected()) {
        //            try {
        //                FileWriter fw = new FileWriter("D:\\KetQuaGoiY\\VGA.txt");
        //                fw.write(listVGA1.get(0).toString());
        //                fw.close();
        //            } catch (Exception e) {
        //                System.out.println(e);
        //            }
        //            JOptionPane.showMessageDialog(rootPane, "Đã tải file gợi ý VGA xuống" + "\n" + "Tại D:\\KetQuaGoiY\\VGA.txt");
        //        } else if (checkboxPSU.isSelected()) {
        //            try {
        //                FileWriter fw = new FileWriter("D:\\KetQuaGoiY\\PSU.txt");
        //                fw.write(listPSU1.get(0).toString());
        //                fw.close();
        //            } catch (Exception e) {
        //                System.out.println(e);
        //            }
        //            JOptionPane.showMessageDialog(rootPane, "Đã tải file gợi ý PSU xuống" + "\n" + "Tại D:\\KetQuaGoiY\\PSU.txt");
        //        }
        if (outTxt.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Chưa có gợi ý nào !\n" + "Vui lòng tìm gợi ý!");
        } else {
            try {
                FileWriter fw = new FileWriter("D:\\KetQuaGoiY\\GoiY.txt");
                fw.write(outTxt);
                fw.close();
            } catch (Exception e) {
                System.out.println(e);
            }
            JOptionPane.showMessageDialog(rootPane, "Đã tải file gợi ý xuống" + "\n" + "Tại D:\\KetQuaGoiY\\GoiY.txt");
        }
    }//GEN-LAST:event_btExportActionPerformed

    private void btSearchmoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchmoreActionPerformed
        checkboxCPU.isSelected();
        modelTBCPU1.setNumRows(0);
        modelTBMainboard1.setNumRows(0);
        modelTBRAM1.setNumRows(0);
        modelTBOCung1.setNumRows(0);
        modelTBCase1.setNumRows(0);
        modelTBPSU1.setNumRows(0);
        modelTBVGA1.setNumRows(0);
        modelTBKQNull.setColumnIdentifiers(new Object[]{});
        if (checkboxCPU.isSelected()) {
            for (int i = 0; i < listCPU1.size(); i++) {
                listCPU1.remove(i);
            }
        } else if (checkboxMB.isSelected()) {
            for (int i = 0; i < listMainboard1.size(); i++) {
                listMainboard1.remove(i);
            }
        } else if (checkboxRAM.isSelected()) {
            for (int i = 0; i < listRAM1.size(); i++) {
                listRAM1.remove(i);
            }
        } else if (checkboxOCung.isSelected()) {
            for (int i = 0; i < listOCung1.size(); i++) {
                listOCung1.remove(i);
            }
        } else if (checkboxCase.isSelected()) {
            for (int i = 0; i < listCase1.size(); i++) {
                listCase1.remove(i);
            }
        } else if (checkboxVGA.isSelected()) {
            for (int i = 0; i < listVGA1.size(); i++) {
                listVGA1.remove(i);
            }
        } else if (checkboxPSU.isSelected()) {
            for (int i = 0; i < listPSU1.size(); i++) {
                listPSU1.remove(i);
            }
        }
    }//GEN-LAST:event_btSearchmoreActionPerformed

    private void mainboardBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainboardBTActionPerformed
        mainboardBT.setEnabled(false);
    }//GEN-LAST:event_mainboardBTActionPerformed

    private void cpuBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpuBTActionPerformed
        cpuBT.setEnabled(false);
    }//GEN-LAST:event_cpuBTActionPerformed

    private void vgaBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vgaBTActionPerformed
        vgaBT.setEnabled(false);
    }//GEN-LAST:event_vgaBTActionPerformed

    private void ramBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ramBTActionPerformed
        ramBT.setEnabled(false);
    }//GEN-LAST:event_ramBTActionPerformed

    private void hddBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hddBTActionPerformed
        hddBT.setEnabled(false);
    }//GEN-LAST:event_hddBTActionPerformed

    private void psuBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_psuBTActionPerformed
        psuBT.setEnabled(false);
    }//GEN-LAST:event_psuBTActionPerformed

    private void cpucoolerBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpucoolerBTActionPerformed
        cpucoolerBT.setEnabled(false);
    }//GEN-LAST:event_cpucoolerBTActionPerformed

    private void btSearchRCMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchRCMActionPerformed
        //        bangKetQua b1 = new bangKetQua();
        int input;
        boolean validinput = false;
        if (txtTien.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập số tiền vào!");
        } else if (checkboxCPU.isSelected()) {
            modelTBCPU1.setColumnIdentifiers(new Object[]{
                "HẢNG", "DÒNG", "THẾ HỆ", "NHÂN", "LUỒNG", "XUNG NHỊP", "CACHE", "SOCKET", "GIÁ"
            });
            input = Integer.parseInt(txtTien.getText());
            b1 = CPUKQ1(Integer.valueOf(txtTien.getText()));
            String temp;
            temp = b1.getCpu().getMaCPU();
            listCPU1 = new connection().getListCPU_User(temp);
            showTBCPU();
            type = 1;
            outTxt += listCPU1.get(0).toString() + "\n";
        } else if (checkboxMB.isSelected()) {
            modelTBCPU1.setColumnIdentifiers(new Object[]{
                "HẢNG", "CHIPSET", "KHE RAM", "LOẠI RAM", "SOCKET", "GIÁ"
            });
            input = Integer.parseInt(txtTien.getText());
            b1 = MainboardKQ(input);
            String temp;
            temp = b1.getM().getMaMainboard();
            listMainboard1 = new connection().getListMainboard_User(temp);
            showTBMainboard();
            type = 2;
            outTxt += listMainboard1.get(0).toString() + "\n";
        } else if (checkboxRAM.isSelected()) {
            modelTBRAM1.setColumnIdentifiers(new Object[]{
                "HẢNG", "TÊN RAM", "DUNG LƯỢNG", "BUS", "LOẠI RAM", "GIÁ"
            });
            input = Integer.parseInt(txtTien.getText());
            b1 = RAMKQ(input);
            String temp;
            temp = b1.getRam().getMaRAM();
            listRAM1 = new connection().getListRAM_User(temp);
            showTBRAM();
            type = 3;
            outTxt += listRAM1.get(0).toString() + "\n";
        } else if (checkboxOCung.isSelected()) {
            modelTBOCung1.setColumnIdentifiers(new Object[]{
                "HẢNG", "TÊN Ổ CỨNG", "LOẠI Ổ CỨNG", "DUNG LƯỢNG", "GHI", "ĐỌC", "GIÁ"
            });
            input = Integer.parseInt(txtTien.getText());
            b1 = OCungKQ(input);
            String temp;
            temp = b1.getO().getMaOCung();
            listOCung1 = new connection().getListOCung_User(temp);
            showTBOCung();
            type = 4;
            outTxt += listOCung1.get(0).toString() + "\n";
        } else if (checkboxCase.isSelected()) {
            modelTBCase1.setColumnIdentifiers(new Object[]{
                "HẢNG", "TÊN CASE", "MÀU SẮC", "CHẤT LIỆU", "GIÁ"
            });
            input = Integer.parseInt(txtTien.getText());
            b1 = CaseKQ(input);
            String temp;
            temp = b1.getC().getMaCase();
            listCase1 = new connection().getListCase_User(temp);
            showTBCase();
            type = 5;
            outTxt += listCase1.get(0).toString() + "\n";

        } else if (checkboxVGA.isSelected()) {
            modelTBVGA1.setColumnIdentifiers(new Object[]{
                "HẢNG", "TÊN VGA", "DÒNG", "NHÂN", "XUNG NHỊP", "GIÁ"
            });
            input = Integer.parseInt(txtTien.getText());
            b1 = VGAKQ(input);
            String temp;
            temp = b1.getV().getMaVGA();
            listVGA1 = new connection().getListVGA_User(temp);
            showTBVGA();
            type = 6;
            outTxt += listVGA1.get(0).toString() + "\n";
        } else if (checkboxPSU.isSelected()) {
            modelTBPSU1.setColumnIdentifiers(new Object[]{
                "HẢNG", "CÔNG SUẤT", "CHUẨN", "GIÁ"
            });
            input = Integer.parseInt(txtTien.getText());
            b1 = PSUKQ(input);
            String temp;
            temp = b1.getP().getMaPSU();
            listPSU1 = new connection().getListPSU_User(temp);
            showTBPSU();
            type = 7;
            outTxt += listPSU1.get(0).toString() + "\n";
        }
//        } else {
//            try {
//                input = Integer.parseInt(txtTien.getText());
//                if (input >= 0) {
//                    validinput = true;
//                }
//            } catch (NumberFormatException e) {
//                //error
//                JOptionPane.showMessageDialog(this, "Vui nhập số !");
//            }
//        }
    }//GEN-LAST:event_btSearchRCMActionPerformed

    private void btBackLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBackLoginActionPerformed
        this.setVisible(false);
        new GDLogin().setVisible(true);
    }//GEN-LAST:event_btBackLoginActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            //If sửa thành Nimbus = > Windows
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GDUser.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GDUser.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GDUser.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GDUser.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GDUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBackLogin;
    private javax.swing.JButton btBuynow;
    private javax.swing.JButton btDetail;
    private javax.swing.JButton btExport;
    private javax.swing.JButton btSearchRCM;
    private javax.swing.JButton btSearchmore;
    private javax.swing.JRadioButton checkboxCPU;
    private javax.swing.JRadioButton checkboxCase;
    private javax.swing.JRadioButton checkboxMB;
    private javax.swing.JRadioButton checkboxOCung;
    private javax.swing.JRadioButton checkboxPSU;
    private javax.swing.JRadioButton checkboxRAM;
    private javax.swing.JRadioButton checkboxVGA;
    private javax.swing.JButton cpuBT;
    private javax.swing.JButton cpucoolerBT;
    private javax.swing.ButtonGroup groupLK;
    private javax.swing.JButton hddBT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton mainboardBT;
    private javax.swing.JButton psuBT;
    private javax.swing.JButton ramBT;
    private javax.swing.JTable tbKetQua;
    private javax.swing.JTextField txtTien;
    private javax.swing.JButton vgaBT;
    // End of variables declaration//GEN-END:variables

    private void urlOpener(String url) {
        Desktop desktop = Desktop.getDesktop();
        try {
            if (desktop.isSupported(Desktop.Action.OPEN)) {
                desktop.browse(java.net.URI.create(url));
            } else {
                Process p;
                try {
                    p = Runtime.getRuntime().exec("cmd /c start" + url);
                } catch (IOException e) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(GDUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
