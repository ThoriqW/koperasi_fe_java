/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package anggota;

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
import java.util.prefs.Preferences;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import unitkerja.CariUnitKerja;
import unitkerja.CariUnitKerjaKeyword;

/**
 *
 * @author Lenovo
 */
public class Anggota extends javax.swing.JDialog {
    private final DefaultTableModel tabMode;
    private String idunitkerja;
    private String keywordidunitkerja = "";
    private CariUnitKerja cariunitkerja=new CariUnitKerja(null,false);
    private CariUnitKerjaKeyword cariunitkerjakeyword=new CariUnitKerjaKeyword(null,false);
    /**
     * Creates new form Anggota
     * @param parent
     * @param modal
     */
    public Anggota(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        this.setLocation(8,1);
        setSize(885,674);
        
        Object[] row={"ID","Username","Nomor Anggota","Nama Lengkap","ID Work Unit","Unit Kerja","NIK","Email","No. HP","Alamat","Tanggal Lahir","Jenis Kelamin","Agama","NIP","Status","Tanggal Masuk","Tanggal Keluar"};
        tabMode=new DefaultTableModel(null,row){
              @Override public boolean isCellEditable(int rowIndex, int colIndex){return false;}
        };
        tbAnggota.setModel(tabMode);
        
        tbAnggota.setPreferredScrollableViewportSize(new Dimension(800,800));
        tbAnggota.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (int i = 0; i < 16; i++) {
            TableColumn column = tbAnggota.getColumnModel().getColumn(i);
            switch (i) {
                case 0 -> {
                    column.setMinWidth(0);
                    column.setMaxWidth(0);
                    column.setWidth(0);
                    column.setPreferredWidth(0);
                }
                case 1 -> column.setPreferredWidth(110);
                case 2 -> column.setPreferredWidth(100);
                case 3 -> column.setPreferredWidth(150);
                case 4 -> {
                    column.setMinWidth(0);
                    column.setMaxWidth(0);
                    column.setWidth(0);
                    column.setPreferredWidth(0);
                }
                case 5 -> column.setPreferredWidth(150);
                case 6 -> column.setPreferredWidth(110);
                case 7 -> column.setPreferredWidth(150);
                case 8 -> column.setPreferredWidth(100);
                case 9 -> column.setPreferredWidth(130);
                case 10 -> column.setPreferredWidth(100);
                case 11 -> column.setPreferredWidth(100);
                case 12 -> column.setPreferredWidth(80);
                case 13 -> column.setPreferredWidth(120);
                case 14 -> column.setPreferredWidth(80);
                case 15 -> column.setPreferredWidth(100);
                case 16 -> column.setPreferredWidth(100);
                default -> {
                }
            }
        }
        tbAnggota.setDefaultRenderer(Object.class, new WarnaTable());
        
        cariunitkerja.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {}
            @Override
            public void windowClosing(WindowEvent e) {}
            @Override
            public void windowClosed(WindowEvent e) {
                if(cariunitkerja.getTable().getSelectedRow()!= -1){                   
                    TUk.setText(cariunitkerja.tbUnitKerja.getValueAt(cariunitkerja.tbUnitKerja.getSelectedRow(),1).toString());
                    idunitkerja = cariunitkerja.tbUnitKerja.getValueAt(cariunitkerja.tbUnitKerja.getSelectedRow(),0).toString();
                }   
                TNip.requestFocus();
            }
            @Override
            public void windowIconified(WindowEvent e) {}
            @Override
            public void windowDeiconified(WindowEvent e) {}
            @Override
            public void windowActivated(WindowEvent e) {}
            @Override
            public void windowDeactivated(WindowEvent e) {}
        });
        
        cariunitkerjakeyword.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {}
            @Override
            public void windowClosing(WindowEvent e) {}
            @Override
            public void windowClosed(WindowEvent e) {
                if(cariunitkerjakeyword.getTable().getSelectedRow()!= -1){                   
                    TCariUk.setText(cariunitkerjakeyword.tbUnitKerja.getValueAt(cariunitkerjakeyword.tbUnitKerja.getSelectedRow(),1).toString());
                    keywordidunitkerja = cariunitkerjakeyword.tbUnitKerja.getValueAt(cariunitkerjakeyword.tbUnitKerja.getSelectedRow(),0).toString();
                }
            }
            @Override
            public void windowIconified(WindowEvent e) {}
            @Override
            public void windowDeiconified(WindowEvent e) {}
            @Override
            public void windowActivated(WindowEvent e) {}
            @Override
            public void windowDeactivated(WindowEvent e) {}
        });
        
        ChkInput.setSelected(false);
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
        jLabel16 = new widget.Label();
        cmbCrJumlahdata = new javax.swing.JComboBox<>();
        jLabel14 = new widget.Label();
        cmbCrJk = new javax.swing.JComboBox<>();
        jLabel7 = new widget.Label();
        TCariUk = new javax.swing.JTextField();
        BtnCariUnitKerjaTable = new widget.Button();
        jLabel8 = new widget.Label();
        cmbCrStatus = new javax.swing.JComboBox<>();
        jLabel6 = new widget.Label();
        TCari = new javax.swing.JTextField();
        BtnCari = new widget.Button();
        PanelInput = new javax.swing.JPanel();
        FormInput = new widget.PanelBiasa();
        jNa = new widget.Label();
        jTK = new widget.Label();
        jUk = new widget.Label();
        TNa = new javax.swing.JTextField();
        TUk = new javax.swing.JTextField();
        CmbJk = new javax.swing.JComboBox<>();
        TnL = new javax.swing.JTextField();
        jNik = new javax.swing.JLabel();
        jNoHp = new javax.swing.JLabel();
        TNik = new javax.swing.JTextField();
        jNip = new javax.swing.JLabel();
        TNoHp = new javax.swing.JTextField();
        TEmail = new javax.swing.JTextField();
        TAlamat = new javax.swing.JTextField();
        jnL = new javax.swing.JLabel();
        jEmail = new javax.swing.JLabel();
        jAgama = new javax.swing.JLabel();
        TNip = new javax.swing.JTextField();
        TAgama = new javax.swing.JTextField();
        jJK = new widget.Label();
        tanggalKeluar = new widget.Tanggal();
        jTL = new widget.Label();
        tanggalLahir = new widget.Tanggal();
        jTM = new widget.Label();
        tanggalMasuk = new widget.Tanggal();
        jAlamat = new javax.swing.JLabel();
        BtnCariUnitKerja = new widget.Button();
        jStatus = new widget.Label();
        CmbStatus = new javax.swing.JComboBox<>();
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

        internalFrame1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 245, 235)), "::[ Data Anggota ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(50, 50, 50))); // NOI18N
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

        jLabel16.setText("Jumlah Data :");
        jLabel16.setPreferredSize(new java.awt.Dimension(85, 23));
        panelGlass9.add(jLabel16);

        cmbCrJumlahdata.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        cmbCrJumlahdata.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "50", "100", "1000" }));
        cmbCrJumlahdata.setBorder(new com.formdev.flatlaf.ui.FlatTextBorder());
        cmbCrJumlahdata.setMinimumSize(new java.awt.Dimension(94, 23));
        cmbCrJumlahdata.setPreferredSize(new java.awt.Dimension(96, 23));
        cmbCrJumlahdata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCrJumlahdataActionPerformed(evt);
            }
        });
        panelGlass9.add(cmbCrJumlahdata);

        jLabel14.setText("J.K. :");
        jLabel14.setPreferredSize(new java.awt.Dimension(40, 23));
        panelGlass9.add(jLabel14);

        cmbCrJk.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        cmbCrJk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "  ", "lakilaki", "perempuan" }));
        cmbCrJk.setBorder(new com.formdev.flatlaf.ui.FlatTextBorder());
        cmbCrJk.setMinimumSize(new java.awt.Dimension(94, 23));
        cmbCrJk.setPreferredSize(new java.awt.Dimension(96, 23));
        cmbCrJk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCrJkActionPerformed(evt);
            }
        });
        panelGlass9.add(cmbCrJk);

        jLabel7.setText("Unit Kerja :");
        jLabel7.setPreferredSize(new java.awt.Dimension(70, 23));
        panelGlass9.add(jLabel7);

        TCariUk.setPreferredSize(new java.awt.Dimension(180, 23));
        panelGlass9.add(TCariUk);

        BtnCariUnitKerjaTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        BtnCariUnitKerjaTable.setMnemonic('1');
        BtnCariUnitKerjaTable.setToolTipText("ALt+1");
        BtnCariUnitKerjaTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCariUnitKerjaTableActionPerformed(evt);
            }
        });
        panelGlass9.add(BtnCariUnitKerjaTable);

        jLabel8.setText("Status :");
        jLabel8.setPreferredSize(new java.awt.Dimension(50, 23));
        panelGlass9.add(jLabel8);

        cmbCrStatus.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        cmbCrStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Aktif", "Tidak Aktif" }));
        cmbCrStatus.setBorder(new com.formdev.flatlaf.ui.FlatTextBorder());
        cmbCrStatus.setMinimumSize(new java.awt.Dimension(94, 23));
        cmbCrStatus.setPreferredSize(new java.awt.Dimension(96, 23));
        cmbCrStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCrStatusActionPerformed(evt);
            }
        });
        panelGlass9.add(cmbCrStatus);

        jLabel6.setText("Key Word :");
        jLabel6.setPreferredSize(new java.awt.Dimension(70, 23));
        panelGlass9.add(jLabel6);

        TCari.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        TCari.setPreferredSize(new java.awt.Dimension(240, 23));
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

        jPanel3.add(panelGlass9, java.awt.BorderLayout.PAGE_START);

        internalFrame1.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        PanelInput.setOpaque(false);
        PanelInput.setPreferredSize(new java.awt.Dimension(850, 190));
        PanelInput.setLayout(new java.awt.BorderLayout(1, 1));

        FormInput.setPreferredSize(new java.awt.Dimension(850, 137));
        FormInput.setLayout(null);

        jNa.setText("Nomor Anggota :");
        FormInput.add(jNa);
        jNa.setBounds(10, 70, 95, 23);

        jTK.setText("Tanggal Keluar :");
        FormInput.add(jTK);
        jTK.setBounds(610, 70, 80, 23);

        jUk.setText("Unit Kerja :");
        FormInput.add(jUk);
        jUk.setBounds(10, 100, 95, 23);
        FormInput.add(TNa);
        TNa.setBounds(110, 70, 210, 23);
        FormInput.add(TUk);
        TUk.setBounds(110, 100, 170, 23);

        CmbJk.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        CmbJk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "lakilaki", "perempuan" }));
        CmbJk.setBorder(new com.formdev.flatlaf.ui.FlatTextBorder());
        CmbJk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbJkActionPerformed(evt);
            }
        });
        FormInput.add(CmbJk);
        CmbJk.setBounds(420, 130, 180, 23);
        FormInput.add(TnL);
        TnL.setBounds(110, 10, 210, 23);

        jNik.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jNik.setText("NIK :");
        FormInput.add(jNik);
        jNik.setBounds(80, 40, 30, 23);

        jNoHp.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jNoHp.setText("No. HP :");
        FormInput.add(jNoHp);
        jNoHp.setBounds(340, 10, 50, 23);
        FormInput.add(TNik);
        TNik.setBounds(110, 40, 210, 23);

        jNip.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jNip.setText("NIP :");
        FormInput.add(jNip);
        jNip.setBounds(80, 130, 24, 23);
        FormInput.add(TNoHp);
        TNoHp.setBounds(390, 10, 210, 23);
        FormInput.add(TEmail);
        TEmail.setBounds(390, 40, 210, 23);
        FormInput.add(TAlamat);
        TAlamat.setBounds(390, 70, 210, 23);

        jnL.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jnL.setText("Nama Lengkap :");
        FormInput.add(jnL);
        jnL.setBounds(27, 10, 80, 23);

        jEmail.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jEmail.setText("Email :");
        FormInput.add(jEmail);
        jEmail.setBounds(348, 40, 40, 23);

        jAgama.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jAgama.setText("Agama :");
        FormInput.add(jAgama);
        jAgama.setBounds(340, 100, 50, 23);

        TNip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TNipActionPerformed(evt);
            }
        });
        FormInput.add(TNip);
        TNip.setBounds(110, 130, 210, 23);

        TAgama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TAgamaActionPerformed(evt);
            }
        });
        FormInput.add(TAgama);
        TAgama.setBounds(390, 100, 210, 23);

        jJK.setText("Jenis Kelamin :");
        FormInput.add(jJK);
        jJK.setBounds(340, 130, 70, 23);

        tanggalKeluar.setBorder(new com.formdev.flatlaf.ui.FlatMenuItemBorder());
        FormInput.add(tanggalKeluar);
        tanggalKeluar.setBounds(700, 70, 120, 23);

        jTL.setText("Tanggal Lahir :");
        FormInput.add(jTL);
        jTL.setBounds(610, 10, 80, 23);

        tanggalLahir.setBorder(new com.formdev.flatlaf.ui.FlatMenuItemBorder());
        FormInput.add(tanggalLahir);
        tanggalLahir.setBounds(700, 10, 120, 23);

        jTM.setText("Tanggal Masuk :");
        FormInput.add(jTM);
        jTM.setBounds(610, 40, 80, 23);

        tanggalMasuk.setBorder(new com.formdev.flatlaf.ui.FlatMenuItemBorder());
        FormInput.add(tanggalMasuk);
        tanggalMasuk.setBounds(700, 40, 120, 23);

        jAlamat.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jAlamat.setText("Alamat :");
        FormInput.add(jAlamat);
        jAlamat.setBounds(340, 70, 50, 23);

        BtnCariUnitKerja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        BtnCariUnitKerja.setMnemonic('1');
        BtnCariUnitKerja.setToolTipText("ALt+1");
        BtnCariUnitKerja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCariUnitKerjaActionPerformed(evt);
            }
        });
        FormInput.add(BtnCariUnitKerja);
        BtnCariUnitKerja.setBounds(290, 100, 28, 23);

        jStatus.setText("Status :");
        FormInput.add(jStatus);
        jStatus.setBounds(620, 100, 70, 23);

        CmbStatus.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        CmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aktif", "Tidak Aktif" }));
        CmbStatus.setBorder(new com.formdev.flatlaf.ui.FlatTextBorder());
        CmbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CmbStatusActionPerformed(evt);
            }
        });
        FormInput.add(CmbStatus);
        CmbStatus.setBounds(700, 100, 120, 23);

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
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_tbAnggotaMouseClicked

    private void tbAnggotaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbAnggotaKeyReleased
        if(tabMode.getRowCount()!=0){
            if((evt.getKeyCode()==KeyEvent.VK_ENTER)||(evt.getKeyCode()==KeyEvent.VK_UP)||(evt.getKeyCode()==KeyEvent.VK_DOWN)){
                try {
                    getData();
                } catch (java.lang.NullPointerException e) {
                    System.out.println(e);
                }
            }
        }
    }//GEN-LAST:event_tbAnggotaKeyReleased

    private void BtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpanActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        try {
            String URL = koneksi.HOST() + "/api/v1/members/register";
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
            requestData.put("nomor_anggota", TNa.getText());
            requestData.put("nama_lengkap", TnL.getText());
            requestData.put("nik", TNik.getText());
            requestData.put("email", TEmail.getText());
            requestData.put("phone", TNoHp.getText());
            requestData.put("alamat", TAlamat.getText());
            requestData.put("tanggal_lahir", new SimpleDateFormat("yyyy-MM-dd").format(this.tanggalLahir.getDate()));
            requestData.put("jenis_kelamin", CmbJk.getSelectedItem().toString());
            requestData.put("agama", TAgama.getText());
            requestData.put("nip", TNip.getText());
            requestData.put("tanggal_masuk", new SimpleDateFormat("yyyy-MM-dd").format(this.tanggalMasuk.getDate()));
            requestData.put("tanggal_keluar", new SimpleDateFormat("yyyy-MM-dd").format(this.tanggalKeluar.getDate()));
            requestData.put("status", CmbStatus.getSelectedItem().toString().equals("Aktif"));
            requestData.put("work_unit_id", idunitkerja);

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
                emptTeks();
                tampil("", cmbCrJk.getSelectedItem().toString(), cmbCrJumlahdata.getSelectedItem().toString(), keywordidunitkerja, cmbCrStatus.getSelectedItem().toString());
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
        if(tbAnggota.getSelectedRow() != -1){
            String idMember = tbAnggota.getValueAt(tbAnggota.getSelectedRow(),0).toString();
            try {
                String URL = koneksi.HOST() + "/api/v1/members/" + idMember;
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
                    tampil("", cmbCrJk.getSelectedItem().toString(), cmbCrJumlahdata.getSelectedItem().toString(), keywordidunitkerja, cmbCrStatus.getSelectedItem().toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Gagal hapus data");
                }

            } catch (JsonProcessingException | RestClientException e) {
                System.out.println(e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Silahkan pilih data terlebih dahulu");
        }
        setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_BtnHapusActionPerformed

    private void BtnHapusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnHapusKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnHapusActionPerformed(null);
        }
    }//GEN-LAST:event_BtnHapusKeyPressed

    private void BtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        if(tbAnggota.getSelectedRow() != -1){
            String idMember = tbAnggota.getValueAt(tbAnggota.getSelectedRow(),0).toString();
            String selectedUnitKerja = tbAnggota.getValueAt(tbAnggota.getSelectedRow(), 4).toString();
            if (idunitkerja == null || idunitkerja.equals(selectedUnitKerja)) {
                idunitkerja = selectedUnitKerja;
            }
            try {
                String URL = koneksi.HOST() + "/api/v1/members/" + idMember;
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
                
                // Data Anggota
                Map<String, Object> requestData = new HashMap<>();
                requestData.put("nomor_anggota", TNa.getText());
                requestData.put("nama_lengkap", TnL.getText());
                requestData.put("nik", TNik.getText());
                requestData.put("email", TEmail.getText());
                requestData.put("phone", TNoHp.getText());
                requestData.put("alamat", TAlamat.getText());
                requestData.put("tanggal_lahir", new SimpleDateFormat("yyyy-MM-dd").format(this.tanggalLahir.getDate()));
                requestData.put("jenis_kelamin", CmbJk.getSelectedItem().toString());
                requestData.put("agama", TAgama.getText());
                requestData.put("nip", TNip.getText());
                requestData.put("tanggal_masuk", new SimpleDateFormat("yyyy-MM-dd").format(this.tanggalMasuk.getDate()));
                requestData.put("tanggal_keluar", new SimpleDateFormat("yyyy-MM-dd").format(this.tanggalKeluar.getDate()));
                requestData.put("status", CmbStatus.getSelectedItem().toString().equals("Aktif"));
                requestData.put("work_unit_id", idunitkerja);

                // Konversi Map ke JSON String menggunakan ObjectMapper
                ObjectMapper objectMapper = new ObjectMapper();
                String requestJsonAnggota = objectMapper.writeValueAsString(requestData);

                    // Request menggunakan RestTemplate
                RestTemplate restAnggota = new RestTemplate();
                HttpEntity<String> entity = new HttpEntity<>(requestJsonAnggota, headers);
                ResponseEntity<String> response = restAnggota.exchange(URL, HttpMethod.PUT, entity, String.class);

                if (response.getStatusCode() == HttpStatus.OK) {
                    JsonNode root = objectMapper.readTree(response.getBody());
                    JOptionPane.showMessageDialog(null, root.path("message").asText());
                    tabMode.setRowCount(0);
                    tampil("", cmbCrJk.getSelectedItem().toString(), cmbCrJumlahdata.getSelectedItem().toString(), keywordidunitkerja, cmbCrStatus.getSelectedItem().toString());
                } else {
                    JOptionPane.showMessageDialog(null, "Gagal edit data data");
                }

            } catch (JsonProcessingException | RestClientException e) {
                System.out.println(e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Silahkan pilih data terlebih dahulu");
        }
        setCursor(Cursor.getDefaultCursor());
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
        cmbCrJk.setSelectedIndex(0);
        cmbCrStatus.setSelectedIndex(0);
        TCari.setText("");
        TCariUk.setText("");
        keywordidunitkerja = "";
        tampil("", cmbCrJk.getSelectedItem().toString(), cmbCrJumlahdata.getSelectedItem().toString(), keywordidunitkerja, cmbCrStatus.getSelectedItem().toString());
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
        if(!TCari.getText().trim().equals("")){
            tampil(TCari.getText().trim(), cmbCrJk.getSelectedItem().toString(), cmbCrJumlahdata.getSelectedItem().toString(), keywordidunitkerja, cmbCrStatus.getSelectedItem().toString());
        } else {
            tampil("", cmbCrJk.getSelectedItem().toString(), cmbCrJumlahdata.getSelectedItem().toString(), keywordidunitkerja, cmbCrStatus.getSelectedItem().toString());
        }
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
        tampil("", cmbCrJk.getSelectedItem().toString(), cmbCrJumlahdata.getSelectedItem().toString(), keywordidunitkerja, cmbCrStatus.getSelectedItem().toString());
    }//GEN-LAST:event_formWindowOpened

    private void CmbJkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbJkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CmbJkActionPerformed

    private void cmbCrJkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCrJkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCrJkActionPerformed

    private void TNipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TNipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TNipActionPerformed

    private void TAgamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TAgamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TAgamaActionPerformed

    private void BtnCariUnitKerjaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCariUnitKerjaActionPerformed
        cariunitkerja.emptTeks();
        cariunitkerja.setSize(internalFrame1.getWidth()-20,internalFrame1.getHeight()-20);
        cariunitkerja.setLocationRelativeTo(internalFrame1);
        cariunitkerja.setAlwaysOnTop(false);
        cariunitkerja.setVisible(true);
    }//GEN-LAST:event_BtnCariUnitKerjaActionPerformed

    private void CmbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CmbStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CmbStatusActionPerformed

    private void cmbCrJumlahdataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCrJumlahdataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCrJumlahdataActionPerformed

    private void BtnCariUnitKerjaTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCariUnitKerjaTableActionPerformed
        // TODO add your handling code here:
        cariunitkerjakeyword.emptTeks();
        cariunitkerjakeyword.setSize(internalFrame1.getWidth()-20,internalFrame1.getHeight()-20);
        cariunitkerjakeyword.setLocationRelativeTo(internalFrame1);
        cariunitkerjakeyword.setAlwaysOnTop(false);
        cariunitkerjakeyword.setVisible(true);
    }//GEN-LAST:event_BtnCariUnitKerjaTableActionPerformed

    private void cmbCrStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCrStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCrStatusActionPerformed

    public void emptTeks() {
        CmbJk.setSelectedIndex(0);
        CmbStatus.setSelectedIndex(0);
        TnL.setText("");
        TNik.setText("");
        TNa.setText("");
        TUk.setText("");
        TNip.setText("");
        TNoHp.setText("");
        TEmail.setText("");
        TAlamat.setText("");
        TAgama.setText("");
        tanggalMasuk.setDate(new Date());
        tanggalKeluar.setDate(new Date());
        tanggalLahir.setDate(new Date());
    }
    
    private void isForm(){
        if(ChkInput.isSelected()==true){
            ChkInput.setVisible(false);
            PanelInput.setPreferredSize(new Dimension(WIDTH,190));
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
            CmbJk.setSelectedItem(tbAnggota.getValueAt(row,11).toString());
            CmbStatus.setSelectedItem(tbAnggota.getValueAt(row,14).toString());
            TnL.setText(tbAnggota.getValueAt(row,3).toString());
            TNik.setText(tbAnggota.getValueAt(row,6).toString());
            TNa.setText(tbAnggota.getValueAt(row,2).toString());
            TUk.setText(tbAnggota.getValueAt(row,5).toString());
            TNip.setText(tbAnggota.getValueAt(row,13).toString());
            TNoHp.setText(tbAnggota.getValueAt(row,8).toString());
            TEmail.setText(tbAnggota.getValueAt(row,7).toString());
            TAlamat.setText(tbAnggota.getValueAt(row,9).toString());
            TAgama.setText(tbAnggota.getValueAt(row,12).toString());
             // Format tanggal yang digunakan dalam tabel (sesuaikan dengan format yang ada)
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            try {
                // Konversi String ke Date
                Date masukDate = dateFormat.parse(tbAnggota.getValueAt(row, 15).toString()); // Sesuaikan kolom tabel
                Date keluarDate = dateFormat.parse(tbAnggota.getValueAt(row, 16).toString());
                Date lahirDate = dateFormat.parse(tbAnggota.getValueAt(row, 10).toString());

                // Set nilai ke JXDatePicker
                tanggalMasuk.setDate(masukDate);
                tanggalKeluar.setDate(keluarDate);
                tanggalLahir.setDate(lahirDate);
            } catch (ParseException e) {
                System.out.println("Format tanggal salah: " + e.getMessage());
            }
        }
    }
     
    private void tampil(String cari, String jk, String perpage, String workunitid, String status) {
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        if("Aktif".equals(status)) {
            status = "1";
        } else if ("Tidak Aktif".equals(status)) {
            status = "0";
        }
        try {
            String URL = koneksi.HOST() + "/api/v1/members?search=" + cari + "&jenis_kelamin=" + jk + "&per_page=" + perpage + "&work_unit_id=" + workunitid + "&status=" + status;
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
            ResponseEntity<String> response = restTemplate.exchange(URL, HttpMethod.GET, entity, String.class);
            
            // Parsing JSON ke dalam tabel
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(response.getBody());
            
            tabMode.setRowCount(0); // Hapus data lama

            System.out.println(rootNode);
            String statusMember;
            JsonNode dataArray = rootNode.path("data");

            if (dataArray.isArray()) {
                for (JsonNode member : dataArray) {
                    String id = member.path("id").asText();
                    String username = member.path("username").asText();
                    String nomorAnggota = member.path("nomor_anggota").asText();
                    String namaLengkap = member.path("nama_lengkap").asText();
                    String unitKerja = member.path("work_unit").asText();
                    String idunitKerja = member.path("work_unit_id").asText();
                    String nik = member.path("nik").asText();
                    String email = member.path("email").asText();
                    String phone = member.path("phone").asText();
                    String alamat = member.path("alamat").asText();
                    String tanggallahir = member.path("tanggal_lahir").asText();
                    String jenisKelamin = member.path("jenis_kelamin").asText();
                    String agama = member.path("agama").asText();
                    String nip = member.path("nip").asText();
                    if(member.path("status").asText().equals("1")){
                        statusMember = "Aktif";
                    } else {
                        statusMember = "Tidak Aktif";
                    }
                    String tanggalmasuk = member.path("tanggal_masuk").asText();
                    String tanggalkeluar = member.path("tanggal_keluar").asText();

                    // Tambahkan data ke tabel
                    tabMode.addRow(new Object[]{id, username, nomorAnggota, namaLengkap, idunitKerja, unitKerja, nik, email, phone, alamat, tanggallahir, jenisKelamin, agama, nip, statusMember, tanggalmasuk, tanggalkeluar});
                }
            }

        } catch (JsonProcessingException | RestClientException e) {
            System.out.println(e);
        } finally{
        }
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
    private widget.Button BtnCariUnitKerja;
    private widget.Button BtnCariUnitKerjaTable;
    private widget.Button BtnEdit;
    private widget.Button BtnHapus;
    private widget.Button BtnKeluar;
    private widget.Button BtnPrint;
    private widget.Button BtnSimpan;
    private widget.CekBox ChkInput;
    private javax.swing.JComboBox<String> CmbJk;
    private javax.swing.JComboBox<String> CmbStatus;
    private widget.PanelBiasa FormInput;
    private widget.Label LCount;
    private javax.swing.JPanel PanelInput;
    private widget.ScrollPane Scroll;
    private javax.swing.JTextField TAgama;
    private javax.swing.JTextField TAlamat;
    private javax.swing.JTextField TCari;
    private javax.swing.JTextField TCariUk;
    private javax.swing.JTextField TEmail;
    private javax.swing.JTextField TNa;
    private javax.swing.JTextField TNik;
    private javax.swing.JTextField TNip;
    private javax.swing.JTextField TNoHp;
    private javax.swing.JTextField TUk;
    private javax.swing.JTextField TnL;
    private javax.swing.JComboBox<String> cmbCrJk;
    private javax.swing.JComboBox<String> cmbCrJumlahdata;
    private javax.swing.JComboBox<String> cmbCrStatus;
    private widget.InternalFrame internalFrame1;
    private javax.swing.JLabel jAgama;
    private javax.swing.JLabel jAlamat;
    private javax.swing.JLabel jEmail;
    private widget.Label jJK;
    private widget.Label jLabel10;
    private widget.Label jLabel14;
    private widget.Label jLabel16;
    private widget.Label jLabel6;
    private widget.Label jLabel7;
    private widget.Label jLabel8;
    private widget.Label jNa;
    private javax.swing.JLabel jNik;
    private javax.swing.JLabel jNip;
    private javax.swing.JLabel jNoHp;
    private javax.swing.JPanel jPanel3;
    private widget.Label jStatus;
    private widget.Label jTK;
    private widget.Label jTL;
    private widget.Label jTM;
    private widget.Label jUk;
    private javax.swing.JLabel jnL;
    private widget.panelisi panelGlass8;
    private widget.panelisi panelGlass9;
    private widget.Tanggal tanggalKeluar;
    private widget.Tanggal tanggalLahir;
    private widget.Tanggal tanggalMasuk;
    private widget.Table tbAnggota;
    // End of variables declaration//GEN-END:variables
}
