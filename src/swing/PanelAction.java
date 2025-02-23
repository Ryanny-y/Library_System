package swing;

import config.ConnDB;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import model.Current_User;
import pages.Admin.Admin_Books;

public class PanelAction extends javax.swing.JPanel {
    
    ConnDB con = ConnDB.getInstance();
    Connection c = con.getConnection();
    JFrame currentFrame;
    private String student_id = Current_User.getCurrentUser().getStudent_id();
    private int book_id;
    
    
    public PanelAction(String status, int book_id, JFrame frame) {
        initComponents();
        this.book_id = book_id;
        setOpaque(false);
        this.currentFrame = frame;
        
        if(!status.equalsIgnoreCase("REQUEST")) {
            this.remove(approve_btn);
            this.remove(reject_btn);
            approve_btn.setEnabled(false);
            reject_btn.setEnabled(false);
        } 
    }
    
    public PanelAction() {
        initComponents();
        
        setOpaque(false);
    }
    
    public PanelAction(String status) {
        initComponents();
        
        if(!status.equalsIgnoreCase("REQUEST")) {
            this.remove(approve_btn);
            this.remove(reject_btn);
            approve_btn.setEnabled(false);
            reject_btn.setEnabled(false);
        } 
        setOpaque(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        approve_btn = new swing.ActionButton();
        reject_btn = new swing.ActionButton();
        reset_btn = new swing.ActionButton();

        setLayout(new java.awt.GridLayout(1, 3, 3, 0));

        approve_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/check_icon.png"))); // NOI18N
        approve_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approve_btnActionPerformed(evt);
            }
        });
        add(approve_btn);

        reject_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel.png"))); // NOI18N
        reject_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reject_btnActionPerformed(evt);
            }
        });
        add(reject_btn);

        reset_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reset.png"))); // NOI18N
        reset_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_btnActionPerformed(evt);
            }
        });
        add(reset_btn);
    }// </editor-fold>//GEN-END:initComponents

    public void restartFrame() {
        currentFrame.dispose();
        new Admin_Books();
    }
    
    private void approve_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approve_btnActionPerformed
        String selectQuery = "SELECT * from books WHERE book_id = ?";
        String updateQuery = "INSERT INTO borrowed_books (student_id, book_id, borrowed_at, due_date) VALUES (?,?,?,?)";
        String updateStatus = "UPDATE books SET status = ? WHERE book_id = ?";
        
        try {
            PreparedStatement ps = c.prepareStatement(selectQuery);
            ps.setInt(1, book_id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                PreparedStatement ps2 = c.prepareStatement(updateQuery);
                ps2.setString(1, rs.getString("borrowed_by"));
                ps2.setInt(2, rs.getInt("book_id"));
                LocalDateTime borrowed_at = LocalDateTime.now();
                ps2.setObject(3, borrowed_at);
                LocalDate due_date = borrowed_at.toLocalDate().plusDays(7);
                ps2.setObject(4, due_date);
                ps2.executeUpdate();
                
                PreparedStatement ps3 = c.prepareStatement(updateStatus);
                ps3.setString(1, "BORROWED");
                ps3.setInt(2, book_id);
                ps3.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Borrow Request has been approved!", "Request Approved!", JOptionPane.PLAIN_MESSAGE);
                restartFrame();
            }

        } catch (SQLException ex) {
            Logger.getLogger(PanelAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_approve_btnActionPerformed

    private void reset_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_btnActionPerformed
        // TODO add your handling code here:
        String updateQuery = "UPDATE books SET status = ?, borrowed_by = ? WHERE book_id = ?";
        String deleteQuery = "DELETE FROM borrowed_books WHERE book_id = ?";
        
        try {
            PreparedStatement ps = c.prepareStatement(updateQuery);
            ps.setString(1, "AVAILABLE");
            ps.setNull(2, java.sql.Types.VARCHAR);
            ps.setInt(3, book_id);
            ps.executeUpdate();
            
            PreparedStatement ps1 = c.prepareStatement(deleteQuery);
            ps1.setInt(1, book_id);
            ps1.executeUpdate();
            restartFrame();

        } catch (SQLException ex) {
            Logger.getLogger(PanelAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_reset_btnActionPerformed

    private void reject_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reject_btnActionPerformed
        String updateQuery = "UPDATE books SET status = ?, borrowed_by = ? WHERE book_id = ?";
         
        try {
            PreparedStatement ps = c.prepareStatement(updateQuery);
            ps.setString(1, "AVAILABLE");
            ps.setNull(2, java.sql.Types.VARCHAR);
            ps.setInt(3, book_id);
            ps.executeUpdate();
            restartFrame();

        } catch (SQLException ex) {
            Logger.getLogger(PanelAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_reject_btnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.ActionButton approve_btn;
    private swing.ActionButton reject_btn;
    private swing.ActionButton reset_btn;
    // End of variables declaration//GEN-END:variables
}
