package pages;

import java.awt.Color;
import java.time.LocalDate;
import java.util.ArrayList;
import model.Book_Model;
import components.BookContainer;
import java.awt.Dimension;
import javax.swing.JScrollBar;

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
        
        Book_Model book1 = new Book_Model(12, 2025, "Harry Potter", "Ryan Mabahin", "Harry_Potter", true, LocalDate.of(2024, 2, 9));
        Book_Model book2 = new Book_Model(12, 2025, "Harry Potter", "Ryan", "Harry_Potter", true, LocalDate.of(2024, 2, 9));
        Book_Model book3 = new Book_Model(12, 2025, "Harry Potter", "Ryan", "Harry_Potter", true, LocalDate.of(2024, 2, 9));
        Book_Model book4 = new Book_Model(12, 2025, "Harry Potter", "Ryan", "Harry_Potter", true, LocalDate.of(2024, 2, 9));
        Book_Model book5 = new Book_Model(12, 2025, "Harry Potter", "Ryan", "Harry_Potter", true, LocalDate.of(2024, 2, 9));
        Book_Model book6 = new Book_Model(12, 2025, "Harry Potter", "Ryan", "Harry_Potter", true, LocalDate.of(2024, 2, 9));
        Book_Model book7 = new Book_Model(12, 2025, "Harry Potter", "Ryan", "Harry_Potter", true, LocalDate.of(2024, 2, 9));
        Book_Model book8 = new Book_Model(12, 2025, "Harry Potter", "Ryan", "Harry_Potter", true, LocalDate.of(2024, 2, 9));
        Book_Model book9 = new Book_Model(12, 2025, "Harry Potter", "Ryan", "Harry_Potter", true, LocalDate.of(2024, 2, 9));
        Book_Model book10 = new Book_Model(12, 2025, "Harry Potter", "Ryan", "Harry_Potter", true, LocalDate.of(2024, 2, 9));
        Book_Model book11 = new Book_Model(12, 2025, "Harry Potter", "Ryan", "Harry_Potter", true, LocalDate.of(2024, 2, 9));
        Book_Model book12 = new Book_Model(12, 2025, "Harry Potter", "Ryan", "Harry_Potter", true, LocalDate.of(2024, 2, 9));
       
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);
        bookList.add(book5);
        bookList.add(book6);
        bookList.add(book7);
        bookList.add(book8);
        bookList.add(book9);
        bookList.add(book10);
        bookList.add(book11);
        
        BookContainer bookContainer = new BookContainer(bookList);
        
        
        jScrollPane1.setViewportView(bookContainer);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new swing.PanelBorder();
        menu1 = new components.Menu();
        frameHeader2 = new components.UserFrameHeader();
        mainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new Dimension(1080, 600));
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
        jScrollPane1.setOpaque(false);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(menu1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(frameHeader2, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                    .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(menu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(frameHeader2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private components.UserFrameHeader frameHeader2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private components.Menu menu1;
    private swing.PanelBorder panelBorder1;
    // End of variables declaration//GEN-END:variables
}
