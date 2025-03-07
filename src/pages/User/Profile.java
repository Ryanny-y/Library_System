package pages.User;
import config.ConnDB;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import model.Book_Model;
import model.Current_User;
import swing.AuthButton;
import model.User_Model;
import pages.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Profile extends javax.swing.JFrame {

    User_Model user = Current_User.getCurrentUser();
    private String cover_img;
    ConnDB con = ConnDB.getInstance();
    Connection c = con.getConnection();
    
    public Profile() {
        initComponents();
        setBackground(new Color(0,0,0,0));
        menu1.initMoving(this);
        setVisible(true);
        if(user != null) {
            initInfo();
        }
        setProfile();
    }
    
    private void initInfo() {
        student_num.setText(user.getStudent_id());
        String lastName = user.getLast_name().substring(0, 1).toUpperCase() + user.getLast_name().substring(1);
        String firstName = user.getFirst_name().substring(0, 1).toUpperCase() + user.getFirst_name().substring(1);
        name.setText(lastName + ", " + firstName);
        email.setText(user.getEmail());
        String pass = user.getPassword();
        password.setText("**********");
        penalty.setText(String.valueOf(user.getPenalty()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new swing.PanelBorder();
        menu1 = new components.Menu();
        frameHeader2 = new components.UserFrameHeader();
        mainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        logoutBtn = new AuthButton("Logout");
        profile_img = new javax.swing.JLabel();
        profile_btn = new javax.swing.JButton();
        studentInfoBox = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        student_num = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        penalty = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1080, 600));

        panelBorder1.setPreferredSize(new java.awt.Dimension(1080, 600));

        mainPanel.setBackground(new java.awt.Color(204, 204, 204));
        mainPanel.setOpaque(false);

        jLabel1.setBackground(new java.awt.Color(27, 76, 140));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(27, 76, 140));
        jLabel1.setText("My Profile");

        jPanel1.setOpaque(false);

        logoutBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        logoutBtn.setText("Logout");
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        profile_img.setBackground(new java.awt.Color(255, 102, 102));
        profile_img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profile_img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/profile/default_profile.png"))); // NOI18N
        profile_img.setPreferredSize(new java.awt.Dimension(200, 200));

        profile_btn.setBackground(new java.awt.Color(27, 76, 140));
        profile_btn.setForeground(new java.awt.Color(255, 255, 255));
        profile_btn.setText("Choose Profile");
        profile_btn.setBorder(null);
        profile_btn.setBorderPainted(false);
        profile_btn.setFocusPainted(false);
        profile_btn.setFocusable(false);
        profile_btn.setOpaque(true);
        profile_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profile_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(profile_img, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(profile_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(profile_img, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(profile_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        studentInfoBox.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(104, 104, 104));
        jLabel2.setText("Student Number:");

        student_num.setBackground(new java.awt.Color(51, 51, 51));
        student_num.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        student_num.setText("number here");

        name.setBackground(new java.awt.Color(51, 51, 51));
        name.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        name.setText("name here");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(104, 104, 104));
        jLabel5.setText("Student Name:");

        email.setBackground(new java.awt.Color(51, 51, 51));
        email.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        email.setText("email here");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(104, 104, 104));
        jLabel7.setText("Email:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(104, 104, 104));
        jLabel8.setText("Password:");

        password.setBackground(new java.awt.Color(51, 51, 51));
        password.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        password.setText("password here");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(104, 104, 104));
        jLabel10.setText("Penalty");

        penalty.setBackground(new java.awt.Color(51, 51, 51));
        penalty.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        penalty.setText("penalty here");

        javax.swing.GroupLayout studentInfoBoxLayout = new javax.swing.GroupLayout(studentInfoBox);
        studentInfoBox.setLayout(studentInfoBoxLayout);
        studentInfoBoxLayout.setHorizontalGroup(
            studentInfoBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentInfoBoxLayout.createSequentialGroup()
                .addGroup(studentInfoBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(studentInfoBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(studentInfoBoxLayout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(studentInfoBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(studentInfoBoxLayout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(studentInfoBoxLayout.createSequentialGroup()
                            .addGap(36, 36, 36)
                            .addComponent(student_num, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(studentInfoBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(studentInfoBoxLayout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(studentInfoBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(studentInfoBoxLayout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(studentInfoBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(studentInfoBoxLayout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addComponent(penalty, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        studentInfoBoxLayout.setVerticalGroup(
            studentInfoBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentInfoBoxLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(student_num, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(penalty, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(studentInfoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(studentInfoBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(menu1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(frameHeader2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(frameHeader2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void setProfile() {
        String query = "SELECT profile_img FROM users WHERE student_id = ?";
        
        try {
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, user.getStudent_id());
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                String img = rs.getString("profile_img");
                profile_img.setIcon(toIcon(img));
            }
            
                        
        } catch (SQLException ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        // TODO add your handling code here:
        Current_User.setCurrentUser(null);
            
        this.dispose();
        Book_Model.resetBookList();
        User_Model.penaltyCalled = false;
        Home.calledNotif = false;
        new Login();
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void getFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        
        if(result == JFileChooser.APPROVE_OPTION) {
            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            cover_img = file.getName();
            
            JFileChooser folderChooser = new JFileChooser();
            folderChooser.setCurrentDirectory(new File(".\\src\\images\\profile"));
            folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int folderResult = folderChooser.showOpenDialog(null);
            
            if(folderResult == JFileChooser.APPROVE_OPTION) {
                File destinationFolder = folderChooser.getSelectedFile();
                
                File copyFile = new File(destinationFolder, file.getName());
                
                try {
                    copyFile(file, copyFile);
                } catch (Exception e) {
                    System.out.println("Copy failed!");
                }
            }
            
        }
    }
    
    private void copyFile(File file, File path) throws IOException {
            Path srcPath = file.toPath();
            Path destinationPath = path.toPath();

            Files.copy(srcPath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
    }
    
    private void profile_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profile_btnActionPerformed
        getFile();
        String query = "UPDATE users SET profile_img = ? WHERE student_id = ?";
        
        try {
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, cover_img);
            ps.setString(2, user.getStudent_id());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        profile_img.setIcon(toIcon(cover_img));
        this.dispose();
        new Profile();
    }//GEN-LAST:event_profile_btnActionPerformed

    public Icon toIcon(String icon) {
        try {
            ImageIcon imageIcon = new ImageIcon(getClass().getResource("/images/profile/" + icon));
            Image image = imageIcon.getImage();

            Image resizedImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            return new ImageIcon(resizedImage);
        } catch (Exception e) {
            ImageIcon imageIcon = new ImageIcon(getClass().getResource("/images/profile/default_profile.png"));
            Image image = imageIcon.getImage();

            Image resizedImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            return new ImageIcon(resizedImage);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel email;
    private components.UserFrameHeader frameHeader2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JPanel mainPanel;
    private components.Menu menu1;
    private javax.swing.JLabel name;
    private swing.PanelBorder panelBorder1;
    private javax.swing.JLabel password;
    private javax.swing.JLabel penalty;
    private javax.swing.JButton profile_btn;
    private javax.swing.JLabel profile_img;
    private javax.swing.JPanel studentInfoBox;
    private javax.swing.JLabel student_num;
    // End of variables declaration//GEN-END:variables
}
