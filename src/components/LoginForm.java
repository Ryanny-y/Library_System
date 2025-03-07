package components;

import config.ConnDB;
import pages.Admin.Admin_Dashboard;
import pages.User.Home;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.List;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JTextField;
import model.*;
import pages.*;
import swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Book_Model;

public class LoginForm extends javax.swing.JPanel implements ActionListener {

    private String email, password;
    private User_Model user;
    private ConnDB db = ConnDB.getInstance();
    private Connection c = db.getConnection();
    
    public LoginForm() {
        initComponents();
        setOpaque(false);
        
        LoginBtn.addActionListener(this);
        
        emailListener(email_field, "Enter Your Email");
        password_field.setEchoChar((char) 0);
        passwordListener(password_field, "Enter Your Password");
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.WHITE);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        icon = new javax.swing.JLabel();
        Name = new javax.swing.JLabel();
        greetings = new javax.swing.JLabel();
        email_field = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        LoginBtn = new AuthButton("Login");
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        password_field = new javax.swing.JPasswordField();

        setPreferredSize(new java.awt.Dimension(500, 500));
        setRequestFocusEnabled(false);

        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Logo.png"))); // NOI18N

        Name.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        Name.setForeground(new java.awt.Color(27, 76, 140));
        Name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Name.setText("IT242 Library");

        greetings.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        greetings.setText("Welcome Back! Please login your account");

        email_field.setBackground(new java.awt.Color(240, 240, 240));
        email_field.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        email_field.setForeground(new java.awt.Color(51, 51, 51));
        email_field.setText("Enter Your Email");
        email_field.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Email");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Password");

        LoginBtn.setBackground(new java.awt.Color(27, 76, 140));
        LoginBtn.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        LoginBtn.setForeground(new java.awt.Color(255, 255, 255));
        LoginBtn.setText("Login");
        LoginBtn.setBorder(null);
        LoginBtn.setBorderPainted(false);
        LoginBtn.setFocusPainted(false);
        LoginBtn.setFocusable(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Don't have account?");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(27, 76, 140));
        jButton1.setText("Sign up");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        jButton1.setFocusable(false);
        jButton1.setPreferredSize(new java.awt.Dimension(65, 65));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        password_field.setBackground(new java.awt.Color(240, 240, 240));
        password_field.setText("Enter Your Password");
        password_field.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        password_field.setPreferredSize(new java.awt.Dimension(123, 22));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(icon))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(greetings))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(email_field, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                            .addComponent(LoginBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(password_field, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(greetings)
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(email_field, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(password_field, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JFrame topFrame = (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
        if (topFrame != null) {
            topFrame.dispose(); // Close the frame 
            new Sign_Up();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void emailListener(JTextField field, String text) {
        field.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(field.getText().equals(text)) {
                    field.setText("");
                } 
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(field.getText().isBlank()) {
                    field.setText(text);
                }
            }
            
            
        });
    }
    
    private void passwordListener(JTextField field, String text) {
        field.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                String pass = String.valueOf(password_field.getPassword()).trim();

                if (pass.equals(text)) {
                    password_field.setText(""); // Clear placeholder
                    password_field.setForeground(Color.BLACK);
                    password_field.setEchoChar('*'); // Enable password masking
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                String pass = String.valueOf(password_field.getPassword()).trim();

                if (pass.isEmpty()) {
                    password_field.setText(text);
                    password_field.setForeground(Color.GRAY);
                    password_field.setEchoChar((char) 0); // Show text instead of *
                }
            }
        });
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == LoginBtn) {
            if (email_field.getText().equalsIgnoreCase("Enter Your Email") || 
                String.valueOf(password_field.getPassword()).equalsIgnoreCase("Enter Your Password")) {
                this.email = "";
                this.password = "";
            } else {
                this.email = email_field.getText();
                this.password = String.valueOf(password_field.getPassword());
            }
            
            JFrame topFrame = (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
            if (topFrame != null) {
                try (Connection c = db.getConnection();
                    PreparedStatement ps = c.prepareStatement("SELECT * FROM users WHERE email = ? AND password = ?")) {
                    ps.setString(1, email);
                    ps.setString(2, password);
                    ResultSet rs = ps.executeQuery();
                    
                    if (rs.next()) {
                        String student_id = rs.getString("student_id");
                        String first_name = rs.getString("first_name");
                        String last_name = rs.getString("last_name");
                        String email = rs.getString("email");
                        String password = rs.getString("password");
                        String profile_img = rs.getString("profile_img");
                        String role = rs.getString("role");
                        double penalty = rs.getDouble("penalty");
                        Timestamp timestamp = rs.getTimestamp("joined_at");
                        LocalDateTime joined_at = timestamp.toLocalDateTime();
                        
                        user = new User_Model(student_id, first_name, last_name, email, password, profile_img, role, penalty, joined_at);
                        Current_User.setCurrentUser(user);
                        
                        if (user.getRole() == User_Role.USER) {
                            new Home();
                            topFrame.dispose();
                        } else if (user.getRole() == User_Role.ADMIN) {
                            new Admin_Dashboard();
                            topFrame.dispose();
                        } else {
                            new Home();
                            topFrame.dispose();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Username or password is incorrect.", "User Not Found", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoginBtn;
    private javax.swing.JLabel Name;
    private javax.swing.JTextField email_field;
    private javax.swing.JLabel greetings;
    private javax.swing.JLabel icon;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField password_field;
    // End of variables declaration//GEN-END:variables
}