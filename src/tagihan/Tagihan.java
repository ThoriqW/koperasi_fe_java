/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package tagihan;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import fungsi.WarnaTable;
import fungsi.koneksi;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.prefs.Preferences;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Lenovo
 */
public class Tagihan extends javax.swing.JDialog {
    private final DefaultTableModel tabMode;
    String[] arrayBulan = {
        "Januari", "Februari", "Maret", "April", "Mei", "Juni",
        "Juli", "Agustus", "September", "Oktober", "November", "Desember"
    };
    private String deleteTahun="";
    private int deleteBulan;
    /**
     * Creates new form Anggota
     * @param parent
     * @param modal
     */
    public Tagihan(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        this.setLocation(8,1);
        setSize(885,674);

        Object[] row={"ID Unit Kerja","Unit Kerja","ID Anggota","Nomor Anggota","Nama Lengkap","Tahun","Bulan","Simpanan Pokok","Simpanan Wajib","Dana Sosial","Sukarela","Pokok","Bunga","Barang","Jangka Waktu","Jangka Waktu Ke","Jumlah Pinjaman","Jumlah Tagihan","Jumlah Setoran Simpanan Pokok","Jumlah Setoran Simpanan Wajib","Jumlah Setoran Simpanan Dana Sosial","Jumlah Setoran Simpanan Sukarela","Jumlah Setoran Pokok","Jumlah Setoran Bunga","Jumlah Setoran Barang","Sisa Tunggakan","Keterangan"};
        tabMode=new DefaultTableModel(null,row){
              @Override public boolean isCellEditable(int rowIndex, int colIndex){return false;}
        };
        tbAnggota.setModel(tabMode);
        
        tbAnggota.setPreferredScrollableViewportSize(new Dimension(800,800));
        tbAnggota.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (int i = 0; i < 27; i++) {
            TableColumn column = tbAnggota.getColumnModel().getColumn(i);
            switch (i) {
                case 0 -> {
                    column.setMinWidth(0);
                    column.setMaxWidth(0);
                    column.setWidth(0);
                    column.setPreferredWidth(0);
                }
                case 1 -> column.setPreferredWidth(150);
                case 2 -> {
                    column.setMinWidth(0);
                    column.setMaxWidth(0);
                    column.setWidth(0);
                    column.setPreferredWidth(0);
                }
                case 3 -> column.setPreferredWidth(100);
                case 4 -> column.setPreferredWidth(100);
                case 5 -> column.setPreferredWidth(100);
                case 6 -> column.setPreferredWidth(100);
                case 7 -> column.setPreferredWidth(100);
                case 8 -> column.setPreferredWidth(100);
                case 9 -> column.setPreferredWidth(80);
                case 10 -> column.setPreferredWidth(80);
                case 11 -> column.setPreferredWidth(80);
                case 12 -> column.setPreferredWidth(80);
                case 13 -> column.setPreferredWidth(80);
                case 14 -> column.setPreferredWidth(80);
                case 15 -> column.setPreferredWidth(100);
                case 16 -> column.setPreferredWidth(100);
                case 17 -> column.setPreferredWidth(100);
                case 18 -> column.setPreferredWidth(180);
                case 19 -> column.setPreferredWidth(180);
                case 20 -> column.setPreferredWidth(200);
                case 21 -> column.setPreferredWidth(180);
                case 22 -> column.setPreferredWidth(180);
                case 23 -> column.setPreferredWidth(140);
                case 24 -> column.setPreferredWidth(140);
                case 25 -> column.setPreferredWidth(140);
                case 26 -> column.setPreferredWidth(100);
                case 27 -> column.setPreferredWidth(100);
                default -> {
                }
            }
        }
        tbAnggota.setDefaultRenderer(Object.class, new WarnaTable());
        ChkInput.setSelected(true);
        isForm(); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        internalFrame1 = new widget.InternalFrame();
        Scroll = new widget.ScrollPane();
        tbAnggota = new widget.Table();
        jPanel3 = new javax.swing.JPanel();
        panelGlass8 = new widget.panelisi();
        BtnSimpan = new widget.Button();
        BtnBatal = new widget.Button();
        BtnHapus = new widget.Button();
        BtnEdit = new widget.Button();
        BtnPrint = new widget.Button();
        BtnAll = new widget.Button();
        jLabel10 = new widget.Label();
        LCount = new widget.Label();
        BtnKeluar = new widget.Button();
        panelGlass9 = new widget.panelisi();
        jLabel15 = new widget.Label();
        cmbBulan = new javax.swing.JComboBox<>();
        jLabel4 = new widget.Label();
        TTahun = new javax.swing.JTextField();
        jLabel6 = new widget.Label();
        TCari = new javax.swing.JTextField();
        BtnCari = new widget.Button();
        BtnCreateTagihan = new widget.Button();
        PanelInput = new javax.swing.JPanel();
        FormInput = new widget.PanelBiasa();
        jnL1 = new javax.swing.JLabel();
        TTPokok = new javax.swing.JTextField();
        TTSimpananPokok = new javax.swing.JTextField();
        jnL2 = new javax.swing.JLabel();
        TTJumlahTagihan = new javax.swing.JTextField();
        TSKeterangan = new javax.swing.JTextField();
        TTSimpananWajib = new javax.swing.JTextField();
        TTDanaSosial = new javax.swing.JTextField();
        TTSukarela = new javax.swing.JTextField();
        jnL3 = new javax.swing.JLabel();
        jnL4 = new javax.swing.JLabel();
        jnL5 = new javax.swing.JLabel();
        jnL6 = new javax.swing.JLabel();
        jnL7 = new javax.swing.JLabel();
        jnL8 = new javax.swing.JLabel();
        TTBunga = new javax.swing.JTextField();
        jnL9 = new javax.swing.JLabel();
        jnL10 = new javax.swing.JLabel();
        jnL11 = new javax.swing.JLabel();
        jnL12 = new javax.swing.JLabel();
        TTJangkaWaktu = new javax.swing.JTextField();
        TTJangkaWaktuKe = new javax.swing.JTextField();
        TTJumlahPinjaman = new javax.swing.JTextField();
        jnL13 = new javax.swing.JLabel();
        jnL14 = new javax.swing.JLabel();
        TSPokok = new javax.swing.JTextField();
        jnL15 = new javax.swing.JLabel();
        jnL16 = new javax.swing.JLabel();
        jnL17 = new javax.swing.JLabel();
        jnL18 = new javax.swing.JLabel();
        TSDanaSosial = new javax.swing.JTextField();
        TSSukarela = new javax.swing.JTextField();
        TSSimpananWajib = new javax.swing.JTextField();
        TSSimpananPokok = new javax.swing.JTextField();
        jnL23 = new javax.swing.JLabel();
        TSBunga = new javax.swing.JTextField();
        jnL24 = new javax.swing.JLabel();
        TTBarang = new javax.swing.JTextField();
        jnL25 = new javax.swing.JLabel();
        TSBarang = new javax.swing.JTextField();
        TSSisaTunggakan = new javax.swing.JTextField();
        jnL26 = new javax.swing.JLabel();
        TBulan = new javax.swing.JTextField();
        TNamaAnggota = new javax.swing.JTextField();
        TUnitKerja = new javax.swing.JTextField();
        TTagihanTahun = new javax.swing.JTextField();
        ChkInput = new widget.CekBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(611, 155));
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        internalFrame1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 245, 235)), "::[ Data Tagihan ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(50, 50, 50))); // NOI18N
        internalFrame1.setLayout(new java.awt.BorderLayout(1, 1));

        Scroll.setOpaque(true);

        tbAnggota.setAutoCreateRowSorter(true);
        tbAnggota.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        tbAnggota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbAnggotaMouseClicked(evt);
            }
        });
        tbAnggota.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbAnggotaKeyReleased(evt);
            }
        });
        Scroll.setViewportView(tbAnggota);

        internalFrame1.add(Scroll, java.awt.BorderLayout.CENTER);

        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(44, 100));
        jPanel3.setLayout(new java.awt.BorderLayout(1, 1));

        panelGlass8.setPreferredSize(new java.awt.Dimension(44, 44));
        panelGlass8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 9));

        BtnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/save-16x16.png"))); // NOI18N
        BtnSimpan.setMnemonic('S');
        BtnSimpan.setText("Simpan");
        BtnSimpan.setToolTipText("Alt+S");
        BtnSimpan.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSimpanActionPerformed(evt);
            }
        });
        BtnSimpan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnSimpanKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnSimpan);

        BtnBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Cancel-2-16x16.png"))); // NOI18N
        BtnBatal.setMnemonic('B');
        BtnBatal.setText("Baru");
        BtnBatal.setToolTipText("Alt+B");
        BtnBatal.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBatalActionPerformed(evt);
            }
        });
        BtnBatal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnBatalKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnBatal);

        BtnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/stop_f2.png"))); // NOI18N
        BtnHapus.setMnemonic('H');
        BtnHapus.setText("Hapus");
        BtnHapus.setToolTipText("Alt+H");
        BtnHapus.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHapusActionPerformed(evt);
            }
        });
        BtnHapus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnHapusKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnHapus);

        BtnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/inventaris.png"))); // NOI18N
        BtnEdit.setMnemonic('G');
        BtnEdit.setText("Ganti");
        BtnEdit.setToolTipText("Alt+G");
        BtnEdit.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditActionPerformed(evt);
            }
        });
        BtnEdit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnEditKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnEdit);

        BtnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/b_print.png"))); // NOI18N
        BtnPrint.setMnemonic('T');
        BtnPrint.setText("Cetak");
        BtnPrint.setToolTipText("Alt+T");
        BtnPrint.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPrintActionPerformed(evt);
            }
        });
        BtnPrint.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnPrintKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnPrint);

        BtnAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Search-16x16.png"))); // NOI18N
        BtnAll.setMnemonic('M');
        BtnAll.setText("Semua");
        BtnAll.setToolTipText("Alt+M");
        BtnAll.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAllActionPerformed(evt);
            }
        });
        BtnAll.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnAllKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnAll);

        jLabel10.setText("Record :");
        jLabel10.setPreferredSize(new java.awt.Dimension(70, 30));
        panelGlass8.add(jLabel10);

        LCount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LCount.setText("0");
        LCount.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        LCount.setPreferredSize(new java.awt.Dimension(72, 30));
        panelGlass8.add(LCount);

        BtnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/exit.png"))); // NOI18N
        BtnKeluar.setMnemonic('K');
        BtnKeluar.setText("Keluar");
        BtnKeluar.setToolTipText("Alt+K");
        BtnKeluar.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnKeluarActionPerformed(evt);
            }
        });
        BtnKeluar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnKeluarKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnKeluar);

        jPanel3.add(panelGlass8, java.awt.BorderLayout.CENTER);

        panelGlass9.setPreferredSize(new java.awt.Dimension(44, 44));
        panelGlass9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 10));

        jLabel15.setText("Bulan :");
        jLabel15.setPreferredSize(new java.awt.Dimension(50, 23));
        panelGlass9.add(jLabel15);

        cmbBulan.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        cmbBulan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember" }));
        cmbBulan.setBorder(new com.formdev.flatlaf.ui.FlatTextBorder());
        cmbBulan.setMinimumSize(new java.awt.Dimension(94, 23));
        cmbBulan.setPreferredSize(new java.awt.Dimension(96, 23));
        cmbBulan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBulanActionPerformed(evt);
            }
        });
        panelGlass9.add(cmbBulan);

        jLabel4.setText("Tahun :");
        jLabel4.setPreferredSize(new java.awt.Dimension(50, 23));
        panelGlass9.add(jLabel4);

        TTahun.setPreferredSize(new java.awt.Dimension(80, 22));
        TTahun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TTahunActionPerformed(evt);
            }
        });
        panelGlass9.add(TTahun);

        jLabel6.setText("Key Word :");
        jLabel6.setPreferredSize(new java.awt.Dimension(70, 23));
        panelGlass9.add(jLabel6);

        TCari.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        TCari.setPreferredSize(new java.awt.Dimension(240, 22));
        panelGlass9.add(TCari);

        BtnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/accept.png"))); // NOI18N
        BtnCari.setMnemonic('2');
        BtnCari.setToolTipText("Alt+2");
        BtnCari.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCariActionPerformed(evt);
            }
        });
        BtnCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnCariKeyPressed(evt);
            }
        });
        panelGlass9.add(BtnCari);

        BtnCreateTagihan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/save-16x16.png"))); // NOI18N
        BtnCreateTagihan.setMnemonic('S');
        BtnCreateTagihan.setToolTipText("Alt+S");
        BtnCreateTagihan.setLabel("Create Tagihan");
        BtnCreateTagihan.setPreferredSize(new java.awt.Dimension(135, 30));
        BtnCreateTagihan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCreateTagihanActionPerformed(evt);
            }
        });
        BtnCreateTagihan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnCreateTagihanKeyPressed(evt);
            }
        });
        panelGlass9.add(BtnCreateTagihan);

        jPanel3.add(panelGlass9, java.awt.BorderLayout.PAGE_START);

        internalFrame1.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        PanelInput.setOpaque(false);
        PanelInput.setPreferredSize(new java.awt.Dimension(850, 430));
        PanelInput.setLayout(new java.awt.BorderLayout(1, 1));

        FormInput.setPreferredSize(new java.awt.Dimension(850, 137));
        FormInput.setLayout(null);

        jnL1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jnL1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jnL1.setText("2. Setoran");
        FormInput.add(jnL1);
        jnL1.setBounds(20, 210, 70, 23);

        TTPokok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TTPokokActionPerformed(evt);
            }
        });
        FormInput.add(TTPokok);
        TTPokok.setBounds(100, 170, 210, 23);
        FormInput.add(TTSimpananPokok);
        TTSimpananPokok.setBounds(100, 50, 210, 23);

        jnL2.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jnL2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jnL2.setText("Keterangan :");
        FormInput.add(jnL2);
        jnL2.setBounds(340, 330, 70, 23);
        FormInput.add(TTJumlahTagihan);
        TTJumlahTagihan.setBounds(740, 50, 190, 23);
        FormInput.add(TSKeterangan);
        TSKeterangan.setBounds(420, 330, 210, 50);
        FormInput.add(TTSimpananWajib);
        TTSimpananWajib.setBounds(100, 80, 210, 23);
        FormInput.add(TTDanaSosial);
        TTDanaSosial.setBounds(100, 110, 210, 23);
        FormInput.add(TTSukarela);
        TTSukarela.setBounds(100, 140, 210, 23);

        jnL3.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jnL3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jnL3.setText("Pokok :");
        FormInput.add(jnL3);
        jnL3.setBounds(20, 170, 70, 23);

        jnL4.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jnL4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jnL4.setText("Dana Sosial :");
        FormInput.add(jnL4);
        jnL4.setBounds(0, 110, 90, 23);

        jnL5.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jnL5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jnL5.setText("Jumlah Tagihan :");
        FormInput.add(jnL5);
        jnL5.setBounds(640, 50, 90, 23);

        jnL6.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jnL6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jnL6.setText("Simpanan Pokok :");
        FormInput.add(jnL6);
        jnL6.setBounds(0, 50, 90, 23);

        jnL7.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jnL7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jnL7.setText("Simpanan Wajib :");
        FormInput.add(jnL7);
        jnL7.setBounds(0, 80, 90, 23);

        jnL8.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jnL8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jnL8.setText("Sukarela :");
        FormInput.add(jnL8);
        jnL8.setBounds(20, 140, 70, 23);
        FormInput.add(TTBunga);
        TTBunga.setBounds(420, 50, 210, 23);

        jnL9.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jnL9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jnL9.setText("Bunga :");
        FormInput.add(jnL9);
        jnL9.setBounds(340, 50, 70, 23);

        jnL10.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jnL10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jnL10.setText("Jangka Waktu :");
        FormInput.add(jnL10);
        jnL10.setBounds(320, 110, 90, 23);

        jnL11.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jnL11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jnL11.setText("Jangka Waktu Ke :");
        FormInput.add(jnL11);
        jnL11.setBounds(320, 140, 90, 23);

        jnL12.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jnL12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jnL12.setText("Jumlah Pinjaman :");
        FormInput.add(jnL12);
        jnL12.setBounds(320, 170, 90, 23);
        FormInput.add(TTJangkaWaktu);
        TTJangkaWaktu.setBounds(420, 110, 210, 23);
        FormInput.add(TTJangkaWaktuKe);
        TTJangkaWaktuKe.setBounds(420, 140, 210, 23);
        FormInput.add(TTJumlahPinjaman);
        TTJumlahPinjaman.setBounds(420, 170, 210, 23);

        jnL13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jnL13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jnL13.setText("1. Tagihan");
        FormInput.add(jnL13);
        jnL13.setBounds(20, 20, 70, 23);

        jnL14.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jnL14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jnL14.setText("Simpanan Pokok :");
        FormInput.add(jnL14);
        jnL14.setBounds(0, 240, 90, 23);
        FormInput.add(TSPokok);
        TSPokok.setBounds(100, 360, 210, 23);

        jnL15.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jnL15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jnL15.setText("Pokok :");
        FormInput.add(jnL15);
        jnL15.setBounds(20, 360, 70, 23);

        jnL16.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jnL16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jnL16.setText("Sukarela :");
        FormInput.add(jnL16);
        jnL16.setBounds(20, 330, 70, 23);

        jnL17.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jnL17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jnL17.setText("Dana Sosial :");
        FormInput.add(jnL17);
        jnL17.setBounds(0, 300, 90, 23);

        jnL18.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jnL18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jnL18.setText("Simpanan Wajib :");
        FormInput.add(jnL18);
        jnL18.setBounds(0, 270, 90, 23);
        FormInput.add(TSDanaSosial);
        TSDanaSosial.setBounds(100, 300, 210, 23);
        FormInput.add(TSSukarela);
        TSSukarela.setBounds(100, 330, 210, 23);
        FormInput.add(TSSimpananWajib);
        TSSimpananWajib.setBounds(100, 270, 210, 23);
        FormInput.add(TSSimpananPokok);
        TSSimpananPokok.setBounds(100, 240, 210, 23);

        jnL23.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jnL23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jnL23.setText("Bunga :");
        FormInput.add(jnL23);
        jnL23.setBounds(340, 240, 70, 23);
        FormInput.add(TSBunga);
        TSBunga.setBounds(420, 240, 210, 23);

        jnL24.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jnL24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jnL24.setText("Barang :");
        FormInput.add(jnL24);
        jnL24.setBounds(340, 80, 70, 23);
        FormInput.add(TTBarang);
        TTBarang.setBounds(420, 80, 210, 23);

        jnL25.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jnL25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jnL25.setText("Barang :");
        FormInput.add(jnL25);
        jnL25.setBounds(340, 270, 70, 23);
        FormInput.add(TSBarang);
        TSBarang.setBounds(420, 270, 210, 23);
        FormInput.add(TSSisaTunggakan);
        TSSisaTunggakan.setBounds(420, 300, 210, 23);

        jnL26.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jnL26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jnL26.setText("Sisa Tunggakan :");
        FormInput.add(jnL26);
        jnL26.setBounds(320, 300, 90, 23);

        TBulan.setEditable(false);
        FormInput.add(TBulan);
        TBulan.setBounds(550, 20, 170, 23);

        TNamaAnggota.setEditable(false);
        FormInput.add(TNamaAnggota);
        TNamaAnggota.setBounds(100, 20, 210, 23);

        TUnitKerja.setEditable(false);
        FormInput.add(TUnitKerja);
        TUnitKerja.setBounds(320, 20, 210, 23);

        TTagihanTahun.setEditable(false);
        FormInput.add(TTagihanTahun);
        TTagihanTahun.setBounds(740, 20, 190, 23);

        PanelInput.add(FormInput, java.awt.BorderLayout.CENTER);

        ChkInput.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/143.png"))); // NOI18N
        ChkInput.setMnemonic('I');
        ChkInput.setText(".: Input Data");
        ChkInput.setToolTipText("Alt+I");
        ChkInput.setBorderPainted(true);
        ChkInput.setBorderPaintedFlat(true);
        ChkInput.setFocusable(false);
        ChkInput.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ChkInput.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ChkInput.setPreferredSize(new java.awt.Dimension(192, 20));
        ChkInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChkInputActionPerformed(evt);
            }
        });
        PanelInput.add(ChkInput, java.awt.BorderLayout.PAGE_END);

        internalFrame1.add(PanelInput, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(internalFrame1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbAnggotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAnggotaMouseClicked
        if(tabMode.getRowCount()!=0){
            try {
                getData();
            } catch (java.lang.NullPointerException e) {
            }
        }
    }//GEN-LAST:event_tbAnggotaMouseClicked

    private void tbAnggotaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbAnggotaKeyReleased
        if(tabMode.getRowCount()!=0){
            if((evt.getKeyCode()==KeyEvent.VK_ENTER)||(evt.getKeyCode()==KeyEvent.VK_UP)||(evt.getKeyCode()==KeyEvent.VK_DOWN)){
                try {
                    getData();
                } catch (java.lang.NullPointerException e) {
                }
            }
        }
    }//GEN-LAST:event_tbAnggotaKeyReleased

    private void BtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpanActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        if(tbAnggota.getSelectedRow() != -1){  
            try {
                String URL = koneksi.HOST() + "/api/v1/bills/update";
                System.out.println("Request ke: " + URL);

                // Ambil token dari Preferences
                Preferences prefs = Preferences.userRoot().node("myApp");
                String token = prefs.get("auth_token", null);

                if (token == null) {
                    JOptionPane.showMessageDialog(null, "Token tidak ditemukan! Harap login terlebih dahulu.");
                    return;
                }

                // Header
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                headers.set("Accept", "application/json");
                headers.set("Authorization", "Bearer " + token);
                
                int indexBulan = Arrays.asList(arrayBulan).indexOf(tbAnggota.getValueAt(tbAnggota.getSelectedRow(),6).toString()) + 1;
                
                // Data Anggota
                Map<String, Object> requestData = new HashMap<>();
                requestData.put("tahun", tbAnggota.getValueAt(tbAnggota.getSelectedRow(),5).toString());
                requestData.put("bulan", indexBulan);
                
                // Data bills (dalam list karena JSON `bills` adalah array)
                List<Map<String, Object>> billsList = new ArrayList<>();

                Map<String, Object> bill1 = new HashMap<>();
                bill1.put("member_profile_id", tbAnggota.getValueAt(tbAnggota.getSelectedRow(),2).toString());
                bill1.put("simpanan_pokok", TTSimpananPokok.getText());
                bill1.put("simpanan_wajib", TTSimpananWajib.getText());
                bill1.put("dana_sosial", TTDanaSosial.getText());
                bill1.put("sukarela", TTSukarela.getText());
                bill1.put("pokok", TTPokok.getText());
                bill1.put("bunga", Integer.valueOf(TSBunga.getText()));
                bill1.put("barang", TTBarang.getText());
                bill1.put("jangka_waktu", TTJangkaWaktu.getText());
                bill1.put("jangka_waktu_ke", TTJangkaWaktuKe.getText());
                bill1.put("jumlah_pinjaman", TTJumlahPinjaman.getText());
                bill1.put("jumlah_tagihan", TTJumlahTagihan.getText());
                bill1.put("jumlah_setoran_simpanan_pokok", TSSimpananPokok.getText());
                bill1.put("jumlah_setoran_simpanan_wajib", TSSimpananWajib.getText());
                bill1.put("jumlah_setoran_dana_sosial", TSDanaSosial.getText());
                bill1.put("jumlah_setoran_sukarela", TSSukarela.getText());
                bill1.put("jumlah_setoran_pokok", TSPokok.getText());
                bill1.put("jumlah_setoran_bunga", Integer.valueOf(TSBunga.getText()));
                bill1.put("jumlah_setoran_barang", TSBarang.getText());
                bill1.put("sisa_tunggakan", TSSisaTunggakan.getText());
                bill1.put("keterangan", TSKeterangan.getText());
                
                billsList.add(bill1);
                
                requestData.put("bills", billsList);

                // Konversi Map ke JSON String menggunakan ObjectMapper
                ObjectMapper objectMapper = new ObjectMapper();
                String requestJsonAnggota = objectMapper.writeValueAsString(requestData);

                // Request menggunakan RestTemplate
                RestTemplate restAnggota = new RestTemplate();
                HttpEntity<String> entity = new HttpEntity<>(requestJsonAnggota, headers);
                ResponseEntity<String> response = restAnggota.exchange(URL, HttpMethod.POST, entity, String.class);

                // Menangani response
                if (response.getStatusCode() == HttpStatus.CREATED) {
                    JsonNode root = objectMapper.readTree(response.getBody());
                    JOptionPane.showMessageDialog(null, root.path("message").asText());
                    tabMode.setRowCount(0);
                    tampil(TCari.getText(),TTahun.getText(),cmbBulan.getSelectedIndex());
                } else {
                    JOptionPane.showMessageDialog(null, "Gagal simpan, periksa kembali data");
                }
            } catch (HttpClientErrorException e) {
                // Menangani error dari API (misalnya 400 Bad Request)
                System.out.println("Error Response: " + e.getResponseBodyAsString());
                JOptionPane.showMessageDialog(null, e.getResponseBodyAsString());
            } catch (JsonProcessingException | HeadlessException | RestClientException e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Silahkan pilih data terlebih dahulu");
        }
        setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_BtnSimpanActionPerformed

    private void BtnSimpanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnSimpanKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnSimpanActionPerformed(null);
        }else{
            //            Valid.pindah(evt,KdJbtn,BtnBatal);
        }
    }//GEN-LAST:event_BtnSimpanKeyPressed

    private void BtnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBatalActionPerformed
        ChkInput.setSelected(true);
        isForm();
        emptTeks();
    }//GEN-LAST:event_BtnBatalActionPerformed

    private void BtnBatalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnBatalKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            emptTeks();
        }
    }//GEN-LAST:event_BtnBatalKeyPressed

    private void BtnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHapusActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        System.out.println(deleteTahun);
            try {
                String URL = koneksi.HOST() + "/api/v1/bills/"+deleteTahun+"/"+deleteBulan;
                System.out.println("Request ke: " + URL);

                // Ambil token dari Preferences
                Preferences prefs = Preferences.userRoot().node("myApp");
                String token = prefs.get("auth_token", null);

                if (token == null) {
                    System.out.println("Token tidak ditemukan! Harap login terlebih dahulu.");
                    return;
                }

                // Header
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                headers.set("Accept", "application/json");
                headers.set("Authorization", "Bearer " + token);

                // Request menggunakan RestTemplate
                RestTemplate restTemplate = new RestTemplate();
                HttpEntity<String> entity = new HttpEntity<>(headers);
                ResponseEntity<String> response = restTemplate.exchange(URL, HttpMethod.DELETE, entity, String.class);

                ObjectMapper objectMapper = new ObjectMapper();

                if (response.getStatusCode() == HttpStatus.OK) {
                    JsonNode root = objectMapper.readTree(response.getBody());
                    JOptionPane.showMessageDialog(null, root.path("message").asText());
                    tabMode.setRowCount(0);
                    tampil("", TTahun.getText(), cmbBulan.getSelectedIndex());
                    emptTeks();
                } else {
                    JOptionPane.showMessageDialog(null, "Gagal hapus data");
                }

            } catch (JsonProcessingException | RestClientException e) {
                System.out.println(e);
            }
        setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_BtnHapusActionPerformed

    private void BtnHapusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnHapusKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnHapusActionPerformed(null);
        }
    }//GEN-LAST:event_BtnHapusKeyPressed

    private void BtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditActionPerformed

    }//GEN-LAST:event_BtnEditActionPerformed

    private void BtnEditKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnEditKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnEditActionPerformed(null);
        }
    }//GEN-LAST:event_BtnEditKeyPressed

    private void BtnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPrintActionPerformed

    }//GEN-LAST:event_BtnPrintActionPerformed

    private void BtnPrintKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnPrintKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnPrintActionPerformed(null);
        }
    }//GEN-LAST:event_BtnPrintKeyPressed

    private void BtnAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAllActionPerformed
