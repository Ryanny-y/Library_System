package components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import swing.AuthButton;
import pages.*;
import config.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.util.Arrays;

public class SignupForm extends javax.swing.JPanel implements ActionListener{

    private ConnDB con = ConnDB.getInstance();
    private Connection c = con.getConnection();
    
    public SignupForm() {
        initComponents();
        
        signup_btn.addActionListener(this);
        initListeners();
    }
    
    private void initListeners() {
        
        textListener(id_field, "Enter Your Student ID");
        textListener(firstname_field, "Enter Your First Name");
        textListener(lastname_field, "Enter Your Last Name");
        textListener(email_field, "Enter Your Email");
        
        password_field.setEchoChar((char) 0);
        passwordListener(password_field, "Enter Your Password");
        confirm_field.setEchoChar((char) 0);
        passwordListener(confirm_field, "Confirm Your Password");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        icon = new javax.swing.JLabel();
        Name = new javax.swing.JLabel();
        greetings = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        id_field = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        firstname_field = new javax.swing.JTextField();
        lastname_field = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        email_field = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        signup_btn = new AuthButton("Sign up");
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        password_field = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        confirm_field = new javax.swing.JPasswordField();

        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Logo.png"))); // NOI18N

        Name.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        Name.setForeground(new java.awt.Color(118, 75, 162));
        Name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Name.setText("IT242 Library");

        greetings.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        greetings.setText("Welcome Back! Please login your account");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Student Id");

        id_field.setBackground(new java.awt.Color(240, 240, 240));
        id_field.setForeground(new java.awt.Color(51, 51, 51));
        id_field.setText("Enter Your Student ID");
        id_field.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        id_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_fieldActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("First Name");

        firstname_field.setBackground(new java.awt.Color(240, 240, 240));
        firstname_field.setForeground(new java.awt.Color(51, 51, 51));
        firstname_field.setText("Enter Your First Name");
        firstname_field.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        firstname_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstname_fieldActionPerformed(evt);
            }
        });

        lastname_field.setBackground(new java.awt.Color(240, 240, 240));
        lastname_field.setForeground(new java.awt.Color(51, 51, 51));
        lastname_field.setText("Enter Your Last Name");
        lastname_field.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        lastname_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastname_fieldActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Last Name");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Email");

        email_field.setBackground(new java.awt.Color(240, 240, 240));
        email_field.setForeground(new java.awt.Color(51, 51, 51));
        email_field.setText("Enter Your Email");
        email_field.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        email_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                email_fieldActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Password");

        signup_btn.setBackground(new java.awt.Color(27, 76, 140));
        signup_btn.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        signup_btn.setForeground(new java.awt.Color(255, 255, 255));
        signup_btn.setText("Sign Up");
        signup_btn.setBorder(null);
        signup_btn.setBorderPainted(false);
        signup_btn.setFocusPainted(false);
        signup_btn.setFocusable(false);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Don't have account?");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(27, 76, 140));
        jButton1.setText("Login");
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
        password_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password_fieldActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Confirm Password");

        confirm_field.setBackground(new java.awt.Color(240, 240, 240));
        confirm_field.setText("Confirm Your Password");
        confirm_field.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 20, 1, 1));
        confirm_field.setPreferredSize(new java.awt.Dimension(123, 22));
        confirm_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirm_fieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(confirm_field, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(signup_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(79, 79, 79)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(67, 67, 67)
                                                .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(120, 120, 120)
                                                .addComponent(icon))
                                            .addComponent(greetings)))
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(id_field, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(firstname_field, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lastname_field, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(email_field, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(password_field, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(id_field, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(firstname_field, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lastname_field, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(email_field, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(password_field, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirm_field, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(signup_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void id_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_fieldActionPerformed

    private void firstname_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstname_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstname_fieldActionPerformed

    private void lastname_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastname_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastname_fieldActionPerformed

    private void email_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_email_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_email_fieldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JFrame topFrame = (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
        if(topFrame != null) {
            topFrame.dispose();
            new Login();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void password_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_password_fieldActionPerformed

    private void confirm_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirm_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirm_fieldActionPerformed

    private void textListener(JTextField field, String text) {
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
    
    private void passwordListener(JPasswordField field, String text) {
        field.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                String pass = String.valueOf(field.getPassword()).trim();

                if (pass.equals(text)) {
                    field.setText(""); // Clear placeholder
                    field.setForeground(Color.BLACK);
                    field.setEchoChar('*'); // Enable password masking
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                String pass = String.valueOf(field.getPassword()).trim();

                if (pass.isEmpty()) {
                    field.setText(text);
                    field.setForeground(Color.GRAY);
                    field.setEchoChar((char) 0);
                }
            }
        });
    }

    private void validateFields() {
        if( id_field.getText().equalsIgnoreCase("Enter Your Student ID")
            || firstname_field.getText().equalsIgnoreCase("Enter Your First Name")
            || lastname_field.getText().equalsIgnoreCase("Enter Your Last Name")
            || email_field.getText().equalsIgnoreCase("Enter Your Email")
            || String.valueOf(password_field.getPassword()).equalsIgnoreCase("Enter Your Password")
          ) {
            JOptionPane.showMessageDialog(null, "All Fieds are required!", "Invalid Data", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!Arrays.equals(password_field.getPassword(), confirm_field.getPassword())) {
            JOptionPane.showMessageDialog(null, "Password do not match. Please try again", "Password mismatch", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == signup_btn) {
           JFrame topFrame = (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
           if(topFrame != null) {
               
               validateFields();
               String query = "INSERT INTO users (student_id, first_name, last_name, email, password) VALUES (?, ?, ?, ?, ?)";
               try {
                   PreparedStatement ps = c.prepareStatement(query);
                   ps.setString(1, id_field.getText());
                   ps.setString(2, firstname_field.getText());
                   ps.setString(3, lastname_field.getText());
                   ps.setString(4, email_field.getText());
                   ps.setString(5, String.valueOf(password_field.getPassword()));
                   ps.executeUpdate();
                   
                   JOptionPane.showMessageDialog(null, "Sign Up Successfull", "Sign Up Successfull", JOptionPane.PLAIN_MESSAGE);
                   topFrame.dispose();
                   new Login();
                   ps.close();
               } catch (SQLException ex) {
                   Logger.getLogger(SignupForm.class.getName()).log(Level.SEVERE, null, ex);
               }
               
               
           }
       }
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.WHITE);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Name;
    private javax.swing.JPasswordField confirm_field;
    private javax.swing.JTextField email_field;
    private javax.swing.JTextField firstname_field;
    private javax.swing.JLabel greetings;
    private javax.swing.JLabel icon;
    private javax.swing.JTextField id_field;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField lastname_field;
    private javax.swing.JPasswordField password_field;
    private javax.swing.JButton signup_btn;
    // End of variables declaration//GEN-END:variables
}
