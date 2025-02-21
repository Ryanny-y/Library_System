package swing;
import config.ConnDB;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import model.Current_User;

public class Book_Actions extends javax.swing.JPanel {

    ConnDB con = ConnDB.getInstance();
    Connection c = con.getConnection();
    String student_id = Current_User.getCurrentUser().getStudent_id();
    
    public Book_Actions(String status, int book_id) {
        initComponents();
        
//        if(status.equalsIgnoreCase("AVAILABLE")) {
//            this.remove(approve_btn);
//            this.remove(cancel_btn);
//        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        approve_btn = new javax.swing.JButton();
        cancel_btn = new javax.swing.JButton();
        reset_btn = new javax.swing.JButton();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(148, 31));
        setLayout(new java.awt.GridLayout(1, 3, 10, 0));

        approve_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/check_icon.png"))); // NOI18N
        approve_btn.setBorder(null);
        approve_btn.setBorderPainted(false);
        approve_btn.setContentAreaFilled(false);
        approve_btn.setFocusPainted(false);
        approve_btn.setFocusable(false);
        approve_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approve_btnActionPerformed(evt);
            }
        });
        add(approve_btn);

        cancel_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        cancel_btn.setBorder(null);
        cancel_btn.setBorderPainted(false);
        cancel_btn.setContentAreaFilled(false);
        cancel_btn.setFocusPainted(false);
        cancel_btn.setFocusable(false);
        add(cancel_btn);

        reset_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/reset.png"))); // NOI18N
        reset_btn.setBorder(null);
        reset_btn.setBorderPainted(false);
        reset_btn.setContentAreaFilled(false);
        reset_btn.setFocusPainted(false);
        reset_btn.setFocusable(false);
        reset_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_btnActionPerformed(evt);
            }
        });
        add(reset_btn);
    }// </editor-fold>//GEN-END:initComponents

    private void reset_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reset_btnActionPerformed

    private void approve_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approve_btnActionPerformed
        // TODO add your handling code here:
        
        System.out.println("Clicked");
        String selectQuery = "SELECT * from books WHERE book_id = ?";
        String updateQuery = "INSERT INTO borrowed_books (student_id, book_id, borrowed_at, due_date) VALUES (?,?,?,?)";
        String updateStatus = "UPDATE books SET status = ? WHERE book_id = ?";
        
        try {
            PreparedStatement ps = c.prepareStatement(selectQuery);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                ps.setString(1, student_id);
                ps.setInt(2, rs.getInt("book_id"));
                LocalDateTime borrowed_at = LocalDateTime.now();
                ps.setObject(3, borrowed_at);
                LocalDate due_date = borrowed_at.toLocalDate().plusDays(7);
                ps.setObject(4, due_date);
                ps.executeUpdate();
                
                PreparedStatement ps2 = c.prepareStatement(updateStatus);
                ps2.setString(1, "BORROWED");
                ps2.setInt(2, rs.getInt("book_id"));
                ps2.executeUpdate();
                
                System.out.println("APPROVED!");
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(Book_Actions.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }//GEN-LAST:event_approve_btnActionPerformed

    
    public JButton getApproveButton() {
        return approve_btn;
    }
    
    public JButton getCancelButton() {
        return cancel_btn;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton approve_btn;
    private javax.swing.JButton cancel_btn;
    private javax.swing.JButton reset_btn;
    // End of variables declaration//GEN-END:variables
}