//        cmbCrJk.setSelectedIndex(0);
        TCari.setText("");
        tampil("",TTahun.getText(),cmbBulan.getSelectedIndex());
    }//GEN-LAST:event_BtnAllActionPerformed

    private void BtnAllKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnAllKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnAllActionPerformed(null);
        }
    }//GEN-LAST:event_BtnAllKeyPressed

    private void BtnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKeluarActionPerformed
        dispose();
    }//GEN-LAST:event_BtnKeluarActionPerformed

    private void BtnKeluarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnKeluarKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            dispose();
        }
    }//GEN-LAST:event_BtnKeluarKeyPressed

    private void BtnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCariActionPerformed
        tampil(TCari.getText(),TTahun.getText(),cmbBulan.getSelectedIndex());
        deleteTahun = TTahun.getText();
        deleteBulan = cmbBulan.getSelectedIndex();
    }//GEN-LAST:event_BtnCariActionPerformed

    private void BtnCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnCariKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnCariActionPerformed(null);
        }
    }//GEN-LAST:event_BtnCariKeyPressed

    private void ChkInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChkInputActionPerformed
        isForm();
    }//GEN-LAST:event_ChkInputActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        tampil(TCari.getText(),TTahun.getText(),cmbBulan.getSelectedIndex());
    }//GEN-LAST:event_formWindowOpened

    private void cmbBulanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBulanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbBulanActionPerformed

    private void TTPokokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TTPokokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TTPokokActionPerformed

    private void TTahunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TTahunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TTahunActionPerformed

    private void BtnCreateTagihanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCreateTagihanActionPerformed
        // TODO add your handling code here:
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        try {
            String URL = koneksi.HOST() + "/api/v1/bills";
            System.out.println("Request ke: " + URL);

            // Ambil token dari Preferences
            Preferences prefs = Preferences.userRoot().node("myApp");
            String token = prefs.get("auth_token", null);

            if (token == null) {
                JOptionPane.showMessageDialog(null, "Token tidak ditemukan! Harap login terlebih dahulu.");
                return;
            }

            // Header
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("Accept", "application/json");
            headers.set("Authorization", "Bearer " + token);

            // Data Anggota
            Map<String, Object> requestData = new HashMap<>();
            requestData.put("tahun", TTahun.getText());
            requestData.put("bulan", cmbBulan.getSelectedIndex());
            
            // Konversi Map ke JSON String menggunakan ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();
            String requestJsonAnggota = objectMapper.writeValueAsString(requestData);

            // Request menggunakan RestTemplate
            RestTemplate restAnggota = new RestTemplate();
            HttpEntity<String> entity = new HttpEntity<>(requestJsonAnggota, headers);
            ResponseEntity<String> response = restAnggota.exchange(URL, HttpMethod.POST, entity, String.class);

            // Menangani response
            if (response.getStatusCode() == HttpStatus.CREATED) {
                JsonNode root = objectMapper.readTree(response.getBody());
                JOptionPane.showMessageDialog(null, root.path("message").asText());
                tabMode.setRowCount(0);
                tampil(TCari.getText(),TTahun.getText(),cmbBulan.getSelectedIndex());
            } else {
                JOptionPane.showMessageDialog(null, "Gagal simpan, periksa kembali data");
            }
        } catch (HttpClientErrorException e) {
            // Menangani error dari API (misalnya 400 Bad Request)
            System.out.println("Error Response: " + e.getResponseBodyAsString());
            JOptionPane.showMessageDialog(null, e.getResponseBodyAsString());
        } catch (JsonProcessingException | HeadlessException | RestClientException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
        setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_BtnCreateTagihanActionPerformed

    private void BtnCreateTagihanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnCreateTagihanKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnCreateTagihanKeyPressed

    public void emptTeks() {
        TNamaAnggota.setText("");
        TUnitKerja.setText("");
        TBulan.setText("");
        TTagihanTahun.setText("");

        TTSimpananPokok.setText("");
        TTSimpananWajib.setText("");
        TTDanaSosial.setText("");
        TTSukarela.setText("");
        TTPokok.setText("");
        TTBunga.setText("");
        TTBarang.setText("");
        TTJangkaWaktu.setText("");
        TTJangkaWaktuKe.setText("");
        TTJumlahPinjaman.setText("");
        TTJumlahTagihan.setText("");

        TSSimpananPokok.setText("");
        TSSimpananWajib.setText("");
        TSDanaSosial.setText("");
        TSSukarela.setText("");
        TSPokok.setText("");
        TSBunga.setText("");
        TSBarang.setText("");
        TSSisaTunggakan.setText("");
        TSKeterangan.setText("");
    }
    
     private void isForm(){
        if(ChkInput.isSelected()==true){
            ChkInput.setVisible(false);
            PanelInput.setPreferredSize(new Dimension(WIDTH,430));
            FormInput.setVisible(true);      
            ChkInput.setVisible(true);
        }else if(ChkInput.isSelected()==false){           
            ChkInput.setVisible(false);            
            PanelInput.setPreferredSize(new Dimension(WIDTH,20));
            FormInput.setVisible(false);      
            ChkInput.setVisible(true);
        }
    }
     
     private void getData() {
        int row=tbAnggota.getSelectedRow();
        if(row!= -1){
            TNamaAnggota.setText(tbAnggota.getValueAt(row,4).toString());
            TUnitKerja.setText(tbAnggota.getValueAt(row,1).toString());
            TBulan.setText(tbAnggota.getValueAt(row,6).toString());
            TTagihanTahun.setText(tbAnggota.getValueAt(row,5).toString());
            
            TTSimpananPokok.setText(tbAnggota.getValueAt(row,7).toString());
            TTSimpananWajib.setText(tbAnggota.getValueAt(row,8).toString());
            TTDanaSosial.setText(tbAnggota.getValueAt(row,9).toString());
            TTSukarela.setText(tbAnggota.getValueAt(row,10).toString());
            TTPokok.setText(tbAnggota.getValueAt(row,11).toString());
            TTBunga.setText(tbAnggota.getValueAt(row,12).toString());
            TTBarang.setText(tbAnggota.getValueAt(row,13).toString());
            TTJangkaWaktu.setText(tbAnggota.getValueAt(row,14).toString());
            TTJangkaWaktuKe.setText(tbAnggota.getValueAt(row,15).toString());
            TTJumlahPinjaman.setText(tbAnggota.getValueAt(row,16).toString());
            TTJumlahTagihan.setText(tbAnggota.getValueAt(row,17).toString());
            
            TSSimpananPokok.setText(tbAnggota.getValueAt(row,18).toString());
            TSSimpananWajib.setText(tbAnggota.getValueAt(row,19).toString());
            TSDanaSosial.setText(tbAnggota.getValueAt(row,20).toString());
            TSSukarela.setText(tbAnggota.getValueAt(row,21).toString());
            TSPokok.setText(tbAnggota.getValueAt(row,22).toString());
            TSBunga.setText(tbAnggota.getValueAt(row,23).toString());
            TSBarang.setText(tbAnggota.getValueAt(row,24).toString());
            TSSisaTunggakan.setText(tbAnggota.getValueAt(row,25).toString());
            TSKeterangan.setText(tbAnggota.getValueAt(row,26).toString());
        }
    }
     
    private void tampil(String cari, String tahun, int bulan) {
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        try {
            String URL = koneksi.HOST() + "/api/v1/bills?search="+cari+"&tahun="+tahun+"&bulan="+bulan;
            System.out.println("Request ke: " + URL);
            
            // Ambil token dari Preferences
            Preferences prefs = Preferences.userRoot().node("myApp");
            String token = prefs.get("auth_token", null);

            if (token == null) {
                System.out.println("Token tidak ditemukan! Harap login terlebih dahulu.");
                return;
            }
            
            tabMode.setRowCount(0); // Hapus data lama

            // Header
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("Accept", "application/json");
            headers.set("Authorization", "Bearer " + token); 
            
            // Request menggunakan RestTemplate
            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<String> entity = new HttpEntity<>(headers);
            ResponseEntity<String> response = restTemplate.exchange(URL, HttpMethod.GET, entity, String.class);
            
            // Parsing JSON ke dalam tabel
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(response.getBody());

            System.out.println(rootNode);
            
            JsonNode dataArray = rootNode.path("data");

            if (dataArray.isArray()) {
                for (JsonNode member : dataArray) {
                    String unitkerjaid = member.path("work_unit_id").asText();
                    String unitkerja = member.path("work_unit").asText();
                    String profileid = member.path("member_profile_id").asText();
                    String nomoranggota = member.path("nomor_anggota").asText();
                    String namalengkap = member.path("nama_lengkap").asText();
                    String tahunTagihan = member.path("tahun").asText();
                    String bulanTagihan = member.path("bulan").asText();
                    
                    // Mengakses array bills
                    JsonNode billsArray = member.path("bills");
                    if (billsArray.isArray() && billsArray.size() > 0) {
                        for (JsonNode bill : billsArray) {
                            String simpananPokok = bill.path("simpanan_pokok").asText();
                            String simpananWajib = bill.path("simpanan_wajib").asText();
                            String danaSosial = bill.path("dana_sosial").asText();
                            String sukarela = bill.path("sukarela").asText();
                            String pokok = bill.path("pokok").asText();
                            String bunga = bill.path("bunga").asText();
                            String barang = bill.path("barang").asText();
                            String jangkawaktu = bill.path("jangka_waktu").asText();
                            String jangkawaktuke = bill.path("jangka_waktu_ke").asText();
                            String jumlahpinjaman = bill.path("jumlah_pinjaman").asText();
                            String jumlahtagihan = bill.path("jumlah_tagihan").asText();
                            String jumlahSetoranSimpananPokok = bill.path("jumlah_setoran_simpanan_pokok").asText();
                            String jumlahSetoranSimpananWajib = bill.path("jumlah_setoran_simpanan_wajib").asText();
                            String jumlahSetoranDanaSosial = bill.path("jumlah_setoran_dana_sosial").asText();
                            String jumlahSetoranSukarela = bill.path("jumlah_setoran_sukarela").asText();
                            String jumlahSetoranPokok = bill.path("jumlah_setoran_pokok").asText();
                            String jumlahSetoranBunga = bill.path("jumlah_setoran_bunga").asText();
                            String jumlahSetoranBarang = bill.path("jumlah_setoran_barang").asText();
                            String sisaTunggakan = bill.path("sisa_tunggakan").asText();
                            String keterangan = bill.path("keterangan").asText();
                            
                            // Tambahkan data ke tabel
                            tabMode.addRow(new Object[]{
                                unitkerjaid,
                                unitkerja.equals("null") ? "" : unitkerja,
                                profileid.equals("null") ? "" : profileid,
                                nomoranggota.equals("null") ? "" : nomoranggota,
                                namalengkap.equals("null") ? "" : namalengkap,
                                tahunTagihan.equals("null") ? "" : tahunTagihan,
                                bulanTagihan.equals("null") ? "" : arrayBulan[Integer.parseInt(bulanTagihan)-1],
                                (simpananPokok != null && (simpananPokok.equals("0") || simpananPokok.equals("0.00"))) ? "" : simpananPokok,
                                (simpananWajib != null && (simpananWajib.equals("0") || simpananWajib.equals("0.00"))) ? "" : simpananWajib,
                                (danaSosial != null && (danaSosial.equals("0") || danaSosial.equals("0.00"))) ? "" : danaSosial,
                                (sukarela != null && (sukarela.equals("0") || sukarela.equals("0.00"))) ? "" : sukarela,
                                (pokok != null && (pokok.equals("0") || pokok.equals("0.00"))) ? "" : pokok,
                                (bunga != null && (bunga.equals("0") || bunga.equals("0.00"))) ? "" : bunga,
                                (barang != null && (barang.equals("0") || barang.equals("0.00"))) ? "" : barang,
                                (jangkawaktu != null && (jangkawaktu.equals("0") || jangkawaktu.equals("0.00"))) ? "" : jangkawaktu,
                                (jangkawaktuke != null && (jangkawaktuke.equals("0") || jangkawaktuke.equals("0.00"))) ? "" : jangkawaktuke,
                                (jumlahpinjaman != null && (jumlahpinjaman.equals("0") || jumlahpinjaman.equals("0.00"))) ? "" : jumlahpinjaman,
                                (jumlahtagihan != null && (jumlahtagihan.equals("0") || jumlahtagihan.equals("0.00"))) ? "" : jumlahtagihan,
                                (jumlahSetoranSimpananPokok != null && (jumlahSetoranSimpananPokok.equals("0") || jumlahSetoranSimpananPokok.equals("0.00"))) ? "" : jumlahSetoranSimpananPokok,
                                (jumlahSetoranSimpananWajib != null && (jumlahSetoranSimpananWajib.equals("0") || jumlahSetoranSimpananWajib.equals("0.00"))) ? "" : jumlahSetoranSimpananWajib,
                                (jumlahSetoranDanaSosial != null && (jumlahSetoranDanaSosial.equals("0") || jumlahSetoranDanaSosial.equals("0.00"))) ? "" : jumlahSetoranDanaSosial,
                                (jumlahSetoranSukarela != null && (jumlahSetoranSukarela.equals("0") || jumlahSetoranSukarela.equals("0.00"))) ? "" : jumlahSetoranSukarela,
                                (jumlahSetoranPokok != null && (jumlahSetoranPokok.equals("0") || jumlahSetoranPokok.equals("0.00"))) ? "" : jumlahSetoranPokok,
                                (jumlahSetoranBunga != null && (jumlahSetoranBunga.equals("0") || jumlahSetoranBunga.equals("0.00"))) ? "" : jumlahSetoranBunga,
                                (jumlahSetoranBarang != null && (jumlahSetoranBarang.equals("0") || jumlahSetoranBarang.equals("0.00"))) ? "" : jumlahSetoranBarang,
                                (sisaTunggakan != null && (sisaTunggakan.equals("0") || sisaTunggakan.equals("0.00"))) ? "" : sisaTunggakan,
                                (keterangan != null && (keterangan.equals("0") || keterangan.equals("0.00"))) ? "" : keterangan,
                            });
                    }}
                }
            }

        } catch (JsonProcessingException | RestClientException e) {
            System.out.println(e);
        } finally{
        }
        ChkInput.setSelected(true);
        LCount.setText(""+tabMode.getRowCount());
        setCursor(Cursor.getDefaultCursor());
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private widget.Button BtnAll;
    private widget.Button BtnBatal;
    private widget.Button BtnCari;
    private widget.Button BtnCreateTagihan;
    private widget.Button BtnEdit;
    private widget.Button BtnHapus;
    private widget.Button BtnKeluar;
    private widget.Button BtnPrint;
    private widget.Button BtnSimpan;
    private widget.CekBox ChkInput;
    private widget.PanelBiasa FormInput;
    private widget.Label LCount;
    private javax.swing.JPanel PanelInput;
    private widget.ScrollPane Scroll;
    private javax.swing.JTextField TBulan;
    private javax.swing.JTextField TCari;
    private javax.swing.JTextField TNamaAnggota;
    private javax.swing.JTextField TSBarang;
    private javax.swing.JTextField TSBunga;
    private javax.swing.JTextField TSDanaSosial;
    private javax.swing.JTextField TSKeterangan;
    private javax.swing.JTextField TSPokok;
    private javax.swing.JTextField TSSimpananPokok;
    private javax.swing.JTextField TSSimpananWajib;
    private javax.swing.JTextField TSSisaTunggakan;
    private javax.swing.JTextField TSSukarela;
    private javax.swing.JTextField TTBarang;
    private javax.swing.JTextField TTBunga;
    private javax.swing.JTextField TTDanaSosial;
    private javax.swing.JTextField TTJangkaWaktu;
    private javax.swing.JTextField TTJangkaWaktuKe;
    private javax.swing.JTextField TTJumlahPinjaman;
    private javax.swing.JTextField TTJumlahTagihan;
    private javax.swing.JTextField TTPokok;
    private javax.swing.JTextField TTSimpananPokok;
    private javax.swing.JTextField TTSimpananWajib;
    private javax.swing.JTextField TTSukarela;
    private javax.swing.JTextField TTagihanTahun;
    private javax.swing.JTextField TTahun;
    private javax.swing.JTextField TUnitKerja;
    private javax.swing.JComboBox<String> cmbBulan;
    private widget.InternalFrame internalFrame1;
    private widget.Label jLabel10;
    private widget.Label jLabel15;
    private widget.Label jLabel4;
    private widget.Label jLabel6;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel jnL1;
    private javax.swing.JLabel jnL10;
    private javax.swing.JLabel jnL11;
    private javax.swing.JLabel jnL12;
    private javax.swing.JLabel jnL13;
    private javax.swing.JLabel jnL14;
    private javax.swing.JLabel jnL15;
    private javax.swing.JLabel jnL16;
    private javax.swing.JLabel jnL17;
    private javax.swing.JLabel jnL18;
    private javax.swing.JLabel jnL2;
    private javax.swing.JLabel jnL23;
    private javax.swing.JLabel jnL24;
    private javax.swing.JLabel jnL25;
    private javax.swing.JLabel jnL26;
    private javax.swing.JLabel jnL3;
    private javax.swing.JLabel jnL4;
    private javax.swing.JLabel jnL5;
    private javax.swing.JLabel jnL6;
    private javax.swing.JLabel jnL7;
    private javax.swing.JLabel jnL8;
    private javax.swing.JLabel jnL9;
    private widget.panelisi panelGlass8;
    private widget.panelisi panelGlass9;
    private widget.Table tbAnggota;
    // End of variables declaration//GEN-END:variables
}
