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

        panelBorder1 = new swing.PanelBorder();
        close_btn = new javax.swing.JButton();
        book_img = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        book_title = new javax.swing.JLabel();
        lblTitle1 = new javax.swing.JLabel();
        book_overview = new javax.swing.JLabel();
        lblTitle2 = new javax.swing.JLabel();
        book_author = new javax.swing.JLabel();
        lblTitle3 = new javax.swing.JLabel();
        book_released = new javax.swing.JLabel();
        borrow_btn = new javax.swing.JButton();
        favorite_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        close_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        close_btn.setBorder(null);
        close_btn.setBorderPainted(false);
        close_btn.setContentAreaFilled(false);
        close_btn.setFocusable(false);
        close_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                close_btnActionPerformed(evt);
            }
        });

        book_img.setBackground(new java.awt.Color(255, 0, 0));
        book_img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        book_img.setPreferredSize(new java.awt.Dimension(200, 270));

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(102, 102, 102));
        lblTitle.setText("Title");

        book_title.setText("Title here");

        lblTitle1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitle1.setForeground(new java.awt.Color(102, 102, 102));
        lblTitle1.setText("Author");

        book_overview.setText("sdadadadasdsadasdsadasda");

        lblTitle2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitle2.setForeground(new java.awt.Color(102, 102, 102));
        lblTitle2.setText("Overview");

        book_author.setText("Harry Potter");

        lblTitle3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitle3.setForeground(new java.awt.Color(102, 102, 102));
        lblTitle3.setText("Year Released");

        book_released.setText("2024");

        borrow_btn.setBackground(new java.awt.Color(27, 76, 140));
        borrow_btn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
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
        favorite_btn.setForeground(new java.awt.Color(255, 255, 255));
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

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(close_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(borrow_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(favorite_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                    .addComponent(book_img, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(book_title)
                    .addComponent(lblTitle)
                    .addComponent(lblTitle1)
                    .addComponent(lblTitle2)
                    .addComponent(book_author)
                    .addComponent(lblTitle3)
                    .addComponent(book_released)
                    .addComponent(book_overview, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(close_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(book_title)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTitle2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(book_overview)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(book_author)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTitle3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(book_released))
                    .addComponent(book_img, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(borrow_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(favorite_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void close_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_close_btnActionPerformed
        this.dispose();
    }//GEN-LAST:event_close_btnActionPerformed

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
    private javax.swing.JButton close_btn;
    private javax.swing.JButton favorite_btn;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JLabel lblTitle2;
    private javax.swing.JLabel lblTitle3;
    private swing.PanelBorder panelBorder1;
    // End of variables declaration//GEN-END:variables
}
