package pages.User;

import java.awt.Color;
import model.Book_Model;
import components.BookContainer;
import config.ConnDB;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollBar;
import model.User_Model;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql


import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import model.Current_User;
import pages.Notification;

public class Home extends javax.swing.JFrame {
    
    private ArrayList<Book_Model> favorites_list = new ArrayList<>();
    ConnDB con = ConnDB.getInstance();
    Connection c = con.getConnection();
    private static boolean calledNotif = false;
    
    public Home() {
        initComponents();
        setBackground(new Color(0,0,0,0));
        menu2.initMoving(this);
        setVisible(true);
        
        JScrollBar vScroll = jScrollPane1.getVerticalScrollBar();
        vScroll.setUnitIncrement(10);
        bookInit();
        renderNotification();
        User_Model.addPenalty();
    }
    
    private void renderNotification () {
        String query = "SELECT b.title, b.author, b.cover_img, b.year_published FROM books AS b INNER JOIN favorites_books AS fb ON b.book_id = fb.book_id WHERE fb.student_id = ?";
        
        try {
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, Current_User.getCurrentUser().getStudent_id());
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                String title = rs.getString("title");
                String author = rs.getString("author");
                String cover_img = rs.getString("cover_img");
                int year_published = rs.getInt("year_published");
                
                Book_Model model = new Book_Model(title, author, cover_img, year_published);
                
                favorites_list.add(model);
            }
            
            if(favorites_list.size() > 0 && (calledNotif == false)) {
                new Thread(() -> {
                    try {
                        // Sleep for 3 seconds (3000 milliseconds)
                        Thread.sleep(3000);

                        // Your original logic after the delay
                        if (favorites_list.size() > 0) {
                            new Notification(favorites_list);
                            calledNotif = true;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void bookInit() {
        String query = "SELECT * FROM books WHERE status = ?";
        Book_Model bookModel = new Book_Model();
        bookModel.getBooks(query, "AVAILABLE");

        updateBookList();
    }
    
    public void updateBookList() {
        if (!Book_Model.bookLists.isEmpty()) {
            BookContainer bookContainer = new BookContainer(Book_Model.bookLists);
            jScrollPane1.setViewportView(bookContainer);
            jScrollPane1.getViewport().addChangeListener(e -> {
                // Revalidate and repaint after the viewport changes (when scrolling)
                jScrollPane1.revalidate();
                jScrollPane1.repaint();
            });
        } else {
            Logger.getLogger(Book_Model.class.getName()).log(Level.WARNING, "No books retrieved from the database.");
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new swing.PanelBorder();
        mainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userFrameHeader1 = new components.UserFrameHeader(this);
        menu2 = new components.Menu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1080, 600));
        setResizable(false);

        panelBorder1.setPreferredSize(new Dimension(1080, 60));

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setOpaque(false);

        jLabel1.setBackground(new java.awt.Color(27, 76, 140));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(27, 76, 140));
        jLabel1.setText("Available Books");

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setOpaque(false);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 868, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
        );

        menu2.setMinimumSize(new java.awt.Dimension(230, 96));

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(menu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userFrameHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(userFrameHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(menu2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private components.Menu menu2;
    private swing.PanelBorder panelBorder1;
    private components.UserFrameHeader userFrameHeader1;
    // End of variables declaration//GEN-END:variables
}
