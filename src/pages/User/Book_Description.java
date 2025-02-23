package pages.User;

import config.ConnDB;
import java.awt.Color;
import javax.swing.JFrame;
import model.Book_Model;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Current_User;

public class Book_Description extends javax.swing.JFrame {

    Book_Model book;
    ConnDB con = ConnDB.getInstance();
    Connection c = con.getConnection();
    String student_id = Current_User.getCurrentUser().getStudent_id();
    private String bookStatus;
    private JFrame currentFrame;
    
    public Book_Description(Book_Model book, JFrame frame) {
        initComponents();
        setVisible(true);
        this.book = book;
        this.currentFrame = frame;
        System.out.println(frame.getClass().getSimpleName());
        book_title.setText(book.getTitle());
        book_overview.setText("<html>" + book.getOverview() + "</html>");
        book_author.setText(book.getAuthor());
        book_released.setText(book.getYear_published() + "");
        book_img.setIcon(book.toIcon(book_img, book));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        checkStatus();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        shadowPane1 = new swing.ShadowPane();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        lbl1 = new javax.swing.JLabel();
        book_title = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        book_author = new javax.swing.JLabel();
        lbl3 = new javax.swing.JLabel();
        book_overview = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        book_img = new javax.swing.JLabel();
        action_btn = new javax.swing.JButton();
        favorite_btn = new javax.swing.JButton();
        lbl4 = new javax.swing.JLabel();
        book_released = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        shadowPane1.setPreferredSize(new java.awt.Dimension(500, 500));

        lbl1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl1.setForeground(new java.awt.Color(255, 255, 255));
        lbl1.setText("Title");

        book_title.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        book_title.setForeground(new java.awt.Color(255, 255, 255));
        book_title.setText("Title Here");

        lbl2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl2.setForeground(new java.awt.Color(255, 255, 255));
        lbl2.setText("Author");

        book_author.setForeground(new java.awt.Color(255, 255, 255));
        book_author.setText("Author Here");

        lbl3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl3.setForeground(new java.awt.Color(255, 255, 255));
        lbl3.setText("Overview");

        book_overview.setForeground(new java.awt.Color(255, 255, 255));
        book_overview.setText("Overview Here");

        jPanel1.setBackground(new java.awt.Color(255, 51, 204));
        jPanel1.setOpaque(false);

        book_img.setPreferredSize(new java.awt.Dimension(215, 260));

        action_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        action_btn.setForeground(new java.awt.Color(27, 76, 140));
        action_btn.setText("Borrow Book");
        action_btn.setBorder(null);
        action_btn.setBorderPainted(false);
        action_btn.setFocusPainted(false);
        action_btn.setFocusable(false);
        action_btn.setOpaque(true);
        action_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                action_btnActionPerformed(evt);
            }
        });

        favorite_btn.setBackground(new java.awt.Color(204, 204, 0));
        favorite_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Favorites-Current.png"))); // NOI18N
        favorite_btn.setBorder(null);
        favorite_btn.setBorderPainted(false);
        favorite_btn.setFocusPainted(false);
        favorite_btn.setFocusable(false);
        favorite_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                favorite_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(action_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(favorite_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(book_img, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(book_img, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(favorite_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(action_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        lbl4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl4.setForeground(new java.awt.Color(255, 255, 255));
        lbl4.setText("Year published");

        book_released.setForeground(new java.awt.Color(255, 255, 255));
        book_released.setText("Year published");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close-white.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLayeredPane1.setLayer(lbl1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(book_title, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lbl2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(book_author, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lbl3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(book_overview, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lbl4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(book_released, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(book_title)
                            .addComponent(lbl2)
                            .addComponent(book_author)
                            .addComponent(lbl3)
                            .addComponent(book_overview)
                            .addComponent(lbl4)
                            .addComponent(book_released))
                        .addContainerGap(103, Short.MAX_VALUE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(lbl1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                .addComponent(lbl1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(book_title)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(book_author)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(book_overview)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(book_released))))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout shadowPane1Layout = new javax.swing.GroupLayout(shadowPane1);
        shadowPane1.setLayout(shadowPane1Layout);
        shadowPane1Layout.setHorizontalGroup(
            shadowPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );
        shadowPane1Layout.setVerticalGroup(
            shadowPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(shadowPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(shadowPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void checkStatus() {
        String status = book.getStatus().name();
        
        if(status.equals("AVAILABLE")) {
            action_btn.setText("Borrow Book");
            action_btn.setBackground(new Color(255,255,255));
            this.bookStatus = "available";
        } else {
            action_btn.setText("Return Book");
            action_btn.setBackground(new Color(0xD84040));
            this.bookStatus = "borrowed";
        }
    }
    
//    Check if added to favorites
    
    
    private void borrowBook() {
        String updateStatus = "UPDATE books SET status = ?, borrowed_by = ? WHERE book_id = ?";
        try {
            
            PreparedStatement ps2 = c.prepareStatement(updateStatus);
            ps2.setString(1, "REQUEST");
            ps2.setString(2, student_id);
            ps2.setInt(3, book.getBook_id());
            ps2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Borrow Request Sent!", "Borrow Request", JOptionPane.PLAIN_MESSAGE);
            con.reconnect();
            this.dispose();
            Book_Model.resetBookList();
            currentFrame.dispose();
            new Home();
            
        } catch (SQLException ex) {
            Logger.getLogger(Book_Description.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void returnBook() {
        String selectQuery = "SELECT borrowed_by FROM books WHERE book_id = ?";
        String updateQuery = "UPDATE borrowed_books SET returned_at = ? WHERE student_id = ? AND book_id = ? AND returned_at IS NULL";
        String statusQuery = "UPDATE books SET status = ? WHERE book_id = ?";
        
        String borrowed_by = null;
        try {
            PreparedStatement ps = c.prepareStatement(selectQuery);
            ps.setInt(1, book.getBook_id());
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                borrowed_by = rs.getString("borrowed_by");
            }
            
            PreparedStatement ps2 = c.prepareStatement(updateQuery);
            ps2.setObject(1, LocalDateTime.now());
            ps2.setString(2, borrowed_by);
            ps2.setInt(3, book.getBook_id());
            ps2.executeUpdate();
            
            PreparedStatement ps3 = c.prepareStatement(statusQuery);
            ps3.setString(1, "RETURNED");
            ps3.setInt(2, book.getBook_id());
            ps3.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Returned Successfully", "Book " + book.getTitle() + " was Returned!", JOptionPane.PLAIN_MESSAGE);
            currentFrame.dispose();
            Book_Model.resetBookList();
            this.dispose();
            new My_Books();
            
        } catch (SQLException ex) {
            Logger.getLogger(Book_Description.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void action_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_action_btnActionPerformed
        if(this.bookStatus.equalsIgnoreCase("available")) {
            borrowBook();
        } else if(this.bookStatus.equalsIgnoreCase("borrowed")) {
            returnBook();
        }

    }//GEN-LAST:event_action_btnActionPerformed

    private void favorite_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_favorite_btnActionPerformed
        // TODO add your handling code here:
        System.out.println("Add to f");
        String query = "INSERT INTO favorites_books (student_id, book_id) VALUES (?,?)";
        try {
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, student_id);
            ps.setInt(2, book.getBook_id());
            ps.executeUpdate();
            System.out.println("addded to favorties");
            
        } catch (SQLException ex) {
            Logger.getLogger(Book_Description.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_favorite_btnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton action_btn;
    private javax.swing.JLabel book_author;
    private javax.swing.JLabel book_img;
    private javax.swing.JLabel book_overview;
    private javax.swing.JLabel book_released;
    private javax.swing.JLabel book_title;
    private javax.swing.JButton favorite_btn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private swing.ShadowPane shadowPane1;
    // End of variables declaration//GEN-END:variables
}
