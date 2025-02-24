package pages;

import config.ConnDB;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import pages.Admin.Admin_Books;

public class Add_Book_Frame extends javax.swing.JFrame implements ActionListener{

    ConnDB con = ConnDB.getInstance();;
    Connection c = con.getConnection();
    
    Admin_Books frame;
    private String cover_img;
    
    public Add_Book_Frame() {
        initComponents();
        setBackground(new Color(0,0,0,0));
        setVisible(true);
        file_btn.addActionListener(this);
        close_btn.addActionListener(this);
        add_book_btn.addActionListener(this);
    }
    
    public Add_Book_Frame(Admin_Books frame) {
        initComponents();
        this.frame = frame;
        setBackground(new Color(0,0,0,0));
        setVisible(true);
        file_btn.addActionListener(this);
        close_btn.addActionListener(this);
        add_book_btn.addActionListener(this);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new swing.PanelBorder();
        header = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        title_field = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        author_field = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        overview_field = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        year_published_field = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        file_btn = new javax.swing.JButton();
        close_btn = new javax.swing.JButton();
        add_book_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        header.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        header.setForeground(new java.awt.Color(27, 76, 140));
        header.setText("Add New Book");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Title");

        title_field.setBackground(new java.awt.Color(230, 230, 230));
        title_field.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Author");

        author_field.setBackground(new java.awt.Color(230, 230, 230));
        author_field.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Overview");

        jScrollPane1.setBorder(null);

        overview_field.setBackground(new java.awt.Color(230, 230, 230));
        overview_field.setColumns(20);
        overview_field.setLineWrap(true);
        overview_field.setRows(5);
        overview_field.setWrapStyleWord(true);
        overview_field.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jScrollPane1.setViewportView(overview_field);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Year Published");

        year_published_field.setBackground(new java.awt.Color(230, 230, 230));
        year_published_field.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Choose Cover Image");

        file_btn.setBackground(new java.awt.Color(27, 76, 140));
        file_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        file_btn.setForeground(new java.awt.Color(255, 255, 255));
        file_btn.setText("Select a file");
        file_btn.setBorder(null);
        file_btn.setBorderPainted(false);
        file_btn.setFocusPainted(false);
        file_btn.setFocusable(false);

        close_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        close_btn.setBorder(null);
        close_btn.setBorderPainted(false);
        close_btn.setContentAreaFilled(false);
        close_btn.setFocusPainted(false);
        close_btn.setFocusable(false);
        close_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                close_btnActionPerformed(evt);
            }
        });

        add_book_btn.setBackground(new java.awt.Color(27, 76, 140));
        add_book_btn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        add_book_btn.setForeground(new java.awt.Color(255, 255, 255));
        add_book_btn.setText("Add Book");
        add_book_btn.setBorder(null);
        add_book_btn.setBorderPainted(false);
        add_book_btn.setFocusPainted(false);
        add_book_btn.setFocusable(false);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(header)
                .addGap(117, 117, 117)
                .addComponent(close_btn)
                .addGap(14, 14, 14))
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4)
                                .addComponent(jLabel2)
                                .addComponent(author_field, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addComponent(title_field)
                                .addComponent(jScrollPane1))
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(year_published_field, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(51, 51, 51)
                                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(file_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(add_book_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(header)
                    .addComponent(close_btn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(title_field, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(author_field, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(file_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(year_published_field, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(add_book_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void close_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_close_btnActionPerformed
        this.dispose();
    }//GEN-LAST:event_close_btnActionPerformed

    private void getFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        
        if(result == JFileChooser.APPROVE_OPTION) {
            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            cover_img = file.getName();
            
            JFileChooser folderChooser = new JFileChooser();
            folderChooser.setCurrentDirectory(new File(".\\src\\images\\Books"));
            folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int folderResult = folderChooser.showOpenDialog(null);
            
            if(folderResult == JFileChooser.APPROVE_OPTION) {
                File destinationFolder = folderChooser.getSelectedFile();
                
                File copyFile = new File(destinationFolder, file.getName());
                
                try {
                    copyFile(file, copyFile);
                } catch (Exception e) {
                    System.out.println("Copy failed!");
                }
            }
            
        }
    }
    
    private void copyFile(File file, File path) throws IOException {
            Path srcPath = file.toPath();
            Path destinationPath = path.toPath();

            Files.copy(srcPath, destinationPath, StandardCopyOption.REPLACE_EXISTING);

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == file_btn) {
            getFile();
        }
        
        if(e.getSource() == add_book_btn) {
            String query = "INSERT INTO books (title, author, overview, year_published, cover_img) VALUES (?,?,?,?,?)";

            try {
                PreparedStatement sp = c.prepareStatement(query);
                sp.setString(1, title_field.getText());
                sp.setString(2, author_field.getText());
                sp.setString(3, overview_field.getText());
                sp.setInt(4, Integer.parseInt(year_published_field.getText()));
                sp.setString(5, cover_img);
                sp.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Added Successfully", "New Book Added!", JOptionPane.PLAIN_MESSAGE);
                this.frame.dispose();
                new Admin_Books();
            } catch (SQLException ex) {
                Logger.getLogger(Add_Book_Frame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    
    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(new Color(0, 0, 0, 50)); // Semi-transparent shadow
        g2d.fillRoundRect(5, 5, getWidth() - 10, getHeight() - 10, 20, 20);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_book_btn;
    private javax.swing.JTextField author_field;
    private javax.swing.JButton close_btn;
    private javax.swing.JButton file_btn;
    private javax.swing.JLabel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea overview_field;
    private swing.PanelBorder panelBorder1;
    private javax.swing.JTextField title_field;
    private javax.swing.JTextField year_published_field;
    // End of variables declaration//GEN-END:variables
}
