package pages.User;

import java.awt.Color;
import java.time.LocalDate;
import java.util.ArrayList;
import model.Book_Model;
import components.BookContainer;
import config.ConnDB;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollBar;
import model.Book_Status;
import model.Current_User;
import model.User_Model;

public class Home extends javax.swing.JFrame {

    ArrayList<Book_Model> bookList = new ArrayList<>();
    
    public Home() {
        initComponents();
        setBackground(new Color(0,0,0,0));
        menu1.initMoving(this);
        setVisible(true);
        
        JScrollBar vScroll = jScrollPane1.getVerticalScrollBar();
        vScroll.setUnitIncrement(10);
        bookInit();
    }
    
    private void bookInit() {
        User_Model user = Current_User.getCurrentUser();
        System.out.println(user.getFirst_name());
        
        ConnDB con = ConnDB.getInstance();
        System.out.println(con);
        Connection c = con.getConnection();
        String query = "SELECT * FROM books";
        try {
            PreparedStatement ps = c.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                int book_id = rs.getInt("book_id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String overview = rs.getString("overview");
                int year_published = rs.getInt("year_published");
                String cover_img = rs.getString("cover_img");
                String statusDB = rs.getString("status");
                Book_Status status = Book_Status.valueOf(statusDB);
                Timestamp b_time = rs.getTimestamp("borrowed_at");
                LocalDateTime borrowed_at = b_time.toLocalDateTime();
                Timestamp c_time = rs.getTimestamp("created_at");
                LocalDateTime created_at = c_time.toLocalDateTime();
                
                Book_Model book = new Book_Model(book_id, title, author, overview, year_published, cover_img, status, borrowed_at, created_at);
                bookList.add(book);
                System.out.println(rs);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Book_Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        BookContainer bookContainer = new BookContainer(bookList);
        
        
        jScrollPane1.setViewportView(bookContainer);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new swing.PanelBorder();
        menu1 = new components.Menu();
        mainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userFrameHeader1 = new components.UserFrameHeader();

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
        jLabel1.setText("All Books");

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(menu1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userFrameHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(menu1, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(userFrameHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private components.Menu menu1;
    private swing.PanelBorder panelBorder1;
    private components.UserFrameHeader userFrameHeader1;
    // End of variables declaration//GEN-END:variables
}
