/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package bakoperasi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import fungsi.koneksi;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.springframework.http.HttpEntity;
import simpanan.Simpanan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import javax.swing.SwingWorker;
import org.springframework.web.client.HttpClientErrorException;
import tagihan.Tagihan;
import anggota.Anggota;
import java.awt.Window;
import javax.swing.JDialog;
import javax.swing.UIManager;
import unitkerja.UnitKerja;

/**
 *
 * @author Lenovo
 */
public class frmUtama extends javax.swing.JFrame {
     private int jmlmenu=0,grid=0,tinggi=0,i=0,menuawal=0;
      private String URL="",requestJson="";
      private ObjectMapper mapper = new ObjectMapper();
      private HttpEntity requestEntity;
      private JsonNode root;
    /**
     * Creates new form frmUtama
     */
    public frmUtama() {
        initComponents();
        initBekoperasi();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        BtnMenu.setVisible(false);
        DlgLogin.setSize(299,180);
        DlgLogin.setVisible(false);
        DlgLogin.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DlgLogin = new javax.swing.JDialog();
        internalFrame2 = new widget.InternalFrame();
        internalFrame3 = new widget.InternalFrame();
        panelGlass1 = new usu.widget.glass.PanelGlass();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        edAdmin = new javax.swing.JPasswordField();
        edPwd = new javax.swing.JPasswordField();
        BtnLogin = new widget.Button();
        BtnCancel = new widget.Button();
        DlgHome = new javax.swing.JDialog();
        panelMenu = new widget.InternalFrame();
        panelisi2 = new widget.panelisi();
        label36 = new widget.Label();
        button1 = new widget.Button();
        label35 = new widget.Label();
        TCari = new widget.TextBox();
        scrollPane2 = new widget.ScrollPane();
        Panelmenu = new widget.panelGlass();
        btnSimpanan = new widget.ButtonBig();
        btnTagihan = new widget.ButtonBig();
        btnAnggota = new widget.ButtonBig();
        btnUnitKerja = new widget.ButtonBig();
        internalFrame1 = new widget.InternalFrame();
        BtnMenu = new widget.ButtonBig();
        BtnLog = new widget.ButtonBig();
        BtnClose = new widget.ButtonBig();
        internalFrame4 = new widget.InternalFrame();
        jLabel7 = new javax.swing.JLabel();
        PanelUtama = new javax.swing.JPanel();
        PanelWall = new usu.widget.glass.PanelGlass();
        panelJudul = new usu.widget.glass.PanelGlass();
        jLabel8 = new javax.swing.JLabel();

        DlgLogin.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        DlgLogin.setUndecorated(true);
        DlgLogin.setResizable(false);

        internalFrame2.setBorder(null);
        internalFrame2.setWarnaAtas(new java.awt.Color(153, 255, 204));
        internalFrame2.setWarnaBawah(new java.awt.Color(102, 255, 204));
        internalFrame2.setLayout(null);

        internalFrame3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), ":: Silahkan Anda Login ::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 11), new java.awt.Color(50, 50, 50))); // NOI18N
        internalFrame3.setRequestFocusEnabled(false);
        internalFrame3.setLayout(null);

