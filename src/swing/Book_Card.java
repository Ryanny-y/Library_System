package swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import model.Book_Model;
import pages.User.Book_Description;

public class Book_Card extends javax.swing.JPanel{
    
    private Book_Model book;

    public Book_Card(Book_Model book) {
        initComponents();
        this.book = book;
        setOpaque(false);
        lbl_img.setIcon(book.toIcon(lbl_img, book));
        lblTitle.setText("<html><div style='text-align:center;'>" + book.getTitle() + "</div></html>");
        lblAuthor.setText("Author: " + book.getAuthor());
        lblPublished.setText("Year Published: " + book.getYear_published());
        
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Window window = SwingUtilities.getWindowAncestor(e.getComponent()); 
                    if (window instanceof JFrame) {
                        new Book_Description(book, (JFrame) window);
                    }
                }
            
        });
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2.setColor(Color.WHITE);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);

        super.paintChildren(g);
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_img = new javax.swing.JLabel();
        lblAuthor = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblPublished = new javax.swing.JLabel();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(180, 210));

        lbl_img.setBackground(new java.awt.Color(153, 0, 0));
        lbl_img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_img.setPreferredSize(new java.awt.Dimension(93, 112));

        lblAuthor.setText("Author:");

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Title");

        lblPublished.setText("Year Published:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPublished, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_img, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_img, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAuthor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPublished, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblAuthor;
    private javax.swing.JLabel lblPublished;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lbl_img;
    // End of variables declaration//GEN-END:variables
}
