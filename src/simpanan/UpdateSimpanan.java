/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package simpanan;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import fungsi.WarnaTable;
import fungsi.koneksi;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import org.springframework.http.HttpStatus;
import unitkerja.CariUnitKerja;

/**
 *
 * @author Lenovo
 */
public class UpdateSimpanan extends javax.swing.JDialog {
    private final DefaultTableModel tabMode;
    private CariUnitKerja cariunitkerja=new CariUnitKerja(null,false);
    private String updateUnitKerja="0";
    /**
     * Creates new form Anggota
     * @param parent
     * @param modal
     */
    public UpdateSimpanan(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        this.setLocation(8,1);
        setSize(885,674);
        
        Object[] row={"Unit Kerja ID","Unit Kerja","ID Anggota", "Nomor Anggota", "Nama Anggota", "Tahun"};
        tabMode=new DefaultTableModel(null,row){
              @Override public boolean isCellEditable(int rowIndex, int colIndex){return false;}
        };
        tbUnitKerja.setModel(tabMode);
        //tbPenyakit.setDefaultRenderer(Object.class, new WarnaTable(panelJudul.getBackground(),tbPenyakit.getBackground()));
        tbUnitKerja.setPreferredScrollableViewportSize(new Dimension(800,800));
        tbUnitKerja.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (int i = 0; i < 6; i++) {
            TableColumn column = tbUnitKerja.getColumnModel().getColumn(i);
            switch (i) {
                case 0 -> {
                    column.setMinWidth(0);
                    column.setMaxWidth(0);
                    column.setWidth(0);
                    column.setPreferredWidth(0);
                }
                case 1 -> column.setPreferredWidth(170);
                case 2 -> {
                    column.setMinWidth(0);
                    column.setMaxWidth(0);
                    column.setWidth(0);
                    column.setPreferredWidth(0);
                }
                case 3 -> column.setPreferredWidth(170);
                case 4 -> column.setPreferredWidth(170);
                case 5 -> column.setPreferredWidth(170);
                default -> {
                }
            }
        }
        
        ChkInput.setSelected(true);
        tbUnitKerja.setDefaultRenderer(Object.class, new WarnaTable());
        isForm();
        
        cariunitkerja.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {}
            @Override
            public void windowClosing(WindowEvent e) {}
            @Override
            public void windowClosed(WindowEvent e) {
                if(cariunitkerja.getTable().getSelectedRow()!= -1){                   
                    TUnitKerja.setText(cariunitkerja.tbUnitKerja.getValueAt(cariunitkerja.tbUnitKerja.getSelectedRow(),1).toString());
                    updateUnitKerja = cariunitkerja.tbUnitKerja.getValueAt(cariunitkerja.tbUnitKerja.getSelectedRow(),0).toString();
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
        tbUnitKerja = new widget.Table();
        jPanel3 = new javax.swing.JPanel();
        panelGlass8 = new widget.panelisi();
        BtnSimpan = new widget.Button();
        BtnBatal = new widget.Button();
        BtnHapus = new widget.Button();
        BtnPrint = new widget.Button();
        BtnAll = new widget.Button();
        jLabel10 = new widget.Label();
        LCount = new widget.Label();
        BtnKeluar = new widget.Button();
        panelGlass9 = new widget.panelisi();
        jLabel16 = new widget.Label();
        cmbCrJumlahdata = new javax.swing.JComboBox<>();
        jLabel6 = new widget.Label();
        TCari = new javax.swing.JTextField();
        BtnCari = new widget.Button();
        PanelInput = new javax.swing.JPanel();
        FormInput = new widget.PanelBiasa();
        TTahun = new javax.swing.JTextField();
        jkd = new javax.swing.JLabel();
        TNomorAnggota = new javax.swing.JTextField();
        jkd1 = new javax.swing.JLabel();
        TNamaAnggota = new javax.swing.JTextField();
        jkd3 = new javax.swing.JLabel();
        TUnitKerja = new javax.swing.JTextField();
        BtnCariUnitKerja = new widget.Button();
        jkd4 = new javax.swing.JLabel();
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

        internalFrame1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 245, 235)), "::[ Update Simpanan ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(50, 50, 50))); // NOI18N
        internalFrame1.setLayout(new java.awt.BorderLayout(1, 1));

        Scroll.setOpaque(true);

        tbUnitKerja.setAutoCreateRowSorter(true);
        tbUnitKerja.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        tbUnitKerja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbUnitKerjaMouseClicked(evt);
            }
        });
        tbUnitKerja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbUnitKerjaKeyReleased(evt);
            }
        });
        Scroll.setViewportView(tbUnitKerja);

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
        cmbCrJumlahdata.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "25", "50", "100", "1000" }));
        cmbCrJumlahdata.setBorder(new com.formdev.flatlaf.ui.FlatTextBorder());
        cmbCrJumlahdata.setMinimumSize(new java.awt.Dimension(94, 23));
        cmbCrJumlahdata.setPreferredSize(new java.awt.Dimension(96, 23));
        cmbCrJumlahdata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCrJumlahdataActionPerformed(evt);
            }
        });
        panelGlass9.add(cmbCrJumlahdata);

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
        PanelInput.setPreferredSize(new java.awt.Dimension(850, 130));
        PanelInput.setLayout(new java.awt.BorderLayout(1, 1));

        FormInput.setPreferredSize(new java.awt.Dimension(850, 137));
        FormInput.setLayout(null);
        FormInput.add(TTahun);
        TTahun.setBounds(110, 10, 120, 23);

        jkd.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jkd.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jkd.setText("Tahun :");
        FormInput.add(jkd);
        jkd.setBounds(40, 10, 60, 23);
        FormInput.add(TNomorAnggota);
        TNomorAnggota.setBounds(340, 10, 200, 23);

        jkd1.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jkd1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jkd1.setText("Nomor Anggota :");
        FormInput.add(jkd1);
        jkd1.setBounds(240, 10, 90, 23);
        FormInput.add(TNamaAnggota);
        TNamaAnggota.setBounds(110, 70, 430, 23);

        jkd3.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jkd3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jkd3.setText("Unit Kerja :");
        FormInput.add(jkd3);
        jkd3.setBounds(10, 40, 90, 23);
        FormInput.add(TUnitKerja);
        TUnitKerja.setBounds(110, 40, 390, 23);

        BtnCariUnitKerja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        BtnCariUnitKerja.setMnemonic('1');
        BtnCariUnitKerja.setToolTipText("ALt+1");
        BtnCariUnitKerja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCariUnitKerjaActionPerformed(evt);
            }
        });
        FormInput.add(BtnCariUnitKerja);
        BtnCariUnitKerja.setBounds(510, 40, 28, 23);

        jkd4.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jkd4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jkd4.setText("Nama Anggota :");
        FormInput.add(jkd4);
        jkd4.setBounds(10, 70, 90, 23);

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

    private void tbUnitKerjaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbUnitKerjaMouseClicked
        if(tabMode.getRowCount()!=0){
            try {
               getData();
            } catch (java.lang.NullPointerException e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_tbUnitKerjaMouseClicked

    private void tbUnitKerjaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbUnitKerjaKeyReleased
        if(tabMode.getRowCount()!=0){
            if((evt.getKeyCode()==KeyEvent.VK_ENTER)||(evt.getKeyCode()==KeyEvent.VK_UP)||(evt.getKeyCode()==KeyEvent.VK_DOWN)){
                try {
                    getData();
                } catch (java.lang.NullPointerException e) {
                    System.out.println(e);
                }
            }
        }
    }//GEN-LAST:event_tbUnitKerjaKeyReleased

    private void BtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpanActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        if(tbUnitKerja.getSelectedRow() != -1){
            try {
                String URL = koneksi.HOST() + "/api/v1/savings/"+TTahun.getText()+"/transfer-work-unit/"+tbUnitKerja.getValueAt(tbUnitKerja.getSelectedRow(),2).toString();
                System.out.println("Request ke: " + URL);

                // Ambil token dari Preferences
                Preferences prefs = Preferences.userRoot().node("myApp");
                String token = prefs.get("auth_token", null);

                if (token == null) {
                    System.out.println("Token tidak ditemukan! Harap login terlebih dahulu.");
                    return;
                }
                
                // Data Anggota
                Map<String, Object> requestData = new HashMap<>();
                requestData.put("work_unit_id", updateUnitKerja);

                // Konversi Map ke JSON String
                ObjectMapper objectMapper = new ObjectMapper();
                String requestJsonAnggota = objectMapper.writeValueAsString(requestData);                
                

                // Menggunakan HttpClient
                HttpClient httpClient = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(URL))
                        .header("Content-Type", "application/json")
                        .header("Accept", "application/json")
                        .header("Authorization", "Bearer " + token)
                        .method("PATCH", HttpRequest.BodyPublishers.ofString(requestJsonAnggota))
                        .build();

                HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
                
                System.out.println(response.body());
                System.out.println(requestJsonAnggota);

                if (response.statusCode() == 200) {
                    JsonNode root = objectMapper.readTree(response.body());
                    JOptionPane.showMessageDialog(null, root.path("message").asText());
                    tabMode.setRowCount(0);
                    tampil("",TTahun.getText(),cmbCrJumlahdata.getSelectedItem().toString());
                } else {
                    JsonNode root = objectMapper.readTree(response.body());
                    JOptionPane.showMessageDialog(null, root.path("errors").asText());
                }

            } catch (JsonProcessingException e) {
                JOptionPane.showMessageDialog(null, "Kesalahan dalam pemrosesan data: " + e.getMessage());
                System.err.println("JSON Processing Error: " + e.getMessage());
            } catch (IOException | InterruptedException e) {
                JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat menghubungi server: " + e.getMessage());
                System.err.println("Error saat melakukan request: " + e.getMessage());
            } finally {
                this.setCursor(Cursor.getDefaultCursor());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Silahkan pilih data terlebih dahulu");
        }
        setCursor(Cursor.getDefaultCursor());
        updateUnitKerja="0";
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
        if(tbUnitKerja.getSelectedRow() != -1){
            String idmember = tbUnitKerja.getValueAt(tbUnitKerja.getSelectedRow(),2).toString();
            try {
                String URL = koneksi.HOST() + "/api/v1/savings/"+TTahun.getText()+"/member/"+idmember;
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
                    tampil("",TTahun.getText(),cmbCrJumlahdata.getSelectedItem().toString());
                    emptTeks();
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

    private void BtnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPrintActionPerformed

    }//GEN-LAST:event_BtnPrintActionPerformed

    private void BtnPrintKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnPrintKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnPrintActionPerformed(null);
        }
    }//GEN-LAST:event_BtnPrintKeyPressed

    private void BtnAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAllActionPerformed
        TCari.setText("");
        tampil("",TTahun.getText(),cmbCrJumlahdata.getSelectedItem().toString());
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
            tampil(TCari.getText(),TTahun.getText(),cmbCrJumlahdata.getSelectedItem().toString());
        } else {
            tampil("",TTahun.getText(),cmbCrJumlahdata.getSelectedItem().toString());
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
        tampil(TCari.getText(),TTahun.getText(),cmbCrJumlahdata.getSelectedItem().toString());
    }//GEN-LAST:event_formWindowOpened

    private void cmbCrJumlahdataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCrJumlahdataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCrJumlahdataActionPerformed

    private void BtnCariUnitKerjaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCariUnitKerjaActionPerformed
        cariunitkerja.emptTeks();
        cariunitkerja.setSize(internalFrame1.getWidth()-20,internalFrame1.getHeight()-20);
        cariunitkerja.setLocationRelativeTo(internalFrame1);
        cariunitkerja.setAlwaysOnTop(false);
        cariunitkerja.setVisible(true);
    }//GEN-LAST:event_BtnCariUnitKerjaActionPerformed

    public void setUpdateSimpanan(String tahun) {
        // Mengatur nilai ke JTextField sesuai dengan parameter JSON
        TTahun.setText(tahun);
        isForm();
        tampil(TCari.getText(),TTahun.getText(),cmbCrJumlahdata.getSelectedItem().toString());
    }
    
    public void emptTeks() {
        TNamaAnggota.setText("");
        TNomorAnggota.setText("");
        TUnitKerja.setText("");
    }
    
    private void isForm(){
        if(ChkInput.isSelected()==true){
            ChkInput.setVisible(false);
            PanelInput.setPreferredSize(new Dimension(WIDTH,130));
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
        int row=tbUnitKerja.getSelectedRow();
        if(row!= -1){
            TUnitKerja.setText(tbUnitKerja.getValueAt(row,1).toString());
            TNomorAnggota.setText(tbUnitKerja.getValueAt(row,3).toString());
            TNamaAnggota.setText(tbUnitKerja.getValueAt(row,4).toString());
        }
    }
     
    private void tampil(String cari, String tahun, String jumlahData) {
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        try {
            String URL = koneksi.HOST() + "/api/v1/savings?tahun=" + tahun + "&per_page=" + jumlahData + "&search=" + cari;
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
                    String idworkunit = member.path("work_unit_id").asText();
                    String namaworkunit = member.path("work_unit").asText();
                    String memberid = member.path("member_profile_id").asText();
                    String nomoranggota = member.path("nomor_anggota").asText();
                    String namalengkap = member.path("nama_lengkap").asText();
                    String tahunSimpanan = member.path("tahun").asText();

                    // Tambahkan data ke tabel
                    tabMode.addRow(new Object[]{idworkunit ,namaworkunit, memberid, nomoranggota, namalengkap, tahunSimpanan});
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
    private widget.Button BtnHapus;
    private widget.Button BtnKeluar;
    private widget.Button BtnPrint;
    private widget.Button BtnSimpan;
    private widget.CekBox ChkInput;
    private widget.PanelBiasa FormInput;
    private widget.Label LCount;
    private javax.swing.JPanel PanelInput;
    private widget.ScrollPane Scroll;
    private javax.swing.JTextField TCari;
    private javax.swing.JTextField TNamaAnggota;
    private javax.swing.JTextField TNomorAnggota;
    private javax.swing.JTextField TTahun;
    private javax.swing.JTextField TUnitKerja;
    private javax.swing.JComboBox<String> cmbCrJumlahdata;
    private widget.InternalFrame internalFrame1;
    private widget.Label jLabel10;
    private widget.Label jLabel16;
    private widget.Label jLabel6;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel jkd;
    private javax.swing.JLabel jkd1;
    private javax.swing.JLabel jkd3;
    private javax.swing.JLabel jkd4;
    private widget.panelisi panelGlass8;
    private widget.panelisi panelGlass9;
    private widget.Table tbUnitKerja;
    // End of variables declaration//GEN-END:variables
}