        panelGlass1.setBackground(java.awt.Color.red);
        panelGlass1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(185, 185, 110)));
        panelGlass1.setOpaqueImage(false);
        panelGlass1.setRound(false);
        panelGlass1.setWarna(new java.awt.Color(153, 255, 204));
        panelGlass1.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(50, 50, 50));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("ID Admin :");
        panelGlass1.add(jLabel4);
        jLabel4.setBounds(2, 12, 75, 23);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(50, 50, 50));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Password :");
        panelGlass1.add(jLabel5);
        jLabel5.setBounds(2, 40, 75, 23);

        edAdmin.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        edAdmin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        panelGlass1.add(edAdmin);
        edAdmin.setBounds(80, 10, 200, 23);

        edPwd.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        edPwd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        panelGlass1.add(edPwd);
        edPwd.setBounds(80, 40, 200, 23);

        internalFrame3.add(panelGlass1);
        panelGlass1.setBounds(-1, 25, 342, 76);

        BtnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/lock.png"))); // NOI18N
        BtnLogin.setMnemonic('Z');
        BtnLogin.setText("Log-in");
        BtnLogin.setToolTipText("Alt+Z");
        BtnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLoginActionPerformed(evt);
            }
        });
        internalFrame3.add(BtnLogin);
        BtnLogin.setBounds(12, 110, 105, 32);

        BtnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/exit.png"))); // NOI18N
        BtnCancel.setMnemonic('Y');
        BtnCancel.setText("Batal");
        BtnCancel.setToolTipText("Alt+Y");
        BtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelActionPerformed(evt);
            }
        });
        internalFrame3.add(BtnCancel);
        BtnCancel.setBounds(177, 110, 105, 32);

        internalFrame2.add(internalFrame3);
        internalFrame3.setBounds(2, 12, 295, 155);

        DlgLogin.getContentPane().add(internalFrame2, java.awt.BorderLayout.CENTER);

        DlgHome.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        DlgHome.setAlwaysOnTop(true);
        DlgHome.setBackground(new java.awt.Color(255, 253, 253));
        DlgHome.setIconImage(null);
        DlgHome.setUndecorated(true);
        DlgHome.setResizable(false);

        panelMenu.setBackground(new java.awt.Color(255, 253, 253));
        panelMenu.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(223, 233, 213)), "::[ Menu Utama ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(50, 50, 50))); // NOI18N
        panelMenu.setPreferredSize(new java.awt.Dimension(2412, 3653));
        panelMenu.setWarnaAtas(new java.awt.Color(255, 252, 252));
        panelMenu.setWarnaBawah(new java.awt.Color(255, 252, 252));
        panelMenu.setLayout(new java.awt.BorderLayout(1, 1));

        panelisi2.setBackground(new java.awt.Color(255, 253, 253));
        panelisi2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 240, 230)));
        panelisi2.setPreferredSize(new java.awt.Dimension(100, 40));
        panelisi2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 7));

        label36.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        label36.setPreferredSize(new java.awt.Dimension(1, 23));
        panelisi2.add(label36);

        button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/exit.png"))); // NOI18N
        button1.setGlassColor(new java.awt.Color(255, 255, 255));
        button1.setMinimumSize(new java.awt.Dimension(28, 23));
        button1.setPreferredSize(new java.awt.Dimension(25, 23));
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        panelisi2.add(button1);

        label35.setText("Tampilkan Menu :");
        label35.setPreferredSize(new java.awt.Dimension(105, 23));
        panelisi2.add(label35);

        TCari.setPreferredSize(new java.awt.Dimension(470, 23));
        TCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TCariKeyPressed(evt);
            }
        });
        panelisi2.add(TCari);

        panelMenu.add(panelisi2, java.awt.BorderLayout.PAGE_START);

        scrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(238, 240, 230)));
        scrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        Panelmenu.setBorder(null);
        Panelmenu.setMinimumSize(new java.awt.Dimension(1975, 2826));
        Panelmenu.setLayout(new java.awt.GridLayout(0, 12));
        scrollPane2.setViewportView(Panelmenu);

        panelMenu.add(scrollPane2, java.awt.BorderLayout.CENTER);

        DlgHome.getContentPane().add(panelMenu, java.awt.BorderLayout.CENTER);

        btnSimpanan.setText("Set Admin");
        btnSimpanan.setIconTextGap(0);
        btnSimpanan.setPreferredSize(new java.awt.Dimension(200, 90));
        btnSimpanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpananActionPerformed(evt);
            }
        });

        btnTagihan.setText("Set Admin");
        btnTagihan.setIconTextGap(0);
        btnTagihan.setPreferredSize(new java.awt.Dimension(200, 90));
        btnTagihan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTagihanActionPerformed(evt);
            }
        });

        btnAnggota.setText("Set Admin");
        btnAnggota.setIconTextGap(0);
        btnAnggota.setPreferredSize(new java.awt.Dimension(200, 90));
        btnAnggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnggotaActionPerformed(evt);
            }
        });

        btnUnitKerja.setText("Set Admin");
        btnUnitKerja.setIconTextGap(0);
        btnUnitKerja.setPreferredSize(new java.awt.Dimension(200, 90));
        btnUnitKerja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnitKerjaActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        internalFrame1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        internalFrame1.setPreferredSize(new java.awt.Dimension(40, 42));
        internalFrame1.setVerifyInputWhenFocusTarget(false);
        internalFrame1.setWarnaBawah(new java.awt.Color(209, 248, 239));
        internalFrame1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 2));

        BtnMenu.setMnemonic('M');
        BtnMenu.setText("Menu");
        BtnMenu.setToolTipText("Alt+M");
        BtnMenu.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        BtnMenu.setIconTextGap(2);
        BtnMenu.setMargin(new java.awt.Insets(0, 0, 0, 0));
        BtnMenu.setName("BtnMenu"); // NOI18N
        BtnMenu.setPreferredSize(new java.awt.Dimension(78, 38));
        BtnMenu.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnMenuActionPerformed(evt);
            }
        });
        internalFrame1.add(BtnMenu);

        BtnLog.setMnemonic('L');
        BtnLog.setText("Log In");
        BtnLog.setToolTipText("Alt+L");
        BtnLog.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        BtnLog.setIconTextGap(2);
        BtnLog.setMargin(new java.awt.Insets(0, 0, 0, 0));
        BtnLog.setPreferredSize(new java.awt.Dimension(78, 38));
        BtnLog.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLogActionPerformed(evt);
            }
        });
        internalFrame1.add(BtnLog);

        BtnClose.setMnemonic('U');
        BtnClose.setText("Keluar");
        BtnClose.setToolTipText("Alt+U");
        BtnClose.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        BtnClose.setIconTextGap(2);
        BtnClose.setMargin(new java.awt.Insets(0, 0, 0, 0));
        BtnClose.setPreferredSize(new java.awt.Dimension(80, 38));
        BtnClose.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCloseActionPerformed(evt);
            }
        });
        internalFrame1.add(BtnClose);

        getContentPane().add(internalFrame1, java.awt.BorderLayout.PAGE_START);

        internalFrame4.setBackground(new java.awt.Color(235, 215, 195));
        internalFrame4.setBorder(null);
        internalFrame4.setPreferredSize(new java.awt.Dimension(330, 25));
        internalFrame4.setWarnaAtas(new java.awt.Color(209, 248, 239));
        internalFrame4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 4, 1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(50, 50, 50));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Bakoperasi");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel7.setIconTextGap(3);
        jLabel7.setPreferredSize(new java.awt.Dimension(287, 23));
        internalFrame4.add(jLabel7);

        getContentPane().add(internalFrame4, java.awt.BorderLayout.PAGE_END);

        PanelUtama.setLayout(new java.awt.BorderLayout());

        PanelWall.setBackground(new java.awt.Color(29, 29, 29));
        PanelWall.setBackgroundImage(new javax.swing.ImageIcon(getClass().getResource("/picture/backgroun.jpg"))); // NOI18N
        PanelWall.setBackgroundImageType(usu.widget.constan.BackgroundConstan.BACKGROUND_IMAGE_STRECT);
        PanelWall.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 0, 0, 0));
        PanelWall.setPreferredSize(new java.awt.Dimension(200, 200));
        PanelWall.setRound(false);
        PanelWall.setWarna(new java.awt.Color(110, 110, 110));
        PanelWall.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                PanelWallMouseMoved(evt);
            }
        });
        PanelWall.setLayout(new java.awt.BorderLayout());

        panelJudul.setBackground(new java.awt.Color(255, 255, 255));
        panelJudul.setOpaqueImage(false);
        panelJudul.setPreferredSize(new java.awt.Dimension(200, 170));
        panelJudul.setRound(false);
        panelJudul.setLayout(null);

        jLabel8.setFont(new java.awt.Font("Tahoma", 2, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Aplikasi Koperasi Simpan Pinjam");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        panelJudul.add(jLabel8);
        jLabel8.setBounds(60, 0, 1020, 170);

        PanelWall.add(panelJudul, java.awt.BorderLayout.PAGE_END);

        PanelUtama.add(PanelWall, java.awt.BorderLayout.CENTER);

        getContentPane().add(PanelUtama, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCloseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnCloseActionPerformed

    private void BtnLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLogActionPerformed
        // TODO add your handling code here:
        switch (BtnLog.getText().trim()) {
            case "Log Out" -> {
                BtnLog.setText("Log In");
                DlgHome.dispose();
                BtnMenu.setVisible(false);
            }
            case "Log In" -> {
                DlgLogin.setVisible(true);
                edAdmin.requestFocus();
            }
        }
    }//GEN-LAST:event_BtnLogActionPerformed

    private void BtnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuActionPerformed
        //TODO add your handling code here:
         this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR)); 
        //    isTutup();
        DlgHome.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        DlgHome.setLocationRelativeTo(PanelUtama);
        DlgHome.setVisible(true);
        isCombo();
        setLayout();
        menuawal=1;
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_BtnMenuActionPerformed

    private void PanelWallMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelWallMouseMoved

    }//GEN-LAST:event_PanelWallMouseMoved

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        DlgHome.dispose();
    }//GEN-LAST:event_button1ActionPerformed

    private void TCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TCariKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            //isTampil();
        }
    }//GEN-LAST:event_TCariKeyPressed

    private void btnSimpananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpananActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        Simpanan simpanan=new Simpanan(null,false);
        simpanan.setSize(PanelUtama.getWidth(),PanelUtama.getHeight());
        simpanan.setLocationRelativeTo(PanelUtama);
        simpanan.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnSimpananActionPerformed

    private void BtnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLoginActionPerformed
        DlgLogin.getGlassPane().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgLogin.getGlassPane().setVisible(true);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws JsonProcessingException {
                try {
                    String URL = koneksi.HOST() + "/api/v1/users/login";
                    System.out.println("Request ke: " + URL);

                    // Header
                    HttpHeaders headers = new HttpHeaders();
                    headers.setContentType(MediaType.APPLICATION_JSON);
                    headers.set("Accept", "application/json");

                    // Data login
                    String username = edAdmin.getText();
                    String password = new String(edPwd.getPassword()).trim();

                    String requestJson = "{ \"username\":\"" + username + "\", \"password\":\"" + password + "\" }";
                    System.out.println("Payload: " + requestJson);

                    // Kirim request
                    HttpEntity<String> requestEntity = new HttpEntity<>(requestJson, headers);
                    RestTemplate restTemplate = new RestTemplate();

                    ResponseEntity<String> response = restTemplate.exchange(URL, HttpMethod.POST, requestEntity, String.class);

                    if (response.getStatusCode() == HttpStatus.OK) {
                        
                        ObjectMapper mapper = new ObjectMapper();
                        JsonNode root = mapper.readTree(response.getBody());
                        // Ambil token dari response
                        String token = root.path("data").path("token").asText();
                        System.out.println("Token: " + token);

                        // Simpan token menggunakan Preferences
                        Preferences prefs = Preferences.userRoot().node("myApp");
                        prefs.put("auth_token", token);

                        System.out.println("Token berhasil disimpan!");
                        System.out.println("Login Berhasil: " + root);
//                      JOptionPane.showMessageDialog(null, root.path("message").asText());
                        BtnMenu.setVisible(true);
                        BtnLog.setText("Log Out");
                        DlgLogin.dispose();
                    } else {
                        System.out.println("Login Gagal: " + response.getBody());
                    }
                } catch (HttpClientErrorException e) {
                    System.out.println("Error " + e.getStatusCode() + ": " + e.getResponseBodyAsString());
//                    // Parse JSON error response
//                    ObjectMapper mapper = new ObjectMapper();
//                    JsonNode root = mapper.readTree(e.getResponseBodyAsString());
//                    // Ambil nilai dari key "errors"
//                    String errorMessage = root.path("errors").asText();
//                    JOptionPane.showMessageDialog(null, errorMessage);
                } catch (JsonProcessingException ex) {
                    Logger.getLogger(frmUtama.class.getName()).log(Level.SEVERE, null, ex);
                } catch (RestClientException e) {
                    System.out.println("Request Error: " + e.getMessage());
                }
                return null;
            }

            @Override
            protected void done() {
                DlgLogin.getGlassPane().setCursor(Cursor.getDefaultCursor());
                DlgLogin.getGlassPane().setVisible(false);
                setCursor(Cursor.getDefaultCursor());
                edAdmin.setText("");
                edPwd.setText("");
            }
        };
        worker.execute();

    }//GEN-LAST:event_BtnLoginActionPerformed

    private void BtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelActionPerformed
        edAdmin.setText("");
        edPwd.setText("");
        DlgLogin.dispose();
    }//GEN-LAST:event_BtnCancelActionPerformed

    private void btnTagihanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTagihanActionPerformed
        // TODO add your handling code here:
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        Tagihan tagihan=new Tagihan(null,false);
        tagihan.setSize(PanelUtama.getWidth(),PanelUtama.getHeight());
        tagihan.setLocationRelativeTo(PanelUtama);
        tagihan.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnTagihanActionPerformed

    private void btnAnggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnggotaActionPerformed
        // TODO add your handling code here:
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        Anggota anggota=new Anggota(null,false);
        anggota.setSize(PanelUtama.getWidth(),PanelUtama.getHeight());
        anggota.setLocationRelativeTo(PanelUtama);
        anggota.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnAnggotaActionPerformed

    private void btnUnitKerjaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnitKerjaActionPerformed
        // TODO add your handling code here:
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        UnitKerja unitkerja=new UnitKerja(null,false);
        unitkerja.setSize(PanelUtama.getWidth(),PanelUtama.getHeight());
        unitkerja.setLocationRelativeTo(PanelUtama);
        unitkerja.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnUnitKerjaActionPerformed

     private void setLayout() {
        if(jmlmenu<=1){
            grid=1;
        }else if(jmlmenu<=4){
            grid=2;
        }else if(jmlmenu<=9){
            grid=3;
        }else if(jmlmenu<=16){
            grid=4;
        }else if(jmlmenu>16){
            grid=5;
        }
        
        if(jmlmenu<=20){
            tinggi=scrollPane2.getHeight()-5;
        }else if(jmlmenu<=25){
            tinggi=scrollPane2.getHeight()+(scrollPane2.getHeight()/4);
        }else if(jmlmenu>25){
            tinggi=1;
            for(i=25;i<jmlmenu;i++){
                if(i%5==0){
                    tinggi++;
                }
            }
            tinggi=scrollPane2.getHeight()+((scrollPane2.getHeight()/4)*tinggi);
        }
        
        Panelmenu.setLayout(new GridLayout(0,grid));
        Panelmenu.setPreferredSize(new Dimension(scrollPane2.getWidth()-10,tinggi));
        Panelmenu.revalidate();
        Panelmenu.repaint(); 
    }
     
     private void isCombo() {
        jmlmenu=0;     
        Panelmenu.add(btnSimpanan);
        jmlmenu++;
        Panelmenu.add(btnTagihan);
        jmlmenu++;
        Panelmenu.add(btnAnggota);
        jmlmenu++;
        Panelmenu.add(btnUnitKerja);
        jmlmenu++;
     }
     
      private void initBekoperasi() {
            btnSimpanan = new widget.ButtonBig();
            btnSimpanan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/simpanan.png")));
            btnSimpanan.setText("Simpanan");
            btnSimpanan.setIconTextGap(0);
            btnSimpanan.setName("btnSimpanan");
            btnSimpanan.setPreferredSize(new java.awt.Dimension(200, 90));
            btnSimpanan.addActionListener(this::btnSimpananActionPerformed);
            
            btnTagihan = new widget.ButtonBig();
            btnTagihan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/tagihan.png")));
            btnTagihan.setText("Tagihan");
            btnTagihan.setIconTextGap(0);
            btnTagihan.setName("btnTagihan");
            btnTagihan.setPreferredSize(new java.awt.Dimension(200, 90));
            btnTagihan.addActionListener(this::btnTagihanActionPerformed);
            
            btnAnggota = new widget.ButtonBig();
            btnAnggota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/anggota.png")));
            btnAnggota.setText("Anggota");
            btnAnggota.setIconTextGap(0);
            btnAnggota.setName("btnAnggota");
            btnAnggota.setPreferredSize(new java.awt.Dimension(200, 90));
            btnAnggota.addActionListener(this::btnAnggotaActionPerformed);
            
            btnUnitKerja = new widget.ButtonBig();
            btnUnitKerja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/office.png")));
            btnUnitKerja.setText("Unit Kerja");
            btnUnitKerja.setIconTextGap(0);
            btnUnitKerja.setName("btnUnitKerja");
            btnUnitKerja.setPreferredSize(new java.awt.Dimension(200, 90));
            btnUnitKerja.addActionListener(this::btnAnggotaActionPerformed);
      }
      
      private void isTutup() {
        Window[] wins = Window.getWindows();
        for (Window win : wins) {
            if (win instanceof JDialog) {
                win.dispose();
            }
        }
    }
    
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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
         //</editor-fold>
         try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        UIManager.put("ComboBox.background", new java.awt.Color(255, 255, 255)); 
        /* Create and display the form */
        SwingUtilities.invokeLater(() -> new frmUtama().setVisible(true));
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private widget.Button BtnCancel;
    private widget.ButtonBig BtnClose;
    private widget.ButtonBig BtnLog;
    private widget.Button BtnLogin;
    private widget.ButtonBig BtnMenu;
    private javax.swing.JDialog DlgHome;
    private javax.swing.JDialog DlgLogin;
    private javax.swing.JPanel PanelUtama;
    private usu.widget.glass.PanelGlass PanelWall;
    private widget.panelGlass Panelmenu;
    private widget.TextBox TCari;
    private widget.ButtonBig btnAnggota;
    private widget.ButtonBig btnSimpanan;
    private widget.ButtonBig btnTagihan;
    private widget.ButtonBig btnUnitKerja;
    private widget.Button button1;
    private javax.swing.JPasswordField edAdmin;
    private javax.swing.JPasswordField edPwd;
    private widget.InternalFrame internalFrame1;
    private widget.InternalFrame internalFrame2;
    private widget.InternalFrame internalFrame3;
    private widget.InternalFrame internalFrame4;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private widget.Label label35;
    private widget.Label label36;
    private usu.widget.glass.PanelGlass panelGlass1;
    private usu.widget.glass.PanelGlass panelJudul;
    private widget.InternalFrame panelMenu;
    private widget.panelisi panelisi2;
    private widget.ScrollPane scrollPane2;
    // End of variables declaration//GEN-END:variables
}
