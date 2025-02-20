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
import javax.swing.JFileChooser;

public class Add_Book_Frame extends javax.swing.JFrame implements ActionListener{

    ConnDB con = ConnDB.getInstance();;
    Connection c = con.getConnection();
    
    public Add_Book_Frame() {
        initComponents();
        setBackground(new Color(0,0,0,0));
        setVisible(true);
        file_btn.addActionListener(this);
        close_btn.addActionListener(this);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new swing.PanelBorder();
        header = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        title_lbl = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        author_lbl = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        overview_lbl = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        year_published_lbl = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        file_btn = new javax.swing.JButton();
        close_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        header.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        header.setForeground(new java.awt.Color(27, 76, 140));
        header.setText("Add New Book");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Title");

        title_lbl.setBackground(new java.awt.Color(230, 230, 230));
        title_lbl.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        title_lbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                title_lblActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Author");

        author_lbl.setBackground(new java.awt.Color(230, 230, 230));
        author_lbl.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        author_lbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                author_lblActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Overview");

        jScrollPane1.setBorder(null);

        overview_lbl.setBackground(new java.awt.Color(230, 230, 230));
        overview_lbl.setColumns(20);
        overview_lbl.setRows(5);
        overview_lbl.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jScrollPane1.setViewportView(overview_lbl);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Year Published");

        year_published_lbl.setBackground(new java.awt.Color(230, 230, 230));
        year_published_lbl.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        year_published_lbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                year_published_lblActionPerformed(evt);
            }
        });

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
                .addGap(18, 18, 18)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4)
                        .addComponent(jLabel2)
                        .addComponent(author_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addComponent(title_lbl)
                        .addComponent(jScrollPane1))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(year_published_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(file_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                .addComponent(title_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(author_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(year_published_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void title_lblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_title_lblActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_title_lblActionPerformed

    private void author_lblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_author_lblActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_author_lblActionPerformed

    private void year_published_lblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_year_published_lblActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_year_published_lblActionPerformed

    private void getFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        
        if(result == JFileChooser.APPROVE_OPTION) {
            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            
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
            String query = "INSERT INTO (title, author, overview, year_published, cover_img) books VALUES (?,?,?,?,?)";
            
            getFile();
        }
        
        if(e.getSource() == close_btn) {
            this.dispose();
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
    private javax.swing.JTextField author_lbl;
    private javax.swing.JButton close_btn;
    private javax.swing.JButton file_btn;
    private javax.swing.JLabel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea overview_lbl;
    private swing.PanelBorder panelBorder1;
    private javax.swing.JTextField title_lbl;
    private javax.swing.JTextField year_published_lbl;
    // End of variables declaration//GEN-END:variables
}
