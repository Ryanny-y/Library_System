package pages.User;

import config.ConnDB;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import model.Book_Model;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Current_User;

public class Book_Description extends javax.swing.JFrame {

    Book_Model book;
    ConnDB con = ConnDB.getInstance();
    Connection c = con.getConnection();
    String student_id = Current_User.getCurrentUser().getStudent_id();
    
    
    public Book_Description(Book_Model book) {
        initComponents();
        setVisible(true);
        this.book = book;
        book_title.setText(book.getTitle());
        book_overview.setText("<html>" + book.getOverview() + "</html>");
        book_author.setText(book.getAuthor());
        book_released.setText(book.getYear_published() + "");
        book_img.setIcon(book.toIcon(book_img, book));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        borrow_btn = new javax.swing.JButton();
        favorite_btn = new javax.swing.JButton();
        lbl4 = new javax.swing.JLabel();
        book_released = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        lbl1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl1.setForeground(new java.awt.Color(51, 51, 51));
        lbl1.setText("Title");

        book_title.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        book_title.setText("Title Here");

        lbl2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl2.setForeground(new java.awt.Color(51, 51, 51));
        lbl2.setText("Author");

        book_author.setText("Author Here");

        lbl3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl3.setForeground(new java.awt.Color(51, 51, 51));
        lbl3.setText("Overview");

        book_overview.setText("Overview Here");

        jPanel1.setBackground(new java.awt.Color(255, 51, 204));
        jPanel1.setOpaque(false);

        book_img.setPreferredSize(new java.awt.Dimension(215, 260));

        borrow_btn.setBackground(new java.awt.Color(27, 76, 140));
        borrow_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        borrow_btn.setForeground(new java.awt.Color(255, 255, 255));
        borrow_btn.setText("Borrow Book");
        borrow_btn.setBorder(null);
        borrow_btn.setBorderPainted(false);
        borrow_btn.setFocusPainted(false);
        borrow_btn.setFocusable(false);
        borrow_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrow_btnActionPerformed(evt);
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
                .addComponent(borrow_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(borrow_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        lbl4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl4.setForeground(new java.awt.Color(51, 51, 51));
        lbl4.setText("Year published");

        book_released.setText("Overview Here");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        jButton1.setFocusable(false);

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
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
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
                        .addComponent(book_released)))
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
            .addComponent(shadowPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void borrow_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrow_btnActionPerformed
        // TODO add your handling code here:
        String query = "INSERT INTO borrowed_books (student_id, book_id, borrowed_at, due_date) VALUES (?,?,?,?)";
        String updateStatus = "UPDATE books SET status = ? WHERE book_id = ?";
        try {
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, student_id);
            ps.setInt(2, book.getBook_id());
            LocalDateTime borrowed_at = LocalDateTime.now();
            ps.setObject(3, borrowed_at);
            LocalDate due_date = borrowed_at.toLocalDate().plusDays(7);
            ps.setObject(4, due_date);
            ps.executeUpdate();
            
            PreparedStatement ps2 = c.prepareStatement(updateStatus);
            ps2.setString(1, "BORROWED");
            ps2.setInt(2, book.getBook_id());
            ps2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Borrowed books", "Borrowed!", JOptionPane.PLAIN_MESSAGE);
            con.reconnect();
            this.dispose();
            Book_Model.resetBookList();
            Home home = new Home();

            
        } catch (SQLException ex) {
            Logger.getLogger(Book_Description.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_borrow_btnActionPerformed

    private void favorite_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_favorite_btnActionPerformed
        // TODO add your handling code here:
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel book_author;
    private javax.swing.JLabel book_img;
    private javax.swing.JLabel book_overview;
    private javax.swing.JLabel book_released;
    private javax.swing.JLabel book_title;
    private javax.swing.JButton borrow_btn;
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
